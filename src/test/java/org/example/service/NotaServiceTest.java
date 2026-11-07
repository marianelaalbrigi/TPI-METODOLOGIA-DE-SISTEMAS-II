package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Rol;
import org.example.entities.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotaServiceTest {

  @Test
  void cargarNotaExitosa() {
    InscripcionService inscripcionService = new InscripcionService();
    NotaService notaService = new NotaService(inscripcionService);

    Usuario estudiante = new Usuario("Pedro", "Gomez", Rol.ESTUDIANTE);
    Usuario profesor = new Usuario("Juan", "Perez", Rol.PROFESOR);
    Asignatura asignatura = new Asignatura("Base de Datos", "Noche", profesor);

    inscripcionService.inscribir(estudiante, asignatura);
    notaService.publicarNota(estudiante, asignatura, 9.5);

    assertEquals(1, notaService.obtenerNotasEstudiante(estudiante).size(), "La nota debe publicarse exitosamente si el alumno esta inscripto");
  }

  @Test
  void cargarNotaSinEstarInscripto() {
    InscripcionService inscripcionService = new InscripcionService();
    NotaService notaService = new NotaService(inscripcionService);

    Usuario estudiante = new Usuario("Pedro", "Gomez", Rol.ESTUDIANTE);
    Usuario profesor = new Usuario("Juan", "Perez", Rol.PROFESOR);
    Asignatura asignatura = new Asignatura("Base de Datos", "Noche", profesor);

    // No lo inscribimos, por lo que publicarNota debe fallar por el control de NotaService
    assertThrows(IllegalStateException.class, () -> {
      notaService.publicarNota(estudiante, asignatura, 8.0);
    }, "Deberia lanzar IllegalStateException si se intenta publicar nota a un estudiante no inscripto");
  }
}