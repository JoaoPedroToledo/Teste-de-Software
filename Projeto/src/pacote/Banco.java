package pacote;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
	public Connection conectar() throws SQLException, ClassNotFoundException {
		Connection conexao = null;
		Class.forName("org.sqlite.JDBC");
		File bd = new File("bdprevisao.db");
		/* verifica se o arquivo do BD existe na raiz do projeto */
		if( !bd.exists() ){
		/* cria o arquivo do BD na raiz do projeto e cria uma conex�o para o BD */
		conexao = DriverManager.getConnection("jdbc:sqlite:bdprevisao.db");
		/* como o BD n�o existe ent�o � necess�rio criar as tabelas */
		createTableCidade();
		createTablePrevisao();
		}
		else{
		/* cria uma conex�o com o BD */
		conexao = DriverManager.getConnection("jdbc:sqlite:bdprevisao.db");
		}
		conexao.setAutoCommit(false);
		return conexao;
		}
	public boolean createTablePrevisao() throws SQLException{
		Statement stmt = conexao.createStatement();
		String sql = "create table if not exists tbprevisao( " +
				"id int not null," +
				"dia date not null," +
				"tempo char(3) not null," +
				"minima float not null," +
				"maxima float not null," +
				"iuv float not null," +
				"primary key (id, dia)," +
				"foreign key (id) references tbcidade(id) " +
				")";
		stmt.executeUpdate(sql);
		stmt.close();
		return true;
	}
	public boolean createTableCidade() throws SQLException{
		Statement stmt = conexao.createStatement();
		String sql = "create table if not exists tbcidade( " +
				"primary key id int not null," +
				"nome varchar(80) not null," +
				"uf char(2) not null" +
				")";
		stmt.executeUpdate(sql);
		stmt.close();
		return true;
	}

}
