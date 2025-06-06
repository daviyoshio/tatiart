package br.com.tatiart.model;

import java.util.List;

public class ProdutoView {

    private String titulo;
    private String descricao;
    private String[] beneficios;
    private String[] imagens;
    private String[] atributos;
    private String banner;

    private List<Feature> features;
    
    // → Novo campo extraInfo
    private String extraInfo;

    public ProdutoView() {
    }

    public ProdutoView(String titulo, String descricao, String[] beneficios, String[] imagens, String[] atributos, String banner) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.beneficios = beneficios;
        this.imagens = imagens;
        this.atributos = atributos;
        this.banner = banner;
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
