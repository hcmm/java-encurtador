package br.com.bemobi.control;

import br.com.bemobi.dao.UrlDao;
import br.com.bemobi.model.Url;
import br.com.bemobi.modules.EncurtadorUrl;
import br.com.bemobi.rest.UrlService;

public class UrlController {
	
	private UrlDao urlDao;
	private Url url;
	private UrlService urlService;
	private EncurtadorUrl encurtadorUrl;
	
	
	public String converterUrl() {
		return null;
		
	}
	
	public void reverterUrl() {
		
	}
	public void calcularTempo() {
		Long tempoDecorrido = System.currentTimeMillis();
		System.out.println("Tempo Decorrido:"+ (tempoDecorrido -System.currentTimeMillis())+"ms");
	}
}
