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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joaoassis
 */
@Entity
@Table(name = "HISTORICO_LOGIN_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoLoginUsuario.findAll", query = "SELECT h FROM HistoricoLoginUsuario h")
    , @NamedQuery(name = "HistoricoLoginUsuario.findByIdUsuario", query = "SELECT h FROM HistoricoLoginUsuario h WHERE h.idUsuario = :idUsuario")
    , @NamedQuery(name = "HistoricoLoginUsuario.findByDataHoraLogin", query = "SELECT h FROM HistoricoLoginUsuario h WHERE h.dataHoraLogin = :dataHoraLogin")
    , @NamedQuery(name = "HistoricoLoginUsuario.findByIdHistorico", query = "SELECT h FROM HistoricoLoginUsuario h WHERE h.idHistorico = :idHistorico")})
public class HistoricoLoginUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private long idUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataHoraLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraLogin;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHistorico")
    private Long idHistorico;

    public HistoricoLoginUsuario() {
    }

    public HistoricoLoginUsuario(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    public HistoricoLoginUsuario(Long idHistorico, long idUsuario, Date dataHoraLogin) {
        this.idHistorico = idHistorico;
        this.idUsuario = idUsuario;
        this.dataHoraLogin = dataHoraLogin;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataHoraLogin() {
        return dataHoraLogin;
    }

    public void setDataHoraLogin(Date dataHoraLogin) {
        this.dataHoraLogin = dataHoraLogin;
    }

    public Long getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorico != null ? idHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoLoginUsuario)) {
            return false;
        }
        HistoricoLoginUsuario other = (HistoricoLoginUsuario) object;
        if ((this.idHistorico == null && other.idHistorico != null) || (this.idHistorico != null && !this.idHistorico.equals(other.idHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfra.crmquality.entidade.HistoricoLoginUsuario[ idHistorico=" + idHistorico + " ]";
    }
    
}
