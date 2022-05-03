/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lossauces.daw.alquiler;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoObj implements VehiculoDao {

    private Path path;

    public VehiculoDaoObj(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado = new ArrayList
    }

    @Override
    public int insertar(List<Vehiculo> vehiculo) throws DaoException {
       
    }

}
