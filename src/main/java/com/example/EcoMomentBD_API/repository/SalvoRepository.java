package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.SalvoModel;
import com.example.EcoMomentBD_API.model.doubleKey.SalvoEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalvoRepository extends JpaRepository<SalvoModel, SalvoEmbeddableModel> {

    @Query(value = "SELECT * FROM cl202247.prototipo_Salvos_EcoMoment where idUsuarioWeb = ?1", nativeQuery = true)
    public List<Integer> findByIdUsuarioWeb(int id);

    @Query(value = "SELECT * FROM cl202247.prototipo_Salvos_EcoMoment where idUsuarioWeb = ?1 and idPostagem = ?2", nativeQuery = true)
    public Optional<SalvoModel> isSaved(int idUsuarioWeb, int idPostagem);

    @Modifying
    @Query(value = "INSERT INTO cl202247.prototipo_Salvos_EcoMoment (idUsuarioWeb, idPostagem) VALUES (?1, ?2)", nativeQuery = true)
    public void save(int idUsuarioWeb, int idPostagem);

    @Modifying
    @Query(value = "DELETE FROM cl202247.prototipo_Salvos_EcoMoment WHERE idUsuarioWeb = ?1 AND idPostagem = ?2", nativeQuery = true)
    public void delete(int idUsuarioWeb, int idPostagem);
}
