package util;

import java.util.UUID;

//A - Arbitro
//S - STJD
//C - CBF
//T - Torcedor
//B - Clube
public class Chave {

	public String gerarChaveArbitro() {
		UUID uuid = UUID.randomUUID();
		return "A" + uuid.toString();
	}

	public String gerarChaveSTJD() {
		UUID uuid = UUID.randomUUID();
		return "S" + uuid.toString();
	}

	public String gerarChaveTorcedor() {
		UUID uuid = UUID.randomUUID();
		return "T" + uuid.toString();
	}

	public String gerarChaveCBF() {
		UUID uuid = UUID.randomUUID();
		return "C" + uuid.toString();

	}

	public String gerarChaveClube() {
		UUID uuid = UUID.randomUUID();
		return"B" + uuid.toString();
	}

}
