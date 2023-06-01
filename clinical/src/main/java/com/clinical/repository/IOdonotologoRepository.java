package com.clinical.repository;

import com.clinical.entity.Odontologo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface IOdonotologoRepository extends JpaRepository<Odontologo,Long> {

    @Query("SELECT o FROM Odontologo o WHERE o.nombre like %?1% OR o.apellido like %?1%")
    List<Odontologo> buscarOdontologosPorNombre(String nombre);

}
