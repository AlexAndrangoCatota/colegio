package com.example.colegio.repository;

import com.example.colegio.model.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaestroRepository extends JpaRepository<Maestro, Integer> {
}
