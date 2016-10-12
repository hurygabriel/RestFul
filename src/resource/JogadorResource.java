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

/**
 * Classe que possui os caminhos e prove as chamadas aos atributos de
 *  jogador convertidos em JSON.
 *  
 * @author hury
 *
 */

@Path("/jogador")
public class JogadorResource {

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<Jogador> listarTodos() throws SQLException, ParseException {
		return new JogadorCtrl().listarTodos();

	}

	@GET
	@Path("listaPorClube/{id}")
	@Produces("application/json")
	public List<Jogador> listarPorClube(@PathParam("id") int id) throws SQLException {
		return new JogadorCtrl().listarPorClube(id);
	}
	
	@GET
	@Path("listaPorNome/{nome}")
	@Produces("application/json")
	public List<Jogador> listarPorNome(@PathParam("nome") String nome) throws SQLException {
		return new JogadorCtrl().listarPorNome(nome);
	}
	
	@GET
	@Path("listaPorUf/{uf}")
	@Produces("application/json")
	public List<Jogador> listarPorUf(@PathParam("uf") String uf) throws SQLException {
		return new JogadorCtrl().listarPorUF(uf);
	}
	
	@GET
	@Path("listaPorUf/{posicao}")
	@Produces("application/json")
	public List<Jogador> listarPorPosicao(@PathParam("posicao") String posicao) throws SQLException {
		return new JogadorCtrl().listarPorPosicao(posicao);
	}
	
	
	

}
