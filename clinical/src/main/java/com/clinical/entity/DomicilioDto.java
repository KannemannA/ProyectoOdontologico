package com.clinical.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDto {
    private Long id;
    private String direccion;
    private String localidad;
    private String provincia;
}
