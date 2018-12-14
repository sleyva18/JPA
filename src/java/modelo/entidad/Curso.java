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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByCodcur", query = "SELECT c FROM Curso c WHERE c.codcur = :codcur")
    , @NamedQuery(name = "Curso.findByNomcur", query = "SELECT c FROM Curso c WHERE c.nomcur = :nomcur")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCUR")
    private Integer codcur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMCUR")
    private String nomcur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcur")
    private List<CursoDet> cursoDetList;

    public Curso() {
    }

    public Curso(Integer codcur) {
        this.codcur = codcur;
    }

    public Curso(Integer codcur, String nomcur) {
        this.codcur = codcur;
        this.nomcur = nomcur;
    }

    public Integer getCodcur() {
        return codcur;
    }

    public void setCodcur(Integer codcur) {
        this.codcur = codcur;
    }

    public String getNomcur() {
        return nomcur;
    }

    public void setNomcur(String nomcur) {
        this.nomcur = nomcur;
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
        hash += (codcur != null ? codcur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codcur == null && other.codcur != null) || (this.codcur != null && !this.codcur.equals(other.codcur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Curso[ codcur=" + codcur + " ]";
    }
    
}
