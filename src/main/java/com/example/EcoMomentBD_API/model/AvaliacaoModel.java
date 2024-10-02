package com.example.EcoMomentBD_API.model;

import com.example.EcoMomentBD_API.model.doubleKey.AvaliacaoEmbeddableModel;
import jakarta.persistence.*;

@Entity
@Table (name = "prototipo_Avaliacao_EcoMoment")
public class AvaliacaoModel {
    @EmbeddedId
    private AvaliacaoEmbeddableModel id; //Referência à chave composta embutida

    @Column (name = "valor")
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public AvaliacaoEmbeddableModel getId() {
        return id;
    }

    public void setId(AvaliacaoEmbeddableModel id) {
        this.id = id;
    }

}
