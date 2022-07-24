package View;

import Classes.CarritoCompra;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controllers.ctlSuperHeroes;
import Classes.Poder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author margarita forero
 */
public final class FrmSuperHeroes extends JFrame implements ActionListener {


    private JLabel bienvenida;
    private JLabel itemCarrito;
    private static final String textoBienvenida = "Hola Bienvenido a la tienda de Super Poderes. Para comprar debes regisrarte primero";
    private FrmBuscarCliente buscarCliente;
    int itemsCarrito = 0;
    ArrayList<String> listaPoderes;
    CarritoCompra carrito;

    public FrmSuperHeroes() {

        listaPoderes=new ArrayList<String>();
        carrito = new CarritoCompra();
        ctlSuperHeroes ctlSHeroes = new ctlSuperHeroes();
        LinkedList<Poder> poder = ctlSHeroes.ConsultarPoderesCarrito();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        makeItemsPanel(poder);

        pack();
        setVisible(true);
    }

    private void makeItemsPanel(LinkedList<Poder> poder) {

        final JPanel main = new JPanel();
        final JPanel titulo = new JPanel();
        bienvenida = new JLabel(textoBienvenida);
        final JLabel carritoImagen = new JLabel();
        carritoImagen.setIcon(new ImageIcon(getClass().getResource("shoppingcart.png"))); // NOI18N
        itemCarrito = new JLabel("0");
        titulo.add(bienvenida);
        titulo.add(carritoImagen);
        titulo.add(itemCarrito);
        this.add(titulo, BorderLayout.NORTH);

        Iterator<Poder> iterator = poder.iterator();    
        while (iterator.hasNext()) {
            final JPanel p = new JPanel();
            Poder nextPoder = iterator.next();
            JCheckBox cb = new JCheckBox(nextPoder.getNombre());
            JLabel valor = new JLabel("$" + Double.toString(nextPoder.getPrecio()));
            JLabel duracion = new JLabel(Long.toString(nextPoder.getDuracion()) + " horas");
            JLabel imagen = new JLabel();
            imagen.setIcon(new ImageIcon(getClass().getResource(nextPoder.getImagen()))); // NOI18N
            p.add(imagen);
            p.add(cb);
            p.add(valor);
            p.add(duracion);
            cb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    System.out.println(e.getStateChange());
                    System.out.println(e.getID());
                    JCheckBox obj = (JCheckBox) e.getItem();
                    System.out.println(obj.getText());

                    System.out.println(e.getItemSelectable());
                    
                    if (e.getStateChange() ==1){
                        itemsCarrito++;
                        listaPoderes.add(obj.getText());
                    }else{
                        itemsCarrito--;
                        listaPoderes.remove(obj.getText());
                    }
                    itemCarrito.setText(String.valueOf(itemsCarrito)); 
                }
            });
            main.add(p);
        }
        final JPanel panelBotones = new JPanel();
        JButton btnRegistro = new JButton("Registro/Ingreso");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCliente = new FrmBuscarCliente(FrmSuperHeroes.this, true);
                buscarCliente.setLocationRelativeTo(null);
                buscarCliente.pack();
                buscarCliente.setVisible(true);

            }
        });
        JButton btnCarrito = new JButton("Ver Carrito");
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrito.setNombrePoderes(listaPoderes);
                buscarCliente = new FrmBuscarCliente(FrmSuperHeroes.this, true);
                buscarCliente.setCarrito(carrito);
                buscarCliente.setLocationRelativeTo(null);
                buscarCliente.pack();
                buscarCliente.setVisible(true);

            }
        });
        
        JButton pedidos = new JButton("Ver Pedidos");
        JButton envios  = new JButton("Ver Envíos");
       // panelBotones.add(btnRegistro);
        panelBotones.add(btnCarrito);
        panelBotones.add(pedidos);
        panelBotones.add(envios);

        main.setLayout(new GridLayout(2, 2));
        this.add(main, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Item(s) adicionados");

    }
}
