package com.example.colegio.service;

import com.example.colegio.model.AlumnoHasMaterias;
import com.example.colegio.repository.IAlumnoHasMateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlumnoHasMateriasService {
    @Autowired
    IAlumnoHasMateriasRepository alumnoHasMateriasRepository;

    public ArrayList<AlumnoHasMaterias> getAlumnoHasMaterias(){
        return (ArrayList<AlumnoHasMaterias>) alumnoHasMateriasRepository.findAll();
    }
    public Optional<AlumnoHasMaterias> getById(Integer idalumhasmateri){
        return alumnoHasMateriasRepository.findById(idalumhasmateri);
    }
    public AlumnoHasMaterias saveAlumnoHasMaterias(AlumnoHasMaterias alumnoHasMaterias){
        return alumnoHasMateriasRepository.save(alumnoHasMaterias);
    }
    public AlumnoHasMaterias updateById(AlumnoHasMaterias request, Integer id){
        AlumnoHasMaterias alumnomateria = alumnoHasMateriasRepository.findById(id).get();
        alumnomateria.setAlumnoIdalumno(request.getAlumnoIdalumno());
        alumnomateria.setMateriaIdmateria(request.getMateriaIdmateria());
        alumnoHasMateriasRepository.save(alumnomateria);
        return alumnomateria;
    }
    public boolean deleteAlumnoMateria(Integer id){
        alumnoHasMateriasRepository.deleteById(id);
        return true;
    }

}
