package com.bosonit.BD1crud.infraestructure.controller.dto.output;

import com.bosonit.BD1crud.domain.Estudiante_Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutputDtoSimple {
    String id;
    int num_hours_week;
    String comments;
    String id_profesor;
    String branch;
    List<Estudiante_Asignatura> estudios;
}
