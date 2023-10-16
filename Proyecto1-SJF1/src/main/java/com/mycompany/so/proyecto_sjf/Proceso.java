package com.mycompany.so.proyecto_sjf;


public class Proceso {
    public String nombre;
    public int tiempoLlegada;
    public int duracion;
    public boolean finalizado;
    
    public Proceso procesoSiguiente;
    public Proceso procesoAnterior;

    public Proceso(String nombre, int tiempoLlegada, int duracion, boolean finalizado, Proceso procesoSiguiente, Proceso procesoAnterior) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
        this.finalizado = finalizado;
        this.procesoSiguiente = procesoSiguiente;
        this.procesoAnterior = procesoAnterior;
    }

    public Proceso(String nombre, int tiempoLlegada, int duracion, boolean finalizado) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
        this.finalizado = finalizado;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
   
    public Proceso getProcesoSiguiente() {
        return procesoSiguiente;
    }

    public void setProcesoSiguiente(Proceso procesoSiguiente) {
        this.procesoSiguiente = procesoSiguiente;
    }

    public Proceso getProcesoAnterior() {
        return procesoAnterior;
    }

    public void setProcesoAnterior(Proceso procesoAnterior) {
        this.procesoAnterior = procesoAnterior;
    }
}
