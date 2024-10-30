package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.CurtidaModel;
import com.example.EcoMomentBD_API.model.doubleKey.CurtidaEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CurtidaRepository extends JpaRepository<CurtidaModel, CurtidaEmbeddableModel> {
    @Query(value = "SELECT * FROM cl202247.prototipo_Curtidas_EcoMoment where idUsuarioWeb = ?1 and idPostagem = ?2", nativeQuery = true)
    public Optional<CurtidaModel> findByIdUsuarioWebAndIdPostagem(int idUsuarioWeb, int idPostagem);

    //função Curtir - 3 ETAPAS [Adicionar ao banco de dados de curtida][Atualizar o numero de curtidas da postagem][Atualizar o numero de curtidas do usuario que fez o post]

    // [Adicionar ao banco de dados de curtida]
    @Modifying
    @Query(value = "INSERT INTO cl202247.prototipo_Curtidas_EcoMoment (idPostagem, idUsuarioWeb) VALUES (?1, ?2)", nativeQuery = true)
    public void curtiuFunction(int idPostagem, int idUsuarioWebCurtiu);

    // [Atualizar o numero de curtidas da postagem]
    @Modifying
    @Query(value = "UPDATE cl202247.prototipo_Postagem_EcoMoment SET numeroCurtidas = numeroCurtidas + 1 WHERE idPostagem = ?1", nativeQuery = true)
    public void atualizarNCurtidaPostagemByIdPostagem(int idPostagem);


    //Buscando o id do usuario que fez o post, a partir do nomeUsuario, para poder fazer a ultima etapa
    @Query(value = "SELECT idUsuarioWeb from cl202247.EcoMomentBD_UsuarioWeb WHERE NomeWeb = ?1", nativeQuery = true)
    public Integer buscarIdUsuarioDonoByNomeWeb(String nomeWeb);


    //[Atualizar o numero de curtidas do usuario que fez o post]
    @Modifying
    @Query(value = "UPDATE cl202247.EcoMomentBD_UsuarioWeb SET qtdeCurtidas = qtdeCurtidas + 1 WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void atualizarNCurtidaUsuarioByIdUsuarioDono(int idUsuarioDono);

    //Função descurtir - 3 ETAPAS [Remover ao banco de dados de curtida][Atualizar o numero de curtidas da postagem][Atualizar o numero de curtidas do usuario que fez o post]

    // [Remover do banco de dados de curtida]
    @Modifying
    @Query(value = "DELETE FROM cl202247.prototipo_Curtidas_EcoMoment WHERE idPostagem = ?1 AND idUsuarioWeb = ?2", nativeQuery = true)
    void descurtirFunction(int idPostagem, int idUsuarioWebCurtiu);

    // [Atualizar o número de curtidas da postagem]
    @Modifying
    @Query(value = "UPDATE cl202247.prototipo_Postagem_EcoMoment SET numeroCurtidas = numeroCurtidas - 1 WHERE idPostagem = ?1", nativeQuery = true)
    void atualizarPostagemByDescurtirFunction(int idPostagem);

    // [Buscar o id do usuário que fez o post a partir do nomeUsuarioDono]
    // @Query(value = "SELECT idUsuarioWeb FROM cl202247.EcoMomentBD_UsuarioWeb WHERE NomeWeb = ?1", nativeQuery = true)
    //Integer buscarIdUsuarioDonoByNomeWeb(String nomeUsuarioDono);

    // [Atualizar o número de curtidas do usuário dono do post]
    @Modifying
    @Query(value = "UPDATE cl202247.EcoMomentBD_UsuarioWeb SET qtdeCurtidas = qtdeCurtidas - 1 WHERE idUsuarioWeb = ?1", nativeQuery = true)
    void atualizarUsuarioByDescurtirFunction(int idUsuarioDono);
}
