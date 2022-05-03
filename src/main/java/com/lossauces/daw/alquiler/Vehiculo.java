/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lossauces.daw.alquiler;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author daw1
 */
public abstract class Vehiculo implements Comparable<Vehiculo>,Serializable {

    private Matricula matricula;
    private Grupo grupo;

    public Vehiculo() {
    }

    public Vehiculo(Matricula matricula, Grupo grupo) {
        this.matricula = matricula;
        this.grupo = grupo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return matricula + "," + grupo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Vehiculo) {
            final Vehiculo other = (Vehiculo) obj;
            if (!Objects.equals(this.matricula, other.matricula)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.matricula);
    }

    public abstract float getPrecioAlquiler();

    public float getPrecioAlquiler(int dias) {
        return getPrecioAlquiler() * dias;
    }

}
