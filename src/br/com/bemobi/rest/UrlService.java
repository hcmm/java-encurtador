package br.com.bemobi.rest;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import br.com.bemobi.dao.UrlDao;
import br.com.bemobi.model.Url;

@Path("/url")
public class UrlService {	
	private UrlDao urlDao;
	private static final String CHARSET_UTF8 = ";charset=utf-8";
		
	@PostConstruct
	private void init() {
		urlDao = new UrlDao();
	}
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Url> listaUrl(){
		List<Url> lista = null;
		try {
			lista = urlDao.listarUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	public String adicionarUrl(@QueryParam("url")String url, Long time) {
		Integer id = 0;
		time = System.currentTimeMillis();
		String msg = "";
		System.out.println("Parametro do recebimento ajax:"+ url);
		try {			
			Url user = new Url();
			if(UrlDao.validaUrl(url) == true) {
				user.setUrl(url);
				id = urlDao.adicionarUrl(user);
				msg = "Url adicionada com sucesso!";
			}else {
				msg = "Url invalida!";
			}	
		} catch (Exception e) {
			msg = "Erro ao adicionar!";
			e.printStackTrace();
		}
		System.out.println("ID: " + id + "\n"+(time =  System.currentTimeMillis()-time) + "ms");
		return msg + id;
	}
	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Url buscarUrl(@PathParam("id") Integer id) {
		Url url = null;
		try {
		url =	urlDao.buscarUrl(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerUrl(Url url,@PathParam("id") Integer id) {
		String msg = "";
		try {
			urlDao.removerUrl(id);
			msg = "Url removida com sucesso!";
		} catch (Exception e) {
			msg = "Url nao removida!";
			e.printStackTrace();
		}
		return msg;
	}
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarUrl(Url url,@PathParam("id")Integer id) {
		String msg = "";
		try {
			urlDao.editarUrl(url, id);
			msg="Url editada com sucesso!";
		} catch (Exception e) {
			msg="Url não editada!";
			e.printStackTrace();
		}
		return msg;
	}
}
