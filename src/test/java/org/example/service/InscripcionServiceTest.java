package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Rol;
import org.example.entities.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InscripcionServiceTest {

  @Test
  void crearInscripcionExitosa() {
    InscripcionService service = new InscripcionService();
    Usuario estudiante = new Usuario("Juan", "Perez", Rol.ESTUDIANTE);
    Usuario profesor = new Usuario("Maria", "Lopez", Rol.PROFESOR);
    Asignatura asignatura = new Asignatura("Algoritmos", "Mañana", profesor);

    service.inscribir(estudiante, asignatura);

    assertTrue(service.estaInscripto(estudiante, asignatura), "El estudiante deberia figurar inscripto correctamente");
  }

  @Test
  void crearInscripcionDuplicadaLanzaExcepcion() {
    InscripcionService service = new InscripcionService();
    Usuario estudiante = new Usuario("Juan", "Perez", Rol.ESTUDIANTE);
    Usuario profesor = new Usuario("Maria", "Lopez", Rol.PROFESOR);
    Asignatura asignatura = new Asignatura("Algoritmos", "Mañana", profesor);

    service.inscribir(estudiante, asignatura);

    assertThrows(IllegalStateException.class, () -> {
      service.inscribir(estudiante, asignatura);
    }, "Deberia lanzar IllegalStateException al intentar inscribir al mismo alumno dos veces");
  }

  @Test
  void intentarListarInscripcionesAlumnoInexistente() {
    InscripcionService service = new InscripcionService();
    Usuario estudianteNuevo = new Usuario("Lucia", "Gomez", Rol.ESTUDIANTE);

    var asignaturas = service.obtenerAsignaturasEstudiante(estudianteNuevo);

    assertTrue(asignaturas.isEmpty(), "Un alumno sin inscripciones debe retornar una lista vacia");
  }
}