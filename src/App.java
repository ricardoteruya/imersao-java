import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		
		//Usando api alternativa fornecida pelos instrutores
		String url = "https://alura-filmes.herokuapp.com/conteudos";
		URI uri = URI.create(url);
		HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		JsonParser parser = new JsonParser();
		List<Map<String,String>> listaDeFilmes = parser.parse(body);
		
		var geradora = new GeradoraDeFigurinhas();
		String DIRETORIO = "saida";
		for (Map<String, String> filme : listaDeFilmes) {
			String titulo = filme.get("title");
			String nomeArquivo = DIRETORIO + "/" + titulo + ".png";
			
			String urlImagem = filme.get("image");			
			InputStream inputStream = new URL(urlImagem).openStream();
			
			geradora.cria(inputStream, nomeArquivo);
			System.out.println();
			
			
//			System.out.println(filme.get("title"));
//			System.out.println(filme.get("image"));
//			System.out.println(filme.get("imDbRating"));
		}
	}

}