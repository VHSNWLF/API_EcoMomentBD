package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.CurtidaModel;
import com.example.EcoMomentBD_API.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/curtida")
public class CurtidaController {
    @Autowired
    CurtidaRepository curtidaRepo;
    @GetMapping
    public List<CurtidaModel> todos(){
        return curtidaRepo.findAll();
    }
}
