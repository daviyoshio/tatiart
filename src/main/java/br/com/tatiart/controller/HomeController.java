package br.com.tatiart.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daviyshiy
 */
import br.com.tatiart.model.Categoria;
import br.com.tatiart.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public String index() {
        return "index"; // carrega index.html da pasta templates
    }
    // Certifique-se de que ESTE MÉTODO RETORNA "index"
    @GetMapping("/produtos") // Este método agora retornará "produtos"
    public String produtosOverview(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "produtos"; // <-- ALTERADO PARA RETORNAR "produtos"
    }
}

