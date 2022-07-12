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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author marga
 */
public final class frmSuperHeroes extends JFrame  implements ActionListener{  
    
    
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JLabel jLabel1;
    
    
  public frmSuperHeroes()
  {
      
    //super("SuperHeroes Store");
    ctlSuperHeroes ctlSHeroes = new ctlSuperHeroes();
    Cliente cliente = ctlSHeroes.inicializarCliente();
    LinkedList<Poder> poder = ctlSHeroes.inicializarPoder();
    
    //initComponents(cliente, poder);
    
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   add(makeWelcomePanel(cliente));
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
          JLabel valor = new JLabel("$"+Double.toString(nextPoder.getPrecio()));
          JLabel duracion = new JLabel(Long.toString(nextPoder.getDuracion())+" horas");
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
                  //System.out.println(e.getItem());
                  JCheckBox obj = (JCheckBox) e.getItem();
                  System.out.println(obj.getText());
                  
                  System.out.println(e.getItemSelectable());
                 
                  //JOptionPane.showMessageDialog(null,"Item(s) adicionados");  
              }
          });
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

    private void initComponents(Cliente cliente, LinkedList<Poder> poder) {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jPanel1 = new javax.swing.JPanel();
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jLabel1 = new JLabel();
        jLabel1.setText("Bienvenido "+cliente.getNombre() + " " + cliente.getApellido());
        jPanel1.setLayout(jPanel1Layout);
        jPanel1.add(jLabel1);
        add(jPanel1);
        
        // inicializamos el panel de poderes
        jPanel2 = new javax.swing.JPanel();
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        Iterator<Poder> iterator=poder.iterator();
        while(iterator.hasNext()){
            final JPanel p = new JPanel();
            Poder nextPoder = iterator.next();
            JCheckBox cb=new JCheckBox(nextPoder.getNombre());  
            JLabel valor = new JLabel("$"+Double.toString(nextPoder.getPrecio()));
            JLabel duracion = new JLabel(Long.toString(nextPoder.getDuracion())+" horas");
            JLabel imagen = new JLabel();
            imagen.setIcon(new ImageIcon(getClass().getResource(nextPoder.getImagen()))); // NOI18N
            p.add(imagen);
            p.add(cb);
            p.add(valor);
            p.add(duracion);
            jPanel2.add(p);
        }
        add(jPanel2);
        pack();
        setVisible(true);
        

    }
    
}
