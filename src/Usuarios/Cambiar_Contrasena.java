/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Alertas.Alerta_Informacion;
import Base_De_Datos.Construcciones.Usuarios;
import Base_De_Datos.Implementaciones.DAOUsuariosImpI;
import Base_De_Datos.interfaces.DAOUsuarios;
import Principal.Ventana_Principal;
import Utilidades.Cifrado;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import Utilidades.ToolTip;
import necesario.RSAWTUtilities;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author DIEGO
 */
public class Cambiar_Contrasena extends javax.swing.JDialog {

    public Cambiar_Contrasena(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);

        Limpiar_Campos();

        Asignar_ToolTip();
    }

    private void addEventKey() {
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    private void Limpiar_Campos(){
        this.JPFL_ContrasenaActual.requestFocus();
        this.JPFL_ContrasenaActual.setNextFocusableComponent(this.JPFL_Contrasena);
        this.JPFL_Contrasena.setNextFocusableComponent(this.JPFL_ContrasenaConfirmar);

        this.JPFL_ContrasenaActual.setText("");
        this.JPFL_Contrasena.setText("");
        this.JPFL_ContrasenaConfirmar.setText("");
    }

    private boolean Verificar_Llenado() {
        if(this.JPFL_ContrasenaActual.getText().isEmpty()
                || this.JPFL_Contrasena.getText().isEmpty()
                || this.JPFL_ContrasenaConfirmar.getText().isEmpty()){
            
            return false;
        }else{
            return true;
        }
    }
    private boolean Verificar_Contrasena(){
        String contrasena = Cifrado.SHA1(this.JPFL_ContrasenaActual.getText());
        Usuarios modelo = new Usuarios();
        DAOUsuarios metodos = new DAOUsuariosImpI();
        
        try{
            modelo = metodos.Extraer_Datos(Ventana_Principal.JLBL_Id.getText());
            
            if(contrasena.equals(modelo.getContrasena())){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.rspanel.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JLBL_Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new rojeru_san.RSButtonRiple();
        JPFL_ContrasenaActual = new rojeru_san.rsfield.RSPassMaterial();
        JLBL_Error = new javax.swing.JLabel();
        JPFL_Contrasena = new rojeru_san.rsfield.RSPassMaterial();
        JPFL_ContrasenaConfirmar = new rojeru_san.rsfield.RSPassMaterial();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(34, 41, 50));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        JLBL_Titulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        JLBL_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        JLBL_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Titulo.setText("CAMBIAR CONTRASEÑA DE USUARIO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Contrasena_v2.png"))); // NOI18N

        btnSalir.setBackground(new java.awt.Color(34, 41, 50));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Alertas/Icono_Salir.png"))); // NOI18N
        btnSalir.setColorHover(new java.awt.Color(34, 41, 50));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBL_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBL_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        JPFL_ContrasenaActual.setForeground(new java.awt.Color(24, 23, 37));
        JPFL_ContrasenaActual.setToolTipText("");
        JPFL_ContrasenaActual.setColorMaterial(new java.awt.Color(66, 63, 102));
        JPFL_ContrasenaActual.setPlaceholder("Contraseña Actual");
        JPFL_ContrasenaActual.setSelectionColor(new java.awt.Color(66, 63, 102));

        JLBL_Error.setBackground(new java.awt.Color(255, 255, 255));
        JLBL_Error.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLBL_Error.setForeground(new java.awt.Color(255, 255, 255));
        JLBL_Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Error.setOpaque(true);

        JPFL_Contrasena.setForeground(new java.awt.Color(24, 23, 37));
        JPFL_Contrasena.setToolTipText("");
        JPFL_Contrasena.setColorMaterial(new java.awt.Color(66, 63, 102));
        JPFL_Contrasena.setPlaceholder("Nueva Contraseña");
        JPFL_Contrasena.setSelectionColor(new java.awt.Color(66, 63, 102));

        JPFL_ContrasenaConfirmar.setForeground(new java.awt.Color(24, 23, 37));
        JPFL_ContrasenaConfirmar.setToolTipText("");
        JPFL_ContrasenaConfirmar.setColorMaterial(new java.awt.Color(66, 63, 102));
        JPFL_ContrasenaConfirmar.setPlaceholder("Confirmar Contraseña");
        JPFL_ContrasenaConfirmar.setSelectionColor(new java.awt.Color(66, 63, 102));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Contrasena_v3.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Contrasena.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Contrasena.png"))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(34, 41, 50));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Salvar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR CAMBIOS");
        btnGuardar.setColorHover(new java.awt.Color(54, 63, 73));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBL_Error, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JPFL_ContrasenaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JPFL_ContrasenaConfirmar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JPFL_Contrasena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JPFL_Contrasena, JPFL_ContrasenaActual, JPFL_ContrasenaConfirmar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8))
                    .addComponent(JPFL_ContrasenaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPFL_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(JPFL_ContrasenaConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JLBL_Error, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (Verificar_Llenado()){
            if(Verificar_Contrasena()){
                if(this.JPFL_Contrasena.getText().equals(this.JPFL_ContrasenaConfirmar.getText())){
                    JPNL_CajerosMaqueta.nuevaContrasena = Cifrado.SHA1(JPFL_Contrasena.getText());
                    
                    JLBL_Error.setIcon(new ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Error.png")));
                    JLBL_Error.setBackground(new Color(255, 255, 255));
                    JLBL_Error.setForeground(new Color(255, 255, 255));
                    this.JLBL_Error.setText("");
                    
                    this.dispose();
                    
                    Alerta_Informacion SA = new Alerta_Informacion(new JFrame(),true);
                    SA.JLBL_Mensaje1.setText("Contraseña aceptada, puesta en");
                    SA.JLBL_Mensaje2.setText("pre-guardado. Guarde los cambios");
                    SA.JLBL_Mensaje3.setText("para actualizar contraseña.");
                    SA.setVisible(true);
                }else{
                    this.JPFL_ContrasenaConfirmar.requestFocus();
                    JLBL_Error.setIcon(new ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Error.png")));
                    JLBL_Error.setBackground(new Color(255, 76, 76));
                    JLBL_Error.setForeground(new Color(255, 255, 255));
                    this.JLBL_Error.setText("¡Las contraseñas no coinciden!");
                }
            }else{
                this.JPFL_ContrasenaActual.requestFocus();
                JLBL_Error.setIcon(new ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Error.png")));
                JLBL_Error.setBackground(new Color(255, 76, 76));
                JLBL_Error.setForeground(new Color(255, 255, 255));
                this.JLBL_Error.setText("¡La contraseña actual no es correcta!");
            }
        }else{
            this.JPFL_ContrasenaActual.requestFocus();
            JLBL_Error.setIcon(new ImageIcon(getClass().getResource("/IMG/Cajeros/Icono_Error.png")));
            JLBL_Error.setBackground(new Color(255, 76, 76));
            JLBL_Error.setForeground(new Color(255, 255, 255));
            this.JLBL_Error.setText("¡Todos los campos son requeridos!");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(Cambiar_Contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cambiar_Contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cambiar_Contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cambiar_Contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cambiar_Contrasena dialog = new Cambiar_Contrasena(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBL_Error;
    private javax.swing.JLabel JLBL_Titulo;
    public static rojeru_san.rsfield.RSPassMaterial JPFL_Contrasena;
    public static rojeru_san.rsfield.RSPassMaterial JPFL_ContrasenaActual;
    public static rojeru_san.rsfield.RSPassMaterial JPFL_ContrasenaConfirmar;
    private rojeru_san.RSButtonRiple btnGuardar;
    private rojeru_san.RSButtonRiple btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables

    private void Asignar_ToolTip() {
        this.JPFL_ContrasenaActual.setToolTipText(ToolTip.head + ToolTip.body + "Contraseña del usuario conectado (Administrador)" + ToolTip.pie);
        this.JPFL_Contrasena.setToolTipText(ToolTip.head + ToolTip.body + "Nueva contraseña para el <br> usuario seleccionado" + ToolTip.pie);
        this.JPFL_ContrasenaConfirmar.setToolTipText(ToolTip.head + ToolTip.body + "Confirmar la nueva contraseña" + ToolTip.pie);
    }
}
