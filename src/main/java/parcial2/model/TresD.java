package parcial2.model;

public class TresD extends Sala {

    public TresD(int codigoSala, int capacidadMaximaEspectadores) {
        super(codigoSala, "Sala 3D " + codigoSala, capacidadMaximaEspectadores);
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
