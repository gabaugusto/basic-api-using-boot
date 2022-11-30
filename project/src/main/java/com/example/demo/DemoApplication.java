package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
		Esta é a classe principal do projeto. Mesmo vazia, ela é procurada e executada assim que o programa é chamado.
		Sem ela não é possível executar o projeto.
		Caso seja necessário acrescentar mais dependencias basta utilizar a classe pow.xml
	 */
}
