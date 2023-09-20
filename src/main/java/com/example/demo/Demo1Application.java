package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import com.giulio.sannino.controller.LibroController;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = "com.giulio.sannino.controller")

// abilita la scansione dei componenti all'interno del pacchetto "com.example." e dei suoi sotto-pacchetti
// cercando e registrando automaticamente i componenti annotati all'interno di quei pacchetti.
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
