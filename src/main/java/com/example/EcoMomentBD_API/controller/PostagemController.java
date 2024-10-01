package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.PostagemModel;
import com.example.EcoMomentBD_API.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/postagem")
public class PostagemController {
    @Autowired
    PostagemRepository postagemRepo;
    @GetMapping
    public List<PostagemModel> todos(){
        return postagemRepo.findAll();
    }
}
