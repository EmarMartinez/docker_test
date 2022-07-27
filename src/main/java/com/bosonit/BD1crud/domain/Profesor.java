package com.bosonit.BD1crud.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Profesor {
    @Id
    @GeneratedValue
    String id_profesor;

    @OneToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id")
    Persona persona;

    String comments;
    String branch;
}
