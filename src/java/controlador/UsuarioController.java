package controlador;

import java.io.IOException;
import modelo.entidad.Usuario;
import modelo.dao.UsuarioFacade;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private modelo.dao.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected = new Usuario();
    private String usuario, contra;

    public String validar() throws Exception {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario u = ejbFacade.validarUsuario(selected);
        if (u != null) {
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
            contex.getExternalContext().redirect("faces/index.xhtml");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido" + u.getUsuusu()));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("usuario o contraseña incorrecta"));
        }
        contex.addMessage(null, new FacesMessage("error"));
        return null;
    }

    public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext contex = FacesContext.getCurrentInstance();
        contex.getExternalContext().redirect("/JPA");
    }

    public static boolean _isLogin() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us != null;
    }
    
    public void validarSesion() throws Exception {
        if (!_isLogin()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JPA" );
        }
    }

    public void validarLogin() throws Exception {
        if (_isLogin()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JPA/index.xhtml");
        }
    }
    
    public UsuarioFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(UsuarioFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Usuario> getItems() {
        return items;
    }

    public void setItems(List<Usuario> items) {
        this.items = items;
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

}
