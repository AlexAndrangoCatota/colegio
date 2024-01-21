package com.example.colegio.service;

import com.example.colegio.model.Maestro;
import com.example.colegio.repository.IMaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MaestroService {
    @Autowired
    IMaestroRepository maestroRepository;

    public ArrayList<Maestro> getMaestro(){
        return (ArrayList<Maestro>) maestroRepository.findAll();
    }
    public Optional<Maestro> getById(Integer idmaestro){
        return maestroRepository.findById(idmaestro);
    }
    public Maestro saveMaestro(Maestro maestro){
        return maestroRepository.save(maestro);
    }
    public Maestro updateById(Maestro request, Integer idmaestro){
        Maestro maestro = maestroRepository.findById(idmaestro).get();
        maestro.setNombre(request.getNombre());
        maestro.setApellido(request.getApellido());
        maestro.setTitulo(request.getTitulo());
        maestroRepository.save(maestro);
        return maestro;
    }
    public boolean deleteMaestro(Integer idmaestro){
        maestroRepository.deleteById(idmaestro);
        return true;
    }

}
