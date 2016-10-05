package enumeration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TipoContratoValidador {
	
	

}	
	
	/**
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
	*/

