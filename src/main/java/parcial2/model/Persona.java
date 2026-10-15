package parcial2.model;

public abstract class Persona {

    private String documentoIdentidad;
    private String nombreCompleto;
    private String correoElectronico;
    private String numeroTelefono;

    /**
     * Metodo constructor de clase abstracta persona
     * @param documentoIdentidad
     * @param nombreCompleto
     * @param correoElectronico
     * @param numeroTelefono
     */
    public Persona(String documentoIdentidad, String nombreCompleto, String correoElectronico, String numeroTelefono) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * getters de clase abstracta persona
     * @return
     */
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    @Override
    public String toString() {
        return "Documento: " + documentoIdentidad +
                ", Nombre: '" + nombreCompleto + '\'' +
                ", Email: '" + correoElectronico + '\'' +
                ", Teléfono: '" + numeroTelefono + '\'';
    }
}