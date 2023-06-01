package com.clinical.service.impl;

import com.clinical.entity.Domicilio;
import com.clinical.entity.DomicilioDto;
import com.clinical.entity.Paciente;
import com.clinical.entity.PacienteDto;
import com.clinical.repository.IPacienteRepository;
import com.clinical.service.IDomicilioService;
import com.clinical.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    IPacienteService pacienteService;

    @Autowired
    IPacienteRepository pacienteRepository;

    PacienteDto crearPaciente() throws IOException {
        DomicilioDto d=new DomicilioDto();
        d.setDireccion("LaReVivis 54");
        d.setLocalidad("Eldorado");
        d.setProvincia("Misiones");
        PacienteDto pacienteDto=new PacienteDto();
        pacienteDto.setApellido("test");
        pacienteDto.setNombre("tesst");
        pacienteDto.setDni(23456789);
        pacienteDto.setFechaDeAlta(LocalDate.of(2023, 3, 1));
        pacienteDto.setDomicilio(mapper.convertValue(d,Domicilio.class));
        return pacienteService.guardarPaciente(pacienteDto);
    }

    @Test
    void guardarPaciente() throws IOException {
        PacienteDto test=crearPaciente();
        Assertions.assertNotNull(test);
    }

    @Test
    void buscarTodos() {
        Assertions.assertTrue(pacienteService.buscarTodos().size()>0);
    }

    @Test
    void buscarPorNombre() throws Exception {
        PacienteDto p =pacienteService.buscarPorNombre("Cola");
        Assertions.assertEquals("Cola",p.getNombre());
    }

    @Test
    void buscarPaciente() throws Exception {
        PacienteDto p= pacienteService.buscarPaciente(1L);
        Assertions.assertEquals(1L,p.getId());
    }

    @Test
    void eliminarPaciente() throws IOException {
        PacienteDto p=crearPaciente();
        pacienteService.eliminarPaciente(p.getId());
        Optional<Paciente> paciente=pacienteRepository.findById(p.getId());
        Assertions.assertFalse(paciente.isPresent());
    }
    //el test modificarPaciente() no lo implemento porque utiliza la misma logica que guardarPaciente().
}