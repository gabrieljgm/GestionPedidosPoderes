package Classes;

/**
 *
 * @author margarita forero
 */
public class Cliente {

    private long id;
    private int tipoDocumento;
    private long documento;
    private String nombre;
    private String apellido;
    private String direccion;
    private int celular;
    private String email;

    /*Contrucutor*/
    public Cliente(int tipoDocumento, long documento, String nombre, String apellido, String direccion, int celular, String email) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }
    
    public Cliente(long id, int tipoDocumento, long documento, String nombre, String apellido, String direccion, int celular, String email) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }
    
    public Cliente(){
        
    }

    /*metodo setter y getter*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
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
