/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.EstadioData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Estadio;

/**
 *
 * @author FP
 */
public class ABMEstadio extends javax.swing.JInternalFrame {
    
       private EstadioData estadioData;
       private ArrayList<Estadio> listaEstadios = new ArrayList<>();
       private Estadio estadio;
        
    /**
     * Creates new form ABMEstadio
     */
    public ABMEstadio() {
        initComponents();
    }
    

    public ABMEstadio(EstadioData estadioData) {
        initComponents();
        this.estadioData = estadioData;
        listaEstadios = (ArrayList) estadioData.obtenerEstadio();
        limpiarCampos();    
        llenarListaEstadios(true);
        desactivarControles();
    }
        
    private void limpiarCampos(){
        rbtnActivos.setEnabled(true);
        rbtnInactivos.setEnabled(true);
        txtNumIdentif.setText("");
        txtCiudad.setText("");
        txtDireccion.setText("");
        txtLargo.setText("");
        txtAncho.setText("");
        txtBuscarEstadio.setText("");
        chkbActivo.setSelected(false);
        txtCantEspectadores.setText("");
        cbCategoria.setSelectedIndex(0);
        cbEstado.setSelectedIndex(0);
        btnAlta.setText("Alta");
        btnModificaciones.setText("Modificación");
        btnAlta.setEnabled(true);
    }
    
    private void llenarListaEstadios(Boolean activo){
    
        
        if (txtBuscarEstadio.getText() != "") {
            listaEstadios = (ArrayList) estadioData.obtenerEstadio(txtBuscarEstadio.getText());
        } else {
            listaEstadios = (ArrayList) estadioData.obtenerEstadio();
        }

        lstEstadio.removeAll();

        int largoLista = listaEstadios.size();
        
        Estadio[] numero = new Estadio[largoLista];
        int i = 0;

        for (Estadio estadio : listaEstadios) {
            if (estadio.isActivo() == activo) {
                numero[i] = estadio;
                i++;
            }
        }

        lstEstadio.setModel(new javax.swing.AbstractListModel<Estadio>() {
            public int getSize() {
                return listaEstadios.size();
            }

            public Estadio getElementAt(int i) {
                return numero[i];
            }
        });
    }
    
    private void desactivarControles(){
        btnBaja.setEnabled(false);
        btnModificaciones.setEnabled(false);
        txtNumIdentif.setEnabled(false);
        txtCiudad.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtAncho.setEnabled(false);
        txtLargo.setEnabled(false);
        cbCategoria.setEnabled(false);
        txtCantEspectadores.setEnabled(false);
        chkbActivo.setEnabled(false);
        cbEstado.setEnabled(false);
    }
    
    private void activarControles(){
        btnBaja.setEnabled(true);
        btnModificaciones.setEnabled(true);
        txtNumIdentif.setEnabled(true);
        txtCiudad.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtAncho.setEnabled(true);
        txtLargo.setEnabled(true);
        cbCategoria.setEnabled(true);
        txtCantEspectadores.setEnabled(true);
        chkbActivo.setEnabled(true);
        cbEstado.setEnabled(true);
    }
    
    private void llenarCampos(Estadio estadio) {
        
        txtNumIdentif.setText(String.valueOf(estadio.getNumeroIdentificador()));
        txtDireccion.setText(estadio.getDireccion());
        txtCiudad.setText(estadio.getCiudad());
        txtCantEspectadores.setText(String.valueOf(estadio.getCantidadEspectadores()));
        txtAncho.setText(String.valueOf(estadio.getAncho()));
        txtLargo.setText(String.valueOf(estadio.getLargo()));
        chkbActivo.setSelected(estadio.isActivo());
        cbCategoria.setSelectedItem(estadio.getCategoria());
        cbEstado.setSelectedIndex(estadio.getEstado());
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Activos = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jbtnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        chkbActivo = new javax.swing.JCheckBox();
        txtNumIdentif = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtLargo = new javax.swing.JTextField();
        txtAncho = new javax.swing.JTextField();
        txtCantEspectadores = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarEstadio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEstadio = new javax.swing.JList<>();
        rbtnActivos = new javax.swing.JRadioButton();
        rbtnInactivos = new javax.swing.JRadioButton();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnModificaciones = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox<>();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Altas/Bajas/Modificaciones Estadios");

        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Identificador:");

        jLabel3.setText("Ciudad:");

        jLabel4.setText("Dirección:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Largo:");

        jLabel7.setText("Ancho:");

        jLabel8.setText("Cantidad de Espectadores:");

        jLabel9.setText("Categoria:");

        chkbActivo.setText("Activo");

        txtNumIdentif.setNextFocusableComponent(txtCiudad);

        txtCiudad.setNextFocusableComponent(txtDireccion);

        txtDireccion.setNextFocusableComponent(txtLargo);

        txtLargo.setNextFocusableComponent(txtAncho);

        txtAncho.setNextFocusableComponent(txtCantEspectadores);

        txtCantEspectadores.setNextFocusableComponent(cbCategoria);

        cbEstado.setMaximumRowCount(20);
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desocupada", "Ocupada" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Buscar Estadio");

        txtBuscarEstadio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarEstadioKeyReleased(evt);
            }
        });

        lstEstadio.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEstadioValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEstadio);

        Activos.add(rbtnActivos);
        rbtnActivos.setSelected(true);
        rbtnActivos.setText("Activos");
        rbtnActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivosActionPerformed(evt);
            }
        });

        Activos.add(rbtnInactivos);
        rbtnInactivos.setText("Inactivos");
        rbtnInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInactivosActionPerformed(evt);
            }
        });

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

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cesped", "Ladrillo", "Cemento" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificaciones)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarCampos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(chkbActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumIdentif, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txtCiudad)
                    .addComponent(txtDireccion)
                    .addComponent(txtLargo)
                    .addComponent(txtAncho)
                    .addComponent(txtCantEspectadores)
                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarEstadio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnActivos)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnInactivos)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumIdentif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantEspectadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(chkbActivo)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnSalir)
                            .addComponent(btnAlta)
                            .addComponent(btnBaja)
                            .addComponent(btnModificaciones)
                            .addComponent(btnLimpiarCampos)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnActivos)
                            .addComponent(rbtnInactivos))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
      dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void lstEstadioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEstadioValueChanged
        try{
        if (!lstEstadio.isSelectionEmpty()) {
            txtBuscarEstadio.setText(lstEstadio.getSelectedValue().toString());
            desactivarControles();
            btnBaja.setEnabled(true);
            btnModificaciones.setEnabled(true);
            btnAlta.setEnabled(false);
            btnAlta.setText("Alta");
            btnModificaciones.setText("Modificación");
            llenarCampos(lstEstadio.getSelectedValue());
        }
         }catch(NullPointerException ex){
           JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la lista.");
         }
    }//GEN-LAST:event_lstEstadioValueChanged

    private void txtBuscarEstadioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEstadioKeyReleased
        if (txtBuscarEstadio.getText().isEmpty()){
        desactivarControles();
        btnAlta.setEnabled(true);
        }
        llenarListaEstadios(rbtnActivos.isSelected());
    }//GEN-LAST:event_txtBuscarEstadioKeyReleased

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
        desactivarControles();
        btnAlta.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnModificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificacionesActionPerformed
        if (btnModificaciones.getText() == "Modificación") {
            activarControles();
            rbtnActivos.setEnabled(false);
            rbtnInactivos.setEnabled(false);
        
            btnModificaciones.setText("Guardar Cambios");
        } else {
            if (validarCampos()) {
            int idEstadio = lstEstadio.getSelectedValue().getIdEstadio();
            int numeroIdentificador = Integer.valueOf(txtNumIdentif.getText());
            String ciudad = txtCiudad.getText();
            String direccion = txtDireccion.getText();
            int estado = Integer.valueOf(cbEstado.getSelectedIndex());
            double largo = Double.valueOf(txtLargo.getText());
            double ancho = Double.valueOf(txtAncho.getText());
            long cantidadEspectadores = Long.valueOf(txtCantEspectadores.getText());
            String Categoria = String.valueOf(cbCategoria.getSelectedItem().toString());
            boolean activo = chkbActivo.isSelected();
            estadio = new Estadio(idEstadio, numeroIdentificador, ciudad, direccion, estado,largo,ancho,cantidadEspectadores, Categoria, activo);

                
                if (estadioData.actualizarEstadio(estadio)) {
                    limpiarCampos();
                    desactivarControles();
                    btnAlta.setEnabled(true);
                    btnAlta.setText("Alta");
                    rbtnActivos.setSelected(true);
                    llenarListaEstadios(true);
                    JOptionPane.showMessageDialog(null, "Datos del Estadio Modificados.");
                } else {
                    txtNumIdentif.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btnModificacionesActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        estadio = armarEstadio();
        estadio.setActivo(false);
        estadioData.desactivarEstadio(estadio);

        limpiarCampos();
        desactivarControles();
        llenarListaEstadios(true);
        JOptionPane.showMessageDialog(null, " Estadio Dado de Baja");
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        if (btnAlta.getText() == "Alta") {
            limpiarCampos();
            activarControles();
            llenarListaEstadios(true);
            btnBaja.setEnabled(false);
            btnModificaciones.setEnabled(false);
            chkbActivo.setSelected(true);
            btnAlta.setText("Guardar");
            txtNumIdentif.requestFocus();
        } else {
            //Archivar
            if (validarCampos()) {
                

        
        int numeroIdentificador = Integer.valueOf(txtNumIdentif.getText());
        String ciudad = txtCiudad.getText();
        String direccion = txtDireccion.getText();
        String categoria = String.valueOf(cbCategoria.getSelectedItem().toString());
        double largo = Double.valueOf(txtLargo.getText());
        double ancho = Double.valueOf(txtAncho.getText());
        int estado = Integer.valueOf(cbEstado.getSelectedIndex());
        long cantidadEspectadores = Long.valueOf(txtCantEspectadores.getText());
        boolean activo = chkbActivo.isSelected();
        estadio = new Estadio(numeroIdentificador, ciudad,direccion, estado,largo,ancho,cantidadEspectadores, categoria, activo);
      
               
                if (estadioData.guardarEstadio(estadio)) {
                    limpiarCampos();
                    desactivarControles();
                    llenarListaEstadios(true);
                    btnAlta.setText("Alta");
                    JOptionPane.showMessageDialog(null, " Estadio Registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo cargar Estadio.");
                    txtNumIdentif.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btnAltaActionPerformed

    private void rbtnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivosActionPerformed
        limpiarCampos();
        listaEstadios = (ArrayList) estadioData.obtenerEstadio();
        if (rbtnActivos.isSelected()) {
            llenarListaEstadios(true);
        } else {
            llenarListaEstadios(false);
        }
    }//GEN-LAST:event_rbtnActivosActionPerformed

    private void rbtnInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInactivosActionPerformed
        limpiarCampos();
        listaEstadios = (ArrayList) estadioData.obtenerEstadio();
        if (rbtnActivos.isSelected()) {
            llenarListaEstadios(true);
        } else {
            llenarListaEstadios(false);
        }
    }//GEN-LAST:event_rbtnInactivosActionPerformed


    
    private Estadio armarEstadio(){
        int idEstadio = lstEstadio.getSelectedValue().getIdEstadio();
        int numeroIdentificador = Integer.valueOf(txtNumIdentif.getText());
        String ciudad = txtCiudad.getText();
        String direccion = txtDireccion.getText();
        int estado = Integer.valueOf(cbEstado.getSelectedIndex());
        double largo = Double.valueOf(txtLargo.getText());
        double ancho = Double.valueOf(txtAncho.getText());
        long cantidadEspectadores = Long.valueOf(txtCantEspectadores.getText());
        String categoria = String.valueOf(cbCategoria.getSelectedItem().toString());
        boolean activo = chkbActivo.isSelected();
        estadio = new Estadio(idEstadio, numeroIdentificador, ciudad, direccion, estado,largo,ancho,cantidadEspectadores, categoria, activo);
      
    
    return estadio;
    
    }
    
    private boolean validarCampos() {
        boolean validado = true;
        try {
            long cantidadEspectadores = Long.parseLong(txtCantEspectadores.getText());
            
            if (cantidadEspectadores < 2000 || cantidadEspectadores > 20000 ){
                JOptionPane.showMessageDialog(null, "El numero de espectadores debe ser mayor que 2000 y menor que 20000");
                validado = false;
            }
            
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Cantidad de Espectadores.");
            txtNumIdentif.requestFocus();
            validado = false;
        }
        
        try {
            double Ancho = Double.parseDouble(txtAncho.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Ancho.");
            txtAncho.requestFocus();
            validado = false;
        }
        
        try {
            double largo = Double.parseDouble(txtLargo.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Largo.");
            txtLargo.requestFocus();
            validado = false;
        }
        
        try {
            double numeroIdentificador = Integer.parseInt(txtNumIdentif.getText());
            
            if (numeroIdentificador < 1 || numeroIdentificador > 30 ){
                JOptionPane.showMessageDialog(null, "El numero identificador debe ser mayor que 0 y menor que 30");
                validado = false;
            }
            
            
            
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Numero Identificador.");
            txtNumIdentif.requestFocus();
            validado = false;
        }
        
        
        if (txtCantEspectadores.getText().isEmpty()
                || txtNumIdentif.getText().isEmpty()
                || txtAncho.getText().isEmpty()
                || txtLargo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los Campos deben estar llenos.");
            validado = false;
        }
        return validado;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Activos;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnModificaciones;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JCheckBox chkbActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JList<Estadio> lstEstadio;
    private javax.swing.JRadioButton rbtnActivos;
    private javax.swing.JRadioButton rbtnInactivos;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtBuscarEstadio;
    private javax.swing.JTextField txtCantEspectadores;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtNumIdentif;
    // End of variables declaration//GEN-END:variables
}
