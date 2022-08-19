/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.Usuariodao;

/**
 *
 * @author nyral
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
@MultipartConfig
public class ServletUsuario extends HttpServlet {

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
         String d,u,c,r,e,nomarc,nombre,url;
         boolean y;
         
         if(request.getParameter("btnnn")!=null){
         d=request.getParameter("doc");
         u=request.getParameter("usu");
         c=request.getParameter("cla");
         r=request.getParameter("rol");
         e=request.getParameter("est");
         Part i=request.getPart("ima");
         nomarc=i.getSubmittedFileName();
         nombre=d+nomarc;
         url="C:\\Users\\nyral\\OneDrive\\Documents\\NetBeansProjects\\banco475\\web\\imagen\\"+nombre;
         String url2="imagen\\"+nombre;
         InputStream file=i.getInputStream();
         File f=new File(url);
         FileOutputStream salida=new FileOutputStream(f);
         int num=file.read();
         while(num !=-1){
             salida.write(num);
             num=file.read();
             
         }
         
         
         
         
          JOptionPane.showMessageDialog(null, d+c+r+e+i+u);
          Usuario us=new Usuario(d, u, c, r, e, url2);
          Usuariodao usdao=new Usuariodao();
          y= usdao.insertarusuario(us);
          
          JOptionPane.showMessageDialog(null, y);
          if(y){
              JOptionPane.showMessageDialog(null, "datos insertados");
          }
          
          else{
              JOptionPane.showMessageDialog(null, "datos  NO insertados");
          }
             
         
         
         
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
