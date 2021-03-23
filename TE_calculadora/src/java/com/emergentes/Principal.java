package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculadora</h1>");
            
            out.println("<form action='Principal' method='post'>");
            out.println("<label>Introduce 1° Numero: </label>");
            out.println("<input type='number' name='txtNum1'><br>");
            out.println("<label>Introduce 2° Numero: </label>");
            out.println("<input type='number' name='txtNum1'><br>");
            
            out.println("<input type='checkbox' name='checkbox1'<br>");
            out.println("Suma<br>");
            out.println("<input type='checkbox' name='checkbox2'<br>");
            out.println("Resta<br>");
            out.println("<input type='checkbox' name='checkbox3'<br>");
            out.println("Multiplicacion<br>");
            out.println("<input type='checkbox' name='checkbox4'<br>");
            out.println("Division<br>");
            out.println("<br>");
            out.println("<input type='submit' value='Procesar'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int resultado;
        String numero1;
        numero1 = request.getParameter("txtNum1");
        int num1 = Integer.parseInt(numero1);
        String numero2;
        numero2 = request.getParameter("txtNum2");
        int num2 = Integer.parseInt(numero2);
        String c1;
        c1 = request.getParameter("checkbox1");
        String c2;
        c2 = request.getParameter("checkbox2");
        String c3;
        c3 = request.getParameter("checkbox3");
        String c4;
        c4 = request.getParameter("checkbox4");
                    
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculadora</h1>");
            if(c1=="checkbox1"){
                resultado=num1+num2;
                out.println("<p>El Resultado de la Suma es "+resultado+"</p>");
            }
            if(c2=="checkbox2"){
                resultado=num1-num2;
                out.println("<p>El Resultado de la Resta es "+resultado+"</p>");
            }
            if(c3=="checkbox3"){
                resultado=num1*num2;
                out.println("<p>El Resultado de la Multiplicasion es "+resultado+"</p>");
            }
            if(c4=="checkbox4"){
                resultado=num1/num2;
                out.println("<p>El Resultado de la Division es "+resultado+"</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
