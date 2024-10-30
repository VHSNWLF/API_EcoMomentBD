package com.example.EcoMomentBD_API.model.DTO;

public class UsuarioUpdateDTO {
    private byte[] foto;
    private String nome;
    private String biografia;
    private int idUsuarioWeb;

    public int getIdUsuarioWeb() {
        return idUsuarioWeb;
    }

    public void setIdUsuarioWeb(int idUsuarioWeb) {
        this.idUsuarioWeb = idUsuarioWeb;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
