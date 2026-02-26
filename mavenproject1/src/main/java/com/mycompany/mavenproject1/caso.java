/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class caso {

    public static void main(String[] args) {
        // Datos cliente
        String nombre = JOptionPane.showInputDialog("Digite el nombre");
        String cedula = JOptionPane.showInputDialog("Digite la cédula");
        String telefono = JOptionPane.showInputDialog("Digite el teléfono");
        String categoria = JOptionPane.showInputDialog("Digite la categoría (VIP/Regular)");

        int mes = 0;
        boolean mesValido = false;

        while (!mesValido) {
            
                mes = Integer.parseInt(
                        JOptionPane.showInputDialog("Digite el mes (1-12)")
                );

                if (mes >= 1 & mes <= 12) {
                    mesValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Mes inválido");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite un número válido");
            }
        }

        Cliente cliente = new Cliente(nombre, cedula, telefono, categoria, mes);

        int cantidadVehiculos = 0;

        String continuar = "SI";

        while (continuar.equalsIgnoreCase("SI")) {

            String placa = JOptionPane.showInputDialog("Digite la placa");
            String marca = JOptionPane.showInputDialog("Digite la marca");
            double precio = Double.parseDouble(
                    JOptionPane.showInputDialog("Digite el precio por día")
            );
            int dias = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite la cantidad de días")
            );

            boolean seguro = JOptionPane.showInputDialog("¿Seguro completo? (SI/NO)")
                    .equalsIgnoreCase("SI");

            boolean gps = JOptionPane.showInputDialog("¿Incluye GPS? (SI/NO)")
                    .equalsIgnoreCase("SI");

            VehiculoAlquiler vehiculo
                    = new VehiculoAlquiler(placa, marca, precio, dias, seguro, gps);

            double subtotal = vehiculo.calcularSubtotal();
            int puntos = vehiculo.calcularPuntos();

            JOptionPane.showMessageDialog(null,
                    "Subtotal vehículo " + placa
                    + ": " + subtotal
                    + " | Puntos ganados: " + puntos);

            totalGeneral += subtotal;
            puntosTotales += puntos;
            cantidadVehiculos++;

            continuar = JOptionPane.showInputDialog("¿Desea ingresar otro vehículo? (SI/NO)");
        }

        if (cliente.getCategoria().equalsIgnoreCase("VIP")) {
            totalGeneral *= 0.95;
            puntosTotales *= 2;
        }

        JOptionPane.showMessageDialog(null,
    }
}
