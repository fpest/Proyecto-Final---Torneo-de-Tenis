
package modelo;

public class Estadio {
    
    private int idEstadio;
    private int numeroIdentificador;
    private String ciudad;
    private String direccion;
    private int estado;
    private double largo;
    private double ancho;
    private long cantidadEspectadores;
    private String categoria;
    private boolean activo;

    public Estadio() {
    }

    public Estadio(int numeroIdentificador, String ciudad, String direccion, int estado, double largo, double ancho, long cantidadEspectadores, String categoria, boolean activo) {
        this.numeroIdentificador = numeroIdentificador;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = estado;
        this.largo = largo;
        this.ancho = ancho;
        this.cantidadEspectadores = cantidadEspectadores;
        this.categoria = categoria;
        this.activo = activo;
    }

    public Estadio(int idEstadio, int numeroIdentificador, String ciudad, String direccion, int estado, double largo, double ancho, long cantidadEspectadores, String categoria, boolean activo) {
        this.idEstadio = idEstadio;
        this.numeroIdentificador = numeroIdentificador;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = estado;
        this.largo = largo;
        this.ancho = ancho;
        this.cantidadEspectadores = cantidadEspectadores;
        this.categoria = categoria;
        this.activo = activo;
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public long getCantidadEspectadores() {
        return cantidadEspectadores;
    }

    public void setCantidadEspectadores(long cantidadEspectadores) {
        this.cantidadEspectadores = cantidadEspectadores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Estadio: " + numeroIdentificador;
    }
    
    
    
}