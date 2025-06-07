/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tatiart.model;

/**
 *
 * @author daviyshiy
 */
public class ChamadaAcoes {
    private String botaoPrincipal;
    private String botaoWhatsapp;
    private String beneficiosRapidos;
    private String mensagemAviso;

    public ChamadaAcoes() {
    }

    public ChamadaAcoes(String botaoPrincipal, String botaoWhatsapp, String beneficiosRapidos, String mensagemAviso) {
        this.botaoPrincipal = botaoPrincipal;
        this.botaoWhatsapp = botaoWhatsapp;
        this.beneficiosRapidos = beneficiosRapidos;
        this.mensagemAviso = mensagemAviso;
    }

    public String getBotaoPrincipal() {
        return botaoPrincipal;
    }

    public void setBotaoPrincipal(String botaoPrincipal) {
        this.botaoPrincipal = botaoPrincipal;
    }

    public String getBotaoWhatsapp() {
        return botaoWhatsapp;
    }

    public void setBotaoWhatsapp(String botaoWhatsapp) {
        this.botaoWhatsapp = botaoWhatsapp;
    }

    public String getBeneficiosRapidos() {
        return beneficiosRapidos;
    }

    public void setBeneficiosRapidos(String beneficiosRapidos) {
        this.beneficiosRapidos = beneficiosRapidos;
    }

    public String getMensagemAviso() {
        return mensagemAviso;
    }

    public void setMensagemAviso(String mensagemAviso) {
        this.mensagemAviso = mensagemAviso;
    }
    
    
}

