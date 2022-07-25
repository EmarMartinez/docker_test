package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.persona.PersonaServiceImpl;
import com.bosonit.BD1crud.exceptions.IdNoEncontrada;
import com.bosonit.BD1crud.exceptions.UnprocesableException;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class ControladorPut {
    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @PutMapping("modificar/{id}")
    public PersonaOutputDto modificarPorId(@PathVariable String id, @RequestBody PersonaInputDto personaInputDto) {
        try {
            return personaServiceImpl.modificarPorId(id, personaInputDto);
        }
        catch(NoSuchElementException e) {
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }
        catch(UnprocesableException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }
}
