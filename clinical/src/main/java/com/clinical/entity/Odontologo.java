package com.clinical.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Odontologos")
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_secuence", sequenceName = "odontologo_secuence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_secuence")
    private Long id;
    private String apellido;
    private String nombre;
    private int matricula;
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;

    @Override
    public String toString() {
        return "Datos del odontologo:\n" +
        "   Id: " + id + "\n" +
        "   Nombre: " + nombre + "\n" +
        "   Apellido: " + apellido + "\n" +
        "   Matricula: " + matricula;
    }
}
