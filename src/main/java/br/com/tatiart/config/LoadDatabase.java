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
            repository.save(new Produto(null, "Arte 1", "Descrição da arte 1", "arte-1", "arte", "decoracao"));
            repository.save(new Produto(null, "Arte 2", "Descrição da arte 2", "arte-2", "arte", "decoracao"));
            repository.save(new Produto(null, "Arte 3", "Descrição da arte 3", "arte-3", "arte", "decoracao"));
        };
    }
}
