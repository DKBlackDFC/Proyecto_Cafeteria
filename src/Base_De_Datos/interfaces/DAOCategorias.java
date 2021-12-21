/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.interfaces;

import Base_De_Datos.Construcciones.Categorias;

/**
 *
 * @author DIEGO
 */
public interface DAOCategorias extends CRUD<Categorias>{
    public boolean Existe_Categoria(String nombre) throws Exception;
    public Categorias Extraer_Categoria(String nombre) throws Exception;
}
