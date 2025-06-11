package br.com.tatiart.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.i18n.LocaleContextHolder;

@Entity
public class TipoPersonalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // O campo 'titulo' foi removido daqui
    private String nomeIcone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "tipoPersonalizacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPersonalizacao> itens = new ArrayList<>();

    // Nova lista para as traduções
    @OneToMany(mappedBy = "tipoPersonalizacao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TipoPersonalizacaoTranslation> translations = new ArrayList<>();

    // Construtores
    public TipoPersonalizacao() { }

    // Método para buscar o título traduzido
    @Transient
    public String getTitulo() {
        String locale = LocaleContextHolder.getLocale().toLanguageTag();
        return getTranslation(locale).map(TipoPersonalizacaoTranslation::getTitulo).orElse("Título");
    }

    @Transient
    private Optional<TipoPersonalizacaoTranslation> getTranslation(String locale) {
        return translations.stream()
                .filter(t -> t.getLocale().equalsIgnoreCase(locale))
                .findFirst()
                .or(() -> translations.stream()
                        .filter(t -> t.getLocale().equals("pt-BR")) // Fallback para pt-BR
                        .findFirst());
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeIcone() { return nomeIcone; }
    public void setNomeIcone(String nomeIcone) { this.nomeIcone = nomeIcone; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public List<ItemPersonalizacao> getItens() { return itens; }
    public void setItens(List<ItemPersonalizacao> itens) { this.itens = itens; }
    public List<TipoPersonalizacaoTranslation> getTranslations() { return translations; }
    public void setTranslations(List<TipoPersonalizacaoTranslation> translations) { this.translations = translations; }
}