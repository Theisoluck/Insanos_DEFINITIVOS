package mx.edu.utez.pruebagit.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.pruebagit.dao.ProveedorDao;
import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.Proveedor;
import mx.edu.utez.pruebagit.model.User;

import java.io.IOException;

@WebServlet(name="ActualizarProveedorServlet", value = "/actualizarProveedor")
public class ActualizarProveedorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        //Para buscar la info del usuario
        ProveedorDao dao = new ProveedorDao();
        Proveedor p = dao.getOne(id);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuario", p);
        //despues mandarla a un formulario para su edición
        resp.sendRedirect("RegistrarProveedor.jsp");
    }
}
