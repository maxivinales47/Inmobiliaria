package com.matirenzomaxi.inmobiliaria;

import java.io.IOException;
import java.util.Random;

public class GestionInmobiliaria {

    private static Menu menu;
    private static Inmobiliaria inmobiliaria;
    private static final Random random = new Random();
    
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Programa iniciado.");
        
        inmobiliaria = new Inmobiliaria();
        
        menu = new Menu(inmobiliaria);
        
        while (menu.ejecutar());
        
        System.out.println("Presiona una tecla para cerrar el programa...");
        System.in.read();
    }
}
