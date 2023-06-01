package com.clinical.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteDto {
    private Long id;
    private String apellido;
    private String nombre;
    private int dni;
    private LocalDate fechaDeAlta;
    private Domicilio domicilio;
    private MultipartFile imagen;
    private String nombreImagen;
    private String rutaImagen;
    private String direccion;
    private String localidad;
    private String provincia;
}
