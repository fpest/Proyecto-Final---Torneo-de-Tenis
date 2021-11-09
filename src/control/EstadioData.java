/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.Estadio;

/**
 *
 * @author TomasNievas
 */
public class EstadioData {
    private java.sql.Connection con;

    public EstadioData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public boolean guardarEstadio(Estadio estadio) {
        boolean guardado = true;
        String sql = "INSERT INTO `estadio`(`NumeroIdentificador`, `Ciudad`, `Direccion`, `Estado`, `Largo`, `Ancho`, `CantEspectadores`, `Categoria`, `Activo`) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, estadio.getNumeroIdentificador());
            ps.setString(2, estadio.getCiudad());
            ps.setString(3, estadio.getDireccion());
            ps.setInt(4, estadio.getEstado());
            ps.setDouble(5, estadio.getLargo());
            ps.setDouble(6, estadio.getAncho());
            ps.setLong(7, estadio.getCantidadEspectadores());
            ps.setString(8, estadio.getCategoria());
            ps.setBoolean(9, estadio.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                estadio.setIdEstadio(rs.getInt("idEstadio"));
            }
            ps.close();
        } catch (SQLException ex) {
            guardado = false;
            System.out.println("Error al insertar el registro" + ex);
        }
        return guardado;
    }
    
    public boolean actualizarEstadio(Estadio estadio) {
    
        boolean actualizado = true;
        String sql = "UPDATE `estadio` SET `NumeroIdentificador`=?,`Ciudad`=?,`Direccion`=?,`Estado`=?,`Largo`=?,`Ancho`=?,`CantEspectadores`=?,`Categoria`=?,`Activo`=? WHERE `IDEstadio`=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estadio.getNumeroIdentificador());
            ps.setString(2, estadio.getCiudad());
            ps.setString(3, estadio.getDireccion());
            ps.setInt(4, estadio.getEstado());
            ps.setDouble(5, estadio.getLargo());
            ps.setDouble(6, estadio.getAncho());
            ps.setLong(7, estadio.getCantidadEspectadores());
            ps.setString(8, estadio.getCategoria());
            ps.setBoolean(9, estadio.isActivo());
            ps.setInt(10, estadio.getIdEstadio());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            actualizado = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return actualizado;
    }
    
    public boolean borrarEstadio(int idEstadio) {
     boolean borrado = true;
        String sql = "DELETE FROM `estadio` WHERE idEstadio=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEstadio);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            borrado = false;
            System.out.println("Error al intentar borrar registro " + ex);
        }
        return borrado;
    }
    
    public boolean desactivarEstadio(Estadio estadio) {
        estadio.setActivo(false);
        estadio.toString();
        return actualizarEstadio(estadio);
    }
 
    public boolean activarEstadio(Estadio estadio) {
        estadio.setActivo(true);
        return actualizarEstadio(estadio);
    }
    
    public List<Estadio> obtenerEstadio() {
        return obtenerEstadio("");
    }
    
    public List<Estadio> obtenerEstadio(String cadena) {
        List<Estadio> estadios = new ArrayList<>();
        Estadio estadio = null;

        String sql = "SELECT * FROM estadio Where NumeroIdentificador like '%" + cadena + "%' or Ciudad like '%" + cadena + "%'  or Direccion like '%" + cadena + "%'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt("IDEstadio"));
                estadio.setNumeroIdentificador(rs.getInt("NumeroIdentificador"));
                estadio.setCiudad(rs.getString("Ciudad"));
                estadio.setDireccion(rs.getString("Direccion"));
                estadio.setEstado(rs.getInt("Estado"));
                estadio.setLargo(rs.getDouble("Largo"));
                estadio.setAncho(rs.getDouble("Ancho"));
                estadio.setCantidadEspectadores(rs.getLong("CantEspectadores"));
                estadio.setCategoria(rs.getString("Categoria"));
                estadio.setActivo(rs.getBoolean("Activo"));

                estadios.add(estadio);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return estadios;
    }
    
    public Estadio buscarEstadio(int idEstadio) {
        Estadio estadio = null;

        String sql = "SELECT * FROM estadio WHERE IDEstadio=?";
        

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEstadio);

            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt("IDEstadio"));
                estadio.setNumeroIdentificador(rs.getInt("NumeroIdentificador"));
                estadio.setCiudad(rs.getString("Ciudad"));
                estadio.setDireccion(rs.getString("Direccion"));
                estadio.setEstado(rs.getInt("Estado"));
                estadio.setLargo(rs.getDouble("Largo"));
                estadio.setAncho(rs.getDouble("Ancho"));
                estadio.setCantidadEspectadores(rs.getLong("CantEspectadores"));
                estadio.setCategoria(rs.getString("Categoria"));
                estadio.setActivo(rs.getBoolean("Activo"));
 }
        } catch (SQLException ex) {
            System.out.println("Error al buscar estadio.");
        }
        return estadio;
    }
}