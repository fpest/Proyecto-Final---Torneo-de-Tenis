/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.toedter.calendar.JDateChooser;
import control.EstadioData;
import control.JugadorData;
import control.PartidoData;
import control.TorneoData;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import modelo.*;

/**
 *
 * @author FP
 */
public class ConfTorneo extends javax.swing.JInternalFrame {

    private TorneoData torneoData;
    private PartidoData partidoData;
    private EstadioData estadioData;
    private JugadorData jugadorData;

    private ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private ArrayList<Torneo> listaTorneos = new ArrayList<>();
    private ArrayList<Estadio> listaEstadios = new ArrayList<>();
    private ArrayList<Partido> listaPartidos = new ArrayList<>();
    private Jugador jugadorGanador;
    private Partido partido;
    
    private int idJugador1=0;
    private int idJugador2=0;
    

    public ConfTorneo() {
        initComponents();
    }

    public ConfTorneo(TorneoData torneoData, PartidoData partidoData, EstadioData estadioData, JugadorData jugadorData) {
        initComponents();

        this.torneoData = torneoData;
        this.partidoData = partidoData;
        this.estadioData = estadioData;
        this.jugadorData = jugadorData;

        partido = new Partido();
        jugadorGanador = new Jugador();
        listaJugadores = (ArrayList) jugadorData.obtenerJugador();

     
        llenarListaJugadores(true);
        llenarComboTorneos(true);
        llenarComboEstadios(true);
        jSpHora.setValue(12);
        llenarTablaDePartidos(cbTorneos.getSelectedItem().toString());

    }

    //

  /*  private void llenarTablaDePartidosFechaHora(Partido partido) {
        DefaultTableModel model = (DefaultTableModel) tblPartidosTorneo.getModel();
        model.setRowCount(0);

        List<Partido> listaPartidos = partidoData.obtenerPartidoEstadioFecha(partido);

        for (Partido partidoHora : listaPartidos) {

            DecimalFormat formato = new DecimalFormat("00");
            LocalDateTime fechaHoraFinalizacion = partidoHora.getFechaHora().plusHours(3);
            
            String fechaHora = formato.format(partidoHora.getFechaHora().getDayOfMonth()) + "-" + formato.format(partidoHora.getFechaHora().getMonthValue()) + "-" + partidoHora.getFechaHora().getYear() + " " + partidoHora.getFechaHora().getHour() + ":00 hs.";
            String fechaHoraFin = formato.format(fechaHoraFinalizacion.getDayOfMonth()) + "-" + formato.format(fechaHoraFinalizacion.getMonthValue()) + "-" + fechaHoraFinalizacion.getYear() + " " + fechaHoraFinalizacion.getHour() + ":00 hs.";
            
            model.addRow(new Object[]{"Estadio " + partidoHora.getEstadio().getNumeroIdentificador(), partidoHora.getJugador1().getApellido() + ", " + partidoHora.getJugador1().getNombre(), partidoHora.getJugador2().getApellido() + ", " + partidoHora.getJugador2().getNombre(), fechaHora, fechaHoraFin});
        }
    }
*/
    
    
    private void llenarTablaDePartidos(String nombreTorneo) {
        DefaultTableModel model = (DefaultTableModel) tblPartidosTorneo.getModel();
        model.setRowCount(0);

        List<Partido> listaPartidos = partidoData.obtenerPartidoTorneo(nombreTorneo, 1);

        for (Partido partido : listaPartidos) {

            DecimalFormat formato = new DecimalFormat("00");
            LocalDateTime fechaHoraFinalizacion = partido.getFechaHora().plusHours(3);
            
            String fechaHora = formato.format(partido.getFechaHora().getDayOfMonth()) + "-" + formato.format(partido.getFechaHora().getMonthValue()) + "-" + partido.getFechaHora().getYear() + " " + partido.getFechaHora().getHour() + ":00 hs.";
            String fechaHoraFin = formato.format(fechaHoraFinalizacion.getDayOfMonth()) + "-" + formato.format(fechaHoraFinalizacion.getMonthValue()) + "-" + fechaHoraFinalizacion.getYear() + " " + fechaHoraFinalizacion.getHour() + ":00 hs.";
            
            model.addRow(new Object[]{"Estadio " + partido.getEstadio().getNumeroIdentificador(), partido.getJugador1().getApellido() + ", " + partido.getJugador1().getNombre(), partido.getJugador2().getApellido() + ", " + partido.getJugador2().getNombre(), fechaHora, fechaHoraFin});
        }
    }

    private void llenarComboTorneos(Boolean activo) {

        listaTorneos = (ArrayList) torneoData.obtenerTodosLosTorneos();
        int largoLista = listaTorneos.size();
        Torneo[] nombre = new Torneo[largoLista];

        int i = 0;

        for (Torneo torneo : listaTorneos) {
            if (torneo.isActivo() == activo) {
                cbTorneos.addItem(torneo);
                i++;
            }
        }

    }

    private void llenarComboEstadios(Boolean activo) {

        listaEstadios = (ArrayList) estadioData.obtenerEstadio();
        int largoLista = listaEstadios.size();
        Estadio[] nombre = new Estadio[largoLista];

        int i = 0;

        for (Estadio estadio : listaEstadios) {
            if (estadio.isActivo() == activo) {
                cbEstadio.addItem(estadio);
                i++;
            }
        }

    }

    private void llenarListaJugadores(Boolean activo) {

        if (txtBuscarJugador.getText() != "") {
            listaJugadores = (ArrayList) jugadorData.obtenerJugador(txtBuscarJugador.getText());
        } else {
            listaJugadores = (ArrayList) jugadorData.obtenerJugador();
        }
        lstJugadores.removeAll();

        int largoLista = listaJugadores.size();
        //    String[] apellidoNombre = new String[largoLista];
        Jugador[] apellidoNombre = new Jugador[largoLista];
        int i = 0;

        for (Jugador jugador : listaJugadores) {
            if (jugador.isActivo() == activo) {
                apellidoNombre[i] = jugador;
                i++;
            }
        }
        lstJugadores.setModel(new javax.swing.AbstractListModel<Jugador>() {
            public int getSize() {
                return listaJugadores.size();
            }

            public Jugador getElementAt(int i) {
                return apellidoNombre[i];
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbTorneos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartidosTorneo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bntAgendar = new javax.swing.JButton();
        btnLimpiarSeleccion = new javax.swing.JButton();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstJugadores = new javax.swing.JList<>();
        txtBuscarJugador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnJugador2 = new javax.swing.JButton();
        btnJugador1 = new javax.swing.JButton();
        cbEstadio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpHora = new javax.swing.JSpinner();

        setTitle("Configuracion de los Torneos");

        cbTorneos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTorneosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Torneo:");

        tblPartidosTorneo.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tblPartidosTorneo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Estadio", "Jugador 1", "Jugador 2", "Fecha/Hora Inicio", "Fecha/Hora Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPartidosTorneo);
        if (tblPartidosTorneo.getColumnModel().getColumnCount() > 0) {
            tblPartidosTorneo.getColumnModel().getColumn(0).setResizable(false);
            tblPartidosTorneo.getColumnModel().getColumn(1).setResizable(false);
            tblPartidosTorneo.getColumnModel().getColumn(2).setResizable(false);
            tblPartidosTorneo.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Partidos Programados para El torneo seleccionado (consideramos 3 horas de juego):");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección"));

        bntAgendar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntAgendar.setText("Agendar");
        bntAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgendarActionPerformed(evt);
            }
        });

        btnLimpiarSeleccion.setText("Limpiar Selección");
        btnLimpiarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSeleccionActionPerformed(evt);
            }
        });

        jDateFechaInicio.setDateFormatString("dd-MM-yyyy");
        jDateFechaInicio.setMinSelectableDate(new java.util.Date(1609473689000L));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha:");

        lstJugadores.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lstJugadores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstJugadoresValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstJugadores);

        txtBuscarJugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarJugadorKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Buscar Jugador:");

        btnJugador2.setText("Jugador 2");
        btnJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador2ActionPerformed(evt);
            }
        });

        btnJugador1.setText("Jugador 1");
        btnJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Estadio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Hora:");

        jSpHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jSpHora.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnLimpiarSeleccion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                            .addComponent(bntAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtBuscarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jSpHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntAgendar)
                    .addComponent(btnLimpiarSeleccion))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(101, 102, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador1ActionPerformed
        if (txtBuscarJugador.getText() != "" && lstJugadores.getSelectedValue() instanceof Jugador) {
            if (lstJugadores.getSelectedValue().getIdJugador() != idJugador2) {
                partido.setJugador1(lstJugadores.getSelectedValue());
                idJugador1 = lstJugadores.getSelectedValue().getIdJugador();
                btnJugador1.setText(lstJugadores.getSelectedValue().toString());
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un Jugador distinto al Jugador 2.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Jugador.");
        }
    }//GEN-LAST:event_btnJugador1ActionPerformed

    private void btnJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador2ActionPerformed
        if (txtBuscarJugador.getText() != "" && lstJugadores.getSelectedValue() instanceof Jugador) {
            if (lstJugadores.getSelectedValue().getIdJugador() != idJugador1) {
                partido.setJugador2(lstJugadores.getSelectedValue());
                idJugador2 = lstJugadores.getSelectedValue().getIdJugador();
    
                
                
                btnJugador2.setText(lstJugadores.getSelectedValue().toString());
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un Jugador distinto al Jugador 1.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Jugador.");
    }//GEN-LAST:event_btnJugador2ActionPerformed
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
          dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarJugadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarJugadorKeyReleased

        llenarListaJugadores(true);
    }//GEN-LAST:event_txtBuscarJugadorKeyReleased

    private void lstJugadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstJugadoresValueChanged

        try {
            if (!lstJugadores.isSelectionEmpty()) {
                txtBuscarJugador.setText(lstJugadores.getSelectedValue().toString());

            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la lista.");
        }
    }//GEN-LAST:event_lstJugadoresValueChanged

    private void limpiarSeleccion() {
        txtBuscarJugador.setText("");
//        partido.getJugador1().setIdJugador(0);
//        partido.getJugador2().setIdJugador(0);
        idJugador1=0;
        idJugador2=0;
        btnJugador1.setText("Jugador 1");
        btnJugador2.setText("Jugador 2");
        jDateFechaInicio.setDate(null);
        jSpHora.setValue(12);
    }


    private void btnLimpiarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSeleccionActionPerformed
        limpiarSeleccion();
    }//GEN-LAST:event_btnLimpiarSeleccionActionPerformed

    private boolean validar() {
        boolean validado = true;

        // verificamos Jugadores (hay que verificar que estos jugadores no esten en otro partido)
        if (btnJugador1.getText() != "Jugador 1" && idJugador1 != 0) {

        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar Jugador 1.");
            return false;
        }
        if (btnJugador2.getText() != "Jugador 2" && idJugador2 != 0) {

        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar Jugador 2.");
            return false;
        }

        // verificamos fecha y hora (hay que verificar que la fecha este dentro del rango del torneo
        // y que en esa cancha no se juegue en el mismo horario otro partido
        // por ahora solo vemos si han seleccionado una fecha
        if (jDateFechaInicio.getDate() != null) {
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar una fecha valida");
            return false;
        }

        return validado;
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }


    private void bntAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgendarActionPerformed
        
        
        
        
        if (validar()) {

            partido.setActivo(true);
            partido.setEstado("Programado");
            //partido.setFechaHora(convertToLocalDate(jDateFechaInicio.getDate()));

            Estadio est = (Estadio) cbEstadio.getSelectedItem();
            partido.setEstadio(est);

            Torneo tor = (Torneo) cbTorneos.getSelectedItem();
            partido.setTorneo(tor);

            
            partido.setJugadorGanador(jugadorGanador);
            partido.setResultado("");
            partido.setInstanciaTorneo("");

            LocalDate fechaInicio;
            fechaInicio = convertToLocalDate(jDateFechaInicio.getDate());
            LocalTime horaInicio;

            DecimalFormat formato = new DecimalFormat("00");
            String valorFormateado = formato.format(jSpHora.getValue());

            horaInicio = LocalTime.parse(valorFormateado + ":00");

            LocalDateTime fechaHora;
            fechaHora = LocalDateTime.of(fechaInicio, horaInicio);

            partido.setFechaHora(fechaHora);

            if (!partidoData.obtenerPartidoJugadoresFecha(partido).isEmpty()){
                JOptionPane.showMessageDialog(null, "Al menos uno de los Jugadores tiene partido agendado para este horario." + partido.getJugador1().getApellido() + "\n" + partido.getJugador2().getApellido() + "\n" + "Estadio: " + partido.getEstadio().getNumeroIdentificador() + "\n" + partido.getFechaHora());
            }else{
            
            if (!partidoData.obtenerPartidoEstadioFecha(partido).isEmpty()){
                JOptionPane.showMessageDialog(null, "El estadio está ocupado en ese horario." + partido.getJugador1().getApellido() + "\n" + partido.getJugador2().getApellido() + "\n" + "Estadio: " + partido.getEstadio().getNumeroIdentificador() + "\n" + partido.getFechaHora());
            }else{
            
            String confirmacion = "Torneo: " + cbTorneos.getSelectedItem().toString() + "\nEstadio: " + cbEstadio.getSelectedItem().toString() + "\nJugador 1: " + btnJugador1.getText() + "\nJugador 2: " + btnJugador2.getText() + "\nFecha Hora: " + fechaInicio + " " + jSpHora.getValue() + " hs.";

            if (JOptionPane.showConfirmDialog(null, confirmacion, "Confirma Registro?",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                registrarPartido(partido);

            }
            }
            }
            }

    }//GEN-LAST:event_bntAgendarActionPerformed

    private void cbTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTorneosActionPerformed
        llenarTablaDePartidos(cbTorneos.getSelectedItem().toString());
    }//GEN-LAST:event_cbTorneosActionPerformed

    private void registrarPartido(Partido partido) {

        if (partidoData.guardarPartidoInicial(partido)) {

            JOptionPane.showMessageDialog(null, "Partido registrado correctamente");
            limpiarSeleccion();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el partido correctamente");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAgendar;
    private javax.swing.JButton btnJugador1;
    private javax.swing.JButton btnJugador2;
    private javax.swing.JButton btnLimpiarSeleccion;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<Estadio> cbEstadio;
    private javax.swing.JComboBox<Torneo> cbTorneos;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpHora;
    private javax.swing.JList<Jugador> lstJugadores;
    private javax.swing.JTable tblPartidosTorneo;
    private javax.swing.JTextField txtBuscarJugador;
    // End of variables declaration//GEN-END:variables
}
