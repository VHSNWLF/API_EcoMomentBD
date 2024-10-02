package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.EscopoModel;
import com.example.EcoMomentBD_API.model.SeguidorModel;
import com.example.EcoMomentBD_API.repository.EscopoRepository;
import com.example.EcoMomentBD_API.repository.SeguidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/seguidor")
public class SeguidorController {
    @Autowired
    SeguidorRepository seguidorRepo;
    @GetMapping
    public List<SeguidorModel> todos(){
        return seguidorRepo.findAll();
    }
}
