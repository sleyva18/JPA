/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Administrador
 */
@Entity
@Table(name = "clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c")
    , @NamedQuery(name = "Clase.findByCodclas", query = "SELECT c FROM Clase c WHERE c.codclas = :codclas")
    , @NamedQuery(name = "Clase.findByNotaclas", query = "SELECT c FROM Clase c WHERE c.notaclas = :notaclas")
    , @NamedQuery(name = "Clase.findByFechclas", query = "SELECT c FROM Clase c WHERE c.fechclas = :fechclas")
    , @NamedQuery(name = "Clase.findByAsisclas", query = "SELECT c FROM Clase c WHERE c.asisclas = :asisclas")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCLAS")
    private Integer codclas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "NOTACLAS")
    private String notaclas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHCLAS")
    @Temporal(TemporalType.DATE)
    private Date fechclas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASISCLAS")
    private Character asisclas;
    @JoinColumn(name = "CODCUREDET", referencedColumnName = "CODCUREDET")
    @ManyToOne(optional = false)
    private CursoDet codcuredet;
    @JoinColumn(name = "CODPER_ALU", referencedColumnName = "CODPER")
    @ManyToOne(optional = false)
    private Alumno codperAlu;

    public Clase() {
    }

    public Clase(Integer codclas) {
        this.codclas = codclas;
    }

    public Clase(Integer codclas, String notaclas, Date fechclas, Character asisclas) {
        this.codclas = codclas;
        this.notaclas = notaclas;
        this.fechclas = fechclas;
        this.asisclas = asisclas;
    }

    public Integer getCodclas() {
        return codclas;
    }

    public void setCodclas(Integer codclas) {
        this.codclas = codclas;
    }

    public String getNotaclas() {
        return notaclas;
    }

    public void setNotaclas(String notaclas) {
        this.notaclas = notaclas;
    }

    public Date getFechclas() {
        return fechclas;
    }

    public void setFechclas(Date fechclas) {
        this.fechclas = fechclas;
    }

    public Character getAsisclas() {
        return asisclas;
    }

    public void setAsisclas(Character asisclas) {
        this.asisclas = asisclas;
    }

    public CursoDet getCodcuredet() {
        return codcuredet;
    }

    public void setCodcuredet(CursoDet codcuredet) {
        this.codcuredet = codcuredet;
    }

    public Alumno getCodperAlu() {
        return codperAlu;
    }

    public void setCodperAlu(Alumno codperAlu) {
        this.codperAlu = codperAlu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclas != null ? codclas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.codclas == null && other.codclas != null) || (this.codclas != null && !this.codclas.equals(other.codclas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Clase[ codclas=" + codclas + " ]";
    }
    
}
