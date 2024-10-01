package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.ComentariosModel;
import com.example.EcoMomentBD_API.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/comentarios")
public class ComentariosControll {
    @Autowired
    ComentariosRepository comentRepo;

    @GetMapping("/todos")
    public List<ComentariosModel> todos(){
        return comentRepo.findAll();
    }
}
