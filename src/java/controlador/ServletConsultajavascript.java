/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.Usuariodao;

/**
 *
 * @author nyral
 */
@WebServlet(name = "ServletConsultajavascript", urlPatterns = {"/ServletConsultajavascript"})
public class ServletConsultajavascript extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
         
         
         
         
        ArrayList<Usuario>lista=new ArrayList<>();
        
        Usuariodao usdao=new Usuariodao();
        lista=usdao.consultausuraios();
        Gson gson=new Gson();
        out.print(gson.toJson(lista));
        
       boolean dat;  
       String d,u,c,r,e,i;
       d=request.getParameter("d");
       u=request.getParameter("u");
       c=request.getParameter("c");
       r=request.getParameter("r"); 
       e=request.getParameter("e");
       i="imagne";
       
       Usuario us=new Usuario(d, u, c, r, e, i);
       Usuariodao usda=new Usuariodao();
       dat=usda.insertarusuario(us);
       if(dat){
           JOptionPane.showMessageDialog(null,"Datos registrados");
       }
       else{
       
       JOptionPane.showMessageDialog(null,"Datos NO registrados");
       
       }   
        
         
         
         
         
         
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
