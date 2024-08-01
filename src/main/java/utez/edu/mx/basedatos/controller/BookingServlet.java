package utez.edu.mx.basedatos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.basedatos.dao.BookingDao;
import utez.edu.mx.basedatos.model.Booking;

import java.io.IOException;

@WebServlet(name = "BookingsServlet", value = "/login ")
public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ruta = "index.jsp";
        HttpSession sesion = req.getSession();

        try {
            String first_name = req.getParameter("first_name");
            String last_name = req.getParameter("last_name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String id_user_type = req.getParameter("id_user_type");
            String id_grupo = req.getParameter("id_grupo");

            BookingDao dao = new BookingDao();
            Booking b = dao.getOne(email,password);

            if (b.getFecha() != null) {
                // Que el usuario SI existe en la base de datos
                ruta = "bienvenido.jsp";
            } else {
                // Que el usuario NO existe
                // ruta = "bienvenido.jsp";
                sesion.setAttribute("mensaje", "El usuario no existe en la BD");
            }

        } catch (NumberFormatException e) {
            // Manejar el error de formato de número
            e.printStackTrace();
            //HttpSession sesion = req.getSession();
            sesion.setAttribute("mensaje", "Parámetros inválidos.");
        } catch (Exception e) {
            // Manejar cualquier otro error
            e.printStackTrace();
            // HttpSession sesion = req.getSession();
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

