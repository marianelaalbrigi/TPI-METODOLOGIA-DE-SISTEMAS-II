package org.example.service;

import org.example.entities.Asignatura;
import org.example.entities.Rol;
import org.example.entities.Usuario;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class AsignaturaServiceTest {

    @Test
    void crearAsignaturaExitosa() {
        AsignaturaService service = new AsignaturaService();
        Usuario profesor = new Usuario("Ana", "Gomez", Rol.PROFESOR);

        service.cargarAsignatura(profesor, "Matematica", "Mañana");

        assertEquals(1, service.obtenerAsignaturas().size(), "La asignatura deberia haberse agregado a la lista del servicio");
    }

    @Test
    void intentarListarMateriaInexistente() {
        AsignaturaService service = new AsignaturaService();

        Optional<Asignatura> resultado = service.buscarAsignatura("MateriaFalsa");

        assertTrue(resultado.isEmpty(), "La busqueda de una materia que no existe debe retornar un Optional vacio");
    }

    @Test
    void cambiarTurnoAsignaturaInexistenteLanzaExcepcion() {
        AsignaturaService service = new AsignaturaService();
        Usuario profesor = new Usuario("Ana", "Gomez", Rol.PROFESOR);

        assertThrows(IllegalArgumentException.class, () -> {
            service.cambiarTurno(profesor, "Fisica", "Noche");
        }, "Deberia lanzar IllegalArgumentException si la asignatura no existe o no pertenece al profesor");
    }
}