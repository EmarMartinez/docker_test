package com.bosonit.BD1crud.application.student;

import com.bosonit.BD1crud.domain.Student;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.StudentInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.StudentOutputDtoSimple;
import com.bosonit.BD1crud.infraestructure.repository.PersonaJpa;
import com.bosonit.BD1crud.infraestructure.repository.StudentJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentJpa studentJpa;

    @Override
    public StudentOutputDtoSimple addStudent(StudentInputDto studentInputDto) {
        Student student = new Student();
        student.StudentInputDto(studentInputDto);
        studentJpa.save(student);
        return student.StudentToOutputDtoSimple(student);
    }

    @Override
    public List<StudentOutputDtoSimple> studentList() {
        return null;
    }
}
