/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import Alertas.Alerta_Advertencia;
import Alertas.Alerta_Cargando;
import Alertas.Alerta_Error;
import Alertas.Alerta_Exito;
import Alertas.Alerta_Informacion;
import Base_De_Datos.Metodos_Configuracion;
import Principal.Ventana_Principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import necesario.RSFileChooser;

/**
 *
 * @author DIEGO
 */
public class JPNL_ConfiguracionMaqueta extends javax.swing.JPanel {

    public JPNL_ConfiguracionMaqueta() {
        initComponents();
        
        Seleccionar_Impresora_Predeterminada();
        Listar_Impresoras();
    }
    
    private void Seleccionar_Impresora_Predeterminada() {
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        if (service != null) {
            String printServiceName = service.getName();
            this.JCBX_SeleccionarImpresora.setSelectedItem(printServiceName);
            this.JLBL_Impresora.setText(printServiceName);
        } else {
            JCBX_SeleccionarImpresora.setSelectedItem("NO SE HA ESTABLECIDO UNA IMPRESORA PREDETERMINADA");
        }
    }

    private void Listar_Impresoras() {
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService p : ps) {
            this.JCBX_SeleccionarImpresora.addItem(p.getName());
        }
    }
    private void Establece_Impresora_Predeterminada(String printerName) {
        System.out.println(printerName);
        String cmdLine = String.format("RUNDLL32 PRINTUI.DLL,PrintUIEntry /y /n \"%s\"", printerName);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmdLine);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = new String();
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }
            System.out.println("result  " + line);
        }
    }
    private void Crear_Respaldo_Base_De_Datos(){
        RSFileChooser fileChooser = new RSFileChooser(); 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Mysql (*.slq)", "slq");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("GUARDAR ARCHIVO");
        Alerta_Cargando LA = new Alerta_Cargando(new JFrame(), true);
        
        if(fileChooser.showSaveDialog(this) == RSFileChooser.APPROVE_OPTION){

            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());

            File archivo = new File(fileChooser.getSelectedFile().getAbsolutePath());
            
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LA.setVisible(true);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Metodos_Configuracion.Crear_Respaldo(archivo);
                        LA.dispose();
                        
                        Alerta_Exito SA = new Alerta_Exito(new JFrame(), true);
                        SA.JLBL_Mensaje1.setText("Información exportada exitosamente.");
                        SA.JLBL_Mensaje2.setText("");
                        SA.JLBL_Mensaje3.setText("");
                        SA.setVisible(true);
                    }catch(Exception ex){
                        LA.dispose();
                        
                        Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                        EA.JLBL_Mensaje1.setText("No se pudo crear el archivo");
                        EA.JLBL_Mensaje2.setText("de la base de datos.");
                        EA.JLBL_Mensaje3.setText("");
                        EA.setVisible(true);
                        System.out.println(ex.getMessage());
                    }
                }
                
            }).start();
        }
    }
    private void Restaurar_Base_De_Datos(){
        RSFileChooser fileChooser = new RSFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Mysql (*.sql)", "sql");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("BUSCAR ARCHIVO");
        Alerta_Cargando LA = new Alerta_Cargando(new JFrame(), true);
        
        if(fileChooser.showOpenDialog(this) == RSFileChooser.APPROVE_OPTION){

            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    LA.setVisible(true);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {  
                    try{
                        Metodos_Configuracion.Cargar_Respaldo(fileChooser.getSelectedFile().getAbsolutePath());
                        LA.dispose();
                        
                        Alerta_Exito SA = new Alerta_Exito(new JFrame(), true);
                        SA.JLBL_Mensaje1.setText("Información importada exitosamente.");
                        SA.JLBL_Mensaje2.setText("Es necesario reiniciar la aplicación.");
                        SA.JLBL_Mensaje3.setText("");
                        SA.setVisible(true);
                        
                        System.exit(0);
                    }catch(Exception ex){
                        LA.dispose();
                        
                        Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                        EA.JLBL_Mensaje1.setText("No se pudo agregar la información");
                        EA.JLBL_Mensaje2.setText("a la base de datos.");
                        EA.JLBL_Mensaje3.setText("");
                        EA.setVisible(true);
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
    }
    private void Reiniciar_Base_De_Datos(){
        Alerta_Advertencia WA = new Alerta_Advertencia(new JFrame(), true);
        WA.JLBL_Mensaje1.setText("TODA la información de la base de datos");
        WA.JLBL_Mensaje2.setText("se borrará, asegurese de tener su");
        WA.JLBL_Mensaje3.setText("usuario por defecto para ingresar.");
        WA.setVisible(true);
        
        if(WA.hecho){
            try{
                Metodos_Configuracion.Reiniciar_Base_De_Datos();
                Alerta_Informacion IA = new Alerta_Informacion(new JFrame(), true);
                IA.JLBL_Mensaje1.setText("Es necesario reiniciar el sistema.");
                IA.JLBL_Mensaje2.setText("");
                IA.JLBL_Mensaje3.setText("");
                IA.setVisible(true);
                
                System.exit(0);
            }catch(Exception ex){
                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                EA.JLBL_Mensaje1.setText("No se pudo eliminar la información,");
                EA.JLBL_Mensaje2.setText("contácte al desarrollador.");
                EA.JLBL_Mensaje3.setText("");
                EA.setVisible(true);
                System.out.println(ex.getMessage());
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        JBTN_Respaldo = new rojeru_san.rsbutton.RSButtonMetro();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        JBTN_Restaurar = new rojeru_san.rsbutton.RSButtonMetro();
        jPanel11 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        JBTN_Reiniciar = new rojeru_san.rsbutton.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        JBTN_EstablecerImpresora = new rojeru_san.rsbutton.RSButtonRoundEffect();
        lblTexto = new javax.swing.JLabel();
        JLBL_Impresora = new javax.swing.JLabel();
        JCBX_SeleccionarImpresora = new rojerusan.RSComboMetro();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(66, 63, 102));
        jSeparator1.setForeground(new java.awt.Color(66, 63, 102));

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 248, 248)), "Respaldos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(248, 248, 248));

        JBTN_Respaldo.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Respaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Configuracion/Icono_CrearRespaldo.png"))); // NOI18N
        JBTN_Respaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_RespaldoActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(171, 179, 182));
        jLabel50.setText("Crear respaldo");

        jLabel51.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(171, 179, 182));
        jLabel51.setText("Base de datos ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTN_Respaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBTN_Respaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(248, 248, 248));

        jLabel52.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(171, 179, 182));
        jLabel52.setText("Restaurar");

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(171, 179, 182));
        jLabel53.setText("Base de datos ");

        JBTN_Restaurar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Restaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Configuracion/Icono_Restaurar.png"))); // NOI18N
        JBTN_Restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_RestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTN_Restaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addGap(69, 69, 69))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53))
                    .addComponent(JBTN_Restaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(248, 248, 248));

        jLabel60.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(171, 179, 182));
        jLabel60.setText("Reinicializar");

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(171, 179, 182));
        jLabel61.setText("Base de datos ");

        JBTN_Reiniciar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Reiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Configuracion/Icono_Reinicializar.png"))); // NOI18N
        JBTN_Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_ReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTN_Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61))
                .addGap(69, 69, 69))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61))
                    .addComponent(JBTN_Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Impresoras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        JBTN_EstablecerImpresora.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_EstablecerImpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Configuracion/Icono_ImpresoraBtn.png"))); // NOI18N
        JBTN_EstablecerImpresora.setText("Establecer");
        JBTN_EstablecerImpresora.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_EstablecerImpresora.setEfecto(rojeru_san.rsbutton.RSButtonRoundEffect.EFECTO.RIPLE);
        JBTN_EstablecerImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_EstablecerImpresoraActionPerformed(evt);
            }
        });

        lblTexto.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTexto.setText("Impresora Predeterminada");

        JLBL_Impresora.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JLBL_Impresora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Impresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Configuracion/Icono_ImpresoraLbl.png"))); // NOI18N
        JLBL_Impresora.setText("Nombre impresora");

        JCBX_SeleccionarImpresora.setBackground(new java.awt.Color(248, 248, 248));
        JCBX_SeleccionarImpresora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una impresora" }));
        JCBX_SeleccionarImpresora.setColorArrow(new java.awt.Color(34, 41, 50));
        JCBX_SeleccionarImpresora.setColorBorde(new java.awt.Color(34, 41, 50));
        JCBX_SeleccionarImpresora.setColorFondo(new java.awt.Color(34, 41, 50));
        JCBX_SeleccionarImpresora.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBTN_EstablecerImpresora, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(JCBX_SeleccionarImpresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTexto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBL_Impresora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCBX_SeleccionarImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_EstablecerImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBL_Impresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 288, Short.MAX_VALUE))
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

    private void JBTN_RespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_RespaldoActionPerformed
        if(Ventana_Principal.JLBL_AsignarTipo.getText().equals("ADMINISTRADOR")){
            Crear_Respaldo_Base_De_Datos();
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No cuentas con los permisos suficientes");
            EA.JLBL_Mensaje3.setText("para realizar esta acción.");
            EA.JLBL_Mensaje2.setText("");
            EA.setVisible(true);
        }
    }//GEN-LAST:event_JBTN_RespaldoActionPerformed

    private void JBTN_RestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_RestaurarActionPerformed
        if(Ventana_Principal.JLBL_AsignarTipo.getText().equals("ADMINISTRADOR")){
            Restaurar_Base_De_Datos();
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No cuentas con los permisos suficientes");
            EA.JLBL_Mensaje3.setText("para realizar esta acción.");
            EA.JLBL_Mensaje2.setText("");
            EA.setVisible(true);
        } 
    }//GEN-LAST:event_JBTN_RestaurarActionPerformed

    private void JBTN_ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_ReiniciarActionPerformed
        if(Ventana_Principal.JLBL_AsignarTipo.getText().equals("ADMINISTRADOR")){
            Reiniciar_Base_De_Datos();
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No cuentas con los permisos suficientes");
            EA.JLBL_Mensaje3.setText("para realizar esta acción.");
            EA.JLBL_Mensaje2.setText("");
            EA.setVisible(true);
        }
    }//GEN-LAST:event_JBTN_ReiniciarActionPerformed

    private void JBTN_EstablecerImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EstablecerImpresoraActionPerformed
        if(!JCBX_SeleccionarImpresora.getSelectedItem().toString().equals("Seleccione una impresora")){
            Establece_Impresora_Predeterminada(JCBX_SeleccionarImpresora.getSelectedItem().toString());
            Seleccionar_Impresora_Predeterminada();
        }else{
            Alerta_Error EA = new Alerta_Error(new JFrame(), true);
            EA.JLBL_Mensaje1.setText("No ha seleccionado ninguna impresora.");
            EA.JLBL_Mensaje3.setText("");
            EA.JLBL_Mensaje2.setText("");
        }
    }//GEN-LAST:event_JBTN_EstablecerImpresoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRoundEffect JBTN_EstablecerImpresora;
    private rojeru_san.rsbutton.RSButtonMetro JBTN_Reiniciar;
    private rojeru_san.rsbutton.RSButtonMetro JBTN_Respaldo;
    private rojeru_san.rsbutton.RSButtonMetro JBTN_Restaurar;
    private rojerusan.RSComboMetro JCBX_SeleccionarImpresora;
    private javax.swing.JLabel JLBL_Impresora;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
    
}