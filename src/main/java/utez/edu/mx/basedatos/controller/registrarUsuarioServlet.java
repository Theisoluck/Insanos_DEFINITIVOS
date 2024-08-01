package utez.edu.mx.basedatos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.basedatos.dao.UserDao;
import utez.edu.mx.basedatos.model.User;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserServlet", value = "/sign_in")
public class registrarUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String first_name = req.getParameter("first_name");
        String last_nameP = req.getParameter("last_nameP");
        String last_nameM = req.getParameter("last_nameM");
        String email = req.getParameter("email");
        String pass1 = req.getParameter("password");
        String pass2 = req.getParameter("password");
        String id_user_type = req.getParameter("id_user_type");
        String id_grupo = req.getParameter("id_grupo");
        String create_time = req.getParameter("create_time");


        User u = new User();
        u.setFirst_name(first_name);
        u.setLast_nameP(last_nameP);
        u.setLast_nameM(last_nameM);
        u.setEmail(email);
        if(pass1.equals(pass2)){
            u.setPassword(pass1);
        }else{//Tus contraseñas no son iguales
            resp.sendRedirect("registroUsuario.jsp");
            System.out.println("Las contraseñas no coinciden");
        }
        u.setId_user_type(id_user_type);
        u.setId_grupo(id_grupo);
        u.setCreate_time(create_time);
        UserDao dao = new UserDao();
        if(dao.insert(u)){
            //Si se inserto
            resp.sendRedirect("verUsuarios.jsp");
        }else{
            //que nel
        }

    }

    public void destroy() {

    }

    public void init() throws ServletException {

    }
}