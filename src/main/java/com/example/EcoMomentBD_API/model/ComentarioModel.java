package com.example.EcoMomentBD_API.model;

import jakarta.persistence.*;

@Entity
@Table (name = "prototipo_Comentarios_EcoMoment", schema = "cl202247")
public class ComentarioModel {

    @Id
    private int idComentario;

    @Column
    private int idPostagem;

    @Column
    private int idUsuarioWeb;

    @Column
    private String comentario;

    // Campos adicionais para manipulação, mas não persistidos
    @Transient
    private String NomeWeb;

    public String getNomeWeb() {
        return NomeWeb;
    }

    public void setNomeWeb(String nomeWeb) {
        NomeWeb = nomeWeb;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int id) {
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
