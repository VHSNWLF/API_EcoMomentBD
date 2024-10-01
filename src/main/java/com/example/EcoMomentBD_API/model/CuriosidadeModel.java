package com.example.EcoMomentBD_API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "prototipo_Curiosidades_EcoMoment")
public class CuriosidadeModel {

    @Id
    private int idCuriosidade;

    @Column
    private String titulo;

    @Column
    private String conteudo;

    public int getIdCuriosidade() {
        return idCuriosidade;
    }

    public void setIdCuriosidade(int idCuriosidade) {
        this.idCuriosidade = idCuriosidade;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
