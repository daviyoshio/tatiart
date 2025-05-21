/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tatiart.config;

import br.com.tatiart.model.Produto;
import br.com.tatiart.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProdutoRepository repository) {
        return args -> {
            repository.save(new Produto("Arte 1", "Descrição da arte 1", "arte1.jpg"));
            repository.save(new Produto("Arte 2", "Descrição da arte 2", "arte2.jpg"));
            repository.save(new Produto("Arte 3", "Descrição da arte 3", "arte3.jpg"));
        };
    }
}

