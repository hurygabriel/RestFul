 package resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import controller.EscalacaoCtrl;
import model.Escalacao;

/**
 * Classe que possui os caminhos e provê as chamadas aos atributos da
 *  escalacao de jogadores convertidos em JSON.
 * @author hury
 *
 */
@Path("/escalacao")
public class EscalacaoResource {

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<Escalacao> listarTodos() throws SQLException {
		return new EscalacaoCtrl().listaTodos();

	}
	
	@GET
	@Path("/listarPorId/{id}")
	@Produces("application/json")
	public Escalacao listarPorId(@PathParam("id")int id) throws SQLException {
		return new EscalacaoCtrl().listaPorId(id);

	}
	
	@GET
	@Path("/listarPorClube/{id}")
	@Produces("application/json")
	//FIXME retorno deve ser List<Escalacao>
	public Escalacao listarPorClube(@PathParam("id")int id) throws SQLException {
		return new EscalacaoCtrl().listaPorClube(id);

	}

	
}
