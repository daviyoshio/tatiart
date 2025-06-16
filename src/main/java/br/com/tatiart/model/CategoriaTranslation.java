package br.com.tatiart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria_translations")
public class CategoriaTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define o idioma desta tradução (ex: "pt_BR", "en_US")
    @Column(nullable = false)
    private String locale;

    // --- Campos que foram movidos da Categoria para cá ---
    @Column(nullable = false)
    private String nomeSingular;

    @Column(nullable = false)
    private String nomePlural;

    @Column(length = 500)
    private String descricao;
    
    private String ctaTitle;
    
    @Column(length = 500)
    private String ctaDescription;
    
    @Column(length = 500)
    private String ctaAttention;

    private String ctaButtonText;

    @Column(length = 500)
    private String heroTitle;

    private String heroButtonText;
    
    @Column(length = 500)
    private String galeriaTitle;

    @Column(length = 500)
    private String galeriaDescricao;
    
    // Relacionamento de volta para a Categoria principal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Getters e Setters para todos os campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getNomeSingular() {
        return nomeSingular;
    }

    public void setNomeSingular(String nomeSingular) {
        this.nomeSingular = nomeSingular;
    }

    public String getNomePlural() {
        return nomePlural;
    }

    public void setNomePlural(String nomePlural) {
        this.nomePlural = nomePlural;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCtaTitle() {
        return ctaTitle;
    }

    public void setCtaTitle(String ctaTitle) {
        this.ctaTitle = ctaTitle;
    }

    public String getCtaDescription() {
        return ctaDescription;
    }

    public void setCtaDescription(String ctaDescription) {
        this.ctaDescription = ctaDescription;
    }

    public String getCtaAttention() {
        return ctaAttention;
    }

    public void setCtaAttention(String ctaAttention) {
        this.ctaAttention = ctaAttention;
    }

    public String getCtaButtonText() {
        return ctaButtonText;
    }

    public void setCtaButtonText(String ctaButtonText) {
        this.ctaButtonText = ctaButtonText;
    }

    public String getHeroTitle() {
        return heroTitle;
    }

    public void setHeroTitle(String heroTitle) {
        this.heroTitle = heroTitle;
    }

    public String getHeroButtonText() {
        return heroButtonText;
    }

    public void setHeroButtonText(String heroButtonText) {
        this.heroButtonText = heroButtonText;
    }

    public String getGaleriaTitle() {
        return galeriaTitle;
    }

    public void setGaleriaTitle(String galeriaTitle) {
        this.galeriaTitle = galeriaTitle;
    }

    public String getGaleriaDescricao() {
        return galeriaDescricao;
    }

    public void setGaleriaDescricao(String galeriaDescricao) {
        this.galeriaDescricao = galeriaDescricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
  
}