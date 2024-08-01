package utez.edu.mx.basedatos.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

//Bean es una estructura de datos que modela
//un objeto de la vida real, es util en diversos escenarios
public class User implements Serializable {
    private String first_name;
    private String last_nameP;
    private String last_nameM;
    private String email;
    private String password;
    private String id_user_type;
    private String id_grupo;
    private String create_time;
    private String cody;
    private boolean estado;

    //Siempre deben contener los metodos de
    //Constructores (al menos el vacio)
    //Y los getters y setters

    //Constructor vacio:
    public User(){

    }

    public User(String first_name, String last_nameP, String last_nameM, String email, String password, String id_user_type, String id_grupo, String cody, boolean estado) {
        this.first_name = first_name;
        this.last_nameP = last_nameP;
        this.last_nameM = last_nameM;
        this.email = email;
        this.password = password;
        this.id_user_type = id_user_type;
        this.id_grupo = id_grupo;
        this.cody = cody;
        this.estado = estado;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_nameP() {
        return last_nameP;
    }

    public void setLast_nameP(String last_nameP) {
        this.last_nameP = last_nameP;
    }
    public String getLast_nameM() {
        return last_nameM;
    }
    public void setLast_nameM(String last_nameM) {
        this.last_nameM = last_nameM;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_user_type() {
        return id_user_type;
    }

    public void setId_user_type(String id_user_type) {
        this.id_user_type = id_user_type;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getCreate_time() {
        return create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCody() {
        return cody;
    }

    public void setCody(String cody) {
        this.cody = cody;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

