/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCodusu", query = "SELECT u FROM Usuario u WHERE u.codusu = :codusu")
    , @NamedQuery(name = "Usuario.findByUsuusu", query = "SELECT u FROM Usuario u WHERE u.usuusu = :usuusu")
    , @NamedQuery(name = "Usuario.findByPasusu", query = "SELECT u FROM Usuario u WHERE u.pasusu = :pasusu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODUSU")
    private Integer codusu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUUSU")
    private String usuusu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASUSU")
    private String pasusu;

    public Usuario() {
    }

    public Usuario(Integer codusu) {
        this.codusu = codusu;
    }

    public Usuario(Integer codusu, String usuusu, String pasusu) {
        this.codusu = codusu;
        this.usuusu = usuusu;
        this.pasusu = pasusu;
    }

    public Integer getCodusu() {
        return codusu;
    }

    public void setCodusu(Integer codusu) {
        this.codusu = codusu;
    }

    public String getUsuusu() {
        return usuusu;
    }

    public void setUsuusu(String usuusu) {
        this.usuusu = usuusu;
    }

    public String getPasusu() {
        return pasusu;
    }

    public void setPasusu(String pasusu) {
        this.pasusu = pasusu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusu != null ? codusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codusu == null && other.codusu != null) || (this.codusu != null && !this.codusu.equals(other.codusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Usuario[ codusu=" + codusu + " ]";
    }
    
}
