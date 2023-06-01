package com.clinical.service;

import com.clinical.entity.OdontologoDto;

import java.util.List;

public interface IOdontologoService {
    public OdontologoDto guardarOdontologo(OdontologoDto odontologoDto);
    public List<OdontologoDto> buscarTodos();
    public List<OdontologoDto> buscarPorNombre(String nombre) throws Exception;
    public OdontologoDto buscarOdontologo(Long id) throws Exception;
    public void eliminarOdontologo(Long id);
    public OdontologoDto modificarOdontologo(OdontologoDto odontologoDto);
}
