package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.SalvoModel;
import com.example.EcoMomentBD_API.model.doubleKey.SalvoEmbeddableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalvoRepository extends JpaRepository<SalvoModel, SalvoEmbeddableModel> {
}
