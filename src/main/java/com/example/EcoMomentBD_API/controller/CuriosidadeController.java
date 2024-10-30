package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.CuriosidadeModel;
import com.example.EcoMomentBD_API.repository.CuriosidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/curiosidade", produces = "application/json; charset=UTF-8")
public class CuriosidadeController {
    @Autowired
    CuriosidadeRepository curiosidadeRepo;

    @GetMapping
    public List<CuriosidadeModel> todos(){
        return curiosidadeRepo.findAll();
    }
}
