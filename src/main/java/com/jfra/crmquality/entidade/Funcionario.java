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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author AbadaCapoeira
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    ,    @NamedQuery(name = "Funcionario.findAllName", query = "SELECT  f.idFuncionario ,f.nomeFuncionario, f.sobrenomeFuncionario, f.emailPessoal FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.funcionarioSemFoto", query = "SELECT f.idFuncionario, f.nomeFuncionario, f.sobrenomeFuncionario, f.rg, f.cpf, f.dataNascimento, f.emailEmpresa FROM Funcionario f")    
    , @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "Funcionario.findByNomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomeFuncionario = :nomeFuncionario")
    , @NamedQuery(name = "Funcionario.findBySobrenomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.sobrenomeFuncionario = :sobrenomeFuncionario")
    , @NamedQuery(name = "Funcionario.findByRg", query = "SELECT f FROM Funcionario f WHERE f.rg = :rg")
    , @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf")
    , @NamedQuery(name = "Funcionario.findByRamal", query = "SELECT f FROM Funcionario f WHERE f.ramal = :ramal")
    , @NamedQuery(name = "Funcionario.findByDataHoraCriacao", query = "SELECT f FROM Funcionario f WHERE f.dataHoraCriacao = :dataHoraCriacao")
    , @NamedQuery(name = "Funcionario.findByDataHoraEdicao", query = "SELECT f FROM Funcionario f WHERE f.dataHoraEdicao = :dataHoraEdicao")
    , @NamedQuery(name = "Funcionario.findBySexo", query = "SELECT f FROM Funcionario f WHERE f.sexo = :sexo")
    , @NamedQuery(name = "Funcionario.findByDataNascimento", query = "SELECT f FROM Funcionario f WHERE f.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Funcionario.findByEstadoCivil", query = "SELECT f FROM Funcionario f WHERE f.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "Funcionario.findByDataCasamento", query = "SELECT f FROM Funcionario f WHERE f.dataCasamento = :dataCasamento")
    , @NamedQuery(name = "Funcionario.findByDependentes", query = "SELECT f FROM Funcionario f WHERE f.dependentes = :dependentes")
    , @NamedQuery(name = "Funcionario.findByEmailEmpresa", query = "SELECT f FROM Funcionario f WHERE f.emailEmpresa = :emailEmpresa")
    , @NamedQuery(name = "Funcionario.findByEmailPessoal", query = "SELECT f FROM Funcionario f WHERE f.emailPessoal = :emailPessoal")
    , @NamedQuery(name = "Funcionario.findByGrauEscolar", query = "SELECT f FROM Funcionario f WHERE f.grauEscolar = :grauEscolar")
    , @NamedQuery(name = "Funcionario.findByPlanoSaudeInterno", query = "SELECT f FROM Funcionario f WHERE f.planoSaudeInterno = :planoSaudeInterno")
    , @NamedQuery(name = "Funcionario.findByDataAdmiss\u00e3o", query = "SELECT f FROM Funcionario f WHERE f.dataAdmiss\u00e3o = :dataAdmiss\u00e3o")
    , @NamedQuery(name = "Funcionario.findByDataDemissao", query = "SELECT f FROM Funcionario f WHERE f.dataDemissao = :dataDemissao")
    , @NamedQuery(name = "Funcionario.findBySalarioBruto", query = "SELECT f FROM Funcionario f WHERE f.salarioBruto = :salarioBruto")
    , @NamedQuery(name = "Funcionario.findByNumeroCarteiraTrabalho", query = "SELECT f FROM Funcionario f WHERE f.numeroCarteiraTrabalho = :numeroCarteiraTrabalho")
    , @NamedQuery(name = "Funcionario.findByUsuarioCriacao", query = "SELECT f FROM Funcionario f WHERE f.usuarioCriacao = :usuarioCriacao")
    , @NamedQuery(name = "Funcionario.findByUsuarioEdicao", query = "SELECT f FROM Funcionario f WHERE f.usuarioEdicao = :usuarioEdicao")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient UploadedFile file;
    
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private Integer idFuncionario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sobrenomeFuncionario")
    private String sobrenomeFuncionario;

    @Size(max = 45)
    @Column(name = "rg")
    private String rg;

    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "ramal")
    private Integer ramal;
    
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
    @Column(name = "sexo")
    private Character sexo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "estadoCivil")
    private Character estadoCivil;
    
    @Column(name = "dataCasamento")
    @Temporal(TemporalType.DATE)
    private Date dataCasamento;
    
    @Column(name = "dependentes")
    private Integer dependentes;
    
    @Size(max = 45)
    @Column(name = "emailEmpresa")
    private String emailEmpresa;
    
    @Size(max = 45)
    @Column(name = "emailPessoal")
    private String emailPessoal;
    
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    
    @Size(max = 45)
    @Column(name = "grauEscolar")
    private String grauEscolar;
    
    @Column(name = "planoSaudeInterno")
    private Integer planoSaudeInterno;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataAdmiss\u00e3o")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAdmissão;
    
    @Column(name = "dataDemissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDemissao;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salarioBruto")
    private Double salarioBruto;
    
    @Column(name = "numeroCarteiraTrabalho")
    private Integer numeroCarteiraTrabalho;
    
    @Column(name = "usuarioCriacao")
    private Integer usuarioCriacao;
    
    @Column(name = "usuarioEdicao")
    private Integer usuarioEdicao;
    
//    @OneToMany(mappedBy = "fkidFuncionario")
//    private List<Dependentes> dependentesList;
    
    @JoinColumn(name = "fk_idCargo", referencedColumnName = "idCargo")
    @ManyToOne
    private Cargo fkidCargo;
    
    @JoinColumn(name = "fk_idSetor", referencedColumnName = "idSetor")
    @ManyToOne(optional = false)
    private Setor fkidSetor;
    
    @Lob
    @Column(name = "rg_foto")
    private byte[] rg_foto;
    
    @Lob
    @Column(name = "cpf_foto")
    private byte[] cpf_foto;    

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(Integer idFuncionario, String nomeFuncionario, String sobrenomeFuncionario, Date dataHoraCriacao, Date dataHoraEdicao, Character sexo, Date dataNascimento, Date dataAdmissão) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenomeFuncionario = sobrenomeFuncionario;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraEdicao = dataHoraEdicao;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataAdmissão = dataAdmissão;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSobrenomeFuncionario() {
        return sobrenomeFuncionario;
    }

    public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
        this.sobrenomeFuncionario = sobrenomeFuncionario;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRamal() {
        return ramal;
    }

    public void setRamal(Integer ramal) {
        this.ramal = ramal;
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

    public Character getSexo() {
        return sexo;
    }
    

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getEstadoCivil() {
        return estadoCivil;
    }
    
    public String getEstadoCivilString(){
        
        String estado = "";
        Character s = this.estadoCivil;
        
        switch(s){
            case 'c':
                estado = "Casado(a)";
                break;
                
            case 's':
                estado = "Solteiro(a)";
                break;
                
            case 'v':
                estado = "Viuvo(a)";
                break;
                
        }
            
        
        return estado;
        
    }    

    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(Date dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getGrauEscolar() {
        return grauEscolar;
    }

    public void setGrauEscolar(String grauEscolar) {
        this.grauEscolar = grauEscolar;
    }

    public Integer getPlanoSaudeInterno() {
        return planoSaudeInterno;
    }

    public void setPlanoSaudeInterno(Integer planoSaudeInterno) {
        this.planoSaudeInterno = planoSaudeInterno;
    }

    public Date getDataAdmissão() {
        return dataAdmissão;
    }

    public void setDataAdmissão(Date dataAdmissão) {
        this.dataAdmissão = dataAdmissão;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Integer getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }

    public void setNumeroCarteiraTrabalho(Integer numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }

    public Integer getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(Integer usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public Integer getUsuarioEdicao() {
        return usuarioEdicao;
    }

    public void setUsuarioEdicao(Integer usuarioEdicao) {
        this.usuarioEdicao = usuarioEdicao;
    }

    public byte[] getRg_foto() {
        return rg_foto;
    }

    public void setRg_foto(byte[] rg_foto) {
        this.rg_foto = rg_foto;
    }

    public byte[] getCpf_foto() {
        return cpf_foto;
    }

    public void setCpf_foto(byte[] cpf_foto) {
        this.cpf_foto = cpf_foto;
    }
    
    
    

//    @XmlTransient
//    public List<Dependentes> getDependentesList() {
//        return dependentesList;
//    }
//
//    public void setDependentesList(List<Dependentes> dependentesList) {
//        this.dependentesList = dependentesList;
//    }

    public Cargo getFkidCargo() {
        return fkidCargo;
    }

    public void setFkidCargo(Cargo fkidCargo) {
        this.fkidCargo = fkidCargo;
    }

    public Setor getFkidSetor() {
        return fkidSetor;
    }

    public void setFkidSetor(Setor fkidSetor) {
        this.fkidSetor = fkidSetor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfra.crmquality.entidade.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }

    public Funcionario(Integer idFuncionario, String nomeFuncionario, String sobrenomeFuncionario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenomeFuncionario = sobrenomeFuncionario;
    }

    public Funcionario(Integer idFuncionario, String nomeFuncionario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
    }

    public Funcionario(Integer idFuncionario, String nomeFuncionario, String sobrenomeFuncionario, String rg, String cpf, Date dataNascimento, String emailEmpresa, Date dataAdmissão, Date dataDemissao) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenomeFuncionario = sobrenomeFuncionario;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.emailEmpresa = emailEmpresa;
        this.dataAdmissão = dataAdmissão;
        this.dataDemissao = dataDemissao;
    }
    
    

}
