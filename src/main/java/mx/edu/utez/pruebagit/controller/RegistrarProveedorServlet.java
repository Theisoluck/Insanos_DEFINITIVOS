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

@WebServlet(name = "ProvedoorServlet", value = "/sign_in")
public class RegistrarProveedorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String operacion = req.getParameter("operacion");
        String user_name = req.getParameter("user_name");
        int id = Integer.parseInt(req.getParameter("id"));
        Proveedor p = new Proveedor();
        p.setUser_name(user_name);
        p.setId(id);
        ProveedorDao dao = new ProveedorDao();

        if(operacion != "") { //probar si isacc tenia razon
            //Que estoy haciendo una modificación / Update
            if(dao.update(Integer.parseInt(operacion),p)){
                resp.sendRedirect("gestionProveedor.jsp");
            }else{
                req.getSession().setAttribute("mensaje","No se pudo actualizar el usuario en la BD");
                resp.sendRedirect("index.jsp");
            }
        }else{
            //Insert
            if(dao.insert(p)){
                //Si se inserto
                resp.sendRedirect("index.jsp");
            }else{
                //que nel
                req.getSession().setAttribute("mensaje","No se pudo registrar el usuario en la BD");
                resp.sendRedirect("registroUsuario.jsp");
            }
        }
    }

    public void destroy() {

    }

    public void init() throws ServletException {

    }
}