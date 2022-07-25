package com.bosonit.BD1crud.application.student;

import com.bosonit.BD1crud.infraestructure.controller.dto.input.StudentInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.StudentOutputDtoSimple;

import java.util.List;

public interface StudentService {

    StudentOutputDtoSimple addStudent(StudentInputDto studentInputDto);
    List<StudentOutputDtoSimple> studentList();

}
