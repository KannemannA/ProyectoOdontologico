package com.clinical.service.impl;

import com.clinical.entity.Domicilio;
import com.clinical.entity.Paciente;
import com.clinical.entity.PacienteDto;
import com.clinical.repository.IPacienteRepository;
import com.clinical.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Value("${file.upload-dir}")
     private String uploadDir;

    private PacienteDto crearPaciente(PacienteDto pacienteDto) throws IOException {
        pacienteDto.setDomicilio(new Domicilio(null,pacienteDto.getDireccion(),pacienteDto.getLocalidad(),pacienteDto.getProvincia(),null));
        MultipartFile file=pacienteDto.getImagen();
        if(file!=null){
            try {
                pacienteDto.setImagen(null);
                Path subi=Paths.get(uploadDir);
                String rutaAbsoluta= subi.toFile().getAbsolutePath();
                Path uploadPath=Paths.get(rutaAbsoluta);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                byte[] bytesImagen= file.getBytes();
                Path rutaCompleta= Paths.get(rutaAbsoluta+"//"+file.getOriginalFilename());
                Files.write(rutaCompleta,bytesImagen);
                pacienteDto.setNombreImagen(file.getOriginalFilename());
                pacienteDto.setRutaImagen(rutaCompleta.toFile().getAbsolutePath());

            }
            catch (IOException err){System.out.println("ERROR al copiar "+err.getMessage());
            }
        }
        Paciente paciente=objectMapper.convertValue(pacienteDto,Paciente.class);
        pacienteDto.setId(pacienteRepository.save(paciente).getId());
        return pacienteDto;
    }

    @Override
    public PacienteDto guardarPaciente(PacienteDto pacienteDto) throws IOException {
        return crearPaciente(pacienteDto);
    }

    @Override
    public List<PacienteDto> buscarTodos() {
        List<PacienteDto> pacienteDtos= new ArrayList<>();
        List<Paciente>lista=pacienteRepository.findAll();
        for (Paciente paciente:lista){
            pacienteDtos.add(objectMapper.convertValue(paciente,PacienteDto.class));
        }
        return pacienteDtos;
    }

    @Override
    public PacienteDto buscarPorNombre(String nombre) throws Exception {
        Optional<Paciente> busqueda = pacienteRepository.buscarPacientePorNombre(nombre);
        if(busqueda.isPresent())
            return objectMapper.convertValue(busqueda.get(), PacienteDto.class);
        else
            throw new Exception("No se encontro el paciente");
    }

    @Override
    public PacienteDto buscarPaciente(Long id) throws Exception {
        Optional<Paciente> busqueda = pacienteRepository.findById(id);
        if(busqueda.isPresent())
            return objectMapper.convertValue(busqueda.get(), PacienteDto.class);
        else
            throw new Exception("No se encontro el paciente");
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDto modificarPaciente(PacienteDto pacienteDto) throws IOException {
        return crearPaciente(pacienteDto);
    }
}
