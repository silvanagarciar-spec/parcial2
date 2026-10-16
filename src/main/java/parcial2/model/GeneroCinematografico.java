package parcial2.model;

/**
 * Clase enum de genero cinematografico
 */
public enum GeneroCinematografico {
    ACCION,
    COMEDIA,
    DRAMA,
    TERROR,
    ANIMACION;

    /**
     * Convierte el texto ingresado por el usuario al enum.
     * @return el genero, o null si el texto no es valido
     */
    public static GeneroCinematografico desdeTexto(String texto) {
        if (texto == null) {
            return null;
        }
        for (GeneroCinematografico g : values()) {
            if (g.name().equalsIgnoreCase(texto.trim())) {
                return g;
            }
        }
        return null;
    }
}
