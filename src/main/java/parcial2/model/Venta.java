package parcial2.model;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int codigoVenta;
    private String fechaRealizacion;
    private Operario operario;
    private Cliente cliente;
    private FuncionCinematografica funcion;
    private List<Boleta> boletas;

    /**
     * Metodo constructor de venta
     * @param codigoVenta
     * @param fechaRealizacion
     * @param operario
     * @param cliente
     * @param funcion
     */
    public Venta(int codigoVenta, String fechaRealizacion, Operario operario, Cliente cliente, FuncionCinematografica funcion) {
        this.codigoVenta = codigoVenta;
        this.fechaRealizacion = fechaRealizacion;
        this.operario = operario;
        this.cliente = cliente;
        this.funcion = funcion;
        this.boletas = new ArrayList<>();
    }
    public double calcularTotal() {
        double total = 0.0;
        if (this.boletas != null) {
            for (Boleta boleta : this.boletas) {
                total += boleta.getValorIndividualPagado();
            }
        }
        return total;
    }
    /**
     * getters de venta
     * @return
     */
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Operario getOperario() {
        return operario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public FuncionCinematografica getFuncion() {
        return funcion;
    }

    public List<Boleta> getBoletas() {
        return boletas;
    }

    public void agregarBoleta(Boleta boleta) {
        this.boletas.add(boleta);
    }

    // Funcionalidad 5: Calcular el valor total de la venta
    public double calcularValorTotal() {
        double total = 0;
        for (Boleta b : boletas) {
            total += b.getValorIndividualPagado();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta {Código: ").append(codigoVenta)
                .append(", Fecha: '").append(fechaRealizacion).append('\'')
                .append(", Operario: ").append(operario.getNombreCompleto())
                .append(", Cliente: ").append(cliente.getNombreCompleto())
                .append(", Función: ").append(funcion.getCodigoFuncionCinematografica())
                .append(" (").append(funcion.getPelicula().getTitulo()).append(")")
                .append(", Total Boletas: ").append(boletas.size())
                .append(", Valor Total: $").append(String.format("%.2f", calcularValorTotal()))
                .append("}\n  Boletas:");
        for (Boleta b : boletas) {
            sb.append("\n   - ").append(b.toString());
        }
        return sb.toString();
    }
}