package br.com.tatiart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ColecaoController {

    @GetMapping("/colecao")
    public String exibirColecao() {
        return "colecao"; // Renderiza templates/colecao.html
    }
}
