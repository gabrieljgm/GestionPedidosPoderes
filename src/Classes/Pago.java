
package Classes;
import java.util.Date;

/**
 *
 * @author margarita forero
 */
public class Pago {
    private int id;
    private Date fecha_pago;
    private String modo_pago;
    private Pedido pedido;    
    
  /*Contrucutor*/

    public Pago(int id, Date fecha_pago, String modo_pago, Pedido pedido) {
        this.id = id;
        this.fecha_pago = fecha_pago;
        this.modo_pago = modo_pago;
        this.pedido = pedido;
    }
    
    /*Getter and Setter*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getModo_pago() {
        return modo_pago;
    }

    public void setModo_pago(String modo_pago) {
        this.modo_pago = modo_pago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
