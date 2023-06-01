package com.clinical.repository;

import com.clinical.entity.Turno;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Long> {
}
