/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tatiart.model;

/**
 *
 * @author daviyshiy
 */
public class CtaFinal {
    private String titulo;
    private String descricaoHtml;
    private String textoBotaoPrincipal;
    private String textoBotaoWhatsapp;
    private String infoEntrega;
    private String infoSatisfacao;
    private String infoAtendimento;
    private String alertaPrazo;

    public CtaFinal() {
    }

    public CtaFinal(String titulo, String descricaoHtml, String textoBotaoPrincipal, String textoBotaoWhatsapp, String infoEntrega, String infoSatisfacao, String infoAtendimento, String alertaPrazo) {
        this.titulo = titulo;
        this.descricaoHtml = descricaoHtml;
        this.textoBotaoPrincipal = textoBotaoPrincipal;
        this.textoBotaoWhatsapp = textoBotaoWhatsapp;
        this.infoEntrega = infoEntrega;
        this.infoSatisfacao = infoSatisfacao;
        this.infoAtendimento = infoAtendimento;
        this.alertaPrazo = alertaPrazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricaoHtml() {
        return descricaoHtml;
    }

    public void setDescricaoHtml(String descricaoHtml) {
        this.descricaoHtml = descricaoHtml;
    }

    public String getTextoBotaoPrincipal() {
        return textoBotaoPrincipal;
    }

    public void setTextoBotaoPrincipal(String textoBotaoPrincipal) {
        this.textoBotaoPrincipal = textoBotaoPrincipal;
    }

    public String getTextoBotaoWhatsapp() {
        return textoBotaoWhatsapp;
    }

    public void setTextoBotaoWhatsapp(String textoBotaoWhatsapp) {
        this.textoBotaoWhatsapp = textoBotaoWhatsapp;
    }

    public String getInfoEntrega() {
        return infoEntrega;
    }

    public void setInfoEntrega(String infoEntrega) {
        this.infoEntrega = infoEntrega;
    }

    public String getInfoSatisfacao() {
        return infoSatisfacao;
    }

    public void setInfoSatisfacao(String infoSatisfacao) {
        this.infoSatisfacao = infoSatisfacao;
    }

    public String getInfoAtendimento() {
        return infoAtendimento;
    }

    public void setInfoAtendimento(String infoAtendimento) {
        this.infoAtendimento = infoAtendimento;
    }

    public String getAlertaPrazo() {
        return alertaPrazo;
    }

    public void setAlertaPrazo(String alertaPrazo) {
        this.alertaPrazo = alertaPrazo;
    }
    
    
}

