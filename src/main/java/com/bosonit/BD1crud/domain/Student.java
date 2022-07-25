package com.bosonit.BD1crud.domain;

import com.bosonit.BD1crud.autoincrementales.PersonaSequenceIdGenerator;
import com.bosonit.BD1crud.autoincrementales.StudentSequenceIdGenerator;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.StudentInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.StudentOutputDtoSimple;
import com.bosonit.BD1crud.infraestructure.repository.PersonaJpa;
import com.bosonit.BD1crud.infraestructure.repository.StudentJpa;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

import static java.lang.Integer.parseInt;


@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias")
    @GenericGenerator(

            name = "ausencias",

            strategy = "com.bosonit.BD1crud.autoincrementales.StudentSequenceIdGenerator",

            parameters = {

                    @org.hibernate.annotations.Parameter(name = StudentSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

                    @org.hibernate.annotations.Parameter(name = StudentSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Std"),

                    @org.hibernate.annotations.Parameter(name = StudentSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")

            })
    @Column(name = "id_student")
    private String id_student;

    @OneToOne
    @JoinColumn(name = "id")
    Persona persona;

    int num_hours_week;

    String comments;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    String branch;

    @OneToMany
    List<Estudiante_Asignatura> estudios;



    public void StudentInputDto(StudentInputDto studentInputDto) {



        this.setComments(studentInputDto.getComments());
        this.setNum_hours_week(studentInputDto.getNum_hours_week());
        this.setBranch(studentInputDto.getBranch());

    }

    public StudentOutputDtoSimple StudentToOutputDtoSimple(Student student) {

        StudentOutputDtoSimple studentOutputDtoSimple = new StudentOutputDtoSimple();
        studentOutputDtoSimple.setId(this.getId_student());
        studentOutputDtoSimple.setBranch(this.getBranch());
        studentOutputDtoSimple.setComments(this.getComments());
        studentOutputDtoSimple.setNum_hours_week(this.getNum_hours_week());

        return studentOutputDtoSimple;
    }

}
