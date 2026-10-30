package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Inscripcion;
import org.example.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class InscripcionService implements InscripcionConsulta {

    private final List<Inscripcion> inscripciones = new ArrayList<>();

    public boolean inscribir(Usuario estudiante, Asignatura asignatura) {
        return false;
    }

    public List<Asignatura> obtenerAsignaturasEstudiante(Usuario estudiante) {
        return null;
    }

    @Override
    public boolean estaInscripto(Usuario estudiante, Asignatura asignatura) {
        return false;
    }

}
