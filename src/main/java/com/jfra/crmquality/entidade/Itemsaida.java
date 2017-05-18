/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AbadaCapoeira
 */
@Entity
@Table(name = "itemsaida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemsaida.findAll", query = "SELECT i FROM Itemsaida i")
    , @NamedQuery(name = "Itemsaida.findByIditemSaida", query = "SELECT i FROM Itemsaida i WHERE i.iditemSaida = :iditemSaida")
    , @NamedQuery(name = "Itemsaida.findByQuantidade", query = "SELECT i FROM Itemsaida i WHERE i.quantidade = :quantidade")})
public class Itemsaida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemSaida")
    private Integer iditemSaida;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "id_fk_Produto", referencedColumnName = "idproduto")
    @ManyToOne
    private Produto idfkProduto;
    @JoinColumn(name = "id_fk_saida", referencedColumnName = "idsaida")
    @ManyToOne
    private Saida idFkSaida;

    public Itemsaida() {
    }

    public Itemsaida(Integer iditemSaida) {
        this.iditemSaida = iditemSaida;
    }

    public Integer getIditemSaida() {
        return iditemSaida;
    }

    public void setIditemSaida(Integer iditemSaida) {
        this.iditemSaida = iditemSaida;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getIdfkProduto() {
        return idfkProduto;
    }

    public void setIdfkProduto(Produto idfkProduto) {
        this.idfkProduto = idfkProduto;
    }

    public Saida getIdFkSaida() {
        return idFkSaida;
    }

    public void setIdFkSaida(Saida idFkSaida) {
        this.idFkSaida = idFkSaida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditemSaida != null ? iditemSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemsaida)) {
            return false;
        }
        Itemsaida other = (Itemsaida) object;
        if ((this.iditemSaida == null && other.iditemSaida != null) || (this.iditemSaida != null && !this.iditemSaida.equals(other.iditemSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.com.Itemsaida[ iditemSaida=" + iditemSaida + " ]";
    }
    
}
