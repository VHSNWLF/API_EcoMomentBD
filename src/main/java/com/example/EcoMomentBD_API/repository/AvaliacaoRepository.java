package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.AvaliacaoModel;
import com.example.EcoMomentBD_API.model.doubleKey.AvaliacaoEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, AvaliacaoEmbeddableModel> {
}
