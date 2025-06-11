package br.com.tatiart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_personalizacao_translations")
public class TipoPersonalizacaoTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String locale;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_personalizacao_id", nullable = false)
    private TipoPersonalizacao tipoPersonalizacao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public TipoPersonalizacao getTipoPersonalizacao() { return tipoPersonalizacao; }
    public void setTipoPersonalizacao(TipoPersonalizacao tipoPersonalizacao) { this.tipoPersonalizacao = tipoPersonalizacao; }
}