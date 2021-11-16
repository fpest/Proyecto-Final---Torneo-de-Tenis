package control;

import static control.PartidoData.formatter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Jugador;
import modelo.Patrocinador;
import modelo.Patrocinio;

public class PatrocinioData {

    private java.sql.Connection con;

    private JugadorData jugadorData;
    private PatrocinadorData patrocinadorData;

    public PatrocinioData(Conexion conexion) {
        try {
            con = conexion.getConexion();
            jugadorData = new JugadorData(conexion);
            patrocinadorData = new PatrocinadorData(conexion);
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }

    
    public boolean guardarPatrocinio(Patrocinio patrocinio) {
        boolean guardado = true;
        String sql = "INSERT INTO `patrocinio`(`IDJugador`, `IDPatrocinador`, `Indumentaria`, `FechaIniContrato`, `FechaFinContrato`, `Activo`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, patrocinio.getJugador().getIdJugador());
            ps.setInt(2, patrocinio.getPatrocinador().getIdPatrocinador());
            ps.setString(3, patrocinio.getIndumentaria());
            ps.setDate(4, Date.valueOf(patrocinio.getFechaContraroIn()));
            ps.setDate(5, Date.valueOf(patrocinio.getFechaContratoFn()));
            ps.setBoolean(6, patrocinio.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                patrocinio.setIdPatrocinio(rs.getInt("IDPatrocinio"));
            }
            ps.close();
        } catch (SQLException ex) {
            guardado = false;
            System.out.println("Error al insertar el registro" + ex);
        }
        return guardado;
    }

    public boolean actualizarPatrocinio(Patrocinio patrocinio) {

        boolean actualizado = true;
        String sql = "UPDATE `patrocinio` SET `IDJugador`=?,`IDPatrocinador`=?,`Indumentaria`=?,`FechaIniContrato`=?,`FechaFinContrato`=?,`Activo`=? WHERE IDPatrocinio=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patrocinio.getJugador().getIdJugador());
            ps.setInt(2, patrocinio.getPatrocinador().getIdPatrocinador());
            ps.setString(3, patrocinio.getIndumentaria());
            ps.setDate(4, Date.valueOf(patrocinio.getFechaContraroIn()));
            ps.setDate(5, Date.valueOf(patrocinio.getFechaContratoFn()));
            ps.setBoolean(6, patrocinio.isActivo());

            ps.setInt(7, patrocinio.getIdPatrocinio());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            actualizado = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return actualizado;
    }

    public boolean borrarPatrocinio(int idPatrocinio) {
        boolean borrado = true;
        String sql = "DELETE FROM `patrocinio` WHERE IDPatrocinio=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPatrocinio);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            borrado = false;
            System.out.println("Error al intentar borrar registro " + ex);
        }
        return borrado;
    }

    public boolean desactivarPatrocinio(Patrocinio patrocinio) {
        patrocinio.setActivo(false);
//        patrocinio.toString();
        return actualizarPatrocinio(patrocinio);
    }

    public boolean activarPatrocinio(Patrocinio patrocinio) {
        patrocinio.setActivo(true);
        return actualizarPatrocinio(patrocinio);
    }

    public List<Patrocinio> obtenerPatrocinio() {
        List<Patrocinio> patrocinios = new ArrayList<>();
        Patrocinio patrocinio = null;

        String sql = "SELECT `IDPatrocinio`, `IDJugador`,`IDPatrocinador`,`Indumentaria`,`FechaIniContrato`,`FechaFinContrato`,`Activo` FROM `patrocinio`";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patrocinio = new Patrocinio();
                patrocinio.setIdPatrocinio(rs.getInt("IDPatrocinio"));
                patrocinio.setJugador(jugadorData.buscarJugador(rs.getInt("IDJugador")));
                patrocinio.setPatrocinador(patrocinadorData.buscarPatrocinador(rs.getInt("IDPatrocinador")));
                patrocinio.setIndumentaria(rs.getString("Indumentaria"));
                patrocinio.setFechaContraroIn(rs.getDate("FechaIniContrato").toLocalDate());
                patrocinio.setFechaContratoFn(rs.getDate("FechaFinContrato").toLocalDate());
                patrocinio.setActivo(rs.getBoolean("Activo"));

                patrocinios.add(patrocinio);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return patrocinios;
    }

    public List<Patrocinio> obtenerPatrocinioJugador(Jugador jugador) {
        List<Patrocinio> patrocinios = new ArrayList<>();
        Patrocinio patrocinio = null;
      
        String sql = "SELECT `IDJugador`,`IDPatrocinador`,`Indumentaria`,`FechaIniContrato`,`FechaFinContrato`, `Activo` FROM `patrocinio` WHERE `IDJugador`= " + jugador.getIdJugador();

     
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patrocinio = new Patrocinio();
                patrocinio.setJugador(jugadorData.buscarJugador(rs.getInt("IDJugador")));
                patrocinio.setPatrocinador(patrocinadorData.buscarPatrocinador(rs.getInt("IDPatrocinador")));
                patrocinio.setIndumentaria(rs.getString("Indumentaria"));
                patrocinio.setFechaContraroIn(rs.getDate("FechaIniContrato").toLocalDate());
                patrocinio.setFechaContratoFn(rs.getDate("FechaFinContrato").toLocalDate());
                patrocinio.setActivo(rs.getBoolean("Activo"));

                patrocinios.add(patrocinio);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return patrocinios;
    }

    public List<Patrocinio> obtenerPatrocinioPatrocinador(Patrocinador patrocinador) {
        List<Patrocinio> patrocinios = new ArrayList<>();
        Patrocinio patrocinio = null;

        String sql = "SELECT `IDJugador`,`IDPatrocinador`,`Indumentaria`,`FechaIniContrato`,`FechaFinContrato` FROM `patrocinio` WHERE `IDPatrocinador`= " + patrocinador.getIdPatrocinador();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patrocinio = new Patrocinio();
                patrocinio.setJugador(jugadorData.buscarJugador(rs.getInt("IDJugador")));
                patrocinio.setPatrocinador(patrocinadorData.buscarPatrocinador(rs.getInt("IDPatrocinador")));
                patrocinio.setIndumentaria(rs.getString("Indumentaria"));
                patrocinio.setFechaContraroIn(rs.getDate("FechaIniContrato").toLocalDate());
                patrocinio.setFechaContratoFn(rs.getDate("FechaFinContrato").toLocalDate());
                patrocinio.setActivo(rs.getBoolean("Activo"));

                patrocinios.add(patrocinio);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return patrocinios;
    }

    public Patrocinio buscarPatrocinio(int idPatrocinio) {
        Patrocinio patrocinio = null;

        String sql = "SELECT `IDPatrocinio`, `IDJugador`,`IDPatrocinador`,`Indumentaria`,`FechaIniContrato`,`FechaFinContrato`, `Activo` FROM `patrocinio` WHERE `IDPatrocinio` = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, idPatrocinio);

           ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                
                patrocinio = new Patrocinio();
                patrocinio.setIdPatrocinio(rs.getInt("IDPatrocinio"));
                patrocinio.setJugador(jugadorData.buscarJugador(rs.getInt("IDJugador")));
                patrocinio.setPatrocinador(patrocinadorData.buscarPatrocinador(rs.getInt("IDPatrocinador")));
                patrocinio.setIndumentaria(rs.getString("Indumentaria"));
                patrocinio.setFechaContraroIn(rs.getDate("FechaIniContrato").toLocalDate());
                patrocinio.setFechaContratoFn(rs.getDate("FechaFinContrato").toLocalDate());
                patrocinio.setActivo(rs.getBoolean("Activo"));

            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar patrocinio.");
        }
        return patrocinio;
    }
    
    public Patrocinio buscarPatrocinioJugadorContrato(Jugador jugador, String fechaInicioContrato, String fechaFinContrato, String indumentaria, int activo) {
        
        Patrocinio patrocinio = null;

        String sql = "SELECT `IDPatrocinio`, `IDJugador`,`IDPatrocinador`,`Indumentaria`,`FechaIniContrato`,`FechaFinContrato`, `Activo` "
                + "FROM `patrocinio` "
                + "WHERE `IDJugador` = " + jugador.getIdJugador() + "  and `FechaIniContrato` = '" + fechaInicioContrato + "' and `FechaFinContrato` = '" + fechaFinContrato + "' and `Indumentaria` = '" + indumentaria + "' and `Activo`= " + activo + " ";
                  
      
//          JOptionPane.showMessageDialog(null, jugador.getIdJugador() + " " + fechaInicioContrato  + " " + fechaFinContrato  + " " + indumentaria  + " " + activo);
          
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, jugador.getIdJugador());
//            ps.setString(2, fechaInicioContrato);
//            ps.setString(3, fechaFinContrato);
//            ps.setString(4, indumentaria);
//            ps.setInt(5, activo);

   
            
           ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                
                patrocinio = new Patrocinio();
                patrocinio.setIdPatrocinio(rs.getInt("IDPatrocinio"));
                patrocinio.setJugador(jugadorData.buscarJugador(rs.getInt("IDJugador")));
                patrocinio.setPatrocinador(patrocinadorData.buscarPatrocinador(rs.getInt("IDPatrocinador")));
                patrocinio.setIndumentaria(rs.getString("Indumentaria"));
                patrocinio.setFechaContraroIn(rs.getDate("FechaIniContrato").toLocalDate());
                patrocinio.setFechaContratoFn(rs.getDate("FechaFinContrato").toLocalDate());
                patrocinio.setActivo(rs.getBoolean("Activo"));

            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar patrocinio.");
        }
        return patrocinio;
    }

    
    //SELECT COUNT(`IDPatrocinio`) FROM `patrocinio` pa join `jugador` ju on ju.IDJugador = pa.IDJugador WHERE pa.IDJugador = 204 and ju.Activo= 1 and pa.Activo = 1 and (now()>`FechaIniContrato` AND now()<`FechaFinContrato`);
    
    public int cantidadPatrociniosActivos(Jugador jugador){
        Patrocinio patrocinio=null;
        int cantidadPatrociniosActivos=0;
        String sql = "SELECT COUNT(`IDPatrocinio`) FROM `patrocinio` pa join `jugador` ju on ju.IDJugador = pa.IDJugador WHERE pa.IDJugador = ? and ju.Activo= 1 and pa.Activo = 1 and (now()>`FechaIniContrato` AND now()<`FechaFinContrato`)";
//          JOptionPane.showMessageDialog(null, jugador.getIdJugador() + " " + fechaInicioContrato  + " " + fechaFinContrato  + " " + indumentaria  + " " + activo);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jugador.getIdJugador());
            
           ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              cantidadPatrociniosActivos = rs.getInt("COUNT(`IDPatrocinio`)");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar patrocinio.");
        }
        return cantidadPatrociniosActivos;
    }
    
    
    
    }
    

