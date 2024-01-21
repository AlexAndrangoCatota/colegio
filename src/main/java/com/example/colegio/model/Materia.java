package com.example.colegio.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Materia {
    private int idmateria;
    private String descripcion;
    private String puntos;
    private Collection<AlumnoHasMaterias> alumnoHasMateriasByIdmateria;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmateria", nullable = false)
    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "puntos", nullable = true, length = -1)
    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Materia materia = (Materia) o;

        if (idmateria != materia.idmateria) return false;
        if (descripcion != null ? !descripcion.equals(materia.descripcion) : materia.descripcion != null) return false;
        if (puntos != null ? !puntos.equals(materia.puntos) : materia.puntos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmateria;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (puntos != null ? puntos.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "materiaByMateriaIdmateria")
    public Collection<AlumnoHasMaterias> getAlumnoHasMateriasByIdmateria() {
        return alumnoHasMateriasByIdmateria;
    }

    public void setAlumnoHasMateriasByIdmateria(Collection<AlumnoHasMaterias> alumnoHasMateriasByIdmateria) {
        this.alumnoHasMateriasByIdmateria = alumnoHasMateriasByIdmateria;
    }
}
