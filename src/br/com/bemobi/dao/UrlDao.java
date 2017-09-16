package br.com.bemobi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.bemobi.model.Url;

public class UrlDao {
	
	public List<Url> listarUrl() throws Exception{
		
		List<Url> lista = new ArrayList<>();
		Connection connection = Dao.getConnection();
		String sql = "Select * from url_repo";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet  rs= statement.executeQuery();
		while (rs.next()) {
			Url url = new Url();
			url.setId(rs.getInt("id"));
			url.setUrl(rs.getString("url"));
			url.setUrlCurta(rs.getString("urlCurta"));
			url.setAlias(rs.getString("alias"));
			lista.add(url);
		}
		
		return lista;
	}
	public void adicionarUrl(Url url) throws Exception {
		Connection connection = Dao.getConnection();
		String sql = "insert into url_repo(url,urlCurta,alias) values (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, url.getUrl());
		statement.setString(2, url.getUrlCurta());
		statement.setString(3, url.getAlias());
		statement.execute();
	}
	public void editarUrl(Url url, Integer id) throws Exception {
		Connection connection = Dao.getConnection();
		String sql = "update url_repo set url = ?, urlCurta = ?,alias = ? where id=?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, url.getUrl());
		statement.setString(2, url.getUrlCurta());
		statement.setString(3, url.getAlias());
		statement.setInt(4, id);
		statement.execute();
	}
	public void removerUrl(Integer id)throws Exception {
		Connection connection = Dao.getConnection();
		String sql = "delete from url_repo where id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.execute();
	}
	public Url buscarUrl(Integer id)throws Exception {
		Url url = null;
		Connection connection = Dao.getConnection();
		String sql = "Select * from url_repo where id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();

		if(rs.next()) {
			url = new Url();
			url.setId(rs.getInt("id"));
			url.setUrl(rs.getString("url"));
			url.setUrlCurta(rs.getString("urlCurta"));
			url.setAlias(rs.getString("alias"));
		}
		return url;
	}
}
