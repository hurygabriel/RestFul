package resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import controller.CadastroCtrl;
import exception.UsuarioException;
import model.Cadastro;

@Path("/cadastro")
public class CadastroResource {
	
	@POST
	@Path("/insereCadastro")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean insereCadastro(@PathParam("cadastro") Cadastro cadastro) {
		CadastroCtrl cControl = new CadastroCtrl();
		try {
			return cControl.insereCadastro(cadastro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
