/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos;

import Base_De_Datos.Implementaciones.DAOMetodosImpI;
import Base_De_Datos.interfaces.DAOMetodos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 *
 * @author DIEGO
 */
public class Metodos_Configuracion {
    public static void Crear_Respaldo(File ruta) throws Exception {
        String[] datos = Traer_Datos();
        
        try{
            Process p = Runtime.getRuntime().exec("mysqldump -u "+ datos[2] +" -p"+ datos[3] +" cafeteria");
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream(ruta.getAbsolutePath() + "_" + Fecha_Actual() + ".sql");
            
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            
            while(leido > 0){
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            
            fos.close();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    public static void Cargar_Respaldo(String ruta) throws Exception {
        String[] datos = Traer_Datos();
        try{
            Process p = Runtime.getRuntime().exec("mysql -u "+ datos[2] +" -p"+ datos[3] +" cafeteria");
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream(ruta);
            
            byte[] buffer = new byte[1000];
            int leido = fis.read(buffer);
            
            while(leido > 0){
                os.write(buffer, 0, leido);
                leido = fis.read(buffer);
            }
            
            os.flush();
            os.close();
            fis.close();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    public static void Reiniciar_Base_De_Datos() throws Exception {
        try{
            DAOMetodos metodos = new DAOMetodosImpI();
            metodos.Vaciar_Base_De_Datos();
            metodos.Crear_Super_Usuario();
        }catch(Exception ex){
            throw ex;
        }
    }
    private static String[] Traer_Datos() throws Exception {
        Properties Datos = new Properties();
        String[] datos = new String[4];
        
        try{
            InputStream Leer = new FileInputStream("src/Base_De_Datos/ConfiguracionBD.properties");
            Datos.load(Leer);
            
        }catch(Exception ex){
            System.out.println(ex.toString());
            throw ex;
        }
        
        datos[0] = Datos.getProperty("Base_De_Datos");
        datos[1] = Datos.getProperty("Puerto");
        datos[2] = Datos.getProperty("Usuario");
        datos[3] = Datos.getProperty("Contrasena");
        
        Datos.clear();
        
        return datos;
    }
    private static String Fecha_Actual() {
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-YYYY");
        return formatofecha.format(fecha);
    }
    public static void Crear_Base_De_Datos() throws Exception {
        try{
            Connection cn = null;
            Statement stmt = null;
            
            String[] datos = Traer_Datos();
            
            String url = "jdbc:mysql://localhost:"+ datos[1] +"/";
            String usuario = datos[2];
            String contraseña = datos[3];
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(url,usuario,contraseña);
            if ( cn != null )
                System.out.println("Se ha establecido una conexión a la base de datos " +
                        "\n " + url );
            
            stmt = cn.createStatement();
            stmt.executeUpdate("CREATE DATABASE cafeteria");
            
            stmt.close();
            cn.close();
            
            Cargar_Respaldo("Complementos/cafeteria.sql");
        }catch(Exception ex){
            throw ex;
        }
    }
}    
