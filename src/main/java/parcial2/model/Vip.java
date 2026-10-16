package parcial2.model;

public class Vip extends Sala {

    public Vip(int codigoSala, int capacidadMaximaEspectadores) {
        super(codigoSala, "Sala VIP " + codigoSala, capacidadMaximaEspectadores);
    }

    @Override
    public double calcularPrecioBoleta(double precioBase) {
        return precioBase * 1.30; // Recargo del 30%
    }

    @Override
    public String getTipoSala() {
        return "VIP";
    }
}
