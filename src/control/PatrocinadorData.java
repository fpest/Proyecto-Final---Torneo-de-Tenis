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
import modelo.Patrocinador;

/**
 *
 * @author TomasNievas
 */
public class PatrocinadorData {
    private java.sql.Connection con;

    public PatrocinadorData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public boolean guardarPatrocinador(Patrocinador patrocinador) {
        boolean guardado = true;
        String sql = "INSERT INTO `patrocinador` (`Marca`, `Activo`) VALUES (?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patrocinador.getMarca());
            ps.setBoolean(2, patrocinador.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                patrocinador.setIdPatrocinador(rs.getInt("idPatrocinador"));
            }
            ps.close();
        } catch (SQLException ex) {
            guardado = false;
            System.out.println("Error al insertar el registro" + ex);
        }
        return guardado;
    }
    
    public boolean actualizarPatrocinador(Patrocinador patrocinador) {
    
        boolean actualizado = true;
        String sql = "UPDATE `patrocinador` SET `Marca`=?,`Activo`=? WHERE `IDPatrocinador`=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, patrocinador.getMarca());
            ps.setBoolean(2, patrocinador.isActivo());
            ps.setInt(3, patrocinador.getIdPatrocinador());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            actualizado = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return actualizado;
    }
    
    public boolean borrarPatrocinador(int idPatrocinador) {
     boolean borrado = true;
        String sql = "DELETE FROM `patrocinador` WHERE IDPatrocinador=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPatrocinador);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            borrado = false;
            System.out.println("Error al intentar borrar registro " + ex);
        }
        return borrado;
    }
    
    public boolean desactivarPatrocinador(Patrocinador patrocinador) {
        patrocinador.setActivo(false);
        patrocinador.toString();
        return actualizarPatrocinador(patrocinador);
    }
 
    public boolean activarPatrocinador(Patrocinador patrocinador) {
        patrocinador.setActivo(true);
        return actualizarPatrocinador(patrocinador);
    }
    
    public List<Patrocinador> obtenerPatrocinador() {
        return obtenerPatrocinador("");
    }
    
    public List<Patrocinador> obtenerPatrocinador(String cadena) {
        List<Patrocinador> patrocinadores = new ArrayList<>();
        Patrocinador patrocinador = null;

        String sql = "SELECT * FROM patrocinador Where Marca like '%" + cadena + "%'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patrocinador = new Patrocinador();
                patrocinador.setIdPatrocinador(rs.getInt("IDPatrocinador"));
                patrocinador.setMarca(rs.getString("Marca"));
                patrocinador.setActivo(rs.getBoolean("Activo"));

                patrocinadores.add(patrocinador);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return patrocinadores;
    }
    
    public Patrocinador buscarPatrocinador(int idPatrocinador) {
        Patrocinador patrocinador = null;

        String sql = "SELECT * FROM patrocinador WHERE IDPatrocinador=?";
        

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPatrocinador);

            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                patrocinador = new Patrocinador();
                patrocinador.setIdPatrocinador(rs.getInt("idPatrocinador"));
                patrocinador.setMarca(rs.getString("Marca"));
                patrocinador.setActivo(rs.getBoolean("Activo"));
 }
        } catch (SQLException ex) {
            System.out.println("Error al buscar patrocinador.");
        }
        return patrocinador;
    }
}