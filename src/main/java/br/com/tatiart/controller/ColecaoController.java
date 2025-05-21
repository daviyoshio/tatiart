package br.com.tatiart.controller;

import br.com.tatiart.model.Produto;
import br.com.tatiart.repository.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ColecaoController {

    private final ProdutoRepository produtoRepository;

    public ColecaoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/colecao")
    public String exibirColecao(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "colecao";
    }
}
