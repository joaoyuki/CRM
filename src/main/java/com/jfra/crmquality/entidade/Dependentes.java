/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AbadaCapoeira
 */
@Entity
@Table(name = "dependentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependentes.findAll", query = "SELECT d FROM Dependentes d")
    , @NamedQuery(name = "Dependentes.findByIdDependentes", query = "SELECT d FROM Dependentes d WHERE d.idDependentes = :idDependentes")
    , @NamedQuery(name = "Dependentes.findByNomeDependente", query = "SELECT d FROM Dependentes d WHERE d.nomeDependente = :nomeDependente")
    , @NamedQuery(name = "Dependentes.findBySobrenomeDependente", query = "SELECT d FROM Dependentes d WHERE d.sobrenomeDependente = :sobrenomeDependente")
    , @NamedQuery(name = "Dependentes.findByIdadeDependente", query = "SELECT d FROM Dependentes d WHERE d.idadeDependente = :idadeDependente")
    , @NamedQuery(name = "Dependentes.findByRgDependente", query = "SELECT d FROM Dependentes d WHERE d.rgDependente = :rgDependente")
    , @NamedQuery(name = "Dependentes.findByCpfDependente", query = "SELECT d FROM Dependentes d WHERE d.cpfDependente = :cpfDependente")
    , @NamedQuery(name = "Dependentes.findByDataHoraCriacao", query = "SELECT d FROM Dependentes d WHERE d.dataHoraCriacao = :dataHoraCriacao")
    , @NamedQuery(name = "Dependentes.findByDataHoraEdicao", query = "SELECT d FROM Dependentes d WHERE d.dataHoraEdicao = :dataHoraEdicao")
    , @NamedQuery(name = "Dependentes.findByUsuarioCriacao", query = "SELECT d FROM Dependentes d WHERE d.usuarioCriacao = :usuarioCriacao")
    , @NamedQuery(name = "Dependentes.findByUsuarioEdicao", query = "SELECT d FROM Dependentes d WHERE d.usuarioEdicao = :usuarioEdicao")})
public class Dependentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDependentes")
    private Integer idDependentes;
    @Size(max = 45)
    @Column(name = "nomeDependente")
    private String nomeDependente;
    @Size(max = 45)
    @Column(name = "sobrenomeDependente")
    private String sobrenomeDependente;
    @Column(name = "idadeDependente")
    private Integer idadeDependente;
    @Column(name = "rgDependente")
    private Integer rgDependente;
    @Column(name = "cpfDependente")
    private Integer cpfDependente;
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
    @JoinColumn(name = "fk_idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne
    private Funcionario fkidFuncionario;

    public Dependentes() {
    }

    public Dependentes(Integer idDependentes) {
        this.idDependentes = idDependentes;
    }

    public Dependentes(Integer idDependentes, Date dataHoraCriacao, Date dataHoraEdicao, int usuarioCriacao, int usuarioEdicao) {
        this.idDependentes = idDependentes;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraEdicao = dataHoraEdicao;
        this.usuarioCriacao = usuarioCriacao;
        this.usuarioEdicao = usuarioEdicao;
    }

    public Integer getIdDependentes() {
        return idDependentes;
    }

    public void setIdDependentes(Integer idDependentes) {
        this.idDependentes = idDependentes;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    public String getSobrenomeDependente() {
        return sobrenomeDependente;
    }

    public void setSobrenomeDependente(String sobrenomeDependente) {
        this.sobrenomeDependente = sobrenomeDependente;
    }

    public Integer getIdadeDependente() {
        return idadeDependente;
    }

    public void setIdadeDependente(Integer idadeDependente) {
        this.idadeDependente = idadeDependente;
    }

    public Integer getRgDependente() {
        return rgDependente;
    }

    public void setRgDependente(Integer rgDependente) {
        this.rgDependente = rgDependente;
    }

    public Integer getCpfDependente() {
        return cpfDependente;
    }

    public void setCpfDependente(Integer cpfDependente) {
        this.cpfDependente = cpfDependente;
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

    public Funcionario getFkidFuncionario() {
        return fkidFuncionario;
    }

    public void setFkidFuncionario(Funcionario fkidFuncionario) {
        this.fkidFuncionario = fkidFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDependentes != null ? idDependentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependentes)) {
            return false;
        }
        Dependentes other = (Dependentes) object;
        if ((this.idDependentes == null && other.idDependentes != null) || (this.idDependentes != null && !this.idDependentes.equals(other.idDependentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfra.crmquality.entidade.Dependentes[ idDependentes=" + idDependentes + " ]";
    }
    
}
