package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Salida", urlPatterns = {"/Salida"})
public class Salida extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre;
        String año;
        nombre = request.getParameter("nombre");
        año = request.getParameter("gestion");
        int años = Integer.parseInt(año);
        
        int edad = 2021 - años; 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Salida</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos recibidos</h1>");
            out.println("<p>Los datos recibidos son: </p>");
            out.println("<p>Nombre: "+nombre+"</p>");
            out.println("<p>Edad: "+edad+" años"+"</p>");
            out.println("<a href='Principal'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
