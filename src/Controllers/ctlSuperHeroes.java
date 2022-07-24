
package Controllers;

import Classes.Cliente;
import Classes.Poder;
import Classes.Dotacion;
import Model.mdlSuperHeroes;
import java.util.LinkedList;

/**
 *
 * @author margarita forero
 */
public class ctlSuperHeroes {
   

    

    
    public void AdicionarPoderCarrito(){
        
    }
    
    public void EliminarPoderCarrito(){
        
    }
    
    public LinkedList<Poder> ConsultarPoderesCarrito(){
        mdlSuperHeroes mdlPoderes = new mdlSuperHeroes();
        LinkedList<Poder> poder = new LinkedList<>();
        poder = mdlPoderes.consultarPoderesCarrito();
        return poder;
    }
}

