package mx.edu.utez.pruebagit.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.User;

import java.io.IOException;

@WebServlet(name="ActualizarUsuarioServlet", value = "/actualizarUsuario")
public class ActualizarUsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        //Para buscar la info del usuario
        UserDao dao = new UserDao();
        User u = dao.getOne(email);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuario", u);
        //despues mandarla a un formulario para su edición
        resp.sendRedirect("registroUsuario.jsp");
    }
}
