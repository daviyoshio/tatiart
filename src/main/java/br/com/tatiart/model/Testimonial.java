package br.com.tatiart.model;

public class Testimonial {

    private String nome;
    private String inicial;
    private String contexto;
    private String mensagem;
    private String imagem;
    private String corFundo;
    private String borda;
    private Integer nota;

    public Testimonial() {
    }

    public Testimonial(String nome, String inicial, String contexto, String mensagem, String imagem, String corFundo, String borda, Integer nota) {
        this.nome = nome;
        this.inicial = inicial;
        this.contexto = contexto;
        this.mensagem = mensagem;
        this.imagem = imagem;
        this.corFundo = corFundo;
        this.borda = borda;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(String corFundo) {
        this.corFundo = corFundo;
    }

    public String getBorda() {
        return borda;
    }

    public void setBorda(String borda) {
        this.borda = borda;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
    
    

}
