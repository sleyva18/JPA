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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "curso_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoDet.findAll", query = "SELECT c FROM CursoDet c")
    , @NamedQuery(name = "CursoDet.findByCodcuredet", query = "SELECT c FROM CursoDet c WHERE c.codcuredet = :codcuredet")})
public class CursoDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCUREDET")
    private Integer codcuredet;
    @JoinColumn(name = "CODPROF", referencedColumnName = "CODPROF")
    @ManyToOne(optional = false)
    private Profesor codprof;
    @JoinColumn(name = "CODCUR", referencedColumnName = "CODCUR")
    @ManyToOne(optional = false)
    private Curso codcur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcuredet")
    private List<Clase> claseList;

    public CursoDet() {
    }

    public CursoDet(Integer codcuredet) {
        this.codcuredet = codcuredet;
    }

    public Integer getCodcuredet() {
        return codcuredet;
    }

    public void setCodcuredet(Integer codcuredet) {
        this.codcuredet = codcuredet;
    }

    public Profesor getCodprof() {
        return codprof;
    }

    public void setCodprof(Profesor codprof) {
        this.codprof = codprof;
    }

    public Curso getCodcur() {
        return codcur;
    }

    public void setCodcur(Curso codcur) {
        this.codcur = codcur;
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
        hash += (codcuredet != null ? codcuredet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoDet)) {
            return false;
        }
        CursoDet other = (CursoDet) object;
        if ((this.codcuredet == null && other.codcuredet != null) || (this.codcuredet != null && !this.codcuredet.equals(other.codcuredet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.CursoDet[ codcuredet=" + codcuredet + " ]";
    }
    
}
