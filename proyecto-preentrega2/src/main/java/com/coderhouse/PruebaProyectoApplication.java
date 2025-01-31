package com.coderhouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Videojuego;
import com.coderhouse.models.Cliente;
import com.coderhouse.repositories.CategoriaRepository;
import com.coderhouse.repositories.VideojuegoRepository;
import com.coderhouse.repositories.ClienteRepository;

@SpringBootApplication
public class PruebaProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaProyectoApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(CategoriaRepository categoriaRepo, VideojuegoRepository videojuegoRepo, ClienteRepository clienteRepo) {
        return args -> {
            // Crear categorías
            Categoria accion = new Categoria("Acción");
            Categoria aventura = new Categoria("Aventura");
            Categoria estrategia = new Categoria("Estrategia");

            // Guardar categorías en la base de datos
            categoriaRepo.save(accion);
            categoriaRepo.save(aventura);
            categoriaRepo.save(estrategia);

            // Crear clientes
            Cliente cliente1 = new Cliente("Carlos Barrientos", "carlosbarrientos@gmail.com");
            Cliente cliente2 = new Cliente("Sergio Perez", "checoperez@gmail.com");
            Cliente cliente3 = new Cliente("Abril Guerra", "abrilguerra@gmail.com");

            // Guardar clientes en la base de datos
            clienteRepo.save(cliente1);
            clienteRepo.save(cliente2);
            clienteRepo.save(cliente3);

            // Crear videojuegos, asociando la categoría con el videojuego
            Videojuego juego1 = new Videojuego("The Legend of Zelda", "Un juego de aventuras épico", aventura, cliente1);
            Videojuego juego2 = new Videojuego("Call of Duty", "Shooter en primera persona", accion, cliente2);
            Videojuego juego3 = new Videojuego("Age of Empires", "Juego de estrategia en tiempo real", estrategia, cliente3);
            Videojuego juego4 = new Videojuego("Dark Souls", "Desafiante y atmosférico", accion, cliente1);

            // Guardar videojuegos en la base de datos
            videojuegoRepo.save(juego1);
            videojuegoRepo.save(juego2);
            videojuegoRepo.save(juego3);
            videojuegoRepo.save(juego4);

            System.out.println("Datos insertados en la base de datos.");
        };
    }
}
