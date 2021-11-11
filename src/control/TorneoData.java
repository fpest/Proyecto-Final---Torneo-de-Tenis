package control;
import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import modelo.Conexion;
import modelo.Torneo;

public class TorneoData {
    private Connection con = null;

    public TorneoData(Conexion conexion) {
        try{
            con=conexion.getConexion();
        }catch(SQLException ex){
            System.out.println("Error al obtener la conexion");
        }
    }
    
    public boolean guardarTorneo(Torneo torneo){
        boolean guardado = true;
        try{
            String sql = "INSERT INTO torneo (Nombre, FechaInicio, FechaFinalizacion, Activo) VALUES (?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, torneo.getNombre());
            ps.setDate(2, Date.valueOf(torneo.getFechaIn()));
            ps.setDate(3, Date.valueOf(torneo.getFechaFn()));
            ps.setBoolean(4, torneo.isActivo());
                       
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            
            if (rs.next()) {
                torneo.setIdTorneo(rs.getInt("IDTorneo"));
                System.out.println("Exito crear torneo");
            }
            ps.close();
        }catch (SQLException ex) {
            guardado = false;
            System.out.println("Error al crear torneo: " + ex.getMessage());
        }
        return guardado;
    }
    
  public boolean actualizarTorneo(Torneo torneo) {
    
        boolean actualizado = true;
        String sql = "UPDATE torneo SET Nombre=?,FechaInicio=?,FechaFinalizacion=?,Activo=? WHERE IDTorneo=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, torneo.getNombre());
            ps.setDate(2, Date.valueOf(torneo.getFechaIn()));
            ps.setDate(3, Date.valueOf(torneo.getFechaFn()));
            ps.setBoolean(4, torneo.isActivo());
            ps.setInt(5, torneo.getIdTorneo());
            ps.executeUpdate();

            ps.close();
            System.out.println("Torneo actualizado correctamente.");
        } catch (SQLException ex) {
            actualizado = false;
            System.out.println("Error al intentar modificar el torneo " + ex);
        }
        return actualizado;
    }
    public boolean borrarTorneo(int id) {
     boolean borrado = true;
        String sql = "DELETE FROM torneo WHERE IDTorneo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            borrado = false;
            System.out.println("Error al intentar borrar registro " + ex);
        }
        return borrado;
    }
    
    public boolean desactivarTorneo(Torneo torneo) {
        torneo.setActivo(false);
        torneo.toString();
        System.out.println("DESACTIVADO");
        return actualizarTorneo(torneo);
    }
    
    public boolean activarTorneo(Torneo torneo) {
        torneo.setActivo(true);
        torneo.toString();
        System.out.println("ACTIVADO");
        return actualizarTorneo(torneo);
    }
    
    public List<Torneo> obtenerTodosLosTorneos() {
        return obtenerTorneos("");
    }
    
     public List<Torneo> obtenerTorneos(String cadena) {
        List<Torneo> torneos = new ArrayList<>();
        Torneo torneo = null;

        String sql = "SELECT * FROM torneo WHERE Nombre like '%" + cadena + "%';";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                torneo = new Torneo();
                torneo.setIdTorneo(rs.getInt("IDTorneo"));
                torneo.setNombre(rs.getString("Nombre"));
                torneo.setFechaIn(rs.getDate("FechaInicio").toLocalDate());
                torneo.setFechaFn(rs.getDate("FechaFinalizacion").toLocalDate());
                torneo.setActivo(rs.getBoolean("Activo"));

                torneos.add(torneo);
            }
            ps.close();
            System.out.println("Torneos obtenidos correctamente");
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return torneos;
    }
    
    public Torneo buscarTorneo(int id) {
        Torneo torneo = null;

        String sql = "SELECT * FROM torneo WHERE IDTorneo=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                torneo = new Torneo();
                torneo.setIdTorneo(rs.getInt("IDTorneo"));
                torneo.setNombre(rs.getString("Nombre"));
                torneo.setFechaIn(rs.getDate("FechaInicio").toLocalDate());
                torneo.setFechaFn(rs.getDate("FechaFinalizacion").toLocalDate());
                torneo.setActivo(rs.getBoolean("Activo"));
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar Torneo.");
        }
        return torneo;
    }   
    
}