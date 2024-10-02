package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.SalvoModel;
import com.example.EcoMomentBD_API.repository.SalvoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/salvo")
public class SalvoController {
    @Autowired
    SalvoRepository salvoRepo;
    @GetMapping
    public List<SalvoModel> todos(){
        return salvoRepo.findAll();
    }
}
