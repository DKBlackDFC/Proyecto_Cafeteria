/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_De_Datos.Implementaciones;

import Base_De_Datos.Conexion;
import Base_De_Datos.Construcciones.Usuarios;
import Base_De_Datos.interfaces.DAOUsuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGO
 */
public class DAOUsuariosImpI extends Conexion implements DAOUsuarios {

    @Override
    public boolean Verificar_Usuario(Usuarios usuario) throws Exception {
        try{
            String SQL = "SELECT U.id_usu, U.nom_usu, U.usu_usu, U.cont_usu, U.tel_usu, T.nom_rol "
                        + "FROM usuarios U INNER JOIN cat_roles T ON U.tipo_usu = T.id_rol "
                        + "WHERE U.usu_usu = ?";
            
            this.Conexion();
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, usuario.getUsuario());
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                if(usuario.getContrasena().equals(res.getString("cont_usu"))){
                    usuario.setId(Integer.parseInt(res.getString("id_usu")));
                    usuario.setNombre(res.getString("nom_usu"));
                    usuario.setTipo(res.getString("nom_rol")); 
                    
                    res.close();
                    ps.close();
                    
                    return true;
                }else{
                    res.close();
                    ps.close();
                    
                    return false;
                }
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
    public List<Usuarios> Listar(String cadena) throws Exception {
        try{
            String SQL;
            List<Usuarios> datosUsuarios = new ArrayList();
            
            this.Conexion();
            
            if(cadena.equals("")){
                SQL = "SELECT U.id_usu, U.nom_usu, U.usu_usu, U.cont_usu, U.tel_usu, T.nom_rol "
                        + "FROM usuarios U INNER JOIN cat_roles T ON U.tipo_usu = T.id_rol";
            }else{
                SQL = "SELECT U.id_usu, U.nom_usu, U.usu_usu, U.cont_usu, U.tel_usu, T.nom_rol "
                        + "FROM usuarios U INNER JOIN cat_roles T ON U.tipo_usu = T.id_rol"
                        + "WHERE (U.id_usu LIKE '"+ cadena +"%' OR "
                               + "U.nom_usu LIKE '"+ cadena +"%' OR "
                               + "U.usu_usu LIKE '"+ cadena +"%')";
            }
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Usuarios usuario = new Usuarios();
                usuario.setId(Integer.parseInt(res.getString("id_usu")));
                usuario.setNombre(res.getString("nom_usu"));
                usuario.setUsuario(res.getString("usu_usu"));
                usuario.setTelefono(res.getString("tel_usu"));
                usuario.setTipo(res.getString("nom_rol"));
                
                datosUsuarios.add(usuario);
            }
            
            res.close();
            ps.close();
            
            return datosUsuarios;
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Registrar(Usuarios usuario) throws Exception {
        try{
            String SQL = "INSERT INTO usuarios (nom_usu, usu_usu, cont_usu, tel_usu, tipo_usu) "
                       + "VALUES(?,?,?,?,?)";
            
            this.Conexion();
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getTelefono());
            ps.setInt(5, Integer.parseInt(usuario.getTipo()));
            
            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Modificar(Usuarios usuario) throws Exception {
        try{
            String SQL = "UPDATE usuarios SET "
                              + "nom_usu = ?, "
                              + "usu_usu = ?, "
                              + "tel_usu = ?, "
                              + "cont_usu = ?, "
                              + "tipo_usu = ? "
                              + "WHERE id_usu = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getTipo());
            ps.setInt(6, usuario.getId());
            
            ps.executeUpdate();
            
            ps.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public void Eliminar(Usuarios usuario) throws Exception {
        try{
            String SQL = "DELETE FROM usuarios WHERE id_usu = ?";
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setInt(1, usuario.getId());
            ps.executeUpdate();
            
            ps.close();
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public Usuarios Extraer_Datos(String codigo) throws Exception {
        try{
            String SQL = "SELECT U.nom_usu, U.usu_usu, U.tel_usu, U.cont_usu, T.nom_rol "
                       + "FROM usuarios U INNER JOIN cat_roles T ON U.tipo_usu = T.id_rol "
                       + "WHERE U.id_usu = ?";
            Usuarios modelo = new Usuarios();
            
            this.Conexion();
            
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, codigo);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                modelo.setNombre(res.getString("nom_usu"));
                modelo.setUsuario(res.getString("usu_usu"));
                modelo.setTelefono(res.getString("tel_usu"));
                modelo.setContrasena(res.getString("cont_usu"));
                modelo.setTipo(res.getString("nom_rol"));
            }
            
            return modelo;
            
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Cerrar_Conexion();
        }
    }

    @Override
    public boolean Existe_Usuario(Usuarios usuario) throws Exception {
        try{
            String SQL = "SELECT usu_usu FROM usuarios WHERE usu_usu = ?";
            
            this.Conexion();
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            ps.setString(1, usuario.getUsuario());
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
}
