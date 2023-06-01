package com.clinical.service;

import com.clinical.entity.Turno;
import com.clinical.entity.TurnoDto;

import java.util.List;

public interface ITurnoService {
    public TurnoDto guardarTurno(TurnoDto turnoDto);
    public List<TurnoDto> buscarTodos();
    public TurnoDto buscarTurno(Long id) throws Exception;
    public void eliminarTurno(Long id);
    public TurnoDto modificarTurno(TurnoDto turnoDto);
}
