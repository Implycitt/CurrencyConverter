package org.example;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Window implements ActionListener {
 
  JFrame frame = new JFrame();
  JButton convert = new JButton();
  JTextField am = new JTextField();
  JTextField out = new JTextField();
  JComboBox want = new JComboBox<>(Globals.getSupported());
  JComboBox have = new JComboBox<>(Globals.getSupported());

  Window() {

    
    have.setBounds(150, 150, 200, 40);
    want.setBounds(450, 150, 200, 40);
    convert.setBounds(375, 250, 50, 40);
    am.setBounds(150, 250, 200, 40);
    out.setBounds(450, 250, 200, 40);

    frame.add(have); 
    frame.add(want);
    frame.add(convert);
    frame.add(am);
    frame.add(out);

    convert.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convert) {
          Globals.amount = Integer.parseInt(am.getText());
          Globals.have = (String) have.getSelectedItem();
          Globals.want = (String) want.getSelectedItem();
          Api.call();
          String returned = Api.getFinalAmount().toString();
          out.setText(returned);
        }
      }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.DARK_GRAY);
    frame.setLayout(null);
    frame.setResizable(false);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  }

  
}