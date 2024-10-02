package com.example.EcoMomentBD_API.model;

import com.example.EcoMomentBD_API.model.doubleKey.SeguidorEmbeddableModel;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "prototipo_Seguidores_EcoMoment")
public class SeguidorModel {
    @EmbeddedId
    private SeguidorEmbeddableModel id;

    public SeguidorEmbeddableModel getId() {
        return id;
    }

    public void setId(SeguidorEmbeddableModel id) {
        this.id = id;
    }
}
