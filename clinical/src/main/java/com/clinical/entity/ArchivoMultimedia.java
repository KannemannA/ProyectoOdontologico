/*package com.clinical.entity;

import jakarta.persistence.*;
import jakarta.validation.Path;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Archivos")
public class ArchivoMultimedia {
    @Id
    @SequenceGenerator(name = "archivo_secuence", sequenceName = "archivo_secuence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "archivo_secuence")
    private Long id;
    private String nombre;
    private String tipoDeContenido;
    private Long tamanio;
    private String ruta;
}*/
