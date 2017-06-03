package resource;

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import controller.UsuarioCtrl;
import exception.UsuarioException;
import model.Usuario;

@Path("/usuario")
public class UsuarioResource {
	
	@GET
	@Path("/login")
	@Produces("application/json")
	public Usuario login(@PathParam("usuario")String usuario, @PathParam("senha") String senha) throws SQLException, UsuarioException{
		return new UsuarioCtrl().login(usuario, senha);
	}

}
