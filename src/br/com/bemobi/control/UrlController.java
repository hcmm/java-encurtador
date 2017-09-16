package br.com.bemobi.control;

import javax.swing.JOptionPane;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bemobi.modules.EncurtadorUrl;

public class UrlController {
	@Autowired
	private EncurtadorUrl encurtadorUrl;
	
	@URL(message="Digite uma URL valida")
	String url;
	
	public void validarUrl() {
		
		url = JOptionPane.showInputDialog("Digite a URL");
		
	}
	public void calcularTempo() {
		Long tempoDecorrido = System.currentTimeMillis();
		System.out.println("Tempo Decorrido:"+ (tempoDecorrido -System.currentTimeMillis())+"ms");
	}
}
