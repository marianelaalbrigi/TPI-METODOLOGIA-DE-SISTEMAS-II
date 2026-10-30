package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Usuario;

public interface InscripcionConsulta {

    boolean estaInscripto(Usuario estudiante, Asignatura asignatura);

}
