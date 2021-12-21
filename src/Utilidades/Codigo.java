/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author DIEGO
 */
public class Codigo{
    public static String Generar_Codigo(String nombre, String tipo) throws IOException{
        final String ceros = "0";
        String codigo;
        
        Properties dato = new Properties();
        
        InputStream Leer = new FileInputStream("src/Utilidades/Codigo.properties");
        dato.load(Leer);
        
        codigo = tipo.substring(0,2) + nombre.substring(0,2);
        
        for(int i = 0;i < (3-dato.getProperty("Contador").length());i++){
            codigo = codigo + ceros;
        }
        
        codigo = codigo + dato.getProperty("Contador");
        
        Actualizar_Contador(dato);
        
        dato.clear();
        Leer.close();
        
        return codigo;
    }
    private static void Actualizar_Contador(Properties dato) throws IOException{
        int valorIncrementado = Integer.parseInt(dato.getProperty("Contador")) + 1;
        String nuevoValor = String.valueOf(valorIncrementado);
        
        dato.setProperty("Contador", nuevoValor);
        
        dato.store(new FileWriter("src/Utilidades/Codigo.properties"), "Valor Actualizado");
    }
    public static String Genrar_Codigo_Venta() throws IOException{
        // BC001-0001
        final String ceros= "0";
        String codigo = "SN";
        
        Properties dato = new Properties();
        
        InputStream Leer = new FileInputStream("src/Utilidades/Codigo_Venta.properties");
        dato.load(Leer);
        
        for(int i = 0;i < (3-dato.getProperty("Sucursal").length());i++){
            codigo = codigo + ceros;
        }
        
        codigo = codigo + dato.getProperty("Sucursal") + "-";
        
        for(int i = 0;i < (3-dato.getProperty("Contador").length());i++){
            codigo = codigo + ceros;
        }
        
        codigo = codigo + dato.getProperty("Contador");
        
        Actualizar_Datos(dato);
        
        dato.clear();
        Leer.close();
        
        return codigo;
    }
    private static void Actualizar_Datos(Properties dato) throws IOException{
        int contadorIncrementado = Integer.parseInt(dato.getProperty("Contador")) + 1;
        
        String nuevoValor = String.valueOf(contadorIncrementado);
        
        dato.setProperty("Contador", nuevoValor);
        
        dato.store(new FileWriter("src/Utilidades/Codigo_Venta.properties"), "Valor Actualizado");
    }
}
