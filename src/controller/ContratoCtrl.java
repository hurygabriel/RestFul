package controller;

import java.sql.SQLException;
import java.util.List;

import model.Contrato;
import persistence.ContratoDao;
import persistence.ContratoDaoImpl;

/**
 * Classe responsável pelo controle dos contratos de jogadores
 * com clubes, junto a sua percistencia.
 * @author hury
 *
 */
public class ContratoCtrl {

	ContratoDao cdao = new ContratoDaoImpl();
	
	/**
	 * Lista todos os contratos cadastrados no banco de dados.
	 * @return
	 * @throws SQLException
	 */
	public List<Contrato>listaTodos()throws SQLException{
		return cdao.pesquisa();
	}
	
	
}
