package persistence;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import enumeration.SituacaoJuiz;
import enumeration.UF;
import model.Arbitro;

public interface ArbitroDao {
	
	public List<Arbitro> pesquisaPorUF(UF uf)throws SQLException;
	public List<Arbitro> pesquisaPorSituacao(SituacaoJuiz situacao) throws SQLException;
	public List<Arbitro> pesquisaPorNome(String nome) throws SQLException;
	public List<Arbitro> listaTodos() throws SQLException, ParseException;
	public Arbitro pesquisaUnico(int id) throws SQLException;
	
}
