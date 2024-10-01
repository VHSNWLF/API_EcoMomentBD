package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.usuarioWeb;
import com.example.EcoMomentBD_API.repository.uWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/Ecomoment/usuarios")
public class uWebControll {
    @Autowired
    uWebRepository uWebRepo;

    @GetMapping("/todos")
    public List<usuarioWeb> todos(){
        return uWebRepo.findAll();
    }
}
