/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author DIEGO
 */
public class JPNL_CajerosMaqueta extends javax.swing.JPanel {
    
    public JPNL_CajerosMaqueta() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOP_MenuTabla = new rojerusan.RSPopuMenu();
        JPNL_Menu = new javax.swing.JPanel();
        JBTN_Eliminar = new rojeru_san.RSButtonRiple();
        JBTN_Editar = new rojeru_san.RSButtonRiple();
        JPNL_Principal = new javax.swing.JPanel();
        JPNL_Tabla = new javax.swing.JPanel();
        JSB_Cajeros = new javax.swing.JScrollPane();
        JTBL_Usuarios = new rojerusan.RSTableMetro();
        JPNL_Campos = new javax.swing.JPanel();
        JTFL_Buscar = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        JTFL_Nombre = new rojeru_san.rsfield.RSTextMaterial();
        JTFL_Usuario = new rojeru_san.rsfield.RSTextMaterial();
        JCBX_Tipo = new RSMaterialComponent.RSComboBoxMaterial();
        JBTN_RegistrarGuardar = new rojeru_san.RSButtonRiple();
        JBTN_Cancelar = new rojeru_san.RSButtonRiple();
        JBTN_EditarContrasena = new rojeru_san.RSButtonRiple();
        JTFL_Telefono = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        rSLabelImage6 = new rojerusan.RSLabelImage();
        rSLabelImage7 = new rojerusan.RSLabelImage();
        JPFL_Contrasena = new rojeru_san.rsfield.RSPassMaterial();
        JPFL_ConfirmarContrasena = new rojeru_san.rsfield.RSPassMaterial();
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

        JPNL_Principal.setBackground(new java.awt.Color(255, 255, 255));

        JPNL_Tabla.setBackground(new java.awt.Color(255, 255, 255));

        JTBL_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "USUARIO", "TELEFONO", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_Usuarios.setAltoHead(30);
        JTBL_Usuarios.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_Usuarios.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        JTBL_Usuarios.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_Usuarios.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_Usuarios.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_Usuarios.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_Usuarios.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_Usuarios.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_Usuarios.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Usuarios.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Usuarios.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Usuarios.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_Usuarios.setGrosorBordeFilas(0);
        JTBL_Usuarios.setGrosorBordeHead(0);
        JTBL_Usuarios.setRowHeight(30);
        JTBL_Usuarios.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_Usuarios.getTableHeader().setReorderingAllowed(false);
        JTBL_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_UsuariosMouseClicked(evt);
            }
        });
        JSB_Cajeros.setViewportView(JTBL_Usuarios);

        javax.swing.GroupLayout JPNL_TablaLayout = new javax.swing.GroupLayout(JPNL_Tabla);
        JPNL_Tabla.setLayout(JPNL_TablaLayout);
        JPNL_TablaLayout.setHorizontalGroup(
            JPNL_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_TablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSB_Cajeros, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPNL_TablaLayout.setVerticalGroup(
            JPNL_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_TablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSB_Cajeros, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPNL_Campos.setBackground(new java.awt.Color(255, 255, 255));

        JTFL_Buscar.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Buscar.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.setPlaceholder("Buscar...");
        JTFL_Buscar.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_BuscarKeyReleased(evt);
            }
        });

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_Buscar.png"))); // NOI18N

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_Nombre.png"))); // NOI18N

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_NombreUsuario.png"))); // NOI18N

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_Tipo.png"))); // NOI18N

        JTFL_Nombre.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Nombre.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Nombre.setPlaceholder("Nombre Completo");
        JTFL_Nombre.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_NombreKeyReleased(evt);
            }
        });

        JTFL_Usuario.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Usuario.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Usuario.setPlaceholder("Nombre de Usuario");
        JTFL_Usuario.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_UsuarioKeyReleased(evt);
            }
        });

        JCBX_Tipo.setForeground(new java.awt.Color(24, 23, 37));
        JCBX_Tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR TIPO", "ADMINISTRADOR", "MODERADOR", "ESTANDAR" }));
        JCBX_Tipo.setColorMaterial(new java.awt.Color(66, 63, 102));
        JCBX_Tipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JCBX_Tipo.setVelMils(300);

        JBTN_RegistrarGuardar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_RegistrarGuardar.setText("REGISTRAR");
        JBTN_RegistrarGuardar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_RegistrarGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_RegistrarGuardarActionPerformed(evt);
            }
        });

        JBTN_Cancelar.setBackground(new java.awt.Color(255, 68, 68));
        JBTN_Cancelar.setText("CANCELAR");
        JBTN_Cancelar.setColorHover(new java.awt.Color(255, 100, 100));
        JBTN_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CancelarActionPerformed(evt);
            }
        });

        JBTN_EditarContrasena.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_EditarContrasena.setText("EDITAR CONTRASEÑA");
        JBTN_EditarContrasena.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_EditarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_EditarContrasenaActionPerformed(evt);
            }
        });

        JTFL_Telefono.setForeground(new java.awt.Color(24, 23, 37));
        JTFL_Telefono.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTFL_Telefono.setPlaceholder("Teléfono");
        JTFL_Telefono.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTFL_Telefono.setSoloNumeros(true);
        JTFL_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFL_TelefonoKeyReleased(evt);
            }
        });

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_Telefono.png"))); // NOI18N

        rSLabelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_Contrasena.png"))); // NOI18N

        rSLabelImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Usuarios/Icono_Contrasena.png"))); // NOI18N

        JPFL_Contrasena.setForeground(new java.awt.Color(24, 23, 37));
        JPFL_Contrasena.setToolTipText("");
        JPFL_Contrasena.setColorMaterial(new java.awt.Color(66, 63, 102));
        JPFL_Contrasena.setPlaceholder("Contraseña");
        JPFL_Contrasena.setSelectionColor(new java.awt.Color(66, 63, 102));

        JPFL_ConfirmarContrasena.setForeground(new java.awt.Color(24, 23, 37));
        JPFL_ConfirmarContrasena.setToolTipText("");
        JPFL_ConfirmarContrasena.setColorMaterial(new java.awt.Color(66, 63, 102));
        JPFL_ConfirmarContrasena.setPlaceholder("Confirmar Contraseña");
        JPFL_ConfirmarContrasena.setSelectionColor(new java.awt.Color(66, 63, 102));

        javax.swing.GroupLayout JPNL_CamposLayout = new javax.swing.GroupLayout(JPNL_Campos);
        JPNL_Campos.setLayout(JPNL_CamposLayout);
        JPNL_CamposLayout.setHorizontalGroup(
            JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_CamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_CamposLayout.createSequentialGroup()
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPNL_CamposLayout.createSequentialGroup()
                                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFL_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPNL_CamposLayout.createSequentialGroup()
                                .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPNL_CamposLayout.createSequentialGroup()
                                .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFL_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPNL_CamposLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBTN_EditarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBTN_RegistrarGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPNL_CamposLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPNL_CamposLayout.createSequentialGroup()
                                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCBX_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JPNL_CamposLayout.createSequentialGroup()
                                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JPFL_ConfirmarContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                            .addComponent(JPFL_Contrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(JPNL_CamposLayout.createSequentialGroup()
                        .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFL_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JPNL_CamposLayout.setVerticalGroup(
            JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_CamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNL_CamposLayout.createSequentialGroup()
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFL_Telefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPNL_CamposLayout.createSequentialGroup()
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPFL_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPFL_ConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBX_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(JPNL_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBTN_RegistrarGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBTN_EditarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPNL_PrincipalLayout = new javax.swing.GroupLayout(JPNL_Principal);
        JPNL_Principal.setLayout(JPNL_PrincipalLayout);
        JPNL_PrincipalLayout.setHorizontalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPNL_PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPNL_Campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPNL_PrincipalLayout.setVerticalGroup(
            JPNL_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNL_PrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JPNL_Campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNL_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(66, 63, 102));
        jSeparator1.setForeground(new java.awt.Color(66, 63, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPNL_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(JPNL_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTFL_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_BuscarKeyReleased
        
    }//GEN-LAST:event_JTFL_BuscarKeyReleased

    private void JTFL_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_NombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_NombreKeyReleased

    private void JTFL_UsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_UsuarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_UsuarioKeyReleased

    private void JTFL_TelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFL_TelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFL_TelefonoKeyReleased

    private void JBTN_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EliminarActionPerformed
        
    }//GEN-LAST:event_JBTN_EliminarActionPerformed

    private void JBTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EditarActionPerformed
        
    }//GEN-LAST:event_JBTN_EditarActionPerformed

    private void JTBL_UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_UsuariosMouseClicked
        
    }//GEN-LAST:event_JTBL_UsuariosMouseClicked

    private void JBTN_RegistrarGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_RegistrarGuardarActionPerformed
        
    }//GEN-LAST:event_JBTN_RegistrarGuardarActionPerformed

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
       
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

    private void JBTN_EditarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_EditarContrasenaActionPerformed
        
    }//GEN-LAST:event_JBTN_EditarContrasenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_Cancelar;
    private rojeru_san.RSButtonRiple JBTN_Editar;
    private rojeru_san.RSButtonRiple JBTN_EditarContrasena;
    private rojeru_san.RSButtonRiple JBTN_Eliminar;
    private rojeru_san.RSButtonRiple JBTN_RegistrarGuardar;
    private RSMaterialComponent.RSComboBoxMaterial JCBX_Tipo;
    public static rojeru_san.rsfield.RSPassMaterial JPFL_ConfirmarContrasena;
    public static rojeru_san.rsfield.RSPassMaterial JPFL_Contrasena;
    private javax.swing.JPanel JPNL_Campos;
    private javax.swing.JPanel JPNL_Menu;
    private javax.swing.JPanel JPNL_Principal;
    private javax.swing.JPanel JPNL_Tabla;
    private rojerusan.RSPopuMenu JPOP_MenuTabla;
    private javax.swing.JScrollPane JSB_Cajeros;
    private rojerusan.RSTableMetro JTBL_Usuarios;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Buscar;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Nombre;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Telefono;
    private rojeru_san.rsfield.RSTextMaterial JTFL_Usuario;
    private javax.swing.JSeparator jSeparator1;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage6;
    private rojerusan.RSLabelImage rSLabelImage7;
    // End of variables declaration//GEN-END:variables
}
