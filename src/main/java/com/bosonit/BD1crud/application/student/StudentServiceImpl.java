package com.bosonit.BD1crud.application.student;

import com.bosonit.BD1crud.domain.Persona;
import com.bosonit.BD1crud.domain.Student;
import com.bosonit.BD1crud.exceptions.UnprocesableException;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.StudentInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.StudentOutputDtoSimple;
import com.bosonit.BD1crud.infraestructure.repository.PersonaJpa;
import com.bosonit.BD1crud.infraestructure.repository.StudentJpa;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentJpa studentJpa;

    @Autowired
    PersonaJpa personaJpa;

    @Override
    public StudentOutputDtoSimple addStudent(StudentInputDto studentInputDto) {
        try {
            Student student = new Student();
            Persona persona;
            persona = personaJpa.findById((studentInputDto.getId())).get();
            student.StudentInputDto(studentInputDto);
            student.setPersona(persona);
            persona.setStudent(student);
            studentJpa.save(student);
        System.out.println("El estudiante: " + studentJpa.findById(student.getId_student()) + " es la persona: " + personaJpa.findById(persona.getId()));
        System.out.println("La persona : " + personaJpa.findById(persona.getId()) + " es el estudiante: " + studentJpa.findById(student.getId_student()));
            return student.StudentToOutputDtoSimple(student);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw new UnprocesableException("La ID suministrada está asociada a otro estudiante");
        }
    }

    @Override
    public List<StudentOutputDtoSimple> studentList() {
        return null;
    }
}
