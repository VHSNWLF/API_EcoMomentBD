package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.UsuarioWebModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioWebRepository extends JpaRepository<UsuarioWebModel, Integer> {
    @Query(value = "Select * from cl202247.EcoMomentBD_UsuarioWeb where NomeWeb = ?1 or EmailWeb = ?2", nativeQuery = true)
    public List<UsuarioWebModel> findByNomeAndEmail(String nome, String email);

    @Query(value = "Select * from cl202247.EcoMomentBD_UsuarioWeb where EmailWeb = ?1", nativeQuery = true)
    public Optional<UsuarioWebModel> findByEmail(String email);

    @Query(value = "Select * from cl202247.EcoMomentBD_UsuarioWeb where NomeWeb = ?1", nativeQuery = true)
    public Optional<UsuarioWebModel> findByNomeWeb(String nomeWeb);

    @Query(value = "Select * from cl202247.EcoMomentBD_UsuarioWeb where (NomeWeb = ?1 or EmailWeb = ?1) and (SenhaWeb = ?2 and ativo = 1)", nativeQuery = true)
    public Optional<UsuarioWebModel> findByEmailOrUsernameAndSenha(String emailOrUsername, String senha);

    @Query(value = "Select * from cl202247.EcoMomentBD_UsuarioWeb where idUsuarioWeb in ?1", nativeQuery = true)
    public List<Integer> findByIdUsuarioSeguindo(List<Integer> listaIdUsuarioSeguindo);

    @Modifying
    @Query(value = "UPDATE cl202247.EcoMomentBD_UsuarioWeb SET FotoPerfil = ?1, NomeWeb = ?2, Biografia = ?3 WHERE idUsuarioWeb = ?4", nativeQuery = true)
    public void atualizarFotoNomeBio(byte[] foto, String nomeUsuario, String biografia, int idUsuarioWeb);

    @Modifying
    @Query(value = "UPDATE cl202247.EcoMomentBD_UsuarioWeb SET SenhaWeb = ?1 WHERE idUsuarioWeb = ?2", nativeQuery = true)
    public void atualizarSenha(String senha, int idUsuario);

    @Modifying
    @Query(value = "DELETE FROM cl202247.prototipo_Avaliacao_EcoMoment WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void excluirContaAvaliacao(int idUsuario);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Comentarios_EcoMoment WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void excluirContaComentarios(int idUsuario);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Curtidas_EcoMoment WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void excluirContaCurtidas(int idUsuario);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Salvos_EcoMoment WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void excluirContaSalvos(int idUsuario);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Seguidores_EcoMoment WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void excluirContaSeguidores(int idUsuario);

    @Query(value = "SELECT prototipo_Postagem_EcoMoment.idPostagem FROM prototipo_Postagem_EcoMoment inner join EcoMomentBD_UsuarioWeb on prototipo_Postagem_EcoMoment.nomeUsuario = EcoMomentBD_UsuarioWeb.NomeWeb WHERE EcoMomentBD_UsuarioWeb.NomeWeb = ?1", nativeQuery = true)
    public List<Integer> listaPostagemByNome(String nomeWeb);

    @Modifying
    @Query(value = "DELETE FROM prototipo_Postagem_EcoMoment WHERE nomeUsuario = ?1", nativeQuery = true)
    public void excluirContaPostagens(String nome);

    @Modifying
    @Query(value = "DELETE FROM EcoMomentBD_UsuarioWeb WHERE idUsuarioWeb = ?1", nativeQuery = true)
    public void excluirConta(int idUsuario);
}
