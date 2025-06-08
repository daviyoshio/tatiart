package br.com.tatiart.controller;

import br.com.tatiart.model.Categoria;
import br.com.tatiart.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importe Model
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // MÉTODO AJUSTADO: Agora passa as categorias para a página inicial (index.html)
    @GetMapping("/")
    public String index(Model model) { // Adicionado 'Model model'
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias); // Adicionado categorias ao modelo
        return "index"; // carrega index.html da pasta templates
    }

    // Este método está correto e carregará produtos.html para /produtos
    @GetMapping("/produtos")
    public String produtosOverview(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "produtos"; // Continua retornando "produtos" para a rota /produtos
    }
}