
package modelo;


import java.time.LocalDate;


public class Patrocinio {
    int idPatrocinio;
    Jugador jugador;
    Patrocinador patrocinador;
    String indumentaria;
    LocalDate fechaContraroIn, fechaContratoFn;
    boolean activo;

    public Patrocinio() {
    }

    public Patrocinio(int idPatrocinio, Jugador jugador, Patrocinador patrocinador, String indumentaria, LocalDate fechaContraroIn, LocalDate fechaContratoFn, boolean activo) {
        this.idPatrocinio = idPatrocinio;
        this.jugador = jugador;
        this.patrocinador = patrocinador;
        this.indumentaria = indumentaria;
        this.fechaContraroIn = fechaContraroIn;
        this.fechaContratoFn = fechaContratoFn;
        this.activo = activo;
    }

    public Patrocinio(Jugador jugador, Patrocinador patrocinador, String indumentaria, LocalDate fechaContraroIn, LocalDate fechaContratoFn, boolean activo) {
        this.jugador = jugador;
        this.patrocinador = patrocinador;
        this.indumentaria = indumentaria;
        this.fechaContraroIn = fechaContraroIn;
        this.fechaContratoFn = fechaContratoFn;
        this.activo = activo;
    }

    public int getIdPatrocinio() {
        return idPatrocinio;
    }

    public void setIdPatrocinio(int idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(String indumentaria) {
        this.indumentaria = indumentaria;
    }

    public LocalDate getFechaContraroIn() {
        return fechaContraroIn;
    }

    public void setFechaContraroIn(LocalDate fechaContraroIn) {
        this.fechaContraroIn = fechaContraroIn;
    }

    public LocalDate getFechaContratoFn() {
        return fechaContratoFn;
    }

    public void setFechaContratoFn(LocalDate fechaContratoFn) {
        this.fechaContratoFn = fechaContratoFn;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Patrocinio{" + "idPatrocinio=" + idPatrocinio + ", jugador=" + jugador + ", patrocinador=" + patrocinador + ", indumentaria=" + indumentaria + ", fechaContraroIn=" + fechaContraroIn + ", fechaContratoFn=" + fechaContratoFn + ", activo=" + activo + '}';
    }

    
}

