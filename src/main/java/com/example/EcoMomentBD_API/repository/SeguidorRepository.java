package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.SeguidorModel;
import com.example.EcoMomentBD_API.model.UsuarioWebModel;
import com.example.EcoMomentBD_API.model.doubleKey.SeguidorEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeguidorRepository extends JpaRepository<SeguidorModel, SeguidorEmbeddableModel> {
    @Query(value = "SELECT * FROM cl202247.prototipo_Seguidores_EcoMoment where idSeguidor = ?1", nativeQuery = true)
    public List<Integer> findIdSeguindo(int id);

    @Query(value = "SELECT NomeWeb FROM cl202247.EcoMomentBD_UsuarioWeb where idUsuarioWeb in ?1;", nativeQuery = true)
    public List<String> findNomeWebById(List<Integer> id);


    //Achar o idSeguido, ou seja, o id do usuario das ideias
    @Query(value = "SELECT idUsuarioWeb FROM cl202247.EcoMomentBD_UsuarioWeb WHERE NomeWeb = ?1", nativeQuery = true)
    public Integer acharIdSeguidoByNomeWeb(String nomeWeb);

    //Função Seguir:

    //adicionar na tabela de seguidor
    @Modifying
    @Query(value = "INSERT INTO cl202247.prototipo_Seguidores_EcoMoment (idSeguido, idSeguidor) values (?1, ?2)", nativeQuery = true)
    public void add_TabelaSeguidor(int idSeguido, int idSeguidor);

    //atualizar qtdeSeguidores do idSeguido
    @Modifying
    @Query(value = "UPDATE cl202247.EcoMomentBD_UsuarioWeb SET qtdeSeguidores = qtdeSeguidores + 1 WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void add_QtdeSeguidores(int idSeguido);

    //atualizar qtdeSeguindo do idSeguidor
    @Modifying
    @Query(value = "UPDATE EcoMomentBD_UsuarioWeb SET qtdeSeguindo = qtdeSeguindo + 1 WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void add_QtdeSeguindo(int idSeguidor);

    //Função unfollow

    // Remover da tabela de seguidor
    @Modifying
    @Query(value = "DELETE FROM cl202247.prototipo_Seguidores_EcoMoment WHERE idSeguido = ?1 AND idSeguidor = ?2", nativeQuery = true)
    public void del_TabelaSeguidor(int idSeguido, int idSeguidor);

    // Atualizar remove_qtdeSeguidores do idSeguido (diminuir)
    @Modifying
    @Query(value = "UPDATE cl202247.EcoMomentBD_UsuarioWeb SET qtdeSeguidores = qtdeSeguidores - 1 WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void del_QtdeSeguidores(int idSeguido);

    // Atualizar qtdeSeguindo do idSeguidor (diminuir)
    @Modifying
    @Query(value = "UPDATE EcoMomentBD_UsuarioWeb SET qtdeSeguindo = qtdeSeguindo - 1 WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void del_QtdeSeguindo(int idSeguidor);

    //Ver seguindo
    @Query(value = "SELECT * FROM EcoMomentBD_UsuarioWeb INNER JOIN prototipo_Seguidores_EcoMoment on prototipo_Seguidores_EcoMoment.idSeguido = EcoMomentBD_UsuarioWeb.idUsuarioWeb  where prototipo_Seguidores_EcoMoment.idSeguidor = ?1", nativeQuery = true)
    public List<Object []> verTodosSeguindo(int idUsuarioWeb);

    //Ver Seguidores
    @Query(value = "SELECT * FROM EcoMomentBD_UsuarioWeb INNER JOIN prototipo_Seguidores_EcoMoment on prototipo_Seguidores_EcoMoment.idSeguidor = EcoMomentBD_UsuarioWeb.idUsuarioWeb where prototipo_Seguidores_EcoMoment.idSeguido = ?1", nativeQuery = true)
    public List<Object []> verTodosSeguidores(int idUsuarioWeb);

    //isFollower?
    @Query(value = "SELECT * FROM cl202247.prototipo_Seguidores_EcoMoment where idSeguidor = ?1 and idSeguido = ?2", nativeQuery = true)
    public Integer isFollower(int MeuIdUsuarioWeb, int UsuarioIdSeguido);


}
