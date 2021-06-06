package com.bank.atm.gui;

import javax.swing.*;

import com.bank.atm.model.Account;
import com.bank.atm.service.Auth;
import com.bank.atm.utils.Utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SignupFrame {

  JFrame signupFrame = new JFrame("Bankoo Account");

  // IMP Create Variables For New USER....//

  String NationalId;
  String Name;
  String PhoneNumber;
  String Password;
  String InitialBalance;
  // String CreditBalance = 0.8 * InitialBalance;
  Boolean Gender;

  // Create Variables.......//
  JPanel p1 = new JPanel();
  JLabel LSU = new JLabel("Sign UP");
  JButton b1 = new JButton("  Sign UP  ");
  JTextField t1 = new JTextField("National ID");
  JLabel L1 = new JLabel("National ID");
  JTextField t2 = new JTextField("Name");
  JLabel L2 = new JLabel("Name");
  JTextField t3 = new JTextField("Phone Number");
  JLabel L3 = new JLabel("Phone Number");
  JPasswordField t4 = new JPasswordField("Password");
  JLabel L4 = new JLabel("PassWord");
  JTextField t5 = new JTextField("Initial Balance");
  JLabel L5 = new JLabel("Initial Balance");
  JTextField t6 = new JTextField("BirthDate");
  JLabel L6 = new JLabel("BirthDate");
  JLabel L7 = new JLabel("Gender");
  JRadioButton r1 = new JRadioButton("Male");
  JRadioButton r2 = new JRadioButton("Female");
  ButtonGroup g1 = new ButtonGroup();
  JLabel L8 = new JLabel("already have an account?");
  JButton b2 = new JButton("  Login  ");
  // END VARIABLES.........................................//
  // SET IMAGE......................//
  ImageIcon image1 = new ImageIcon(getClass().getResource("../images/Login.png"));
  JLabel img = new JLabel(image1);
  // END OF IMAGE......................//

  public SignupFrame() {

    // SET FRAME..................//
    signupFrame.setTitle("Sign Up");
    signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    signupFrame.setVisible(true);
    signupFrame.setResizable(false);
    signupFrame.setSize(1000, 666);
    signupFrame.setLocation(200, 20);
    // END OF FRAME..................//

    // SET LAYOUT OF FRAME................//
    signupFrame.setLayout(null);
    img.setBounds(0, 0, 501, 666);
    p1.setBounds(501, 0, 501, 666);
    // END OF LAYOUT OF FRAME................//

    // SET PANEL.................//
    p1.setBackground(Color.darkGray);
    p1.setLayout(null);
    // 1 ADD TO PANEL.............//
    p1.add(LSU);
    p1.add(L1);
    p1.add(L2);
    p1.add(L3);
    p1.add(L4);
    p1.add(L5);
    p1.add(L6);
    p1.add(L7);
    p1.add(L8);
    p1.add(t1);
    p1.add(t2);
    p1.add(t3);
    p1.add(t4);
    p1.add(t5);
    p1.add(t6);
    p1.add(b1);
    p1.add(b2);
    p1.add(r1);
    p1.add(r2);
    g1.add(r1);
    g1.add(r2);
    // 2 LAYOUT OF THE PANEL.....................//
    LSU.setBounds(155, 15, 250, 70);
    L1.setBounds(90, 95, 250, 30);
    t1.setBounds(90, 125, 250, 20);
    L2.setBounds(90, 150, 250, 30);
    t2.setBounds(90, 180, 250, 20);
    L3.setBounds(90, 205, 250, 20);
    t3.setBounds(90, 235, 250, 20);
    L4.setBounds(90, 260, 250, 30);
    t4.setBounds(90, 290, 250, 20);
    L5.setBounds(90, 315, 250, 30);
    t5.setBounds(90, 345, 250, 20);
    L6.setBounds(90, 370, 250, 30);
    t6.setBounds(90, 400, 250, 20);
    L7.setBounds(90, 425, 250, 30);
    r1.setBounds(90, 455, 115, 20);
    r2.setBounds(225, 455, 115, 20);
    b1.setBounds(90, 485, 250, 60);
    L8.setBounds(60, 570, 250, 35);
    b2.setBounds(300, 570, 150, 35);
    // COLORS AND FONT............//
    // FONT.........................//
    LSU.setFont(new Font("Arial Rounded MT bold", 70, 40));
    L1.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L2.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L3.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L4.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L5.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L6.setFont(new Font("Arial Rounded MT bold", 30, 20));
    L7.setFont(new Font("Arial Rounded MT bold", 30, 20));
    b1.setFont(new Font("Arial Rounded MT bold", 40, 25));
    L8.setFont(new Font("Arial Rounded MT bold", 40, 15));
    b2.setFont(new Font("Arial Rounded MT bold", 40, 15));
    // END OF FONT.........................//
    p1.setBackground(new java.awt.Color(34, 45, 65));
    LSU.setForeground(Color.WHITE);
    L1.setForeground(Color.WHITE);
    L2.setForeground(Color.WHITE);
    L3.setForeground(Color.WHITE);
    L4.setForeground(Color.WHITE);
    L5.setForeground(Color.WHITE);
    L6.setForeground(Color.WHITE);
    L7.setForeground(Color.WHITE);
    L8.setForeground(Color.WHITE);
    t1.setBackground(Color.WHITE);
    t2.setBackground(Color.WHITE);
    t3.setBackground(Color.WHITE);
    t4.setBackground(Color.WHITE);
    t5.setBackground(Color.WHITE);
    t6.setBackground(Color.WHITE);
    // t1.setBackground(new java.awt.Color(34,45,65));
    b1.setBackground(new java.awt.Color(161, 194, 255));
    b1.setForeground(new java.awt.Color(35, 45, 65));
    b2.setBackground(new java.awt.Color(161, 194, 255));
    b2.setForeground(new java.awt.Color(35, 45, 65));

    // ADD TO FRAME................//
    signupFrame.add(p1);
    signupFrame.add(img);

    // ACTIONS..............//
    // b1.addActionListener(add);

    r1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == r1) {
          Gender = true;
        }
      }
    });
    r2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == r2) {
          Gender = false;
        }
      }
    });
    /// VVVIIIIIIIPPPPPPPPPPP///
    b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

          NationalId = t1.getText();
          Name = t2.getText();
          PhoneNumber = t3.getText();
          Password = t4.getText();
          InitialBalance = t5.getText();

          System.out.println("NationalId=" + NationalId);
          System.out.println("Name=" + Name);
          System.out.println("PhoneNumber=" + PhoneNumber);
          System.out.println("Password=" + Password);
          System.out.println("InitialBalance=" + InitialBalance);
          // reurtn BIRTHDATE
          String BirthDate = t6.getText();
          try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(BirthDate);
            System.out.println(BirthDate + "\t" + date1);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(signupFrame,
                "Please Enter Date in Numbers By this form only \n  \t Day/Month/Year ");
          }
          // End of return Birthdate
          System.out.println("Gender=" + Gender);
          Account account = new Account(0, Name, NationalId, Password, LocalDate.now(), PhoneNumber,
              Double.parseDouble(InitialBalance), Utils.getRandomNumber(11111111, 99999999), Gender);

          Auth.signUp(account);
        }
      }
    });
    // End of VVVVIIIIIIIPPPP//

    b2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        LoginFrame Login = new LoginFrame();
        signupFrame.dispose();
      }
    });

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
    t3.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        t3.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
      }
    });
    t4.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        t4.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
      }
    });
    t5.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        t5.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
      }
    });
    t6.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        t6.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
      }
    });
    // END OF EMPTY THE TEXT
    // FIELDS......................................................//////
  }
}
