package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.ComentarioModel;
import com.example.EcoMomentBD_API.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/comentario")
public class ComentarioController {
    @Autowired
    ComentarioRepository comentRepo;

    @GetMapping
    public List<ComentarioModel> todos(){
        return comentRepo.findAll();
    }
}
