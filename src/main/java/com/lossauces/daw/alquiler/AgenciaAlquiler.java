/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lossauces.daw.alquiler;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 *
 * @author daw1
 */
public class AgenciaAlquiler {

    private String nombre;
    private List<Vehiculo> flota;

    public AgenciaAlquiler() {
    }

    public AgenciaAlquiler(String nombre, List<Vehiculo> flota) {
        this.nombre = nombre;
        this.flota = flota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getFlota() {
        return flota;
    }

    public void setFlota(List<Vehiculo> flota) {
        this.flota = flota;
    }

    public boolean incluirVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && !flota.contains(vehiculo)) {
            return flota.add(vehiculo);
        }
        return false;
    }

    public Vehiculo consultarVehiculo(String matricula) {
        for (Vehiculo vehiculo : flota) {
            if(vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
        }
        /*
            ListIterator<Vehiculo> li=flota.listIterator();
            while(li.hasNext()){
                salida=li.next();
                if(salida.getMatricula().equals(matricula)){
                    retutn salida
                }
            }
            return null;
        
        */
        return null;
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null){
            return flota.remove(vehiculo);
        }
        return false;
    }
    
    public List<Vehiculo> listarVehiculosPorPrecio(){
        List<Vehiculo> salida = new ArrayList<>(flota);
        Collections.sort(salida, new ComparadorPrecio());
        return salida;
    }
    
    public List<Vehiculo> listarVehiculos(Grupo grupo){
        List<Vehiculo> salida = new ArrayList<>(flota);
        Collections.sort(salida);
        return salida;
    }
    
    public Vehiculo getVehiculoMasBarato(){
        return Collections.min(flota, new ComparadorPrecio());   
    }
    
    
}
