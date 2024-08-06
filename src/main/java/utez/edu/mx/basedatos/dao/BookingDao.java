package utez.edu.mx.basedatos.dao;

import utez.edu.mx.basedatos.model.Booking;
import utez.edu.mx.basedatos.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Me permite hacer funciones CRUD
public class BookingDao {

    //Para la lectura de una entidad en la base de datos
    public Booking getOne(String fecha, String id_user){
        Booking b = new Booking();
        //Los simbolos ? son para evitar la inyección de código SQL
        String query = "select * from bookings where fecha = ? and id_user = ?";

        try{
            //Conectarme a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Voy a definir los parametros del query (los "?")

            ps.setString(1 , fecha);

            ps.setString(2 , id_user);

            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                //Que el usuario si exite en la base de datos

                b.setFecha(rs.getString("fecha"));

                b.setId_user(rs.getString("id_user"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return b;
    }

    public boolean insert(Booking booking){
        boolean flag = false;
        String query = "insert into bookings(fecha, start_time, end_time, id_status, id_user) values(?,?,?,?,?);";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , booking.getFecha());
            ps.setString(2 , booking.getStart_time());
            ps.setString(3 , booking.getEnd_time());
            ps.setString(4 , booking.getId_status());
            ps.setString(5 , booking.getId_user());
            if(ps.executeUpdate()==1){
                flag = true; //si se inserto el dato
                System.out.println("Reserva registrada exitosamente");
            } else {
                System.out.println("Reserva no registrada");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

}
