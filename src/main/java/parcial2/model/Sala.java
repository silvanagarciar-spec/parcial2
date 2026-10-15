package parcial2.model;

public abstract class Sala {
    private int codigoSala;
    private String nombre;
    private int capacidadMaximaEspectadores;

    /**
     * Metodo Constructor de Sala
     * @param codigoSala
     * @param nombre
     * @param capacidadMaximaEspectadores
     */
    public Sala(int codigoSala, String nombre, int capacidadMaximaEspectadores) {
        this.codigoSala = codigoSala;
        this.nombre = nombre;
        this.capacidadMaximaEspectadores = capacidadMaximaEspectadores;
    }

    /**
     * getters de Sala
     * @return
     */
    public int getCodigoSala() {
        return codigoSala;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaximaEspectadores() {
        return capacidadMaximaEspectadores;
    }

    // Métodos para el cálculo del precio base según tipo de sala
    public abstract double calcularPrecioBoleta(double precioBase);

    public abstract String getTipoSala();

    @Override
    public String toString() {
        return "Sala {" +
                "Código: " + codigoSala +
                ", Nombre: '" + nombre + '\'' +
                ", Capacidad: " + capacidadMaximaEspectadores +
                ", Tipo: " + getTipoSala() +
                '}';
    }
}