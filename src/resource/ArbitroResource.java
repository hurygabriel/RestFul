package resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ArbitroCtrl;
import enumeration.SituacaoJuiz;
import enumeration.UF;
import model.Arbitro;


@Path("/arbitro")
public class ArbitroResource {
	
	
	@GET
	@Path("/listarTodos")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String listarTodos() throws SQLException, ParseException{
		List<Arbitro> lista = new ArrayList<Arbitro>();
		lista = new ArbitroCtrl().listaTodos();
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create(); 
		return gson.toJson(lista);
	}
	
	@GET
	@Path("/listarSituacao/{situacao}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String listarSituacao(@PathParam("situacao") SituacaoJuiz situacao) throws SQLException, ParseException{
		List<Arbitro> lista = new ArrayList<Arbitro>();
		lista = new ArbitroCtrl().listaPorSituacao(situacao);
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create(); 
		return gson.toJson(lista);
	}
	
	@GET
	@Path("/listarUf/{uf}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String listarUf(@PathParam("uf") UF uf) throws SQLException, ParseException{
		List<Arbitro> lista = new ArrayList<Arbitro>();
		lista = new ArbitroCtrl().listaPorUF(uf);
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create(); 
		return gson.toJson(lista);
	}
	
	@GET
	@Path("/listarNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String listarNome(@PathParam("nome") String nome) throws SQLException, ParseException{
		List<Arbitro> lista = new ArrayList<Arbitro>();
		lista = new ArbitroCtrl().listaPorNome(nome);
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create(); 
		return gson.toJson(lista);
	}
	
	

}
