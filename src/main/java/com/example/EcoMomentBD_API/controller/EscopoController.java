package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.CuriosidadeModel;
import com.example.EcoMomentBD_API.model.EscopoModel;
import com.example.EcoMomentBD_API.repository.EscopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/")
public class EscopoController {
    @Autowired
    EscopoRepository escopoRepo;
    @GetMapping
    public List<EscopoModel> todos(){
        return escopoRepo.findAll();
    }
}
