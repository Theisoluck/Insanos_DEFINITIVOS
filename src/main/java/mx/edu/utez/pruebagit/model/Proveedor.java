package mx.edu.utez.pruebagit.model;
import java.io.Serializable;

//Bean es una estructura de datos que modela
//un objeto de la vida real, es util en diversos escenarios
public class Proveedor implements Serializable {
    private int id;
    private String user_name;
    //Siempre deben contener los metodos de
    //Constructores (al menos el vacio)
    //Y los getters y setters
    //Constructor vacio:
    public Proveedor(){

    }

    public Proveedor(int id, String user_name) {
        this.id = id;
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
