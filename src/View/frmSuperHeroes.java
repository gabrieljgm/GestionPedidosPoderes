package View;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controllers.ctlSuperHeroes;
import Classes.Cliente;
import Classes.Poder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author marga
 */
public final class frmSuperHeroes extends JFrame  implements ActionListener{  
    
    
    
  public frmSuperHeroes()
  {
    super("SuperHeroes Store");
    ctlSuperHeroes ctlSHeroes = new ctlSuperHeroes();
    Cliente cliente = ctlSHeroes.inicializarCliente();
    LinkedList<Poder> poder = ctlSHeroes.inicializarPoder();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(makeWelcomePanel(cliente), "North");
    makeItemsPanel(poder);

    pack();
    setVisible(true);
  }
  
  private JPanel makeWelcomePanel(Cliente cliente)
  {

    final JPanel p = new JPanel();
    p.setBackground(Color.blue);
    final JLabel l = new JLabel("Bienvenido "+cliente.getNombre() + " " + cliente.getApellido());
    l.setForeground(Color.yellow);
    p.add(l);
    return p;
  }

  private void makeItemsPanel(LinkedList<Poder> poder) {
        
      
      Iterator<Poder> iterator=poder.iterator();
      while(iterator.hasNext()){
          final JPanel p = new JPanel();
          Poder nextPoder = iterator.next();
          JCheckBox cb=new JCheckBox(nextPoder.getNombre());  
          //JLabel nombre = new JLabel(nextPoder.getNombre());
          JLabel valor = new JLabel("$"+Double.toString(nextPoder.getPrecio()));
          JLabel duracion = new JLabel(Long.toString(nextPoder.getDuracion())+" horas");
          //JLabel imagen = new JLabel();
          p.add(cb);
          p.add(valor);
          p.add(duracion);
          this.add(p);
      }
      JButton b = new JButton("Agregar al Carrito");
      b.addActionListener(this);  
      this.add(b);
      this.setLayout(new GridLayout(2,2,20,25));
               
    }
  
  @Override
    public void actionPerformed(ActionEvent e){  
       JOptionPane.showMessageDialog(this,"Item(s) adicionados");  
    }
    
}
