/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.interfaces;

import Base_De_Datos.Construcciones.Usuarios;
import java.util.List;

/**
 *
 * @author DIEGO
 */
public interface DAOUsuarios{
    public boolean Verificar_Usuario(Usuarios usuario) throws Exception;
    public List<Usuarios> Listar(String cadena) throws Exception;
}
