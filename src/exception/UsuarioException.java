package exception;

import java.io.Serializable;

public class UsuarioException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public UsuarioException(String msg){
		super(msg);
	}
	
	public UsuarioException(String msg, Throwable cause){
		super(msg, cause);
	}
	

}
