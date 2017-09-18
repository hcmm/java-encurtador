package br.com.bemobi.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.UrlValidator;

import br.com.bemobi.model.Url;
import br.com.bemobi.modules.EncurtadorUrl;

public class UrlDao {
	int id =0;
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
		statement.close();
		connection.close();
		return lista;
	}
	public Integer adicionarUrl(Url url) throws Exception {
		Connection connection = Dao.getConnection();
		String sql = "insert into url_repo(url,urlCurta,alias) values (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, url.getUrl());
		statement.setString(2, url.getUrlCurta());
		statement.setString(3, url.getAlias());
		statement.execute();
		ResultSet rsId = statement.getGeneratedKeys();
		if(rsId.next()) {
			id = rsId.getInt(1);
		}
		statement.close();
		connection.close();
		return id;
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
		statement.close();
		connection.close();
		
	}
	public void removerUrl(Integer id)throws Exception {
		Connection connection = Dao.getConnection();
		String sql = "delete from url_repo where id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.execute();
		statement.close();
		connection.close();
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
		statement.close();
		connection.close();
		return url;
		
	}
	public static boolean validaUrl(String string) {
		String[] schemes = {"http","https", "ftp"};  
		UrlValidator urlValidator = new UrlValidator(schemes);
		if (urlValidator.isValid(string)) {
			System.out.println("Validada!");
		   return true;
		} else {
		   System.out.println("Não Validada");
		   return false;
		}
	}
}
