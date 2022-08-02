package Clase23_06.Ejemplos.Primero.Mains;

import Clase23_06.Ejemplos.Primero.Logica.*;


public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona(12345, "Pepito");
        System.out.println("**** Persona ****");
        System.out.println(persona.showInformation()); // Cuando lo imprimimos usamos el metodo ToString
        
        Estudiante estudiante = new Estudiante(12, "Juanito", "DS");
        System.out.println("**** Estudiante ****");
        System.out.println(estudiante.showInformation());
        
        Persona[] listadoPersonas = new Persona[3];
        listadoPersonas[0] = new Estudiante(1, "Pepito", "DS");
        listadoPersonas[1] = new Estudiante(2, "Junaito", "DS");
        listadoPersonas[2] = new Persona(3, "Pepita");
        
        System.out.println("Listado de Personas");
        for (Persona listadoPersona : listadoPersonas) {
            System.out.println(listadoPersona.showInformation() + " -> " + listadoPersona.getClass());
        }
    }   
}
