package com.clinical.controller;

import com.clinical.entity.*;
import com.clinical.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/turnos/")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @Autowired
    ObjectMapper mapper;

    @PostMapping("guardar")
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoDto turnoDto) throws Exception {
        turnoService.guardarTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("buscar_todos")
    public List<TurnoDto> buscarTodos(){
        return turnoService.buscarTodos();
    }

    @GetMapping("buscar_{id}")
    public TurnoDto buscarTurno(@PathVariable Long id) throws Exception {
        return turnoService.buscarTurno(id);
    }

    @DeleteMapping("eliminar_{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("modificar")
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDto turnoDto){
        turnoService.modificarTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
