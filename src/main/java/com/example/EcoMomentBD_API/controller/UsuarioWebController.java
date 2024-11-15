package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.PostagemModel;
import com.example.EcoMomentBD_API.model.UsuarioWebModel;
import com.example.EcoMomentBD_API.repository.UsuarioWebRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping (value = "/Ecomoment/usuario", produces = "application/json; charset=UTF-8")
public class UsuarioWebController {
    @Autowired
    UsuarioWebRepository uWebRepo;

    @GetMapping
    public List<UsuarioWebModel> todos(){
        return uWebRepo.findAll();
    }

    @PostMapping("/cadastrar/{nome}/{email}/{senha}")
    public void cadastrarUsuario(@PathVariable String nome, @PathVariable String email, @PathVariable String senha){
        UsuarioWebModel usuario = new UsuarioWebModel();
        usuario.setNomeWeb(nome);
        usuario.setEmailWeb(email);
        usuario.setSenhaWeb(senha);
        uWebRepo.save(usuario);
    }

    @GetMapping("/verificaUsuarioByNomeAndEmail/{nome}/{email}")
    public List<UsuarioWebModel> usuarioExistenteByNomeAndEMail(@PathVariable String nome, @PathVariable String email){
        return uWebRepo.findByNomeAndEmail(nome, email);
    }

    @GetMapping("/verificaUsuarioByEmail/{email}")
    public Optional<UsuarioWebModel> usuarioExistenteByEMail(@PathVariable String email){
        return uWebRepo.findByEmail(email);
    }

    @GetMapping("/verificaUsuarioByNomeWeb/{nomeWeb}")
    public Optional<UsuarioWebModel> usuarioExistenteByNomeWeb(@PathVariable String nomeWeb){
        return uWebRepo.findByNomeWeb(nomeWeb);
    }

    @GetMapping("/verificaUsuarioByEmailOrUsernameAndSenha/{email}/{senha}")
    public Optional<UsuarioWebModel> usuarioExistenteByMailOrUsername(@PathVariable(value = "email") String emailorusername, @PathVariable String senha){
        return uWebRepo.findByEmailOrUsernameAndSenha(emailorusername, senha);
    }

    @PostMapping ("/atualizarFotoNomeBio")
    @Transactional
    public void atualizarFotoNomeBio(@RequestParam("foto") String foto,
                                     @RequestParam("nome") String nome,
                                     @RequestParam("bio") String bio,
                                     @RequestParam("id") int id){
        byte[] fotoBytes = foto.isEmpty() ? null : Base64.getDecoder().decode(foto);
        uWebRepo.atualizarFotoNomeBio(fotoBytes, nome, bio, id);
    }

    @PostMapping ("/atualizarSenha/{senha}/{id}")
    @Transactional
    public void atualizarSenha(@PathVariable String senha, @PathVariable int id){
        uWebRepo.atualizarSenha(senha, id);
    }

    @PostMapping ("/excluirConta/{id}/{nome}")
    @Transactional
    public void excluirConta(@PathVariable int id, @PathVariable String nome){
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        List<Integer> lista3 = new ArrayList<>();
        List<Integer> lista4 = new ArrayList<>();
        List<Integer> lista5 = new ArrayList<>();
        List<Integer> lista6 = new ArrayList<>();

        lista1 = uWebRepo.listaAvaliacao(id);
        if(!lista1.isEmpty()){
            uWebRepo.excluirContaAvaliacao(id);
        }

        lista2 = uWebRepo.listaComentarios(id);
        if(!lista2.isEmpty()){
            uWebRepo.excluirContaComentarios(id);
        }

        lista3 = uWebRepo.listaCurtidas(id);
        if(!lista3.isEmpty()){
            uWebRepo.excluirContaCurtidas(id);
        }

        lista4 = uWebRepo.listaSalvos(id);
        if(!lista4.isEmpty()){
            uWebRepo.excluirContaSalvos(id);
        }

        lista5 = uWebRepo.listaSeguidores(id);
        if(!lista5.isEmpty()){
            uWebRepo.excluirContaSeguidores(id);
        }

        lista6 = uWebRepo.listaPostagemByNome(nome);
        if (!lista6.isEmpty()){
            uWebRepo.excluirContaPostagens(nome);
        }
        uWebRepo.excluirConta(id);
    }




}
