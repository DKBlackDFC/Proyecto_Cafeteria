/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.interfaces;

import Base_De_Datos.Construcciones.Almacen;

/**
 *
 * @author DIEGO
 */
public interface DAOAlmacen extends CRUD<Almacen>{
    public boolean Existe_Producto(String codigo) throws Exception;
    public Almacen Extraer_Datos(String codigo) throws Exception;
}
