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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByCodprof", query = "SELECT p FROM Profesor p WHERE p.codprof = :codprof")
    , @NamedQuery(name = "Profesor.findByNomprof", query = "SELECT p FROM Profesor p WHERE p.nomprof = :nomprof")
    , @NamedQuery(name = "Profesor.findByApeprof", query = "SELECT p FROM Profesor p WHERE p.apeprof = :apeprof")
    , @NamedQuery(name = "Profesor.findByDniprof", query = "SELECT p FROM Profesor p WHERE p.dniprof = :dniprof")
    , @NamedQuery(name = "Profesor.findByDirprof", query = "SELECT p FROM Profesor p WHERE p.dirprof = :dirprof")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPROF")
    private Integer codprof;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMPROF")
    private String nomprof;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APEPROF")
    private String apeprof;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNIPROF")
    private String dniprof;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DIRPROF")
    private String dirprof;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprof")
    private List<CursoDet> cursoDetList;

    public Profesor() {
    }

    public Profesor(Integer codprof) {
        this.codprof = codprof;
    }

    public Profesor(Integer codprof, String nomprof, String apeprof, String dniprof, String dirprof) {
        this.codprof = codprof;
        this.nomprof = nomprof;
        this.apeprof = apeprof;
        this.dniprof = dniprof;
        this.dirprof = dirprof;
    }

    public Integer getCodprof() {
        return codprof;
    }

    public void setCodprof(Integer codprof) {
        this.codprof = codprof;
    }

    public String getNomprof() {
        return nomprof;
    }

    public void setNomprof(String nomprof) {
        this.nomprof = nomprof;
    }

    public String getApeprof() {
        return apeprof;
    }

    public void setApeprof(String apeprof) {
        this.apeprof = apeprof;
    }

    public String getDniprof() {
        return dniprof;
    }

    public void setDniprof(String dniprof) {
        this.dniprof = dniprof;
    }

    public String getDirprof() {
        return dirprof;
    }

    public void setDirprof(String dirprof) {
        this.dirprof = dirprof;
    }

    @XmlTransient
    public List<CursoDet> getCursoDetList() {
        return cursoDetList;
    }

    public void setCursoDetList(List<CursoDet> cursoDetList) {
        this.cursoDetList = cursoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprof != null ? codprof.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.codprof == null && other.codprof != null) || (this.codprof != null && !this.codprof.equals(other.codprof))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Profesor[ codprof=" + codprof + " ]";
    }
    
}
