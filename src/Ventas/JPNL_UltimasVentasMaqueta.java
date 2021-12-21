/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Alertas.Alerta_Advertencia;
import Alertas.Alerta_Error;
import Alertas.Alerta_Exito;
import Base_De_Datos.Construcciones.Ventas;
import Base_De_Datos.Implementaciones.DAOVentasImpI;
import Base_De_Datos.interfaces.DAOVentas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class JPNL_UltimasVentasMaqueta extends javax.swing.JPanel {
    
    public JPNL_UltimasVentasMaqueta() {
        initComponents();
        
        this.JTBL_UltimasVentas.setCursor(new Cursor(12));
        this.JSB_UltimasVentas.getViewport().setBackground(Color.WHITE);
        this.JPOP_MenuTabla.add(JPNL_Menu);
        
        Agregar_Datos_Cadena("");
    }

    private void Agregar_Datos_Cadena(String cadena){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_UltimasVentas.getModel();
        DAOVentas metodos = new DAOVentasImpI();
        List<Ventas> datosVentas = new ArrayList();
        String[] datos = new String[8];
        
        while(modeloTabla.getRowCount() > 0){
            modeloTabla.removeRow(0);
        }
        
        try{
            datosVentas = metodos.Listar(cadena);
            
            for(int i = 0;i < datosVentas.size();i++){
                datos[0] = String.valueOf(datosVentas.get(i).getId());
                datos[1] = datosVentas.get(i).getNumero_venta();
                datos[2] = datosVentas.get(i).getProducto();
                datos[3] = String.format("%.2f", datosVentas.get(i).getCantidad());
                datos[4] = String.format("%.2f", datosVentas.get(i).getPrecio());
                datos[5] = String.format("%.2f", datosVentas.get(i).getTotal());
                datos[6] = datosVentas.get(i).getCajero();
                datos[7] = datosVentas.get(i).getFecha();
                
                modeloTabla.addRow(datos);
            }
        }catch(Exception ex){
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("Error al extraer productos de");
            EA.JLBL_Mensaje2.setText("la base de datos.");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
        }
    }
    private void Agregar_Datos_Fecha(String fecha){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_UltimasVentas.getModel();
        DAOVentas metodos = new DAOVentasImpI();
        List<Ventas> datosVentas = new ArrayList();
        String[] datos = new String[8];
        
        while(modeloTabla.getRowCount() > 0){
            modeloTabla.removeRow(0);
        }
        
        try{
            datosVentas = metodos.Listar_Rango(fecha, fecha);
            
            for(int i = 0;i < datosVentas.size();i++){
                datos[0] = String.valueOf(datosVentas.get(i).getId());
                datos[1] = datosVentas.get(i).getNumero_venta();
                datos[2] = datosVentas.get(i).getProducto();
                datos[3] = String.format("%.2f", datosVentas.get(i).getCantidad());
                datos[4] = String.format("%.2f", datosVentas.get(i).getPrecio());
                datos[5] = String.format("%.2f", datosVentas.get(i).getTotal());
                datos[6] = datosVentas.get(i).getCajero();
                datos[7] = datosVentas.get(i).getFecha();
                
                modeloTabla.addRow(datos);
            }
        }catch(Exception ex){
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("Error al extraer productos de");
            EA.JLBL_Mensaje2.setText("la base de datos.");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOP_MenuTabla = new rojerusan.RSPopuMenu();
        JPNL_Menu = new javax.swing.JPanel();
        JBTN_Eliminar = new rojeru_san.RSButtonRiple();
        jPanel1 = new javax.swing.JPanel();
        JPNL_Encabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JTFL_Buscar = new rojeru_san.rsfield.RSTextMaterial();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JBTN_Consultar = new rojeru_san.RSButtonRiple();
        JDCH_Fecha = new newscomponents.RSDateChooser();
        jPanel3 = new javax.swing.JPanel();
        JSB_UltimasVentas = new javax.swing.JScrollPane();
        JTBL_UltimasVentas = new rojerusan.RSTableMetro();

        JPNL_Menu.setBackground(new java.awt.Color(255, 255, 255));
        JPNL_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBTN_Eliminar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Eliminar.png"))); // NOI18N
        JBTN_Eliminar.setText("ELIMINAR");
        JBTN_Eliminar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Eliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_EliminarActionPerformed(evt);
            }
        });
        JPNL_Menu.add(JBTN_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JPNL_Encabezado.setBackground(new java.awt.Color(236, 236, 236));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 23, 37));
        jLabel3.setText("ÚLTIMAS VENTAS");

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        JTFL_Buscar.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Buscar.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.setPlaceholder("Buscar...");
        JTFL_Buscar.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_BuscarKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Buscar.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(34, 41, 50));

        JBTN_Consultar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Reportes.png"))); // NOI18N
        JBTN_Consultar.setText("CONSULTAR");
        JBTN_Consultar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Consultar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Consultar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_ConsultarJBTN_ConsultarActionPerformed(evt);
            }
        });

        JDCH_Fecha.setBackground(new java.awt.Color(34, 41, 50));
        JDCH_Fecha.setBgColor(new java.awt.Color(34, 41, 50));
        JDCH_Fecha.setFormatDate("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(JDCH_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBTN_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(JBTN_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(JDCH_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        JSB_UltimasVentas.setBackground(new java.awt.Color(255, 255, 255));

        JTBL_UltimasVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "CODIGO DE VENTA", "PRODUCTO", "CANTIDAD", "PRECIO", "TOTAL", "CAJERO", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_UltimasVentas.setAltoHead(30);
        JTBL_UltimasVentas.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_UltimasVentas.setColorBordeFilas(new java.awt.Color(109, 109, 109));
        JTBL_UltimasVentas.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_UltimasVentas.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_UltimasVentas.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_UltimasVentas.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_UltimasVentas.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_UltimasVentas.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_UltimasVentas.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_UltimasVentas.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_UltimasVentas.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_UltimasVentas.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_UltimasVentas.setGrosorBordeFilas(0);
        JTBL_UltimasVentas.setGrosorBordeHead(0);
        JTBL_UltimasVentas.setRowHeight(30);
        JTBL_UltimasVentas.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_UltimasVentas.getTableHeader().setReorderingAllowed(false);
        JTBL_UltimasVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_UltimasVentasMouseClicked(evt);
            }
        });
        JSB_UltimasVentas.setViewportView(JTBL_UltimasVentas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSB_UltimasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSB_UltimasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JPNL_Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JPNL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTFL_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_BuscarKeyReleased
        Agregar_Datos_Cadena(this.JTFL_Buscar.getText());
    }//GEN-LAST:event_JTFL_BuscarKeyReleased

    private void JBTN_ConsultarJBTN_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_ConsultarJBTN_ConsultarActionPerformed
        SimpleDateFormat formateador = new SimpleDateFormat("YYYY-MM-dd");
            
        String fecha = String.valueOf(formateador.format(this.JDCH_Fecha.getDate()));
        
        Agregar_Datos_Fecha(fecha);
    }//GEN-LAST:event_JBTN_ConsultarJBTN_ConsultarActionPerformed

    private void JTBL_UltimasVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_UltimasVentasMouseClicked
        int row = JTBL_UltimasVentas.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.JTBL_UltimasVentas.setRowSelectionInterval(row, row);
            //PosicionMouse = evt.getY() / 16;
            JPOP_MenuTabla.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.JTBL_UltimasVentas.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_JTBL_UltimasVentasMouseClicked

    private void JBTN_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EliminarActionPerformed
        int filaSeleccionada = this.JTBL_UltimasVentas.getSelectedRow();
        this.JPOP_MenuTabla.setVisible(false);
        String codigo = this.JTBL_UltimasVentas.getValueAt(filaSeleccionada, 0).toString();
        DAOVentas metodos = new DAOVentasImpI();
        
        Alerta_Advertencia WA = new Alerta_Advertencia(new JFrame(),true);
        WA.JLBL_Mensaje1.setText("Se eliminará el registro seleccionado");
        WA.JLBL_Mensaje2.setText("de forma permanente.");
        WA.JLBL_Mensaje3.setText("");
        WA.setVisible(true);
        
        if(WA.hecho){
            try{
                metodos.Eliminar(codigo);
                
                Agregar_Datos_Cadena("");
                
                Alerta_Exito SA = new Alerta_Exito(new JFrame(),true);
                SA.JLBL_Mensaje1.setText("Producto eliminado exitosamente");
                SA.JLBL_Mensaje2.setText("");
                SA.JLBL_Mensaje3.setText("");
                SA.setVisible(true);
            }catch(Exception ex){
                Alerta_Error EA = new Alerta_Error(new JFrame(),true);
                EA.JLBL_Mensaje1.setText("Error al eliminar información del");
                EA.JLBL_Mensaje2.setText("producto seleccionado");
                EA.JLBL_Mensaje3.setText("");
                EA.setVisible(true);
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_JBTN_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_Consultar;
    private rojeru_san.RSButtonRiple JBTN_Eliminar;
    private newscomponents.RSDateChooser JDCH_Fecha;
    private javax.swing.JPanel JPNL_Encabezado;
    private javax.swing.JPanel JPNL_Menu;
    private rojerusan.RSPopuMenu JPOP_MenuTabla;
    private javax.swing.JScrollPane JSB_UltimasVentas;
    public static rojerusan.RSTableMetro JTBL_UltimasVentas;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Buscar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
