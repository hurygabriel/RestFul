package resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.JogadorCtrl;
import model.Jogador;

/**
 * Classe que possui os caminhos e provê as chamadas aos atributos de jogador
 * convertidos em JSON.
 * 
 * @author hury
 *
 */

@Path("/jogador")
public class JogadorResource {

	// GETs

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<Jogador> listarTodos() throws SQLException {
		return new JogadorCtrl().listaTodos();

	}

	@GET
	@Path("listaPorClubeId/{id}")
	@Produces("application/json")
	public List<Jogador> listarPorClube(@PathParam("id") int id) throws SQLException {
		return new JogadorCtrl().listarPorClubeId(id);
	}

	@GET
	@Path("listaPorClubeNome/{nome}")
	@Produces("application/json")
	public List<Jogador> listarPorClube(@PathParam("nome") String nome) throws SQLException {
		return new JogadorCtrl().listarPorClubeNome(nome);
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
	@Path("listaPorPosicao/{posicao}")
	@Produces("application/json")
	public List<Jogador> listarPorPosicao(@PathParam("posicao") String posicao) throws SQLException {
		return new JogadorCtrl().listarPorPosicao(posicao);
	}

	// POST

	@POST
	@Path("/cad") //TODO verificar necessidade de url unica
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) //TODO verificar a necessidade desta tag
	public Response addJogador(Jogador jog) {

		if (jog == null) {
			return Response.status(400).entity("Preencha os campos antes de enviar!").build();
		} else {
			
			try {
				new JogadorCtrl().inclui(jog);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// return HTTP response 200 in case of success
			return Response.status(200).entity(jog.toString()).build();
		}

	}

	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";

		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}

}
