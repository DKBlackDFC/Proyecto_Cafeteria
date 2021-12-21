/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Alertas.Alerta_Error;
import Principal.Ventana_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 *
 * @author DIEGO
 */
public class JPNL_VentasMaqueta extends javax.swing.JPanel {
    
    private JPNL_CajaMaqueta JPNL_Caja;
    private JPNL_UltimasVentasMaqueta JPNL_UltimasVentas;
    
    public JPNL_VentasMaqueta() {
        initComponents();
        
        addEventKey();
        Inicializar_Paneles();
    }
    
    private void Inicializar_Paneles(){
        JPNL_Caja = new JPNL_CajaMaqueta();
        JPNL_UltimasVentas = new JPNL_UltimasVentasMaqueta();
        
        JPNL_Caja.setName("JPNL_CajaMaqueta");
        JPNL_UltimasVentas.setName("JPNL_UltimasVentasMaqueta");
        
        JPNL_Slider.add(JPNL_Caja);
        JPNL_Slider.add(JPNL_UltimasVentas);
    }
    
    private void addEventKey() {
        //--------------------------------------------------------------------------------
        KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0, false);
        Action f5Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!JBTN_Ventas.isSelected()){
                    JBTN_Ventas.setSelected(true);
                    JBTN_Reportes.setSelected(false);
                    JBTN_UltimasVentas.setSelected(false);

                    JPNL_Slider.slidPanel(4, JPNL_Caja, rojerusan.RSPanelsSlider.direct.Right);
                }
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f5, "F5");
        this.getActionMap().put("F5", f5Action);

        //--------------------------------------------------------------------------------
        KeyStroke f6 = KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0, false);
        Action f6Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!Ventana_Principal.JLBL_AsignarTipo.getText().equals("ESTANDAR")){
                    new Imprimir_Ventas(new JFrame(),true).setVisible(true);
                }else{
                    Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                    EA.JLBL_Mensaje1.setText("No cuentas con los permisos suficientes");
                    EA.JLBL_Mensaje2.setText("para acceder a éste apartado.");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                }
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f6, "F6");
        this.getActionMap().put("F6", f6Action);

        //--------------------------------------------------------------------------------
        KeyStroke f7 = KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0, false);
        Action f7Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!Ventana_Principal.JLBL_AsignarTipo.getText().equals("ESTANDAR")){
                    if(!JBTN_UltimasVentas.isSelected()){
                        JBTN_Ventas.setSelected(false);
                        JBTN_Reportes.setSelected(false);
                        JBTN_UltimasVentas.setSelected(true);

                        JPNL_Slider.slidPanel(4, JPNL_UltimasVentas, rojerusan.RSPanelsSlider.direct.Right);
                    }
                }else{
                    Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                    EA.JLBL_Mensaje1.setText("No cuentas con los permisos suficientes");
                    EA.JLBL_Mensaje2.setText("para acceder a éste apartado.");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                }
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f7, "F7");
        this.getActionMap().put("F7", f7Action);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        JPNL_Principal = new javax.swing.JPanel();
        JPNL_Slider = new rojerusan.RSPanelsSlider();
        JPNL_Encabezado = new javax.swing.JPanel();
        JPNL_Botones = new javax.swing.JPanel();
        JBTN_Reportes = new rojeru_san.RSButtonRiple();
        JBTN_UltimasVentas = new rojeru_san.RSButtonRiple();
        JBTN_Ventas = new rojeru_san.RSButtonRiple();

        setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(66, 63, 102));
        jSeparator1.setForeground(new java.awt.Color(66, 63, 102));

        JPNL_Principal.setBackground(new java.awt.Color(255, 255, 255));

        JPNL_Encabezado.setBackground(new java.awt.Color(255, 255, 255));

        JPNL_Botones.setBackground(new java.awt.Color(255, 255, 255));
        JPNL_Botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBTN_Reportes.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Reportes.png"))); // NOI18N
        JBTN_Reportes.setText("REPORTES (F6)");
        JBTN_Reportes.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Reportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Reportes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_ReportesActionPerformed(evt);
            }
        });
        JPNL_Botones.add(JBTN_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 180, 42));

        JBTN_UltimasVentas.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_UltimasVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Ventas_v2.png"))); // NOI18N
        JBTN_UltimasVentas.setText("ÚLTIMAS VENTAS (F7)");
        JBTN_UltimasVentas.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_UltimasVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_UltimasVentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_UltimasVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_UltimasVentasActionPerformed(evt);
            }
        });
        JPNL_Botones.add(JBTN_UltimasVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 230, 42));

        JBTN_Ventas.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Caja.png"))); // NOI18N
        JBTN_Ventas.setText("CAJA (F5)");
        JBTN_Ventas.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Ventas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Ventas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Ventas.setSelected(true);
        JBTN_Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_VentasActionPerformed(evt);
            }
        });
        JPNL_Botones.add(JBTN_Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 42));

        javax.swing.GroupLayout JPNL_EncabezadoLayout = new javax.swing.GroupLayout(JPNL_Encabezado);
        JPNL_Encabezado.setLayout(JPNL_EncabezadoLayout);
        JPNL_EncabezadoLayout.setHorizontalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPNL_EncabezadoLayout.createSequentialGroup()
                    .addComponent(JPNL_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        JPNL_EncabezadoLayout.setVerticalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
            .addGroup(JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPNL_EncabezadoLayout.createSequentialGroup()
                    .addComponent(JPNL_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout JPNL_PrincipalLayout = new javax.swing.GroupLayout(JPNL_Principal);
        JPNL_Principal.setLayout(JPNL_PrincipalLayout);
        JPNL_PrincipalLayout.setHorizontalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
            .addGroup(JPNL_PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPNL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPNL_PrincipalLayout.setVerticalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPNL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_Slider, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
            .addComponent(JPNL_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBTN_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_ReportesActionPerformed
        new Imprimir_Ventas(new JFrame(),true).setVisible(true);
    }//GEN-LAST:event_JBTN_ReportesActionPerformed

    private void JBTN_UltimasVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_UltimasVentasActionPerformed
        if(!Ventana_Principal.JLBL_AsignarTipo.getText().equals("ESTANDAR")){
            if(!this.JBTN_UltimasVentas.isSelected()){
                this.JBTN_Ventas.setSelected(false);
                this.JBTN_Reportes.setSelected(false);
                this.JBTN_UltimasVentas.setSelected(true);

                this.JPNL_Slider.slidPanel(4, JPNL_UltimasVentas, rojerusan.RSPanelsSlider.direct.Right);
            }
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No cuentas con los permisos suficientes");
            EA.JLBL_Mensaje2.setText("para acceder a éste apartado.");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }//GEN-LAST:event_JBTN_UltimasVentasActionPerformed

    private void JBTN_VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_VentasActionPerformed
        if(!this.JBTN_Ventas.isSelected()){
            this.JBTN_Ventas.setSelected(true);
            this.JBTN_Reportes.setSelected(false);
            this.JBTN_UltimasVentas.setSelected(false);
            
            this.JPNL_Slider.slidPanel(4, JPNL_Caja, rojerusan.RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_JBTN_VentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_Reportes;
    private rojeru_san.RSButtonRiple JBTN_UltimasVentas;
    private rojeru_san.RSButtonRiple JBTN_Ventas;
    private javax.swing.JPanel JPNL_Botones;
    private javax.swing.JPanel JPNL_Encabezado;
    private javax.swing.JPanel JPNL_Principal;
    public static rojerusan.RSPanelsSlider JPNL_Slider;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
