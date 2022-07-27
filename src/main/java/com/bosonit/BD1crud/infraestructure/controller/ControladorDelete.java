package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.persona.PersonaServiceImpl;
import com.bosonit.BD1crud.application.student.StudentServiceImpl;
import com.bosonit.BD1crud.exceptions.IdNoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class ControladorDelete {
    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @DeleteMapping("borrar/{id}")

    public void borrarPorId(@PathVariable String id){
        try {
            personaServiceImpl.borrarPorId(id);
        }
        catch(NoSuchElementException e){
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }

    }
    @DeleteMapping("borrar/estudiante/{id}")
    public void borrarEstudiantePorId(@PathVariable String id){
        try {
            studentServiceImpl.borrarEstudiantePorId(id);
        }
        catch(NoSuchElementException e){
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }

    }
}
