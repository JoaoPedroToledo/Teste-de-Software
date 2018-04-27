package pacote;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import xml.Cidade;
import xml.Cidades;

public class Classe {
	
	public boolean insertCidade(Cidade cidade) throws SQLException{
		/* o campo atualizacao irá receber o valor padrão, ou seja, null */
		String sql = "insert or ignore into tbcidade(id,nome,uf) values(?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, cidade.getId() );
		stmt.setString(2, cidade.getNome() );
		stmt.setString(3, cidade.getUf() );
		stmt.execute();
		stmt.close();
		conexao.commit();
		return true;
	}
	public List<Cidade> selectCidade(String sql) throws SQLException{
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Cidade> lista = new ArrayList<>();
		Cidade cidade;
		while ( rs.next() ) {
			cidade = new Cidade();
			cidade.setId(rs.getInt("id"));
			cidade.setNome(rs.getString("nome"));
			cidade.setUf(rs.getString("uf"));
			cidade.setAtualizacao(rs.getString("atualizacao"));
			lista.add(cidade);
		}
		rs.close();
		stmt.close();
		conexao.commit();
		return lista;
	}
	
}
