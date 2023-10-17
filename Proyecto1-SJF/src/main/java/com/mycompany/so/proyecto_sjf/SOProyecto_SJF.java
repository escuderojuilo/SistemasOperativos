package com.mycompany.so.proyecto_sjf;
import java.util.*;

public class SOProyecto_SJF {
    static Scanner teclado = new Scanner(System.in);
    static boolean apropiativo;
    static int numProcesos;
    static Lista listaProcesos = new Lista();
    static int tiempo = 0;
    static int tiempoTotal;
    
    public static void main(String[] args) {
        inicio();
        apropiativo = menuApropiativoSeleccion();
        numProcesos = numeroProcesos();
        tiempoTotal = creacionProcesos(numProcesos);      
        System.out.println("Todos los procesos suman: " + tiempoTotal + " mseg\n");
        
        if (listaProcesos.getLength() != 0) {
            System.out.println("Los procesos registrados son: " + listaProcesos.listar());
            listaProcesos = listaProcesos.merge_sort();
            System.out.println("Los procesos ya ordenados por tiempo de llegada son: " + listaProcesos.listar());
            tiempo = listaProcesos.peak().getTiempoLlegada();  
            System.out.println(""); 

            if (apropiativo) {
                siApropiativo();
            } else {
                noApropiativo();
            }
        }
    }
    
    public static void siApropiativo() {
        while (tiempo <= tiempoTotal) {
            System.out.println("Tiempo actual: " + tiempo);
            
            // Comprobar si hay procesos en la cola de procesos listos para ejecución
            if (!listaProcesos.isEmpty()) {
                Proceso procesoActual = listaProcesos.peak();
                
                // Verificar si el proceso está listo para ejecutarse (su tiempo de llegada ha llegado)
                if (procesoActual.getTiempoLlegada() <= tiempo) {
                    // Asignar la CPU al proceso y ejecutarlo
                    System.out.println("Ejecutando proceso: " + procesoActual.getNombre());
                    
                    // Aquí puedes implementar la lógica de planificación SJF
                    // ...

                    // Actualizar el tiempo y eliminar el proceso de la cola
                    tiempo += procesoActual.getDuracion();
                    listaProcesos.pop();
                } else {
                    // No hay procesos listos para ejecutarse en este momento, avanzar en el tiempo
                    tiempo++;
                }
            } else {
                // No hay procesos en la cola, avanzar en el tiempo
                tiempo++;
            }
        }
    }

    // Recuerda implementar la lógica
    public static void noApropiativo() {
        // Implementa la lógica de la planificación no apropiativa
    }
    
    public static boolean menuApropiativoSeleccion() {
        System.out.println("Este es el programa SJF\n"
                    + "¿Quieres que sea:\n"
                    + "1) Apropiativo\n"
                    + "2) No Apropiativo");
        int x = teclado.nextInt();
        switch(x) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Opción no válida, seleccionando No Apropiativo por defecto");
                return false;
        }
    }
    
    public static int numeroProcesos() {
        int numProcesos = 0;
        
        System.out.println("\n¿Cuántos procesos quieres crear?");
        numProcesos = teclado.nextInt();
        return numProcesos;
    }
    
    public static int creacionProcesos(int numProcesos) {
        Proceso proceso[] = new Proceso[numProcesos];
        String nombre;
        int duracion;
        int tiempoLlegada;
        
        for (int i = 0; i < numProcesos; i++) {
            System.out.println("\nDame el nombre del proceso: " + (i + 1));
            nombre = teclado.next();
            System.out.println("Dame la duración del proceso");
            duracion = teclado.nextInt();
            System.out.println("Dame el tiempo de llegada del proceso " + (i + 1));
            tiempoLlegada = teclado.nextInt();
            proceso[i] = new Proceso(nombre, tiempoLlegada, duracion, false);
            listaProcesos.insertar(proceso[i]);
        }
        
        int tiempoTotal = 0;
        for (int i = 0; i < numProcesos; i++) {
            tiempoTotal += proceso[i].getDuracion();
        }
        return tiempoTotal;
    }
    
    public static void inicio() {
        System.out.print("\tSimulador Planificador de procesos Shortest Job First (SJF)\t Equipo 02\n");
        String seguir;
        System.out.print("\nIntegrantes:\n "
                + "\tMatias Zavala, Melissa Maruuati\n "
                + "\tBohorquez Escudero, Julio\n "
                + "\tGuillen Luna, Adair Isaí\n "
                + "\tMedrano Miranda, Daniel Ulises\n");
    }
}
