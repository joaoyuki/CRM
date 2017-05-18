/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tipoproduto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoproduto.findAll", query = "SELECT t FROM Tipoproduto t")
    , @NamedQuery(name = "Tipoproduto.findByIdtipoProduto", query = "SELECT t FROM Tipoproduto t WHERE t.idtipoProduto = :idtipoProduto")
    , @NamedQuery(name = "Tipoproduto.findByNome", query = "SELECT t FROM Tipoproduto t WHERE t.nome = :nome")})
public class Tipoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoProduto")
    private Integer idtipoProduto;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidTipo")
    private List<Produto> produtoList;

    public Tipoproduto() {
    }

    public Tipoproduto(Integer idtipoProduto) {
        this.idtipoProduto = idtipoProduto;
    }

    public Integer getIdtipoProduto() {
        return idtipoProduto;
    }

    public void setIdtipoProduto(Integer idtipoProduto) {
        this.idtipoProduto = idtipoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoProduto != null ? idtipoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoproduto)) {
            return false;
        }
        Tipoproduto other = (Tipoproduto) object;
        if ((this.idtipoProduto == null && other.idtipoProduto != null) || (this.idtipoProduto != null && !this.idtipoProduto.equals(other.idtipoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.com.Tipoproduto[ idtipoProduto=" + idtipoProduto + " ]";
    }
    
}
