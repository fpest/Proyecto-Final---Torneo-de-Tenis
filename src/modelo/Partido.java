
package modelo;

import java.time.LocalDate;

public class Partido {
private int idPartido;
private int idTorneo;
private int idJugador1;
private int idJugador2;
private int idEstadio;
private LocalDate fechaHora;
private String Estado;
private int idJugadorGanador;
private String resultado;
private String instanciaTorneo;
private boolean activo;

    public Partido() {
    }

    public Partido(int idTorneo, int idJugador1, int idJugador2, int idEstadio, LocalDate fechaHora, String Estado, int idJugadorGanador, String resultado, String instanciaTorneo, boolean activo) {
        this.idTorneo = idTorneo;
        this.idJugador1 = idJugador1;
        this.idJugador2 = idJugador2;
        this.idEstadio = idEstadio;
        this.fechaHora = fechaHora;
        this.Estado = Estado;
        this.idJugadorGanador = idJugadorGanador;
        this.resultado = resultado;
        this.instanciaTorneo = instanciaTorneo;
        this.activo = activo;
    }

    public Partido(int idPartido, int idTorneo, int idJugador1, int idJugador2, int idEstadio, LocalDate fechaHora, String Estado, int idJugadorGanador, String resultado, String instanciaTorneo, boolean activo) {
        this.idPartido = idPartido;
        this.idTorneo = idTorneo;
        this.idJugador1 = idJugador1;
        this.idJugador2 = idJugador2;
        this.idEstadio = idEstadio;
        this.fechaHora = fechaHora;
        this.Estado = Estado;
        this.idJugadorGanador = idJugadorGanador;
        this.resultado = resultado;
        this.instanciaTorneo = instanciaTorneo;
        this.activo = activo;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getIdJugador1() {
        return idJugador1;
    }

    public void setIdJugador1(int idJugador1) {
        this.idJugador1 = idJugador1;
    }

    public int getIdJugador2() {
        return idJugador2;
    }

    public void setIdJugador2(int idJugador2) {
        this.idJugador2 = idJugador2;
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdJugadorGanador() {
        return idJugadorGanador;
    }

    public void setIdJugadorGanador(int idJugadorGanador) {
        this.idJugadorGanador = idJugadorGanador;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getInstanciaTorneo() {
        return instanciaTorneo;
    }

    public void setInstanciaTorneo(String instanciaTorneo) {
        this.instanciaTorneo = instanciaTorneo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", idTorneo=" + idTorneo + ", idJugador1=" + idJugador1 + ", idJugador2=" + idJugador2 + ", idEstadio=" + idEstadio + ", fechaHora=" + fechaHora + ", Estado=" + Estado + ", idJugadorGanador=" + idJugadorGanador + ", resultado=" + resultado + ", instanciaTorneo=" + instanciaTorneo + ", activo=" + activo + '}';
    }

   
}
