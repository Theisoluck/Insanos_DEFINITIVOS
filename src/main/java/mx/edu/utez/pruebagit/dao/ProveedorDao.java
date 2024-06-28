package mx.edu.utez.pruebagit.dao;

import mx.edu.utez.pruebagit.model.Proveedor;
import mx.edu.utez.pruebagit.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Me permite hacer funciones CRUD
public class ProveedorDao {

    //Para la lectura de una entidad en la base de datos
    public Proveedor getOne(int id){
        Proveedor p = new Proveedor();
        //Los simbolos ? son para evitar la inyección de código SQL
        String query = "select * from Proveedor where user_name = ? and id = sha2(?,256)";

        try{
            //Conectarme a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Voy a definir los parametros del query (los "?")
            ps.setString(1, String.valueOf(id));
            Object user_name = new Object();
            ps.setString(2, String.valueOf(user_name));
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                //Que el usuario si exite en la base de datos
                p.setId(rs.getInt("id"));
                p.setUser_name(rs.getString("user_name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    public boolean insert(Proveedor proveedor){
        boolean flag = false;
        String query = "insert into Proveedor(user_name, id) values(?, sha2(?,256));";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, proveedor.getUser_name());
            ps.setString(2, String.valueOf(proveedor.getId()));
            if(ps.executeUpdate() == 1){
                flag = true; //si se inserto el dato
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<Proveedor> getAll(){
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String query = "select * from Proveedor order by id desc";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ //Iteramos cada fila resultado de la query
                Proveedor p = new Proveedor();
                p.setId(rs.getInt("id"));
                p.setUser_name(rs.getString("user_name"));
                proveedores.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return proveedores;
    }

    //Si voy a editar debo tener 2 parametros 1 el ID del usuario y 2 el Ususrio como tal
    public boolean update(int id, Proveedor p){
        boolean flag = false;
        String query = "update Proveedor set user_name = ? where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p.getUser_name());
            ps.setInt(2, id);
            if(ps.executeUpdate() > 0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
}
