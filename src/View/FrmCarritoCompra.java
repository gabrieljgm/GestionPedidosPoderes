package View;

import Classes.CarritoCompra;
import Classes.Cliente;
import Classes.Poder;
import Controllers.ctlCarritoCompra;
import Controllers.ctlCliente;
import Controllers.ctlSuperHeroes;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author margarita forero
 */
public class FrmCarritoCompra extends javax.swing.JDialog {

    private JLabel bienvenida;
    private JLabel itemCarrito;
    LinkedList<Poder> poder;
    CarritoCompra carrito;
    Cliente cliente;

    public FrmCarritoCompra(CarritoCompra carritoCompra, Cliente cliente) {
        this.carrito = carritoCompra;
        this.cliente = cliente;
        ctlSuperHeroes ctlSHeroes = new ctlSuperHeroes();
        poder = ctlSHeroes.ConsultarPoderesCarrito();
        makeItemsPanel();
    }

    public void makeItemsPanel() {
        ArrayList<String> nombrePoderes = carrito.getNombrePoderes();
        final JPanel main = new JPanel();
        final JPanel titulo = new JPanel();
        bienvenida = new JLabel("Este es tu carrito de compras " + cliente.getNombre());
        titulo.add(bienvenida);
        this.add(titulo, BorderLayout.NORTH);
        Iterator<Poder> iterator = poder.iterator();
        while (iterator.hasNext()) {
            Poder nextPoder = iterator.next();
            if (nombrePoderes.contains(nextPoder.getNombre())) {

                final JPanel p = new JPanel();
                JLabel nombre = new JLabel(nextPoder.getNombre());
                JLabel valor = new JLabel("$" + Double.toString(nextPoder.getPrecio()));
                JLabel duracion = new JLabel(Long.toString(nextPoder.getDuracion()) + " horas");
                JLabel imagen = new JLabel();
                imagen.setIcon(new ImageIcon(getClass().getResource(nextPoder.getImagen()))); // NOI18N
                p.add(imagen);
                p.add(nombre);
                p.add(valor);
                p.add(duracion);
                main.add(p);
            }
        }
        final JPanel panelBotones = new JPanel();
        JButton btnContinuar = new JButton("Continuar pago");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctlCarritoCompra ctlcarrito = new ctlCarritoCompra();
                ctlcarrito.registrarCarrito(cliente.getId());

            }
        });
        panelBotones.add(btnContinuar);
        main.setLayout(new GridLayout(2, 2));
        this.add(main, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);

    }

}
