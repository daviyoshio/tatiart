package br.com.tatiart.controller;

import br.com.tatiart.model.Categoria; // Importar
import br.com.tatiart.repository.CategoriaRepository; // Importar
import java.util.List; // Importar
import org.springframework.beans.factory.annotation.Autowired; // Importar
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importar
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SobreController {

    // Injetar o repositório para buscar as categorias
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/sobre")
    public String exibirPaginaSobre(Model model) { // Adicionar "Model model"
        // Buscar todas as categorias e adicioná-las ao modelo
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        
        return "sobre"; // Renderiza templates/sobre.html
    }
}