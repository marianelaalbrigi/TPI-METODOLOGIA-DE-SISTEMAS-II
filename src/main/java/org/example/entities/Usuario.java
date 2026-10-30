package org.example.entities;

public class Usuario {

    private String nombre;
    private String apellido;
    private Rol rol;

    public Usuario(String nombre, String apellido, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public String getNombreCompleto() {
        String nombreCompleto = nombre + " " +  apellido;
        return nombreCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Rol getRol() {
        return rol;
    }

}
