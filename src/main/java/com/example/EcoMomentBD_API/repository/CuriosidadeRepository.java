package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.CuriosidadeModel;
import com.example.EcoMomentBD_API.model.InfoMaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuriosidadeRepository extends JpaRepository<CuriosidadeModel, Integer> {
}
