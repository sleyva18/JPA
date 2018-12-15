package modelo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entidad.Usuario;

/**
 *
 * @author Administrador
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "PoolNotasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario validarUsuario(Usuario usuario) {
        Usuario user = null;
        String jpql = "SELECT u FROM Usuario u WHERE "
                + "u.usuusu = :usuusu and u.pasusu = :pasusu";
        Query p = em.createQuery(jpql);
        p.setParameter("usuusu", usuario.getUsuusu());
        p.setParameter("pasusu", usuario.getPasusu());
        List<Usuario> lstUsuario = p.getResultList();
        if (lstUsuario.size() > 0) {
            user = lstUsuario.get(0);
        }
        return user;
    }
}
