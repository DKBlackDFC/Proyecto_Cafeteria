/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.Implementaciones;

import Base_De_Datos.Conexion;
import Base_De_Datos.interfaces.DAOMetodos;
import Utilidades.Cifrado;
import java.sql.PreparedStatement;

/**
 *
 * @author DIEGO
 */
public class DAOMetodosImpI extends Conexion implements DAOMetodos {

    @Override
    public void Vaciar_Base_De_Datos() throws Exception {
        try{
            String[] tablas = {"cat_categorias","productos","usuarios"};
            
            this.Conexion();
            
            for(int i = 0;i < tablas.length;i++){
                String SQL = "DELETE FROM " + tablas[i];

                PreparedStatement ps = this.conexion.prepareStatement(SQL);
                ps.executeUpdate();

                ps.close();
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }
    
    @Override
    public void Crear_Super_Usuario() throws Exception {
        try{
            String SQL = "INSERT INTO usuarios (nom_usu,usu_usu,cont_usu,tel_usu,tipo_usu) "
                       + "VALUES(?,?,?,?,?)";
            String contrasena = Cifrado.SHA1("admin");
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, "ADMIN");
            ps.setString(2, "admin");
            ps.setString(3, contrasena);
            ps.setString(4, "0000000000");
            ps.setInt(5, 1);
            ps.executeUpdate();
            
            ps.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }
}
