package org.example.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void obtenerNombreCompletoExitoso() {
        Usuario usuario = new Usuario("Maria", "Gomez", Rol.PROFESOR);

        String nombreCompleto = usuario.getNombreCompleto();

        assertEquals("Maria Gomez", nombreCompleto, "El nombre completo debe formarse uniendo nombre y apellido con un espacio");
    }

    @Test
    void usuariosIgualesDebenSerEquivalentes() {
        Usuario usuario1 = new Usuario("Juan", "Perez", Rol.ESTUDIANTE);
        Usuario usuario2 = new Usuario("Juan", "Perez", Rol.ESTUDIANTE);

        assertEquals(usuario1, usuario2, "Dos usuarios con el mismo nombre, apellido y rol deben ser considerados iguales por equals");
    }
}