package utez.edu.mx.basedatos.model;

public class Building {
    int id_building;
    String name;

    public Building() {
    }

    public Building(int id_building, String name) {
        this.id_building = id_building;
        this.name = name;
    }

    public int getId_building() {
        return id_building;
    }

    public void setId_building(int id_building) {
        this.id_building = id_building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


