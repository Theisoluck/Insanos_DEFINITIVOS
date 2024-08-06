package utez.edu.mx.basedatos.dao;

import utez.edu.mx.basedatos.model.Building;
import utez.edu.mx.basedatos.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuildingDao {

    // Para obtener un edificio por su ID
    public Building getOne(int id) {
        Building b = new Building();
        String query = "SELECT * FROM buildings WHERE id = ?";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b.setId_building(rs.getInt("id"));
                b.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }

    // Para insertar un nuevo edificio
    public boolean insert(Building building) {
        boolean flag = false;
        String query = "INSERT INTO buildings(name) VALUES(?)";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, building.getName());

            if (ps.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    // Para obtener todos los edificios
    public ArrayList<Building> getAll() {
        ArrayList<Building> buildings = new ArrayList<>();
        String query = "SELECT * FROM buildings";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Building b = new Building();
                b.setId_building(rs.getInt("id"));
                b.setName(rs.getString("name"));
                buildings.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buildings;
    }

    // Para actualizar un edificio por su ID
    public boolean update(Building building) {
        boolean flag = false;
        String query = "UPDATE buildings SET name = ? WHERE id = ?";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, building.getName());
            ps.setInt(2, building.getId_building());

            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }



    public boolean delete(Building building) {
        boolean flag = false;
        String query = "DELETE FROM buildings WHERE id = ?";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, building.getId_building());

            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}


