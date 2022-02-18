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
public enum Grupo {
    A (50,1.5F,5),B (55,2,10),C (60,2.5F,15);
    
    private int base;
    private float variableTurismo;
    private int variableFurgoneta;

    private Grupo(int base, float variableTurismo, int variableFurgoneta) {
        this.base = base;
        this.variableTurismo = variableTurismo;
        this.variableFurgoneta = variableFurgoneta;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public float getVariableTurismo() {
        return variableTurismo;
    }

    public void setVariableTurismo(float variableTurismo) {
        this.variableTurismo = variableTurismo;
    }

    public int getVariableFurgoneta() {
        return variableFurgoneta;
    }

    public void setVariableFurgoneta(int variableFurgoneta) {
        this.variableFurgoneta = variableFurgoneta;
    }
    
    
}
