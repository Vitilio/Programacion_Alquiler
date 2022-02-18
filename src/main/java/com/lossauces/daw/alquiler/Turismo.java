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
public class Turismo extends Vehiculo {

    private int plazas;

    public Turismo() {
    }

    public Turismo(int plazas, String matricula, Grupo grupo) {
        super(matricula, grupo);
        this.plazas = plazas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return super.toString() + "," + plazas;
    }

    @Override
    public float getPrecioAlquiler() {
        return getGrupo().getBase()+getGrupo().getVariableTurismo()*plazas;
    }

}
