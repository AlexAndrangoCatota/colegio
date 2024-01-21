package com.example.colegio.controller;

import com.example.colegio.model.Materia;
import com.example.colegio.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriaController {
    @Autowired
    MateriaService materiaService;
    @PostMapping("/mostrartodo")
    public ArrayList<Materia> getMateria(){
        return materiaService.getMateria();
    }
    @PostMapping("/mostrarporid/{id]")
    public Optional<Materia>getById(@PathVariable("id")Integer idMateria){
        return materiaService.getById(idMateria);
    }
    @PostMapping("/guardar")
    public Materia saveMateria(@RequestBody Materia materia){
        return materiaService.saveMateria(materia);
    }
    @PostMapping(path = "editar/{id}")
    public Materia updateMateriaById(@RequestBody Materia request,
                                     @PathVariable("id")Integer id){
        return materiaService.updateById(request, id);
    }
    @PostMapping(path = "/eliminar/{id}")
    public String deleteById(@PathVariable("id")Integer idmateria){
        boolean ok = materiaService.deleteMatetia(idmateria);
        if (ok){
        return "Eliminado"+idmateria;}else {
            return "error al eliminar "+idmateria;
        }
    }

}
