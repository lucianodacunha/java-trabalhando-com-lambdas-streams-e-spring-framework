package io.github.lucianodacunha.autobuscar.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutobuscarApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(AutobuscarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();
	}
}
