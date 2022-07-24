
package Classes;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author margarita forero
 */
public class CarritoCompra {
    private int id;
    private LinkedList<Poder> poder;
    private Date fecha_creacion;
    private int total;
    private Cliente cliente;
    private ArrayList<String> nombrePoderes;

    /*Contrucutor*/
    
    public CarritoCompra(int id, LinkedList<Poder> poder, Date fecha_creacion, int total, Cliente cliente) {
        this.id = id;
        this.poder = poder;
        this.fecha_creacion = fecha_creacion;
        this.total = total;
        this.cliente = cliente;
    }
    
    public CarritoCompra(){
        
    }

    public ArrayList<String> getNombrePoderes() {
        return nombrePoderes;
    }

    public void setNombrePoderes(ArrayList<String> nombrePoderes) {
        this.nombrePoderes = nombrePoderes;
    }
    
    /*Getter and Setter*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Poder> getPoder() {
        return poder;
    }

    public void setPoder(LinkedList<Poder> poder) {
        this.poder = poder;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
