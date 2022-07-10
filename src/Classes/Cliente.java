
package Classes;

/**
 *
 * @author margarita forero
 */
public class Cliente {
    private String tipoDocumento;
    private long documento;
    private String nombre;
    private String apellido;
    private String razonSocial;
    private String direccion;
    private long celular;
    private String email;

    /*Contrucutor*/   

    public Cliente(String tipoDocumento, long documento, String nombre, String apellido, String razonSocial, String direccion, long celular, String email) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }
  
    
    /*metodo setter y getter*/

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
