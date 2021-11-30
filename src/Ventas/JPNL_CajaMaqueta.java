/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

/**
 *
 * @author DIEGO
 */
public class JPNL_CajaMaqueta extends javax.swing.JPanel {
    
    public JPNL_CajaMaqueta() {
        initComponents();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOP_MenuTabla = new rojerusan.RSPopuMenu();
        JPNL_Menu = new javax.swing.JPanel();
        JBTN_Editar = new rojeru_san.RSButtonRiple();
        JPNL_Principal = new javax.swing.JPanel();
        JPNL_Encabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JPNL_ControlInformacion = new javax.swing.JPanel();
        JPLN_Control = new javax.swing.JPanel();
        JBTN_Buscar = new rojeru_san.RSButtonRiple();
        JBTN_CobrarVenta = new rojeru_san.RSButtonRiple();
        JBTN_QuitarProducto = new rojeru_san.RSButtonRiple();
        JBTN_Cancelar = new rojeru_san.RSButtonRiple();
        JSB_Ventas = new javax.swing.JScrollPane();
        JTBL_Ventas = new rojerusan.RSTableMetro();
        JPNL_Datos = new javax.swing.JPanel();
        JLBL_Fecha = new rojeru_san.rsdate.RSLabelFecha();
        rSLabelImage1 = new rojeru_san.rslabel.RSLabelImage();
        rSLabelImage2 = new rojeru_san.rslabel.RSLabelImage();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        jLabel1 = new javax.swing.JLabel();
        JLBL_Total = new javax.swing.JLabel();

        JPNL_Menu.setBackground(new java.awt.Color(255, 255, 255));

        JBTN_Editar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Editar.png"))); // NOI18N
        JBTN_Editar.setText("EDITAR CANTIDAD");
        JBTN_Editar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Editar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_EditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPNL_MenuLayout = new javax.swing.GroupLayout(JPNL_Menu);
        JPNL_Menu.setLayout(JPNL_MenuLayout);
        JPNL_MenuLayout.setHorizontalGroup(
            JPNL_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JBTN_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        JPNL_MenuLayout.setVerticalGroup(
            JPNL_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JBTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPNL_Principal.setBackground(new java.awt.Color(255, 255, 255));

        JPNL_Encabezado.setBackground(new java.awt.Color(236, 236, 236));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 23, 37));
        jLabel3.setText("VENTA DE PRODUCTOS");

        javax.swing.GroupLayout JPNL_EncabezadoLayout = new javax.swing.GroupLayout(JPNL_Encabezado);
        JPNL_Encabezado.setLayout(JPNL_EncabezadoLayout);
        JPNL_EncabezadoLayout.setHorizontalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPNL_EncabezadoLayout.setVerticalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        JPNL_ControlInformacion.setBackground(new java.awt.Color(255, 255, 255));

        JPLN_Control.setBackground(new java.awt.Color(255, 255, 255));

        JBTN_Buscar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Buscar.png"))); // NOI18N
        JBTN_Buscar.setText("Agregar Producto (F1)");
        JBTN_Buscar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Buscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_BuscarActionPerformed(evt);
            }
        });

        JBTN_CobrarVenta.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_CobrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Caja.png"))); // NOI18N
        JBTN_CobrarVenta.setText("Cobrar venta (F2)");
        JBTN_CobrarVenta.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_CobrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_CobrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CobrarVentaActionPerformed(evt);
            }
        });

        JBTN_QuitarProducto.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Eliminar.png"))); // NOI18N
        JBTN_QuitarProducto.setText("Quitar producto (F3)");
        JBTN_QuitarProducto.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProductoActionPerformed(evt);
            }
        });

        JBTN_Cancelar.setBackground(new java.awt.Color(255, 68, 68));
        JBTN_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Cancelar.png"))); // NOI18N
        JBTN_Cancelar.setText("Cancelar Venta (F4)");
        JBTN_Cancelar.setColorHover(new java.awt.Color(255, 100, 100));
        JBTN_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPLN_ControlLayout = new javax.swing.GroupLayout(JPLN_Control);
        JPLN_Control.setLayout(JPLN_ControlLayout);
        JPLN_ControlLayout.setHorizontalGroup(
            JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLN_ControlLayout.createSequentialGroup()
                .addComponent(JBTN_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBTN_CobrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_QuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPLN_ControlLayout.setVerticalGroup(
            JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLN_ControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBTN_QuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBTN_CobrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JBTN_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JSB_Ventas.setBackground(new java.awt.Color(255, 255, 255));

        JTBL_Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO DE BARRAS", "PRODUCTO", "CANTIDAD", "PRECIO DE VENTA", "IMPORTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_Ventas.setAltoHead(30);
        JTBL_Ventas.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_Ventas.setColorBordeFilas(new java.awt.Color(109, 109, 109));
        JTBL_Ventas.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_Ventas.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_Ventas.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_Ventas.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_Ventas.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_Ventas.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_Ventas.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Ventas.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Ventas.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Ventas.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_Ventas.setGrosorBordeFilas(0);
        JTBL_Ventas.setGrosorBordeHead(0);
        JTBL_Ventas.setRowHeight(30);
        JTBL_Ventas.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_Ventas.getTableHeader().setReorderingAllowed(false);
        JTBL_Ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_VentasMouseClicked(evt);
            }
        });
        JSB_Ventas.setViewportView(JTBL_Ventas);

        javax.swing.GroupLayout JPNL_ControlInformacionLayout = new javax.swing.GroupLayout(JPNL_ControlInformacion);
        JPNL_ControlInformacion.setLayout(JPNL_ControlInformacionLayout);
        JPNL_ControlInformacionLayout.setHorizontalGroup(
            JPNL_ControlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_ControlInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_ControlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPLN_Control, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JSB_Ventas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        JPNL_ControlInformacionLayout.setVerticalGroup(
            JPNL_ControlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_ControlInformacionLayout.createSequentialGroup()
                .addComponent(JPLN_Control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSB_Ventas, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPNL_Datos.setBackground(new java.awt.Color(255, 255, 255));

        JLBL_Fecha.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_Fecha.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        JLBL_Fecha.setFormato("yyyy-MM-dd");

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Calendario.png"))); // NOI18N

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Reloj.png"))); // NOI18N

        rSLabelHora1.setForeground(new java.awt.Color(109, 109, 109));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 23, 37));
        jLabel1.setText("TOTAL: $");

        JLBL_Total.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        JLBL_Total.setText("0.00");

        javax.swing.GroupLayout JPNL_DatosLayout = new javax.swing.GroupLayout(JPNL_Datos);
        JPNL_Datos.setLayout(JPNL_DatosLayout);
        JPNL_DatosLayout.setHorizontalGroup(
            JPNL_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBL_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBL_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPNL_DatosLayout.setVerticalGroup(
            JPNL_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_DatosLayout.createSequentialGroup()
                .addGroup(JPNL_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(JLBL_Fecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelImage2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JPNL_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLBL_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPNL_PrincipalLayout = new javax.swing.GroupLayout(JPNL_Principal);
        JPNL_Principal.setLayout(JPNL_PrincipalLayout);
        JPNL_PrincipalLayout.setHorizontalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_ControlInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPNL_Datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPNL_Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPNL_PrincipalLayout.setVerticalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_PrincipalLayout.createSequentialGroup()
                .addComponent(JPNL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_ControlInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBTN_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_BuscarActionPerformed
        
    }//GEN-LAST:event_JBTN_BuscarActionPerformed

    private void JBTN_CobrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CobrarVentaActionPerformed
        
    }//GEN-LAST:event_JBTN_CobrarVentaActionPerformed

    private void JBTN_QuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProductoActionPerformed
        
    }//GEN-LAST:event_JBTN_QuitarProductoActionPerformed

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
       
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

    private void JTBL_VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_VentasMouseClicked
        
    }//GEN-LAST:event_JTBL_VentasMouseClicked

    private void JBTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EditarActionPerformed
        
    }//GEN-LAST:event_JBTN_EditarActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_Buscar;
    private rojeru_san.RSButtonRiple JBTN_Cancelar;
    private rojeru_san.RSButtonRiple JBTN_CobrarVenta;
    private rojeru_san.RSButtonRiple JBTN_Editar;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha;
    private javax.swing.JLabel JLBL_Total;
    private javax.swing.JPanel JPLN_Control;
    private javax.swing.JPanel JPNL_ControlInformacion;
    private javax.swing.JPanel JPNL_Datos;
    private javax.swing.JPanel JPNL_Encabezado;
    private javax.swing.JPanel JPNL_Menu;
    private javax.swing.JPanel JPNL_Principal;
    private rojerusan.RSPopuMenu JPOP_MenuTabla;
    private javax.swing.JScrollPane JSB_Ventas;
    private rojerusan.RSTableMetro JTBL_Ventas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage1;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage2;
    // End of variables declaration//GEN-END:variables
}
