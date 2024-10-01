package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.ComentarioModel;
import com.example.EcoMomentBD_API.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<PostagemModel, Integer> {
}
