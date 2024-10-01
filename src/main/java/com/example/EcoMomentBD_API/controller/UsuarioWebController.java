package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.UsuarioWebModel;
import com.example.EcoMomentBD_API.repository.UsuarioWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/Ecomoment/usuario")
public class UsuarioWebController {
    @Autowired
    UsuarioWebRepository uWebRepo;

    @GetMapping
    public List<UsuarioWebModel> todos(){
        return uWebRepo.findAll();
    }
}
