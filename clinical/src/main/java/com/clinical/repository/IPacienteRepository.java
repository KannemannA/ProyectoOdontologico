package com.clinical.repository;

import com.clinical.entity.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {

    @Query("SELECT p FROM Paciente p WHERE p.nombre =?1")
    Optional<Paciente> buscarPacientePorNombre(String nombre);

}
