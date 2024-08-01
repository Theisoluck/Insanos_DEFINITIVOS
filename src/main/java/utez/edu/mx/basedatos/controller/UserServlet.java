package utez.edu.mx.basedatos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.basedatos.dao.UserDao;
import utez.edu.mx.basedatos.model.User;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(name = "UsersServlet", value = "/registroUsuario")
class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ruta = "RegistroUsuario.jsp";
        HttpSession sesion = req.getSession();

        try {
            String first_name = req.getParameter("first_name");
            String last_nameP = req.getParameter("last_nameP");
            String last_nameM = req.getParameter("last_nameM");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String id_user_type = req.getParameter("id_user_type");
            String id_grupo = req.getParameter("id_grupo");
            String create_time = req.getParameter("create_time");

            UserDao dao = new UserDao();
            User u = dao.getOne(email, password, Integer.valueOf(id_user_type) );

            if (u.getEmail() != null) {
                // El usuario existe en la base de datos
                if (u.getId_user_type().equals(id_user_type)) {
                    // El tipo de usuario coincide
                    ruta = "registroUsuario.jsp";
                } else {
                    // El tipo de usuario no coincide
                    sesion.setAttribute("mensaje", "No coincide con el tipo de usuario.");
                }
            } else {
                // El usuario no existe
                sesion.setAttribute("mensaje", "El usuario no existe en la BD");
            }

        } catch (NumberFormatException e) {
            // Manejar el error de formato de número
            e.printStackTrace();
            sesion.setAttribute("mensaje", "Parámetros inválidos.");
        } catch (Exception e) {
            // Manejar cualquier otro error
            e.printStackTrace();
            sesion.setAttribute("mensaje", "Error interno del servidor.");
        }

        resp.sendRedirect(ruta);
    }
    public void destroy() {
        // Aquí puedes liberar recursos si es necesario
    }

    public void init() throws ServletException {
        // Aquí puedes inicializar recursos si es necesario
    }
}





