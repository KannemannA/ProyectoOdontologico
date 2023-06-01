package com.clinical.controller;

import com.clinical.entity.PacienteDto;
import com.clinical.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pacientes/")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("guardar")
    public ResponseEntity<?> guardarPaciente(@ModelAttribute PacienteDto pacienteDto) throws IOException {
        pacienteService.guardarPaciente(pacienteDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("buscar_todos")
    public List<PacienteDto> buscarTodos(){
        return pacienteService.buscarTodos();
    }

    @GetMapping("buscarn_{nombre}")
    public PacienteDto buscarPorNombre(@PathVariable String nombre) throws Exception {
        return pacienteService.buscarPorNombre(nombre);
    }

    @GetMapping("buscar_{id}")
    public PacienteDto buscarPaciente(@PathVariable Long id) throws Exception {
        return pacienteService.buscarPaciente(id);
    }

    @DeleteMapping("eliminar_{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("modificar")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDto pacienteDto) throws IOException {
        pacienteService.modificarPaciente(pacienteDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
