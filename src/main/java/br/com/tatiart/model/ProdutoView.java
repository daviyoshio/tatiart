package br.com.tatiart.model;

import java.util.List;

public class ProdutoView {

    private String titulo;
    private String descricao;
    private String[] beneficios;
    private String[] imagens;
    private String[] atributos;
    private String banner;
    private String categoria;
    private List<Testimonial> depoimentos;
    private List<Personalizacao> personalizacoes;
    private List<Feature> features;
    private String extraInfo;

    public ProdutoView() {
    }

    public ProdutoView(String titulo, String descricao, String[] beneficios, String[] imagens, String[] atributos, String banner, String categoria, List<Testimonial> depoimentos, List<Personalizacao> personalizacoes, List<Feature> features, String extraInfo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.beneficios = beneficios;
        this.imagens = imagens;
        this.atributos = atributos;
        this.banner = banner;
        this.categoria = categoria;
        this.depoimentos = depoimentos;
        this.personalizacoes = personalizacoes;
        this.features = features;
        this.extraInfo = extraInfo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[] getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String[] beneficios) {
        this.beneficios = beneficios;
    }

    public String[] getImagens() {
        return imagens;
    }

    public void setImagens(String[] imagens) {
        this.imagens = imagens;
    }

    public String[] getAtributos() {
        return atributos;
    }

    public void setAtributos(String[] atributos) {
        this.atributos = atributos;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Testimonial> getDepoimentos() {
        return depoimentos;
    }

    public void setDepoimentos(List<Testimonial> depoimentos) {
        this.depoimentos = depoimentos;
    }

    public List<Personalizacao> getPersonalizacoes() {
        return personalizacoes;
    }

    public void setPersonalizacoes(List<Personalizacao> personalizacoes) {
        this.personalizacoes = personalizacoes;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
    
    

}