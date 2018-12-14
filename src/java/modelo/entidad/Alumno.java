/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

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
 * @author Administrador
 */
@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByCodper", query = "SELECT a FROM Alumno a WHERE a.codper = :codper")
    , @NamedQuery(name = "Alumno.findByNomper", query = "SELECT a FROM Alumno a WHERE a.nomper = :nomper")
    , @NamedQuery(name = "Alumno.findByApeper", query = "SELECT a FROM Alumno a WHERE a.apeper = :apeper")
    , @NamedQuery(name = "Alumno.findByDniper", query = "SELECT a FROM Alumno a WHERE a.dniper = :dniper")
    , @NamedQuery(name = "Alumno.findByDirper", query = "SELECT a FROM Alumno a WHERE a.dirper = :dirper")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPER")
    private Integer codper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMPER")
    private String nomper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APEPER")
    private String apeper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNIPER")
    private String dniper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DIRPER")
    private String dirper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codperAlu")
    private List<Clase> claseList;

    public Alumno() {
    }

    public Alumno(Integer codper) {
        this.codper = codper;
    }

    public Alumno(Integer codper, String nomper, String apeper, String dniper, String dirper) {
        this.codper = codper;
        this.nomper = nomper;
        this.apeper = apeper;
        this.dniper = dniper;
        this.dirper = dirper;
    }

    public Integer getCodper() {
        return codper;
    }

    public void setCodper(Integer codper) {
        this.codper = codper;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getApeper() {
        return apeper;
    }

    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    public String getDniper() {
        return dniper;
    }

    public void setDniper(String dniper) {
        this.dniper = dniper;
    }

    public String getDirper() {
        return dirper;
    }

    public void setDirper(String dirper) {
        this.dirper = dirper;
    }

    @XmlTransient
    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codper != null ? codper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codper == null && other.codper != null) || (this.codper != null && !this.codper.equals(other.codper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Alumno[ codper=" + codper + " ]";
    }
    
}
