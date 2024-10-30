package com.example.EcoMomentBD_API.model;

import com.example.EcoMomentBD_API.model.doubleKey.CurtidaEmbeddableModel;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "prototipo_Curtidas_EcoMoment")
public class CurtidaModel {
    @EmbeddedId
    private CurtidaEmbeddableModel id; //Referência à chave composta embutida

    public CurtidaEmbeddableModel getId() {
        return id;
    }

    public void setId(CurtidaEmbeddableModel id) {
        this.id = id;
    }

}
