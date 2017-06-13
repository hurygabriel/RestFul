package resource;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import controller.ArbitroCtrl;
import controller.ClubeCtrl;
import controller.JogadorCtrl;
import model.Arbitro;
import model.Clube;
import model.Jogador;

@Path("/imagem")
public class ImagensResource {

	private static final String FILE_PATH = "c:\\imagens";

	// FIXME Refatorar, codigo utiliza o caminho absoluto da imagem, convem
	// usar o caminho relativo do arquivo
	
	@GET
	@Path("/escudo/{id}")
	@Produces("image/png")
	public Response getEscudo(@PathParam("id") int id) throws SQLException {
		
		Clube c = new ClubeCtrl().listaPorId(id);
		
		File file = new File(FILE_PATH + "\\escudos\\" + c.getCaminhoimg());
		
		if (!file.exists()) {
			throw new WebApplicationException(404);
		}
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"" + c.getNome() + ".png\"");
		return response.build();

		// EXEMPLO http://localhost:8085/RestFul/imagem/escudo/1

	}
	
	@GET
	@Path("/foto/{id}")
	@Produces("image/png")
	public Response getFotoJogador(@PathParam("id") int id) throws SQLException {
		
		Jogador j = new JogadorCtrl().pesquisaUnico(id);
		
		File file = new File(FILE_PATH + "\\jogador\\" + j.getCaminhoimg());
		
		if (!file.exists()) {
			throw new WebApplicationException(404);
		}
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"" + j.getNome() + ".png\"");
		return response.build();
	}
	
	// EXEMPLO http://localhost:8085/RestFul/imagem/fotojogador/1
	
	@GET
	@Path("/fotoarbitro/{id}")
	@Produces("image/png")
	public Response getFotoArbitro(@PathParam("id") int id) throws SQLException {
		
		Arbitro a = new ArbitroCtrl().listaPorId(id);
		
		File file = new File(FILE_PATH + "\\arbitro\\" + a.getCaminhoimg());
		
		if (!file.exists()) {
			throw new WebApplicationException(404);
		}
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"" + a.getNome() + ".png\"");
		return response.build();
	}
	
	// EXEMPLO http://localhost:8085/RestFul/imagem/fotoarbitro/1
	
}

// static String convertStreamToString(java.io.InputStream is) {
// java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
// return s.hasNext() ? s.next() : "";
// }
// InputStream in = getClass().getClassLoader().getResourceAsStream(FILE_PATH);
// String caminho = convertStreamToString(in);

/*
 * File f = new File(FILE_PATH); if (!f.exists()) { throw new
 * WebApplicationException(404); } String mt = new
 * MimetypesFileTypeMap().getContentType(f); return Response.ok(f, mt).build();
 */
