package parcial2.model;

public class Pelicula {
    private int codigoPelicula;
    private String titulo;
    private int duracionMinutos;
    private GeneroCinematografico genero;
    private ClasificacionEdad clasificacion;

    /**
     * Metodo constructor de pelicula
     * @param codigoPelicula
     * @param titulo
     * @param duracionMinutos
     * @param genero
     * @param clasificacion
     */
    public Pelicula(int codigoPelicula, String titulo, int duracionMinutos, GeneroCinematografico genero, ClasificacionEdad clasificacion) {
        this.codigoPelicula = codigoPelicula;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.clasificacion = clasificacion;
    }

    /**
     * getters de pelicula
     * @return
     */
    public int getCodigoPelicula() {
        return codigoPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public GeneroCinematografico getGenero() {
        return genero;
    }

    public ClasificacionEdad getClasificacion() {
        return clasificacion;
    }

    @Override
    public String toString() {
        return "Película {" +
                "Código: " + codigoPelicula +
                ", Título: '" + titulo + '\'' +
                ", Duración: " + duracionMinutos + " min" +
                ", Género: " + genero +
                ", Clasificación: " + clasificacion +
                '}';
    }
}
