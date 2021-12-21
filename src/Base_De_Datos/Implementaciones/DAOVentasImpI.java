/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.Implementaciones;

import Base_De_Datos.Conexion;
import Base_De_Datos.Construcciones.Ventas;
import Base_De_Datos.interfaces.DAOVentas;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGO
 */
public class DAOVentasImpI extends Conexion implements DAOVentas {

    @Override
    public void Registrar(Ventas venta) throws Exception {
        try{
            String SQL = "INSERT INTO ventas (numero_venta,producto,cantidad,precio,total,cajero,fecha,forma_pago) "
                    + "VALUES(?,?,?,?,?,?,?,?)";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, venta.getNumero_venta());
            ps.setString(3, venta.getProducto());
            ps.setDouble(4, venta.getCantidad());
            ps.setDouble(5, venta.getPrecio());
            ps.setDouble(6, venta.getTotal());
            ps.setString(8, venta.getCajero());
            ps.setDate(9, Date.valueOf(venta.getFecha()));
            ps.setString(10, venta.getForma_pago());

            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public List<Ventas> Listar_Rango(String fechaInicial, String fechaFinal) throws Exception {
        try{
            String SQL = "SELECT * FROM ventas WHERE fecha BETWEEN ? AND ?";
            List<Ventas> datosVentas = new ArrayList();
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setDate(1, Date.valueOf(fechaInicial));
            ps.setDate(2, Date.valueOf(fechaFinal));
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Ventas modeloVentas = new Ventas();
                
                modeloVentas.setId(res.getInt("id"));
                modeloVentas.setNumero_venta(res.getString("numero_venta"));
                modeloVentas.setProducto(res.getString("producto"));
                modeloVentas.setCantidad(res.getDouble("cantidad"));
                modeloVentas.setPrecio(res.getDouble("precio"));
                modeloVentas.setTotal(res.getDouble("total"));
                modeloVentas.setCajero(res.getString("cajero"));
                modeloVentas.setFecha(res.getDate("fecha").toString());
                modeloVentas.setForma_pago(res.getString("forma_pago"));
                
                datosVentas.add(modeloVentas);
            }
            
            res.close();
            ps.close();
            
            return datosVentas;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public List<Ventas> Listar(String cadena) throws Exception {
        try{
            String SQL;
            List<Ventas> datosVentas = new ArrayList();
            
            this.Conexion();
            
            if(cadena.equals("")){
                SQL = "SELECT * FROM ventas";
            }else{
                SQL = "SELECT * FROM ventas WHERE ("
                        + "numero_venta LIKE '"+ cadena +"%' OR "
                        + "producto LIKE '"+ cadena +"%' OR "
                        + "cajero LIKE '"+ cadena +"%' OR "
                        + "forma_pago LIKE '"+ cadena +"%')";
            }
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Ventas modeloVentas = new Ventas();
                
                modeloVentas.setId(res.getInt("id"));
                modeloVentas.setNumero_venta(res.getString("numero_venta"));
                modeloVentas.setProducto(res.getString("producto"));
                modeloVentas.setCantidad(res.getDouble("cantidad"));
                modeloVentas.setPrecio(res.getDouble("precio"));
                modeloVentas.setTotal(res.getDouble("total"));
                modeloVentas.setCajero(res.getString("cajero"));
                modeloVentas.setFecha(res.getDate("fecha").toString());
                modeloVentas.setForma_pago(res.getString("forma_pago"));
                
                datosVentas.add(modeloVentas);
            }
            
            res.close();
            ps.close();
            
            return datosVentas;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Eliminar(String codigo) throws Exception {
        try{
            String SQL = "DELETE FROM ventas WHERE id = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, codigo);
            ps.executeUpdate();
            
            ps.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public Ventas Extraer_Venta(String id) throws Exception {
        try{
            String SQL = "SELECT * FROM ventas WHERE id = ?";
            Ventas modeloVentas = new Ventas();
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                modeloVentas.setId(res.getInt("id"));
                modeloVentas.setNumero_venta(res.getString("numero_venta"));
                modeloVentas.setProducto(res.getString("producto"));
                modeloVentas.setCantidad(res.getDouble("cantidad"));
                modeloVentas.setPrecio(res.getDouble("precio"));
                modeloVentas.setTotal(res.getDouble("total"));
                modeloVentas.setCajero(res.getString("cajero"));
                modeloVentas.setFecha(res.getDate("fecha").toString());
                modeloVentas.setForma_pago(res.getString("forma_pago"));
            }
            
            return modeloVentas;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }
    
}
