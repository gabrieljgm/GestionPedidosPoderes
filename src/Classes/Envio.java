
package Classes;
import java.util.Date;

/**
 *
 * @author margarita forero
 */
public class Envio {
    private int id;
    private String departamento;
    private String ciudad;
    private String direccion;
    private Date fecha_envio;
    private String empresa_mensajeria;
    private String estado;
    private Pedido pedido;

    /*Contrucutor*/
    
    public Envio(int id, String departamento, String ciudad, String direccion, Date fecha_envio, String empresa_mensajeria, String estado, Pedido pedido) {
        this.id = id;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.fecha_envio = fecha_envio;
        this.empresa_mensajeria = empresa_mensajeria;
        this.estado = estado;
        this.pedido = pedido;
    }

    /*Getter and Setter*/ 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getEmpresa_mensajeria() {
        return empresa_mensajeria;
    }

    public void setEmpresa_mensajeria(String empresa_mensajeria) {
        this.empresa_mensajeria = empresa_mensajeria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
