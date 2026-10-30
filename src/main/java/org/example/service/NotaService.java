package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Nota;
import org.example.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class NotaService {

    private final List<Nota> notas = new ArrayList<>();
    private final InscripcionConsulta inscripcionConsulta;

    public NotaService(InscripcionConsulta inscripcionConsulta) {
        this.inscripcionConsulta = inscripcionConsulta;
    }

    public boolean publicarNota(Usuario estudiante, Asignatura asignatura, double valor) {
        return false;
    }

    public List<Nota> obtenerNotasEstudiante(Usuario estudiante) {
        return null;
    }

}
