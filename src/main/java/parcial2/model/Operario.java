package parcial2.model;

public class Operario extends Persona {
    private int codigoEmpleado;
    private String fechaContratacion;
    private double salarioBasico;

    /**
     * metodo constructor de clase hija (operario)
     *
     * @param documentoIdentidad
     * @param nombreCompleto
     * @param correoElectronico
     * @param numeroTelefono
     * @param codigoEmpleado
     * @param fechaContratacion
     * @param salarioBasico
     */
    public Operario(String documentoIdentidad, String nombreCompleto, String correoElectronico, String numeroTelefono, int codigoEmpleado, String fechaContratacion, double salarioBasico) {
        super(documentoIdentidad, nombreCompleto, correoElectronico, numeroTelefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
    }

    /**
     * getter de clase hija operario
     * @return
     */
    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    @Override
    public String toString() {
        return "Operario {" + super.toString() +
                ", Código Empleado: " + codigoEmpleado +
                ", Fecha Contratación: '" + fechaContratacion + '\'' +
                ", Salario: $" + salarioBasico +
                '}';
    }
}