
package Classes;

import java.util.UUID;

/**
 *
 * @author margarita forero
 */
public class Dotacion {
    private UUID id;
    private String nombre;
    private String color;

    /*Contrucutor*/
    
    public Dotacion(String nombre, String color) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
