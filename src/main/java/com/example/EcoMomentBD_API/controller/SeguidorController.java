package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.SeguidorModel;
import com.example.EcoMomentBD_API.model.UsuarioWebModel;
import com.example.EcoMomentBD_API.repository.SeguidorRepository;
import com.example.EcoMomentBD_API.service.SalvoService;
import com.example.EcoMomentBD_API.service.SeguindoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/seguidor", produces = "application/json; charset=UTF-8")
public class SeguidorController {

    @Autowired
    SeguidorRepository seguidorRepo;

    @Autowired
    SeguindoService seguindoService;

    @GetMapping
    public List<SeguidorModel> todos(){
        return seguidorRepo.findAll();
    }

    @GetMapping("/ByIdSeguidor/{id}")
    public List<Integer> IdSeguindo(@PathVariable int id){
        seguindoService.setListaIdUsuarioSeguindo(seguidorRepo.findIdSeguindo(id));
        System.out.println(seguindoService.getListaIdUsuarioSeguindo());
        return seguidorRepo.findIdSeguindo(id);
    }

    @GetMapping("/ByIdSeguindo")
    public List<String> nomeWeb(){
        seguindoService.setListaNomeUsuarioWebByIdSeguindo(seguidorRepo.findNomeWebById(seguindoService.getListaIdUsuarioSeguindo()));
        System.out.println(seguindoService.getListaNomeUsuarioWebByIdSeguindo());
        return seguidorRepo.findNomeWebById(seguindoService.getListaIdUsuarioSeguindo());
    }

    //função seguir:
    @PostMapping("/follow/{nomeWeb}/{idSeguidor}")
    @Transactional
    public void follow(@PathVariable String nomeWeb, @PathVariable int idSeguidor){
        Integer idSeguido = seguidorRepo.acharIdSeguidoByNomeWeb(nomeWeb);
        System.out.println("IdSeguido: "+idSeguido);
        seguidorRepo.add_TabelaSeguidor(idSeguido, idSeguidor);
        seguidorRepo.add_QtdeSeguidores(idSeguido);
        seguidorRepo.add_QtdeSeguindo(idSeguidor);
    }

    //função parar de seguir:
    @PostMapping("/unfollow/{nomeWeb}/{idSeguidor}")
    @Transactional
    public void unfollow(@PathVariable String nomeWeb, @PathVariable int idSeguidor){
        Integer idSeguido = seguidorRepo.acharIdSeguidoByNomeWeb(nomeWeb);
        System.out.println("IdSeguido: "+idSeguido);
        seguidorRepo.del_TabelaSeguidor(idSeguido, idSeguidor);
        seguidorRepo.del_QtdeSeguidores(idSeguido);
        seguidorRepo.del_QtdeSeguindo(idSeguidor);
    }

    @GetMapping("/verSeguindo/{idUsuarioWeb}")
    public List<UsuarioWebModel> mostrarSeguindo(@PathVariable int idUsuarioWeb){
        List<UsuarioWebModel> listaSeguindoUserWebModel = new ArrayList<>();
        List<Object []> listaSeguindo = seguidorRepo.verTodosSeguindo(idUsuarioWeb);

        for(Object [] row: listaSeguindo){
            UsuarioWebModel usuarioWebModel = new UsuarioWebModel();
            usuarioWebModel.setIdUsuarioWeb((int) row[0]);
            usuarioWebModel.setNomeWeb((String) row[1]);
            usuarioWebModel.setEmailWeb((String) row[2]);
            usuarioWebModel.setSenhaWeb((String) row[3]);
            usuarioWebModel.setQtdeSeguidores((int) row[4]);
            usuarioWebModel.setQtdeSeguindo((int) row[5]);
            usuarioWebModel.setQtdeCurtidas((int) row[6]);
            usuarioWebModel.setQtdePostagens((int) row[7]);
            usuarioWebModel.setReputacao((float) row[8]);
            usuarioWebModel.setBiografia((String) row[9]);
            usuarioWebModel.setFotoPerfil((byte[]) row[10]);
            usuarioWebModel.setAtivo((int) row[11]);
            usuarioWebModel.setIdSeguido((int) row[12]);
            usuarioWebModel.setIdSeguidor((int) row[13]);

            listaSeguindoUserWebModel.add(usuarioWebModel);
        }
        return listaSeguindoUserWebModel;
    }

    @GetMapping("/verSeguidores/{idUsuarioWeb}")
    public List<UsuarioWebModel> mostrarSeguidores(@PathVariable int idUsuarioWeb){
        List<UsuarioWebModel> listaSeguidoresUserWebModel = new ArrayList<>();
        List<Object []> listaSeguidores = seguidorRepo.verTodosSeguidores(idUsuarioWeb);

        for(Object [] row: listaSeguidores){
            UsuarioWebModel usuarioWebModel = new UsuarioWebModel();
            usuarioWebModel.setIdUsuarioWeb((int) row[0]);
            usuarioWebModel.setNomeWeb((String) row[1]);
            usuarioWebModel.setEmailWeb((String) row[2]);
            usuarioWebModel.setSenhaWeb((String) row[3]);
            usuarioWebModel.setQtdeSeguidores((int) row[4]);
            usuarioWebModel.setQtdeSeguindo((int) row[5]);
            usuarioWebModel.setQtdeCurtidas((int) row[6]);
            usuarioWebModel.setQtdePostagens((int) row[7]);
            usuarioWebModel.setReputacao((float) row[8]);
            usuarioWebModel.setBiografia((String) row[9]);
            usuarioWebModel.setFotoPerfil((byte[]) row[10]);
            usuarioWebModel.setAtivo((int) row[11]);
            usuarioWebModel.setIdSeguido((int) row[12]);
            usuarioWebModel.setIdSeguidor((int) row[13]);

            listaSeguidoresUserWebModel.add(usuarioWebModel);
        }
        return listaSeguidoresUserWebModel;
    }

    @GetMapping("/isFollower/{meuIdUsuarioWeb}/{UsuarioIdSeguido}")
    public Integer isFollower(@PathVariable int meuIdUsuarioWeb, @PathVariable int UsuarioIdSeguido){
        return seguidorRepo.isFollower(meuIdUsuarioWeb, UsuarioIdSeguido);
    }


}
