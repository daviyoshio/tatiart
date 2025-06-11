package br.com.tatiart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item_personalizacao_translations")
public class ItemPersonalizacaoTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String locale;

    @Column(nullable = false)
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_personalizacao_id", nullable = false)
    private ItemPersonalizacao itemPersonalizacao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public ItemPersonalizacao getItemPersonalizacao() { return itemPersonalizacao; }
    public void setItemPersonalizacao(ItemPersonalizacao itemPersonalizacao) { this.itemPersonalizacao = itemPersonalizacao; }
}