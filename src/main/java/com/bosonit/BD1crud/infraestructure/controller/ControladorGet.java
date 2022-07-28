package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.Asignatura.AsignaturaServiceImpl;
import com.bosonit.BD1crud.application.persona.PersonaServiceImpl;
import com.bosonit.BD1crud.application.profesor.ProfesorServiceImpl;
import com.bosonit.BD1crud.application.student.StudentServiceImpl;
import com.bosonit.BD1crud.exceptions.IdNoEncontrada;
import com.bosonit.BD1crud.exceptions.UnprocesableException;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.StudentInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.AsignaturaOutputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.ProfesorOutputDtoSimple;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.StudentOutputDtoSimple;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class ControladorGet {

    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @Autowired
    ProfesorServiceImpl profesorServiceImpl;

    @Autowired
    AsignaturaServiceImpl asignaturaServiceImpl;

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


    @GetMapping("estudiante/{id}")
    public Object getStudent(@PathVariable String id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
    try {
        if (outputType.equals("full")) {
            return studentServiceImpl.getStudentFull(id);
        }
        else {
            return studentServiceImpl.getStudent(id);
        }
    }
    catch(Exception e) {

        throw new IdNoEncontrada("No se encontro la ID");

        }
    }

    @GetMapping("estudiante/entradas")
    public List<StudentOutputDtoSimple> mostrarEstudiantes() {

        return studentServiceImpl.mostrarEstudiantes();
    }

    @GetMapping("profesor/entradas")
    public List<ProfesorOutputDtoSimple> mostrarProfesores() {

        return profesorServiceImpl.profesorList();
    }

    @GetMapping("profesor/{id}")
    public Object getProfesor(@PathVariable int id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
        try {
            if (outputType.equals("full")) {
                return profesorServiceImpl.getProfesorFull(id);
            } else {
                return profesorServiceImpl.getProfesor(id);
            }
        }
        catch(Exception e) {

            throw new IdNoEncontrada("No se encontro la ID");

        }
    }
    @GetMapping("asignatura/nombre/{nombre}")
    public List<AsignaturaOutputDto> buscarAsignaturaPorNombre(@PathVariable String nombre) {
        return asignaturaServiceImpl.buscarAsignaturaPorNombre(nombre);
    }
    @JsonIgnore
    @GetMapping("asignatura/estudiante/{idEstudiante}")
    public List<AsignaturaOutputDto> buscarAsignaturasEstudiante(@PathVariable String idEstudiante) {
        return studentServiceImpl.asignaturasEstudiante(idEstudiante);
    }

}
