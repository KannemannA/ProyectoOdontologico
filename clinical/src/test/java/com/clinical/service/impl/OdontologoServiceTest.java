package com.clinical.service.impl;

import com.clinical.entity.Odontologo;
import com.clinical.entity.OdontologoDto;
import com.clinical.repository.IOdonotologoRepository;
import com.clinical.service.IOdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    IOdontologoService odontologoService;

    @Autowired
    IOdonotologoRepository odonotologoRepository;

    OdontologoDto crearOdontologo(){
        OdontologoDto odontologoDto=new OdontologoDto();
        odontologoDto.setApellido("test");
        odontologoDto.setNombre("tesst");
        odontologoDto.setMatricula(12345678);
        return odontologoService.guardarOdontologo(odontologoDto);
    }

    @Test
    void guardarOdontologo() {
        OdontologoDto test=crearOdontologo();
        Assertions.assertNotNull(test);
    }

    @Test
    void buscarTodos() {
        Assertions.assertTrue(odontologoService.buscarTodos().size()>0);
    }

    @Test
    void buscarOdontologo() throws Exception {
        OdontologoDto o= odontologoService.buscarOdontologo(1L);
        Assertions.assertEquals(1L,o.getId());
    }

    @Test
    void eliminarOdontologo() {
        OdontologoDto o= crearOdontologo();
        odontologoService.eliminarOdontologo(o.getId());
        Optional<Odontologo> odontologo=odonotologoRepository.findById(o.getId());
        Assertions.assertFalse(odontologo.isPresent());
    }
    //el test modificarOdontologo() no lo implemento porque utiliza la misma logica que guardarOdontologo().
}