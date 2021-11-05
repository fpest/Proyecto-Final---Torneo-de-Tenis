
package modelo;

import java.time.LocalDate;

/**
 *
 * @author TomasNievas
 */
public class Jugador {
    
    private int idJugador;
    private String nombre;
    private String apellido;
    private long dni;
    private LocalDate fechaNacimiento;
    private double altura;
    private double peso;
    private String estilo;
    private boolean diestro;
    private boolean activo;

    public Jugador() {
    }

    public Jugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, double altura, double peso, String estilo, boolean diestro, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.diestro = diestro;
        this.activo = activo;
    }

    public Jugador(int idJugador, String nombre, String apellido, long dni, LocalDate fechaNacimiento, double altura, double peso, String estilo, boolean diestro, boolean activo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.diestro = diestro;
        this.activo = activo;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean isDiestro() {
        return diestro;
    }

    public void setDiestro(boolean diestro) {
        this.diestro = diestro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre;
    }
    
    
    
}