package Controllers;

import Model.mdlCarrito;
import Model.mdlCliente;

/**
 *
 * @author margarita forero
 */
public class ctlCarritoCompra {

    private mdlCarrito mdlcarrito;

    public boolean registrarCarrito(long clienteId) {
        mdlcarrito = new mdlCarrito();
        return mdlcarrito.registrarCarrito(clienteId);
    }
}
