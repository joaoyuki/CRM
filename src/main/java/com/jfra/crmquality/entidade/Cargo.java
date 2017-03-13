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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo")
    , @NamedQuery(name = "Cargo.findByNomeCargo", query = "SELECT c FROM Cargo c WHERE c.nomeCargo = :nomeCargo")
    , @NamedQuery(name = "Cargo.findByDescricaoCargo", query = "SELECT c FROM Cargo c WHERE c.descricaoCargo = :descricaoCargo")
    , @NamedQuery(name = "Cargo.findByDataHoraCriacao", query = "SELECT c FROM Cargo c WHERE c.dataHoraCriacao = :dataHoraCriacao")
    , @NamedQuery(name = "Cargo.findByDataHoraEdicao", query = "SELECT c FROM Cargo c WHERE c.dataHoraEdicao = :dataHoraEdicao")
    , @NamedQuery(name = "Cargo.findByUsuarioCriacao", query = "SELECT c FROM Cargo c WHERE c.usuarioCriacao = :usuarioCriacao")
    , @NamedQuery(name = "Cargo.findByUsuarioEdicao", query = "SELECT c FROM Cargo c WHERE c.usuarioEdicao = :usuarioEdicao")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCargo")
    private Integer idCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeCargo")
    private String nomeCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoCargo")
    private String descricaoCargo;
    @Basic(optional = false)
    @NotNull
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
    @OneToMany(mappedBy = "fkidCargo")
    private List<Funcionario> funcionarioList;

    public Cargo() {
    }

    public Cargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Cargo(Integer idCargo, String nomeCargo, String descricaoCargo, Date dataHoraCriacao, int usuarioCriacao, int usuarioEdicao) {
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
        this.descricaoCargo = descricaoCargo;
        this.dataHoraCriacao = dataHoraCriacao;
        this.usuarioCriacao = usuarioCriacao;
        this.usuarioEdicao = usuarioEdicao;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
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
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeCargo;
    }
    
}
