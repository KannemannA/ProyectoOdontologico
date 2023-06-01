package com.clinical.service;

import com.clinical.entity.PacienteDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPacienteService {
    public PacienteDto guardarPaciente(PacienteDto pacienteDto) throws IOException;
    public List<PacienteDto> buscarTodos();
    public PacienteDto buscarPorNombre(String nombre) throws Exception;
    public PacienteDto buscarPaciente(Long id) throws Exception;
    public void eliminarPaciente(Long id);
    public PacienteDto modificarPaciente(PacienteDto pacienteDto) throws IOException;
}
