package resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.primefaces.json.JSONObject;

import controller.CadastroCtrl;
import enumeration.Tipo;
import exception.UsuarioException;
import model.Cadastro;
import model.Usuario;

@Path("/cadastro")
public class CadastroResource {
	
	@POST
	@Path("/insereCadastroObject") //TODO verificar necessidade de url unica
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) //TODO verificar a necessidade desta tag
	public Response insereCadastro(Cadastro cad) {
		//CadastroCtrl cControl = new CadastroCtrl();
		if (cad.equals(null)) {
			return Response.status(400).entity("Preencha os campos antes de enviar!").build();
		} else {
			try {
				//cControl.insereCadastro(cad);
				System.out.println("CPF : " + cad.getCpf());
				System.out.println("Nome : " + cad.getNome());
				System.out.println("Registro : " + cad.getRegistro());
				System.out.println("Tipo : " + cad.getTipo().toString());
				System.out.println("Usuario : " + cad.getUsuario().getUsuario());
				System.out.println("Senha : " +cad.getUsuario().getSenha());
			} catch (Exception e) {
				e.printStackTrace();
			}
			// return HTTP response 200 in case of success
			return Response.status(200).entity(cad.toString()).build();
		}

	}
	
	@POST
	@Path("/insereCadastro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crunchifyREST(InputStream incomingData) {
		StringBuilder crunchifyBuilder = new StringBuilder();
		CadastroCtrl cControl = new CadastroCtrl();
		Usuario usuario = new Usuario();
		Cadastro cad = new Cadastro();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		JSONObject jObject  = new JSONObject(crunchifyBuilder.toString());
		
		usuario.setUsuario(String.valueOf(jObject.get("usuario")));
		usuario.setSenha(String.valueOf(jObject.get("senha")));
		System.out.println(String.valueOf(jObject.get("nome")));
		cad.setNome(String.valueOf(jObject.get("nome")));
		cad.setCpf(String.valueOf(jObject.get("cpf")));
		cad.setRegistro(String.valueOf(jObject.get("registro")));
		cad.setTipo((Tipo.valueOf(jObject.get("tipo").toString())));
		cad.setUsuario(usuario);
		
		try {
			cControl.insereCadastro(cad);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		
		
		//System.out.println(jObject.get("usuario"));
		//System.out.println("Data Received: " + crunchifyBuilder.toString());
		
		
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
	}

}
