package com.clinical.service.impl;

import com.clinical.entity.Domicilio;
import com.clinical.entity.DomicilioDto;
import com.clinical.entity.Odontologo;
import com.clinical.entity.OdontologoDto;
import com.clinical.repository.IDomicilioRepository;
import com.clinical.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//NO ES NECESARIO CREAR ESTA CLASE PARA EL CORRECTO FUNCIONAMIENTO CON LOS REQUERIMIENTOS INICIALES.
//LO TENGO CREADO PARA FUTUROS FEATURES.

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper objectMapper;

    private DomicilioDto crearDomicilio(DomicilioDto domicilioDto){
        Domicilio domicilio= objectMapper.convertValue(domicilioDto, Domicilio.class);
        domicilioDto.setId(domicilioRepository.save(domicilio).getId());
        return domicilioDto;
    }

    @Override
    public DomicilioDto guardarDomicilio(DomicilioDto domicilioDto) {
        return crearDomicilio(domicilioDto);
    }

    @Override
    public DomicilioDto buscarDomicilio(DomicilioDto domicilioDto) throws Exception {
        Optional<Domicilio> resultado= domicilioRepository.buscarDomicilio(domicilioDto.getDireccion(),domicilioDto.getLocalidad(),domicilioDto.getProvincia());
        if(resultado.isPresent())
            return objectMapper.convertValue(resultado, DomicilioDto.class);
        else
            throw new Exception("No se encontro el domicilio");
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public DomicilioDto modificarDomicilio(DomicilioDto domicilioDto) {
        return crearDomicilio(domicilioDto);
    }
}
