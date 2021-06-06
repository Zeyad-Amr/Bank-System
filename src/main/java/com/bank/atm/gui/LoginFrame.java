package com.bank.atm.gui;

import javax.swing.*;

import com.bank.atm.model.Account;
import com.bank.atm.service.Auth;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginFrame {
  JFrame loginFrame = new JFrame("Bankoo Account");

  // Create ACTIONS............//
  BL b = new BL();
  // END OF ACTIONS............//
  // Create Variables.......//
  JPanel p1 = new JPanel();
  JTextField t1 = new JTextField("National ID");
  JPasswordField t2 = new JPasswordField("Password");
  JButton b1 = new JButton("  Login  ");
  JButton b2 = new JButton("  Create New Account ");
  JLabel L1 = new JLabel("NATIONAL ID");
  JLabel L2 = new JLabel("PASSWORD");
  JLabel L3 = new JLabel("Login");
  JLabel L4 = new JLabel("New User");
  // END VARIABLES.........................................//
  // SET IMAGE......................//
  ImageIcon image1 = new ImageIcon(getClass().getResource("../images/Login.png"));
  JLabel img = new JLabel(image1);
  // END OF IMAGE......................//

  public LoginFrame() {

    // SET FRAME..................//
    loginFrame.setTitle("Login");
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginFrame.setVisible(true);
    loginFrame.setResizable(false);
    loginFrame.setSize(1000, 666);
    loginFrame.setLocation(200, 20);
    // END OF FRAME..................//

    // SET LAYOUT OF FRAME................//
    loginFrame.setLayout(null);
    img.setBounds(0, 0, 501, 666);
    p1.setBounds(501, 0, 501, 666);
    // END OF LAYOUT OF FRAME................//
    //// SET PANEL.....................//
    p1.setLayout(null);
    // 1 ADD TO PANEL.............//
    p1.add(b1);
    p1.add(b2);
    p1.add(L1);
    p1.add(L2);
    p1.add(L3);
    p1.add(L4);
    p1.add(t1);
    p1.add(t2);
    // 2 LAYOUT OF THE PANEL.....................//
    int x = 50;
    L3.setBounds(170, 60, 150, 70);

    L1.setBounds(60 + x, 160, 215, 30);
    L2.setBounds(60 + x, 240, 215, 30);

    t1.setBounds(60 + x, 200, 215, 30);
    t2.setBounds(60 + x, 275, 215, 30);

    b1.setBounds(70 + x, 340, 195, 40);
    L4.setBounds(70, 560, 215, 40);
    b2.setBounds(250, 560, 200, 40);
    // COLORS AND FONT............//
    // FONT.........................//
    L3.setFont(new Font("Arial Rounded MT bold", 70, 40));
    L2.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L1.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L4.setFont(new Font("Arial Rounded MT bold", 35, 25));
    // END OF FONT.........................//

    // COLORS.................................//
    p1.setBackground(new java.awt.Color(34, 45, 65));

    L1.setForeground(Color.WHITE);
    L2.setForeground(Color.WHITE);
    L3.setForeground(Color.WHITE);
    L4.setForeground(Color.WHITE);

    t1.setBackground(new java.awt.Color(34, 45, 65));
    t2.setBackground(new java.awt.Color(34, 45, 65));

    t1.setForeground(Color.WHITE);
    t2.setForeground(Color.WHITE);

    b1.setBackground(new java.awt.Color(161, 194, 255));
    b2.setBackground(new java.awt.Color(161, 194, 255));
    // END OF COLORS.................................//
    // ADD TO FRAME................//
    loginFrame.add(p1);
    loginFrame.add(img);
    // ACTIONS..............//
    b1.addActionListener(b);
    b2.addActionListener(b);
    // END OF ACTIONS............//
    // EMPTY THE TEXT
    // FIELDS......................................................///////////
    t1.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        t1.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
      }
    });
    t2.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        t2.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
      }
    });
    // END OF EMPTY THE TEXT
    // FIELDS......................................................//////
  }

  // EVENTS........................//
  private class BL implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == b1) {
        String nationalId = t1.getText();
        String password = t2.getText();
        System.out.println(nationalId + "  " + password);
        Account account = Auth.login(nationalId, password);
        if (account != null) {
          new AccountFrame(account);
          loginFrame.dispose();
        }
      }

      if (e.getSource() == b2) {
        SignupFrame create = new SignupFrame();
        loginFrame.dispose();
      }

    }
  }
}
