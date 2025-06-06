/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.tatiart.model;

public class Feature {
    private String icon;      // caminho ou nome do ícone (por exemplo: "palette", "heart" etc.)
    private String titulo;    // título do recurso
    private String descricao; // texto explicativo

    public Feature() { }

    public Feature(String icon, String titulo, String descricao) {
        this.icon = icon;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
}

