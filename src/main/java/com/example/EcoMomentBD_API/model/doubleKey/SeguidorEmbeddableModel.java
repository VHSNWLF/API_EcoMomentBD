package com.example.EcoMomentBD_API.model.doubleKey;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeguidorEmbeddableModel implements Serializable {
    private int idSeguido;
    private int idSeguidor;

    public SeguidorEmbeddableModel() {
    }

    public SeguidorEmbeddableModel(int idSeguido, int idSeguidor) {
        this.idSeguido = idSeguido;
        this.idSeguidor = idSeguidor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeguidorEmbeddableModel that = (SeguidorEmbeddableModel) o;
        return idSeguido == that.idSeguido && idSeguidor == that.idSeguidor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeguido, idSeguidor);
    }

    public int getIdSeguido() {
        return idSeguido;
    }

    public void setIdSeguido(int idSeguido) {
        this.idSeguido = idSeguido;
    }

    public int getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(int idSeguidor) {
        this.idSeguidor = idSeguidor;
    }
}
