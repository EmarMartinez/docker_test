package com.bosonit.BD1crud.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Estudiante_Asignatura {
    @Id
    @GeneratedValue
    String id_asignatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_student")
    Student student;

    String comments;
    Date initial_date;
    Date finish_date;

}
