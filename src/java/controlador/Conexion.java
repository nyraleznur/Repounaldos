
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    
    Connection cnn;
    
    public Connection conexiondb(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn=DriverManager.getConnection("jdbc:mysql://localhost/banco","root","");
            JOptionPane.showMessageDialog(null, "conexion ok");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
 
        return cnn;
        
    }
    
    /*public static void main(String[]args){
        Conexion con=new Conexion();
        con.conexiondb();
    }*/
    
    
    
}
