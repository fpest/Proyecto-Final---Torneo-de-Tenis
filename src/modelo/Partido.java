
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Partido {
private int idPartido;
private Torneo Torneo;
private Jugador Jugador1;
private Jugador Jugador2;
private Estadio Estadio;
private LocalDateTime fechaHora;
private String Estado;
private Jugador JugadorGanador;
private String resultado;
private String instanciaTorneo;
private boolean activo;

    public Partido() {
    }

    public Partido(int idPartido, Torneo Torneo, Jugador Jugador1, Jugador Jugador2, Estadio Estadio, LocalDateTime fechaHora, String Estado, Jugador JugadorGanador, String resultado, String instanciaTorneo, boolean activo) {
        this.idPartido = idPartido;
        this.Torneo = Torneo;
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        this.Estadio = Estadio;
        this.fechaHora = fechaHora;
        this.Estado = Estado;
        this.JugadorGanador = JugadorGanador;
        this.resultado = resultado;
        this.instanciaTorneo = instanciaTorneo;
        this.activo = activo;
    }

    public Partido(Torneo Torneo, Jugador Jugador1, Jugador Jugador2, Estadio Estadio, LocalDateTime fechaHora, String Estado, Jugador JugadorGanador, String resultado, String instanciaTorneo, boolean activo) {
        this.Torneo = Torneo;
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        this.Estadio = Estadio;
        this.fechaHora = fechaHora;
        this.Estado = Estado;
        this.JugadorGanador = JugadorGanador;
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

    public Torneo getTorneo() {
        return Torneo;
    }

    public void setTorneo(Torneo Torneo) {
        this.Torneo = Torneo;
    }

    public Jugador getJugador1() {
        return Jugador1;
    }

    public void setJugador1(Jugador Jugador1) {
        this.Jugador1 = Jugador1;
    }

    public Jugador getJugador2() {
        return Jugador2;
    }

    public void setJugador2(Jugador Jugador2) {
        this.Jugador2 = Jugador2;
    }

    public Estadio getEstadio() {
        return Estadio;
    }

    public void setEstadio(Estadio Estadio) {
        this.Estadio = Estadio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Jugador getJugadorGanador() {
        return JugadorGanador;
    }

    public void setJugadorGanador(Jugador JugadorGanador) {
        this.JugadorGanador = JugadorGanador;
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
        return "Partido{" + "idPartido=" + idPartido + ", Torneo=" + Torneo + ", Jugador1=" + Jugador1 + ", Jugador2=" + Jugador2 + ", Estadio=" + Estadio + ", fechaHora=" + fechaHora + ", Estado=" + Estado + ", JugadorGanador=" + JugadorGanador + ", resultado=" + resultado + ", instanciaTorneo=" + instanciaTorneo + ", activo=" + activo + '}';
    }

    
}
