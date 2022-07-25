package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.persona.PersonaService;
import com.bosonit.BD1crud.application.student.StudentServiceImpl;
import com.bosonit.BD1crud.exceptions.UnprocesableException;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.StudentInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.StudentOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorPost {

    @Autowired
    PersonaService personaservice;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping("/persona")
    public PersonaOutputDto crearPersona(@RequestBody PersonaInputDto personaInputDto){
        try {
            return personaservice.addPersona(personaInputDto);
        }
        catch(UnprocesableException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }

    @PostMapping("estudiante")
    public StudentOutputDtoSimple addStudent(@RequestBody StudentInputDto studentInputDto) {
        return studentServiceImpl.addStudent(studentInputDto);
    }
}
