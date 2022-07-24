package Controllers;

import Classes.Cliente;
import Model.mdlCliente;

/**
 *
 * @author margarita forero
 */
public class ctlCliente {
    
    private mdlCliente mdlcliente;
    
    public Cliente consultarCliente(int tipoDocumento, long documento){
        
        mdlcliente = new mdlCliente();
        return mdlcliente.consultarCliente(tipoDocumento, documento);
           
    }
    
    public boolean registrarCliente(Cliente cliente){
        
        mdlcliente = new mdlCliente();
        return mdlcliente.registrarCliente(cliente);

    }
}
