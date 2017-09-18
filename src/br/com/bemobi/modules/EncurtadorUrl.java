package br.com.bemobi.modules;



import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.glassfish.jersey.server.Uri;
import org.springframework.stereotype.Component;

@Component
public class EncurtadorUrl {
	private String encodado;
	private Integer decodado;
	public String getEncodado() {
		return encodado;
	}
	public void setEncodado(String encodado) {
		this.encodado = encodado;
	}
	public Integer getDecodado() {
		return decodado;
	}
	public void setDecodado(Integer decodado) {
		this.decodado = decodado;
	}
	public String encurtarUrl(Integer id) {
		encodado = "";
		String str = String.valueOf(id);
		byte[] bs= str.getBytes();
		byte[] bytesEncoded = Base64.getEncoder().encode(bs);
		//System.out.println("encoded value is " + new String(bytesEncoded));
		encodado = new String(bytesEncoded);
		return "OK";
	}
	public String urlToId(String urlEncurtada) {
		byte[] valueDecoded= Base64.getDecoder().decode(urlEncurtada);
		System.out.println("Decoded value is " + new String(valueDecoded));
		return valueDecoded.toString();
	}
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		 Base64.Encoder enc = Base64.getEncoder();
		    Base64.Encoder encURL = Base64.getUrlEncoder();

		    byte[] bytes = enc.encode("7yr6534".getBytes());
		    byte[] bytesURL = encURL.encode("7yr6534".getBytes());

		    System.out.println(new String(bytes)); // c3ViamVjdHM/X2Q=      notice the "/"
		    System.out.println(new String(bytesURL)); // c3ViamVjdHM_X2Q=   notice the "_"

		    Base64.Decoder dec = Base64.getDecoder();
		    Base64.Decoder decURL = Base64.getUrlDecoder();

		    byte[] decodedURL = decURL.decode(bytesURL);
		    byte[] decoded = dec.decode(bytes);

		    System.out.println(new String(decodedURL));
		    System.out.println(new String(decoded));
		    
	}
	{
		
	}
}
