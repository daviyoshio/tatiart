package br.com.tatiart.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.i18n.LocaleContextHolder;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos que NÃO são traduzidos permanecem aqui
    @Column(unique = true, nullable = false)
    private String slug;
    private String imagemUrlHome;
    private String imagemDestaqueUrl;
    private String urlImagemPersonalizacao;

    // Relacionamento com a nova tabela de traduções
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CategoriaTranslation> translations = new ArrayList<>();

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Produto> produtos = new ArrayList<>();

    // --- MÉTODOS AUXILIARES (GETTERS TRADUZIDOS) ---
    // Estes métodos pegam a tradução correta para você
    
    @Transient
    public String getNomeSingular() {
        return getTranslation().map(CategoriaTranslation::getNomeSingular).orElse("Item");
    }

    @Transient
    public String getNomePlural() {
        return getTranslation().map(CategoriaTranslation::getNomePlural).orElse("Categoria");
    }

    @Transient
    public String getDescricao() {
        return getTranslation().map(CategoriaTranslation::getDescricao).orElse("Descrição não disponível");
    }

    @Transient
    public String getCtaTitle() {
        return getTranslation().map(CategoriaTranslation::getCtaTitle).orElse("");
    }
    
    // --- MÉTODOS QUE FALTAVAM ---
    @Transient
    public String getCtaDescription() {
        return getTranslation().map(CategoriaTranslation::getCtaDescription).orElse("");
    }
    
    @Transient
    public String getCtaAttention() {
        return getTranslation().map(CategoriaTranslation::getCtaAttention).orElse("");
    }
    
    @Transient
    public String getCtaButtonText() {
        return getTranslation().map(CategoriaTranslation::getCtaButtonText).orElse("");
    }
    
    @Transient
    public String getHeroTitle() {
        return getTranslation().map(CategoriaTranslation::getHeroTitle).orElse("");
    }
    
    @Transient
    public String getHeroButtonText() {
        return getTranslation().map(CategoriaTranslation::getHeroButtonText).orElse("");
    }
    // --- FIM DOS MÉTODOS QUE FALTAVAM ---

    /**
     * Lógica central para encontrar a tradução.
     */
    @Transient
    private Optional<CategoriaTranslation> getTranslation() {
        String locale = LocaleContextHolder.getLocale().toLanguageTag();
        String defaultLocale = "pt-BR";
        
        return translations.stream()
                .filter(t -> t.getLocale().equalsIgnoreCase(locale))
                .findFirst()
                .or(() -> translations.stream()
                        .filter(t -> t.getLocale().equalsIgnoreCase(locale.split("-")[0]))
                        .findFirst())
                .or(() -> translations.stream()
                        .filter(t -> t.getLocale().equalsIgnoreCase(defaultLocale))
                        .findFirst())
                .or(() -> translations.stream().findFirst());
    }

    // --- GETTERS E SETTERS PADRÃO ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getImagemUrlHome() { return imagemUrlHome; }
    public void setImagemUrlHome(String imagemUrlHome) { this.imagemUrlHome = imagemUrlHome; }
    public String getImagemDestaqueUrl() { return imagemDestaqueUrl; }
    public void setImagemDestaqueUrl(String imagemDestaqueUrl) { this.imagemDestaqueUrl = imagemDestaqueUrl; }
    public String getUrlImagemPersonalizacao() { return urlImagemPersonalizacao; }
    public void setUrlImagemPersonalizacao(String urlImagemPersonalizacao) { this.urlImagemPersonalizacao = urlImagemPersonalizacao; }
    public List<CategoriaTranslation> getTranslations() { return translations; }
    public void setTranslations(List<CategoriaTranslation> translations) { this.translations = translations; }
    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}