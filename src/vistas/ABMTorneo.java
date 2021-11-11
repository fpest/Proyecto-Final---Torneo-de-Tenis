
package vistas;

import control.TorneoData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Torneo;


public class ABMTorneo extends javax.swing.JInternalFrame {

    TorneoData torneoData;
    ArrayList<Torneo> listaTorneos = new ArrayList<>();
    Torneo torneo;
   
    public ABMTorneo() {
        initComponents();
    }
    
    public ABMTorneo(TorneoData torneoData) {
        initComponents();
        this.torneoData = torneoData;

        listaTorneos = (ArrayList) torneoData.obtenerTodosLosTorneos();
        limpiarCampos();
        llenarListaTorneos(true);
        desactivarControles();
    }
    
    public void limpiarCampos() {
        rbtnActivos.setEnabled(true);
        rbtnInactivos.setEnabled(true);
        txtNombre.setText("");
        txtBuscarTorneo.setText("");
        chkbActivoT.setSelected(false);
        jDateFechaInicio.setDate(new Date());
        jDateFechaFin.setDate(new Date());
        btnAltaT.setText("Alta");
        btnModificacionesT.setText("Modificación");
        btnAltaT.setEnabled(true);
    }

    public void llenarListaTorneos(Boolean activo) {

        if (!"".equals(txtBuscarTorneo.getText())) {
            listaTorneos = (ArrayList) torneoData.obtenerTorneos(txtBuscarTorneo.getText());
        } else {
            listaTorneos = (ArrayList) torneoData.obtenerTodosLosTorneos();
        }

        lstTorneos.removeAll();

        int largoLista = listaTorneos.size();
        //    String[] nombre = new String[largoLista];
        Torneo[] nombre = new Torneo[largoLista];
        int i = 0;

        for (Torneo t : listaTorneos) {
            if (t.isActivo() == activo) {
                nombre[i] = t;
                i++;
            }
        }

        lstTorneos.setModel(new javax.swing.AbstractListModel<Torneo>() {
            @Override
            public int getSize() {
                return listaTorneos.size();
            }

            @Override
            public Torneo getElementAt(int i) {
                return nombre[i];
            }
        });
    }

    public void desactivarControles() {
        btnBajaT.setEnabled(false);
        btnModificacionesT.setEnabled(false);
        txtNombre.setEnabled(false);
        jDateFechaInicio.setEnabled(false);
        jDateFechaFin.setEnabled(false);
        chkbActivoT.setEnabled(false);
    }

    public void activarControles() {
        btnBajaT.setEnabled(true);
        btnModificacionesT.setEnabled(true);
        txtNombre.setEnabled(true);
        txtBuscarTorneo.setEnabled(true);
        jDateFechaInicio.setEnabled(true);
        jDateFechaFin.setEnabled(true);
        chkbActivoT.setEnabled(false);
    }

    private void llenarCampos(Torneo torneo) {

        txtNombre.setText(torneo.getNombre());
        jDateFechaInicio.setDate(convertToDate(torneo.getFechaIn()));
        jDateFechaFin.setDate(convertToDate(torneo.getFechaFn()));
        chkbActivoT.setSelected(torneo.isActivo());

    }

    private boolean validarCampos() {
        boolean validado = true;

        if (txtNombre.getText().isEmpty()
                || jDateFechaInicio.getDate() == null
                || jDateFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Todos los Campos deben estar llenos.");
            txtNombre.requestFocus();
            validado = false;
        }
        if (jDateFechaFin.getDate().before(jDateFechaInicio.getDate())){
            JOptionPane.showMessageDialog(null, "Las fechas deben ser correctas.");
            txtNombre.requestFocus();
            validado = false;
        }
        return validado;
    }

    private Torneo armarTorneo() {
        int idTorneo = lstTorneos.getSelectedValue().getIdTorneo();
        String nombre = txtNombre.getText();
        Date fechaIn = jDateFechaInicio.getDate();
        Date fechaFn = jDateFechaFin.getDate();
        boolean activo = chkbActivoT.isSelected();
        torneo = new Torneo(idTorneo, nombre, convertToLocalDate(fechaIn), convertToLocalDate(fechaFn), activo);

        return torneo;
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupActivosInactivos = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarTorneo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTorneos = new javax.swing.JList<>();
        rbtnInactivos = new javax.swing.JRadioButton();
        rbtnActivos = new javax.swing.JRadioButton();
        btnSalir = new javax.swing.JButton();
        chkbActivoT = new javax.swing.JCheckBox();
        jDateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiarCamposT = new javax.swing.JButton();
        btnModificacionesT = new javax.swing.JButton();
        btnBajaT = new javax.swing.JButton();
        btnAltaT = new javax.swing.JButton();

        setClosable(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Altas/Bajas/Modificaciones Torneos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Buscar Torneo");

        txtBuscarTorneo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarTorneoKeyReleased(evt);
            }
        });

        lstTorneos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTorneosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstTorneos);

        btnGroupActivosInactivos.add(rbtnInactivos);
        rbtnInactivos.setText("Inactivos");
        rbtnInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInactivosActionPerformed(evt);
            }
        });

        btnGroupActivosInactivos.add(rbtnActivos);
        rbtnActivos.setSelected(true);
        rbtnActivos.setText("Activos");
        rbtnActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivosActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        chkbActivoT.setText("Activo");

        jLabel7.setText("Fecha de Fin: ");

        jLabel6.setText("Fecha de Inicio: ");

        jLabel3.setText("Nombre:");

        btnLimpiarCamposT.setText("Limpiar Campos");
        btnLimpiarCamposT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposTActionPerformed(evt);
            }
        });

        btnModificacionesT.setText("Modificaciones");
        btnModificacionesT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificacionesTActionPerformed(evt);
            }
        });

        btnBajaT.setText("Baja");
        btnBajaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaTActionPerformed(evt);
            }
        });

        btnAltaT.setText("Alta");
        btnAltaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAltaT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBajaT))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnLimpiarCamposT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkbActivoT)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre)
                                .addComponent(jDateFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificacionesT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalir)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBuscarTorneo)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnActivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnInactivos)))))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkbActivoT)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAltaT)
                            .addComponent(btnBajaT)
                            .addComponent(btnModificacionesT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarCamposT))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnActivos)
                            .addComponent(rbtnInactivos))))
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarTorneoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTorneoKeyReleased
        if (txtBuscarTorneo.getText().isEmpty()) {
            desactivarControles();
            btnAltaT.setEnabled(true);

        }
        llenarListaTorneos(rbtnActivos.isSelected());
    }//GEN-LAST:event_txtBuscarTorneoKeyReleased

    private void lstTorneosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTorneosValueChanged

        try {
            if (!lstTorneos.isSelectionEmpty()) {
                txtBuscarTorneo.setText(lstTorneos.getSelectedValue().toString());
                desactivarControles();
                btnBajaT.setEnabled(true);
                btnModificacionesT.setEnabled(true);
                btnAltaT.setEnabled(false);
                btnAltaT.setText("Alta");
                btnModificacionesT.setText("Modificación");
                llenarCampos(lstTorneos.getSelectedValue());
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la lista.");
        }
    }//GEN-LAST:event_lstTorneosValueChanged

    private void rbtnInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInactivosActionPerformed
        limpiarCampos();
        listaTorneos = (ArrayList) torneoData.obtenerTodosLosTorneos();
        if (rbtnActivos.isSelected()) {
            llenarListaTorneos(true);
        } else {
            llenarListaTorneos(false);
        }
    }//GEN-LAST:event_rbtnInactivosActionPerformed

    private void rbtnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivosActionPerformed
        limpiarCampos();
        listaTorneos = (ArrayList) torneoData.obtenerTodosLosTorneos();
        if (rbtnActivos.isSelected()) {
            llenarListaTorneos(true);
        } else {
            llenarListaTorneos(false);
        }
    }//GEN-LAST:event_rbtnActivosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAltaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaTActionPerformed
        if ("Alta".equals(btnAltaT.getText())) {
            limpiarCampos();
            activarControles();
            llenarListaTorneos(true);
            btnBajaT.setEnabled(false);
            btnModificacionesT.setEnabled(false);
            chkbActivoT.setSelected(true);
            btnAltaT.setText("Guardar");
            txtNombre.requestFocus();
        } else {
            //Archivar
            if (validarCampos()) {
                btnAltaT.setText("Alta");

                String nombre = txtNombre.getText();
                Date fechaIn = jDateFechaInicio.getDate();
                Date fechaFn = jDateFechaFin.getDate();
                boolean activo = chkbActivoT.isSelected();
                torneo = new Torneo(nombre, convertToLocalDate(fechaIn), convertToLocalDate(fechaFn),activo);

                if (torneoData.guardarTorneo(torneo)) {
                    limpiarCampos();
                    desactivarControles();
                    llenarListaTorneos(true);
                    JOptionPane.showMessageDialog(null, "Torneo Registrado");
                } else {
                    txtNombre.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btnAltaTActionPerformed

    private void btnBajaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaTActionPerformed
        torneo = armarTorneo();
        torneo.setActivo(false);
        torneoData.desactivarTorneo(torneo);

        limpiarCampos();
        desactivarControles();
        llenarListaTorneos(true);
        JOptionPane.showMessageDialog(null, "Torneo Dado de Baja");
    }//GEN-LAST:event_btnBajaTActionPerformed

    private void btnModificacionesTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificacionesTActionPerformed
        if ("Modificación".equals(btnModificacionesT.getText())) {
            activarControles();
            chkbActivoT.setEnabled(true);
            rbtnActivos.setEnabled(false);
            rbtnInactivos.setEnabled(false);

            btnModificacionesT.setText("Guardar Cambios");
        } else {
            if (validarCampos()) {
                torneo = armarTorneo();

                if (torneoData.actualizarTorneo(torneo)) {
                    limpiarCampos();
                    desactivarControles();
                    btnAltaT.setEnabled(true);
                    btnAltaT.setText("Alta");
                    rbtnActivos.setSelected(true);
                    llenarListaTorneos(true);
                    JOptionPane.showMessageDialog(null, "Datos del Torneo Modificados.");
                } else {
                    txtNombre.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btnModificacionesTActionPerformed

    private void btnLimpiarCamposTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposTActionPerformed
        limpiarCampos();
        desactivarControles();
        btnAltaT.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarCamposTActionPerformed

                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaT;
    private javax.swing.JButton btnBajaT;
    private javax.swing.ButtonGroup btnGroupActivosInactivos;
    private javax.swing.JButton btnLimpiarCamposT;
    private javax.swing.JButton btnModificacionesT;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkbActivoT;
    private com.toedter.calendar.JDateChooser jDateFechaFin;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Torneo> lstTorneos;
    private javax.swing.JRadioButton rbtnActivos;
    private javax.swing.JRadioButton rbtnInactivos;
    private javax.swing.JTextField txtBuscarTorneo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
