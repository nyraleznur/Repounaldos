
package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDAO {
    
    Conexion con=new Conexion();
    Connection cnn=con.conexiondb();
    PreparedStatement ps;
    ResultSet rs;
    Login logg;
    
      
    public Login Loginususraio(Login lo){
               
        try {
            ps=cnn.prepareStatement("SELECT nomusu,clave,rol FROM usuarios WHERE nomusu=? AND clave=?");
            ps.setString(1, lo.getUsuario());
            ps.setString(2, lo.getClave());
            rs=ps.executeQuery();
            while(rs.next()){
                logg=new Login(rs.getString(1), rs.getString(2), rs.getString(3));
                
            }
            
                 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       return logg;
    }
    
    
    
}
