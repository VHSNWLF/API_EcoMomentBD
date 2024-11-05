package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostagemRepository extends JpaRepository<PostagemModel, Integer> {

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment WHERE nomeUsuario = ?1", nativeQuery = true)
    public List<PostagemModel> findByNomeUsuario(String nome);

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment WHERE nomePostagem = ?1", nativeQuery = true)
    public Optional<PostagemModel> findByNomePostagem(String nomePostagem);

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment WHERE materialPostagem = ?1", nativeQuery = true)
    public List<PostagemModel> findByMaterialPostagem(String materialPostagem);

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment order by numeroCurtidas desc limit 5", nativeQuery = true)
    public  List<PostagemModel> ideiasMaisAvaliadas_10();

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment WHERE materialPostagem = ?1 order by avaliacaoPostagem  desc", nativeQuery = true)
    public  List<PostagemModel> ideiasMaisAvaliadas(String materialPostagem);

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment WHERE materialPostagem = ?1 order by numeroCurtidas  desc", nativeQuery = true)
    public  List<PostagemModel> ideiasMaisCurtidas(String materialPostagem);

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment WHERE materialPostagem = ?1 ORDER BY CASE dificuldadePostagem WHEN 'facil' THEN 1 WHEN 'media' THEN 2 WHEN 'dificil' THEN 3 END ", nativeQuery = true)
    public  List<PostagemModel> ideiasMaisDificuldade(String materialPostagem);

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment where idPostagem IN ?1", nativeQuery = true)
    public  List<PostagemModel> listaIdeiasByIdPostagem(List<Integer> listaIdPostagem);

    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment where nomeUsuario in ?1", nativeQuery = true)
    public List<PostagemModel> listaIdeiasByNomeWeb(List<String> nomeWeb);

    //Postagens com mais numero de curtidas acima
    @Query(value = "SELECT * FROM cl202247.prototipo_Postagem_EcoMoment WHERE nomeUsuario = ?1 order by numeroCurtidas DESC", nativeQuery = true)
    public List<PostagemModel> findByNomeUsuarioOrderByNCurtidas(String nome);

    @Modifying
    @Query(value = "INSERT INTO cl202247.prototipo_Postagem_EcoMoment (nomePostagem, nomeUsuario, descricaoPostagem, materiaisNecessariosPostagem, instrucoesPostagem, materialPostagem, dificuldadePostagem, midia1, midia2, midia3, midia4, midia5, midia6, midia7, midia8, midia9, midia10) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17)", nativeQuery = true)
    public void publicarIdeia(String nomePostagem, String nomeUsuario, String desc, String matNecessarios, String passoPasso, int tipoMaterial, String dificuldade, byte[] img1, byte[] img2,byte[] img3,byte[] img4,byte[] img5,byte[] img6,byte[] img7,byte[] img8,byte[] img9,byte[] img10);

    //função excluir
    @Modifying
    @Query(value = "DELETE FROM prototipo_Avaliacao_EcoMoment WHERE idPostagem = ?1", nativeQuery = true)
    public void deleteAvalPostagem(int idPostagem);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Comentarios_EcoMoment WHERE idPostagem = ?1", nativeQuery = true)
    public void deleteComenPostagem(int idPostagem);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Curtidas_EcoMoment WHERE idPostagem = ?1", nativeQuery = true)
    public void deleteCurtPostagem(int idPostagem);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Salvos_EcoMoment WHERE idPostagem = ?1", nativeQuery = true)
    public void deleteSalvPostagem(int idPostagem);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Postagem_EcoMoment WHERE idPostagem = ?1", nativeQuery = true)
    public void deletePostagem(int idPostagem);

    @Modifying
    @Query(value = "UPDATE EcoMomentBD_UsuarioWeb SET qtdePostagens = qtdePostagens - 1 WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void deleteUpdateUsuarioWebPostagem(int idUsuarioWeb);

}
