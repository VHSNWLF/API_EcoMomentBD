package com.example.EcoMomentBD_API.repository;

import com.example.EcoMomentBD_API.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
