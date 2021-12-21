/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author DIEGO
 */
public class Verificaciones_Converciones {
    public static boolean Verificar_Entero(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    public static boolean Verificar_Doble(String numero){
        try{
            Double.parseDouble(numero);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    public static double Convertir_Double(String numero){
        return Double.parseDouble(numero);
    }
}
