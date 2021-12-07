/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.interfaces;

import Base_De_Datos.Construcciones.Usuarios;

/**
 *
 * @author DIEGO
 */
public interface DAOUsuarios extends CRUD<Usuarios>{
    public boolean Verificar_Usuario(Usuarios usuario) throws Exception;
}
