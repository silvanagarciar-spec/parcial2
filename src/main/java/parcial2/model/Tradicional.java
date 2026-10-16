package parcial2.model;

    public class Tradicional extends Sala {

        public Tradicional(int codigoSala, int capacidadMaximaEspectadores) {
            super(codigoSala, "Sala Tradicional " + codigoSala, capacidadMaximaEspectadores);
        }

        @Override
        public double calcularPrecioBoleta(double precioBase) {
            return precioBase; // Sin recargo
        }

        @Override
        public String getTipoSala() {
            return "Tradicional";
        }
    }

