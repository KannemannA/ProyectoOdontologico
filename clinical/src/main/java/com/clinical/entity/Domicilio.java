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
@Table(name = "Domicilios")
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_secuence", sequenceName = "domicilio_secuence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_secuence")
    private Long id;
    private String direccion;
    private String localidad;
    private String provincia;
    @OneToMany(mappedBy = "domicilio", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Paciente> pacientes;

    @Override
    public String toString() {
        return "Domicilio en " + direccion + ", " + localidad + ", " + provincia;
    }
}
