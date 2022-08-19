<%
HttpSession dat=request.getSession();
String usu=(String)dat.getAttribute("usuario");
if(usu==null){
response.sendRedirect("index.jsp");

 }




%>

<%@page import="modelo.Usuariodao"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="controlador.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/gestionusuario.js"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <label><%=usu%></label> 
        <h1>Insertar usuarios</h1>
        
        <form action="" method="" enctype="">
        <input id="doc"  class="doc" type="text" name="doc" placeholder="Ingrese documento">
        <input id="usu" class="usu" type="text" name="usu" placeholder="Ingrese nombre">
        <input id="cla" class="cla" type="text" name="cla" placeholder="Ingrese clave">
        <input id="rol" class="rol" type="text" name="rol" placeholder="Ingrese rol">
        <input id="est" class="est" type="text" name="est" placeholder="Ingrese estado">
        <input id="est" class="est" type="file" name="ima" placeholder="Ingrese estado">
        <input id="btnenv" class="btninsertar" type="button" name="btnnn" value="Insertar"> 
        </form>
        
        
        
        <table border="1">
            <thead>
                <tr>
                    <th>Documento</th>
                    <th>Usuario</th>
                    <th>Clave</th>
                    <th>Rol</th>
                    <th>Estado</th>
                    <th>Imagen</th>
                </tr>
            </thead>
           <tbody>
    <%
      ArrayList<Usuario> list=new ArrayList<>();
      Usuario sus=new Usuario();
      Usuariodao usdao=new Usuariodao();
      list=usdao.consultausuraios();
      for(int i=0; i<list.size(); i++){
      
        sus=list.get(i);
    
        JOptionPane.showMessageDialog(null,sus.getImagen());
    
    %>        
          
                <tr>
                    <td><%=sus.getDocumento()%></td>
                    <td><%=sus.getUsuario()%></td>
                    <td><%=sus.getClave()%></td>
                    <td><%=sus.getRol()%></td>
                    <td><%=sus.getEstado()%></td>
                    <td><img src="<%=sus.getImagen()%>"  width="50px"  height="50px"></td>
                </tr>
                
         <%
         
             }
         %>
            </tbody>
        </table>
            <form action="Servletpdf" method="POST">
                <input type="submit" name="pdf"  value="pdf">  
                
                
            </form>
            
            
            
            
            <table   id="tabla">
                
            </table>
            
    </body>
</html>
