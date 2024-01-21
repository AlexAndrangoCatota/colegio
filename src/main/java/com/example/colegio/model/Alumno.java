package com.example.colegio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
//@Builder
@NoArgsConstructor
public class Alumno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idalumno", nullable = false)
    private int idalumno;
    @Column(name = "nombre", nullable = true, length = -1)
    private String nombre;
    @Column(name = "apellido", nullable = true, length = -1)
    private String apellido;

    private Integer maestroIdmaestro;
    private Maestro maestroByMaestroIdmaestro;
    private Collection<AlumnoHasMaterias> alumnoHasMateriasByIdalumno;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (idalumno != alumno.idalumno) return false;
        if (nombre != null ? !nombre.equals(alumno.nombre) : alumno.nombre != null) return false;
        if (apellido != null ? !apellido.equals(alumno.apellido) : alumno.apellido != null) return false;
        if (maestroIdmaestro != null ? !maestroIdmaestro.equals(alumno.maestroIdmaestro) : alumno.maestroIdmaestro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idalumno;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (maestroIdmaestro != null ? maestroIdmaestro.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "maestro_idmaestro", referencedColumnName = "idmaestro")
    public Maestro getMaestroByMaestroIdmaestro() {
        return maestroByMaestroIdmaestro;
    }

    public void setMaestroByMaestroIdmaestro(Maestro maestroByMaestroIdmaestro) {
        this.maestroByMaestroIdmaestro = maestroByMaestroIdmaestro;
    }

    @OneToMany(mappedBy = "alumnoByAlumnoIdalumno")
    public Collection<AlumnoHasMaterias> getAlumnoHasMateriasByIdalumno() {
        return alumnoHasMateriasByIdalumno;
    }

    public void setAlumnoHasMateriasByIdalumno(Collection<AlumnoHasMaterias> alumnoHasMateriasByIdalumno) {
        this.alumnoHasMateriasByIdalumno = alumnoHasMateriasByIdalumno;
    }
}
