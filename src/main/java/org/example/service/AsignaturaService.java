package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AsignaturaService {

    private final List<Asignatura> asignaturas = new ArrayList<>();

    public void cargarAsignatura(Usuario profesor, String nombre, String turno) {

    }

    public List<Asignatura> obtenerAsignaturasProfesor(Usuario profesor) {
        return null;
    }

    public Asignatura buscarAsignatura(String nombre){
        return null;
    }

    public boolean cambiarTurno(Usuario profesor, String nombreAsignatura, String nuevoTurno) {
        return false;
    }
}
