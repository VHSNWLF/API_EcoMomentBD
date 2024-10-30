package com.example.EcoMomentBD_API.model;

import jakarta.persistence.*;

@Entity
@Table (name = "prototipo_Postagem_EcoMoment")
public class PostagemModel {

    @Id
    private int idPostagem;

    @Column
    private String nomePostagem;

    @Column
    private String nomeUsuario;

    @Column
    private String descricaoPostagem;

    @Column
    private String materiaisNecessariosPostagem;

    @Column
    private String instrucoesPostagem;

    @Column
    private String dificuldadePostagem;

    @Lob
    private byte[] midia1;

    @Lob
    private byte[] midia2;

    @Lob
    private byte[] midia3;

    @Lob
    private byte[] midia4;

    @Lob
    private byte[] midia5;

    @Lob
    private byte[] midia6;

    @Lob
    private byte[] midia7;

    @Lob
    private byte[] midia8;

    @Lob
    private byte[] midia9;

    @Lob
    private byte[] midia10;

    @Column
    private int numeroCurtidas;

    @Column
    private int materialPostagem;

    @Column
    private int qtdeAvaliacoesPostagem;

    @Column
    private int qtdeComentarios;

    @Column
    private float avaliacaoPostagem;


    public int getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(int idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getNomePostagem() {
        return nomePostagem;
    }

    public void setNomePostagem(String nomePostagem) {
        this.nomePostagem = nomePostagem;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDescricaoPostagem() {
        return descricaoPostagem;
    }

    public void setDescricaoPostagem(String descricaoPostagem) {
        this.descricaoPostagem = descricaoPostagem;
    }

    public String getMateriaisNecessariosPostagem() {
        return materiaisNecessariosPostagem;
    }

    public void setMateriaisNecessariosPostagem(String materiaisNecessariosPostagem) {
        this.materiaisNecessariosPostagem = materiaisNecessariosPostagem;
    }

    public String getInstrucoesPostagem() {
        return instrucoesPostagem;
    }

    public void setInstrucoesPostagem(String instrucoesPostagem) {
        this.instrucoesPostagem = instrucoesPostagem;
    }

    public String getDificuldadePostagem() {
        return dificuldadePostagem;
    }

    public void setDificuldadePostagem(String dificuldadePostagem) {
        this.dificuldadePostagem = dificuldadePostagem;
    }

    public byte[] getMidia1() {
        return midia1;
    }

    public void setMidia1(byte[] midia1) {
        this.midia1 = midia1;
    }

    public byte[] getMidia2() {
        return midia2;
    }

    public void setMidia2(byte[] midia2) {
        this.midia2 = midia2;
    }

    public byte[] getMidia3() {
        return midia3;
    }

    public void setMidia3(byte[] midia3) {
        this.midia3 = midia3;
    }

    public byte[] getMidia4() {
        return midia4;
    }

    public void setMidia4(byte[] midia4) {
        this.midia4 = midia4;
    }

    public byte[] getMidia5() {
        return midia5;
    }

    public void setMidia5(byte[] midia5) {
        this.midia5 = midia5;
    }

    public byte[] getMidia6() {
        return midia6;
    }

    public void setMidia6(byte[] midia6) {
        this.midia6 = midia6;
    }

    public byte[] getMidia7() {
        return midia7;
    }

    public void setMidia7(byte[] midia7) {
        this.midia7 = midia7;
    }

    public byte[] getMidia8() {
        return midia8;
    }

    public void setMidia8(byte[] midia8) {
        this.midia8 = midia8;
    }

    public byte[] getMidia9() {
        return midia9;
    }

    public void setMidia9(byte[] midia9) {
        this.midia9 = midia9;
    }

    public byte[] getMidia10() {
        return midia10;
    }

    public void setMidia10(byte[] midia10) {
        this.midia10 = midia10;
    }

    public int getNumeroCurtidas() {
        return numeroCurtidas;
    }

    public void setNumeroCurtidas(int numeroCurtidas) {
        this.numeroCurtidas = numeroCurtidas;
    }

    public int getMaterialPostagem() {
        return materialPostagem;
    }

    public void setMaterialPostagem(int materialPostagem) {
        this.materialPostagem = materialPostagem;
    }

    public int getQtdeAvaliacoesPostagem() {
        return qtdeAvaliacoesPostagem;
    }

    public void setQtdeAvaliacoesPostagem(int qtdeAvaliacoesPostagem) {
        this.qtdeAvaliacoesPostagem = qtdeAvaliacoesPostagem;
    }

    public int getQtdeComentarios() {
        return qtdeComentarios;
    }

    public void setQtdeComentarios(int qtdeComentarios) {
        this.qtdeComentarios = qtdeComentarios;
    }

    public float getAvaliacaoPostagem() {
        return avaliacaoPostagem;
    }

    public void setAvaliacaoPostagem(float avaliacaoPostagem) {
        this.avaliacaoPostagem = avaliacaoPostagem;
    }
}
