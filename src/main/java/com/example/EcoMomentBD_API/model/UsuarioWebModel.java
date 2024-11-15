package com.example.EcoMomentBD_API.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EcoMomentBD_UsuarioWeb")
public class UsuarioWebModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuarioWeb")  // Mapeia a coluna "idUsuarioWeb" da tabela
    private int idUsuarioWeb;

    @Column(name = "NomeWeb") // Mapeia a coluna "NomeWeb"
    private String nomeWeb;

    @Column(name = "EmailWeb") // Mapeia a coluna "EmailWeb"
    private String emailWeb;

    @Column(name = "SenhaWeb") // Mapeia a coluna "SenhaWeb"
    private String senhaWeb;

    @Column(name = "qtdeSeguidores")  // Mapeia a coluna "qtdeSeguidores" da tabela
    private int qtdeSeguidores;

    @Column(name = "qtdeSeguindo")  // Mapeia a coluna "qtdeSeguindo" da tabela
    private int qtdeSeguindo;

    @Column(name = "qtdeCurtidas")  // Mapeia a coluna "qtdeCurtidas" da tabela
    private int qtdeCurtidas;

    @Column(name = "qtdePostagens")  // Mapeia a coluna "qtdePostagens" da tabela
    private int qtdePostagens;

    @Column(name = "Reputacao")  // Mapeia a coluna "Reputacao" da tabela
    private float reputacao;

    @Column(name = "ativo")  // Mapeia a coluna "ativo" da tabela
    private int ativo;

    @Column(name = "Biografia")
    private String biografia;

    @Transient
    private int idSeguido;

    @Transient
    private int idSeguidor;

    @Lob // Mapeia a coluna "FotoPerfil"
    private byte[] fotoPerfil;

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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getIdUsuarioWeb() {
        return idUsuarioWeb;
    }

    public void setIdUsuarioWeb(int idUsuarioWeb) {
        this.idUsuarioWeb = idUsuarioWeb;
    }

    public String getNomeWeb() {
        return nomeWeb;
    }

    public void setNomeWeb(String nomeWeb) {
        this.nomeWeb = nomeWeb;
    }

    public String getEmailWeb() {
        return emailWeb;
    }

    public void setEmailWeb(String emailWeb) {
        this.emailWeb = emailWeb;
    }

    public String getSenhaWeb() {
        return senhaWeb;
    }

    public void setSenhaWeb(String senhaWeb) {
        this.senhaWeb = senhaWeb;
    }

    public int getQtdeSeguidores() {
        return qtdeSeguidores;
    }

    public void setQtdeSeguidores(int qtdeSeguidores) {
        this.qtdeSeguidores = qtdeSeguidores;
    }

    public int getQtdeSeguindo() {
        return qtdeSeguindo;
    }

    public void setQtdeSeguindo(int qtdeSeguindo) {
        this.qtdeSeguindo = qtdeSeguindo;
    }

    public int getQtdeCurtidas() {
        return qtdeCurtidas;
    }

    public void setQtdeCurtidas(int qtdeCurtidas) {
        this.qtdeCurtidas = qtdeCurtidas;
    }

    public int getQtdePostagens() {
        return qtdePostagens;
    }

    public void setQtdePostagens(int qtdePostagens) {
        this.qtdePostagens = qtdePostagens;
    }

    public float getReputacao() {
        return reputacao;
    }

    public void setReputacao(float reputacao) {
        this.reputacao = reputacao;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }


    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
