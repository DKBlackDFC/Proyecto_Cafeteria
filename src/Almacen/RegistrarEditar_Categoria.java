/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import Alertas.Alerta_Error;
import Alertas.Alerta_Exito;
import Alertas.Alerta_Advertencia;
import Base_De_Datos.Construcciones.Categorias;
import Base_De_Datos.Implementaciones.DAOCategoriasImpI;
import Base_De_Datos.interfaces.DAOCategorias;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import necesario.RSAWTUtilities;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author DIEGO
 */
public class RegistrarEditar_Categoria extends javax.swing.JDialog {
    
    private static int id;
    private static boolean Registrar = true;

    private Alerta_Advertencia AA = new Alerta_Advertencia(new JFrame(), true);
    private Alerta_Error EA = new Alerta_Error(new JFrame(), true);
    private Alerta_Exito AE = new Alerta_Exito(new JFrame(), true);

    public RegistrarEditar_Categoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);

        this.JTBL_Categorias.setCursor(new Cursor(12));
        this.JSB_Categoria.getViewport().setBackground(Color.WHITE);
        this.JPOP_MenuTabla.add(this.JPNL_Menu);

        Limpiar_Campos();
        Agregar_Datos_Tabla("");
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
    private void Limpiar_Campos() {
        this.JTFL_Categoria.requestFocus();

        this.JTFL_Categoria.setText("");

        this.JBTN_Registrar.setIcon(new ImageIcon(this.getClass().getResource("/IMG/Almacen/Icono_Anadir.png")));
        this.JBTN_Registrar.setText("REGISTRAR");
        this.JBTN_Cancelar.setVisible(false);

        Registrar = true;
    }
    private boolean Verificar_Llenado() {
        if(this.JTFL_Categoria.getText().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    private void Agregar_Datos_Tabla(String cadena){
        DAOCategorias metodos = new DAOCategoriasImpI();
        String[] datos = new String[1];
        
        try{
            List<Categorias> datosCategorias = metodos.Listar(cadena);
            
            DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Categorias.getModel();
            
            while(modeloTabla.getRowCount() > 0){
                modeloTabla.removeRow(0);
            }
            
            for(int i = 0;i < datosCategorias.size();i++){
                datos[0] = datosCategorias.get(i).getNombre();
               
                modeloTabla.addRow(datos);
            }
        }catch(Exception ex){
            EA.JLBL_Mensaje1.setText("Error al cargar datos a la");
            EA.JLBL_Mensaje2.setText("tabla de la base de datos");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPNL_Menu = new javax.swing.JPanel();
        JBTN_Eliminar = new rojeru_san.RSButtonRiple();
        JBTN_Editar = new rojeru_san.RSButtonRiple();
        JPOP_MenuTabla = new rojerusan.RSPopuMenu();
        JPNL_Shadow = new rojeru_san.RSPanelShadow();
        JPNL_Fondo = new javax.swing.JPanel();
        JNPL_Encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBTN_Cerrar = new rojeru_san.RSButtonRiple();
        JPNL_Control = new javax.swing.JPanel();
        JTFL_Buscar = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        JTFL_Categoria = new rojeru_san.rsfield.RSTextMaterial();
        JBTN_Registrar = new rojeru_san.RSButtonRiple();
        JBTN_Cancelar = new rojeru_san.RSButtonRiple();
        JPNL_Tabla = new javax.swing.JPanel();
        JSB_Categoria = new javax.swing.JScrollPane();
        JTBL_Categorias = new rojerusan.RSTableMetro();

        JPNL_Menu.setBackground(new java.awt.Color(255, 255, 255));

        JBTN_Eliminar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Eliminar.png"))); // NOI18N
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
        JBTN_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Editar.png"))); // NOI18N
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        JPNL_Fondo.setBackground(new java.awt.Color(255, 255, 255));

        JNPL_Encabezado.setBackground(new java.awt.Color(34, 41, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CATEGORÍAS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Categoria.png"))); // NOI18N

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
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
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

        JPNL_Control.setBackground(new java.awt.Color(255, 255, 255));

        JTFL_Buscar.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Buscar.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.setPlaceholder("Buscar...");
        JTFL_Buscar.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_BuscarKeyReleased(evt);
            }
        });

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Buscar.png"))); // NOI18N

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_EditarCategoria.png"))); // NOI18N

        JTFL_Categoria.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Categoria.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Categoria.setPlaceholder("Nombre de la categoría");
        JTFL_Categoria.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_CategoriaKeyReleased(evt);
            }
        });

        JBTN_Registrar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Anadir.png"))); // NOI18N
        JBTN_Registrar.setText("REGISTRAR");
        JBTN_Registrar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Registrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Registrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_RegistrarActionPerformed(evt);
            }
        });

        JBTN_Cancelar.setBackground(new java.awt.Color(255, 68, 68));
        JBTN_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Cancelar.png"))); // NOI18N
        JBTN_Cancelar.setText("CANCELAR");
        JBTN_Cancelar.setColorHover(new java.awt.Color(255, 100, 100));
        JBTN_Cancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPNL_ControlLayout = new javax.swing.GroupLayout(JPNL_Control);
        JPNL_Control.setLayout(JPNL_ControlLayout);
        JPNL_ControlLayout.setHorizontalGroup(
            JPNL_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_ControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_ControlLayout.createSequentialGroup()
                        .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFL_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                    .addGroup(JPNL_ControlLayout.createSequentialGroup()
                        .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFL_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBTN_Registrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPNL_ControlLayout.setVerticalGroup(
            JPNL_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_ControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPNL_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFL_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTN_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JSB_Categoria.setBackground(new java.awt.Color(255, 255, 255));

        JTBL_Categorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"001"},
                {"002"}
            },
            new String [] {
                "CATEGORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_Categorias.setAltoHead(30);
        JTBL_Categorias.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_Categorias.setColorBordeFilas(new java.awt.Color(109, 109, 109));
        JTBL_Categorias.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_Categorias.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_Categorias.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_Categorias.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_Categorias.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_Categorias.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_Categorias.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Categorias.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Categorias.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Categorias.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_Categorias.setGrosorBordeFilas(0);
        JTBL_Categorias.setGrosorBordeHead(0);
        JTBL_Categorias.setRowHeight(30);
        JTBL_Categorias.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_Categorias.getTableHeader().setReorderingAllowed(false);
        JTBL_Categorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_CategoriasMouseClicked(evt);
            }
        });
        JSB_Categoria.setViewportView(JTBL_Categorias);

        javax.swing.GroupLayout JPNL_TablaLayout = new javax.swing.GroupLayout(JPNL_Tabla);
        JPNL_Tabla.setLayout(JPNL_TablaLayout);
        JPNL_TablaLayout.setHorizontalGroup(
            JPNL_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSB_Categoria)
        );
        JPNL_TablaLayout.setVerticalGroup(
            JPNL_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JPNL_FondoLayout = new javax.swing.GroupLayout(JPNL_Fondo);
        JPNL_Fondo.setLayout(JPNL_FondoLayout);
        JPNL_FondoLayout.setHorizontalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPNL_Control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPNL_FondoLayout.setVerticalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_FondoLayout.createSequentialGroup()
                .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPNL_Control, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
            .addComponent(JPNL_Shadow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBTN_CerrarActionPerformed

    private void JTFL_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_BuscarKeyReleased
        Agregar_Datos_Tabla(JTFL_Buscar.getText());
    }//GEN-LAST:event_JTFL_BuscarKeyReleased

    private void JTFL_CategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_CategoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_CategoriaKeyReleased

    private void JBTN_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_RegistrarActionPerformed
        if(Verificar_Llenado()){
            if(Registrar){
                DAOCategorias metodos = new DAOCategoriasImpI();
                try{
                    if(!metodos.Existe_Categoria(this.JTFL_Categoria.getText())){
                        Categorias modelo = new Categorias();
                        
                        modelo.setNombre(this.JTFL_Categoria.getText());
                        
                        try{
                            metodos.Registrar(modelo);
                            
                            Limpiar_Campos();
                            Agregar_Datos_Tabla("");
                            
                            AE.JLBL_Mensaje1.setText("Categoría registrada exitosamente");
                            AE.JLBL_Mensaje2.setText("");
                            AE.JLBL_Mensaje3.setText("");
                            AE.setVisible(true);
                        }catch(Exception ex){
                            EA.JLBL_Mensaje1.setText("Error al registrar la nueva");
                            EA.JLBL_Mensaje2.setText("categoría");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                            System.out.println(ex.getMessage());
                        }
                    }else{
                        EA.JLBL_Mensaje1.setText("La categoría que intentas");
                        EA.JLBL_Mensaje2.setText("registrar ya existe");
                        EA.JLBL_Mensaje3.setText("");
                        EA.setVisible(true);
                    }
                }catch(Exception ex){
                    EA.JLBL_Mensaje1.setText("Error al exgraer información");
                    EA.JLBL_Mensaje2.setText("de la base de datos");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                    System.out.println(ex.getMessage());
                }
            }else{
                DAOCategorias metodos = new DAOCategoriasImpI();
                Categorias modelo = new Categorias();
                
                modelo.setId(id);
                modelo.setNombre(this.JTFL_Categoria.getText());
                
                try{
                    metodos.Modificar(modelo);
                    
                    Limpiar_Campos();
                    Agregar_Datos_Tabla("");
                    
                    AE.JLBL_Mensaje1.setText("Categoría modificada");
                    AE.JLBL_Mensaje2.setText("exitosamente");
                    AE.JLBL_Mensaje3.setText("");
                    AE.setVisible(true);
                }catch(Exception ex){
                    EA.JLBL_Mensaje1.setText("Error al modificar la categoría");
                    EA.JLBL_Mensaje2.setText("en la base de datos");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                    System.out.println(ex.getMessage());
                }
            }
        }else{
            Limpiar_Campos();

            EA.JLBL_Mensaje1.setText("Todos los campos son requeridos");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }//GEN-LAST:event_JBTN_RegistrarActionPerformed

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
        Limpiar_Campos();
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

    private void JBTN_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EliminarActionPerformed
        int filaSeleccionada = this.JTBL_Categorias.getSelectedRow();
        this.JPOP_MenuTabla.setVisible(false);
        String nombre = this.JTBL_Categorias.getValueAt(filaSeleccionada, 0).toString();
        DAOCategorias metodos = new DAOCategoriasImpI();
        Categorias modelo = new Categorias();
        
        AA.JLBL_Mensaje1.setText("Se eliminará la categoría " + nombre);
        AA.JLBL_Mensaje2.setText("de forma permanente");
        AA.JLBL_Mensaje3.setText("");
        AA.setVisible(true);
        
        if(AA.hecho){
            modelo.setNombre(nombre);
            
            try{
                metodos.Eliminar(modelo);
                
                Limpiar_Campos();
                Agregar_Datos_Tabla("");
                
                AE.JLBL_Mensaje1.setText("Categoría eliminada exitosamente");
                AE.JLBL_Mensaje2.setText("");
                AE.JLBL_Mensaje3.setText("");
                AE.setVisible(true);
            }catch(Exception ex){
                EA.JLBL_Mensaje1.setText("No se pudo eliminar la categoría");
                EA.JLBL_Mensaje2.setText("de la base de datos");
                EA.JLBL_Mensaje3.setText("");
                EA.setVisible(true);
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_JBTN_EliminarActionPerformed

    private void JBTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EditarActionPerformed
        int filaSeleccionada = this.JTBL_Categorias.getSelectedRow();
        this.JPOP_MenuTabla.setVisible(false);
        String nombre = this.JTBL_Categorias.getValueAt(filaSeleccionada, 0).toString();
        
        DAOCategorias metodos = new DAOCategoriasImpI();
        Categorias modelo = new Categorias();
        
        this.JBTN_Cancelar.setVisible(true);
        this.JBTN_Registrar.setText("GUARDAR");
        this.JBTN_Registrar.setIcon(new ImageIcon(this.getClass().getResource("/IMG/Almacen/Icono_Salvar.png")));
        Registrar = false;
        
        try{
            modelo = metodos.Extraer_Categoria(nombre);
            this.id = modelo.getId();
            
            this.JTFL_Categoria.setText(modelo.getNombre());
        }catch(Exception ex){
            EA.JLBL_Mensaje1.setText("Error al extraer la categoría");
            EA.JLBL_Mensaje2.setText("de la base de datos");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
            Registrar = true;
            Limpiar_Campos();
        }
    }//GEN-LAST:event_JBTN_EditarActionPerformed

    private void JTBL_CategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_CategoriasMouseClicked
        int row = JTBL_Categorias.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.JTBL_Categorias.setRowSelectionInterval(row, row);
            //PosicionMouse = evt.getY() / 16;
            JPOP_MenuTabla.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.JTBL_Categorias.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_JTBL_CategoriasMouseClicked

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
            java.util.logging.Logger.getLogger(RegistrarEditar_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEditar_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEditar_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEditar_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                RegistrarEditar_Categoria dialog = new RegistrarEditar_Categoria(new javax.swing.JFrame(), true);
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
    public static rojeru_san.RSButtonRiple JBTN_Cancelar;
    private rojeru_san.RSButtonRiple JBTN_Cerrar;
    private rojeru_san.RSButtonRiple JBTN_Editar;
    private rojeru_san.RSButtonRiple JBTN_Eliminar;
    public static rojeru_san.RSButtonRiple JBTN_Registrar;
    private javax.swing.JPanel JNPL_Encabezado;
    private javax.swing.JPanel JPNL_Control;
    private javax.swing.JPanel JPNL_Fondo;
    private javax.swing.JPanel JPNL_Menu;
    private rojeru_san.RSPanelShadow JPNL_Shadow;
    private javax.swing.JPanel JPNL_Tabla;
    private rojerusan.RSPopuMenu JPOP_MenuTabla;
    private javax.swing.JScrollPane JSB_Categoria;
    private rojerusan.RSTableMetro JTBL_Categorias;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Buscar;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    // End of variables declaration//GEN-END:variables
}
