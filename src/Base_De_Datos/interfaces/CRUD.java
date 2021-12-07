/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.interfaces;

import java.util.List;

/**
 *
 * @author DIEGO
 */
public interface CRUD<T > {
    public void Registrar(T t) throws Exception;
    public void Modificar(T t) throws Exception; 
    public void Eliminar(T t) throws Exception; 
    public List<T> Listar(String cadena) throws Exception;
}
