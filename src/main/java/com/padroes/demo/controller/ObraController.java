package com.padroes.demo.controller;

import com.padroes.demo.model.Obra;
import com.padroes.demo.model.Usuario;
import com.padroes.demo.repository.ObraRepository;
import com.padroes.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/obra")
public class ObraController {

    @Autowired
    private ObraRepository obraRepository;


    @Autowired
    @RequestMapping(value = "novo", method = RequestMethod.POST)
    public ResponseEntity<Obra> novo(@RequestBody Obra obra){
        return new ResponseEntity<Obra>(obraRepository.save(obra), HttpStatus.OK);
    }

    @Autowired
    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Obra>> listar(){
        return ResponseEntity.ok((List<Obra>) obraRepository.findAll());
    }

    @Autowired
    @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Obra> getById(@PathVariable(value = "id") Long id){
        Optional<Obra> object = obraRepository.findById(id);
        if(object.isPresent()){
            return new ResponseEntity<>(object.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable(value = "id") Long id){
        if(obraRepository.existsById(id)){
            obraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return  ResponseEntity.notFound().build();
        }
    }
}
