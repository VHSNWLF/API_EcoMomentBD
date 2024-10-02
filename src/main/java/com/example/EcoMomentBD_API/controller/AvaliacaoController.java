package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.AvaliacaoModel;
import com.example.EcoMomentBD_API.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/avaliacao")
public class AvaliacaoController {
    @Autowired
    AvaliacaoRepository avaliacaoRepo;
    @GetMapping
    public List<AvaliacaoModel> todos(){
        return avaliacaoRepo.findAll();
    }
}
