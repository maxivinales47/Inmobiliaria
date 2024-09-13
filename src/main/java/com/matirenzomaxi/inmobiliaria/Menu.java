package com.matirenzomaxi.inmobiliaria;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    
    private static Scanner scanner = new Scanner(System.in);
    private Inmobiliaria inmobiliaria;
    
    public Menu(Inmobiliaria inmobiliaria){
        this.inmobiliaria = inmobiliaria;
    }
    
    public boolean ejecutar() throws IOException, InterruptedException{ // Se ejecuta en loop
        limpiarPantalla();
        
        int opcion = mostrarMenu(); // Mostramos menu y pedimos el ingreso de una opción
        switch (opcion){
            case 0 -> { // Matriculación a carrera
                iniciarMatriculacion();
            }
            case 1 -> { // Inscripción a materia (debe estar matriculado en carrera)
                iniciarInscripcionMateria();
            }
            case 2 -> { // Cargar situacion final de alumno (debe estar inscripto en la materia)
                cargarSituacionFinal();
            }
            case 3 -> { // Mostrar alumnos por materia, cada alumno -> materias finalizadas/inscriptas, (si finalizo la materia mostrar situación final e inasistencias)
                mostrarEstadoAlumnos();
            }
            case 4 -> { // Cargar asistencia de todos los alumnos de una materia. (el nombre del profesor que carga la asistencia debe ser el mismo que el profesore que da la materia)
                cargarInasistencia();
            }
            case 5-> { // Informacion de una carrera: mostrar materias, cuatrimestre, y profesor
                mostrarInformacionCarrera();
            }
            case 6 -> { // Salir del programa
                return false; // Devolvemos un valor falso para que el programa salga del bucle infinito.
            }
        }
        
        System.out.println("Presione una tecla para continuar...");
        System.in.read();
        
        return true;
    }
    
    private int mostrarMenu(){
        System.out.println("Menu:");
        System.out.println("0 - Matricular alumno a una carrera.");
        System.out.println("1 - Inscribir alumno a una materia.");
        System.out.println("2 - Cargar situacion final del alumno.");
        System.out.println("3 - Mostrar estado de alumnos de una materia.");
        System.out.println("4 - Cargar asistencia de alumnos.");
        System.out.println("5 - Mostrar informacion sobre una carrera.");
        System.out.println("6 - Salir del programa.");
        System.out.println("Ingrese la accion que desea realizar...");
        return leerInt(0, 6);
    }
    
    // Solo funciona cuando es ejecuta como programa, no desde el IDE
    private static void limpiarPantalla() throws IOException, InterruptedException{
        String os = System.getProperty("os.name");
        if (os.contains("Windows")){ // Comando para Windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else{ // Comando para UNIX (Linux, MacOS)
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    }
    
    private static int leerInt(int minValor, int maxValor){
        int entrada = 0;
        do {
            try {
                entrada = scanner.nextInt();
                
                if (entrada >= minValor && entrada <= maxValor){ // Cerrar loop si la entrada cumple con las condiciones de valor mínimo y máximo
                    break;
                }
            }
            catch (Error e) {
                System.out.println("Numero invalido. Ingrese nuevamente.");
                scanner.nextLine();
                continue;
            }
            
            System.out.println("Numero invalido. Ingrese nuevamente.");
        } while (entrada < minValor || entrada > maxValor);
        return entrada;
    }
}
