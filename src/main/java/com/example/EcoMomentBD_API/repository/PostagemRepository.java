package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
