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
  JTextField NationalIDTextField = new JTextField("National ID");
  JPasswordField PasswordTextField = new JPasswordField("Password");
  JButton LoginButton = new JButton("  Login  ");
  JButton Create_New_Account_Button = new JButton("  Create New Account ");
  JLabel NATIONALIDLabel = new JLabel("NATIONAL ID");
  JLabel PASSWORDLabel = new JLabel("PASSWORD");
  JLabel LoginLabel = new JLabel("Login");
  JLabel NewUserLabel = new JLabel("New User");
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
    p1.add(LoginButton);
    p1.add(Create_New_Account_Button);
    p1.add(NATIONALIDLabel);
    p1.add(PASSWORDLabel);
    p1.add(LoginLabel);
    p1.add(NewUserLabel);
    p1.add(NationalIDTextField);
    p1.add(PasswordTextField);
    // 2 LAYOUT OF THE PANEL.....................//
    int x = 50;
    LoginLabel.setBounds(170, 60, 150, 70);

    NATIONALIDLabel.setBounds(60 + x, 160, 215, 30);
    PASSWORDLabel.setBounds(60 + x, 240, 215, 30);

    NationalIDTextField.setBounds(60 + x, 200, 215, 30);
    PasswordTextField.setBounds(60 + x, 275, 215, 30);

    LoginButton.setBounds(70 + x, 340, 195, 40);
    NewUserLabel.setBounds(70, 560, 215, 40);
    Create_New_Account_Button.setBounds(250, 560, 200, 40);
    // COLORS AND FONT............//
    // FONT.........................//
    LoginLabel.setFont(new Font("Arial Rounded MT bold", 70, 40));
    PASSWORDLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    NATIONALIDLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    NewUserLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    // END OF FONT.........................//

    // COLORS.................................//
    p1.setBackground(new java.awt.Color(34, 45, 65));

    NATIONALIDLabel.setForeground(Color.WHITE);
    PASSWORDLabel.setForeground(Color.WHITE);
    LoginLabel.setForeground(Color.WHITE);
    NewUserLabel.setForeground(Color.WHITE);

    NationalIDTextField.setBackground(new java.awt.Color(34, 45, 65));
    PasswordTextField.setBackground(new java.awt.Color(34, 45, 65));

    NationalIDTextField.setForeground(Color.WHITE);
    PasswordTextField.setForeground(Color.WHITE);

    LoginButton.setBackground(new java.awt.Color(161, 194, 255));
    Create_New_Account_Button.setBackground(new java.awt.Color(161, 194, 255));
    // END OF COLORS.................................//
    // ADD TO FRAME................//
    loginFrame.add(p1);
    loginFrame.add(img);
    // ACTIONS..............//
    LoginButton.addActionListener(b);
    Create_New_Account_Button.addActionListener(b);
    // END OF ACTIONS............//
    // EMPTY THE TEXT
    // FIELDS......................................................///////////
    NationalIDTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("National ID".equals(NationalIDTextField.getText())) {
          NationalIDTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {
      }
    });
    PasswordTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Password".equals(PasswordTextField.getText())) {
          PasswordTextField.setText("");
        }
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
      if (e.getSource() == LoginButton) {

        // For Login Button//
        String password = PasswordTextField.getText();
        try {
          long nationalId_Integer = Long.parseLong(NationalIDTextField.getText());
          String nationalId_String = NationalIDTextField.getText();
          if (nationalId_Integer <= 0) {
            JOptionPane.showMessageDialog(loginFrame, "Enter Positive National ID");
          } else {
            if (nationalId_String.length() != 14) {
              JOptionPane.showMessageDialog(loginFrame, "National ID Should be 14 Numbers");
            } else {
              Account account = Auth.login(nationalId_String, password);
              if (account != null) {
                new AccountFrame(account);
                loginFrame.dispose();
                System.out.println(nationalId_String + "  " + password);
              }

            }
          }
        } catch (NumberFormatException a) {
          JOptionPane.showMessageDialog(loginFrame, "Enter Numbers Only For National ID");
        }

      }
      // For Vreate New Account Button//
      if (e.getSource() == Create_New_Account_Button) {
        SignupFrame create = new SignupFrame();
        loginFrame.dispose();
      }

    }
  }
}