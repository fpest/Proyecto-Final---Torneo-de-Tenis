
package modelo;

public class Patrocinador {
private int idPatrocinador;
private String marca;
private boolean activo;

    public Patrocinador() {
    }

    public Patrocinador(String marca, boolean activo) {
        this.marca = marca;
        this.activo = activo;
    }

    public Patrocinador(int idPatrocinador, String marca, boolean activo) {
        this.idPatrocinador = idPatrocinador;
        this.marca = marca;
        this.activo = activo;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return  marca;
    }





}
