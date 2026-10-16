package parcial2;

import parcial2.model.Boleta;
import parcial2.model.CinePlus;
import parcial2.model.Cliente;
import parcial2.model.FuncionCinematografica;
import parcial2.model.Pelicula;
import parcial2.model.Sala;
import parcial2.model.Venta;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        CinePlus cinePlus = new CinePlus("CinePlus Armenia", "900987654", "www.cineplus.com");

        int opcion = 0;

        while (opcion != 10) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            ================ CINEPLUS ================
                            1. Gestionar películas
                            2. Gestionar salas
                            3. Gestionar clientes
                            4. Gestionar operarios
                            5. Programar función
                            6. Gestionar boletas
                            7. Gestionar ventas
                            8. Calcular valor individual de boleta
                            9. Calcular total de venta
                            10. Salir

                            Seleccione una opción:
                            """));

            if (opcion == 1) {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la película:"));
                String titulo = JOptionPane.showInputDialog(null, "Ingrese el título de la película:");
                int duracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la duración en minutos:"));
                String genero = JOptionPane.showInputDialog(null, """
                        Ingrese el género cinematográfico:
                        ACCION
                        COMEDIA
                        TERROR
                        DRAMA
                        """);
                String clasificacion = JOptionPane.showInputDialog(null, """
                        Ingrese la clasificación por edad:
                        TODOS
                        MAYORES_12
                        MAYORES_15
                        MAYORES_18
                        """);
                String resultado = cinePlus.registrarPelicula(codigo, titulo, duracion, genero, clasificacion);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 2) {
                int numeroSala = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de la sala:"));
                int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la capacidad máxima:"));
                String tipoSala = JOptionPane.showInputDialog(null, """
                        Ingrese el tipo de sala:
                        Tradicional
                        3D
                        VIP
                        """);
                String resultado = cinePlus.registrarSala(numeroSala, capacidad, tipoSala);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 3) {
                String nombreCompleto = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del cliente:");
                String documento = JOptionPane.showInputDialog(null, "Ingrese el documento de identidad:");
                String telefono = JOptionPane.showInputDialog(null, "Ingrese el número de teléfono:");
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico:");
                String codigoCliente = JOptionPane.showInputDialog(null, "Ingrese el código de cliente:");
                double porcentajeDescuento = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el porcentaje de descuento:"));
                String resultado = cinePlus.registrarCliente(nombreCompleto, documento, telefono, correo, codigoCliente, porcentajeDescuento);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 4) {
                String nombreCompleto = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del operario:");
                String documento = JOptionPane.showInputDialog(null, "Ingrese el documento de identidad:");
                String telefono = JOptionPane.showInputDialog(null, "Ingrese el número de teléfono:");
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico:");
                String codigoOperario = JOptionPane.showInputDialog(null, "Ingrese el código de operario:");
                double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario del operario:"));
                String resultado = cinePlus.registrarOperario(nombreCompleto, documento, telefono, correo, codigoOperario, salario);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 5) {
                int codigoPelicula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la película:"));
                Pelicula pelicula = cinePlus.buscarPelicula(codigoPelicula);
                if (pelicula != null) {
                    int numeroSala = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de la sala:"));
                    Sala sala = cinePlus.buscarSala(numeroSala);
                    if (sala != null) {
                        String codigoFuncion = JOptionPane.showInputDialog(null, "Ingrese el código de la función:");
                        String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de realización:");
                        String horaInicio = JOptionPane.showInputDialog(null, "Ingrese la hora de inicio:");
                        double precioEntrada = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio de la entrada:"));
                        String resultado = cinePlus.registrarFuncion(codigoFuncion, fecha, horaInicio, precioEntrada, pelicula, sala);
                        JOptionPane.showMessageDialog(null, resultado);
                    } else {
                        JOptionPane.showMessageDialog(null, "La sala no se encuentra registrada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La película no se encuentra registrada.");
                }

            } else if (opcion == 6) {
                String codigoFuncion = JOptionPane.showInputDialog(null, "Ingrese el código de la función:");
                FuncionCinematografica funcion = cinePlus.buscarFuncion(Integer.parseInt(codigoFuncion));
                if (funcion != null) {
                    String codigoBoleta = JOptionPane.showInputDialog(null, "Ingrese el código de la boleta:");
                    int numeroSilla = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de silla:"));
                    String resultado = cinePlus.registrarBoleta(codigoBoleta, funcion, numeroSilla);
                    JOptionPane.showMessageDialog(null, resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "La función no existe.");
                }

            } else if (opcion == 7) {
                String documento = JOptionPane.showInputDialog(null, "Ingrese el documento del cliente:");
                Cliente cliente = cinePlus.buscarCliente(documento);
                if (cliente != null) {
                    String codigoVenta = JOptionPane.showInputDialog(null, "Ingrese el código de la venta:");
                    String resultado = cinePlus.registrarVenta(codigoVenta, cliente);
                    JOptionPane.showMessageDialog(null, resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente no se encuentra registrado.");
                }

            } else if (opcion == 8) {
                String codigoBoleta = JOptionPane.showInputDialog(null, "Ingrese el código de la boleta:");
                Boleta boleta = cinePlus.buscarBoleta(Integer.parseInt(codigoBoleta));
                if (boleta != null) {
                    double valorFinal = boleta.calcularValorFinal();
                    JOptionPane.showMessageDialog(null, "Código de Boleta: " + boleta.getCodigoBoleta() + "\nValor Final: $" + valorFinal);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe una boleta registrada con ese código.");
                }

            } else if (opcion == 9) {
                String codigoVenta = JOptionPane.showInputDialog(null, "Ingrese el código de la venta:");
                Venta venta = cinePlus.buscarVenta(codigoVenta);
                if (venta != null) {
                    double total = venta.calcularTotal();
                    JOptionPane.showMessageDialog(null, "Total correspondientes a la venta " + codigoVenta + ":\n$" + total);
                } else {
                    JOptionPane.showMessageDialog(null, "La venta no existe.");
                }

            } else if (opcion == 10) {
                JOptionPane.showMessageDialog(null, "Saliendo del sistema CinePlus.");
            } else {
                JOptionPane.showMessageDialog(null, "La opción seleccionada no es válida.");
            }
        }
    }
}