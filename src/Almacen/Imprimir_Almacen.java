/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;


import Alertas.Alerta_Error;
import Base_De_Datos.Construcciones.Categorias;
import Base_De_Datos.Implementaciones.DAOCategoriasImpI;
import Base_De_Datos.interfaces.DAOCategorias;
import Reportes.Reportes;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import necesario.RSAWTUtilities;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author DIEGO
 */
public class Imprimir_Almacen extends javax.swing.JDialog {

    private Alerta_Error EA = new Alerta_Error(new JFrame(),true);
    
    public Imprimir_Almacen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setMoverVentana(this);
        
        Llenar_Categorias();
        this.JCBX_Categoria.setSelectedIndex(0);
    }

    private void addEventKey() {
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        Action enterAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JPNL_Slider.slidPanel(1, JPNL_Cargando, rojerusan.RSPanelsSlider.direct.Left);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Reportes nuevoReporte = new Reportes();
                        try {
                            nuevoReporte.Reporte_Inventario(JCBX_Categoria.getSelectedItem().toString());
                            dispose();
                        } catch (Exception ex) {
                            EA.JLBL_Mensaje1.setText("Error al generar reporte");
                            EA.JLBL_Mensaje2.setText("");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                            System.out.println(ex.getMessage());
                        }
                    }
                }).start();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enter, "ENTER");
        getRootPane().getActionMap().put("ENTER", enterAction);

        //---------------------------------------------------------------------------
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }
    private void Llenar_Categorias(){
        List<Categorias> datosCategorias = new ArrayList();
        DAOCategorias metodos = new DAOCategoriasImpI();
        
        DefaultComboBoxModel modeloCombo = (DefaultComboBoxModel) this.JCBX_Categoria.getModel();
        
        modeloCombo.removeAllElements();
        modeloCombo.addElement("-Imprimir todo-");
        
        try{
            datosCategorias = metodos.Listar("");
            
            for(int i = 0;i < datosCategorias.size();i++){
                modeloCombo.addElement(datosCategorias.get(i).getNombre());
            }
            
        }catch(Exception ex){
            EA.JLBL_Mensaje1.setText("Error al obtener las categorías");
            EA.JLBL_Mensaje2.setText("de la base de datos");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPNL_Shadow = new rojeru_san.RSPanelShadow();
        JPNL_Fondo = new javax.swing.JPanel();
        JNPL_Encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBTN_Cerrar = new rojeru_san.RSButtonRiple();
        JPNL_Slider = new rojerusan.RSPanelsSlider();
        JPNL_Imprimir = new javax.swing.JPanel();
        JCBX_Categoria = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JBTN_Imprimir = new rojeru_san.RSButtonRiple();
        JPNL_Cargando = new javax.swing.JPanel();
        rSProgressMaterial1 = new RSMaterialComponent.RSProgressMaterial();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        JPNL_Fondo.setBackground(new java.awt.Color(255, 255, 255));

        JNPL_Encabezado.setBackground(new java.awt.Color(34, 41, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GENERAR REPORTE");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Impresion.png"))); // NOI18N

        JBTN_Cerrar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Alertas/Icono_Salir.png"))); // NOI18N
        JBTN_Cerrar.setColorHover(new java.awt.Color(34, 41, 50));
        JBTN_Cerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JBTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JNPL_EncabezadoLayout = new javax.swing.GroupLayout(JNPL_Encabezado);
        JNPL_Encabezado.setLayout(JNPL_EncabezadoLayout);
        JNPL_EncabezadoLayout.setHorizontalGroup(
            JNPL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JNPL_EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBTN_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JNPL_EncabezadoLayout.setVerticalGroup(
            JNPL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JNPL_EncabezadoLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(JNPL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBTN_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JPNL_Imprimir.setBackground(new java.awt.Color(255, 255, 255));
        JPNL_Imprimir.setName("JPNL_Imprimir"); // NOI18N

        JCBX_Categoria.setForeground(new java.awt.Color(24, 23, 37));
        JCBX_Categoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR CATEGORIA", "ADMINISTRADOR", "MODERADOR", "ESTANDAR" }));
        JCBX_Categoria.setColorMaterial(new java.awt.Color(66, 63, 102));
        JCBX_Categoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JCBX_Categoria.setVelMils(300);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(93, 97, 92));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Desea exportar todo el inventario?");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(93, 97, 92));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(puede elegir una categoría)");

        JBTN_Imprimir.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Impresion.png"))); // NOI18N
        JBTN_Imprimir.setText("IMPRIMIR");
        JBTN_Imprimir.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Imprimir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_ImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPNL_ImprimirLayout = new javax.swing.GroupLayout(JPNL_Imprimir);
        JPNL_Imprimir.setLayout(JPNL_ImprimirLayout);
        JPNL_ImprimirLayout.setHorizontalGroup(
            JPNL_ImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPNL_ImprimirLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(JBTN_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_ImprimirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCBX_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        JPNL_ImprimirLayout.setVerticalGroup(
            JPNL_ImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_ImprimirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(JCBX_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(JBTN_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        JPNL_Slider.add(JPNL_Imprimir, "card2");

        JPNL_Cargando.setBackground(new java.awt.Color(255, 255, 255));
        JPNL_Cargando.setName("JPNL_Cargando"); // NOI18N

        rSProgressMaterial1.setForeground(new java.awt.Color(24, 23, 37));
        rSProgressMaterial1.setWidthProgress(20);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(93, 97, 92));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Generando, espere por favor...");

        javax.swing.GroupLayout JPNL_CargandoLayout = new javax.swing.GroupLayout(JPNL_Cargando);
        JPNL_Cargando.setLayout(JPNL_CargandoLayout);
        JPNL_CargandoLayout.setHorizontalGroup(
            JPNL_CargandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_CargandoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSProgressMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        JPNL_CargandoLayout.setVerticalGroup(
            JPNL_CargandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_CargandoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSProgressMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );

        JPNL_Slider.add(JPNL_Cargando, "card3");

        javax.swing.GroupLayout JPNL_FondoLayout = new javax.swing.GroupLayout(JPNL_Fondo);
        JPNL_Fondo.setLayout(JPNL_FondoLayout);
        JPNL_FondoLayout.setHorizontalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPNL_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        JPNL_FondoLayout.setVerticalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 276, Short.MAX_VALUE))
        );

        JPNL_Shadow.add(JPNL_Fondo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Shadow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Shadow, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBTN_CerrarActionPerformed

    private void JBTN_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_ImprimirActionPerformed
        JPNL_Slider.slidPanel(1, JPNL_Cargando, rojerusan.RSPanelsSlider.direct.Left);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Reportes nuevoReporte = new Reportes();
                    try {
                        nuevoReporte.Reporte_Inventario(JCBX_Categoria.getSelectedItem().toString());
                        dispose();
                    } catch (Exception ex) {
                        EA.JLBL_Mensaje1.setText("Error al generar reporte");
                        EA.JLBL_Mensaje2.setText("");
                        EA.JLBL_Mensaje3.setText("");
                        EA.setVisible(true);
                        System.out.println(ex.getMessage());
                    }
                }
            }).start();
    }//GEN-LAST:event_JBTN_ImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Imprimir_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imprimir_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imprimir_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imprimir_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Imprimir_Almacen dialog = new Imprimir_Almacen(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple JBTN_Cerrar;
    public static rojeru_san.RSButtonRiple JBTN_Imprimir;
    private RSMaterialComponent.RSComboBoxMaterial JCBX_Categoria;
    private javax.swing.JPanel JNPL_Encabezado;
    private javax.swing.JPanel JPNL_Cargando;
    private javax.swing.JPanel JPNL_Fondo;
    private javax.swing.JPanel JPNL_Imprimir;
    private rojeru_san.RSPanelShadow JPNL_Shadow;
    private rojerusan.RSPanelsSlider JPNL_Slider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private RSMaterialComponent.RSProgressMaterial rSProgressMaterial1;
    // End of variables declaration//GEN-END:variables
}
