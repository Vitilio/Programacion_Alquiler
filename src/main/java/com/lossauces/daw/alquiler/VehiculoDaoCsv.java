/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lossauces.daw.alquiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw1
 */
public class VehiculoDaoCsv implements VehiculoDao {

    private Path path;

    public VehiculoDaoCsv(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado = new ArrayList<>();
        String linea,tipo,g,mat;
        String[] tokens;
        Vehiculo vehiculo = null;
        int plazas;
        float capacidad;
        try (BufferedReader entrada = Files.newBufferedReader(path)) {
            linea = entrada.readLine();
            while (linea != null) {
                tokens = linea.split(",");
                tipo=tokens[0];
                mat=tokens[1];
                g=tokens[2];
                switch (tipo) {
                    case "Turismo":
                        plazas = Integer.parseInt(tokens[3]);
                        vehiculo = new Turismo(Matricula.valueOf(mat),Grupo.valueOf(g) , plazas);
                        break;
                    case "Furgoneta":
                        capacidad = Float.parseFloat(tokens[3]);
                        vehiculo = new Furgoneta(Matricula.valueOf(mat),Grupo.valueOf(g), capacidad);
                        break;
                    default:
                }
                listado.add(vehiculo);
                linea = entrada.readLine();
            }

        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        } catch (MatriculaException ex) {
            throw new DaoException(ex.getMessage());
        } catch (Exception ex) {
            throw new DaoException("Formato incorrecto");
        }
        return listado;
    }

    @Override
    public int insertar(List<Vehiculo> listado) throws DaoException {
        int n = 0;
        String linea;
        try (BufferedWriter salida = Files.newBufferedWriter(path)) {
            for (Vehiculo vehiculo : listado) {
                linea = vehiculo.getClass().getSimpleName() + "," + vehiculo.toString();
                salida.write(linea);
                salida.newLine();
                n++;
            }
        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        return n;
    }
}
