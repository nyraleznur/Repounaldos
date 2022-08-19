
package modelo;

import controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Usuariodao {
    
    Conexion con=new Conexion();
    Connection cnn=con.conexiondb();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean  insertarusuario(Usuario us){
        int x=0;
        boolean dat=false;
        try {
            ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?,?)");
            ps.setString(1, us.getDocumento());
            ps.setString(2, us.getUsuario());
            ps.setString(3, us.getClave());
            ps.setString(4, us.getRol());
            ps.setString(5, us.getEstado());
            ps.setString(6, us.getImagen());
            x= ps.executeUpdate();
            JOptionPane.showMessageDialog(null, x);
           if(x>0){
               dat=true;
           }
          
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return dat;
    }
    
    
    
    
    public ArrayList<Usuario> consultausuraios(){
        ArrayList<Usuario> lista=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("SELECT * FROM usuarios");
            rs=ps.executeQuery();
            while(rs.next()){
                
                Usuario usu=new Usuario(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5), rs.getString(6));
                
                lista.add(usu);
            }
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        return  lista;
    }
    
    
    
    
    
}
