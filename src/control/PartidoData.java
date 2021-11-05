
package control;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Partido;

public class PartidoData {
private java.sql.Connection con;

    public PartidoData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }

    
    public boolean guardarPartido(Partido partido) {
        boolean guardado = true;
        String sql = "INSERT INTO `partido`(`IDTorneo`, `IDJugador1`, `IDJugador2`, `IDEstadio`, `FechaHora`, `Estado`, `IDJugadorGanador`, `Resultado`, `InstanciaTorneo`, `Activo`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, partido.getIdTorneo());
            ps.setInt(2, partido.getIdJugador1());
            ps.setInt(3, partido.getIdJugador2());
            ps.setInt(4, partido.getIdEstadio());
            ps.setDate(5, Date.valueOf(partido.getFechaHora()));
            ps.setString(6, partido.getEstado());
            ps.setInt(7, partido.getIdJugadorGanador());
            ps.setString(8, partido.getResultado());
            ps.setString(9, partido.getInstanciaTorneo());
            ps.setBoolean(10, partido.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                partido.setIdPartido(rs.getInt("IDPartido"));
            }
            ps.close();
        } catch (SQLException ex) {
            guardado = false;
            System.out.println("Error al insertar el registro" + ex);
        }
        return guardado;
    }
    
    public boolean actualizarPartido(Partido partido) {
    
        boolean actualizado = true;
        String sql = "UPDATE `partido` SET `IDTorneo`=?,`IDJugador1`=?,`IDJugador2`=?,`IDEstadio`=?,`FechaHora`=?,`Estado`=?,`IDJugadorGanador`=?,`Resultado`=?,`InstanciaTorneo`=?,`Activo`=? WHERE IDPartido=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
 ps.setInt(1, partido.getIdTorneo());
            ps.setInt(2, partido.getIdJugador1());
            ps.setInt(3, partido.getIdJugador2());
            ps.setInt(4, partido.getIdEstadio());
            ps.setDate(5, Date.valueOf(partido.getFechaHora()));
            ps.setString(6, partido.getEstado());
            ps.setInt(7, partido.getIdJugadorGanador());
            ps.setString(8, partido.getResultado());
            ps.setString(9, partido.getInstanciaTorneo());
            ps.setBoolean(10, partido.isActivo());
            ps.setInt(11, partido.getIdPartido());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            actualizado = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return actualizado;
    }

    public boolean borrarPartido(int idPartido) {
     boolean borrado = true;
        String sql = "DELETE FROM `partido` WHERE IDPartido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPartido);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            borrado = false;
            System.out.println("Error al intentar borrar registro " + ex);
        }
        return borrado;
    }
  
    public boolean desactivarPartido(Partido partido) {
        partido.setActivo(false);
        partido.toString();
        return actualizarPartido(partido);
    }
 
    public boolean activarPartido(Partido partido) {
        partido.setActivo(true);
        return actualizarPartido(partido);
    }
    
    public List<Partido> obtenerPartido(int torneoActivo) {
        List<Partido> partidos = new ArrayList<>();
        Partido partido = null;

        String sql = "SELECT * FROM `partido` WHERE `Activo`= " + torneoActivo;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                partido = new Partido();
                partido.setIdPartido(rs.getInt("IDPartido"));
                partido.setIdTorneo(rs.getInt("IDTorneo"));
                partido.setIdJugador1(rs.getInt("IDJugador1"));
                partido.setIdJugador2(rs.getInt("IDJugador2"));
                partido.setIdEstadio(rs.getInt("IDEstadio"));
                partido.setFechaHora(rs.getDate("FechaHora").toLocalDate());
                partido.setEstado(rs.getString("Estado"));
                partido.setIdJugadorGanador(rs.getInt("IDJugadorGanador"));
                partido.setResultado(rs.getString("Resultado"));
                partido.setInstanciaTorneo(rs.getString("InstanciaTorneo"));
                partido.setActivo(rs.getBoolean("Activo"));

                partidos.add(partido);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return partidos;
    }
    
    
    public List<Partido> obtenerPartidoTorneo(String torneoNombre, String torneoEstado, int torneoActivo) {
        List<Partido> partidos = new ArrayList<>();
        Partido partido = null;

        String sql = "SELECT * FROM `partido` pa JOIN `torneo` tor on pa.IDTorneo = tor.IDTorneo WHERE `tor.Nombre`= " + torneoNombre + " and `Estado`= " + torneoEstado + " and `Activo`= " + torneoActivo;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                partido = new Partido();
                partido.setIdPartido(rs.getInt("IDPartido"));
                partido.setIdTorneo(rs.getInt("IDTorneo"));
                partido.setIdJugador1(rs.getInt("IDJugador1"));
                partido.setIdJugador2(rs.getInt("IDJugador2"));
                partido.setIdEstadio(rs.getInt("IDEstadio"));
                partido.setFechaHora(rs.getDate("FechaHora").toLocalDate());
                partido.setEstado(rs.getString("Estado"));
                partido.setIdJugadorGanador(rs.getInt("IDJugadorGanador"));
                partido.setResultado(rs.getString("Resultado"));
                partido.setInstanciaTorneo(rs.getString("InstanciaTorneo"));
                partido.setActivo(rs.getBoolean("Activo"));

                partidos.add(partido);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return partidos;
    }
    
    
    public Partido buscarPartido(int idPartido) {
        Partido partido = null;

        String sql = "SELECT * FROM partido WHERE IDPartido=?";
        

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPartido);

            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                partido = new Partido();
                partido.setIdPartido(rs.getInt("IDPartido"));
                partido.setIdTorneo(rs.getInt("IDTorneo"));
                partido.setIdJugador1(rs.getInt("IDJugador1"));
                partido.setIdJugador2(rs.getInt("IDJugador2"));
                partido.setIdEstadio(rs.getInt("IDEstadio"));
                partido.setFechaHora(rs.getDate("FechaHora").toLocalDate());
                partido.setEstado(rs.getString("Estado"));
                partido.setIdJugadorGanador(rs.getInt("IDJugadorGanador"));
                partido.setResultado(rs.getString("Resultado"));
                partido.setInstanciaTorneo(rs.getString("InstanciaTorneo"));
                partido.setActivo(rs.getBoolean("Activo"));
}
        } catch (SQLException ex) {
            System.out.println("Error al buscar partido.");
        }
        return partido;
    }
    
}
