package com.example.EcoMomentBD_API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "prototipo_Comentarios_EcoMoment")
public class ComentariosModel {

    @Id
    private int idComentario;

    @Column
    private int idPostagem;

    @Column
    private int idUsuarioWeb;

    @Column
    private String comentario;

    public int getId() {
        return idComentario;
    }

    public void setId(int id) {
        this.idComentario = id;
    }

    public int getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(int idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuarioWeb() {
        return idUsuarioWeb;
    }

    public void setIdUsuarioWeb(int idUsuarioWeb) {
        this.idUsuarioWeb = idUsuarioWeb;
    }
}
