/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alertas_SC;

import Alertas.Alerta_Error;
import Base_De_Datos.Construcciones.Almacen;
import Base_De_Datos.Implementaciones.DAOAlmacenImpI;
import Base_De_Datos.interfaces.DAOAlmacen;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

/**
 *
 * @author DIEGO
 */
public class Alertas {
    private String Fecha;
    
    private void Obtener_Fecha_1(){
        Properties Datos = new Properties();
        
        try{
            InputStream Leer = new FileInputStream("src/Alertas_SC/Revision.properties");
            Datos.load(Leer);
            
        }catch(FileNotFoundException ex){
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } catch (IOException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        
        this.Fecha = Datos.getProperty("Fecha_1");
        
        Datos.clear();
    }
    private void Obtener_Fecha_2(){
        Properties Datos = new Properties();
        
        try{
            InputStream Leer = new FileInputStream("src/Alertas_SC/Revision.properties");
            Datos.load(Leer);
            
        }catch(FileNotFoundException ex){
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } catch (IOException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        
        this.Fecha = Datos.getProperty("Fecha_2");
        
        Datos.clear();
    }
    private static String Fecha_Actual() {
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }
    private static void Actualizar_Fecha_1(String nuevaFecha) throws IOException{        
        Properties datos = new Properties();
        
        InputStream Leer = new FileInputStream("src/Alertas_SC/Revision.properties");
        datos.load(Leer);
        
        datos.setProperty("Fecha_1", nuevaFecha);
        
        datos.store(new FileWriter("src/Alertas_SC/Revision.properties"), "Valor Actualizado");
        
        datos.clear();
        Leer.close();
    }
    private static void Actualizar_Fecha_2(String nuevaFecha) throws IOException{        
        Properties datos = new Properties();
        
        InputStream Leer = new FileInputStream("src/Alertas_SC/Revision.properties");
        datos.load(Leer);
        
        datos.setProperty("Fecha_2", nuevaFecha);
        
        datos.store(new FileWriter("src/Alertas_SC/Revision.properties"), "Valor Actualizado");
        
        datos.clear();
        Leer.close();
    }
    public boolean Alerta_Existencias(){
        boolean bandera = false;
        String fechaActual = Fecha_Actual();
        Obtener_Fecha_1();
        
        if(!this.Fecha.equals(fechaActual)){
            DAOAlmacen metodosAlmacen = new DAOAlmacenImpI();
            List<Almacen> datos = new ArrayList();
            
            try{
                datos = metodosAlmacen.Listar("");
                
                for(int i = 0;i < datos.size();i++){
                    if(datos.get(i).getExistencias() < 3){
                        bandera = true;
                        break;
                    }
                }
                
                Actualizar_Fecha_1(fechaActual);
            }catch(Exception ex){
                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                EA.JLBL_Mensaje1.setText("Error al ejecutar el escaneo de");
                EA.JLBL_Mensaje2.setText("las Existencias.");
                EA.JLBL_Mensaje3.setText("");
                EA.setVisible(true);
                System.out.println(ex.getMessage());
            }
        }
        return bandera;
    }
    public boolean Alerta_Caducidad(){
        boolean bandera = false;
        String fechaActual = Fecha_Actual();
        Obtener_Fecha_2();
        
        if(!this.Fecha.equals(fechaActual)){
            DAOAlmacen metodosAlmacen = new DAOAlmacenImpI();
            List<Almacen> datos = new ArrayList();
            
            try{
                datos = metodosAlmacen.Listar("");
                
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);
                Date primeraFecha = sdf.parse(fechaActual);
                Date segundaFecha;
                
                for(int i = 0;i < datos.size();i++){
                    segundaFecha = sdf.parse(datos.get(i).getFechaCaducidad());
                    
                    long dif = segundaFecha.getTime() - primeraFecha.getTime();
                    TimeUnit tiempo = TimeUnit.DAYS; 
                    long diferencia = tiempo.convert(dif, TimeUnit.MILLISECONDS);
                    
                    if(diferencia < 3){
                        bandera = true;
                        break;
                    }
                }
                
                Actualizar_Fecha_1(fechaActual);
            }catch(Exception ex){
                Alerta_Error EA = new Alerta_Error(new JFrame(), true);
                EA.JLBL_Mensaje1.setText("Error al ejecutar el escaneo de");
                EA.JLBL_Mensaje2.setText("las Existencias.");
                EA.JLBL_Mensaje3.setText("");
                EA.setVisible(true);
                System.out.println(ex.getMessage());
            }
        }
        return bandera;
    }
}
