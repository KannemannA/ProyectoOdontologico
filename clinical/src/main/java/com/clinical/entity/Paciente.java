package com.clinical.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pacientes")
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_secuence", sequenceName = "paciente_secuence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_secuence")
    private Long id;
    private String apellido;
    private String nombre;
    private int dni;
    private LocalDate fechaDeAlta;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id", nullable = false)
    private Domicilio domicilio;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;
    private String nombreImagen;
    private String rutaImagen;

    @Override
    public String toString() {
        return "Datos del paciente:\n" +
                "   Nombre: " + nombre + "\n" +
                "   Apellido: " + apellido + "\n" +
                "   " + domicilio.toString() + "\n" +
                "   DNI: " + dni + "\n" +
                "   Fecha de alta: " + fechaDeAlta;
    }
}
