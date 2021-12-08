/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.Implementaciones;

import Base_De_Datos.Conexion;
import Base_De_Datos.Construcciones.Categorias;
import Base_De_Datos.interfaces.DAOCategorias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGO
 */
public class DAOCategoriasImpI extends Conexion implements DAOCategorias{
    
    @Override
    public Categorias Extraer_Categoria(String nombre) throws Exception {
        try{
            String SQL = "SELECT * FROM cat_categorias WHERE desc_cat = ?";
            Categorias modelo = new Categorias();
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, nombre);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                modelo.setId(res.getInt("id_cat"));
                modelo.setNombre(res.getString("desc_cat"));
            }
            
            return modelo;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }
    
    @Override
    public boolean Existe_Categoria(String nombre) throws Exception {
        try{
            String SQL = "SELECT id_cat FROM cat_categorias WHERE desc_cat = ?";
        
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, nombre);
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
    public void Registrar(Categorias categoria) throws Exception {
        try{
            String SQL = "INSERT INTO cat_categorias (desc_cat) VALUES(?)";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Modificar(Categorias categoria) throws Exception {
        try{
            String SQL = "UPDATE cat_categorias SET desc_cat = ? WHERE id_cat = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getId());
            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Eliminar(Categorias categoria) throws Exception {
        try{
            String SQL = "DELETE FROM cat_categorias WHERE desc_cat = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public List<Categorias> Listar(String cadena) throws Exception {
        try{
            String SQL;
            List<Categorias> datosCategoria = new ArrayList();
            
            this.Conexion();
            
            if(cadena.isEmpty()){
                SQL = "SELECT * FROM cat_categorias";  
            }else{
                SQL = "SELECT * FROM cat_categorias WHERE "
                        + "desc_cat LIKE '"+ cadena +"%'";
            }
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Categorias categoria = new Categorias();
                
                categoria.setId(res.getInt("id_cat"));
                categoria.setNombre(res.getString("desc_cat"));
                
                datosCategoria.add(categoria);
            }
            
            res.close();
            ps.close();
            
            return datosCategoria;
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }
    
}
