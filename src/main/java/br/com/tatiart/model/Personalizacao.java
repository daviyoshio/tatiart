/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tatiart.model;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author daviyshiy
 */
public class Personalizacao {
    private String titulo;
    private String icone;
    private String corFundoIcone;
    private String corIcone;
    private List<String> itens;

    public Personalizacao() {
    }

    public Personalizacao(String titulo, String icone, String corFundoIcone, String corIcone, List<String> itens) {
        this.titulo = titulo;
        this.icone = icone;
        this.corFundoIcone = corFundoIcone;
        this.corIcone = corIcone;
        this.itens = itens;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getCorFundoIcone() {
        return corFundoIcone;
    }

    public void setCorFundoIcone(String corFundoIcone) {
        this.corFundoIcone = corFundoIcone;
    }

    public String getCorIcone() {
        return corIcone;
    }

    public void setCorIcone(String corIcone) {
        this.corIcone = corIcone;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }
    
    
    
    

}
