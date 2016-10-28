package resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controller.ContratoCtrl;
import model.Contrato;

/**
 * Classe que possui os metodos de contrato a serem consumidos pelo JSON.
 * @author hury
 *
 */

@Path("/contrato")
public class ContratoResource {
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<Contrato>listarTodos() throws SQLException{
		return new ContratoCtrl().listaTodos();
	}
	
	
	
}
