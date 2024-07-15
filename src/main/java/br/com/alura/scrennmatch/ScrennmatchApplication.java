package br.com.alura.scrennmatch;

import br.com.alura.scrennmatch.modulo.DadosSerie;
import br.com.alura.scrennmatch.service.ConsumoApi;
import br.com.alura.scrennmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrennmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrennmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApi();

		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=arcane&apikey=6585022c");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
