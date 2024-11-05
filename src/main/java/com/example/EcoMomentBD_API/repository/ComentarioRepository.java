package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, Integer> {
    @Query(value = "SELECT prototipo_Comentarios_EcoMoment.idComentario, prototipo_Comentarios_EcoMoment.comentario, EcoMomentBD_UsuarioWeb.NomeWeb, EcoMomentBD_UsuarioWeb.idUsuarioWeb FROM cl202247.prototipo_Comentarios_EcoMoment INNER JOIN EcoMomentBD_UsuarioWeb on prototipo_Comentarios_EcoMoment.idUsuarioWeb = EcoMomentBD_UsuarioWeb.idUsuarioWeb WHERE prototipo_Comentarios_EcoMoment.idPostagem = ?1 ORDER BY prototipo_Comentarios_EcoMoment.idComentario DESC", nativeQuery = true)
    public List<Object[]> comentariosByIdPostagem(int idPostagem);

    //função de comentar
    @Modifying
    @Query(value = "INSERT INTO prototipo_Comentarios_EcoMoment (idPostagem, idUsuarioWeb, comentario) values (?1, ?2, ?3)", nativeQuery = true)
    public void comentar(int idPostagem, int idUsuarioWeb, String comentario);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Comentarios_EcoMoment WHERE idPostagem = ?1 AND idUsuarioWeb = ?2 AND comentario = ?3", nativeQuery = true)
    public void deletarComentario(int idPostagem, int idUsuarioWeb, String comentario);

    @Modifying
    @Query(value = "UPDATE prototipo_Postagem_EcoMoment SET qtdeComentarios = qtdeComentarios + 1 WHERE idPostagem = ?1", nativeQuery = true)
    public void updateQtdeComentariosPostagem(int idPostagem);

    @Modifying
    @Query(value = "UPDATE prototipo_Postagem_EcoMoment SET qtdeComentarios = qtdeComentarios - 1 WHERE idPostagem = ?1", nativeQuery = true)
    public void updateDelQtdeComentariosPostagem(int idPostagem);
}
