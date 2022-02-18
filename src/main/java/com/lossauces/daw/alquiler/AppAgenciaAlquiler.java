/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lossauces.daw.alquiler;

import java.util.Scanner;

/**
 *
 * @author daw1
 */
public class AppAgenciaAlquiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        String matricula, grupo;
        int plazas;
        float capacidad;
        AgenciaAlquiler aa = null;

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
            System.out.println("0.- Salir");
            System.out.println("Introduzca una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("CREAR TURISMO");
                    System.out.println("Introduzca la matricula del vehiculo: ");
                    matricula = teclado.nextLine();
                    System.out.println("Introduzca el grupo al que pertenece: ");
                    System.out.println(Grupo.values());
                    grupo = teclado.nextLine();
                    System.out.println("Introduzca el numero de plazas que posee");
                    plazas = teclado.nextInt();
                    teclado.nextLine();
                    if (aa.incluirVehiculo(new Turismo(plazas, matricula, Grupo.valueOf(grupo)))) {
                        System.out.println("Se ha introducido el turismo en la agencia");
                    } else {
                        System.out.println("No se ha podido introducir el turismo");
                    }
                    break;
                case 2:
                    System.out.println("CREAR FURGONETA");
                    System.out.println("Introduzca la matricula del vehiculo: ");
                    matricula = teclado.nextLine();
                    System.out.println("Introduzca el grupo al que pertenece: ");
                    System.out.println(Grupo.values());
                    grupo = teclado.nextLine();
                    System.out.println("Introduzca la capacidad que posee");
                    capacidad = teclado.nextInt();
                    teclado.nextLine();
                    if (aa.incluirVehiculo(new Turismo(plazas, matricula, Grupo.valueOf(grupo)))) {
                        System.out.println("Se ha introducido el turismo en la agencia");
                    } else {
                        System.out.println("No se ha podido introducir el turismo");
                    }
                    break;
                case 3:
                    System.out.println("CONSULTAR VEHICULO");
                    System.out.println("Introduzca la matricula del vehiculo a consultar");
                    matricula = teclado.nextLine();
                    v = aa.consultarVehiculo(matricula);
                    if (emp != null) {
                        System.out.println(emp);
                    } else {
                        System.out.println("No existe un empleado con ese DNI");
                    }

                    break;
                case 4:
                    System.out.println("ELIMINAR VEHICULO");
                    System.out.println("Introduzca la matricula del vehiculo a eliminar");
                    matricula = teclado.nextLine();
                    v = aa.consultarVehiculo(matricula);
                    if (v != null) {

                    }

                    break;
                case 5:
                    System.out.println("LISTAR VEHICULOS POR PRECIO");
                    for (Vehiculo v : aa.listarVehiculosPorPrecio()) {
                        System.out.println(v);
                    }
                    break;
                case 6:
                    System.out.println("LISTAR VEHICULOS POR GRUPO");
                    grupo = teclado.nextLine();
                    for (Vehiculo v : aa.listarVehiculos(Grupo.valueOf(grupo))) {
                        System.out.println(v);
                    }
                    break;
                case 7:
                    System.out.println("LISTAR TURISMOS");
                    for (Vehiculo v : aa.getFlota()) {
                        if (v instanceof Turismo) {
                            System.out.println(v);
                        }
                    }
                    break;
                case 8:
                    System.out.println("LISTAR FURGONETAS");
                    if (v.) {
                        break;
                    }
                case 9:
                    System.out.println("ALQUILER MAS BARATO: " + aa.getVehiculoMasBarato());
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
            }

        } while (opcion != 0);

    }
}
