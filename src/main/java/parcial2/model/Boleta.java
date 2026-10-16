package parcial2.model;

public class Boleta {

    private int codigoBoleta;
    private int fila;
    private int numeroAsiento;
    private double valorIndividualPagado;

    /**
     * Metodo constructor boleta
     * @param codigoBoleta
     * @param fila
     * @param numeroAsiento
     * @param valorIndividualPagado
     */
    public Boleta(int codigoBoleta, int fila, int numeroAsiento, double valorIndividualPagado) {
        this.codigoBoleta = codigoBoleta;
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
        this.valorIndividualPagado = valorIndividualPagado;
    }

    public Boleta(String codigoBoleta, FuncionCinematografica funcion, int numeroSilla) {

    }

    /**
     * getters boleta
     * @return
     */
    public int getCodigoBoleta() {
        return codigoBoleta;
    }

    public int getFila() {
        return fila;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public double getValorIndividualPagado() {
        return valorIndividualPagado;
    }

    @Override
    public String toString() {
        return "Boleta {" +
                "Código: " + codigoBoleta +
                ", Fila: " + fila +
                ", Asiento: " + numeroAsiento +
                ", Valor Pagado: $" + String.format("%.2f", valorIndividualPagado) +
                '}';
    }
}