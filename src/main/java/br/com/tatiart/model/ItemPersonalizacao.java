package br.com.tatiart.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.i18n.LocaleContextHolder;

@Entity
public class ItemPersonalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // O campo 'texto' foi removido daqui

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_personalizacao_id")
    private TipoPersonalizacao tipoPersonalizacao;

    // Nova lista para as traduções
    @OneToMany(mappedBy = "itemPersonalizacao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ItemPersonalizacaoTranslation> translations = new ArrayList<>();

    // Construtor vazio é necessário para o JPA
    public ItemPersonalizacao() {}

    // Método para buscar o texto traduzido
    @Transient
    public String getTexto() {
        String locale = LocaleContextHolder.getLocale().toLanguageTag();
        return getTranslation(locale).map(ItemPersonalizacaoTranslation::getTexto).orElse("Item");
    }

    @Transient
    private Optional<ItemPersonalizacaoTranslation> getTranslation(String locale) {
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
    public TipoPersonalizacao getTipoPersonalizacao() { return tipoPersonalizacao; }
    public void setTipoPersonalizacao(TipoPersonalizacao tipoPersonalizacao) { this.tipoPersonalizacao = tipoPersonalizacao; }
    public List<ItemPersonalizacaoTranslation> getTranslations() { return translations; }
    public void setTranslations(List<ItemPersonalizacaoTranslation> translations) { this.translations = translations; }
}