package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.CurtidaModel;
import com.example.EcoMomentBD_API.model.doubleKey.CurtidaEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<CurtidaModel, CurtidaEmbeddableModel> {
}
