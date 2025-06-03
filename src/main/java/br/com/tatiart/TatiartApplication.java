package br.com.tatiart;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TatiartApplication {

    @Value("${server.port:8080}")
    private String porta;

    public static void main(String[] args) {
        SpringApplication.run(TatiartApplication.class, args);
    }

    @PostConstruct
    public void logPorta() {
        System.out.println("🚀 Porta configurada: " + porta);
    }
}
