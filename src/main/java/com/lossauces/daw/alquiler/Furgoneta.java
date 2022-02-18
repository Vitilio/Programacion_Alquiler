/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lossauces.daw.alquiler;

/**
 *
 * @author daw1
 */
public class Furgoneta extends Vehiculo{
    private float capacidad;

    public Furgoneta() {
    }
    
    public Furgoneta(float capacidad, String matricula, Grupo grupo) {
        super(matricula, grupo);
        this.capacidad = capacidad;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return super.toString()+","+ capacidad;
    }

    @Override
    public float getPrecioAlquiler() {
        return getGrupo().getBase()+getGrupo().getVariableFurgoneta()*capacidad;
    }
    
    
}
