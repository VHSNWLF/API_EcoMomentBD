package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.PostagemModel;
import com.example.EcoMomentBD_API.repository.PostagemRepository;
import com.example.EcoMomentBD_API.service.SalvoService;
import com.example.EcoMomentBD_API.service.SeguindoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/postagem", produces = "application/json; charset=UTF-8")
public class PostagemController {

    @Autowired
    SalvoService salvoService;

    @Autowired
    SeguindoService segService;

    @Autowired
    PostagemRepository postagemRepo;

    @GetMapping
    public List<PostagemModel> todos(){
        return postagemRepo.findAll();
    }

    @GetMapping("/byNomeUsuario/{nome}")
    public List<PostagemModel> byNomeUsuario(@PathVariable String nome){
        return postagemRepo.findByNomeUsuario(nome);
    }

    @GetMapping("/byMaterialPostagem/{materialPostagem}")
    public List<PostagemModel> byMaterialPostagem(@PathVariable String materialPostagem){
        return postagemRepo.findByMaterialPostagem(materialPostagem);
    }

    @GetMapping("/maisAvaliadas")
    public List<PostagemModel> MaisAvaliadas_10(){
        return postagemRepo.ideiasMaisAvaliadas_10();
    }


    @GetMapping("/maisAvaliadas2/{materialPostagem}")
    public List<PostagemModel> MaisAvaliadas(@PathVariable String materialPostagem){
        return postagemRepo.ideiasMaisAvaliadas( materialPostagem);
    }
    @GetMapping("/maisCurtidas/{materialPostagem}")
    public List<PostagemModel> MaisCurtidas(@PathVariable String materialPostagem){
        return postagemRepo.ideiasMaisCurtidas(materialPostagem);
    }
    @GetMapping("/maisDificuldade/{materialPostagem}")
    public List<PostagemModel> MaisDificuldade(@PathVariable String materialPostagem){
        return postagemRepo.ideiasMaisDificuldade(materialPostagem);
    }

        @GetMapping("/ideiasByIdPostagem")
    public List<PostagemModel> ideiasByIdPostagem(){
            System.out.println(salvoService.getListaIdPostagem());
        return postagemRepo.listaIdeiasByIdPostagem(salvoService.getListaIdPostagem());
    }

    @GetMapping("/ideiasByNomeWeb")
    public List<PostagemModel> ideiasByNomeWeb(){
        return postagemRepo.listaIdeiasByNomeWeb(segService.getListaNomeUsuarioWebByIdSeguindo());
    }

    @GetMapping("/ideiasByNomeWebOrderByNCurtidas/{nomeWeb}")
    public List<PostagemModel> ideiasByNomeWeb(@PathVariable String nomeWeb){
        return postagemRepo.findByNomeUsuarioOrderByNCurtidas(nomeWeb);
    }

    @GetMapping("/findByNomePostagem/{nomePostagem}")
    public Optional<PostagemModel> findByNomePostagem(@PathVariable String nomePostagem){
        return postagemRepo.findByNomePostagem(nomePostagem);
    }

    @PostMapping("/publicarIdeia")
    @Transactional
    public ResponseEntity<String> publicarIdeia(@RequestParam("nomePostagem") String nomePostagem,
                                                @RequestParam("nomeUsuario") String nomeUsuario,
                                                @RequestParam("desc") String desc,
                                                @RequestParam("matNecessarios") String matNecessarios,
                                                @RequestParam("passoPasso") String passoPasso,
                                                @RequestParam("tipoMaterial") int tipoMaterial,
                                                @RequestParam("dificuldade") String dificuldade,
                                                @RequestParam(value = "img1") String img1,
                                                @RequestParam(value = "img2") String img2,
                                                @RequestParam(value = "img3") String img3,
                                                @RequestParam(value = "img4") String img4,
                                                @RequestParam(value = "img5") String img5,
                                                @RequestParam(value = "img6") String img6,
                                                @RequestParam(value = "img7") String img7,
                                                @RequestParam(value = "img8") String img8,
                                                @RequestParam(value = "img9") String img9,
                                                @RequestParam(value = "img10") String img10) {
        try {
            // Converter as strings Base64 para byte[]
            byte[] img1Bytes = img1 != null && !img1.isEmpty() ? Base64.getDecoder().decode(img1) : null;
            byte[] img2Bytes = img2 != null && !img2.isEmpty() ? Base64.getDecoder().decode(img2) : null;
            byte[] img3Bytes = img3 != null && !img3.isEmpty() ? Base64.getDecoder().decode(img3) : null;
            byte[] img4Bytes = img4 != null && !img4.isEmpty() ? Base64.getDecoder().decode(img4) : null;
            byte[] img5Bytes = img5 != null && !img5.isEmpty() ? Base64.getDecoder().decode(img5) : null;
            byte[] img6Bytes = img6 != null && !img6.isEmpty() ? Base64.getDecoder().decode(img6) : null;
            byte[] img7Bytes = img7 != null && !img7.isEmpty() ? Base64.getDecoder().decode(img7) : null;
            byte[] img8Bytes = img8 != null && !img8.isEmpty() ? Base64.getDecoder().decode(img8) : null;
            byte[] img9Bytes = img9 != null && !img9.isEmpty() ? Base64.getDecoder().decode(img9) : null;
            byte[] img10Bytes = img10 != null && !img10.isEmpty() ? Base64.getDecoder().decode(img10) : null;

            postagemRepo.publicarIdeia(nomePostagem, nomeUsuario, desc, matNecessarios, passoPasso, tipoMaterial, dificuldade,
                    img1Bytes, img2Bytes, img3Bytes, img4Bytes, img5Bytes, img6Bytes, img7Bytes, img8Bytes, img9Bytes, img10Bytes);

            return ResponseEntity.ok("Ideia publicada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao publicar ideia: " + e.getMessage());
        }
    }

    @PostMapping("/deletePostagem/{idPostagem}/{idUsuarioWeb}")
    @Transactional
    public void deletePostagem(@PathVariable int idPostagem, @PathVariable int idUsuarioWeb){
        postagemRepo.deleteAvalPostagem(idPostagem);
        postagemRepo.deleteSalvPostagem(idPostagem);
        postagemRepo.deleteCurtPostagem(idPostagem);
        postagemRepo.deleteComenPostagem(idPostagem);
        postagemRepo.deletePostagem(idPostagem);
        postagemRepo.deleteUpdateUsuarioWebPostagem(idUsuarioWeb);
    }

    }
