
package modelo;


public class Login {
    
private String documento;
private String usuario;
private String clave;
private String rol;

    public Login(String documento, String usuario, String clave, String rol) {
        this.documento = documento;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }

    public Login(String usuario, String clave, String rol) {
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }

    public Login(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

  
    
    

    public Login() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }






}
