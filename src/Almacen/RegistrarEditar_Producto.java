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
import Base_De_Datos.Interfaces.DAOAlmacen;
import Base_De_Datos.Interfaces.DAOCategorias;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import Utilidades.ToolTip;
import Utilidades.Verificaciones_Converciones;
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
        this.JTFL_CodigoBarras.requestFocus();
        this.JTFL_CodigoBarras.setNextFocusableComponent(this.JTFL_Descripcion);
        this.JTFL_Descripcion.setNextFocusableComponent(this.JTFL_PrecioCompra);
        this.JTFL_PrecioCompra.setNextFocusableComponent(this.JTFL_GananciaMenudeo);
        this.JTFL_GananciaMenudeo.setNextFocusableComponent(this.JTFL_GananciaMayoreo);
        this.JTFL_GananciaMayoreo.setNextFocusableComponent(this.JTFL_PrecioMenudeo);
        this.JTFL_PrecioMenudeo.setNextFocusableComponent(this.JTFL_PrecioMayoreo);
        this.JTFL_PrecioMayoreo.setNextFocusableComponent(this.JTFL_Ubicacion);
        this.JTFL_Ubicacion.setNextFocusableComponent(this.JTFL_Existencias);
        this.JTFL_Existencias.setNextFocusableComponent(this.JCBX_Unidades);

        this.JTFL_CodigoBarras.setText("");
        this.JTFL_Descripcion.setText("");
        this.JTFL_PrecioCompra.setText("");
        this.JTFL_GananciaMenudeo.setText("");
        this.JTFL_GananciaMayoreo.setText("");
        this.JTFL_PrecioMenudeo.setText("");
        this.JTFL_PrecioMayoreo.setText("");
        this.JTFL_Ubicacion.setText("");
        this.JTFL_Existencias.setText("");
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
        
        this.JTFL_CodigoBarras.setText(modeloGeneral.getCodigo());
        this.JTFL_Descripcion.setText(modeloGeneral.getDescripcion());
        this.JTFL_PrecioCompra.setText(String.format("%.2f", modeloGeneral.getPrecio()));
        this.JTFL_GananciaMenudeo.setText(String.format("%.2f", modeloGeneral.getGanancia_menudeo()));
        this.JTFL_GananciaMayoreo.setText(String.format("%.2f", modeloGeneral.getGanancia_mayoreo()));
        this.JTFL_PrecioMenudeo.setText(String.format("%.2f", modeloGeneral.getPrecio_venta_menudeo()));
        this.JTFL_PrecioMayoreo.setText(String.format("%.2f", modeloGeneral.getPrecio_venta_mayoreo()));
        if(modeloGeneral.getUnidad_venta().equals("Kg") || modeloGeneral.getUnidad_venta().equals("Litros")
                || modeloGeneral.getUnidad_venta().equals("Metros")){
            this.JTFL_Existencias.setText(String.format("%.2f", modeloGeneral.getExistencias()));
        }else{
            this.JTFL_Existencias.setText(String.format("%.0f", modeloGeneral.getExistencias()));
        }
        this.JTFL_Ubicacion.setText(modeloGeneral.getUbicacion());
    }
    private boolean Verificar_Llenado(){
        if(this.JTFL_CodigoBarras.getText().isEmpty()
                || this.JTFL_Descripcion.getText().isEmpty()
                || this.JTFL_PrecioCompra.getText().isEmpty()
                || this.JTFL_GananciaMenudeo.getText().isEmpty()
                || this.JTFL_GananciaMayoreo.getText().isEmpty()
                || this.JTFL_PrecioMenudeo.getText().isEmpty()
                || this.JTFL_PrecioMayoreo.getText().isEmpty()
                || this.JTFL_Ubicacion.getText().isEmpty()
                || this.JTFL_Existencias.getText().isEmpty()
                || this.JCBX_Unidades.getSelectedItem().toString().equals("Se venden en")){

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
            ErrorAlert EA = new ErrorAlert(new JFrame(), true);
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
        JTFL_CodigoBarras = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        JCBX_Categoria = new RSMaterialComponent.RSComboBoxMaterial();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        JTFL_Descripcion = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        JTFL_PrecioCompra = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage6 = new rojerusan.RSLabelImage();
        JTFL_PrecioMayoreo = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage7 = new rojerusan.RSLabelImage();
        JTFL_Existencias = new rojeru_san.rsfield.RSTextMaterial();
        JCBX_Unidades = new RSMaterialComponent.RSComboBoxMaterial();
        rSLabelImage8 = new rojerusan.RSLabelImage();
        JTFL_Ubicacion = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage9 = new rojerusan.RSLabelImage();
        JBTN_Registrar = new rojeru_san.RSButtonRiple();
        JBTN_Cancelar = new rojeru_san.RSButtonRiple();
        JTFL_GananciaMenudeo = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage10 = new rojerusan.RSLabelImage();
        rSLabelImage11 = new rojerusan.RSLabelImage();
        JTFL_GananciaMayoreo = new rojeru_san.rsfield.RSTextMaterial();
        JTFL_PrecioMenudeo = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage12 = new rojerusan.RSLabelImage();

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

        JTFL_CodigoBarras.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_CodigoBarras.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_CodigoBarras.setPlaceholder("Código de barras");
        JTFL_CodigoBarras.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_CodigoBarras.setSoloNumeros(true);
        JTFL_CodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_CodigoBarrasKeyReleased(evt);
            }
        });

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_CodigoBarras.png"))); // NOI18N

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
        JTFL_Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_DescripcionKeyReleased(evt);
            }
        });

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_PrecioCompra.png"))); // NOI18N

        JTFL_PrecioCompra.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_PrecioCompra.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_PrecioCompra.setPlaceholder("Precio de compra");
        JTFL_PrecioCompra.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_PrecioCompra.setSoloNumeros(true);
        JTFL_PrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_PrecioCompraKeyReleased(evt);
            }
        });

        rSLabelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_PrecioVenta.png"))); // NOI18N

        JTFL_PrecioMayoreo.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_PrecioMayoreo.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_PrecioMayoreo.setPlaceholder("Precio Mayoreo");
        JTFL_PrecioMayoreo.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_PrecioMayoreo.setSoloNumeros(true);
        JTFL_PrecioMayoreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_PrecioMayoreoKeyReleased(evt);
            }
        });

        rSLabelImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Existencias.png"))); // NOI18N

        JTFL_Existencias.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Existencias.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Existencias.setPlaceholder("Existencias");
        JTFL_Existencias.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Existencias.setSoloNumeros(true);
        JTFL_Existencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_ExistenciasKeyReleased(evt);
            }
        });

        JCBX_Unidades.setForeground(new java.awt.Color(24, 23, 37));
        JCBX_Unidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Se venden en", "Kg", "Piezas", "Cajas", "Botes", "Litros", "Bultos", "Metros", "Pares" }));
        JCBX_Unidades.setColorMaterial(new java.awt.Color(66, 63, 102));
        JCBX_Unidades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JCBX_Unidades.setVelMils(300);

        rSLabelImage8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Unidades.png"))); // NOI18N

        JTFL_Ubicacion.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Ubicacion.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Ubicacion.setPlaceholder("Ubicacion");
        JTFL_Ubicacion.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Ubicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_UbicacionKeyReleased(evt);
            }
        });

        rSLabelImage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Ubicacion.png"))); // NOI18N

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

        JTFL_GananciaMenudeo.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_GananciaMenudeo.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_GananciaMenudeo.setPlaceholder("Ganancia Menudeo");
        JTFL_GananciaMenudeo.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_GananciaMenudeo.setSoloNumeros(true);
        JTFL_GananciaMenudeo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_GananciaMenudeoKeyReleased(evt);
            }
        });

        rSLabelImage10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Ganancias.png"))); // NOI18N

        rSLabelImage11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_Ganancias.png"))); // NOI18N

        JTFL_GananciaMayoreo.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_GananciaMayoreo.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_GananciaMayoreo.setPlaceholder("Ganancia Mayoreo");
        JTFL_GananciaMayoreo.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_GananciaMayoreo.setSoloNumeros(true);
        JTFL_GananciaMayoreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_GananciaMayoreoKeyReleased(evt);
            }
        });

        JTFL_PrecioMenudeo.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_PrecioMenudeo.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_PrecioMenudeo.setPlaceholder("Precio Menudeo");
        JTFL_PrecioMenudeo.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_PrecioMenudeo.setSoloNumeros(true);
        JTFL_PrecioMenudeo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_PrecioMenudeoKeyReleased(evt);
            }
        });

        rSLabelImage12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Almacen/Icono_PrecioVenta.png"))); // NOI18N

        javax.swing.GroupLayout JPNL_FondoLayout = new javax.swing.GroupLayout(JPNL_Fondo);
        JPNL_Fondo.setLayout(JPNL_FondoLayout);
        JPNL_FondoLayout.setHorizontalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_FondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFL_CodigoBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTFL_PrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCBX_Categoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(JTFL_Descripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_FondoLayout.createSequentialGroup()
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFL_GananciaMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_GananciaMenudeo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addComponent(rSLabelImage12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFL_PrecioMenudeo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_FondoLayout.createSequentialGroup()
                            .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFL_Ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JPNL_FondoLayout.createSequentialGroup()
                            .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JCBX_Unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JPNL_FondoLayout.createSequentialGroup()
                            .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFL_Existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFL_PrecioMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        JPNL_FondoLayout.setVerticalGroup(
            JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_FondoLayout.createSequentialGroup()
                .addComponent(JNPL_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBX_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_CodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_PrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_GananciaMenudeo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_GananciaMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPNL_FondoLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_PrecioMenudeo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_PrecioMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPNL_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBX_Unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    if(!metodos.Existe_Producto(this.JTFL_CodigoBarras.getText())){
                        if(this.JCBX_Unidades.getSelectedItem().toString().equals("Kg")
                           ||this.JCBX_Unidades.getSelectedItem().toString().equals("Litros")
                           ||this.JCBX_Unidades.getSelectedItem().toString().equals("Metros")){
                            
                            Almacen modelo = new Almacen();
                            
                            modelo.setCodigo(this.JTFL_CodigoBarras.getText());
                            modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                            modelo.setDescripcion(this.JTFL_Descripcion.getText());
                            modelo.setPrecio(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                            modelo.setGanancia_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMenudeo.getText()));
                            modelo.setGanancia_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMayoreo.getText()));
                            modelo.setPrecio_venta_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMenudeo.getText()));
                            modelo.setPrecio_venta_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMayoreo.getText()));
                            modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                            modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                            modelo.setUbicacion(this.JTFL_Ubicacion.getText());
                            
                            try{
                                metodos.Registrar(modelo);
                                
                                Modo_Registrar();
                                
                                SuccessAlert SA = new SuccessAlert(new JFrame(), true);
                                SA.JLBL_Mensaje1.setText("Producto registrado exitosamente");
                                SA.JLBL_Mensaje2.setText("");
                                SA.JLBL_Mensaje3.setText("");
                                SA.setVisible(true);
                            }catch(Exception ex){
                                ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Error a registrar el producto");
                                EA.JLBL_Mensaje2.setText("en la base de datos");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                                System.out.println(ex.getMessage());
                            }
                        }else{
                            if(Verificaciones_Converciones.Verificar_Entero(this.JTFL_Existencias.getText())){
                                Almacen modelo = new Almacen();
                            
                                modelo.setCodigo(this.JTFL_CodigoBarras.getText());
                                modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                                modelo.setDescripcion(this.JTFL_Descripcion.getText());
                                modelo.setPrecio(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                                modelo.setGanancia_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMenudeo.getText()));
                                modelo.setGanancia_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMayoreo.getText()));
                                modelo.setPrecio_venta_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMenudeo.getText()));
                                modelo.setPrecio_venta_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMayoreo.getText()));
                                modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                                modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                                modelo.setUbicacion(this.JTFL_Ubicacion.getText());

                                try{
                                    metodos.Registrar(modelo);

                                    Modo_Registrar();

                                    SuccessAlert SA = new SuccessAlert(new JFrame(), true);
                                    SA.JLBL_Mensaje1.setText("Producto registrado exitosamente.");
                                    SA.JLBL_Mensaje2.setText("");
                                    SA.JLBL_Mensaje3.setText("");
                                    SA.setVisible(true);
                                }catch(Exception ex){
                                    ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                    EA.JLBL_Mensaje1.setText("Error a registrar el producto");
                                    EA.JLBL_Mensaje2.setText("en la base de datos.");
                                    EA.JLBL_Mensaje3.setText("");
                                    EA.setVisible(true);
                                    System.out.println(ex.getMessage());
                                }
                            }else{
                                ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Las existencias  en estas unidades");
                                EA.JLBL_Mensaje2.setText("deben de ser un número entero.");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                            }
                        } 
                    }else{
                        ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                        EA.JLBL_Mensaje1.setText("El código que intentas registrar");
                        EA.JLBL_Mensaje2.setText("ya existe.");
                        EA.JLBL_Mensaje3.setText("");
                        EA.setVisible(true);
                    }
                }catch(Exception ex){
                    ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                    EA.JLBL_Mensaje1.setText("Error al exgraer información");
                    EA.JLBL_Mensaje2.setText("de la base de datos");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                    System.out.println(ex.getMessage());
                }
            }else{
                DAOAlmacen metodos = new DAOAlmacenImpI();
                Almacen modelo = new Almacen();
                
                try{
                    if(modeloGeneral.getCodigo().equals(this.JTFL_CodigoBarras.getText())){
                        if(this.JCBX_Unidades.getSelectedItem().toString().equals("Kg")
                            ||this.JCBX_Unidades.getSelectedItem().toString().equals("Litros")
                            ||this.JCBX_Unidades.getSelectedItem().toString().equals("Metros")){

                            modelo.setId(modeloGeneral.getId());
                            modelo.setCodigo(this.JTFL_CodigoBarras.getText());
                            modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                            modelo.setDescripcion(this.JTFL_Descripcion.getText());
                            modelo.setPrecio(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                            modelo.setGanancia_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMenudeo.getText()));
                            modelo.setGanancia_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMayoreo.getText()));
                            modelo.setPrecio_venta_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMenudeo.getText()));
                            modelo.setPrecio_venta_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMayoreo.getText()));
                            modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                            modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                            modelo.setUbicacion(this.JTFL_Ubicacion.getText());

                            try{
                                metodos.Modificar(modelo);

                                SuccessAlert SA = new SuccessAlert(new JFrame(), true);
                                SA.JLBL_Mensaje1.setText("Producto modificado exitosamente");
                                SA.JLBL_Mensaje2.setText("");
                                SA.JLBL_Mensaje3.setText("");
                                SA.setVisible(true);

                                this.dispose();
                            }catch(Exception ex){
                                ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Error a modificar el producto");
                                EA.JLBL_Mensaje2.setText("en la base de datos");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                                System.out.println(ex.getMessage());
                            }
                        }else{
                            if(Verificaciones_Converciones.Verificar_Entero(this.JTFL_Existencias.getText())){
                                modelo.setId(modeloGeneral.getId());
                                modelo.setCodigo(this.JTFL_CodigoBarras.getText());
                                modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                                modelo.setDescripcion(this.JTFL_Descripcion.getText());
                                modelo.setPrecio(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                                modelo.setGanancia_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMenudeo.getText()));
                                modelo.setGanancia_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMayoreo.getText()));
                                modelo.setPrecio_venta_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMenudeo.getText()));
                                modelo.setPrecio_venta_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMayoreo.getText()));
                                modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                                modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                                modelo.setUbicacion(this.JTFL_Ubicacion.getText());

                                try{
                                    metodos.Modificar(modelo);

                                    SuccessAlert SA = new SuccessAlert(new JFrame(), true);
                                    SA.JLBL_Mensaje1.setText("Producto modificado exitosamente");
                                    SA.JLBL_Mensaje2.setText("");
                                    SA.JLBL_Mensaje3.setText("");
                                    SA.setVisible(true);

                                    this.dispose();
                                }catch(Exception ex){
                                    ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                    EA.JLBL_Mensaje1.setText("Error a modificar el producto");
                                    EA.JLBL_Mensaje2.setText("en la base de datos");
                                    EA.JLBL_Mensaje3.setText("");
                                    EA.setVisible(true);
                                    System.out.println(ex.getMessage());
                                }
                            }else{
                                ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                EA.JLBL_Mensaje1.setText("Las existencias  en estas unidades");
                                EA.JLBL_Mensaje2.setText("deben de ser un número entero");
                                EA.JLBL_Mensaje3.setText("");
                                EA.setVisible(true);
                            }
                        }
                    }else{
                        if(!metodos.Existe_Producto(this.JTFL_CodigoBarras.getText())){
                            if(this.JCBX_Unidades.getSelectedItem().toString().equals("Kg")
                                ||this.JCBX_Unidades.getSelectedItem().toString().equals("Litros")
                                ||this.JCBX_Unidades.getSelectedItem().toString().equals("Metros")){

                                modelo.setId(modeloGeneral.getId());
                                modelo.setCodigo(this.JTFL_CodigoBarras.getText());
                                modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                                modelo.setDescripcion(this.JTFL_Descripcion.getText());
                                modelo.setPrecio(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                                modelo.setGanancia_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMenudeo.getText()));
                                modelo.setGanancia_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMayoreo.getText()));
                                modelo.setPrecio_venta_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMenudeo.getText()));
                                modelo.setPrecio_venta_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMayoreo.getText()));
                                modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                                modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                                modelo.setUbicacion(this.JTFL_Ubicacion.getText());

                                try{
                                    metodos.Modificar(modelo);

                                    SuccessAlert SA = new SuccessAlert(new JFrame(), true);
                                    SA.JLBL_Mensaje1.setText("Producto modificado exitosamente");
                                    SA.JLBL_Mensaje2.setText("");
                                    SA.JLBL_Mensaje3.setText("");
                                    SA.setVisible(true);

                                    this.dispose();
                                }catch(Exception ex){
                                    ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                    EA.JLBL_Mensaje1.setText("Error a modificar el producto");
                                    EA.JLBL_Mensaje2.setText("en la base de datos");
                                    EA.JLBL_Mensaje3.setText("");
                                    EA.setVisible(true);
                                    System.out.println(ex.getMessage());
                                }
                            }else{
                                if(Verificaciones_Converciones.Verificar_Entero(this.JTFL_Existencias.getText())){
                                    modelo.setId(modeloGeneral.getId());
                                    modelo.setCodigo(this.JTFL_CodigoBarras.getText());
                                    modelo.setCategoria(this.JCBX_Categoria.getSelectedItem().toString());
                                    modelo.setDescripcion(this.JTFL_Descripcion.getText());
                                    modelo.setPrecio(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText()));
                                    modelo.setGanancia_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMenudeo.getText()));
                                    modelo.setGanancia_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMayoreo.getText()));
                                    modelo.setPrecio_venta_menudeo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMenudeo.getText()));
                                    modelo.setPrecio_venta_mayoreo(Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioMayoreo.getText()));
                                    modelo.setExistencias(Verificaciones_Converciones.Convertir_Double(this.JTFL_Existencias.getText()));
                                    modelo.setUnidad_venta(this.JCBX_Unidades.getSelectedItem().toString());
                                    modelo.setUbicacion(this.JTFL_Ubicacion.getText());

                                    try{
                                        metodos.Modificar(modelo);

                                        SuccessAlert SA = new SuccessAlert(new JFrame(), true);
                                        SA.JLBL_Mensaje1.setText("Producto modificado exitosamente");
                                        SA.JLBL_Mensaje2.setText("");
                                        SA.JLBL_Mensaje3.setText("");
                                        SA.setVisible(true);

                                        this.dispose();
                                    }catch(Exception ex){
                                        ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                        EA.JLBL_Mensaje1.setText("Error a modificar el producto");
                                        EA.JLBL_Mensaje2.setText("en la base de datos");
                                        EA.JLBL_Mensaje3.setText("");
                                        EA.setVisible(true);
                                        System.out.println(ex.getMessage());
                                    }
                                }else{
                                    ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                                    EA.JLBL_Mensaje1.setText("Las existencias  en estas unidades");
                                    EA.JLBL_Mensaje2.setText("deben de ser un número entero");
                                    EA.JLBL_Mensaje3.setText("");
                                    EA.setVisible(true);
                                }
                            }
                        }else{
                            ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                            EA.JLBL_Mensaje1.setText("El código ya se encuentra registrado.");
                            EA.JLBL_Mensaje2.setText("");
                            EA.JLBL_Mensaje3.setText("");
                            EA.setVisible(true);
                        }
                    }
                }catch(Exception ex){
                    ErrorAlert EA = new ErrorAlert(new JFrame(), true);
                    EA.JLBL_Mensaje1.setText("Error al extraer información de la.");
                    EA.JLBL_Mensaje2.setText("base de datos.");
                    EA.JLBL_Mensaje3.setText("");
                    EA.setVisible(true);
                    System.out.println(ex.getMessage());
                }
            }
        }else{
            ErrorAlert EA = new ErrorAlert(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("Todos los campos son requeridos");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }//GEN-LAST:event_JBTN_RegistrarActionPerformed

    private void JTFL_UbicacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_UbicacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_UbicacionKeyReleased

    private void JTFL_ExistenciasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_ExistenciasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_ExistenciasKeyReleased

    private void JBTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBTN_CerrarActionPerformed

    private void JTFL_CodigoBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_CodigoBarrasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_CodigoBarrasKeyReleased

    private void JTFL_DescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_DescripcionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_DescripcionKeyReleased

    private void JTFL_PrecioCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_PrecioCompraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_PrecioCompraKeyReleased

    private void JTFL_PrecioMayoreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_PrecioMayoreoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_PrecioMayoreoKeyReleased

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

    private void JTFL_GananciaMenudeoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_GananciaMenudeoKeyReleased
        if(!this.JTFL_GananciaMenudeo.getText().isEmpty()){
            double porcentajeGanancia = Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMenudeo.getText());
            double precioCompra = Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText());
            double ganancia = (precioCompra)*(porcentajeGanancia/100);

            this.JTFL_PrecioMenudeo.setText(String.format("%.2f",precioCompra + ganancia));
        }
    }//GEN-LAST:event_JTFL_GananciaMenudeoKeyReleased

    private void JTFL_GananciaMayoreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_GananciaMayoreoKeyReleased
        if(!this.JTFL_GananciaMayoreo.getText().isEmpty()){
            double porcentajeGanancia = Verificaciones_Converciones.Convertir_Double(this.JTFL_GananciaMayoreo.getText());
            double precioCompra = Verificaciones_Converciones.Convertir_Double(this.JTFL_PrecioCompra.getText());
            double ganancia = (precioCompra)*(porcentajeGanancia/100);

            this.JTFL_PrecioMayoreo.setText(String.format("%.2f",precioCompra + ganancia));
        }
    }//GEN-LAST:event_JTFL_GananciaMayoreoKeyReleased

    private void JTFL_PrecioMenudeoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_PrecioMenudeoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_PrecioMenudeoKeyReleased

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
    private javax.swing.JLabel JLBL_Titulo;
    private javax.swing.JPanel JNPL_Encabezado;
    private javax.swing.JPanel JPNL_Fondo;
    private rojeru_san.RSPanelShadow JPNL_Shadow;
    private rojeru_san.rsfield.RSTextMaterial JTFL_CodigoBarras;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Descripcion;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Existencias;
    private rojeru_san.rsfield.RSTextMaterial JTFL_GananciaMayoreo;
    private rojeru_san.rsfield.RSTextMaterial JTFL_GananciaMenudeo;
    private rojeru_san.rsfield.RSTextMaterial JTFL_PrecioCompra;
    private rojeru_san.rsfield.RSTextMaterial JTFL_PrecioMayoreo;
    private rojeru_san.rsfield.RSTextMaterial JTFL_PrecioMenudeo;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Ubicacion;
    private javax.swing.JLabel jLabel2;
    private rojerusan.RSLabelImage rSLabelImage10;
    private rojerusan.RSLabelImage rSLabelImage11;
    private rojerusan.RSLabelImage rSLabelImage12;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage6;
    private rojerusan.RSLabelImage rSLabelImage7;
    private rojerusan.RSLabelImage rSLabelImage8;
    private rojerusan.RSLabelImage rSLabelImage9;
    // End of variables declaration//GEN-END:variables
    
    private void Agregar_ToolTip() {
        JCBX_Categoria.setToolTipText(ToolTip.head + ToolTip.body + "Categoría del producto" + ToolTip.pie);
        JTFL_CodigoBarras.setToolTipText(ToolTip.head + ToolTip.body + "Código de barras" + ToolTip.pie);
        JTFL_Descripcion.setToolTipText(ToolTip.head + ToolTip.body + "Nombre del producto" + ToolTip.pie);
        JTFL_PrecioCompra.setToolTipText(ToolTip.head + ToolTip.body + "Precio de compra" + ToolTip.pie);
        JTFL_GananciaMenudeo.setToolTipText(ToolTip.head + ToolTip.body + "Porcentaje de ganancia en menudeo" + ToolTip.pie);
        JTFL_GananciaMayoreo.setToolTipText(ToolTip.head + ToolTip.body + "Procentaje de ganancia en mayoreo" + ToolTip.pie);
        JTFL_PrecioMenudeo.setToolTipText(ToolTip.head + ToolTip.body + "Precio de venta minorísta" + ToolTip.pie);
        JTFL_PrecioMayoreo.setToolTipText(ToolTip.head + ToolTip.body + "Precio de venta mayorísta" + ToolTip.pie);
        JTFL_Existencias.setToolTipText(ToolTip.head + ToolTip.body + "Cantidad en almacén" + ToolTip.pie);
        JCBX_Unidades.setToolTipText(ToolTip.head + ToolTip.body + "Como se vende el producto" + ToolTip.pie);
        JTFL_Ubicacion.setToolTipText(ToolTip.head + ToolTip.body + "Lugar donde se ecnuentra el producto" + ToolTip.pie);
    }
}
