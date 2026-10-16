package parcial2.model;
import java.time.LocalTime;

public class FuncionCinematografica {
    private int codigoFuncionCinematografica;
    private String fechaPresentacion; // Formato YYYY-MM-DD
    private String horaInicio;        // Formato HH:mm
    private double precioBaseBoleta;
    private Pelicula pelicula;
    private Sala sala;

    /**
     * Metodo constructor funcion cinematografica
     * @param codigoFuncionCinematografica
     * @param fechaPresentacion
     * @param horaInicio
     * @param precioBaseBoleta
     * @param pelicula
     * @param sala
     */
    public FuncionCinematografica(int codigoFuncionCinematografica, String fechaPresentacion, String horaInicio, double precioBaseBoleta, Pelicula pelicula, Sala sala) {
        this.codigoFuncionCinematografica = codigoFuncionCinematografica;
        this.fechaPresentacion = fechaPresentacion;
        this.horaInicio = horaInicio;
        this.precioBaseBoleta = precioBaseBoleta;
        this.pelicula = pelicula;
        this.sala = sala;
    }

    /**
     * getters de funcion cinematografica
     * @return
     */
    public int getCodigoFuncionCinematografica() {
        return codigoFuncionCinematografica;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public double getPrecioBaseBoleta() {
        return precioBaseBoleta;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    // Calcula el minuto de inicio del día
    public int getMinutosInicio() {
        LocalTime time = LocalTime.parse(horaInicio);
        return time.getHour() * 60 + time.getMinute();
    }

    // Calcula el minuto de fin teniendo en cuenta la duración de la película
    public int getMinutosFin() {
        return getMinutosInicio() + pelicula.getDuracionMinutos();
    }

    // Verifica si hay solapamiento de horario con otra función
    public boolean hayConflictoHorario(FuncionCinematografica otra) {
        if (!this.fechaPresentacion.equalsIgnoreCase(otra.fechaPresentacion)) {
            return false;
        }
        if (this.sala.getCodigoSala() != otra.sala.getCodigoSala()) {
            return false;
        }
        int inicioA = this.getMinutosInicio();
        int finA = this.getMinutosFin();
        int inicioB = otra.getMinutosInicio();
        int finB = otra.getMinutosFin();

        return (inicioA < finB && inicioB < finA);
    }

    @Override
    public String toString() {
        return "Función {" +
                "Código: " + codigoFuncionCinematografica +
                ", Fecha: '" + fechaPresentacion + '\'' +
                ", Hora: '" + horaInicio + '\'' +
                ", Precio Base: $" + precioBaseBoleta +
                ", Película: " + pelicula.getTitulo() +
                ", Sala: " + sala.getNombre() + " (" + sala.getTipoSala() + ")" +
                '}';
    }
}
