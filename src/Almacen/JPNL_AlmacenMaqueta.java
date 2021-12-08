/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

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

public class JPNL_AlmacenMaqueta extends javax.swing.JPanel {
    
    public JPNL_AlmacenMaqueta() {
        initComponents();
    }
    
    private void addEventKey(){

        KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false);
        Action f1Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new RegistrarEditar_Producto(new JFrame(), true).setVisible(true);
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f1, "F1");
        this.getActionMap().put("F1", f1Action);

        //---------------------------------------------------------------------------
        KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, false);
        Action f2Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new RegistrarEditar_Categoria(new JFrame(), true).setVisible(true);
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f2, "F2");
        this.getActionMap().put("F2", f2Action);

        //--------------------------------------------------------------------------------
        KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0, false);
        Action f5Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new Imprimir_Almacen(new JFrame(), true).setVisible(true);
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f5, "F5");
        this.getActionMap().put("F5", f5Action);
    }
    private void Agregar_Datos_Tabla(String cadena){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Almacen.getModel();
        DAOAlmacen metodos = new DAOAlmacenImpI();
        List<Almacen> datosAlmacen = new ArrayList();
        String[] datos = new String[11];
        
        while(modeloTabla.getRowCount() > 0){
            modeloTabla.removeRow(0);
        }
        
        try{
            datosAlmacen = metodos.Listar(cadena);
            
            for(int i = 0;i < datosAlmacen.size();i++){
                datos[0] = datosAlmacen.get(i).getCodigo();
                datos[1] = datosAlmacen.get(i).getCategoria();
                datos[2] = datosAlmacen.get(i).getDescripcion();
                datos[3] = String.format("%.2f", datosAlmacen.get(i).getPrecio());
                datos[4] = String.format("%.2f", datosAlmacen.get(i).getGanancia_menudeo());
                datos[5] = String.format("%.2f", datosAlmacen.get(i).getGanancia_mayoreo());
                datos[6] = String.format("%.2f", datosAlmacen.get(i).getPrecio_venta_menudeo());
                datos[7] = String.format("%.2f", datosAlmacen.get(i).getPrecio_venta_mayoreo());
                
                if(datosAlmacen.get(i).getUnidad_venta().equals("Kg")
                    || datosAlmacen.get(i).getUnidad_venta().equals("Litros")
                    || datosAlmacen.get(i).getUnidad_venta().equals("Metros")){
                    
                    datos[8] = String.format("%.2f", datosAlmacen.get(i).getExistencias());
                    
                }else{
                    datos[8] = String.format("%.0f", datosAlmacen.get(i).getExistencias());
                }
                
                datos[9] = datosAlmacen.get(i).getUnidad_venta();
                datos[10] = datosAlmacen.get(i).getUbicacion();
                
                modeloTabla.addRow(datos);
            }
        }catch(Exception ex){
            ErrorAlert EA = new ErrorAlert(new JFrame(),true);
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

        JPOP_MenuTabla = new rojerusan.RSPopuMenu();
        JPNL_Menu = new javax.swing.JPanel();
        JBTN_Eliminar = new rojeru_san.RSButtonRiple();
        JBTN_Editar = new rojeru_san.RSButtonRiple();
        JPNL_Pincipal = new javax.swing.JPanel();
        JPNL_Tabla = new javax.swing.JPanel();
        JSB_Almacen = new javax.swing.JScrollPane();
        JTBL_Almacen = new rojerusan.RSTableMetro();
        JBTN_Nuevo = new rojeru_san.RSButtonRiple();
        jLabel3 = new javax.swing.JLabel();
        JBTN_Categorias = new rojeru_san.RSButtonRiple();
        JBTN_Imprimir = new rojeru_san.RSButtonRiple();
        JTFL_Buscar = new rojeru_san.rsfield.RSTextMaterial();
        jSeparator1 = new javax.swing.JSeparator();

        JPNL_Menu.setBackground(new java.awt.Color(255, 255, 255));

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

        JBTN_Editar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventas/Icono_Editar.png"))); // NOI18N
        JBTN_Editar.setText("EDITAR");
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
            .addComponent(JBTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(JBTN_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JPNL_MenuLayout.setVerticalGroup(
            JPNL_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_MenuLayout.createSequentialGroup()
                .addComponent(JBTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JBTN_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1175, 630));

        JPNL_Pincipal.setBackground(new java.awt.Color(255, 255, 255));

        JPNL_Tabla.setBackground(new java.awt.Color(255, 255, 255));

        JSB_Almacen.setBackground(new java.awt.Color(255, 255, 255));

        JTBL_Almacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCIÓN", "CATEGORÍA", "PRECIO DE COMPRA", "PRECIO DE VENTA", "EXISTENCIAS", "UNIDAD DE VENTA", "FECHA DE CADUCIDAD", "PROVEEDOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            .addComponent(JSB_Almacen)
        );
        JPNL_TablaLayout.setVerticalGroup(
            JPNL_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSB_Almacen, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        JBTN_Nuevo.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Nuevo.png"))); // NOI18N
        JBTN_Nuevo.setText("NUEVO (F1)");
        JBTN_Nuevo.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Nuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_NuevoActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Buscar.png"))); // NOI18N

        JBTN_Categorias.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Categorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Categoria.png"))); // NOI18N
        JBTN_Categorias.setText("CATEGORÍAS(F2)");
        JBTN_Categorias.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Categorias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Categorias.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CategoriasActionPerformed(evt);
            }
        });

        JBTN_Imprimir.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Impresion.png"))); // NOI18N
        JBTN_Imprimir.setText("EXOPORTAR REPORTE (F5)");
        JBTN_Imprimir.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Imprimir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_ImprimirActionPerformed(evt);
            }
        });

        JTFL_Buscar.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Buscar.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.setPlaceholder("Buscar...");
        JTFL_Buscar.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_BuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPNL_PincipalLayout = new javax.swing.GroupLayout(JPNL_Pincipal);
        JPNL_Pincipal.setLayout(JPNL_PincipalLayout);
        JPNL_PincipalLayout.setHorizontalGroup(
            JPNL_PincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPNL_PincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_PincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_PincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPNL_PincipalLayout.createSequentialGroup()
                        .addComponent(JBTN_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTN_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTN_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(532, Short.MAX_VALUE))
        );
        JPNL_PincipalLayout.setVerticalGroup(
            JPNL_PincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_PincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_PincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPNL_PincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTN_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTN_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTN_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(66, 63, 102));
        jSeparator1.setForeground(new java.awt.Color(66, 63, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPNL_Pincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_Pincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTBL_AlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_AlmacenMouseClicked
        
    }//GEN-LAST:event_JTBL_AlmacenMouseClicked

    private void JBTN_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EliminarActionPerformed
        
    }//GEN-LAST:event_JBTN_EliminarActionPerformed

    private void JBTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EditarActionPerformed
        
    }//GEN-LAST:event_JBTN_EditarActionPerformed

    private void JBTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_NuevoActionPerformed
        RegistrarEditar_Producto.Registrar = true;
        new RegistrarEditar_Producto(new JFrame(),true).setVisible(true);
        Agregar_Datos_Tabla("");
    }//GEN-LAST:event_JBTN_NuevoActionPerformed

    private void JBTN_CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CategoriasActionPerformed
        
    }//GEN-LAST:event_JBTN_CategoriasActionPerformed

    private void JBTN_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_ImprimirActionPerformed
        
    }//GEN-LAST:event_JBTN_ImprimirActionPerformed

    private void JTFL_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_BuscarKeyReleased
        
    }//GEN-LAST:event_JTFL_BuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_Categorias;
    private rojeru_san.RSButtonRiple JBTN_Editar;
    private rojeru_san.RSButtonRiple JBTN_Eliminar;
    private rojeru_san.RSButtonRiple JBTN_Imprimir;
    private rojeru_san.RSButtonRiple JBTN_Nuevo;
    private javax.swing.JPanel JPNL_Menu;
    private javax.swing.JPanel JPNL_Pincipal;
    private javax.swing.JPanel JPNL_Tabla;
    private rojerusan.RSPopuMenu JPOP_MenuTabla;
    private javax.swing.JScrollPane JSB_Almacen;
    public static rojerusan.RSTableMetro JTBL_Almacen;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Buscar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
