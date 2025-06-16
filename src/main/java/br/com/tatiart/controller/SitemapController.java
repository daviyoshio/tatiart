package br.com.tatiart.controller;

import br.com.tatiart.model.Categoria;
import br.com.tatiart.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class SitemapController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // IMPORTANTE: Altere para o domínio final do seu site quando for para produção
    private final String BASE_URL = "https://www.tatiart.com.br"; 

    @GetMapping(value = "/sitemap.xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String generateSitemap() {
        StringBuilder sitemap = new StringBuilder();
        String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

        sitemap.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sitemap.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");

        // --- URLs Estáticas ---
        // Página Inicial
        addUrl(sitemap, BASE_URL + "/", currentDate, "1.0");
        // Página Sobre
        addUrl(sitemap, BASE_URL + "/sobre", currentDate, "0.8");
        // Página Geral de Produtos
        addUrl(sitemap, BASE_URL + "/produtos", currentDate, "0.9");

        // --- URLs Dinâmicas (buscadas do banco de dados) ---
        List<Categoria> categorias = categoriaRepository.findAll(); //
        for (Categoria categoria : categorias) {
            addUrl(sitemap, BASE_URL + "/produtos/" + categoria.getSlug(), currentDate, "0.9");
        }

        sitemap.append("</urlset>");
        return sitemap.toString();
    }

    private void addUrl(StringBuilder sitemap, String loc, String lastmod, String priority) {
        sitemap.append("  <url>\n");
        sitemap.append("    <loc>").append(loc).append("</loc>\n");
        sitemap.append("    <lastmod>").append(lastmod).append("</lastmod>\n");
        sitemap.append("    <priority>").append(priority).append("</priority>\n");
        sitemap.append("  </url>\n");
    }
}