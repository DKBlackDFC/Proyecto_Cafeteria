/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author DIEGO
 */

public class Conexion{
    private String bd;
    private String puerto;
    private String usuario;
    private String contrasena;
    
    protected Connection conexion;
    
    private void Obtener_Datos(){
        Properties Datos = new Properties();
        
        try{
            InputStream Leer = new FileInputStream("src/Base_De_Datos/ConfiguracionBD.properties");
            Datos.load(Leer);
            
        }catch(FileNotFoundException ex){
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } catch (IOException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        
        this.bd = Datos.getProperty("Base_De_Datos");
        this.puerto = Datos.getProperty("Puerto");
        this.usuario = Datos.getProperty("Usuario");
        this.contrasena = Datos.getProperty("Contrasena");
        
        Datos.clear();
    }
    
    public void Conexion() throws Exception{
        this.Obtener_Datos();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:"+ puerto +"/" + bd, usuario, contrasena);
        }catch(Exception ex){
            throw ex;
        }
    }
    public void Cerrar_Conexion() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}