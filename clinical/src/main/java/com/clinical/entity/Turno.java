package com.clinical.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Turnos")
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_secuence", sequenceName = "turno_secuence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_secuence")
    private Long id;
    private LocalDateTime fechaHoraTurno;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_odontologo", referencedColumnName = "id")
    private Odontologo odontologo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    private Paciente paciente;
}
