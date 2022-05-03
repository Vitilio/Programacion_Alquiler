/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lossauces.daw.alquiler;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author daw1
 */
public class AppAgenciaAlquiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        AgenciaAlquiler aa = new AgenciaAlquiler();
        int opcion, plazas;
        String entrada,archivo;
        Grupo grupo=null;
        Matricula matricula=null;
        float capacidad;
        boolean correcto;

        do {
            System.out.println("1.- Crear turismo");
            System.out.println("2.- Crear furgoneta");
            System.out.println("3.- Consultar vehiculo");
            System.out.println("4.- Eliminar vehiculo");
            System.out.println("5.- Listar vehiculos por precio");
            System.out.println("6.- Listar vehiculos por grupo");
            System.out.println("7.- Listar turismos");
            System.out.println("8.- Listar furgonetas");
            System.out.println("9.- Consultar alquiler mas barato");
            System.out.println("10.- Guardar empleados");
            System.out.println("11.- Cargar empleados");
            System.out.println("0.- Salir");
            System.out.println("Introduzca una opcion: ");
            while (!teclado.hasNextInt()) {
                teclado.nextLine();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    try {
                    System.out.println("CREAR TURISMO");
                    System.out.println("Introduzca la matricula del vehiculo: ");
                    entrada = teclado.nextLine();
                    matricula = Matricula.valueOf(entrada);
                    System.out.println("Introduce Grupo del vehiculo");
                    System.out.println(Arrays.toString(Grupo.values()));
                    entrada = teclado.nextLine();
                    grupo = Grupo.valueOf(entrada);
                    System.out.println("Introduzca el numero de plazas que posee"); //A
                    plazas = teclado.nextInt();
                    teclado.nextLine();
                    if (aa.incluirVehiculo(new Turismo(matricula, grupo, plazas))) {
                        System.out.println("Se ha registrado el turismo en la agencia");
                    } else {
                        System.out.println("No se ha podido introducir el turismo");
                    }
                } catch (MatriculaException ex) {
                    System.out.println(ex.getMessage());
                } catch (InputMismatchException ime) {
                    System.out.println("Debe ser un entero");
                    teclado.nextLine();
                } catch (IllegalArgumentException iae) {
                    System.out.println("Debe introducir uno de los siguientes valores" + Arrays.toString(Grupo.values()));
                }
                break;

                case 2:
                    try {
                    System.out.println("CREAR FURGONETA");
                    System.out.println("Introduzca la matricula del vehiculo: ");
                    entrada = teclado.nextLine();
                    matricula = Matricula.valueOf(entrada);
                    System.out.println("Introduce Grupo del vehiculo");
                    System.out.println(Arrays.toString(Grupo.values()));
                    entrada = teclado.nextLine();
                    grupo = Grupo.valueOf(entrada);
                    System.out.println("Introduzca la capacidad que posee"); //A
                    capacidad = teclado.nextFloat();
                    teclado.nextLine();
                    if (aa.incluirVehiculo(new Furgoneta(matricula, grupo, capacidad))) {
                        System.out.println("Se ha registrado la furgoneta en la agencia");
                    } else {
                        System.out.println("No se ha podido introducir el turismo");
                    }
                } catch (MatriculaException ex) {
                    System.out.println(ex.getMessage());
                } catch (InputMismatchException ime) {
                    System.out.println("Debe ser un entero");
                } catch (IllegalArgumentException iae) {
                    System.out.println("Debe introducir uno de los siguientes valores" + Arrays.toString(Grupo.values()));
                }
                break;

                case 3:
                try {
                    System.out.println("CONSULTAR VEHICULO");
                    System.out.println("Introduzca la matricula del vehiculo a consultar");
                    entrada = teclado.nextLine();
                    matricula = Matricula.valueOf(entrada);
                } catch (MatriculaException ex) {
                    System.out.println(ex.getMessage());
                }
                if (aa.consultarVehiculo(matricula) != null) {
                    System.out.println(aa.consultarVehiculo(matricula));
                } else {
                    System.out.println("Vehiculo no existe");
                }

                break;

                case 4:
                    System.out.println("ELIMINAR VEHICULO");
                    System.out.println("Introduzca la matricula del vehiculo a eliminar");
                    entrada = teclado.nextLine();
                    matricula = Matricula.valueOf(entrada);
                    if (aa.consultarVehiculo(matricula) != null) {
                        aa.eliminarVehiculo(aa.consultarVehiculo(matricula));
                        System.out.println("Vehiculo eliminado");
                    } else {
                        System.out.println("Vehiculo no  se ha podido eliminar");
                    }
                    break;

                case 5:
                    System.out.println("LISTAR VEHICULOS POR PRECIO");
                    System.out.println(aa.listarVehiculosPorPrecio());
                    break;
                case 6:
                    System.out.println("LISTAR VEHICULOS POR GRUPO");
                    correcto = false;
                    do {
                        correcto = false;
                        System.out.println("Introduce Grupo del vehiculo " + Arrays.toString(Grupo.values()));
                        entrada = teclado.nextLine();
                        for (Grupo g : Grupo.values()) {
                            if (grupo.equals(g)) {
                                correcto = true;
                            }
                        }
                    } while (!correcto);
                    for (Vehiculo v : aa.listarVehiculos(Grupo.valueOf(entrada))) {
                        System.out.println(v);
                    }
                    break;
                case 7:
                    System.out.println("LISTAR TURISMOS");
                    for (Vehiculo v : aa.listarVehiculosPorPrecio()) {
                        if (v.getClass().equals(Turismo.class)) {
                            System.out.println(v.toString());
                        }
                    }
                    break;
                case 8:
                    System.out.println("LISTAR FURGONETAS");
                    for (Vehiculo v : aa.listarVehiculosPorPrecio()) {
                        if (v instanceof Furgoneta) {
                            System.out.println(v.toString());
                        }
                    }
                    break;
                case 9:
                    Vehiculo v=null;
                    System.out.println("ALQUILER MAS BARATO: " + aa.getVehiculoMasBarato());
                    break;
                case 10:
                    System.out.println("Introduzca el nombre del archivo a guardar");
                    archivo=teclado.nextLine();
                    break;
                case 11:
                    System.out.println("Introduzca el nombre del arhivo a cargar");
                    archivo=teclado.nextLine();
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
            }

        } while (opcion != 0);

    }
}
