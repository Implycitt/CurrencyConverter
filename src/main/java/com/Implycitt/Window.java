package com.Implycitt;

import java.awt.*;

import javax.swing.*;

public class Window {
  public static void createWindow() {
    JFrame frame = new JFrame("Currency Converter"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComboBox have = new JComboBox(Globals.getSupported());
    have.setPreferredSize(new Dimension(300, 100));
    frame.getContentPane().add(have, BorderLayout.CENTER); 

    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setSize(800, 600);
    frame.getContentPane().setBackground(Color.DARK_GRAY);
    frame.setVisible(true);
  } 
}
