package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.ComentarioModel;
import com.example.EcoMomentBD_API.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/comentario", produces = "application/json; charset=UTF-8")
public class ComentarioController {
    @Autowired
    ComentarioRepository comentRepo;

    @GetMapping
    public List<ComentarioModel> todos(){
        return comentRepo.findAll();
    }

    @GetMapping("/ByIdPostagem/{idPostagem}")
    public List<ComentarioModel> comentariosByIdPostagem(@PathVariable int idPostagem){
        List<Object[]> resultado = comentRepo.comentariosByIdPostagem(idPostagem);
        List<ComentarioModel> comentarios = new ArrayList<>();

            for(Object[] row : resultado){
                ComentarioModel comentarioModel = new ComentarioModel();
                comentarioModel.setIdComentario((int) row[0]);
                comentarioModel.setComentario((String) row[1]);
                comentarioModel.setNomeWeb((String) row[2]);
                comentarioModel.setIdUsuarioWeb((int) row[3]);

                comentarios.add(comentarioModel);
            }
        return comentarios;
    }

    @PostMapping("/comentar/{idPostagem}/{idUsuarioWeb}/{comentario}")
    @Transactional
    public void comentar(@PathVariable int idPostagem, @PathVariable int idUsuarioWeb, @PathVariable String comentario){
        comentRepo.comentar(idPostagem, idUsuarioWeb, comentario);
        comentRepo.updateQtdeComentariosPostagem(idPostagem);
    }
}
