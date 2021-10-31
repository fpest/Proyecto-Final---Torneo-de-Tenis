
package modelo;


import java.time.LocalDate;


public class Patrocinio {
    int idPatrocinio, idJugador, idPatrocinador;
    String indumentaria;
    LocalDate fechaContraroIn, fechaContratoFn;
    boolean activo;

    public Patrocinio() {
    }

    public Patrocinio(int idJugador, int idPatrocinador, String indumentaria, LocalDate fechaContraroIn, LocalDate fechaContratoFn, boolean activo) {
        this.idJugador = idJugador;
        this.idPatrocinador = idPatrocinador;
        this.indumentaria = indumentaria;
        this.fechaContraroIn = fechaContraroIn;
        this.fechaContratoFn = fechaContratoFn;
        this.activo = activo;
    }

    public Patrocinio(int idPatrocinio, int idJugador, int idPatrocinador, String indumentaria, LocalDate fechaContraroIn, LocalDate fechaContratoFn, boolean activo) {
        this.idPatrocinio = idPatrocinio;
        this.idJugador = idJugador;
        this.idPatrocinador = idPatrocinador;
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

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
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
        return "Patrocinio{" + "idPatrocinio=" + idPatrocinio + ", idJugador=" + idJugador + ", idPatrocinador=" + idPatrocinador + ", indumentaria=" + indumentaria + ", fechaContraroIn=" + fechaContraroIn + ", fechaContratoFn=" + fechaContratoFn + ", activo=" + activo + '}';
    }
    
    
}

