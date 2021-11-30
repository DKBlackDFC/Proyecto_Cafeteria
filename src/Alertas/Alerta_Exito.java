/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alertas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author DIEGO
 */
public class Alerta_Exito extends javax.swing.JDialog {

    public Alerta_Exito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setMoverVentana(this);
    }
    
    private void addEventKey() {
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        Action enterAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enter, "ENTER");
        getRootPane().getActionMap().put("ENTER", enterAction);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.rspanel.RSPanelShadow();
        JPNL_Fondo = new javax.swing.JPanel();
        JLBL_Mensaje1 = new javax.swing.JLabel();
        JLBL_Mensaje2 = new javax.swing.JLabel();
        JLBL_Mensaje3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JLBL_Titulo = new javax.swing.JLabel();
        JBTN_Salir = new rojeru_san.rsbutton.RSButtonRoundEffect();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        JPNL_Fondo.setBackground(new java.awt.Color(0, 126, 51));
        JPNL_Fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 126, 51), 10));

        JLBL_Mensaje1.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        JLBL_Mensaje1.setForeground(new java.awt.Color(255, 255, 255));
        JLBL_Mensaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Mensaje1.setText("Aqui  va un mensaje");

        JLBL_Mensaje2.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        JLBL_Mensaje2.setForeground(new java.awt.Color(255, 255, 255));
        JLBL_Mensaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Mensaje2.setText("Aqui  va un mensaje");

        JLBL_Mensaje3.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        JLBL_Mensaje3.setForeground(new java.awt.Color(255, 255, 255));
        JLBL_Mensaje3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Mensaje3.setText("Aqui   va aun mensaje");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Alertas/Icono_Ok.png"))); // NOI18N

        JLBL_Titulo.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        JLBL_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        JLBL_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Titulo.setText("Operacion completada !");

        JBTN_Salir.setBackground(new java.awt.Color(0, 126, 51));
        JBTN_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Alertas/Icono_Salir.png"))); // NOI18N
        JBTN_Salir.setAutoscrolls(true);
        JBTN_Salir.setColorHover(new java.awt.Color(0, 126, 51));
        JBTN_Salir.setEfecto(rojeru_san.rsbutton.RSButtonRoundEffect.EFECTO.RIPLE);
        JBTN_Salir.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        JBTN_Salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JBTN_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPNL_FondoLayout = new javax.swing.GroupLayout(JPNL_Fondo);
        JPNL_Fondo.setLayout(JPNL_FondoLayout);
        JPNL_FondoLayout.setHorizontalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLBL_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBL_Mensaje1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBL_Mensaje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBL_Mensaje3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_FondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JBTN_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JPNL_FondoLayout.setVerticalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addComponent(JBTN_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addComponent(JLBL_Titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBL_Mensaje1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBL_Mensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBL_Mensaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPNL_FondoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JLBL_Mensaje1, JLBL_Mensaje2, JLBL_Mensaje3});

        rSPanelShadow1.add(JPNL_Fondo, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTN_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBTN_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(Alerta_Exito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alerta_Exito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alerta_Exito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alerta_Exito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Alerta_Exito dialog = new Alerta_Exito(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRoundEffect JBTN_Salir;
    public static javax.swing.JLabel JLBL_Mensaje1;
    public static javax.swing.JLabel JLBL_Mensaje2;
    public static javax.swing.JLabel JLBL_Mensaje3;
    public static javax.swing.JLabel JLBL_Titulo;
    private javax.swing.JPanel JPNL_Fondo;
    private javax.swing.JLabel jLabel1;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
