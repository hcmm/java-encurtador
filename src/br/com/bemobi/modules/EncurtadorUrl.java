package br.com.bemobi.modules;



import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class EncurtadorUrl {

	public void encurtarUrl(Integer id) {
		String str = String.valueOf(id);
		byte[] bs= str.getBytes();
		byte[] bytesEncoded = Base64.getEncoder().encode(bs);
		System.out.println("encoded value is " + new String(bytesEncoded));
	}
	public void urlToId(String urlEncurtada) {
		byte[] valueDecoded= Base64.getDecoder().decode(urlEncurtada);
		System.out.println("Decoded value is " + new String(valueDecoded));
	}
	public static void main(String[] args) {
		EncurtadorUrl encurtadorUrl = new EncurtadorUrl();
		encurtadorUrl.encurtarUrl(17);
		encurtadorUrl.urlToId("MTc=");
	}
}
