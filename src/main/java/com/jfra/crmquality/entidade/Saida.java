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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "saida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saida.findAll", query = "SELECT s FROM Saida s")
    , @NamedQuery(name = "Saida.findByIdsaida", query = "SELECT s FROM Saida s WHERE s.idsaida = :idsaida")
    , @NamedQuery(name = "Saida.findByTotalSaida", query = "SELECT s FROM Saida s WHERE s.totalSaida = :totalSaida")
    , @NamedQuery(name = "Saida.findByIdSetor", query = "SELECT s FROM Saida s WHERE s.idSetor = :idSetor")
    , @NamedQuery(name = "Saida.findByQuantidade", query = "SELECT s FROM Saida s WHERE s.quantidade = :quantidade")
    , @NamedQuery(name = "Saida.findBySaidacol", query = "SELECT s FROM Saida s WHERE s.saidacol = :saidacol")
    , @NamedQuery(name = "Saida.findByIdSetor1", query = "SELECT s FROM Saida s WHERE s.idSetor1 = :idSetor1")})
public class Saida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsaida")
    private Integer idsaida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalSaida")
    private Double totalSaida;
    @Column(name = "idSetor")
    private Integer idSetor;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Size(max = 45)
    @Column(name = "saidacol")
    private String saidacol;
    @Column(name = "id_setor")
    private Integer idSetor1;
    @OneToMany(mappedBy = "idFkSaida")
    private List<Itemsaida> itemsaidaList;
    @JoinColumn(name = "id_setorSaida", referencedColumnName = "idSetor")
    @ManyToOne
    private Setor idsetorSaida;

    public Saida() {
    }

    public Saida(Integer idsaida) {
        this.idsaida = idsaida;
    }

    public Integer getIdsaida() {
        return idsaida;
    }

    public void setIdsaida(Integer idsaida) {
        this.idsaida = idsaida;
    }

    public Double getTotalSaida() {
        return totalSaida;
    }

    public void setTotalSaida(Double totalSaida) {
        this.totalSaida = totalSaida;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getSaidacol() {
        return saidacol;
    }

    public void setSaidacol(String saidacol) {
        this.saidacol = saidacol;
    }

    public Integer getIdSetor1() {
        return idSetor1;
    }

    public void setIdSetor1(Integer idSetor1) {
        this.idSetor1 = idSetor1;
    }

    @XmlTransient
    public List<Itemsaida> getItemsaidaList() {
        return itemsaidaList;
    }

    public void setItemsaidaList(List<Itemsaida> itemsaidaList) {
        this.itemsaidaList = itemsaidaList;
    }

    public Setor getIdsetorSaida() {
        return idsetorSaida;
    }

    public void setIdsetorSaida(Setor idsetorSaida) {
        this.idsetorSaida = idsetorSaida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsaida != null ? idsaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.idsaida == null && other.idsaida != null) || (this.idsaida != null && !this.idsaida.equals(other.idsaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.com.Saida[ idsaida=" + idsaida + " ]";
    }
    
}
