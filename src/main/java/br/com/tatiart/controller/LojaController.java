package br.com.tatiart.controller;

import br.com.tatiart.model.Categoria;
import br.com.tatiart.model.Depoimento;
import br.com.tatiart.model.Produto;
import br.com.tatiart.model.TipoPersonalizacao;
import br.com.tatiart.repository.CategoriaRepository;
import br.com.tatiart.repository.DepoimentoRepository;
import br.com.tatiart.repository.ProdutoRepository;
import br.com.tatiart.repository.TipoPersonalizacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller // Marca esta classe como um Controller do Spring MVC
public class LojaController {

    // @Autowired faz a "injeção de dependência": O Spring nos dá uma instância
    // pronta dos nossos repositórios, sem precisarmos criá-las manualmente.
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired // Adicione esta linha
    private DepoimentoRepository depoimentoRepository;
    
    // 3. Injete o novo repositório
    @Autowired
    private TipoPersonalizacaoRepository tipoPersonalizacaoRepository;

    // @GetMapping diz que este método vai responder a requisições GET
    // para a URL "/produtos/{qualquer-coisa}".
    // O que estiver no lugar de {slug} será passado para a variável 'slug'.
    @GetMapping("/produtos/{slug}")
    public String exibirPaginaCategoria(@PathVariable String slug, Model model) {

        // 1. Encontra a categoria no banco de dados usando o slug da URL.
        // Se não encontrar, lança um erro (uma página 404 seria o ideal no futuro).
        Categoria categoria = categoriaRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalArgumentException("Categoria inválida: " + slug));

        // 2. Com a categoria encontrada, busca todos os produtos associados a ela.
        List<Produto> produtos = produtoRepository.findByCategoria(categoria);
        List<Depoimento> depoimentos = depoimentoRepository.findByCategoria(categoria);
        List<Categoria> todasAsCategorias = categoriaRepository.findAll();
        List<TipoPersonalizacao> tiposPersonalizacao = tipoPersonalizacaoRepository.findByCategoria(categoria);

        // 3. Adiciona os dados encontrados ao "Model".
        // O Model vai carregar esses dados para o nosso arquivo HTML.
        // Estamos dando os nomes "categoriaInfo" e "produtos" para eles.
        // Adiciona tudo ao Model
        model.addAttribute("categoriaInfo", categoria);
        model.addAttribute("produtos", produtos);
        model.addAttribute("depoimentos", depoimentos);
        model.addAttribute("todasAsCategorias", todasAsCategorias);
        model.addAttribute("tiposPersonalizacao", tiposPersonalizacao);;

        // 4. Retorna o nome do arquivo de template que deve ser renderizado.
        // O Spring vai procurar por "pagina_categoria.html" na pasta /resources/templates.
        return "pagina_categoria";
    }
}