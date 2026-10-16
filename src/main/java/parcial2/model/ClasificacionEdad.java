package parcial2.model;

/**
 * Clase enum clasificacion Edad
 */
public enum ClasificacionEdad {
    TODOS_LOS_PUBLICOS,
    MAYORES_7,
    MAYORES_12,
    MAYORES_15,
    MAYORES_18;

    /**
     * Convierte el texto ingresado por el usuario al enum.
     * Acepta "TODOS" como atajo de TODOS_LOS_PUBLICOS (asi lo muestra el menu).
     * @return la clasificacion, o null si el texto no es valido
     */
    public static ClasificacionEdad desdeTexto(String texto) {
        if (texto == null) {
            return null;
        }
        String t = texto.trim();
        if (t.equalsIgnoreCase("TODOS")) {
            return TODOS_LOS_PUBLICOS;
        }
        for (ClasificacionEdad c : values()) {
            if (c.name().equalsIgnoreCase(t)) {
                return c;
            }
        }
        return null;
    }
}
