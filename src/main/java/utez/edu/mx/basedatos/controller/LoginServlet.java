package utez.edu.mx.basedatos.controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.basedatos.dao.UserDao;
import utez.edu.mx.basedatos.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String category = request.getParameter("category");
        System.out.println(email);
        System.out.println(password);
        System.out.println(category);
        int id_user_type = 0;
        switch (category){
            case "Estudiante":
                id_user_type = 3;
                break;
            case "Administrador":
                id_user_type = 1;
                break;
            case "Maestro":
                id_user_type =2;
                break;
            default:
                break;
        }

        UserDao user = new UserDao();
        User userLogged;
        userLogged = user.getOne(email, password, id_user_type);

        System.out.println(userLogged.getEmail());

        if(userLogged.getEmail() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", email);
            response.sendRedirect("bienvenido.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("mensaje", "Credenciales incorrectas. Inténtalo de nuevo.");
            response.sendRedirect("index.jsp");
        }
    }
}

