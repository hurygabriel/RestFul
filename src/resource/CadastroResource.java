package resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import controller.CadastroCtrl;
import model.Cadastro;

@Path("/cadastro")
public class CadastroResource {
	
	/*@POST
	@Path("/insereCadastro") //TODO verificar necessidade de url unica
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) //TODO verificar a necessidade desta tag
	public Response insereCadastro(Cadastro cad) {
		//CadastroCtrl cControl = new CadastroCtrl();
		if (cad.equals(null)) {
			return Response.status(400).entity("Preencha os campos antes de enviar!").build();
		} else {
			try {
				//cControl.insereCadastro(cad);
				System.out.println(cad.getCpf());
				System.out.println(cad.getNome());
				System.out.println(cad.getRegistro());
				System.out.println(cad.getTipo().toString());
				System.out.println(cad.getUsuario().getUsuario());
				System.out.println(cad.getUsuario().getSenha());
			} catch (Exception e) {
				e.printStackTrace();
			}
			// return HTTP response 200 in case of success
			return Response.status(200).entity(cad.toString()).build();
		}

	}*/
	
	@POST
	@Path("/insereCadastro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crunchifyREST(InputStream incomingData) {
		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
	}

}
