package com.example.EcoMomentBD_API.model.doubleKey;

import java.io.Serializable;
import java.util.Objects;

public class SalvoEmbeddableModel implements Serializable {
    private int idPostagem;
    private int idUsuarioWeb;

    public SalvoEmbeddableModel() {
    }

    public SalvoEmbeddableModel(int idPostagem, int idUsuarioWeb) {
        this.idPostagem = idPostagem;
        this.idUsuarioWeb = idUsuarioWeb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalvoEmbeddableModel that = (SalvoEmbeddableModel) o;
        return idPostagem == that.idPostagem && idUsuarioWeb == that.idUsuarioWeb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPostagem, idUsuarioWeb);
    }

    public int getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(int idPostagem) {
        this.idPostagem = idPostagem;
    }

    public int getIdUsuarioWeb() {
        return idUsuarioWeb;
    }

    public void setIdUsuarioWeb(int idUsuarioWeb) {
        this.idUsuarioWeb = idUsuarioWeb;
    }
}