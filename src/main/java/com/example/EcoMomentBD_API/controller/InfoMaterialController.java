package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.InfoMaterialModel;
import com.example.EcoMomentBD_API.repository.InfoMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Ecomoment/infoMaterial")
public class InfoMaterialController {
    @Autowired
    InfoMaterialRepository infoMatRepo;

    @GetMapping
    public List<InfoMaterialModel> todos(){
        return infoMatRepo.findAll();
    }
}
