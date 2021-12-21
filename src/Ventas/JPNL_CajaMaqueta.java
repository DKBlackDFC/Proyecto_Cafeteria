/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Alertas.Alerta_Advertencia;
import Alertas.Alerta_Error;
import Alertas.Alerta_Exito;
import Almacen.JPNL_AlmacenMaqueta;
import Base_De_Datos.Construcciones.Almacen;
import Base_De_Datos.Construcciones.Ventas;
import Base_De_Datos.Implementaciones.DAOAlmacenImpI;
import Base_De_Datos.Implementaciones.DAOVentasImpI;
import Base_De_Datos.interfaces.DAOAlmacen;
import Base_De_Datos.interfaces.DAOVentas;
import Principal.Ventana_Principal;
import Reportes.Reportes;
import Utilidades.Codigo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
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
public class JPNL_CajaMaqueta extends javax.swing.JPanel {
    
    private static String codigoVenta;
    
    public JPNL_CajaMaqueta() {
        initComponents();
     
        this.JTBL_Ventas.setCursor(new Cursor(12));
        this.JSB_Ventas.getViewport().setBackground(Color.WHITE);

        this.JPOP_MenuTabla.add(JPNL_Menu);
        
        addEventKey();
    }
    
    private void addEventKey(){

        KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false);
        Action f1Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Agregar_Sin_Codigo();
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f1, "F1");
        this.getActionMap().put("F1", f1Action);

        //---------------------------------------------------------------------------
        KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, false);
        Action f2Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Cobrar_Venta();
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f2, "F2");
        this.getActionMap().put("F2", f2Action);

        //------------------------------------------------------------------------------
        KeyStroke f3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0, false);
        Action f3Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Quitar_Producto();
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f3, "F3");
        this.getActionMap().put("F3", f3Action);

        //--------------------------------------------------------------------------------
        KeyStroke f4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0, false);
        Action f4Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Cancelar_Venta();
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f4, "F4");
        this.getActionMap().put("F4", f4Action);
    }
    private void Cancelar_Venta(){
        int filas = this.JTBL_Ventas.getRowCount();
        
        if(filas > 0){
            Alerta_Advertencia WA = new Alerta_Advertencia(new JFrame(), true);
            WA.JLBL_Mensaje1.setText("Se removerán todos los productos");
            WA.JLBL_Mensaje2.setText("agregados.");
            WA.JLBL_Mensaje3.setText("");
            WA.setVisible(true);

            if(WA.hecho){
                DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
                while(modeloTabla.getRowCount() > 0){
                    modeloTabla.removeRow(0);
                }
                
                this.JLBL_Total.setText("0.00");
            }
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No ha agregado ningún producto aún");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }
    private void Quitar_Producto(){
        int filaSeleccionada = this.JTBL_Ventas.getSelectedRow();
        
        if(filaSeleccionada != -1){    
            DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
            
            Alerta_Advertencia WA = new Alerta_Advertencia(new JFrame(), true);
            WA.JLBL_Mensaje1.setText("Se removerá el producto seleccionado.");
            WA.JLBL_Mensaje2.setText("");
            WA.JLBL_Mensaje3.setText("");
            WA.setVisible(true);
            
            if(WA.hecho){
                modeloTabla.removeRow(filaSeleccionada);
                Calcular_Total();
            }
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No ha seleccionado ningún producto.");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }
    private void Calcular_Total(){
        double total = 0;
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
        
        for(int i = 0;i < modeloTabla.getRowCount();i++){
            total += Double.parseDouble(modeloTabla.getValueAt(i,4).toString());
        }
        
        this.JLBL_Total.setText("" + String.format("%.2f", total));
    }
    private void Cobrar_Venta(){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
        int cantidadFilas = modeloTabla.getRowCount();
        
        if(cantidadFilas > 0){
            
            Cobrar C = new Cobrar(new JFrame(), true);
            C.JLBL_Total.setText("$" + this.JLBL_Total.getText());
            C.totalCobrar = Double.parseDouble(this.JLBL_Total.getText());
            C.JTFL_PagoCon.setText(this.JLBL_Total.getText());
            C.JTFL_PagoCon.setSelectionStart(0);
            C.JTFL_PagoCon.setSelectionEnd(C.JTFL_PagoCon.getText().length());
            C.JLBL_Cantidad.setText(String.valueOf(cantidadFilas));
            C.setVisible(true);

            if (C.ventaSinTicket) {
                Realizar_Venta(C.formaPago, C.efectivo, C.tarjeta);
            }

            if (C.ventaConTicket) {
                Realizar_Venta_Ticket(C.pagoCon, C.cambio, String.valueOf(modeloTabla.getRowCount()), String.valueOf(C.totalCobrar), C.formaPago, C.efectivo, C.tarjeta);
            }
            
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No ha agregado ningún producto aún");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
        }
    }
    private void Realizar_Venta(String formaPago, String efectivo, String tarjeta){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
        DAOVentas metodosVentas = new DAOVentasImpI();
        DAOAlmacen metodosAlmacen = new DAOAlmacenImpI();
        Ventas modeloVenta = new Ventas();
        Almacen modeloAlmacen = new Almacen();
        
        try{
            String codigo_venta = Codigo.Genrar_Codigo_Venta();
            codigoVenta = codigo_venta;
            
            for(int i = 0;i < modeloTabla.getRowCount();i++){
                modeloAlmacen = metodosAlmacen.Extraer_Datos(modeloTabla.getValueAt(i,0).toString());
                
                modeloVenta.setNumero_venta(codigo_venta);
                modeloVenta.setProducto(modeloTabla.getValueAt(i,1).toString());
                modeloVenta.setCantidad(Double.parseDouble(modeloTabla.getValueAt(i,2).toString()));
                modeloVenta.setPrecio(Double.parseDouble(modeloTabla.getValueAt(i,3).toString()));
                modeloVenta.setTotal(Double.parseDouble(modeloTabla.getValueAt(i,4).toString()));
                modeloVenta.setCajero(Ventana_Principal.JLBL_AsignarNombre.getText());
                modeloVenta.setFecha(this.JLBL_Fecha.getFecha());
                modeloVenta.setForma_pago(formaPago);
                
                metodosVentas.Registrar(modeloVenta);
            }
            
            Actualizar_Almacen();
            
            Actualizar_Tabla_Almacen("");
            //Actualizar_Tabla_UltimasVentas("");
            
            Limpiar_Tabla();
            
            Alerta_Exito SA = new Alerta_Exito(new JFrame(), true);
            SA.JLBL_Mensaje1.setText("Venta registrada exitosamente.");
            SA.JLBL_Mensaje2.setText("");
            SA.JLBL_Mensaje3.setText("");
            SA.setVisible(true);
        }catch(Exception ex){
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("Error al registrar la venta en la");
            EA.JLBL_Mensaje2.setText("base de datos.");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
        }
    }
    private void Realizar_Venta_Ticket(String pagoCon, String cambio, String cantidad, String total, String formaPago, String efectivo, String tarjeta){
        Realizar_Venta(formaPago, efectivo, tarjeta);
        
        
    }
    private void Limpiar_Tabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
        
        while(modeloTabla.getRowCount() > 0){
            modeloTabla.removeRow(0);
        }
        
        this.JLBL_Total.setText("0.00");
    }
    private void Actualizar_Almacen(){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
        DAOAlmacen metodosAlmacen = new DAOAlmacenImpI();
        Almacen modeloAlmacen = new Almacen();
        double existencias = 0;
        
        try{
            for(int i = 0;i < modeloTabla.getRowCount();i++){
                modeloAlmacen = metodosAlmacen.Extraer_Datos(modeloTabla.getValueAt(i,0).toString());
                existencias = modeloAlmacen.getExistencias();
                modeloAlmacen.setExistencias(existencias-(Double.parseDouble(modeloTabla.getValueAt(i,2).toString())));
                
                metodosAlmacen.Modificar(modeloAlmacen);
            }
        }catch(Exception ex){
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("Error al actualizar el inventario.");
            EA.JLBL_Mensaje2.setText("");
            EA.JLBL_Mensaje3.setText("");
            EA.setVisible(true);
            System.out.println(ex.getMessage());
        }
    }
    private void Actualizar_Tabla_Almacen(String cadena){
        DefaultTableModel modeloTabla = (DefaultTableModel) JPNL_AlmacenMaqueta.JTBL_Almacen.getModel();
        DAOAlmacen metodos = new DAOAlmacenImpI();
        List<Almacen> datosAlmacen = new ArrayList();
        String[] datos = new String[9];
        
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
                datos[7] = datosAlmacen.get(i).getFechaCaducidad();
                datos[8] = datosAlmacen.get(i).getProveedor();
                
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
    private void Agregar_Sin_Codigo(){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
        
        Agregar_Producto_Sin_Codigo AP = new Agregar_Producto_Sin_Codigo(new JFrame(), true);
        
        for(int i = 0;i < AP.codigos.size();i++){
            AP.codigos.remove(i);
        }
        
        for(int i = 0;i < modeloTabla.getRowCount();i++){
            AP.codigos.add(modeloTabla.getValueAt(i,0).toString());
        }
        
        AP.setVisible(true);
        
        if(AP.continuar){
            Almacen modeloAlmacen = new Almacen();
            String[] datos = new String[5];
            double cantidad = 0;
            boolean productoAgregado = false;
            int fila = 0;
            
            modeloAlmacen = AP.producto;
            cantidad = AP.cantidad;
            
            for(int i = 0;i < modeloTabla.getRowCount();i++){
                if(modeloTabla.getValueAt(i,0).toString().equals(String.valueOf(modeloAlmacen.getId()))){
                    fila = i;
                    productoAgregado = true;
                    break;
                }
            }
            
            if(productoAgregado){
                if(Unidad_Venta(modeloAlmacen.getUnidad_venta())){
                    modeloTabla.setValueAt(String.format("%.2f", Double.parseDouble(modeloTabla.getValueAt(fila,2).toString())+cantidad), fila, 2);
                    modeloTabla.setValueAt(String.format("%.2f", Calcular_Importe(fila)), fila, 4);
                    Calcular_Total();
                }else{
                    modeloTabla.setValueAt(String.format("%.0f", Double.parseDouble(modeloTabla.getValueAt(fila,2).toString())+cantidad), fila, 2);
                    modeloTabla.setValueAt(String.format("%.2f", Calcular_Importe(fila)), fila, 4);
                    Calcular_Total();
                }
            }else{
                datos[0] = String.valueOf(modeloAlmacen.getId());
                datos[1] = modeloAlmacen.getDescripcion();
                if(Unidad_Venta(modeloAlmacen.getUnidad_venta())){
                    datos[2] = String.format("%.2f",cantidad);
                }else{
                    datos[2] = String.format("%.0f",cantidad);
                }

                datos[3] = String.format("%.2f", modeloAlmacen.getPrecioVenta());
                datos[4] = String.format("%.2f", modeloAlmacen.getPrecioVenta()*cantidad);
                modeloTabla.addRow(datos);
                Calcular_Total();
            }
        }
    }
    private boolean Unidad_Venta(String unidad_venta){
        if(unidad_venta.equals("Kg") || unidad_venta.equals("Litros") || unidad_venta.equals("Mililitros")){
            return  true;
        }else{
            return false;
        }
    }
    private double Calcular_Importe(int fila){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.JTBL_Ventas.getModel();
        double importe = Double.parseDouble(modeloTabla.getValueAt(fila, 2).toString())
                * Double.parseDouble(modeloTabla.getValueAt(fila, 3).toString());
        
        return importe;
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
                "ID", "PRODUCTO", "CANTIDAD", "PRECIO DE VENTA", "IMPORTE"
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
        Agregar_Sin_Codigo();
    }//GEN-LAST:event_JBTN_BuscarActionPerformed

    private void JBTN_CobrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CobrarVentaActionPerformed
        Cobrar_Venta();
    }//GEN-LAST:event_JBTN_CobrarVentaActionPerformed

    private void JBTN_QuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProductoActionPerformed
        Quitar_Producto();
    }//GEN-LAST:event_JBTN_QuitarProductoActionPerformed

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
       Cancelar_Venta();
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

    private void JTBL_VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_VentasMouseClicked
        int row = JTBL_Ventas.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.JTBL_Ventas.setRowSelectionInterval(row, row);
            //PosicionMouse = evt.getY() / 16;
            JPOP_MenuTabla.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.JTBL_Ventas.setRowSelectionInterval(row, row);
        }
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
