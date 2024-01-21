package com.example.colegio.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Maestro {
    private int idmaestro;
    private String nombre;
    private String apellido;
    private String titulo;
    private Collection<Alumno> alumnosByIdmaestro;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmaestro", nullable = false)
    public int getIdmaestro() {
        return idmaestro;
    }

    public void setIdmaestro(int idmaestro) {
        this.idmaestro = idmaestro;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = -1)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido", nullable = true, length = -1)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "titulo", nullable = true, length = -1)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maestro maestro = (Maestro) o;

        if (idmaestro != maestro.idmaestro) return false;
        if (nombre != null ? !nombre.equals(maestro.nombre) : maestro.nombre != null) return false;
        if (apellido != null ? !apellido.equals(maestro.apellido) : maestro.apellido != null) return false;
        if (titulo != null ? !titulo.equals(maestro.titulo) : maestro.titulo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmaestro;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "maestroByMaestroIdmaestro")
    public Collection<Alumno> getAlumnosByIdmaestro() {
        return alumnosByIdmaestro;
    }

    public void setAlumnosByIdmaestro(Collection<Alumno> alumnosByIdmaestro) {
        this.alumnosByIdmaestro = alumnosByIdmaestro;
    }
}
