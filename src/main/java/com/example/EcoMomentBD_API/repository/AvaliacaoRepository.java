package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.AvaliacaoModel;
import com.example.EcoMomentBD_API.model.doubleKey.AvaliacaoEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, AvaliacaoEmbeddableModel> {
    @Modifying
    @Query(value = "INSERT INTO cl202247.prototipo_Avaliacao_EcoMoment (idPostagem, idUsuarioWeb, valor) VALUES (?1, ?2, ?3)", nativeQuery = true)
    public void saveAvaliacao(int idPostagem, int idUsuarioWeb, int valor);

    @Modifying
    @Query(value = "UPDATE cl202247.prototipo_Postagem_EcoMoment SET qtdeAvaliacoesPostagem = qtdeAvaliacoesPostagem + 1 WHERE idPostagem = ?1", nativeQuery = true)
    public void atualizarQtdeAvaliacoesPostagem(int idPostagem);

    @Query(value = "SELECT count(idUsuarioWeb) AS numero FROM cl202247.prototipo_Avaliacao_EcoMoment WHERE idPostagem = ?1", nativeQuery = true)
    public float countUsuariosWeb(int idPostagem);

    @Query(value = "SELECT sum(valor) AS soma FROM cl202247.prototipo_Avaliacao_EcoMoment WHERE idPostagem = ?1", nativeQuery = true)
    public float somaValorAvaliacao(int idPostagem);

    @Modifying
    @Query(value = "UPDATE cl202247.prototipo_Postagem_EcoMoment SET avaliacaoPostagem = ?1 WHERE idPostagem = ?2", nativeQuery = true)
    public void atualizarMediaAvaliacaoPostagem(float media, int idPostagem);

    //Segunda parte

    @Query(value = "SELECT count(idPostagem) AS numero FROM cl202247.prototipo_Postagem_EcoMoment WHERE nomeUsuario = ?1 AND avaliacaoPostagem !=0", nativeQuery = true)
    public float countPostagensPorUsuario(String nomeUsuario);

    @Query(value = "SELECT sum(avaliacaoPostagem) AS soma FROM cl202247.prototipo_Postagem_EcoMoment WHERE nomeUsuario = ?1", nativeQuery = true)
    public float somaAvaliacaoPostagem(String nomeUsuario);

    @Modifying
    @Query(value = "UPDATE cl202247.EcoMomentBD_UsuarioWeb SET Reputacao = ?1 WHERE NomeWeb = ?2", nativeQuery = true)
    public void atualizarReputacaoUsuario(float rep, String nomeWeb);

    @Query(value = "SELECT * FROM cl202247.prototipo_Avaliacao_EcoMoment WHERE idPostagem = ?1 AND idUsuarioWeb = ?2", nativeQuery = true)
    public Optional<AvaliacaoModel> isRated(int idPostagem, int idUsuarioWeb);

    //reavaliação

    @Modifying
    @Query(value = "UPDATE cl202247.prototipo_Avaliacao_EcoMoment SET valor = ?1 WHERE idPostagem = ?2 AND idUsuarioWeb = ?3", nativeQuery = true)
    public void atualizarValor(int valor, int idPostagem, int idUsuarioWeb);

}
