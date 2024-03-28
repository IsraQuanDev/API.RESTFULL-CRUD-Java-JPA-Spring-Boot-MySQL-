package com.example.demo.controllers;

import com.example.demo.models.Persona;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private Repository repo;

    @GetMapping("/")
    public String index(){
        return "CONECTAR";
    }

    @GetMapping("personas")
    public List<Persona> getPersonas(){
        return repo.findAll();
    }

    @PostMapping("grabar")
    public String post(@RequestBody Persona persona){
        repo.save(persona);
        return "Grabado";
    }

    @PutMapping("editar/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona) {
        Optional<Persona> optionalPersona = repo.findById(id);

        if (optionalPersona.isPresent()) {
            Persona updatePersona = optionalPersona.get();

            updatePersona.setNombre(persona.getNombre());
            updatePersona.setTelefono(persona.getTelefono());
            repo.save(updatePersona);

            return "Editado Correctamente";
        } else {
            return "Persona no encontrada";
        }
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Persona> optionalPersona = repo.findById(id);

        if (optionalPersona.isPresent()) {
            Persona deletePersona = optionalPersona.get();
            repo.delete(deletePersona);
            return "Eliminado";
        } else {
            return "Persona no encontrada";
        }
    }
}
