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
            out.println("<title>Matriz Caracol</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cambio de Moneda</h1>");
            out.println("<form action='Principal' method='post'>");
            out.println("<label>Introduce Tamaño: </label>");
            out.println("<input type='number' name='numero'>");
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
        String numero;
        numero = request.getParameter("numero");
        int n = Integer.parseInt(numero);
        int matriz[][];  
        matriz=new int[n][n];       
        int a = 0;
        int b = n - 1;
        int valor = 1;
        int j,i;
        
        for (j=0; j<n;j++){
            for(i = a; i <= b; i++){
                matriz[a][i] = valor;
                valor++;
            }
            for(i = a+1; i<=b; i++){
                matriz[i][b]=valor;
                valor++;
            }
            for(i = b-1; i>=a; i--){
                matriz[b][i]=valor;
                valor++;
            }
            for(i = b-1; i>=a+1; i--){
                matriz[i][a]=valor;
                valor++;
            }
            a++;
            b--;
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Salida</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Matriz Caracol de tamaño "+n+"</h1>");
            for(int fil=0;fil<n;fil++)
            {
                out.println("");
                for(int col=0;col<n;col++)
                {
                out.println("["+matriz[fil][col]+"]");
                out.println("<br>");
                }
            }  
            out.println("");
                        
            out.println("<a href='Principal'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
