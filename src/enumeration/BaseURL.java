package enumeration;

/**
 * Constante de url caminho para o servidor.
 * @author hury
 *
 */
public enum BaseURL {

    //URL("http://192.168.1.4:8080/RestFul/");
	URL("localhost:8085/RestFul/");
	
    public String caminho;

    BaseURL(String caminho){
        this.caminho = caminho;
    }
	
	
}
