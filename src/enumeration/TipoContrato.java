package enumeration;

/**
 * Classe que possui os tipos constantes de um contrato
 * 
 * @author hury
 *
 */

public enum TipoContrato {

	DEFINITIVO, RENOVACAO, PRORROGACAO, RESCISAO, PRECONTRATO, EMPRESTIMO, NAOPROFISSIONAL;
	// alteração salarial,

	TipoContrato verifica(String nome) {
		
		switch (nome) {
		case "DEFINITIVO":
			return TipoContrato.DEFINITIVO;
		case "RENOVACAO":
			return TipoContrato.RENOVACAO;
		case "PRORROGACAO":
			return TipoContrato.PRORROGACAO;
		case "RESCISAO":
			return TipoContrato.RESCISAO;
		case "PRECONTRATO":
			return TipoContrato.PRECONTRATO;
		case "EMPRESTIMO":
			return TipoContrato.EMPRESTIMO;
		case "NAOPROFISSIONAL":
			return TipoContrato.NAOPROFISSIONAL;

		default:
			return null;
		}
		

	}

}
