package parcial2.model;

public class Cliente extends Persona {

    private int codigoAfiliacion;
    private double porcentajeDescuento;// Ejemplo: 10.0 para 10%

    /**
     * Metodo constructor para la clase padre(persona)
     * @param documentoIdentidad
     * @param nombreCompleto
     * @param correoElectronico
     * @param numeroTelefono
     * @param codigoAfiliacion
     * @param porcentajeDescuento
     */
    public Cliente(String documentoIdentidad, String nombreCompleto, String correoElectronico, String numeroTelefono, int codigoAfiliacion, double porcentajeDescuento) {
        super(documentoIdentidad, nombreCompleto, correoElectronico, numeroTelefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    /**
     * getters de clase padre(persona)
     * @return
     */
    public int getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Cliente {" + super.toString() +
                ", Código Afiliación: " + codigoAfiliacion +
                ", Descuento: " + porcentajeDescuento + "%" +
                '}';
    }
}
