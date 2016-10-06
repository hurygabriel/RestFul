package persistence;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import enumeration.UF;
import model.Arbitro;
import model.Situacao;

public interface ArbitroDao {
	
	public List<Arbitro> pesquisaPorUF(UF UF)throws SQLException;
	public List<Arbitro> pesquisaPorSituacao(Situacao situacao) throws SQLException;
	public List<Arbitro> pesquisaPorNome(String nome) throws SQLException;
	public List<Arbitro> listaTodos() throws SQLException, ParseException;

}
