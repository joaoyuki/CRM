/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AbadaCapoeira
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto")
    , @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto")
    , @NamedQuery(name = "Produto.findByLote", query = "SELECT p FROM Produto p WHERE p.lote = :lote")
    , @NamedQuery(name = "Produto.findByDataValidade", query = "SELECT p FROM Produto p WHERE p.dataValidade = :dataValidade")
    , @NamedQuery(name = "Produto.findByDataEnrtada", query = "SELECT p FROM Produto p WHERE p.dataEnrtada = :dataEnrtada")
    , @NamedQuery(name = "Produto.findByNumeroNota", query = "SELECT p FROM Produto p WHERE p.numeroNota = :numeroNota")
    , @NamedQuery(name = "Produto.findByDataHoraCriacao", query = "SELECT p FROM Produto p WHERE p.dataHoraCriacao = :dataHoraCriacao")
    , @NamedQuery(name = "Produto.findByDataHoraEdicao", query = "SELECT p FROM Produto p WHERE p.dataHoraEdicao = :dataHoraEdicao")
    , @NamedQuery(name = "Produto.findByUsuarioCriacao", query = "SELECT p FROM Produto p WHERE p.usuarioCriacao = :usuarioCriacao")
    , @NamedQuery(name = "Produto.findByUsuarioEdicao", query = "SELECT p FROM Produto p WHERE p.usuarioEdicao = :usuarioEdicao")
    , @NamedQuery(name = "Produto.findByProdutoControlado", query = "SELECT p FROM Produto p WHERE p.produtoControlado = :produtoControlado")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduto")
    private Integer idproduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeProduto")
    private String nomeProduto;
    @Column(name = "lote")
    private Integer lote;
    @Column(name = "dataValidade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @Column(name = "dataEnrtada")
    @Temporal(TemporalType.DATE)
    private Date dataEnrtada;
    @Column(name = "numeroNota")
    private Integer numeroNota;
    @Column(name = "dataHoraCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCriacao;
    @Column(name = "dataHoraEdicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEdicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioCriacao")
    private int usuarioCriacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioEdicao")
    private int usuarioEdicao;
    @Lob
    @Column(name = "fotoProduto")
    private byte[] fotoProduto;
    @Column(name = "produtoControlado")
    private Short produtoControlado;
    @OneToMany(mappedBy = "idfkProduto")
    private List<Itemsaida> itemsaidaList;
    @JoinColumn(name = "fk_idFornecedor", referencedColumnName = "idfornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fkidFornecedor;
    @JoinColumn(name = "fk_idMarca", referencedColumnName = "idmarca")
    @ManyToOne(optional = false)
    private Marca fkidMarca;
    @JoinColumn(name = "fk_idTipo", referencedColumnName = "idtipoProduto")
    @ManyToOne(optional = false)
    private Tipoproduto fkidTipo;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Produto(Integer idproduto, String nomeProduto, int usuarioCriacao, int usuarioEdicao) {
        this.idproduto = idproduto;
        this.nomeProduto = nomeProduto;
        this.usuarioCriacao = usuarioCriacao;
        this.usuarioEdicao = usuarioEdicao;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataEnrtada() {
        return dataEnrtada;
    }

    public void setDataEnrtada(Date dataEnrtada) {
        this.dataEnrtada = dataEnrtada;
    }

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Date getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(Date dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public Date getDataHoraEdicao() {
        return dataHoraEdicao;
    }

    public void setDataHoraEdicao(Date dataHoraEdicao) {
        this.dataHoraEdicao = dataHoraEdicao;
    }

    public int getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(int usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public int getUsuarioEdicao() {
        return usuarioEdicao;
    }

    public void setUsuarioEdicao(int usuarioEdicao) {
        this.usuarioEdicao = usuarioEdicao;
    }

    public byte[] getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(byte[] fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public Short getProdutoControlado() {
        return produtoControlado;
    }

    public void setProdutoControlado(Short produtoControlado) {
        this.produtoControlado = produtoControlado;
    }

    @XmlTransient
    public List<Itemsaida> getItemsaidaList() {
        return itemsaidaList;
    }

    public void setItemsaidaList(List<Itemsaida> itemsaidaList) {
        this.itemsaidaList = itemsaidaList;
    }

    public Fornecedor getFkidFornecedor() {
        return fkidFornecedor;
    }

    public void setFkidFornecedor(Fornecedor fkidFornecedor) {
        this.fkidFornecedor = fkidFornecedor;
    }

    public Marca getFkidMarca() {
        return fkidMarca;
    }

    public void setFkidMarca(Marca fkidMarca) {
        this.fkidMarca = fkidMarca;
    }

    public Tipoproduto getFkidTipo() {
        return fkidTipo;
    }

    public void setFkidTipo(Tipoproduto fkidTipo) {
        this.fkidTipo = fkidTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.com.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
