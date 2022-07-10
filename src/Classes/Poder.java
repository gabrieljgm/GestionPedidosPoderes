
package Classes;
import java.util.LinkedList;
import java.util.UUID;

/**
 *
 * @author margarita forero
 */
public class Poder {
    private UUID id;
    private String nombre;
    private double precio;
    private int duracion;
    private String imagen;
    private LinkedList<Dotacion> dotacion;

    /*Contrucutor*/
    
    public Poder(String nombre, double precio, int duracion, String imagen, LinkedList<Dotacion> dotacion) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
        this.imagen = imagen;
        this.dotacion = dotacion;
    }
    
    /*Getter and Setter*/
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LinkedList<Dotacion> getDotacion() {
        return dotacion;
    }

    public void setDotacion(LinkedList<Dotacion> dotacion) {
        this.dotacion = dotacion;
    }
    
    
}

