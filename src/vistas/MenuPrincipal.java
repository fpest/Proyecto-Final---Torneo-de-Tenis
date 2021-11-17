/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;

/**
 *
 * @author FP
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMnABMVarios = new javax.swing.JMenu();
        jMnJugador = new javax.swing.JMenuItem();
        jMnEstadio = new javax.swing.JMenuItem();
        jMnTorneo = new javax.swing.JMenuItem();
        jMnPatrocinador = new javax.swing.JMenuItem();
        jMnConfTorneo = new javax.swing.JMenu();
        jMnPatrocinios = new javax.swing.JMenu();
        jMnContratos = new javax.swing.JMenuItem();
        jMnResultado = new javax.swing.JMenu();
        jMnRanking = new javax.swing.JMenu();
        jMnInformes = new javax.swing.JMenu();
        jMnJugadoresTorneo = new javax.swing.JMenuItem();
        jMnTorneosJugador = new javax.swing.JMenuItem();
        jMnSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jMnABMVarios.setText("ABM Varios");

        jMnJugador.setText("Jugador");
        jMnJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnJugadorActionPerformed(evt);
            }
        });
        jMnABMVarios.add(jMnJugador);

        jMnEstadio.setText("Estadio");
        jMnEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnEstadioActionPerformed(evt);
            }
        });
        jMnABMVarios.add(jMnEstadio);

        jMnTorneo.setText("Torneo");
        jMnTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnTorneoActionPerformed(evt);
            }
        });
        jMnABMVarios.add(jMnTorneo);

        jMnPatrocinador.setText("Patrocinador");
        jMnPatrocinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnPatrocinadorActionPerformed(evt);
            }
        });
        jMnABMVarios.add(jMnPatrocinador);

        jMenuBar1.add(jMnABMVarios);

        jMnConfTorneo.setText("Conf. Torneo");
        jMnConfTorneo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnConfTorneoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMnConfTorneo);

        jMnPatrocinios.setText("Patrocinios");

        jMnContratos.setText("Contratos");
        jMnContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnContratosActionPerformed(evt);
            }
        });
        jMnPatrocinios.add(jMnContratos);

        jMenuBar1.add(jMnPatrocinios);

        jMnResultado.setText("Resultado");
        jMnResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnResultadoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMnResultado);

        jMnRanking.setText("Ranking");
        jMnRanking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnRankingMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMnRanking);

        jMnInformes.setText("Informes");
        jMnInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnInformesActionPerformed(evt);
            }
        });

        jMnJugadoresTorneo.setText("Jugadores x Torneo");
        jMnJugadoresTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnJugadoresTorneoActionPerformed(evt);
            }
        });
        jMnInformes.add(jMnJugadoresTorneo);

        jMnTorneosJugador.setText("Torneos x Jugador");
        jMnTorneosJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnTorneosJugadorActionPerformed(evt);
            }
        });
        jMnInformes.add(jMnTorneosJugador);

        jMenuBar1.add(jMnInformes);

        jMnSalir.setText("Salir");
        jMnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnSalirMouseClicked(evt);
            }
        });
        jMnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMnSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnJugadorActionPerformed
          
        try {
            Conexion conexion = new Conexion();
            JugadorData jugadorData = new JugadorData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            ABMJugador aj = new ABMJugador(jugadorData);
            aj.setVisible(true);
            escritorio.add(aj);
            escritorio.moveToFront(aj);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ABMJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMnJugadorActionPerformed

    private void jMnEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnEstadioActionPerformed
           try {
            Conexion conexion = new Conexion();
            EstadioData estadioData = new EstadioData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            ABMEstadio aj = new ABMEstadio(estadioData);
            aj.setVisible(true);
            escritorio.add(aj);
            escritorio.moveToFront(aj);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ABMEstadio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMnEstadioActionPerformed

    private void jMnTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnTorneoActionPerformed
        try {
            Conexion conexion = new Conexion();
            TorneoData torneoData = new TorneoData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            ABMTorneo at = new ABMTorneo(torneoData);
            at.setVisible(true);
            escritorio.add(at);
            escritorio.moveToFront(at);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ABMTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMnTorneoActionPerformed

    private void jMnPatrocinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnPatrocinadorActionPerformed
           try {
            Conexion conexion = new Conexion();
            PatrocinadorData patrocinadorData = new PatrocinadorData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            ABMPatrocinador at = new ABMPatrocinador(patrocinadorData);
            at.setVisible(true);
            escritorio.add(at);
            escritorio.moveToFront(at);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ABMPatrocinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMnPatrocinadorActionPerformed

    private void jMnConfTorneoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnConfTorneoMouseClicked
           try {
            Conexion conexion = new Conexion();
            TorneoData torneoData = new TorneoData(conexion);
            PartidoData partidoData = new PartidoData(conexion);
            EstadioData estadioData = new EstadioData(conexion);
            JugadorData jugadorData = new JugadorData(conexion);
            
            escritorio.removeAll();
            escritorio.repaint();
            ConfTorneo ct = new ConfTorneo(torneoData, partidoData, estadioData, jugadorData);
            ct.setVisible(true);
            escritorio.add(ct);
            escritorio.moveToFront(ct);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMnConfTorneoMouseClicked

    private void jMnContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnContratosActionPerformed
              try {
            Conexion conexion = new Conexion();
            PatrocinioData patrocinioData = new PatrocinioData(conexion);
            JugadorData jugadorData = new JugadorData(conexion);
            PatrocinadorData patrocinadorData = new PatrocinadorData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            ABMPatrocinio ap = new ABMPatrocinio(patrocinioData, jugadorData, patrocinadorData);
            ap.setVisible(true);
            escritorio.add(ap);
            escritorio.moveToFront(ap);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ABMPatrocinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMnContratosActionPerformed

    private void jMnResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnResultadoMouseClicked
                   try {
            Conexion conexion = new Conexion();
            TorneoData torneoData = new TorneoData(conexion);
            PartidoData partidoData = new PartidoData(conexion);
            EstadioData estadioData = new EstadioData(conexion);
            JugadorData jugadorData = new JugadorData(conexion);
            
            escritorio.removeAll();
            escritorio.repaint();
            Resultados res = new Resultados(torneoData, partidoData, estadioData, jugadorData);
            res.setVisible(true);
            escritorio.add(res);
            escritorio.moveToFront(res);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jMnResultadoMouseClicked

    private void jMnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnSalirActionPerformed

    }//GEN-LAST:event_jMnSalirActionPerformed

    private void jMnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMnSalirMouseClicked

    private void jMnRankingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnRankingMouseClicked

                   try {
            Conexion conexion = new Conexion();
            TorneoData torneoData = new TorneoData(conexion);
            PartidoData partidoData = new PartidoData(conexion);
           // EstadioData estadioData = new EstadioData(conexion);
            JugadorData jugadorData = new JugadorData(conexion);
            PatrocinioData patrocinioData = new PatrocinioData(conexion);
            
            escritorio.removeAll();
            escritorio.repaint();
            Ranking res = new Ranking(torneoData, partidoData, patrocinioData, jugadorData);
            res.setVisible(true);
            escritorio.add(res);
            escritorio.moveToFront(res);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        



    }//GEN-LAST:event_jMnRankingMouseClicked

    private void jMnInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnInformesActionPerformed
        
    }//GEN-LAST:event_jMnInformesActionPerformed

    private void jMnJugadoresTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnJugadoresTorneoActionPerformed
           try {
            Conexion conexion = new Conexion();
            TorneoData torneoData = new TorneoData(conexion);
            PartidoData partidoData = new PartidoData(conexion);
            JugadorData jugadorData = new JugadorData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            ListarJugadoresPorTorneo ljt = new ListarJugadoresPorTorneo(torneoData, partidoData, jugadorData);
            ljt.setVisible(true);
            escritorio.add(ljt);
            escritorio.moveToFront(ljt);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMnJugadoresTorneoActionPerformed

    private void jMnTorneosJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnTorneosJugadorActionPerformed
       try {
            Conexion conexion = new Conexion();
            TorneoData torneoData = new TorneoData(conexion);
            PartidoData partidoData = new PartidoData(conexion);
            JugadorData jugadorData = new JugadorData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            ListarTorneosPorJugador ltj = new ListarTorneosPorJugador(torneoData, partidoData, jugadorData);
            ltj.setVisible(true);
            escritorio.add(ltj);
            escritorio.moveToFront(ltj);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMnTorneosJugadorActionPerformed

    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMnABMVarios;
    private javax.swing.JMenu jMnConfTorneo;
    private javax.swing.JMenuItem jMnContratos;
    private javax.swing.JMenuItem jMnEstadio;
    private javax.swing.JMenu jMnInformes;
    private javax.swing.JMenuItem jMnJugador;
    private javax.swing.JMenuItem jMnJugadoresTorneo;
    private javax.swing.JMenuItem jMnPatrocinador;
    private javax.swing.JMenu jMnPatrocinios;
    private javax.swing.JMenu jMnRanking;
    private javax.swing.JMenu jMnResultado;
    private javax.swing.JMenu jMnSalir;
    private javax.swing.JMenuItem jMnTorneo;
    private javax.swing.JMenuItem jMnTorneosJugador;
    // End of variables declaration//GEN-END:variables
}