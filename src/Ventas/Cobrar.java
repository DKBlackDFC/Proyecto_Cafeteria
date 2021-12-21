/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author DIEGO
 */
public class Cobrar extends javax.swing.JDialog {
    
    public static double totalCobrar = 0;
    public static boolean ventaSinTicket = false;
    public static boolean ventaConTicket = false;
    public static String pagoCon;
    public static String cambio;
    public static String formaPago;
    public static String efectivo;
    public static String tarjeta;
    
    public Cobrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setMoverVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        
        JGBT_FormasPago.add(JCHB_Efectivo);
        JGBT_FormasPago.add(JCHB_Tarjeta);
        
        Pago_Efectivo();
        
        Seleccionar_Campo();
        addEventKey();
    }
    
    private void addEventKey() {
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                ventaSinTicket = false;
                ventaConTicket = false;
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);

        //--------------------------------------------------------------------------------
        KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false);
        Action f1Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Venta_Ticket();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f1, "F1");
        getRootPane().getActionMap().put("F1", f1Action);

        //--------------------------------------------------------------------------------
        KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, false);
        Action f2Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Venta();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f2, "F2");
        getRootPane().getActionMap().put("F2", f2Action);
    }
    private void Pago_Efectivo(){
        if(Double.parseDouble(JTFL_PagoCon.getText()) >= totalCobrar){
            this.JLBL_Error.setText("");
            JTFL_PagoCon.setEnabled(true);
            JTFL_PagoCon.setBackground(new Color(255,255,255));
            this.JLBL_CambioTarjeta.setText("Cambio: ");
            this.JLBL_Cambio.setText("$" + (Double.parseDouble(JTFL_PagoCon.getText()) - totalCobrar));
        }else{
            this.JLBL_Error.setText("¡La cantidad del pago no es válida!.");
            JTFL_PagoCon.setEnabled(true);
            JTFL_PagoCon.setBackground(new Color(255,255,255));
            this.JLBL_CambioTarjeta.setText("Cambio: ");
            this.JLBL_Cambio.setText("$" + String.format("%.2f", (Double.parseDouble(JTFL_PagoCon.getText()) - totalCobrar)));
        }
    }
    private void Pago_Tarjeta(){
        this.JLBL_Error.setText("");
        JTFL_PagoCon.setEnabled(false);
        JTFL_PagoCon.setBackground(new Color(255,255,255));
        JTFL_PagoCon.setText("" + totalCobrar);
        this.JLBL_CambioTarjeta.setText("Cambio: ");
        this.JLBL_Cambio.setText("$0.00");
    }
    private void Seleccionar_Campo() {
        this.JTFL_PagoCon.requestFocus();
        InputMap map1 = this.JTFL_PagoCon.getInputMap(this.JTFL_PagoCon.WHEN_FOCUSED);

        this.JTFL_PagoCon.setSelectionStart(0);
        this.JTFL_PagoCon.setSelectionEnd(this.JTFL_PagoCon.getText().length());
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JGBT_FormasPago = new javax.swing.ButtonGroup();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        JBTN_Cancelar = new rojeru_san.RSButtonRiple();
        JBTN_VentaTicket = new rojeru_san.RSButtonRiple();
        JBTN_Venta = new rojeru_san.RSButtonRiple();
        JLBL_Error = new javax.swing.JLabel();
        JCHB_Efectivo = new Utilidades.RSCheckBox();
        JCHB_Tarjeta = new Utilidades.RSCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JLBL_Total = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTFL_PagoCon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JLBL_Cantidad = new javax.swing.JLabel();
        JLBL_Cambio = new javax.swing.JLabel();
        JLBL_CambioTarjeta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(714, 497));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(34, 41, 50));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Caja.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("COBRAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBTN_Cancelar.setBackground(new java.awt.Color(255, 68, 68));
        JBTN_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Cancelar.png"))); // NOI18N
        JBTN_Cancelar.setText("Cancelar (ESC)");
        JBTN_Cancelar.setColorHover(new java.awt.Color(255, 100, 100));
        JBTN_Cancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CancelarActionPerformed(evt);
            }
        });
        jPanel4.add(JBTN_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 49));

        JBTN_VentaTicket.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_VentaTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Ticket.png"))); // NOI18N
        JBTN_VentaTicket.setText("Venta con Nota (F1)");
        JBTN_VentaTicket.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_VentaTicket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_VentaTicket.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_VentaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_VentaTicketActionPerformed(evt);
            }
        });
        jPanel4.add(JBTN_VentaTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 225, 49));

        JBTN_Venta.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_SinTicket.png"))); // NOI18N
        JBTN_Venta.setText("Venta sin Nota (F2)");
        JBTN_Venta.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Venta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Venta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_VentaActionPerformed(evt);
            }
        });
        jPanel4.add(JBTN_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 0, 222, 49));

        JLBL_Error.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        JLBL_Error.setForeground(new java.awt.Color(243, 66, 53));
        JLBL_Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JCHB_Efectivo.setSelected(true);
        JCHB_Efectivo.setText("Efectivo");
        JCHB_Efectivo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JCHB_Efectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCHB_EfectivoMouseClicked(evt);
            }
        });

        JCHB_Tarjeta.setText("Tarjeta");
        JCHB_Tarjeta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JCHB_Tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCHB_TarjetaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBL_Error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(JCHB_Efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JCHB_Tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCHB_Efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCHB_Tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLBL_Error, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(93, 97, 92));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total a cobrar $:");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        JLBL_Total.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        JLBL_Total.setForeground(new java.awt.Color(51, 51, 51));
        JLBL_Total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Total.setText("$ 0.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLBL_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLBL_Total)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(93, 97, 92));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Pago con $:");

        JTFL_PagoCon.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        JTFL_PagoCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFL_PagoCon.setText("0.00");
        JTFL_PagoCon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        JTFL_PagoCon.setSelectionColor(new java.awt.Color(220, 23, 111));
        JTFL_PagoCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_PagoConKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFL_PagoConKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(93, 97, 92));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Productos a venta:");

        JLBL_Cantidad.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JLBL_Cantidad.setForeground(new java.awt.Color(51, 51, 51));
        JLBL_Cantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Cantidad.setText("7");

        JLBL_Cambio.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        JLBL_Cambio.setForeground(new java.awt.Color(0, 204, 102));
        JLBL_Cambio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLBL_Cambio.setText("$0.00");

        JLBL_CambioTarjeta.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        JLBL_CambioTarjeta.setForeground(new java.awt.Color(93, 97, 92));
        JLBL_CambioTarjeta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLBL_CambioTarjeta.setText("Cambio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(JLBL_CambioTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLBL_Cambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFL_PagoCon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLBL_Cantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTFL_PagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLBL_Cantidad))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLBL_CambioTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBL_Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
        ventaSinTicket = false;
        ventaConTicket = false;
        this.dispose();
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

    private void JBTN_VentaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_VentaTicketActionPerformed
        Venta_Ticket();
    }//GEN-LAST:event_JBTN_VentaTicketActionPerformed

    private void JBTN_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_VentaActionPerformed
        Venta();
    }//GEN-LAST:event_JBTN_VentaActionPerformed

    private void JTFL_PagoConKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_PagoConKeyReleased
        if(this.JCHB_Efectivo.isSelected()){
            if(!this.JTFL_PagoCon.getText().isEmpty()){
                if(totalCobrar > Double.parseDouble(JTFL_PagoCon.getText())){
                    this.JLBL_Error.setText("¡La cantidad del pago no es válida!.");
                }else{
                    this.JLBL_Error.setText("");
                }
            }

            if(!this.JTFL_PagoCon.getText().isEmpty()){
                double cambio = Double.parseDouble(this.JTFL_PagoCon.getText()) - totalCobrar;
                this.JLBL_Cambio.setText("$" + String.format("%.2f",cambio));
            }else{
                this.JLBL_Cambio.setText("$0.00");
            }
        }else{
            if(!this.JTFL_PagoCon.getText().isEmpty()){
                if(totalCobrar <= Double.parseDouble(JTFL_PagoCon.getText())){
                    this.JLBL_Error.setText("¡La cantidad del pago no es válida!.");
                }else{
                    this.JLBL_Error.setText("");
                }
            }

            if(!this.JTFL_PagoCon.getText().isEmpty()){
                double cambio = totalCobrar - Double.parseDouble(this.JTFL_PagoCon.getText());
                this.JLBL_Cambio.setText("$" + String.format("%.2f",cambio));
            }else{
                this.JLBL_Cambio.setText("$0.00");
            }
        }
    }//GEN-LAST:event_JTFL_PagoConKeyReleased

    private void JTFL_PagoConKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_PagoConKeyTyped
        char car = evt.getKeyChar();
        if (((car < '0') || (car > '9')) && (car != KeyEvent.VK_BACK_SPACE) && (car != '.')) {
            evt.consume();
        }

        if (car == '.' && JTFL_PagoCon.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_JTFL_PagoConKeyTyped

    private void JCHB_EfectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCHB_EfectivoMouseClicked
        if(this.JCHB_Efectivo.isSelected()){
            Pago_Efectivo();
        }
    }//GEN-LAST:event_JCHB_EfectivoMouseClicked

    private void JCHB_TarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCHB_TarjetaMouseClicked
        if(this.JCHB_Tarjeta.isSelected()){
            Pago_Tarjeta();
        }
    }//GEN-LAST:event_JCHB_TarjetaMouseClicked

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
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cobrar dialog = new Cobrar(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple JBTN_Cancelar;
    private rojeru_san.RSButtonRiple JBTN_Venta;
    private rojeru_san.RSButtonRiple JBTN_VentaTicket;
    private Utilidades.RSCheckBox JCHB_Efectivo;
    private Utilidades.RSCheckBox JCHB_Tarjeta;
    private javax.swing.ButtonGroup JGBT_FormasPago;
    private javax.swing.JLabel JLBL_Cambio;
    private javax.swing.JLabel JLBL_CambioTarjeta;
    public static javax.swing.JLabel JLBL_Cantidad;
    private javax.swing.JLabel JLBL_Error;
    public static javax.swing.JLabel JLBL_Total;
    public static javax.swing.JTextField JTFL_PagoCon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables

    private void Venta_Ticket(){
        if(this.JCHB_Efectivo.isSelected()){
            if(!JTFL_PagoCon.getText().isEmpty()){
                if (totalCobrar <= Double.parseDouble(JTFL_PagoCon.getText())) {
                    ventaConTicket = true;
                    pagoCon = this.JTFL_PagoCon.getText();
                    cambio = this.JLBL_Cambio.getText();
                    formaPago = "Efectivo";
                    efectivo = pagoCon;
                    tarjeta = "0.00";
                    this.dispose();
                }
            }
        }else{
            if(this.JCHB_Tarjeta.isSelected()){
                if(!JTFL_PagoCon.getText().isEmpty()){
                    if(totalCobrar <= Double.parseDouble(JTFL_PagoCon.getText())) {
                        ventaConTicket = true;
                        pagoCon = this.JTFL_PagoCon.getText();
                        cambio = this.JLBL_Cambio.getText();
                        formaPago = "Tarjeta";
                        efectivo = "0.00";
                        tarjeta = pagoCon;
                        this.dispose();
                    }
                }
            }else{
                if(!JTFL_PagoCon.getText().isEmpty()){
                    if (totalCobrar > Double.parseDouble(JTFL_PagoCon.getText()) && Double.parseDouble(JTFL_PagoCon.getText()) > 0) {
                        ventaConTicket = true;
                        pagoCon = this.JTFL_PagoCon.getText();
                        cambio = this.JLBL_Cambio.getText();
                        formaPago = "Hibrido";
                        efectivo = pagoCon;
                        tarjeta = String.format("%.2f", totalCobrar-Double.parseDouble(pagoCon));
                        this.dispose();
                    }
                }
            }
        }
    }
    private void Venta(){
        if(this.JCHB_Efectivo.isSelected()){
            if(!JTFL_PagoCon.getText().isEmpty()){
                if (totalCobrar <= Double.parseDouble(JTFL_PagoCon.getText())) {
                    ventaSinTicket = true;
                    pagoCon = this.JTFL_PagoCon.getText();
                    cambio = this.JLBL_Cambio.getText();
                    formaPago = "Efectivo";
                    efectivo = pagoCon;
                    tarjeta = "0.00";
                    this.dispose();
                }
            }
        }else{
            if(this.JCHB_Tarjeta.isSelected()){
                if(!JTFL_PagoCon.getText().isEmpty()){
                    if(totalCobrar <= Double.parseDouble(JTFL_PagoCon.getText())) {
                        ventaSinTicket = true;
                        pagoCon = this.JTFL_PagoCon.getText();
                        cambio = this.JLBL_Cambio.getText();
                        formaPago = "Tarjeta";
                        efectivo = "0.00";
                        tarjeta = pagoCon;
                        this.dispose();
                    }
                }
            }else{
                if(!JTFL_PagoCon.getText().isEmpty()){
                    if(totalCobrar > Double.parseDouble(JTFL_PagoCon.getText()) && Double.parseDouble(JTFL_PagoCon.getText()) > 0){
                        ventaSinTicket = true;
                        pagoCon = this.JTFL_PagoCon.getText();
                        cambio = this.JLBL_Cambio.getText();
                        formaPago = "Hibrido";
                        efectivo = pagoCon;
                        tarjeta = String.format("%.2f", totalCobrar-Double.parseDouble(pagoCon));
                        this.dispose();
                    }
                }
            }
        }
    }
}
