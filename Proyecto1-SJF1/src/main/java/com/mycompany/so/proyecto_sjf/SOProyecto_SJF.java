package com.mycompany.so.proyecto_sjf;
import java.util.*;

public class SOProyecto_SJF {
    static Scanner teclado = new Scanner(System.in);
    static boolean apropiativo;
    static int numProcesos;
    static Lista listaProcesos = Lista();
    
    public static void main(String[] args) {
        inicio();
        apropiativo = menuApropiativoSeleccion();
        numProcesos = numeroProcesos();
        //creacionProcesos(numProcesos);
        int tiempoTotal = creacionProcesos(numProcesos);      
        System.out.println("Todos los procesos suman: "+ tiempoTotal +" mseg\n");
        
        if(apropiativo == true){ //No Apropiativo
            
        }
        else{  //Apropiativo
            
        }
    }
    
    public static boolean menuApropiativoSeleccion(){
        System.out.println("Este es el programa SJF\n"
                    + "Quieres que sea:\n"
                    + "1)Apropiativo\n"
                    + "2)No Apropiativo");
        int x = teclado.nextInt();
        switch(x){
            case 1:
                return true;
                //break;
            case 2:
                return false;
                //break;
            default:
                System.out.println("Opcion no valida\n default: No apropiativo");
                return false;
                //break;
        }
    }
    public static int numeroProcesos(){
        int numProcesos = 0;
        
        System.out.println("\nCuantos procesos quieres crear?");
        numProcesos = teclado.nextInt();
        return numProcesos;
        
    }
    
    public static int creacionProcesos(int numProcesos){
        
        Proceso proceso[] = new Proceso[numProcesos];
        String nombre;
        int duracion;
        int tiempoLlegada;
        
        for(int i = 0; i < numProcesos; i++){
            System.out.println("\nDame el nombre del proceso: "+(i+1));
            nombre = teclado.next();
            System.out.println("Dame la duracion del proceso");
            duracion = teclado.nextInt();
            System.out.println("Dame el tiempo de llegada del proceso");
            tiempoLlegada = teclado.nextInt();
            
            proceso[i] = new Proceso(nombre, tiempoLlegada, duracion, false);
            listaProceso.insertar(proceso[i]);
        }
        
        int tiempoTotal = 0;
        for(int i=0; i<numProcesos; i++){
            tiempoTotal += proceso[i].duracion;
        }
        return tiempoTotal;
    }
    
    public static void inicio(){
        System.out.print("\tSimulador Planificador de procesos Shortest Job First (SJF)\t Equipo 02\n");
        Scanner teclado = new Scanner (System.in);
        String seguir;
        System.out.print("\nIntegrantes:\n "
        		+ "\tMatias Zavala, Melissa Maruuati\n "
        		+ "\tBohorquez Escudero, Julio\n "
        		+ "\tGuillen Luna, Adair Isaí\n "
        		+ "\tMedrano Miranda, Daniel Ulises\n");
        		//+ "Presione una tecla para continuar...");
        /*try
        {
            seguir = teclado.nextLine();
        }
        catch(Exception e)
        {}
        System.out.print("\033[H\033[2J");*/
    }
}


