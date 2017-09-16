package br.com.bemobi.control;

import javax.swing.JOptionPane;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bemobi.modules.EncurtadorUrl;

public class UrlController {
	@Autowired
	private EncurtadorUrl encurtadorUrl;
	
	
	public void calcularTempo() {
		Long tempoDecorrido = System.currentTimeMillis();
		System.out.println("Tempo Decorrido:"+ (tempoDecorrido -System.currentTimeMillis())+"ms");
	}
}
