package parcial2.model;

public class TresD extends Sala {

    public TresD(int codigoSala, String nombre, int capacidadMaximaEspectadores) {
        super(codigoSala, nombre, capacidadMaximaEspectadores);
    }

    @Override
    public double calcularPrecioBoleta(double precioBase) {
        return precioBase * 1.20; // Recargo del 20%
    }

    @Override
    public String getTipoSala() {
        return "3D";
    }
}
