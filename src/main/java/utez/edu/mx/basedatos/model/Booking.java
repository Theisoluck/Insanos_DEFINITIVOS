package utez.edu.mx.basedatos.model;

import java.io.Serializable;

public class Booking implements Serializable {
    private String fecha;
    private String start_time;
    private String end_time;
    private String id_status;
    private String id_user;


    public Booking() {

    }

    public Booking(String fecha, String start_time, String end_time, String id_status, String id_user) {
        this.fecha = fecha;
        this.start_time = start_time;
        this.end_time = end_time;
        this.id_status = id_status;
        this.id_user = id_user;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
