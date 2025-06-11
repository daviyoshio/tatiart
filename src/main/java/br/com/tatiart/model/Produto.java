package br.com.tatiart.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.i18n.LocaleContextHolder;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Os campos 'nome' e 'descricao' foram removidos daqui
    private String urlImagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Nova lista para as traduções
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProdutoTranslation> translations = new ArrayList<>();

    // Construtor vazio
    public Produto() {}

    // Construtor para campos não traduzíveis
    public Produto(String urlImagem, Categoria categoria) {
        this.urlImagem = urlImagem;
        this.categoria = categoria;
    }

    // Método para buscar o nome traduzido
    @Transient
    public String getNome() {
        String locale = LocaleContextHolder.getLocale().toLanguageTag();
        return getTranslation(locale).map(ProdutoTranslation::getNome).orElse("Produto");
    }

    // Método para buscar a descrição traduzida
    @Transient
    public String getDescricao() {
        String locale = LocaleContextHolder.getLocale().toLanguageTag();
        return getTranslation(locale).map(ProdutoTranslation::getDescricao).orElse("Descrição indisponível");
    }

    @Transient
    private Optional<ProdutoTranslation> getTranslation(String locale) {
        return translations.stream()
                .filter(t -> t.getLocale().equalsIgnoreCase(locale))
                .findFirst()
                .or(() -> translations.stream()
                        .filter(t -> t.getLocale().equals("pt-BR"))
                        .findFirst());
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUrlImagem() { return urlImagem; }
    public void setUrlImagem(String urlImagem) { this.urlImagem = urlImagem; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public List<ProdutoTranslation> getTranslations() { return translations; }
    public void setTranslations(List<ProdutoTranslation> translations) { this.translations = translations; }
}