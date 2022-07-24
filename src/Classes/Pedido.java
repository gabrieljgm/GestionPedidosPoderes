
package Classes;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author margarita forero
 */
public class Pedido {
    private int id;
    private Date fecha_realizacion;
    private String estado;
    private int total_pedido;
    private Cliente cliente;
    private LinkedList<Poder> poder;
    
    /*Contrucutor*/

    public Pedido(int id, Date fecha_realizacion, String estado, int total_pedido, Cliente cliente, LinkedList<Poder> poder) {
        this.id = id;
        this.fecha_realizacion = fecha_realizacion;
        this.estado = estado;
        this.total_pedido = total_pedido;
        this.cliente = cliente;
        this.poder = poder;
    }

     /*Getter and Setter*/   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_realizacion() {
        return fecha_realizacion;
    }

    public void setFecha_realizacion(Date fecha_realizacion) {
        this.fecha_realizacion = fecha_realizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(int total_pedido) {
        this.total_pedido = total_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LinkedList<Poder> getPoder() {
        return poder;
    }

    public void setPoder(LinkedList<Poder> poder) {
        this.poder = poder;
    }
    
    
}
