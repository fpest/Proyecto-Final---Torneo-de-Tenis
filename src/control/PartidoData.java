package control;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.zone;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Estadio;
import modelo.Jugador;
import modelo.Partido;
import modelo.Patrocinio;
import modelo.Torneo;

public class PartidoData {

    private java.sql.Connection con;

    private JugadorData jugadorData;
    private EstadioData estadioData;
    private TorneoData torneoData;

    public PartidoData(Conexion conexion) {
        try {
            con = conexion.getConexion();

            jugadorData = new JugadorData(conexion);
            estadioData = new EstadioData(conexion);
            torneoData = new TorneoData(conexion);

        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public boolean guardarPartidoInicial(Partido partido) {
        boolean guardado = true;
        String formattedDateTime = partido.getFechaHora().format(formatter);
        String sql = "INSERT INTO `partido`(`IDTorneo`, `IDJugador1`, `IDJugador2`, `IDEstadio`, `FechaHora`, `Estado`,`Activo`) VALUES (?,?,?,?,?,?,?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, partido.getTorneo().getIdTorneo());
            ps.setInt(2, partido.getJugador1().getIdJugador());
            ps.setInt(3, partido.getJugador2().getIdJugador());
            ps.setInt(4, partido.getEstadio().getIdEstadio());

            ps.setString(5, formattedDateTime);

            ps.setString(6, partido.getEstado());
            ps.setBoolean(7, partido.isActivo());

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

    public boolean guardarPartido(Partido partido) {
        boolean guardado = true;
        String formattedDateTime = partido.getFechaHora().format(formatter);
        String sql = "INSERT INTO `partido`(`IDTorneo`, `IDJugador1`, `IDJugador2`, `IDEstadio`, `FechaHora`, `Estado`, `IDJugadorGanador`, `Resultado`, `InstanciaTorneo`, `Activo`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {// 
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, partido.getTorneo().getIdTorneo());
            ps.setInt(2, partido.getJugador1().getIdJugador());
            ps.setInt(3, partido.getJugador2().getIdJugador());
            ps.setInt(4, partido.getEstadio().getIdEstadio());
            ps.setString(5, formattedDateTime);
            ps.setString(6, partido.getEstado());
            ps.setInt(7, partido.getJugadorGanador().getIdJugador());
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

    public boolean acautlizarPartidoFechaHora(Partido partido) {
        String formattedDateTime = partido.getFechaHora().format(formatter);
        boolean actualizado = true;
        String sql = "UPDATE `partido` SET `IDTorneo`=?,`IDJugador1`=?,`IDJugador2`=?,`IDEstadio`=?,`FechaHora`=?,`Estado`=?,`Activo`=? WHERE IDPartido=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, partido.getTorneo().getIdTorneo());
            ps.setInt(2, partido.getJugador1().getIdJugador());
            ps.setInt(3, partido.getJugador2().getIdJugador());
            ps.setInt(4, partido.getEstadio().getIdEstadio());
            ps.setString(5, formattedDateTime);
            ps.setString(6, partido.getEstado());
            ps.setBoolean(7, partido.isActivo());
            ps.setInt(8, partido.getIdPartido());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            actualizado = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return actualizado;
        
        
        
        
    }
    
    public boolean actualizarPartido(Partido partido) {
        String formattedDateTime = partido.getFechaHora().format(formatter);
        boolean actualizado = true;
        String sql = "UPDATE `partido` SET `IDTorneo`=?,`IDJugador1`=?,`IDJugador2`=?,`IDEstadio`=?,`FechaHora`=?,`Estado`=?,`IDJugadorGanador`=?,`Resultado`=?,`InstanciaTorneo`=?,`Activo`=? WHERE IDPartido=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, partido.getTorneo().getIdTorneo());
            ps.setInt(2, partido.getJugador1().getIdJugador());
            ps.setInt(3, partido.getJugador2().getIdJugador());
            ps.setInt(4, partido.getEstadio().getIdEstadio());
            ps.setString(5, formattedDateTime);
            ps.setString(6, partido.getEstado());
            ps.setInt(7, partido.getJugadorGanador().getIdJugador());
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
        return actualizarPartido(partido);
    }

    public boolean activarPartido(Partido partido) {
        partido.setActivo(true);
        return actualizarPartido(partido);
    }

    public LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return LocalDateTime.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    private LocalDateTime deMysqlALocalDateTime(String rs) {
        String sDate = rs;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT-6:00"));
        Date date = null;
        try {
            date = formatter.parse(sDate);
            return convertToLocalDateTime(date);
        } catch (ParseException ex) {
            Logger.getLogger(PartidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertToLocalDateTime(date);
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
                partido.setTorneo(torneoData.buscarTorneo(rs.getInt("IDTorneo")));
                partido.setJugador1(jugadorData.buscarJugador(rs.getInt("IDJugador1")));
                partido.setJugador2(jugadorData.buscarJugador(rs.getInt("IDJugador2")));
                partido.setEstadio(estadioData.buscarEstadio(rs.getInt("IDEstadio")));
                partido.setFechaHora(deMysqlALocalDateTime(rs.getObject("FechaHora").toString()));
                partido.setEstado(rs.getString("Estado"));
                partido.setJugadorGanador(jugadorData.buscarJugador(rs.getInt("IDJugadorGanador")));
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

    public List<Partido> obtenerPartidoEstadioFecha(Partido partido) {

        String formattedDateTime = partido.getFechaHora().format(formatter);

        List<Partido> listaPartidos = new ArrayList<>();

        // String sql = "SELECT `IDJugador1`, `IDJugador2`, `FechaHora` FROM `partido` WHERE `IDEstadio` = " + partido.getEstadio().getIdEstadio() + " and (`FechaHora` BETWEEN \"" + formattedDateTime + "\" and DATE_ADD(\"" + formattedDateTime + "\",INTERVAL 3 HOUR))";
        String sql = "SELECT * FROM `partido` WHERE `IDEstadio` = " + partido.getEstadio().getIdEstadio() + " and ((`FechaHora` BETWEEN \"" + formattedDateTime + "\" and DATE_ADD(\"" + formattedDateTime + "\",INTERVAL 3 HOUR)) || (DATE_ADD(`FechaHora`,INTERVAL 3 HOUR) BETWEEN \"" + formattedDateTime + "\" and DATE_ADD(\"" + formattedDateTime + "\",INTERVAL 3 HOUR)))";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                partido = new Partido();
//                Estadio estadio = new Estadio();
//          
//                estadio = estadioData.buscarEstadio(1);
//                
//                partido.setJugador1(jugadorData.buscarJugador(rs.getInt("IDJugador1")));
//                partido.setJugador2(jugadorData.buscarJugador(rs.getInt("IDJugador2")));
//                partido.setFechaHora(deMysqlALocalDateTime(rs.getObject("FechaHora").toString()));
//               

                partido.setIdPartido(rs.getInt("IDPartido"));
                partido.setTorneo(torneoData.buscarTorneo(rs.getInt("IDTorneo")));
                partido.setJugador1(jugadorData.buscarJugador(rs.getInt("IDJugador1")));
                partido.setJugador2(jugadorData.buscarJugador(rs.getInt("IDJugador2")));
                partido.setEstadio(estadioData.buscarEstadio(rs.getInt("IDEstadio")));
                partido.setFechaHora(deMysqlALocalDateTime(rs.getObject("FechaHora").toString()));
                partido.setEstado(rs.getString("Estado"));
                partido.setJugadorGanador(jugadorData.buscarJugador(rs.getInt("IDJugadorGanador")));
                partido.setResultado(rs.getString("Resultado"));
                partido.setInstanciaTorneo(rs.getString("InstanciaTorneo"));
                partido.setActivo(rs.getBoolean("Activo"));

                listaPartidos.add(partido);

            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros AQUI ");
        }
        return listaPartidos;
    }

    public List<Partido> obtenerPartidoJugadoresFecha(Partido partido) {

        String formattedDateTime = partido.getFechaHora().format(formatter);

        List<Partido> listaPartidos = new ArrayList<>();

        // String sql = "SELECT `IDJugador1`, `IDJugador2`, `FechaHora` FROM `partido` WHERE `IDEstadio` = " + partido.getEstadio().getIdEstadio() + " and (`FechaHora` BETWEEN \"" + formattedDateTime + "\" and DATE_ADD(\"" + formattedDateTime + "\",INTERVAL 3 HOUR))";
        String sql = "SELECT * FROM `partido` WHERE (`IDJugador1` = " + partido.getJugador1().getIdJugador() + " or `IDJugador2` = " + partido.getJugador2().getIdJugador() + ") and ((`FechaHora` BETWEEN \"" + formattedDateTime + "\" and DATE_ADD(\"" + formattedDateTime + "\",INTERVAL 3 HOUR)) or (DATE_ADD(`FechaHora`,INTERVAL 3 HOUR) BETWEEN \"" + formattedDateTime + "\" and DATE_ADD(\"" + formattedDateTime + "\",INTERVAL 3 HOUR)))";

        // JOptionPane.showMessageDialog(null,sql); 
        System.out.println(sql);
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                partido = new Partido();
//                Estadio estadio = new Estadio();
//                estadio = estadioData.buscarEstadio(1);
//                partido.setTorneo(torneoData.buscarTorneo(rs.getInt("IDTorneo")));
//                partido.setEstadio(estadioData.buscarEstadio(rs.getInt("IDEstadio")));
//                partido.setFechaHora(deMysqlALocalDateTime(rs.getObject("FechaHora").toString()));
//               
                partido.setIdPartido(rs.getInt("IDPartido"));
                partido.setTorneo(torneoData.buscarTorneo(rs.getInt("IDTorneo")));
                partido.setJugador1(jugadorData.buscarJugador(rs.getInt("IDJugador1")));
                partido.setJugador2(jugadorData.buscarJugador(rs.getInt("IDJugador2")));
                partido.setEstadio(estadioData.buscarEstadio(rs.getInt("IDEstadio")));
                partido.setFechaHora(deMysqlALocalDateTime(rs.getObject("FechaHora").toString()));
                partido.setEstado(rs.getString("Estado"));
                partido.setJugadorGanador(jugadorData.buscarJugador(rs.getInt("IDJugadorGanador")));
                partido.setResultado(rs.getString("Resultado"));
                partido.setInstanciaTorneo(rs.getString("InstanciaTorneo"));
                partido.setActivo(rs.getBoolean("Activo"));

                listaPartidos.add(partido);

            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros AQUI ");
        }
        return listaPartidos;
    }

    public List<Partido> obtenerPartidoTorneo(String torneoNombre, int torneoActivo) {
        List<Partido> listaPartidos = new ArrayList<>();
        Partido partido = new Partido();

        //String sql = "SELECT IDPartido, est.IDEstadio, est.NumeroIdentificador, ju1.IDJugador, ju1.Apellido, ju1.Nombre, ju2.IDJugador, ju2.Apellido, ju2.Nombre, FechaHora  FROM `partido` pa JOIN `torneo` tor on pa.IDTorneo = tor.IDTorneo JOIN `estadio`est on pa.IDEstadio = est.IdEstadio JOIN `jugador` ju1 on pa.IDJugador1 = ju1.IDJugador JOIN `jugador` ju2 on pa.IDJugador2 = ju2.IDJugador WHERE tor.Nombre = \"" + torneoNombre + "\" and pa.Activo = " + torneoActivo;
        String sql = "SELECT IDPartido, est.IDEstadio, est.NumeroIdentificador, ju1.IDJugador, ju1.Apellido, ju1.Nombre, ju2.IDJugador, ju2.Apellido, ju2.Nombre, FechaHora, jug.IDJugador, jug.Apellido, jug.Nombre, Resultado, InstanciaTorneo  FROM `partido` pa JOIN `torneo` tor on pa.IDTorneo = tor.IDTorneo JOIN `estadio`est on pa.IDEstadio = est.IdEstadio JOIN `jugador` ju1 on pa.IDJugador1 = ju1.IDJugador JOIN `jugador` ju2 on pa.IDJugador2 = ju2.IDJugador LEFT JOIN `jugador` jug on pa.IDJugadorGanador = jug.IDJugador WHERE tor.Nombre = \"" + torneoNombre + "\" and pa.Activo = " + torneoActivo;
      
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                partido = new Partido();
                Estadio estadio = new Estadio();

                //   estadio = estadioData.buscarEstadio(1);
                partido.setIdPartido(rs.getInt("IDPartido"));
                partido.setEstadio(estadioData.buscarEstadio(rs.getInt("est.IDEstadio")));
                partido.setJugador1(jugadorData.buscarJugador(rs.getInt("ju1.IDJugador")));
                partido.setJugador2(jugadorData.buscarJugador(rs.getInt("ju2.IDJugador")));
                partido.setFechaHora(deMysqlALocalDateTime(rs.getObject("FechaHora").toString()));
                partido.setJugadorGanador(jugadorData.buscarJugador(rs.getInt("jug.IDJugador")));
                partido.setResultado(rs.getString("Resultado"));
                partido.setInstanciaTorneo(rs.getString("InstanciaTorneo"));
                
                listaPartidos.add(partido);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return listaPartidos;
    }

    public Partido buscarPartido(int idPartido) {
        Partido partido = null;

        //  String formattedDateTime = partido.getFechaHora().format(formatter);
        String sql = "SELECT * FROM partido WHERE IDPartido=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPartido);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                partido = new Partido();
                partido.setIdPartido(rs.getInt("IDPartido"));
                partido.setTorneo(torneoData.buscarTorneo(rs.getInt("IDTorneo")));
                partido.setJugador1(jugadorData.buscarJugador(rs.getInt("IDJugador1")));
                partido.setJugador2(jugadorData.buscarJugador(rs.getInt("IDJugador2")));
                partido.setEstadio(estadioData.buscarEstadio(rs.getInt("IDEstadio")));
                partido.setFechaHora(deMysqlALocalDateTime(rs.getObject("FechaHora").toString()));
                partido.setEstado(rs.getString("Estado"));
                partido.setJugadorGanador(jugadorData.buscarJugador(rs.getInt("IDJugadorGanador")));
                partido.setResultado(rs.getString("Resultado"));
                partido.setInstanciaTorneo(rs.getString("InstanciaTorneo"));
                partido.setActivo(rs.getBoolean("Activo"));

            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar partido.");
        }
        return partido;
    }
    
    public List<Partido> obtenerPartidoJugadorGanador(Torneo torneo){
        List<Partido> listaPartidos = new ArrayList<>();
        Partido partido = new Partido();

        String sql = "SELECT DISTINCT `IDJugadorGanador`FROM `partido`pa JOIN `jugador` ju on ju.IDJugador = pa.IDJugadorGanador Where `IDTorneo` = ? and ju.Activo = 1";
      
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, torneo.getIdTorneo());
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                partido = new Partido();
               
                //   estadio = estadioData.buscarEstadio(1);
                partido.setJugadorGanador(jugadorData.buscarJugador(rs.getInt("IDJugadorGanador")));
                
                listaPartidos.add(partido);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return listaPartidos;
    }
    
    public int cantidadPartidosGanadosJugador(Jugador jugador, Torneo torneo){
           Partido partido=null;
        int cantidadPartidosGanados=0;
        String sql = "SELECT COUNT(`IDPartido`) FROM `partido` WHERE IDJugadorGanador = ? and IDTorneo = ? and Activo = 1";
 

try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jugador.getIdJugador());
            ps.setInt(2, torneo.getIdTorneo());
            
           ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              cantidadPartidosGanados = rs.getInt("COUNT(`IDPartido`)");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar partido.");
        }
        return cantidadPartidosGanados;
    }
    

    public List<Torneo> obtenerTorneosPorJugador(Jugador jugador){
        List<Torneo> listaTorneos = new ArrayList<>();
   
        Torneo torneo = new Torneo();
        
        
        String sql = "SELECT DISTINCT(tor.nombre) FROM partido par JOIN torneo tor on tor.IDTorneo = par.IDTorneo WHERE (`IDJugador1`=? or `IDJugador2`=?) and tor.Activo=1";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jugador.getIdJugador());
            ps.setInt(2, jugador.getIdJugador());
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                torneo = new Torneo();
               
                //   estadio = estadioData.buscarEstadio(1);
                torneo.setNombre(rs.getString("tor.nombre"));
                
                listaTorneos.add(torneo);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los torneos ");
        }
        return listaTorneos;
    }
    
   
        public List<Jugador> obtenerJugadoresPorTorneo(Torneo torneo){
        List<Jugador> listaJugadores = new ArrayList<>();
   
        Jugador jugador = new Jugador();
        
        
        String sql = "SELECT DISTINCT(IDJugador), Nombre, Apellido FROM ((SELECT jug1.IDJugador as IDJugador, jug1.nombre as Nombre, jug1.apellido as Apellido FROM partido par JOIN jugador jug1 on par.IDJugador1 = jug1.IDJugador WHERE IDTorneo = ? and jug1.Activo=1) UNION ALL (SELECT jug2.IDJugador as IDJugador, jug2.nombre as Nombre, jug2.apellido as Apellido FROM partido par JOIN jugador jug2 on par.IDJugador2 = jug2.IDJugador WHERE IDTorneo = ? and jug2.Activo=1)) jugadores;";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, torneo.getIdTorneo());
            ps.setInt(2, torneo.getIdTorneo());
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jugador = new Jugador();
               
                //   estadio = estadioData.buscarEstadio(1);
                jugador.setIdJugador(rs.getInt("IDJugador"));
                jugador.setNombre(rs.getString("Nombre"));
                jugador.setApellido(rs.getString("Apellido"));
                
//                System.out.println(jugador.getIdJugador() + " " + jugador.getApellido() + " " + jugador.getNombre());
                listaJugadores.add(jugador);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los torneos ");
        }
        
        return listaJugadores;
        }
        
        
}