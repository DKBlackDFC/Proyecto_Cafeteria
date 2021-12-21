/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Alertas.Alerta_Error;
import Base_De_Datos.Construcciones.Almacen;
import Base_De_Datos.Implementaciones.DAOAlmacenImpI;
import Base_De_Datos.interfaces.DAOAlmacen;
import Utilidades.Verificaciones_Converciones;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class Agregar_Producto_Sin_Codigo extends javax.swing.JDialog {
    
    public static Almacen producto;
    public static double cantidad;
    public static boolean continuar;
    public static boolean precio_mayoreo;
    public static List<String> codigos = new ArrayList();
    
    public Agregar_Producto_Sin_Codigo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setMoverVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        
        this.JTBL_Almacen.setCursor(new Cursor(12));
        this.JSB_Almacen.getViewport().setBackground(Color.WHITE);
        
        Agregar_Datos_Tabla("");
        addEventKey();
    }
    
    private void addEventKey(){
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        //---------------------------------------------------------------------------------
        KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false);
        Action f1Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Agregar_Producto();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f1, "F1");
        getRootPane().getActionMap().put("F1", f1Action);
    }    
    private void Agregar_Datos_Tabla(String cadena){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Almacen.getModel();
        DAOAlmacen metodos = new DAOAlmacenImpI();
        List<Almacen> datosAlmacen = new ArrayList();
        String[] datos = new String[7];
        
        while(modeloTabla.getRowCount() > 0){
            modeloTabla.removeRow(0);
        }
        
        try{
            datosAlmacen = metodos.Listar(cadena);
            
            for(int i = 0;i < datosAlmacen.size();i++){
                datos[0] = String.valueOf(datosAlmacen.get(i).getId());
                datos[1] = datosAlmacen.get(i).getCategoria();
                datos[2] = datosAlmacen.get(i).getDescripcion();
                datos[3] = String.format("%.2f", datosAlmacen.get(i).getPrecioCompra());
                datos[4] = String.format("%.2f", datosAlmacen.get(i).getPrecioVenta());
                
                if(datosAlmacen.get(i).getUnidad_venta().equals("Kg")
                    || datosAlmacen.get(i).getUnidad_venta().equals("Litros")
                    || datosAlmacen.get(i).getUnidad_venta().equals("Mililitros")){
                    
                    datos[5] = String.format("%.2f", datosAlmacen.get(i).getExistencias());
                    
                }else{
                    datos[5] = String.format("%.0f", datosAlmacen.get(i).getExistencias());
                }
                
                datos[6] = datosAlmacen.get(i).getUnidad_venta();
                
                modeloTabla.addRow(datos);
            }
        }catch(Exception ex){
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("Error al extraer productos de");
            EA.JLBL_Mensaje2.setText("la base de datos");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        JPNL_Principal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JBTN_Cerrar = new rojeru_san.RSButtonRiple();
        JPNL_Tabla = new javax.swing.JPanel();
        JSB_Almacen = new javax.swing.JScrollPane();
        JTBL_Almacen = new rojerusan.RSTableMetro();
        JPLN_Controles = new javax.swing.JPanel();
        JTFL_Buscar = new rojeru_san.rsfield.RSTextMaterial();
        jLabel3 = new javax.swing.JLabel();
        JBTN_Agregar = new rojeru_san.RSButtonRiple();
        JTFL_Cantidad = new rojeru_san.rsfield.RSTextMaterial();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        JPNL_Principal.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(34, 41, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR PRODUCTO");

        JBTN_Cerrar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Alertas/Icono_Salir.png"))); // NOI18N
        JBTN_Cerrar.setColorHover(new java.awt.Color(34, 41, 50));
        JBTN_Cerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JBTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTN_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPNL_Tabla.setBackground(new java.awt.Color(255, 255, 255));

        JSB_Almacen.setBackground(new java.awt.Color(255, 255, 255));

        JTBL_Almacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CATEGORIAS", "DESCRIPCION", "PRECIO DE COMPRA", "PRECIO DE VENTA", "EXISTENCIAS", "UNIDAD DE VENTA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_Almacen.setAltoHead(30);
        JTBL_Almacen.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_Almacen.setColorBordeFilas(new java.awt.Color(109, 109, 109));
        JTBL_Almacen.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_Almacen.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_Almacen.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_Almacen.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_Almacen.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_Almacen.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_Almacen.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Almacen.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Almacen.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Almacen.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_Almacen.setGrosorBordeFilas(0);
        JTBL_Almacen.setGrosorBordeHead(0);
        JTBL_Almacen.setRowHeight(30);
        JTBL_Almacen.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_Almacen.getTableHeader().setReorderingAllowed(false);
        JTBL_Almacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_AlmacenMouseClicked(evt);
            }
        });
        JSB_Almacen.setViewportView(JTBL_Almacen);

        javax.swing.GroupLayout JPNL_TablaLayout = new javax.swing.GroupLayout(JPNL_Tabla);
        JPNL_Tabla.setLayout(JPNL_TablaLayout);
        JPNL_TablaLayout.setHorizontalGroup(
            JPNL_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_TablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSB_Almacen)
                .addContainerGap())
        );
        JPNL_TablaLayout.setVerticalGroup(
            JPNL_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_TablaLayout.createSequentialGroup()
                .addComponent(JSB_Almacen, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPLN_Controles.setBackground(new java.awt.Color(255, 255, 255));

        JTFL_Buscar.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Buscar.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.setPlaceholder("Buscar...");
        JTFL_Buscar.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_BuscarKeyReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Buscar.png"))); // NOI18N

        JBTN_Agregar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Anadir.png"))); // NOI18N
        JBTN_Agregar.setText("AGREGAR PRODUCTO (F1)");
        JBTN_Agregar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Agregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Agregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_AgregarActionPerformed(evt);
            }
        });

        JTFL_Cantidad.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Cantidad.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Cantidad.setPlaceholder("Cantidad");
        JTFL_Cantidad.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Cantidad.setSoloNumeros(true);
        JTFL_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_CantidadKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Existencias.png"))); // NOI18N

        javax.swing.GroupLayout JPLN_ControlesLayout = new javax.swing.GroupLayout(JPLN_Controles);
        JPLN_Controles.setLayout(JPLN_ControlesLayout);
        JPLN_ControlesLayout.setHorizontalGroup(
            JPLN_ControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLN_ControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFL_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        JPLN_ControlesLayout.setVerticalGroup(
            JPLN_ControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLN_ControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPLN_ControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(JPLN_ControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBTN_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTFL_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPNL_PrincipalLayout = new javax.swing.GroupLayout(JPNL_Principal);
        JPNL_Principal.setLayout(JPNL_PrincipalLayout);
        JPNL_PrincipalLayout.setHorizontalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPLN_Controles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPNL_PrincipalLayout.setVerticalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_PrincipalLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPLN_Controles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(JPNL_Principal, java.awt.BorderLayout.CENTER);

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

    private void JBTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CerrarActionPerformed
        continuar = false;
        this.dispose();
    }//GEN-LAST:event_JBTN_CerrarActionPerformed

    private void JTFL_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_BuscarKeyReleased
        Agregar_Datos_Tabla(this.JTFL_Buscar.getText());
    }//GEN-LAST:event_JTFL_BuscarKeyReleased

    private void JBTN_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_AgregarActionPerformed
        Agregar_Producto();
    }//GEN-LAST:event_JBTN_AgregarActionPerformed

    private void JTBL_AlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_AlmacenMouseClicked
        
    }//GEN-LAST:event_JTBL_AlmacenMouseClicked

    private void JTFL_CantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_CantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_CantidadKeyReleased

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
            java.util.logging.Logger.getLogger(Agregar_Producto_Sin_Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Producto_Sin_Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Producto_Sin_Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Producto_Sin_Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agregar_Producto_Sin_Codigo dialog = new Agregar_Producto_Sin_Codigo(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple JBTN_Agregar;
    private rojeru_san.RSButtonRiple JBTN_Cerrar;
    private javax.swing.JPanel JPLN_Controles;
    private javax.swing.JPanel JPNL_Principal;
    private javax.swing.JPanel JPNL_Tabla;
    private javax.swing.JScrollPane JSB_Almacen;
    private rojerusan.RSTableMetro JTBL_Almacen;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Buscar;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
    private void Agregar_Producto(){
        int filaSeleccionada = this.JTBL_Almacen.getSelectedRow();
        if(filaSeleccionada > -1){
            DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Almacen.getModel();
            boolean existe = false;
            
            for(int i = 0;i < codigos.size();i++){
                if(modeloTabla.getValueAt(filaSeleccionada,0).toString().equals(codigos.get(i))){
                    existe = true;
                    break;
                }
            }
            
            if(!existe){
                DAOAlmacen metodosAlmacen = new DAOAlmacenImpI();
            
                try{
                    producto = metodosAlmacen.Extraer_Datos(modeloTabla.getValueAt(filaSeleccionada,0).toString());

                    if(Unidad_Venta(producto.getUnidad_venta())){
                        if(!this.JTFL_Cantidad.getText().isEmpty()){
                            double cantidadLocal = Double.parseDouble(this.JTFL_Cantidad.getText());
                            if((producto.getExistencias()-cantidadLocal) >= 0){
                                cantidad = cantidadLocal;
                                continuar = true;
                                this.dispose();
                            }else{
                                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Existencias insuficientes.");
                                EA.JLBL_Mensaje2.setText("");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                            }
                        }else{
                            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                            EA.JLBL_Mensaje1.setText("Debe ingresar una cantidad válida.");
                            EA.JLBL_Mensaje2.setText("");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                        }
                    }else{
                        if(!this.JTFL_Cantidad.getText().isEmpty()){
                            double cantidadLocal = Double.parseDouble(this.JTFL_Cantidad.getText());
                            if(Verificaciones_Converciones.Verificar_Entero(this.JTFL_Cantidad.getText())){
                                if((producto.getExistencias()-cantidadLocal) >= 0){
                                    cantidad = cantidadLocal;
                                    continuar = true;
                                    this.dispose();
                                }else{
                                    Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                                    EA.JLBL_Mensaje1.setText("Existencias insuficientes.");
                                    EA.JLBL_Mensaje2.setText("");
                                    EA.JLBL_Mensaje3.setText("");
                                    EA.setVisible(true);
                                }
                            }else{
                                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Cantidad inválidad para la unidad de");
                                EA.JLBL_Mensaje2.setText("venta de este producto.");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                            }
                        }else{
                            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                            EA.JLBL_Mensaje1.setText("Debe ingresar una cantidad válida.");
                            EA.JLBL_Mensaje2.setText("");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                        }    
                    }
                }catch(Exception ex){
                    Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                    EA.JLBL_Mensaje1.setText("Error al extraer información de la");
                    EA.JLBL_Mensaje2.setText("base de datos.");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                    System.out.println(ex.getMessage());
                }
            }else{
                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                EA.JLBL_Mensaje1.setText("El producto seleccionado ya existe");
                EA.JLBL_Mensaje2.setText("dentro de la venta.");
                EA.JLBL_Mensaje3.setText("");
                EA.setVisible(true);
            }
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No ha seleccionado ningún producto");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }
    private boolean Unidad_Venta(String unidad_venta){
        if(unidad_venta.equals("Kg") || unidad_venta.equals("Litros") || unidad_venta.equals("Mililitros")){
            return  true;
        }else{
            return false;
        }
    }
}
