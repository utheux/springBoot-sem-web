package br.com.springteste.screenmatch;

import br.com.springteste.screenmatch.service.ConsumoAPI;
import br.com.springteste.screenmatch.service.ConverteDados;
import model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication  implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=sex+education&apikey=366aee82");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(serie);
    }
}
