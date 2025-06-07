package br.com.tatiart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String imagem;
    private String fraseCta;      // ex: "❤️ SIM! Quero Criar Minha Caneca Agora"
    private String frasePrazo; 

    public Produto(Long id, String nome, String descricao, String imagem, String fraseCta, String frasePrazo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.fraseCta = fraseCta;
        this.frasePrazo = frasePrazo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getFraseCta() {
        return fraseCta;
    }

    public void setFraseCta(String fraseCta) {
        this.fraseCta = fraseCta;
    }

    public String getFrasePrazo() {
        return frasePrazo;
    }

    public void setFrasePrazo(String frasePrazo) {
        this.frasePrazo = frasePrazo;
    }
    
// ex: "⚡ ATENÇÃO: Devido à alta demanda, estamos com prazo de entrega..."

    public Produto() {
    }


}