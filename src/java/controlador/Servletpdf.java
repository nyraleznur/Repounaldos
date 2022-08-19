/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import modelo.Usuario;
import modelo.Usuariodao;

/**
 *
 * @author nyral
 */
@WebServlet(name = "Servletpdf", urlPatterns = {"/Servletpdf"})
public class Servletpdf extends HttpServlet {

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
        response.setContentType("application/pdf");
         OutputStream out=response.getOutputStream();
         
         if(request.getParameter("pdf")!=null){
             
             try {
             com.itextpdf.text.Document docpdf=new com.itextpdf.text.Document();
             PdfWriter.getInstance(docpdf, out);
             docpdf.open();
                 Paragraph par=new Paragraph();
                 Font titulo=new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD,BaseColor.BLUE);
                 par.add(new Phrase("Listado de usuarios",titulo));
                 par.setAlignment(Element.ALIGN_CENTER);
                 par.add(new Phrase(Chunk.NEWLINE));
                 par.add(new Phrase(Chunk.NEWLINE));
                 docpdf.add(par);
                 PdfPTable tabla=new PdfPTable(5);
                 tabla.setHorizontalAlignment(0);
                 tabla.setWidthPercentage(100);
                 PdfPCell doc=new PdfPCell(new Paragraph("Documento",FontFactory.getFont("arial",12,Font.BOLD,BaseColor.GREEN)));
                 PdfPCell usu=new PdfPCell(new Paragraph("Usuario",FontFactory.getFont("arial",12,Font.BOLD,BaseColor.GREEN)));
                 PdfPCell cla=new PdfPCell(new Paragraph("clave",FontFactory.getFont("arial",12,Font.BOLD,BaseColor.GREEN)));
                 PdfPCell rol=new PdfPCell(new Paragraph("Rol",FontFactory.getFont("arial",12,Font.BOLD,BaseColor.GREEN)));
                 PdfPCell est=new PdfPCell(new Paragraph("Estado",FontFactory.getFont("arial",12,Font.BOLD,BaseColor.GREEN)));
                 /*docpdf.add(doc);
                 docpdf.add(usu);
                 docpdf.add(cla);
                 docpdf.add(rol);
                 docpdf.add(est);*/
                 tabla.addCell(doc);
                 tabla.addCell(usu);
                 tabla.addCell(cla);
                 tabla.addCell(rol);
                 tabla.addCell(est);
                   
                 
                 
                 
                 ArrayList<Usuario> lista=new ArrayList<>();
                 Usuario us=new Usuario();
                 Usuariodao usdao=new Usuariodao();
                 lista=usdao.consultausuraios();
                 for(int i=0; i<lista.size(); i++){
                     us=lista.get(i);
                     tabla.addCell(us.getDocumento());
                     tabla.addCell(us.getUsuario());
                     tabla.addCell(us.getClave());
                     tabla.addCell(us.getRol());
                     tabla.addCell(us.getEstado());
                   }
                 
                 docpdf.add(tabla);
                 docpdf.close();
                 JOptionPane.showMessageDialog(null,"Se genero el pdf");
             
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "No se genero pdf");
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
