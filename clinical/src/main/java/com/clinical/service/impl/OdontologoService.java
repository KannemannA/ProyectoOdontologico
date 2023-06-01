package com.clinical.service.impl;

import com.clinical.entity.Odontologo;
import com.clinical.entity.OdontologoDto;
import com.clinical.repository.IOdonotologoRepository;
import com.clinical.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdonotologoRepository odonotologoRepository;

    @Autowired
    ObjectMapper objectMapper;

    private OdontologoDto crearOdontologo(OdontologoDto odontologoDto){
        Odontologo odontologo= objectMapper.convertValue(odontologoDto,Odontologo.class);
        if(Objects.equals(odontologo.getNombre(), "") ||odontologo.getNombre()==null){
            odontologo.setNombre("juan");
        }
        odontologoDto.setId(odonotologoRepository.save(odontologo).getId());
        return odontologoDto;
    }

    @Override
    public OdontologoDto guardarOdontologo(OdontologoDto odontologoDto) {
        return crearOdontologo(odontologoDto);
    }


    @Override
    public List<OdontologoDto> buscarTodos() {
        List<OdontologoDto> odontologoDtos= new ArrayList<>();
        List<Odontologo>lista=odonotologoRepository.findAll();
        for (Odontologo odontologo:lista){
            odontologoDtos.add(objectMapper.convertValue(odontologo,OdontologoDto.class));
        }
        return odontologoDtos;
    }

    @Override
    public List<OdontologoDto> buscarPorNombre(String nombre) throws Exception {
        List<OdontologoDto> odontologoDtos =new ArrayList<>();
        List<Odontologo> resultado= odonotologoRepository.buscarOdontologosPorNombre(nombre);
        for (Odontologo odontologo:resultado){
            odontologoDtos.add(objectMapper.convertValue(odontologo,OdontologoDto.class));
        }
        return odontologoDtos;
    }

    @Override
    public OdontologoDto buscarOdontologo(Long id) throws Exception {
        Optional<Odontologo> resultado = odonotologoRepository.findById(id);
        if(resultado.isPresent())
            return objectMapper.convertValue(resultado.get(), OdontologoDto.class);
        else
            throw new Exception("No se encontro el odontologo");
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odonotologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDto modificarOdontologo(OdontologoDto odontologoDto) {
        return crearOdontologo(odontologoDto);
    }
}
