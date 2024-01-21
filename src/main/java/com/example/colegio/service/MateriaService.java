package com.example.colegio.service;

import com.example.colegio.model.Materia;
import com.example.colegio.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MateriaService {
    @Autowired
    IMateriaRepository materiaRepository;
    public ArrayList<Materia> getMateria(){
        return (ArrayList<Materia>) materiaRepository.findAll();
    }
    public Optional<Materia> getById(Integer idmateria){
        return materiaRepository.findById(idmateria);
    }
    public Materia saveMateria(Materia materia){
        return materiaRepository.save(materia);
    }
    public Materia updateById(Materia request, Integer idmateria){
        Materia materia = materiaRepository.findById(idmateria).get();
        materia.setDescripcion(request.getDescripcion());
        materia.setPuntos(request.getPuntos());
        materiaRepository.save(materia);
        return materia;
    }
    public boolean deleteMatetia(Integer idMateria){
        materiaRepository.deleteById(idMateria);
        return true;
    }


}
