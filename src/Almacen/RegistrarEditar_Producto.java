/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import Alertas.Alerta_Error;
import Alertas.Alerta_Exito;
import Base_De_Datos.Construcciones.Almacen;
import Base_De_Datos.Construcciones.Categorias;
import Base_De_Datos.Implementaciones.DAOAlmacenImpI;
import Base_De_Datos.Implementaciones.DAOCategoriasImpI;
import Base_De_Datos.interfaces.DAOAlmacen;
import Base_De_Datos.interfaces.DAOCategorias;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import Utilidades.ToolTip;
import Utilidades.Verificaciones_Converciones;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import necesario.RSAWTUtilities;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author DIEGO
 */
public class RegistrarEditar_Producto extends javax.swing.JDialog {
    
    public static boolean Registrar = true;
    public static Almacen modeloGeneral = new Almacen();
    
    public RegistrarEditar_Producto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);

        if(Registrar){
            Modo_Registrar();
        }else{
            Modo_Editar();
        }
        Agregar_ToolTip();
        Llenar_Categorias();
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
    private void Modo_Registrar() {
        this.JTFL_Descripcion.setNextFocusableComponent(this.JTFL_PrecioCompra);
        this.JTFL_PrecioCompra.setNextFocusableComponent(this.JTFL_PrecioVenta);
        this.JTFL_PrecioVenta.setNextFocusableComponent(this.JTFL_Existencias);
        this.JTFL_Existencias.setNextFocusableComponent(this.JCBX_Unidades);
        this.JCBX_Unidades.setNextFocusableComponent(this.JDCH_FechaCaducidad);
        this.JDCH_FechaCaducidad.setNextFocusableComponent(this.JTFL_Proveedor);

        this.JTFL_Descripcion.setText("");
        this.JTFL_PrecioCompra.setText("");
        this.JTFL_PrecioVenta.setText("");
        this.JTFL_Existencias.setText("");
        this.JTFL_Proveedor.setText("");
        this.JCBX_Unidades.setSelectedIndex(0);
        this.JCBX_Categoria.setSelectedIndex(0);
        
        this.JLBL_Titulo.setText("REGISTRAR PRODUCTO");
        this.JBTN_Registrar.setText("REGISTRAR");
        this.JBTN_Registrar.setIcon(new ImageIcon(this.getClass().getResource("/IMG/Almacen/Icono_Anadir.png")));
        this.JBTN_Cancelar.setVisible(false);
    }
    private void Modo_Editar(){
        this.JLBL_Titulo.setText("EDITAR PRODUCTO");
        this.JBTN_Registrar.setText("GUARDAR");
        this.JBTN_Registrar.setIcon(new ImageIcon(this.getClass().getResource("/IMG/Almacen/Icono_Salvar.png")));
        this.JBTN_Cancelar.setVisible(true);
        
        this.JTFL_Descripcion.setText(modeloGeneral.getDescripcion());
        this.JTFL_PrecioCompra.setText(String.format("%.2f", modeloGeneral.getPrecioCompra()));
        this.JTFL_PrecioVenta.setText(String.format("%.2f", modeloGeneral.getPrecioVenta()));
        this.JTFL_Existencias.setText(String.format("%.2f", modeloGeneral.getExistencias()));
        this.JTFL_Proveedor.setText(modeloGeneral.getProveedor());
    }
    private boolean Verificar_Llenado(){
        if(this.JTFL_Descripcion.getText().isEmpty()
                || this.JTFL_PrecioCompra.getText().isEmpty()
                || this.JTFL_PrecioVenta.getText().isEmpty()
                || this.JTFL_Existencias.getText().isEmpty()
                || this.JCBX_Unidades.getSelectedItem().toString().equals("Se venden en")
                || this.JTFL_Proveedor.getText().isEmpty()){

            return false;
        } else {
            return true;
        }
    }
    private void Llenar_Categorias(){
        List<Categorias> datosCategorias = new ArrayList();
        DAOCategorias metodos = new DAOCategoriasImpI();
        
        DefaultComboBoxModel modeloCombo = (DefaultComboBoxModel) this.JCBX_Categoria.getModel();
        
        modeloCombo.removeAllElements();
        modeloCombo.addElement("-Sin Categoría-");
        
        try{
            datosCategorias = metodos.Listar("");
            
            for(int i = 0;i < datosCategorias.size();i++){
                modeloCombo.addElement(datosCategorias.get(i).getNombre());
            }
            
        }catch(Exception ex){
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
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
        JLBL_Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBTN_Cerrar = new rojeru_san.RSButtonRiple();
        JCBX_Categoria = new RSMaterialComponent.RSComboBoxMaterial();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        JTFL_Descripcion = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        JTFL_PrecioCompra = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage7 = new rojerusan.RSLabelImage();
        JTFL_Existencias = new rojeru_san.rsfield.RSTextMaterial();
        JCBX_Unidades = new RSMaterialComponent.RSComboBoxMaterial();
        rSLabelImage8 = new rojerusan.RSLabelImage();
        JBTN_Registrar = new rojeru_san.RSButtonRiple();
        JBTN_Cancelar = new rojeru_san.RSButtonRiple();
        JTFL_PrecioVenta = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage13 = new rojerusan.RSLabelImage();
        JDCH_FechaCaducidad = new newscomponents.RSDateChooser();
        jLabel16 = new javax.swing.JLabel();
        rSLabelImage9 = new rojerusan.RSLabelImage();
        JTFL_Proveedor = new rojeru_san.rsfield.RSTextMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        JPNL_Fondo.setBackground(new java.awt.Color(255, 255, 255));

        JNPL_Encabezado.setBackground(new java.awt.Color(34, 41, 50));

        JLBL_Titulo.setBackground(new java.awt.Color(255, 255, 255));
        JLBL_Titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        JLBL_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        JLBL_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Titulo.setText("REGISTRAR PRODUCTO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Nuevo.png"))); // NOI18N

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
                .addComponent(JLBL_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(JLBL_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JCBX_Categoria.setForeground(new java.awt.Color(24, 23, 37));
        JCBX_Categoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR CATEGORIA", "ADMINISTRADOR", "MODERADOR", "ESTANDAR" }));
        JCBX_Categoria.setColorMaterial(new java.awt.Color(66, 63, 102));
        JCBX_Categoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JCBX_Categoria.setVelMils(300);

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_EditarCategoria.png"))); // NOI18N

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Descripcion.png"))); // NOI18N

        JTFL_Descripcion.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Descripcion.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Descripcion.setPlaceholder("Descripción");
        JTFL_Descripcion.setSelectionColor(new java.awt.Color(66, 63, 102));

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_PrecioCompra.png"))); // NOI18N

        JTFL_PrecioCompra.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_PrecioCompra.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_PrecioCompra.setPlaceholder("Precio de compra");
        JTFL_PrecioCompra.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_PrecioCompra.setSoloNumeros(true);

        rSLabelImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Existencias.png"))); // NOI18N

        JTFL_Existencias.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Existencias.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Existencias.setPlaceholder("Existencias");
        JTFL_Existencias.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Existencias.setSoloNumeros(true);

        JCBX_Unidades.setForeground(new java.awt.Color(24, 23, 37));
        JCBX_Unidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Se venden en", "Rebanadas", "Tazas", "Mililitros", "Litros", "Piezas", "Kg" }));
        JCBX_Unidades.setColorMaterial(new java.awt.Color(66, 63, 102));
        JCBX_Unidades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JCBX_Unidades.setVelMils(300);

        rSLabelImage8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Unidades.png"))); // NOI18N

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

        JTFL_PrecioVenta.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_PrecioVenta.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_PrecioVenta.setPlaceholder("Precio de venta");
        JTFL_PrecioVenta.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_PrecioVenta.setSoloNumeros(true);

        rSLabelImage13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_PrecioVenta.png"))); // NOI18N

        JDCH_FechaCaducidad.setBackground(new java.awt.Color(34, 41, 50));
        JDCH_FechaCaducidad.setBgColor(new java.awt.Color(34, 41, 50));
        JDCH_FechaCaducidad.setFormatDate("yyyy-MM-dd");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(24, 23, 37));
        jLabel16.setText("Fecha de Caducidad:");

        rSLabelImage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_NombreUsuario.png"))); // NOI18N

        JTFL_Proveedor.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Proveedor.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Proveedor.setPlaceholder("Proveedor");
        JTFL_Proveedor.setSelectionColor(new java.awt.Color(66, 63, 102));

        javax.swing.GroupLayout JPNL_FondoLayout = new javax.swing.GroupLayout(JPNL_Fondo);
        JPNL_Fondo.setLayout(JPNL_FondoLayout);
        JPNL_FondoLayout.setHorizontalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTN_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JTFL_PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JPNL_FondoLayout.createSequentialGroup()
                                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JCBX_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(JPNL_FondoLayout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JTFL_Descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                        .addComponent(JTFL_PrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSLabelImage13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                                .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFL_Proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFL_Existencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JCBX_Unidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JDCH_FechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        JPNL_FondoLayout.setVerticalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBX_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFL_Existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFL_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBX_Unidades, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_PrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JDCH_FechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTN_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
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

    private void checkUtilizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUtilizaActionPerformed
        
    }//GEN-LAST:event_checkUtilizaActionPerformed

    private void JBTN_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_RegistrarActionPerformed
        if(Verificar_Llenado()){
            if(Registrar){
                DAOAlmacen metodos = new DAOAlmacenImpI();
                try{
                    if(this.JCBX_Unidades.getSelectedItem().toString().equals("Kg")
                       ||this.JCBX_Unidades.getSelectedItem().toString().equals("Litros")
                       ||this.JCBX_Unidades.getSelectedItem().toString().equals("Mililitros")){
                        
                        SimpleDateFormat formateador = new SimpleDateFormat("YYYY-MM-dd");
                        
                        Almacen modelo = new Almacen();

                        modelo.setDescripcion(this.JTFL_Descripcion.getText());
                        modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                        modelo.setPrecioCompra(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                        modelo.setPrecioVenta(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioVenta.getText()));
                        modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                        modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                        modelo.setFechaCaducidad(String.valueOf(formateador.format(this.JDCH_FechaCaducidad.getDate())));
                        modelo.setProveedor(this.JTFL_Proveedor.getText());
                        
                        try{
                            
                            metodos.Registrar(modelo);

                            Modo_Registrar();

                            Alerta_Exito SA = new Alerta_Exito(new JFrame(), true);
                            SA.JLBL_Mensaje1.setText("Producto registrado exitosamente");
                            SA.JLBL_Mensaje2.setText("");
                            SA.JLBL_Mensaje3.setText("");
                            SA.setVisible(true);
                        }catch(Exception ex){
                            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                            EA.JLBL_Mensaje1.setText("Error a registrar el producto");
                            EA.JLBL_Mensaje2.setText("en la base de datos");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                            System.out.println(ex.getMessage());
                        }
                    }else{
                        if(Verificaciones_Converciones.Verificar_Entero(this.JTFL_Existencias.getText())){
                            SimpleDateFormat formateador = new SimpleDateFormat("YYYY-MM-dd");
                            
                            Almacen modelo = new Almacen();
                            
                            modelo.setDescripcion(this.JTFL_Descripcion.getText());
                            modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                            modelo.setPrecioCompra(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                            modelo.setPrecioVenta(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioVenta.getText()));
                            modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                            modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                            modelo.setFechaCaducidad(String.valueOf(formateador.format(this.JDCH_FechaCaducidad.getDate())));
                            modelo.setProveedor(this.JTFL_Proveedor.getText());

                            try{
                                metodos.Registrar(modelo);

                                Modo_Registrar();

                                Alerta_Exito SA = new Alerta_Exito(new JFrame(), true);
                                SA.JLBL_Mensaje1.setText("Producto registrado exitosamente.");
                                SA.JLBL_Mensaje2.setText("");
                                SA.JLBL_Mensaje3.setText("");
                                SA.setVisible(true);
                            }catch(Exception ex){
                                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Error a registrar el producto");
                                EA.JLBL_Mensaje2.setText("en la base de datos.");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                                System.out.println(ex.getMessage());
                            }
                        }else{
                            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                            EA.JLBL_Mensaje1.setText("Las existencias  en estas unidades");
                            EA.JLBL_Mensaje2.setText("deben de ser un número entero.");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                        }
                    } 
                }catch(Exception ex){
                    Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                    EA.JLBL_Mensaje1.setText("Error al exgraer información");
                    EA.JLBL_Mensaje2.setText("de la base de datos");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                    System.out.println(ex.getMessage());
                }
            }else{
                DAOAlmacen metodos = new DAOAlmacenImpI();
                
                SimpleDateFormat formateador = new SimpleDateFormat("YYYY-MM-dd");
                
                Almacen modelo = new Almacen();
                
                try{
                    if(this.JCBX_Unidades.getSelectedItem().toString().equals("Kg")
                        ||this.JCBX_Unidades.getSelectedItem().toString().equals("Litros")
                        ||this.JCBX_Unidades.getSelectedItem().toString().equals("Mililitros")){

                        modelo.setId(modeloGeneral.getId());
                        modelo.setDescripcion(this.JTFL_Descripcion.getText());
                        modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                        modelo.setPrecioCompra(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                        modelo.setPrecioVenta(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioVenta.getText()));
                        modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                        modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                        modelo.setFechaCaducidad(String.valueOf(formateador.format(this.JDCH_FechaCaducidad.getDate())));
                        modelo.setProveedor(this.JTFL_Proveedor.getText());

                        try{
                            metodos.Modificar(modelo);

                            Alerta_Exito SA = new Alerta_Exito(new JFrame(), true);
                            SA.JLBL_Mensaje1.setText("Producto modificado exitosamente");
                            SA.JLBL_Mensaje2.setText("");
                            SA.JLBL_Mensaje3.setText("");
                            SA.setVisible(true);

                            this.dispose();
                        }catch(Exception ex){
                            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                            EA.JLBL_Mensaje1.setText("Error a modificar el producto");
                            EA.JLBL_Mensaje2.setText("en la base de datos");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                            System.out.println(ex.getMessage());
                        }
                    }else{
                        if(Verificaciones_Converciones.Verificar_Entero(this.JTFL_Existencias.getText())){
                            modelo.setId(modeloGeneral.getId());
                            modelo.setDescripcion(this.JTFL_Descripcion.getText());
                            modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                            modelo.setPrecioCompra(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                            modelo.setPrecioVenta(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioVenta.getText()));
                            modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                            modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                            modelo.setFechaCaducidad(String.valueOf(formateador.format(this.JDCH_FechaCaducidad.getDate())));
                            modelo.setProveedor(this.JTFL_Proveedor.getText());

                            try{
                                metodos.Modificar(modelo);

                                Alerta_Exito SA = new Alerta_Exito(new JFrame(), true);
                                SA.JLBL_Mensaje1.setText("Producto modificado exitosamente");
                                SA.JLBL_Mensaje2.setText("");
                                SA.JLBL_Mensaje3.setText("");
                                SA.setVisible(true);

                                this.dispose();
                            }catch(Exception ex){
                                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Error a modificar el producto");
                                EA.JLBL_Mensaje2.setText("en la base de datos");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                                System.out.println(ex.getMessage());
                            }
                        }else{
                            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                            EA.JLBL_Mensaje1.setText("Las existencias  en estas unidades");
                            EA.JLBL_Mensaje2.setText("deben de ser un número entero");
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
            }
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("Todos los campos son requeridos");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }//GEN-LAST:event_JBTN_RegistrarActionPerformed

    private void JBTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBTN_CerrarActionPerformed

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarEditar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEditar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEditar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEditar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                RegistrarEditar_Producto dialog = new RegistrarEditar_Producto(new javax.swing.JFrame(), true);
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
    public static rojeru_san.RSButtonRiple JBTN_Registrar;
    private RSMaterialComponent.RSComboBoxMaterial JCBX_Categoria;
    private RSMaterialComponent.RSComboBoxMaterial JCBX_Unidades;
    private newscomponents.RSDateChooser JDCH_FechaCaducidad;
    private javax.swing.JLabel JLBL_Titulo;
    private javax.swing.JPanel JNPL_Encabezado;
    private javax.swing.JPanel JPNL_Fondo;
    private rojeru_san.RSPanelShadow JPNL_Shadow;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Descripcion;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Existencias;
    private rojeru_san.rsfield.RSTextMaterial JTFL_PrecioCompra;
    private rojeru_san.rsfield.RSTextMaterial JTFL_PrecioVenta;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Proveedor;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private rojerusan.RSLabelImage rSLabelImage13;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage7;
    private rojerusan.RSLabelImage rSLabelImage8;
    private rojerusan.RSLabelImage rSLabelImage9;
    // End of variables declaration//GEN-END:variables
    
    private void Agregar_ToolTip() {
        JCBX_Categoria.setToolTipText(ToolTip.head + ToolTip.body + "Categoría del producto" + ToolTip.pie);
        JTFL_Descripcion.setToolTipText(ToolTip.head + ToolTip.body + "Nombre del producto" + ToolTip.pie);
        JTFL_PrecioCompra.setToolTipText(ToolTip.head + ToolTip.body + "Precio de compra" + ToolTip.pie);
        JTFL_PrecioVenta.setToolTipText(ToolTip.head + ToolTip.body + "Precio de venta" + ToolTip.pie);
        JTFL_Existencias.setToolTipText(ToolTip.head + ToolTip.body + "Cantidad en almacén" + ToolTip.pie);
        JCBX_Unidades.setToolTipText(ToolTip.head + ToolTip.body + "Como se vende el producto" + ToolTip.pie);
        JDCH_FechaCaducidad.setToolTipText(ToolTip.head + ToolTip.body + "Fecha de caducidad del producto" + ToolTip.pie);
        JTFL_Proveedor.setToolTipText(ToolTip.head + ToolTip.body + "Proveedor del producto" + ToolTip.pie);
    }
}
