package com.clinical.service.impl;

import com.clinical.entity.Turno;
import com.clinical.entity.TurnoDto;
import com.clinical.repository.ITurnoRepository;
import com.clinical.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private TurnoDto crearTurno(TurnoDto turnoDto){
        Turno turno=mapper.convertValue(turnoDto, Turno.class);
        turnoDto.setId(turnoRepository.save(turno).getId());
        return turnoDto;
    }

    @Override
    public TurnoDto guardarTurno(TurnoDto turnoDto) {
        return crearTurno(turnoDto);
    }

    @Override
    public List<TurnoDto> buscarTodos() {
        List<TurnoDto> turnoDtos= new ArrayList<>();
        List<Turno>lista=turnoRepository.findAll();
        for (Turno turno:lista){
            turnoDtos.add(mapper.convertValue(turno,TurnoDto.class));
        }
        return turnoDtos;
    }

    @Override
    public TurnoDto buscarTurno(Long id) throws Exception {
        Optional<Turno> busqueda = turnoRepository.findById(id);
        if(busqueda.isPresent()){
            System.out.println(mapper.convertValue(busqueda.get(), TurnoDto.class));
            return mapper.convertValue(busqueda.get(), TurnoDto.class);}
        else
            throw new Exception("No se encontro el turno");
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoDto modificarTurno(TurnoDto turnoDto) {
        return crearTurno(turnoDto);
    }
}
