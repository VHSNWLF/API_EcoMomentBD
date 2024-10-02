package com.example.EcoMomentBD_API.model;

import com.example.EcoMomentBD_API.model.doubleKey.SalvoEmbeddableModel;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "prototipo_Salvos_EcoMoment")
public class SalvoModel {
    @EmbeddedId
    private SalvoEmbeddableModel id;

    public SalvoEmbeddableModel getId() {
        return id;
    }

    public void setId(SalvoEmbeddableModel id) {
        this.id = id;
    }
}
