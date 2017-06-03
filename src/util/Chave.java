package util;

import java.util.UUID;

public class Chave {

	public String gerarChave() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
