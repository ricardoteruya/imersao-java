import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Usando api alternativa fornecida pelos instrutores
		String url = "https://alura-filmes.herokuapp.com/conteudos";
		URI uri = URI.create(url);
		HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		JsonParser parser = new JsonParser();
		List<Map<String,String>> listaDeFilmes = parser.parse(body);
		
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));		
		}
	}

}