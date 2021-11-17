/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.EstadioData;
import control.JugadorData;
import control.PartidoData;
import control.TorneoData;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Estadio;
import modelo.Jugador;
import modelo.Partido;
import modelo.Torneo;

    
/**
 *
 * @author FP
 */
public class Resultados extends javax.swing.JInternalFrame {
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

    private int idJugador1 = 0;
    private int idJugador2 = 0;
    /**
     * Creates new form Resultados
     */
    public Resultados() {
        initComponents();
    }
    
    public Resultados(TorneoData torneoData, PartidoData partidoData, EstadioData estadioData, JugadorData jugadorData) {
        initComponents();
        
         this.torneoData = torneoData;
        this.partidoData = partidoData;
        this.estadioData = estadioData;
        this.jugadorData = jugadorData;
        
        partido = new Partido();
        jugadorGanador = new Jugador();
        listaJugadores = (ArrayList) jugadorData.obtenerJugador();

        
        llenarComboTorneos(true);
        if (cbTorneos.getItemCount()!=0) llenarTablaDePartidos(cbTorneos.getSelectedItem().toString());
        limpiarCampos();
        deshabilitarCampos();
        
        
    }

   private void llenarComboTorneos(Boolean activo) {

        listaTorneos = (ArrayList) torneoData.obtenerTodosLosTorneos();
        
        if (!listaTorneos.isEmpty()){
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
    }
    
   private void deshabilitarCampos(){
       btnRegistrar.setEnabled(false);
   cbJugadores.setEnabled(false);
   spnGanadorPrimerSet.setEnabled(false);
   spnPerdedorPrimerSet.setEnabled(false);
   spnGanadorSegundoSet.setEnabled(false);
   spnPerdedorSegundoSet.setEnabled(false);
   spnGanadorTercerSet.setEnabled(false);
   spnPerdedorTercerSet.setEnabled(false);
   cbInstancia.setEnabled(false);
   
   }
   private void habilitarCampos(){
       btnRegistrar.setEnabled(true);
   cbJugadores.setEnabled(true);
   spnGanadorPrimerSet.setEnabled(true);
   spnPerdedorPrimerSet.setEnabled(true);
   spnGanadorSegundoSet.setEnabled(true);
   spnPerdedorSegundoSet.setEnabled(true);
   spnGanadorTercerSet.setEnabled(true);
   spnPerdedorTercerSet.setEnabled(true);
   cbInstancia.setEnabled(true);
   }
   private void limpiarCampos(){
   
   cbJugadores.removeAllItems();
   spnGanadorPrimerSet.setValue(0);
   spnPerdedorPrimerSet.setValue(0);
   spnGanadorSegundoSet.setValue(0);
   spnPerdedorSegundoSet.setValue(0);
   spnGanadorTercerSet.setValue(0);
   spnPerdedorTercerSet.setValue(0);
   lblResultado.setText(obtenerResultado());
   
   
   }
    private void llenarTablaDePartidos(String nombreTorneo) {
        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
        model.setRowCount(0);
        String jugadorGanador="";
        String resultado="";
        String instanciaTorneo="";
        
        List<Partido> listaPartidos = partidoData.obtenerPartidoTorneo(nombreTorneo, 1);

        for (Partido partido : listaPartidos) {

            String estadoPartido = null;
            DecimalFormat formato = new DecimalFormat("00");
            LocalDateTime fechaHoraInicio = partido.getFechaHora();
            LocalDateTime fechaHoraFinalizacion = partido.getFechaHora().plusHours(3);
            LocalDateTime ahora = LocalDateTime.now();
            
            
            
            int antesDespuesInicio = fechaHoraInicio.compareTo(ahora);
            int antesDespuesFin = fechaHoraFinalizacion.compareTo(ahora);
            
            if (antesDespuesInicio>0 && antesDespuesFin>0){estadoPartido = "PROGRAMADO";}
            if (antesDespuesInicio<0 && antesDespuesFin<0){estadoPartido = "TERMINADO";}
            if (antesDespuesInicio<0 && antesDespuesFin>0){estadoPartido = "EN CURSO";}
            
            
            String fechaHora = formato.format(partido.getFechaHora().getDayOfMonth()) + "-" + formato.format(partido.getFechaHora().getMonthValue()) + "-" + partido.getFechaHora().getYear() + " " + partido.getFechaHora().getHour() + ":00 hs.";
            String fechaHoraFin = formato.format(fechaHoraFinalizacion.getDayOfMonth()) + "-" + formato.format(fechaHoraFinalizacion.getMonthValue()) + "-" + fechaHoraFinalizacion.getYear() + " " + fechaHoraFinalizacion.getHour() + ":00 hs.";

            if (partido.getJugadorGanador()== null){
               
                jugadorGanador = "";
            }else{
                jugadorGanador = partido.getJugadorGanador().toString();
            }
            
            if (partido.getResultado() == null){
                resultado = "";
            }else{
                resultado = partido.getResultado();
            }
            
            if (partido.getInstanciaTorneo()== null){
                instanciaTorneo = "";
            }else{
                instanciaTorneo = partido.getInstanciaTorneo();
            }
            
            
            //model.addRow(new Object[]{partido.getIdPartido(),"Estadio " + partido.getEstadio().getNumeroIdentificador(), partido.getJugador1().getApellido() + ", " + partido.getJugador1().getNombre(), partido.getJugador2().getApellido() + ", " + partido.getJugador2().getNombre(), fechaHora, estadoPartido, partido.getJugadorGanador().getApellido() + ", " + partido.getJugadorGanador().getNombre(), partido.getResultado(),partido.getInstanciaTorneo()});
            model.addRow(new Object[]{partido.getIdPartido(),"Estadio " + partido.getEstadio().getNumeroIdentificador(), partido.getJugador1().getApellido() + ", " + partido.getJugador1().getNombre(), partido.getJugador2().getApellido() + ", " + partido.getJugador2().getNombre(), fechaHora, estadoPartido, jugadorGanador, resultado, instanciaTorneo });
                        
        }
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
        tblResultados = new javax.swing.JTable();
        cbJugadores = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbInstancia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnGanadorPrimerSet = new javax.swing.JSpinner();
        spnPerdedorPrimerSet = new javax.swing.JSpinner();
        spnGanadorSegundoSet = new javax.swing.JSpinner();
        spnPerdedorSegundoSet = new javax.swing.JSpinner();
        spnGanadorTercerSet = new javax.swing.JSpinner();
        spnPerdedorTercerSet = new javax.swing.JSpinner();
        lblResultado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Resultados");

        cbTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTorneosActionPerformed(evt);
            }
        });

        jLabel1.setText("Torneo:");

        tblResultados.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Part", "Estadio", "Jugador 1", "Jugador 2", "Fecha Inicio", "Estado", "Ganador", "Resultado", "Instancia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        jLabel2.setText("Jugador Ganador:");

        cbInstancia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Qualy", "Octavos de Final", "Cuartos de Final", "Semi Final", "Final" }));

        jLabel3.setText("Instancia:");

        jLabel4.setText("1er. Set");

        spnGanadorPrimerSet.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));
        spnGanadorPrimerSet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnGanadorPrimerSetStateChanged(evt);
            }
        });

        spnPerdedorPrimerSet.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));
        spnPerdedorPrimerSet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPerdedorPrimerSetStateChanged(evt);
            }
        });

        spnGanadorSegundoSet.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));
        spnGanadorSegundoSet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnGanadorSegundoSetStateChanged(evt);
            }
        });

        spnPerdedorSegundoSet.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));
        spnPerdedorSegundoSet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPerdedorSegundoSetStateChanged(evt);
            }
        });

        spnGanadorTercerSet.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));
        spnGanadorTercerSet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnGanadorTercerSetStateChanged(evt);
            }
        });

        spnPerdedorTercerSet.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));
        spnPerdedorTercerSet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPerdedorTercerSetStateChanged(evt);
            }
        });

        lblResultado.setText("Resultado:");

        jLabel6.setText("2do. Set");

        jLabel7.setText("3er. Set");

        jLabel8.setText("* todos los set son cortos (tie break)");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Resultados de los Partidos");

        jLabel5.setText("Resultado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(56, 56, 56)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(spnGanadorSegundoSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(spnGanadorPrimerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(spnGanadorTercerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(spnPerdedorSegundoSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel6))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(spnPerdedorTercerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel7))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(spnPerdedorPrimerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel4))))
                                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblResultado)
                                                    .addGap(30, 30, 30))))))))
                        .addGap(0, 233, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(274, 274, 274))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spnGanadorPrimerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPerdedorPrimerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnGanadorSegundoSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPerdedorSegundoSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnGanadorTercerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPerdedorTercerSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultado)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnRegistrar)
                    .addComponent(btnLimpiarCampos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
        deshabilitarCampos();

    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private String obtenerResultado(){
    
        
        String resultado = "0/0 0/0 0/0";
        resultado = spnGanadorPrimerSet.getValue() + "/" + spnPerdedorPrimerSet.getValue() + " " + spnGanadorSegundoSet.getValue() + "/" + spnPerdedorSegundoSet.getValue() + " " + spnGanadorTercerSet.getValue() + "/" + spnPerdedorTercerSet.getValue(); 
        
        return resultado;
    }
    
    private void tblResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseClicked
                
        
        try{
        int filaSeleccionada = tblResultados.getSelectedRow();
        if (tblResultados.getRowCount()!= 0 && tblResultados.getValueAt(filaSeleccionada, 0)!= null){    

          String estado = ((String) tblResultados.getValueAt(filaSeleccionada, 5));
          int idPartido = ((Integer) tblResultados.getValueAt(filaSeleccionada, 0));
          
          if (estado != "TERMINADO"){
              JOptionPane.showMessageDialog(null, "Sólo pueden cargar resultados de partidos que esten TERMINADOS, no se pueden cargar resultados de partidos PROGRAMADOS o EN CURSO");
              
          }else{
              
              limpiarCampos();
              cbJugadores.addItem(jugadorData.buscarJugador(partidoData.buscarPartido(idPartido).getJugador1().getIdJugador()));
              cbJugadores.addItem(jugadorData.buscarJugador(partidoData.buscarPartido(idPartido).getJugador2().getIdJugador()));
              lblResultado.setText(obtenerResultado());
              
           Date hoy = new Date();
           habilitarCampos();
          
                }
            }
        
         }catch(ArrayIndexOutOfBoundsException ex){
           JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la tabla.");
         }
          
        
    }//GEN-LAST:event_tblResultadosMouseClicked

    private void cbTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTorneosActionPerformed
         llenarTablaDePartidos(cbTorneos.getSelectedItem().toString());
        limpiarCampos();
        deshabilitarCampos();
    }//GEN-LAST:event_cbTorneosActionPerformed

    private void spnGanadorPrimerSetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnGanadorPrimerSetStateChanged
        lblResultado.setText(obtenerResultado());
    }//GEN-LAST:event_spnGanadorPrimerSetStateChanged

    private void spnPerdedorPrimerSetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPerdedorPrimerSetStateChanged
        lblResultado.setText(obtenerResultado());
    }//GEN-LAST:event_spnPerdedorPrimerSetStateChanged

    private void spnGanadorSegundoSetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnGanadorSegundoSetStateChanged
        lblResultado.setText(obtenerResultado());
    }//GEN-LAST:event_spnGanadorSegundoSetStateChanged

    private void spnPerdedorSegundoSetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPerdedorSegundoSetStateChanged
        lblResultado.setText(obtenerResultado());
    }//GEN-LAST:event_spnPerdedorSegundoSetStateChanged

    private void spnGanadorTercerSetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnGanadorTercerSetStateChanged
         lblResultado.setText(obtenerResultado());
    }//GEN-LAST:event_spnGanadorTercerSetStateChanged

    private void spnPerdedorTercerSetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPerdedorTercerSetStateChanged
         lblResultado.setText(obtenerResultado());
    }//GEN-LAST:event_spnPerdedorTercerSetStateChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int filaSeleccionada = tblResultados.getSelectedRow();
        int idPartido = ((Integer) tblResultados.getValueAt(filaSeleccionada, 0));
        
        Partido partidoResultado= new Partido();
        
        partidoResultado = partidoData.buscarPartido(idPartido);
        
        partidoResultado.setJugadorGanador((Jugador) cbJugadores.getSelectedItem());
        partidoResultado.setResultado(lblResultado.getText());
        partidoResultado.setInstanciaTorneo((String) cbInstancia.getSelectedItem());
        
        if (partidoData.actualizarPartido(partidoResultado)){
           JOptionPane.showMessageDialog(null, "Los Resultados del partido se actualizaron correctamente.");
        llenarTablaDePartidos(cbTorneos.getSelectedItem().toString());
        limpiarCampos();
        deshabilitarCampos();
        
        }else{
           JOptionPane.showMessageDialog(null, "No se pudo actualizar correctamente el resultado del partido.");
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbInstancia;
    private javax.swing.JComboBox<Jugador> cbJugadores;
    private javax.swing.JComboBox<Torneo> cbTorneos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JSpinner spnGanadorPrimerSet;
    private javax.swing.JSpinner spnGanadorSegundoSet;
    private javax.swing.JSpinner spnGanadorTercerSet;
    private javax.swing.JSpinner spnPerdedorPrimerSet;
    private javax.swing.JSpinner spnPerdedorSegundoSet;
    private javax.swing.JSpinner spnPerdedorTercerSet;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables
}
