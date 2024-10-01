package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, Integer> {
}
