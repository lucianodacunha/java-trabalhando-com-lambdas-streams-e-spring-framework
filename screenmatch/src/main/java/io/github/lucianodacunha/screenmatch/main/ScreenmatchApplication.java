package io.github.lucianodacunha.screenmatch.main;

import io.github.lucianodacunha.screenmatch.model.SerieData;
import io.github.lucianodacunha.screenmatch.services.ConsumerAPI;
import io.github.lucianodacunha.screenmatch.services.DataConvert;
import io.github.lucianodacunha.screenmatch.util.GetAPIKey;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var main = new Main();
		main.showMenu();
	}
}
