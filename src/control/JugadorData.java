
package control;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.Jugador;



public class JugadorData {
    private java.sql.Connection con;

    public JugadorData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }

    public boolean guardarJugador(Jugador jugador) {
        boolean guardado = true;
        String sql = "INSERT INTO `jugador`(`Nombre`, `Apellido`, `DNI`, `FechaNacimiento`, `Altura`, `Peso`, `Estilo`, `Diestro`, `Activo`) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setLong(3, jugador.getDni());
            ps.setDate(4, Date.valueOf(jugador.getFechaNacimiento()));
            ps.setDouble(5, jugador.getAltura());
            ps.setDouble(6, jugador.getPeso());
            ps.setString(7, jugador.getEstilo());
            ps.setBoolean(8, jugador.isDiestro());
            ps.setBoolean(9, jugador.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                jugador.setIdJugador(rs.getInt("IDJugador"));
            }
            ps.close();
        } catch (SQLException ex) {
            guardado = false;
            System.out.println("Error al insertar el registro" + ex);
        }
        return guardado;
    }
    
    public boolean actualizarJugador(Jugador jugador) {
    
        boolean actualizado = true;
        String sql = "UPDATE `jugador` SET `Nombre`=?,`Apellido`=?,`DNI`=?,`FechaNacimiento`=?,`Altura`=?,`Peso`=?,`Estilo`=?,`Diestro`=?,`Activo`=? WHERE idJugador=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setLong(3, jugador.getDni());
            ps.setDate(4, Date.valueOf(jugador.getFechaNacimiento()));
            ps.setDouble(5, jugador.getAltura());
            ps.setDouble(6, jugador.getPeso());
            ps.setString(7, jugador.getEstilo());
            ps.setBoolean(8, jugador.isDiestro());
            ps.setBoolean(9, jugador.isActivo());
            ps.setInt(10, jugador.getIdJugador());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            actualizado = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return actualizado;
    }

    public boolean borrarJugador(int idJugador) {
     boolean borrado = true;
        String sql = "DELETE FROM `jugador` WHERE idJugador=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idJugador);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            borrado = false;
            System.out.println("Error al intentar borrar registro " + ex);
        }
        return borrado;
    }
  
    public boolean desactivarJugador(Jugador jugador) {
        jugador.setActivo(false);
        jugador.toString();
        return actualizarJugador(jugador);
    }
 
    public boolean activarJugador(Jugador jugador) {
        jugador.setActivo(true);
        return actualizarJugador(jugador);
    }
    
    public List<Jugador> obtenerJugador() {
        return obtenerJugador("");
    }

    public List<Jugador> obtenerJugador(String cadena) {
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = null;

        String sql = "SELECT * FROM jugador Where Nombre like '%" + cadena + "%' or Apellido like '%" + cadena + "%'  or DNI like '%" + cadena + "%'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jugador = new Jugador();
                jugador.setIdJugador(rs.getInt("IDJugador"));
                jugador.setNombre(rs.getString("Nombre"));
                jugador.setApellido(rs.getString("Apellido"));
                jugador.setDni(rs.getLong("DNI"));
                jugador.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
                jugador.setAltura(rs.getDouble("Altura"));
                jugador.setPeso(rs.getDouble("Peso"));
                jugador.setEstilo(rs.getString("Estilo"));
                jugador.setDiestro(rs.getBoolean("Diestro"));
                jugador.setActivo(rs.getBoolean("Activo"));

                jugadores.add(jugador);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return jugadores;
    }

    public Jugador buscarJugador(int idJugador) {
        Jugador jugador = null;

        String sql = "SELECT * FROM jugador WHERE IDJugador=?";
        

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idJugador);

            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jugador = new Jugador();
                jugador.setIdJugador(rs.getInt("IDJugador"));
                jugador.setNombre(rs.getString("Nombre"));
                jugador.setApellido(rs.getString("Apellido"));
                jugador.setDni(rs.getLong("DNI"));
                jugador.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
                jugador.setAltura(rs.getDouble("Altura"));
                jugador.setPeso(rs.getDouble("Peso"));
                jugador.setEstilo(rs.getString("Estilo"));
                jugador.setDiestro(rs.getBoolean("Diestro"));
                jugador.setActivo(rs.getBoolean("Activo"));
 }
        } catch (SQLException ex) {
            System.out.println("Error al buscar jugador.");
        }
        return jugador;
    }

}
