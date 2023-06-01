package com.clinical.service;

import com.clinical.entity.DomicilioDto;

//NO ES NECESARIO CREAR ESTA INTERFAZ PARA EL CORRECTO FUNCIONAMIENTO CON LOS REQUERIMIENTOS INICIALES.
//LO TENGO CREADO PARA FUTUROS FEATURES.

public interface IDomicilioService {
    public DomicilioDto guardarDomicilio(DomicilioDto domicilioDto);
    public DomicilioDto buscarDomicilio(DomicilioDto domicilioDto) throws Exception;
    public void eliminarDomicilio(Long id);
    public DomicilioDto modificarDomicilio(DomicilioDto domicilioDto);
}
