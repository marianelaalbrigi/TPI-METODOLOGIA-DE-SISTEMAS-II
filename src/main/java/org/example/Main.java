package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // Simulación de persistencia en memoria mediante ArrayList.

    // Asignatura: [0] profesor, [1] nombre de asignaturas, [2] turno.
    static ArrayList<String[]> bdAsignaturasDisponibles = new ArrayList<String[]>();

    // Inscripción: [0] estudiante, [1] nombre de asignatura.
    static ArrayList<String[]> bdInscripciones = new ArrayList<String[]>();

    // Nota: [0] asignatura, [1] estudiante, [2] nota.
    static ArrayList<String[]> notas = new ArrayList<String[]>();

    public static void main(String[] args) {


        int opcionMenuPrincipal = -1;

        while (opcionMenuPrincipal != 0) {

            System.out.println("--- SISTEMA ACADEMICO ---");
            System.out.println("1 - Iniciar Sesión");
            System.out.println("0 - Salir del Sistema completamente");
            System.out.print("Seleccione una opción: ");
            opcionMenuPrincipal = sc.nextInt();
            sc.nextLine();

            if (opcionMenuPrincipal == 1) {

                System.out.println("Ingrese su nombre: ");
                String n = sc.nextLine();

                System.out.println("Ingrese su apellido: ");
                String ap = sc.nextLine();

                // Manejo de Rol mediante String en esta version inicial
                System.out.println("Ingrese su Rol (profesor/estudiante): ");
                String r = sc.nextLine();

                if (r.equals("profesor") || r.equals("Profesor")) {
                    int opcion;
                    do {
                        System.out.println("--- Menu (Profesor) ---");
                        System.out.println("1-Cargar Asignaturas");
                        System.out.println("2-Listar Asignaturas a cargo");
                        System.out.println("3-Cambiar turno de asignaturas");
                        System.out.println("4-Publicar Notas");
                        System.out.println("0-Cerrar Sesión");
                        opcion = sc.nextInt();
                        sc.nextLine();
                        switch (opcion) {
                            case 1:
                                cargarAsignaturas( n, ap);
                                break;
                            case 2:
                                listarAsignaturasACargo(n, ap);
                                break;
                            case 3:
                                cambiarTurno(n, ap);
                                break;
                            case 4:
                                publicarNotas(n, ap);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                                break;
                        }
                    } while (opcion != 0);

                } else if (r.equals("estudiante") || r.equals("Estudiante")) {

                    int opcion1;

                    do {
                        System.out.println("--- Menu (Estudiante) ---");
                        System.out.println("1-Inscripción a asignatura.");
                        System.out.println("2-Listar mis Asignaturas.");
                        System.out.println("3-Ver Notas.");
                        System.out.println("0-Cerrar Sesión.");
                        opcion1 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion1) {
                            case 1:
                                inscripciones(n,ap);
                                break;
                            case 2:
                                listarAsigaturasEstudiante(n,ap);
                                break;
                            case 3:
                                verNotas(n,ap);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                                break;
                        }
                    } while (opcion1 != 0);
                } else {
                    System.out.println("Rol no reconocido, debe ingresar 'profesor' o 'estudiante'");
                }
            } else if (opcionMenuPrincipal == 0) {
                System.out.println("Saliendo del sistema.");
            } else {
                System.out.println("Opcion incorrecta.");
            }

        }


    }


    public static void inscripciones (String n, String ap) {

        String alumno = n + " " + ap;
        boolean disponible = false;

        System.out.println("\n --- AIGNATURAS DISPONIBLES ---");

        for (String[] asignaturas : bdAsignaturasDisponibles) {
            System.out.println("Asignatura: " + asignaturas[1] + " | Profesor: "+ asignaturas[0]);
        }

        System.out.println("Introducir la asignatura: ");
        String as = sc.nextLine();

        for (String[] asignaturas : bdAsignaturasDisponibles) {
            if  (asignaturas[1].equals(as)) {
                disponible = true;
            }
        }
        if  (disponible) {
            String[] a = new String[2];
            a[0] = alumno;
            a[1] = as;

            bdInscripciones.add(a);
            System.out.println("Inscripcion registrada correctamente.");
        } else {
            System.out.println("Asignatura no disponible.");
        }

    }



    public static void cambiarTurno(String n, String ap) {

        String profe = n + " " + ap;
        boolean encontrado = false;

        System.out.println("Introducir la asignatura: ");
        String as = sc.nextLine();
        System.out.println("Introducir nuevo turno: ");
        String t = sc.nextLine();

        for (String[] a : bdAsignaturasDisponibles) {
            if (a[0].equals(profe) && a[1].equals(as)){
                a[2] = t;
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("Asignatura Cambiada.");
        } else {
            System.out.println("Asignatura no encontrada.");
        }

    }


    public static void cargarAsignaturas(String n, String ap){


        String prof = n + " " + ap;

        System.out.println("\n --- ALTA DE ASIGNATURA ---");

        System.out.println("Introducir el nombre de la asignatura: ");
        String as = sc.nextLine();

        System.out.println("Introducir el turno (Mañana/Tarde): ");
        String t = sc.nextLine();

        String[] a = new String[3];
        a[0] = prof;
        a[1] = as;
        a[2] = t;

        bdAsignaturasDisponibles.add(a);
        System.out.println("Asignatura " + as + " dada de alta correctamente por el profesor " + prof + ".");
    }

    // Filtra las asignaturas pertencientes al profesor que inicio sesión.
    public static ArrayList<String[]> obtenerAsignaturasACargo(String n, String ap){
        String prof = n + " " + ap;
        ArrayList<String[]> asignaturasACargo = new ArrayList<>();
        for (String[] asignaturas : bdAsignaturasDisponibles) {
            if (asignaturas[0].equals(prof)) {
                asignaturasACargo.add(asignaturas);
            }
        }
        return asignaturasACargo;
    }


    public static void listarAsignaturasACargo(String n, String ap){

        String prof =  n + " " + ap;

        ArrayList<String[]> asignaturas = obtenerAsignaturasACargo(n, ap);
        System.out.println("\n --- ASIGNATURAS A CARGO ("+ prof +") ---");

        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas disponibles.");
        } else {
            for (String[] a: asignaturas) {
                System.out.println("Materia: " + a[1] + " | Turno: " + a[2]);
            }
        }

    }

    // El profesor solo puede publicar notas en asignaturas que tiene a cargo.
    public static void publicarNotas(String n, String ap){

        ArrayList<String[]> asignaturas = obtenerAsignaturasACargo(n, ap);
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas a cargo.");
            return;
        }

        System.out.println("--- ASIGNATURAS A CARGO ---");

        for (String[] a: asignaturas) {
            System.out.println("Materia: " + a[1] + " | Turno: " + a[2]);
        }

        System.out.println("ingrese asignatura: ");
        String asSeleccionada = sc.nextLine();
        boolean encontrado = false;

        for (String[] a: asignaturas) {
            if (a[1].equals(asSeleccionada)) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("La asignatura seleccionada no esta a su cargo.");
            return;
        }

        System.out.println("--- ESTUDIANTES INSCRIPTOS ---");


        boolean existeEstudiantes = false;

        for (String[] inscripciones: bdInscripciones) {
            if (inscripciones[1].equals(asSeleccionada)) {
                System.out.println("Alumno: " + inscripciones[0]);
                existeEstudiantes = true;
            }
        }

        if (!existeEstudiantes) {
            System.out.println("No hay estudiantes inscriptos en esta asignatura.");
            return;
        }

        System.out.println("Ingrese el nombre del estudiante: ");
        String estudiante = sc.nextLine();
        boolean estudianteEncontrado = false;

        for (String[] inscripciones: bdInscripciones) {
            if (inscripciones[1].equals(asSeleccionada) && inscripciones[0].equals(estudiante)) {
                estudianteEncontrado = true;
                break;
            }
        }

        if (!estudianteEncontrado) {
            System.out.println("El estudiante no esta inscripto en esta materia.");
            return;
        }

        System.out.println("Ingrese nota");
        String nota = sc.nextLine();

        String[] nuevaNota = new String[3];
        nuevaNota[0] = asSeleccionada;
        nuevaNota[1] = estudiante;
        nuevaNota[2] = nota;

        notas.add(nuevaNota);
        System.out.println("Notas publicadas correctamente.");
    }


    // Muestra únicamente las notas correspondientes al estudiante que inicio sesión.
    public static void verNotas(String n, String ap){

        String estudiante = n + " " + ap;
        boolean tieneNotas = false;

        System.out.println("--- VER NOTAS ---");

        for (String[] nota: notas) {
            if (nota[1].equals(estudiante)) {
                System.out.println("Asignatura: " + nota[0] + " | Nota: " + nota[2]);
                tieneNotas = true;
            }
        }

        if (!tieneNotas) {
            System.out.println("No hay notas disponibles.");
        }
    }

    // Lista las asignaturas en las que se encuentra inscripto el estudiante.
    public static void listarAsigaturasEstudiante(String n, String ap){

        String estudiante = n + " " + ap;
        boolean existeEstudiantes = false;

        System.out.println("--- MIS ASIGNATURAS ---");
        for (String[] inscripciones: bdInscripciones) {
            if (inscripciones[0].equals(estudiante)) {
                System.out.println("Asignatura: " + inscripciones[1]);
                existeEstudiantes = true;
            }
        }
        if (!existeEstudiantes) {
            System.out.println("No estas inscripto en ninguna asignatura.");
        }
    }
}
