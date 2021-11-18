
package modelo;


import java.time.LocalDate;


public class Torneo {
    private int idTorneo;
    private String nombre;
    private LocalDate fechaIn, fechaFn;
    private boolean activo;

    public Torneo() {
    }

    public Torneo(String nombre, LocalDate fechaIn, LocalDate fechaFn, boolean activo) {
        this.nombre = nombre;
        this.fechaIn = fechaIn;
        this.fechaFn = fechaFn;
        this.activo = activo;
    }

    public Torneo(int idTorneo, String nombre, LocalDate fechaIn, LocalDate fechaFn, boolean activo) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.fechaIn = fechaIn;
        this.fechaFn = fechaFn;
        this.activo = activo;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public LocalDate getFechaFn() {
        return fechaFn;
    }

    public void setFechaFn(LocalDate fechaFn) {
        this.fechaFn = fechaFn;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}