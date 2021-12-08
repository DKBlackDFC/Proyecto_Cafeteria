/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.Implementaciones;

import Base_De_Datos.Conexion;
import Base_De_Datos.Construcciones.Almacen;
import Base_De_Datos.interfaces.DAOAlmacen;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGO
 */
public class DAOAlmacenImpI extends Conexion implements DAOAlmacen{

    @Override
    public boolean Existe_Producto(String codigo) throws Exception {
        try{
            String SQL = "SELECT id_prod FROM productos WHERE id_prod = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, codigo);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                res.close();
                ps.close();
                
                return true;
            }else{
                res.close();
                ps.close();
                
                return false;
            }
        }catch(Exception ex){
            throw ex; 
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public Almacen Extraer_Datos(String codigo) throws Exception {
        try{
            String SQL = "SELECT * FROM almacen WHERE codigo LIKE '%"+codigo+"%'";
            Almacen modelo = new Almacen();
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                modelo.setId(res.getInt("id"));
                modelo.setCodigo(res.getString("codigo"));
                modelo.setCategoria(res.getString("categoria"));
                modelo.setDescripcion(res.getString("descripcion"));
                modelo.setPrecio(res.getDouble("precio"));
                modelo.setGanancia_menudeo(res.getDouble("ganancia_menudeo"));
                modelo.setGanancia_mayoreo(res.getDouble("ganancia_mayoreo"));
                modelo.setPrecio_venta_menudeo(res.getDouble("precio_venta_menudeo"));
                modelo.setPrecio_venta_mayoreo(res.getDouble("precio_venta_mayoreo"));
                modelo.setExistencias(res.getDouble("existencias"));
                modelo.setUnidad_venta(res.getString("unidad_venta"));
                modelo.setUbicacion(res.getString("ubicacion"));
            }
            
            res.close();
            ps.close();
            
            return modelo;
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Registrar(Almacen producto) throws Exception {
        try{
            String SQL = "INSERT INTO productos VALUES("+ 0 +",?,?,?,?,?,?,?,?)";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, Integer.parseInt(producto.getCategoria()));
            ps.setDouble(3, producto.getPrecioCompra());
            ps.setDouble(4, producto.getPrecioVenta());
            ps.setDouble(5, producto.getExistencias());
            ps.setInt(6, Integer.parseInt(producto.getUnidad_venta()));
            ps.setDate(7, Date.valueOf(producto.getFechaCaducidad()));
            ps.setInt(8, Integer.parseInt(producto.getProveedor()));
            
            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Modificar(Almacen producto) throws Exception {
        try{
            String SQL = "UPDATE productos SET "
                    + "desc_prod = ?, "
                    + "cat_prod = ?, "
                    + "prec_comp = ?, "
                    + "prec_ven = ?, "
                    + "cant_prod = ?, "
                    + "uni_prod = ?, "
                    + "fcad_prod = ? "
                    + "prov_prod = ? "
                    + "WHERE id_prod = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, Integer.parseInt(producto.getCategoria()));
            ps.setDouble(3, producto.getPrecioCompra());
            ps.setDouble(4, producto.getPrecioVenta());
            ps.setDouble(5, producto.getExistencias());
            ps.setInt(6, Integer.parseInt(producto.getUnidad_venta()));
            ps.setDate(7, Date.valueOf(producto.getFechaCaducidad()));
            ps.setInt(8, Integer.parseInt(producto.getProveedor()));
            ps.setInt(9, producto.getId());
            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Eliminar(Almacen producto) throws Exception {
        try{
            String SQL = "DELETE FROM productos WHERE id_prod = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setInt(1, producto.getId());
            ps.executeUpdate();
            
            ps.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public List<Almacen> Listar(String cadena) throws Exception {
        try{
            String SQL;
            List<Almacen> datosAlmacen = new ArrayList();
            
            this.Conexion();
            
            if(cadena.equals("")){
                SQL = "SELECT * FROM almacen";
            }else{
                SQL = "SELECT * FROM almacen WHERE ("
                        + "codigo LIKE '"+ cadena +"%' OR "
                        + "descripcion LIKE '"+ cadena +"%' OR "
                        + "categoria LIKE '"+ cadena +"%' OR "
                        + "ubicacion LIKE '"+ cadena +"%')";
            }
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Almacen modelo = new Almacen();
                
                modelo.setId(res.getInt("id"));
                modelo.setCodigo(res.getString("codigo"));
                modelo.setCategoria(res.getString("categoria"));
                modelo.setDescripcion(res.getString("descripcion"));
                modelo.setPrecio(res.getDouble("precio"));
                modelo.setGanancia_menudeo(res.getDouble("ganancia_menudeo"));
                modelo.setGanancia_mayoreo(res.getDouble("ganancia_mayoreo"));
                modelo.setPrecio_venta_menudeo(res.getDouble("precio_venta_menudeo"));
                modelo.setPrecio_venta_mayoreo(res.getDouble("precio_venta_mayoreo"));
                modelo.setExistencias(res.getDouble("existencias"));
                modelo.setUnidad_venta(res.getString("unidad_venta"));
                modelo.setUbicacion(res.getString("ubicacion"));
                
                datosAlmacen.add(modelo);
            }
            
            res.close();
            ps.close();
            
            return datosAlmacen;
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }
    
}
