package com.clinical.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TurnoDto {
    private Long id;
    private LocalDateTime fechaHoraTurno;
    private Odontologo odontologo;
    private Paciente paciente;
}
