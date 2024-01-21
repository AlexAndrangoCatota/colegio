package com.example.colegio.repository;

import com.example.colegio.model.AlumnoHasMaterias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoHasMateriasRepository extends JpaRepository<AlumnoHasMaterias, Integer> {
}
