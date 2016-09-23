package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogador;

public interface JogadorDao {

	public List<Jogador> pesquisa() throws SQLException ;

	
	
}
