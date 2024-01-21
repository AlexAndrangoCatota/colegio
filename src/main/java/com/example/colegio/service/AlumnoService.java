package com.example.colegio.service;

import com.example.colegio.model.Alumno;
import com.example.colegio.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    IAlumnoRepository alumnoRepository;

    public ArrayList<Alumno> getAlumno(){
        return (ArrayList<Alumno>) alumnoRepository.findAll();
    }
    public Optional<Alumno> getById(Integer idalumno){
        return alumnoRepository.findById(idalumno);
    }
    public Alumno saveAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }
    public Alumno updateById(Alumno request, Integer idalumno){
        Alumno alumno = alumnoRepository.findById(idalumno).get();
        alumno.setNombre(request.getNombre());
        alumno.setApellido(request.getApellido());
        alumno.setMaestroIdmaestro(request.getMaestroIdmaestro());
        alumnoRepository.save(alumno);
        return alumno;
    }
    public boolean deleteAlumno(Integer idalumno){
        alumnoRepository.deleteById(idalumno);
        return true;
    }
}
