package resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import controller.JogadorCtrl;
import model.Jogador;

@Path("/jogador")
public class JogadorResource {

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<Jogador> listarTodos() throws SQLException, ParseException {
		return new JogadorCtrl().listaTodos();

	}

	@GET
	@Path("listaPorClube/{id}")
	@Produces("application/json")
	public List<Jogador> listarPorClube(@PathParam("id") int id) throws SQLException {
		return new JogadorCtrl().listarPorClube(id);
	}

}
