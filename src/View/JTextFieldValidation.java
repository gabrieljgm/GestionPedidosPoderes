/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JTextFieldValidation extends JFrame {
   JTextField tf;
   Container container;
   JLabel label;
   public JTextFieldValidation() {
      container = getContentPane();
      setBounds(0, 0, 500, 300);
      tf = new JTextField(25);
      setLayout(new FlowLayout());
      container.add(new JLabel("Enter the number"));
      container.add(tf);
      container.add(label = new JLabel());
      label.setForeground(Color.red);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      tf.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = tf.getText();
            int l = value.length();
            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyCode() ==  ke.VK_BACK_SPACE) {
               tf.setEditable(true);
               label.setText("");
            } else {
               tf.setEditable(false);
               label.setText("* Enter only numeric digits(0-9)");
            }
         }
      });
      setVisible(true);
   }
   public static void main(String[] args) {
      new JTextFieldValidation();
   }
}
