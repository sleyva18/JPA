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
    private Usuario selected;
    private String usuario, contra;

    public String validar() throws Exception {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario u = ejbFacade.validarUsuario(usuario, contra);
        if (u != null) {
            contex.getExternalContext().redirect("faces/index.xhtml");
            contex.addMessage(null, new FacesMessage("Bienvenido" + u.getUsuusu()));
            this.setContra("");
            this.setUsuario("");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("usuario o contraseña incorrecta"));
            return "login";
        }
        contex.addMessage(null, new FacesMessage("error"));
        return null;
    }

    public void cerrarSesion() throws IOException {
        FacesContext contex = FacesContext.getCurrentInstance();
        contex.getExternalContext().redirect("faces/login.xhtml");
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
