package com.example.colegio.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
////@Builder
@NoArgsConstructor
@Table(name = "alumno_has_materias", schema = "public", catalog = "colegio")
public class AlumnoHasMaterias {
    @Column(name = "alumno_idalumno", nullable = true)
    private Integer alumnoIdalumno;
    @Column(name = "materia_idmateria", nullable = true)
    private Integer materiaIdmateria;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idalumnohasmaterias", nullable = false)
    private int idalumnohasmaterias;


    private Alumno alumnoByAlumnoIdalumno;
    private Materia materiaByMateriaIdmateria;




    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idalumnohasmaterias", nullable = false)
    public int getIdalumnohasmaterias() {
        return idalumnohasmaterias;
    }

    public void setIdalumnohasmaterias(int idalumnohasmaterias) {
        this.idalumnohasmaterias = idalumnohasmaterias;
    }









    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlumnoHasMaterias that = (AlumnoHasMaterias) o;

        if (idalumnohasmaterias != that.idalumnohasmaterias) return false;
        if (alumnoIdalumno != null ? !alumnoIdalumno.equals(that.alumnoIdalumno) : that.alumnoIdalumno != null)
            return false;
        if (materiaIdmateria != null ? !materiaIdmateria.equals(that.materiaIdmateria) : that.materiaIdmateria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = alumnoIdalumno != null ? alumnoIdalumno.hashCode() : 0;
        result = 31 * result + (materiaIdmateria != null ? materiaIdmateria.hashCode() : 0);
        result = 31 * result + idalumnohasmaterias;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "alumno_idalumno", referencedColumnName = "idalumno")
    public Alumno getAlumnoByAlumnoIdalumno() {
        return alumnoByAlumnoIdalumno;
    }

    public void setAlumnoByAlumnoIdalumno(Alumno alumnoByAlumnoIdalumno) {
        this.alumnoByAlumnoIdalumno = alumnoByAlumnoIdalumno;
    }

    @ManyToOne
    @JoinColumn(name = "materia_idmateria", referencedColumnName = "idmateria")
    public Materia getMateriaByMateriaIdmateria() {
        return materiaByMateriaIdmateria;
    }

    public void setMateriaByMateriaIdmateria(Materia materiaByMateriaIdmateria) {
        this.materiaByMateriaIdmateria = materiaByMateriaIdmateria;
    }
}
