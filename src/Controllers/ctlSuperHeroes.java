
package Controllers;

import Classes.Cliente;
import Classes.Poder;
import Classes.Dotacion;
import java.util.LinkedList;

/**
 *
 * @author margarita forero
 */
public class ctlSuperHeroes {
   
    public Cliente inicializarCliente(){
      Cliente cliente = new Cliente("CC",785698511,"Margarita","Forero","","Cra 78 No. 52-89",300248568,"margaritamfs.forero@gmail.com");
      return cliente;
    }
    
    public LinkedList<Poder> inicializarPoder(){
        LinkedList<Dotacion> dotacion = new LinkedList<>();
        dotacion.add(new Dotacion("Capa", "Azul"));
        dotacion.add(new Dotacion("Capa", "Roja"));
        LinkedList<Dotacion> dotacion2 = new LinkedList<>();
        dotacion2.add(new Dotacion("Casco", "Verde"));
        dotacion2.add(new Dotacion("Botas", "Azul"));
        LinkedList<Dotacion> dotacion3 = new LinkedList<>();
        dotacion3.add(new Dotacion("Traje", "Invisible"));
    
                
        LinkedList<Poder> poder = new LinkedList<>();
        poder.add(new Poder("Volar",300.000,24,"volar.png",dotacion));
        poder.add(new Poder("Telequinesis",300.000,48,"volar.png",dotacion2));
        poder.add(new Poder("Invisibilidad",500.000,12,"volar.png",dotacion3));
        poder.add(new Poder("Nadar Bajo Agua",300.000,24,"volar.png",dotacion));
        poder.add(new Poder("Teletrasportacion",700.000,48,"volar.png",dotacion2));
        poder.add(new Poder("Cambia Formas",800.000,12,"volar.png",dotacion3));
        return poder; 
    }
}

