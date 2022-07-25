package com.bosonit.BD1crud.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Profesor {
    @Id
    @GeneratedValue
    String id_profesor;

    @OneToOne
    @JoinColumn(name = "id")
    Persona persona;

    String comments;
    String branch;
}
