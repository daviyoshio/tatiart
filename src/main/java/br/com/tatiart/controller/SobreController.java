package br.com.tatiart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SobreController {

    @GetMapping("/sobre")
    public String exibirPaginaSobre() {
        return "sobre"; // Renderiza templates/sobre.html
    }
}
