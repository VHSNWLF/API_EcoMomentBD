package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.EscopoModel;
import com.example.EcoMomentBD_API.model.SeguidorModel;
import com.example.EcoMomentBD_API.model.doubleKey.SeguidorEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguidorRepository extends JpaRepository<SeguidorModel, SeguidorEmbeddableModel> {
}
