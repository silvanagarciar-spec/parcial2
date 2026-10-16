package parcial2.model;

import java.util.ArrayList;

public class CinePlus {

    // Atributos
    private String nombre;
    private String nit;
    private String direccion;

    // Colecciones de la empresa
    private ArrayList<Pelicula> listaPeliculas;
    private ArrayList<Sala> listaSalas;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Operario> listaOperarios;
    private ArrayList<FuncionCinematografica> listaFunciones;
    private ArrayList<Boleta> listaBoletas;
    private ArrayList<Venta> listaVentas;

    // Constructor
    public CinePlus(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listaPeliculas = new ArrayList<>();
        this.listaSalas = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaOperarios = new ArrayList<>();
        this.listaFunciones = new ArrayList<>();
        this.listaBoletas = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    // ==========================================
    // MÉTODOS DE BÚSQUEDA Y REGISTRO (CON WHILE)
    // ==========================================

    // 1. Películas
    public Pelicula buscarPelicula(int codigo) {
        int i = 0;
        while (i < listaPeliculas.size()) {
            Pelicula p = listaPeliculas.get(i);
            if (p.getCodigoPelicula() == codigo) {
                return p;
            }
            i++;
        }
        return null;
    }

    public String registrarPelicula(int codigo, String titulo, int duracion, String genero, String clasificacion) {
        if (buscarPelicula(codigo) != null) {
            return "La película ya se encuentra registrada.";
        }
        GeneroCinematografico generoEnum = GeneroCinematografico.desdeTexto(genero);
        if (generoEnum == null) {
            return "El género ingresado no es válido.";
        }
        ClasificacionEdad clasificacionEnum = ClasificacionEdad.desdeTexto(clasificacion);
        if (clasificacionEnum == null) {
            return "La clasificación ingresada no es válida.";
        }
        Pelicula pelicula = new Pelicula(codigo, titulo, duracion, generoEnum, clasificacionEnum);
        listaPeliculas.add(pelicula);
        return "Película registrada con éxito.";
    }

    // 2. Salas
    public Sala buscarSala(int numeroSala) {
        int i = 0;
        while (i < listaSalas.size()) {
            Sala s = listaSalas.get(i);
            if (s.getCodigoSala() == numeroSala) {
                return s;
            }
            i++;
        }
        return null;
    }

    public String registrarSala(int numeroSala, int capacidad, String tipoSala) {
        if (buscarSala(numeroSala) != null) {
            return "La sala ya se encuentra registrada.";
        }

        Sala sala;
        if (tipoSala.equalsIgnoreCase("3D") || tipoSala.equalsIgnoreCase("TresD")) {
            sala = new TresD(numeroSala, capacidad);
        } else if (tipoSala.equalsIgnoreCase("VIP")) {
            sala = new Vip(numeroSala, capacidad);
        } else {
            sala = new Tradicional(numeroSala, capacidad);
        }

        listaSalas.add(sala);
        return "Sala registrada con éxito.";
    }

    // 3. Clientes
    public Cliente buscarCliente(String documento) {
        int i = 0;
        while (i < listaClientes.size()) {
            Cliente c = listaClientes.get(i);
            if (c.getDocumentoIdentidad().equalsIgnoreCase(documento)) {
                return c;
            }
            i++;
        }
        return null;
    }

    public String registrarCliente(String nombreCompleto, String documento, String telefono, String correo, String codigoCliente, double porcentajeDescuento) {
        if (buscarCliente(documento) != null) {
            return "El cliente ya se encuentra registrado.";
        }
        int codigoAfiliacion;
        try {
            codigoAfiliacion = Integer.parseInt(codigoCliente.trim());
        } catch (NumberFormatException e) {
            return "El código de cliente debe ser un número entero.";
        }
        Cliente cliente = new Cliente(documento, nombreCompleto, correo, telefono, codigoAfiliacion, porcentajeDescuento);
        listaClientes.add(cliente);
        return "Cliente registrado con éxito.";
    }

    // 4. Operarios
    public String registrarOperario(String nombreCompleto, String documento, String telefono, String correo, String codigoOperario, double salario) {
        int codigoEmpleado;
        try {
            codigoEmpleado = Integer.parseInt(codigoOperario.trim());
        } catch (NumberFormatException e) {
            return "El código de operario debe ser un número entero.";
        }
        Operario operario = new Operario(documento, nombreCompleto, correo, telefono, codigoEmpleado,
                java.time.LocalDate.now().toString(), salario);
        listaOperarios.add(operario);
        return "Operario registrado con éxito.";
    }

    // 5. Funciones
    public FuncionCinematografica buscarFuncion(int codigoFuncion) {
        int i = 0;
        while (i < listaFunciones.size()) {
            FuncionCinematografica f = listaFunciones.get(i);
            if (f.getCodigoFuncionCinematografica() == codigoFuncion) {
                return f;
            }
            i++;
        }
        return null;
    }

    public String registrarFuncion(String codigoFuncion, String fecha, String horaInicio, double precioEntrada, Pelicula pelicula, Sala sala) {
        int codigo;
        try {
            codigo = Integer.parseInt(codigoFuncion.trim());
        } catch (NumberFormatException e) {
            return "El código de la función debe ser un número entero.";
        }
        if (buscarFuncion(codigo) != null) {
            return "La función ya se encuentra registrada.";
        }
        FuncionCinematografica funcion = new FuncionCinematografica(codigo, fecha, horaInicio, precioEntrada, pelicula, sala);
        listaFunciones.add(funcion);
        return "Función programada con éxito.";
    }

    // 6. Boletas
    public Boleta buscarBoleta(int codigoBoleta) {
        int i = 0;
        while (i < listaBoletas.size()) {
            Boleta b = listaBoletas.get(i);
            if (b.getCodigoBoleta() == codigoBoleta) {
                return b;
            }
            i++;
        }
        return null;
    }

    public String registrarBoleta(String codigoBoleta, FuncionCinematografica funcion, int numeroSilla) {
        if (buscarBoleta(Integer.parseInt(codigoBoleta)) != null) {
            return "La boleta ya se encuentra registrada.";
        }
        Boleta boleta = new Boleta(codigoBoleta, funcion, numeroSilla);
        listaBoletas.add(boleta);
        return "Boleta registrada con éxito.";
    }

    // 7. Ventas
    public Venta buscarVenta(int codigoVenta) {
        int i = 0;
        while (i < listaVentas.size()) {
            Venta v = listaVentas.get(i);
            if (v.getCodigoVenta() == codigoVenta) {
                return v;
            }
            i++;
        }
        return null;
    }

    public Venta buscarVenta(String codigoVenta) {
        try {
            int codigo = Integer.parseInt(codigoVenta);
            return buscarVenta(codigo);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String registrarVenta(int codigoVenta, String fechaRealizacion, Operario operario, Cliente cliente, FuncionCinematografica funcion) {
        if (buscarVenta(codigoVenta) != null) {
            return "La venta ya se encuentra registrada.";
        }
        Venta venta = new Venta(codigoVenta, fechaRealizacion, operario, cliente, funcion);
        listaVentas.add(venta);
        return "Venta registrada con éxito.";
    }

    public String registrarVenta(String codigoVenta, Cliente cliente) {
        try {
            int codigo = Integer.parseInt(codigoVenta);
            if (buscarVenta(codigo) != null) {
                return "La venta ya se encuentra registrada.";
            }
            Venta venta = new Venta(codigo, "", null, cliente, null);
            listaVentas.add(venta);
            return "Venta registrada con éxito.";
        } catch (NumberFormatException e) {
            return "El código de la venta debe ser un número entero.";
        }
    }

    // ==========================================
    // GETTERS Y SETTERS
    // ==========================================

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public ArrayList<Sala> getListaSalas() {
        return listaSalas;
    }

    public void setListaSalas(ArrayList<Sala> listaSalas) {
        this.listaSalas = listaSalas;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Operario> getListaOperarios() {
        return listaOperarios;
    }

    public void setListaOperarios(ArrayList<Operario> listaOperarios) {
        this.listaOperarios = listaOperarios;
    }

    public ArrayList<FuncionCinematografica> getListaFunciones() {
        return listaFunciones;
    }

    public void setListaFunciones(ArrayList<FuncionCinematografica> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    public ArrayList<Boleta> getListaBoletas() {
        return listaBoletas;
    }

    public void setListaBoletas(ArrayList<Boleta> listaBoletas) {
        this.listaBoletas = listaBoletas;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}