package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.persona.PersonaServiceImpl;
import com.bosonit.BD1crud.application.student.StudentServiceImpl;
import com.bosonit.BD1crud.exceptions.IdNoEncontrada;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.StudentInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.StudentOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ControladorGet {

    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("id/{id}")
    public PersonaOutputDto buscarPorId(@PathVariable String id) {
        try {
            personaServiceImpl.buscarPorId(String.valueOf(id));
        }
        catch(NoSuchElementException e) {

            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }
        return personaServiceImpl.buscarPorId(String.valueOf(id));

    }


    @GetMapping("persona/{nombre}")
    public ResponseEntity<List<PersonaOutputDto>> buscarPorNombre(@PathVariable String nombre) {
        return personaServiceImpl.buscarPorNombre(nombre);
    }


    @GetMapping("entradas")
    public ResponseEntity<List<PersonaOutputDto>> listaCompleta() {

        return personaServiceImpl.buscarTodos();
    }


}
