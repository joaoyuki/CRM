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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "setor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s")
    , @NamedQuery(name = "Setor.findByIdSetor", query = "SELECT s FROM Setor s WHERE s.idSetor = :idSetor")
    , @NamedQuery(name = "Setor.findByDescricaoSetor", query = "SELECT s FROM Setor s WHERE s.descricaoSetor = :descricaoSetor")
    , @NamedQuery(name = "Setor.findByDataHoraCriacao", query = "SELECT s FROM Setor s WHERE s.dataHoraCriacao = :dataHoraCriacao")
    , @NamedQuery(name = "Setor.findByDataHoraEdicao", query = "SELECT s FROM Setor s WHERE s.dataHoraEdicao = :dataHoraEdicao")
    , @NamedQuery(name = "Setor.findByUsuarioCriacao", query = "SELECT s FROM Setor s WHERE s.usuarioCriacao = :usuarioCriacao")
    , @NamedQuery(name = "Setor.findByUsuarioEdicao", query = "SELECT s FROM Setor s WHERE s.usuarioEdicao = :usuarioEdicao")})
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSetor")
    private Integer idSetor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoSetor")
    private String descricaoSetor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataHoraCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCriacao;
    @Basic(optional = false)
    @NotNull
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidSetor")
    private List<Funcionario> funcionarioList;

    public Setor() {
    }

    public Setor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Setor(Integer idSetor, String descricaoSetor, Date dataHoraCriacao, Date dataHoraEdicao, int usuarioCriacao, int usuarioEdicao) {
        this.idSetor = idSetor;
        this.descricaoSetor = descricaoSetor;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraEdicao = dataHoraEdicao;
        this.usuarioCriacao = usuarioCriacao;
        this.usuarioEdicao = usuarioEdicao;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getDescricaoSetor() {
        return descricaoSetor;
    }

    public void setDescricaoSetor(String descricaoSetor) {
        this.descricaoSetor = descricaoSetor;
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

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSetor != null ? idSetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.idSetor == null && other.idSetor != null) || (this.idSetor != null && !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricaoSetor;
    }
    
}
