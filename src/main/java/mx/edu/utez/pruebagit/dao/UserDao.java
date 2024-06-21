package mx.edu.utez.pruebagit.dao;

import mx.edu.utez.pruebagit.model.User;
import mx.edu.utez.pruebagit.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Me permite hacer funciones CRUD
public class UserDao {

    //Para la lectura de una entidad en la base de datos
    public User getOne(String user_name, String pass){
        User u = new User();
        //Los simbolos ? son para evitar la inyección de código SQL
        String query = "select * from users where user_name = ? and pass = sha2(?,256)";

        try{
            //Conectarme a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Voy a definir los parametros del query (los "?")
            ps.setString(1 , user_name);
            ps.setString(2 , pass);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                //Que el usuario si exite en la base de datos
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                u.setCody(rs.getString("cody"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public boolean insert(User user){
        boolean flag = false;
        String query = "insert into users(user_name, pass, email) values(?,?,?);";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , user.getUser_name());
            ps.setString(2 , user.getPass());
            ps.setString(3 , user.getEmail());
            if(ps.executeUpdate()==1){
                flag = true; //si se inserto el dato
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<User> getAll(){
        ArrayList<User> users = new ArrayList<>();
        String query = "select * from users";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ //Iteramos cada fila resultado de la query
                User u = new User();
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                users.add(u);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }


}
