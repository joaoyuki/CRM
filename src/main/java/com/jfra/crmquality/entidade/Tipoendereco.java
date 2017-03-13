/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AbadaCapoeira
 */
@Entity
@Table(name = "tipoendereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoendereco.findAll", query = "SELECT t FROM Tipoendereco t")
    , @NamedQuery(name = "Tipoendereco.findByIdTipoEndereco", query = "SELECT t FROM Tipoendereco t WHERE t.idTipoEndereco = :idTipoEndereco")
    , @NamedQuery(name = "Tipoendereco.findByDescricaoTipoEndereco", query = "SELECT t FROM Tipoendereco t WHERE t.descricaoTipoEndereco = :descricaoTipoEndereco")})
public class Tipoendereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoEndereco")
    private Integer idTipoEndereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoTipoEndereco")
    private String descricaoTipoEndereco;
    @OneToMany(mappedBy = "fktipoEndereco")
    private List<Endereco> enderecoList;

    public Tipoendereco() {
    }

    public Tipoendereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public Tipoendereco(Integer idTipoEndereco, String descricaoTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
        this.descricaoTipoEndereco = descricaoTipoEndereco;
    }

    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getDescricaoTipoEndereco() {
        return descricaoTipoEndereco;
    }

    public void setDescricaoTipoEndereco(String descricaoTipoEndereco) {
        this.descricaoTipoEndereco = descricaoTipoEndereco;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEndereco != null ? idTipoEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoendereco)) {
            return false;
        }
        Tipoendereco other = (Tipoendereco) object;
        if ((this.idTipoEndereco == null && other.idTipoEndereco != null) || (this.idTipoEndereco != null && !this.idTipoEndereco.equals(other.idTipoEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfra.crmquality.entidade.Tipoendereco[ idTipoEndereco=" + idTipoEndereco + " ]";
    }
    
}
