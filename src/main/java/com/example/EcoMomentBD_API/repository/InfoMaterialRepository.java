package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.InfoMaterialModel;
import com.example.EcoMomentBD_API.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoMaterialRepository extends JpaRepository<InfoMaterialModel, Integer> {
}
