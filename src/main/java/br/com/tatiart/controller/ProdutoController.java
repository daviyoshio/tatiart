package br.com.tatiart.controller;

import br.com.tatiart.model.ProdutoView;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProdutoController {

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<ProdutoView> produtos = new ArrayList<>();

        produtos.add(new ProdutoView(
            "Canecas Personalizadas",
            "Canecas feitas sob medida com seu nome ou frase favorita.",
            new String[]{"Durável", "Criativa"},
            new String[]{"/images/canecas/caneca1.png"},
            new String[]{"Cerâmica de alta qualidade"},
            "/images/canecas-icon.png"
        ));

        produtos.add(new ProdutoView(
            "Necessaires",
            "Compactas, estilosas e funcionais para o dia a dia.",
            new String[]{"Tecido resistente", "Estampas exclusivas"},
            new String[]{"/images/necessaires/necessaire1.png"},
            new String[]{"Feita à mão"},
            "/images/necessaires-icon.png"
        ));

        produtos.add(new ProdutoView(
            "Bolsas",
            "Bolsas artesanais que unem beleza e utilidade.",
            new String[]{"Design exclusivo", "Feita à mão"},
            new String[]{"/images/bolsas/bolsa1.png"},
            new String[]{"Material sustentável"},
            "/images/bolsas-icon.png"
        ));

        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/produtos/{tipo}")
    public String paginaProduto(@PathVariable String tipo, Model model) {
        ProdutoView produto = new ProdutoView();

        if (tipo.equalsIgnoreCase("canecas")) {
            produto.setTitulo("Canecas Personalizadas");
            produto.setDescricao("Nossas canecas personalizadas combinam praticidade e originalidade...");
            produto.setBeneficios(new String[]{
                "Cerâmica resistente de alta qualidade",
                "Personalização com fotos, nomes ou frases",
                "Opções com alça colorida, glitter ou interior personalizado"
            });
            produto.setImagens(new String[]{
                "/images/canecas/caneca1.png",
                "/images/canecas/caneca2.png",
                "/images/canecas/caneca3.png"
            });
            produto.setAtributos(new String[]{
                "Feita com cerâmica premium",
                "Estampa resistente a micro-ondas e lava-louças"
            });
            produto.setBanner("/images/canecas-icon.png");

        } else if (tipo.equalsIgnoreCase("necessaires")) {
            produto.setTitulo("Necessaires Personalizadas");
            produto.setDescricao("Nossas necessaires são práticas, duráveis e com estilo único.");
            produto.setBeneficios(new String[]{
                "Tecido reforçado com zíper resistente",
                "Estampas exclusivas e criativas",
                "Ideal para viagens ou organização diária"
            });
            produto.setImagens(new String[]{
                "/images/necessaires/necessaire1.png",
                "/images/necessaires/necessaire2.png",
                "/images/necessaires/necessaire3.png"
            });
            produto.setAtributos(new String[]{
                "Lavável e reutilizável",
                "Produção artesanal e sustentável"
            });
            produto.setBanner("/images/necessaires-icon.png");

        } else if (tipo.equalsIgnoreCase("bolsas")) {
            produto.setTitulo("Bolsas da Tatiart");
            produto.setDescricao("Estilo, utilidade e personalização em cada detalhe.");
            produto.setBeneficios(new String[]{
                "Alças reforçadas",
                "Espaço interno otimizado",
                "Modelos modernos e personalizados"
            });
            produto.setImagens(new String[]{
                "/images/bolsas/bolsa1.png",
                "/images/bolsas/bolsa2.png",
                "/images/bolsas/bolsa3.png"
            });
            produto.setAtributos(new String[]{
                "Confeccionada à mão com carinho",
                "Feita com tecidos resistentes e ecológicos"
            });
            produto.setBanner("/images/bolsas-icon.png");
            
        } else if (tipo.equalsIgnoreCase("mochilas")) {
            produto.setTitulo("Mochilas Personalizadas");
            produto.setDescricao("Funcionalidade e estilo para o dia a dia...");
            produto.setBeneficios(new String[]{
                "Vários tamanhos e modelos",
                "Personalização com nomes e estampas"
            });
            produto.setImagens(new String[]{
                "/images/mochilas/mochila1.png",
                "/images/mochilas/mochila2.png"
            });
            produto.setAtributos(new String[]{
                "Material resistente",
                "Confeccionada à mão"
            });
            produto.setBanner("/images/mochilas-icon.png");
        } else {
            return "redirect:/produtos";
        }

        model.addAttribute("produto", produto);
        return "produto";
    }
}
