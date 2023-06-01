package com.clinical.repository;

import com.clinical.entity.Domicilio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//NO ES NECESARIO CREAR ESTA INTERFAZ PARA EL CORRECTO FUNCIONAMIENTO CON LOS REQUERIMIENTOS INICIALES.
//LO TENGO CREADO PARA FUTUROS FEATURES.
@Transactional
@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
    @Query("SELECT d FROM Domicilio d WHERE (d.direccion =?1 AND d.localidad=?2 AND d.provincia=?3)")
    Optional<Domicilio> buscarDomicilio(String direccion, String localidad, String provincia);
}
