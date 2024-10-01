package com.example.EcoMomentBD_API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    @Column
    private String midia1;

    @Column
    private String midia2;

    @Column
    private String midia3;

    @Column
    private String midia4;

    @Column
    private String midia5;

    @Column
    private String midia6;

    @Column
    private String midia7;

    @Column
    private String midia8;

    @Column
    private String midia9;

    @Column
    private String midia10;

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

    public String getMidia1() {
        return midia1;
    }

    public void setMidia1(String midia1) {
        this.midia1 = midia1;
    }

    public String getMidia2() {
        return midia2;
    }

    public void setMidia2(String midia2) {
        this.midia2 = midia2;
    }

    public String getMidia3() {
        return midia3;
    }

    public void setMidia3(String midia3) {
        this.midia3 = midia3;
    }

    public String getMidia4() {
        return midia4;
    }

    public void setMidia4(String midia4) {
        this.midia4 = midia4;
    }

    public String getMidia5() {
        return midia5;
    }

    public void setMidia5(String midia5) {
        this.midia5 = midia5;
    }

    public String getMidia6() {
        return midia6;
    }

    public void setMidia6(String midia6) {
        this.midia6 = midia6;
    }

    public String getMidia7() {
        return midia7;
    }

    public void setMidia7(String midia7) {
        this.midia7 = midia7;
    }

    public String getMidia8() {
        return midia8;
    }

    public void setMidia8(String midia8) {
        this.midia8 = midia8;
    }

    public String getMidia9() {
        return midia9;
    }

    public void setMidia9(String midia9) {
        this.midia9 = midia9;
    }

    public String getMidia10() {
        return midia10;
    }

    public void setMidia10(String midia10) {
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
