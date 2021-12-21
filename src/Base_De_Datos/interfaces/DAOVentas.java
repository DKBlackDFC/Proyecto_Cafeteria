/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.interfaces;

import Base_De_Datos.Construcciones.Ventas;
import java.util.List;

/**
 *
 * @author DIEGO
 */
public interface DAOVentas {
    public void Registrar(Ventas venta) throws Exception;
    public void Eliminar(String codigo) throws Exception;
    public Ventas Extraer_Venta(String id) throws Exception;
    public List<Ventas> Listar(String cadena) throws Exception;
    public List<Ventas> Listar_Rango(String fechaInicial, String fechaFinal) throws Exception;
}
