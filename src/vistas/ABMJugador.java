/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.JugadorData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Jugador;

/**
 *
 * @author FP
 */
public class ABMJugador extends javax.swing.JInternalFrame {

    /**
     * Creates new form ABMJugador
     */
    
    JugadorData jugadorData;
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    Jugador jugador;
 
    
    public ABMJugador() {
        initComponents();
    }
    
    
    public ABMJugador(JugadorData jugadorData) {
        initComponents();
        this.jugadorData = jugadorData;
        
        listaJugadores = (ArrayList) jugadorData.obtenerJugador();
        limpiarCampos();    
        llenarListaJugadores(true);
        desactivarControles();
        
    }
    
    public void limpiarCampos()
        {rbtnActivos.setEnabled(true);
        rbtnInactivos.setEnabled(true);
//        rbtnActivos.setSelected(true);
        rbtnDiestro.setSelected(true);
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtAltura.setText("");
        txtPeso.setText("");
        txtBuscarJugador.setText("");
        chkbActivo.setSelected(false);
        jDateFechaNacimiento.setDate(new Date());
        cbEstilo.setSelectedIndex(0);
        btnAlta.setText("Alta");
        btnModificaciones.setText("Modificación");
        btnAlta.setEnabled(true);
    }
    
    public void llenarListaJugadores(Boolean activo){
    
        
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
    
    
    public void desactivarControles(){
         btnBaja.setEnabled(false);
        btnModificaciones.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtDni.setEnabled(false);
        txtAltura.setEnabled(false);
        txtPeso.setEnabled(false);
        jDateFechaNacimiento.setEnabled(false);
        chkbActivo.setEnabled(false);
        rbtnDiestro.setEnabled(false);
        rbtnZurdo.setEnabled(false);
        cbEstilo.setEnabled(false);
    }
    
    public void activarControles(){
        btnBaja.setEnabled(true);
        btnModificaciones.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtDni.setEnabled(true);
        txtAltura.setEnabled(true);
        txtPeso.setEnabled(true);
        txtBuscarJugador.setEnabled(true);
        jDateFechaNacimiento.setEnabled(true);
        chkbActivo.setEnabled(true);
        rbtnDiestro.setEnabled(true);
        rbtnZurdo.setEnabled(true);
        cbEstilo.setEnabled(true);
    }
    
    private void llenarCampos(Jugador jugador) {
        
        txtNombre.setText(jugador.getNombre());
        txtApellido.setText(jugador.getApellido());
        txtDni.setText(String.valueOf(jugador.getDni()));
        txtAltura.setText(String.valueOf(jugador.getAltura()));
        txtPeso.setText(String.valueOf(jugador.getPeso()));
        chkbActivo.setSelected(jugador.isActivo());
        rbtnDiestro.setSelected(jugador.isDiestro());
        rbtnZurdo.setSelected(!jugador.isDiestro());
        jDateFechaNacimiento.setDate(convertToDate(jugador.getFechaNacimiento()));
        cbEstilo.setSelectedItem(jugador.getEstilo());
        
    }
    
     public LocalDate convertToLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        bgroupDiestroZurdo = new javax.swing.ButtonGroup();
        bgroupActivos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jbtnSalir = new javax.swing.JButton();
        txtBuscarJugador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstJugadores = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        cbEstilo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chkbActivo = new javax.swing.JCheckBox();
        rbtnDiestro = new javax.swing.JRadioButton();
        rbtnZurdo = new javax.swing.JRadioButton();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnModificaciones = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rbtnActivos = new javax.swing.JRadioButton();
        rbtnInactivos = new javax.swing.JRadioButton();

        jButton1.setText("jButton1");

        setTitle("Alta/Baja/Modificaciones de Jugadores");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Altas/Bajas/Modificaciones Jugadores");

        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        txtBuscarJugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarJugadorKeyReleased(evt);
            }
        });

        lstJugadores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstJugadoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstJugadores);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Buscar Jugador");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("DNI:");

        cbEstilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agresivo", "Voleador", "De Toda la Cancha" }));

        jLabel6.setText("Fecha de Nacimiento: ");

        jLabel7.setText("Altura: ");

        jLabel8.setText("Peso:");

        jLabel9.setText("cm");

        jLabel10.setText("Kg");

        chkbActivo.setText("Activo");

        bgroupDiestroZurdo.add(rbtnDiestro);
        rbtnDiestro.setSelected(true);
        rbtnDiestro.setText("Diestro");

        bgroupDiestroZurdo.add(rbtnZurdo);
        rbtnZurdo.setText("Zurdo");

        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnModificaciones.setText("Modificaciones");
        btnModificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificacionesActionPerformed(evt);
            }
        });

        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        jLabel11.setText("Estilo:");

        bgroupActivos.add(rbtnActivos);
        rbtnActivos.setSelected(true);
        rbtnActivos.setText("Activos");
        rbtnActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivosActionPerformed(evt);
            }
        });

        bgroupActivos.add(rbtnInactivos);
        rbtnInactivos.setText("Inactivos");
        rbtnInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInactivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(144, 144, 144))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkbActivo)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel11))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbtnDiestro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtnZurdo)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtApellido)
                                    .addComponent(txtDni)
                                    .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbtnActivos)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rbtnInactivos))
                                        .addComponent(txtBuscarJugador)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbEstilo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addGap(202, 202, 202)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificaciones)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarCampos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSalir)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnDiestro)
                            .addComponent(rbtnZurdo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkbActivo)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnActivos)
                            .addComponent(rbtnInactivos))))
                .addGap(18, 18, 18)
                .addComponent(jbtnSalir)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlta)
                    .addComponent(btnBaja)
                    .addComponent(btnModificaciones)
                    .addComponent(btnLimpiarCampos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void lstJugadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstJugadoresValueChanged
          
        try{
        if (!lstJugadores.isSelectionEmpty()) {
            txtBuscarJugador.setText(lstJugadores.getSelectedValue().toString());
            desactivarControles();
            btnBaja.setEnabled(true);
            btnModificaciones.setEnabled(true);
            btnAlta.setEnabled(false);
            btnAlta.setText("Alta");
            btnModificaciones.setText("Modificación");
            llenarCampos(lstJugadores.getSelectedValue());
        }
         }catch(NullPointerException ex){
           JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la lista.");
         }
    }//GEN-LAST:event_lstJugadoresValueChanged

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
        desactivarControles();
        btnAlta.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private Jugador armarJugador(){
        int idJugador = lstJugadores.getSelectedValue().getIdJugador();
        long dni = Long.valueOf(txtDni.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        Date fechaNac = jDateFechaNacimiento.getDate();
        double altura = Double.valueOf(txtAltura.getText());
        double peso = Double.valueOf(txtPeso.getText());
        String estilo = cbEstilo.getSelectedItem().toString();
        boolean diestro = rbtnDiestro.isSelected();
        boolean activo = chkbActivo.isSelected();
        jugador = new Jugador(idJugador, nombre, apellido,dni, convertToLocalDate(fechaNac),altura,peso,estilo, diestro, activo);
      
    
    return jugador;
    
    }
    
    
    
    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        
        jugador = armarJugador();
        jugador.setActivo(false);
        jugadorData.desactivarJugador(jugador);

        limpiarCampos();
        desactivarControles();
        llenarListaJugadores(true);
        JOptionPane.showMessageDialog(null, " Jugador Dado de Baja");
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnModificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificacionesActionPerformed
         if (btnModificaciones.getText() == "Modificación") {
            activarControles();
            rbtnActivos.setEnabled(false);
            rbtnInactivos.setEnabled(false);
        
            btnModificaciones.setText("Guardar Cambios");
        } else {
            if (validarCampos()) {
                jugador = armarJugador();
                
                if (jugadorData.actualizarJugador(jugador)) {
                    limpiarCampos();
                    desactivarControles();
                    btnAlta.setEnabled(true);
                    btnAlta.setText("Alta");
                    rbtnActivos.setSelected(true);
                    llenarListaJugadores(true);
                    JOptionPane.showMessageDialog(null, "Datos del Jugador Modificados.");
                } else {
                    txtNombre.requestFocus();
                }
            }
        }

    }//GEN-LAST:event_btnModificacionesActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
     if (btnAlta.getText() == "Alta") {
            limpiarCampos();
            activarControles();
            llenarListaJugadores(true);
            btnBaja.setEnabled(false);
            btnModificaciones.setEnabled(false);
            chkbActivo.setSelected(true);
            btnAlta.setText("Guardar");
            txtNombre.requestFocus();
        } else {
            //Archivar
            if (validarCampos()) {
                btnAlta.setText("Alta");

        long dni = Long.valueOf(txtDni.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        Date fechaNac = jDateFechaNacimiento.getDate();
        double altura = Double.valueOf(txtAltura.getText());
        double peso = Double.valueOf(txtPeso.getText());
        String estilo = cbEstilo.getSelectedItem().toString();
        boolean diestro = rbtnDiestro.isSelected();
        boolean activo = chkbActivo.isSelected();
        jugador = new Jugador(nombre, apellido,dni, convertToLocalDate(fechaNac),altura,peso,estilo, diestro, activo);
      
               
                if (jugadorData.guardarJugador(jugador)) {
                    limpiarCampos();
                    desactivarControles();
                    llenarListaJugadores(true);
                    JOptionPane.showMessageDialog(null, " Jugador Registrado");
                } else {
                    txtNombre.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btnAltaActionPerformed

    private void txtBuscarJugadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarJugadorKeyReleased
           if (txtBuscarJugador.getText().isEmpty()){
        desactivarControles();
        btnAlta.setEnabled(true);
        
        
        }
        llenarListaJugadores(rbtnActivos.isSelected());
    }//GEN-LAST:event_txtBuscarJugadorKeyReleased

    
    
    private void rbtnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivosActionPerformed
          limpiarCampos();
        listaJugadores = (ArrayList) jugadorData.obtenerJugador();
        if (rbtnActivos.isSelected()) {
            llenarListaJugadores(true);
        } else {
            llenarListaJugadores(false);
        }
    }//GEN-LAST:event_rbtnActivosActionPerformed

    private void rbtnInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInactivosActionPerformed
        limpiarCampos();
        listaJugadores = (ArrayList) jugadorData.obtenerJugador();
        if (rbtnActivos.isSelected()) {
            llenarListaJugadores(true);
        } else {
            llenarListaJugadores(false);
        }
    }//GEN-LAST:event_rbtnInactivosActionPerformed

    private boolean validarCampos() {
        boolean validado = true;
        try {
            long modelo = Long.parseLong(txtDni.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo DNI.");
            txtDni.requestFocus();
            validado = false;
        }
        
        try {
            double modelo = Double.parseDouble(txtPeso.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Peso.");
            txtPeso.requestFocus();
            validado = false;
        }
        
        try {
            double modelo = Double.parseDouble(txtAltura.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Altura.");
            txtAltura.requestFocus();
            validado = false;
        }
        
        
        if (txtDni.getText().isEmpty()
                || txtNombre.getText().isEmpty()
                || txtApellido.getText().isEmpty()
                || txtAltura.getText().isEmpty()
                || txtPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los Campos deben estar llenos.");
            txtDni.requestFocus();
            validado = false;
        }
        return validado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroupActivos;
    private javax.swing.ButtonGroup bgroupDiestroZurdo;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnModificaciones;
    private javax.swing.JComboBox<String> cbEstilo;
    private javax.swing.JCheckBox chkbActivo;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JList<Jugador> lstJugadores;
    private javax.swing.JRadioButton rbtnActivos;
    private javax.swing.JRadioButton rbtnDiestro;
    private javax.swing.JRadioButton rbtnInactivos;
    private javax.swing.JRadioButton rbtnZurdo;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarJugador;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
