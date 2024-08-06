package utez.edu.mx.basedatos.dao;

import utez.edu.mx.basedatos.model.User;
import utez.edu.mx.basedatos.utils.DatabaseConnectionManager;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//Me permite hacer funciones CRUD
public class UserDao {

    //Para la lectura de una entidad en la base de datos
    public User getOne(String email, String password, int id_user_type) {
        User u = new User();
        // Los símbolos ? son para evitar la inyección de código SQL
        String query = "SELECT * FROM user WHERE email = ? AND password = sha2(?,256) AND id_user_type = ?";

        try {
            // Conectarme a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            // Me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            // Voy a definir los parámetros del query (los "?")

            ps.setString(1, email);
            ps.setString(2, password);
            ps.setInt(3, id_user_type); // Se agrega el parámetro para id_user_type

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            // Obtener la información del ResultSet
            if (rs.next()) {
                // Que el usuario sí existe en la base de datos
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setId_user_type(String.valueOf(rs.getInt("id_user_type"))); // Se obtiene el id_user_type
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }


    public boolean insert(User user){
        boolean flag = false;
        String query = "insert into user(first_name, last_nameP, last_nameM, email, password, id_user_type, id_grupo, create_time) values(?,?,?,?,sha2(?, 256),?,?,?);";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp createTime = Timestamp.valueOf(dateFormat.format(now));
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , user.getFirst_name());
            ps.setString(2 , user.getLast_nameP());
            ps.setString(3 , user.getLast_nameM());
            ps.setString(4 , user.getEmail());
            ps.setString(5 , user.getPassword());
            ps.setString(6 , user.getId_user_type());
            ps.setString(7 , user.getId_grupo());
            ps.setTimestamp(8 , createTime);
            if(ps.executeUpdate()==1){
                flag = true; //si se inserto el dato
                System.out.println("Usuario registrado exitosamente");
            } else {
                System.out.println("Usuario no registrado");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

}

