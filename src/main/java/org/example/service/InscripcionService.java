package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Inscripcion;
import org.example.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

// Gestiona las inscripciones y permite consultar si un estudiante pertenece a una asignatura.
public class InscripcionService implements InscripcionConsulta {

    private final List<Inscripcion> inscripciones = new ArrayList<>();

    //Registra al estudiante en una asignatura.
    public boolean inscribir(Usuario estudiante, Asignatura asignatura) {
        if (estaInscripto(estudiante, asignatura)) {
            return false;
        }
        Inscripcion inscripcion = new Inscripcion(estudiante, asignatura);
        inscripciones.add(inscripcion);
        return true;
    }

    // Obtiene todas las asignaturas en las que está inscripto el estudiante.
    public List<Asignatura> obtenerAsignaturasEstudiante(Usuario estudiante) {
        List<Asignatura> asignaturasEstudiante = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getEstudiante().equals(estudiante)) {
                asignaturasEstudiante.add(inscripcion.getAsignatura());
            }
        }
        return asignaturasEstudiante;
    }

    // Devuelve los estudiantes inscriptos en una asignatura determinada.
    public List<Usuario> obtenerEstudiantesAsignatura(Asignatura asignatura) {
        List<Usuario> estudiantes = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getAsignatura().equals(asignatura)) {
                estudiantes.add(inscripcion.getEstudiante());
            }
        }
        return estudiantes;
    }

    // Permite comprobar una inscripción sin depender directamente de InscripcionService
    @Override
    public boolean estaInscripto(Usuario estudiante, Asignatura asignatura) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getEstudiante().equals(estudiante) && inscripcion.getAsignatura().equals(asignatura)) {
                return true;
            }
        }
        return false;
    }

}
