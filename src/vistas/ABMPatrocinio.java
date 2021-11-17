/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.EstadioData;
import control.JugadorData;
import control.PatrocinadorData;
import control.PatrocinioData;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Estadio;
import modelo.Jugador;
import modelo.Partido;
import modelo.Patrocinador;
import modelo.Patrocinio;
import modelo.Torneo;

/**
 *
 * @author FP
 */
public class ABMPatrocinio extends javax.swing.JInternalFrame {

    /**
     * Creates new form ABMPatrocinio
     */
    private JugadorData jugadorData;
    private PatrocinadorData patrocinadorData;

    private ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private ArrayList<Patrocinador> listaPatrocinadores = new ArrayList<>();

    public ABMPatrocinio() {
        initComponents();

    }
    PatrocinioData patrocinioData;
    ArrayList<Patrocinio> listaPatrocinio = new ArrayList<>();
    Patrocinio patrocinio;

    public ABMPatrocinio(PatrocinioData patrocinioData, JugadorData jugadorData, PatrocinadorData patrocinadorData) {
        initComponents();
        this.patrocinioData = patrocinioData;
        this.jugadorData = jugadorData;
        this.patrocinadorData = patrocinadorData;

        Date hoy = new Date();
        
        jdcInicioContrato.setDate(hoy);
        
        LocalDate hoyLd = convertToLocalDate(hoy);
        LocalDate proximoAnoLd = hoyLd.plusYears(1);
        
        jdcFinContrato.setDate(convertToDate(proximoAnoLd));
        rbActivos.setSelected(true);
        llenarComboJugadores(true);
        llenarComboPatrocinadores(true);
        llenarTablaPatrocinios(true);

    }

    private void llenarTablaPatrocinios(boolean Activo) {
        DefaultTableModel model = (DefaultTableModel) tblPatrocinio.getModel();
        model.setRowCount(0);

        List<Patrocinio> listaPatrocinios = patrocinioData.obtenerPatrocinioJugador((Jugador) cbJugador.getSelectedItem());

        if (!listaPatrocinios.isEmpty()){
        for (Patrocinio patrocinio : listaPatrocinios) {

            if ((rbActivos.isSelected() && (patrocinio.isActivo())) || (!rbActivos.isSelected() && (!patrocinio.isActivo()))) {
                model.addRow(new Object[]{patrocinio.getPatrocinador().getMarca(), patrocinio.getIndumentaria(), patrocinio.getJugador().getApellido(), patrocinio.getFechaContraroIn(), patrocinio.getFechaContratoFn()});
            }

        }
        }
    }

    private void llenarComboJugadores(Boolean activo) {

        listaJugadores = (ArrayList) jugadorData.obtenerJugador();
        
        if (!listaJugadores.isEmpty()){
        
        int largoLista = listaJugadores.size();
        Jugador[] nombre = new Jugador[largoLista];

        int i = 0;

        for (Jugador jugador : listaJugadores) {
            if (jugador.isActivo() == activo) {
                cbJugador.addItem(jugador);
                i++;
            }
        }
    }
    }

    private void llenarComboPatrocinadores(Boolean activo) {

        listaPatrocinadores = (ArrayList) patrocinadorData.obtenerPatrocinador();
     if (!listaPatrocinadores.isEmpty()){
        
        int largoLista = listaPatrocinadores.size();
        Patrocinador[] nombre = new Patrocinador[largoLista];

        int i = 0;

        for (Patrocinador patrocinador : listaPatrocinadores) {
            if (patrocinador.isActivo() == activo) {
                cbPatrocinador.addItem(patrocinador);
                i++;
            }
        }
    }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        cbPatrocinador = new javax.swing.JComboBox<>();
        cbIndumentaria = new javax.swing.JComboBox<>();
        cbJugador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdcInicioContrato = new com.toedter.calendar.JDateChooser();
        jdcFinContrato = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatrocinio = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        rbActivos = new javax.swing.JRadioButton();
        rbInactivos = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPatrociniosActivos = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Altas/Bajas/Modificaciones Patrocinio");

        cbIndumentaria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Raqueta", "Remera", "Zapatilla", "Reloj" }));

        cbJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJugadorActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador:");

        jLabel3.setText("Patocinador:");

        jLabel4.setText("Indumentaria:");

        jdcInicioContrato.setDateFormatString("dd-MM-yyyy");

        jdcFinContrato.setDateFormatString("dd-MM-yyyy");

        jLabel5.setText("Inicio Contrato:");

        jLabel6.setText("Fin Contrato:");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tblPatrocinio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patrocinador", "Indumentaria", "Jugador", "Inicio", "Fin"
            }
        ));
        tblPatrocinio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatrocinioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPatrocinio);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbActivos);
        rbActivos.setText("Activos");
        rbActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActivosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbInactivos);
        rbInactivos.setText("Inactivos");
        rbInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInactivosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tabla de Patrocinadores por Jugador:");

        jLabel8.setText("* clickear sobre la fila para activar contrato.");

        lblPatrociniosActivos.setText("Patrocinios:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jdcInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jdcFinContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbJugador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbPatrocinador, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbIndumentaria, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(lblPatrociniosActivos))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbActivos)
                                .addGap(18, 18, 18)
                                .addComponent(rbInactivos))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatrociniosActivos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPatrocinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cbIndumentaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jdcFinContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbActivos)
                    .addComponent(rbInactivos)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnRegistrar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJugadorActionPerformed

        if (rbActivos.isSelected()) {
         
//            int cantidadPatrociniosActivos = 0;
//            cantidadPatrociniosActivos = (patrocinioData.cantidadPatrociniosActivos((Jugador) cbJugador.getSelectedItem()));
//            String cantidad = cantidadPatrociniosActivos+"";
//         lblPatrociniosActivos.setText(cantidad);
            llenarTablaPatrocinios(true);
        } else {
            llenarTablaPatrocinios(false);
        }

    }//GEN-LAST:event_cbJugadorActionPerformed

     public Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
    private LocalDate convertToLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    private boolean validar() {

        if (jdcInicioContrato.getDate().compareTo(jdcFinContrato.getDate()) > 0) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser menor a la fecha de finalizacion de contrato.");
            return false;
        }

        if (cbIndumentaria.getItemCount()==0 || cbJugador.getItemCount()==0 || cbPatrocinador.getItemCount()==0){
         JOptionPane.showMessageDialog(null, "Deben haber cargado tanto Indumentarias , Jugadores y Patrocinadores para poder Vincularlos por un Contrato.");
            return false;
        } 
        
        
        List<Patrocinio> listaPatrocinios = patrocinioData.obtenerPatrocinioJugador((Jugador) cbJugador.getSelectedItem());
        for (Patrocinio patrocinio : listaPatrocinios) {

            if (patrocinio.isActivo() && (patrocinio.getFechaContratoFn().compareTo(convertToLocalDate(jdcInicioContrato.getDate())) > 0) && patrocinio.getIndumentaria().equals(cbIndumentaria.getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "Este Jugador tiene vigente un contrato para el uso de: " + cbIndumentaria.getSelectedItem());
                return false;
            }

        }
        return true;
    }

    private void rbActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActivosActionPerformed
        if (rbActivos.isSelected()) {
            llenarTablaPatrocinios(true);
        } else {
            llenarTablaPatrocinios(false);
        }
    }//GEN-LAST:event_rbActivosActionPerformed

    private void rbInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInactivosActionPerformed
        if (rbActivos.isSelected()) {
            llenarTablaPatrocinios(true);
        } else {
            llenarTablaPatrocinios(false);
        }
    }//GEN-LAST:event_rbInactivosActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Patrocinio patrocinio = new Patrocinio();
        if (validar()){
            
            
            patrocinio.setIndumentaria(cbIndumentaria.getSelectedItem().toString());
            patrocinio.setJugador((Jugador) cbJugador.getSelectedItem());
            patrocinio.setPatrocinador((Patrocinador) cbPatrocinador.getSelectedItem());
            patrocinio.setFechaContraroIn(convertToLocalDate(jdcInicioContrato.getDate()));
            patrocinio.setFechaContratoFn(convertToLocalDate(jdcFinContrato.getDate()));
            patrocinio.setActivo(true);
            
            
            
            if (patrocinioData.guardarPatrocinio(patrocinio)){
                 JOptionPane.showMessageDialog(null, "Se registro correctamente el contrato.");
            }else{
            JOptionPane.showMessageDialog(null, "No se pudo registrar el contrato");
            }
        
            llenarTablaPatrocinios(true);
        
        
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblPatrocinioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatrocinioMouseClicked
        Patrocinio patrocinio=new Patrocinio();
//        Patrocinador  patrocinador;
        
        int filaSeleccionada = tblPatrocinio.getSelectedRow();
//        JOptionPane.showMessageDialog(null, tblPatrocinio.getValueAt(filaSeleccionada, 0));
        
          String indumentaria = ((String) tblPatrocinio.getValueAt(filaSeleccionada, 1));
          String patrocinador = ((String) tblPatrocinio.getValueAt(filaSeleccionada, 0));
          String jugador = ((String) tblPatrocinio.getValueAt(filaSeleccionada, 2));
          String fechaInicio = (tblPatrocinio.getValueAt(filaSeleccionada, 3).toString());
          String fechaFin = (tblPatrocinio.getValueAt(filaSeleccionada, 4).toString());
   
          if (rbActivos.isSelected()){
          String confirmacion = "¿Desea dar de Baja este Contrato? \n" + patrocinador + "\n" + indumentaria + "\n" + jugador + "\n" + fechaInicio + "\n" + fechaFin;
          if (JOptionPane.showConfirmDialog(null, confirmacion,"¿Desea dar de Baja Contrato?" ,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          Patrocinio patrocinioBaja = new Patrocinio();
          patrocinioBaja = patrocinioData.buscarPatrocinioJugadorContrato((Jugador) cbJugador.getSelectedItem(), fechaInicio, fechaFin, indumentaria, 1);
          if (patrocinioData.desactivarPatrocinio(patrocinioBaja)){
          llenarTablaPatrocinios(true);
          }
          }
          }else{
              
            JOptionPane.showMessageDialog(null, "No se puede Reactivar un contrato. Se debe generar nuevamente.");  
//          String confirmacion = "¿Desea Activar este Contrato? \n" + patrocinador + "\n" + indumentaria + "\n" + jugador + "\n" + fechaInicio + "\n" + fechaFin;
//          if (JOptionPane.showConfirmDialog(null, confirmacion,"¿Desea Activar Contrato?" ,
//                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//          Patrocinio patrocinioBaja = new Patrocinio();
//          patrocinioBaja = patrocinioData.buscarPatrocinioJugadorContrato((Jugador) cbJugador.getSelectedItem(), fechaInicio, fechaFin, indumentaria, 0);
//          if (patrocinioData.activarPatrocinio(patrocinioBaja)){
//          llenarTablaPatrocinios(true);
//          }
//          }
          }

          
          
          
          

    }//GEN-LAST:event_tblPatrocinioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbIndumentaria;
    private javax.swing.JComboBox<Jugador> cbJugador;
    private javax.swing.JComboBox<Patrocinador> cbPatrocinador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdcFinContrato;
    private com.toedter.calendar.JDateChooser jdcInicioContrato;
    private javax.swing.JLabel lblPatrociniosActivos;
    private javax.swing.JRadioButton rbActivos;
    private javax.swing.JRadioButton rbInactivos;
    private javax.swing.JTable tblPatrocinio;
    // End of variables declaration//GEN-END:variables
}
