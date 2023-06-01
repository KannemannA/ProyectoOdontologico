package com.clinical.controller;

import com.clinical.entity.OdontologoDto;
import com.clinical.service.IOdontologoService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@GetMapping("/login")
//public String login(){
//    return "index";
//}
@CrossOrigin
@RestController
@RequestMapping("/odontologos/")
public class OdontologoController {

    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping("guardar")
    public ResponseEntity<?> guardarOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.guardarOdontologo(odontologoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("buscar_todos")
    public List<OdontologoDto> buscarTodos(){
        return odontologoService.buscarTodos();
    }

    @GetMapping("buscarn_{nombre}")
    public List<OdontologoDto> buscarPorNombre(@PathVariable String nombre) throws Exception {
        return odontologoService.buscarPorNombre(nombre);
    }

    @GetMapping("buscar_{id}")
    public OdontologoDto buscarOdontologo(@PathVariable Long id) throws Exception {
        return odontologoService.buscarOdontologo(id);
    }

    @DeleteMapping("eliminar_{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("modificar")
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.modificarOdontologo(odontologoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
