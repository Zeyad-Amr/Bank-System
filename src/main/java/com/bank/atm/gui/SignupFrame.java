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
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SignupFrame {

  JFrame signupFrame = new JFrame("Bankoo Account");

  // IMP Create Variables For New USER....//

  String NationalId_String;
  String Name;
  String PhoneNumber_String;
  String Password;
  String InitialBalance_String;
  Boolean Gender;
  Boolean Account_Type;

  // Create Variables.......//
  JPanel p1 = new JPanel();
  JLabel SignUPLabel = new JLabel("Sign Up");
  JButton SignUPButton = new JButton("Sign Up");
  JTextField NationalIDTextField = new JTextField("National ID");
  JLabel NationalIDLabel = new JLabel("National ID");
  JTextField NameTextField = new JTextField("Name");
  JLabel NameLabel = new JLabel("Name");
  JTextField PhoneNumberTextField = new JTextField("Phone Number");
  JLabel PhoneNumberLabel = new JLabel("Phone Number");
  JPasswordField PasswordTextField = new JPasswordField("Password");
  JLabel PasswordLabel = new JLabel("Password");
  JTextField InitialBalanceTextField = new JTextField("Initial Balance");
  JLabel InitialBalanceLabel = new JLabel("Initial Balance");
  JTextField BirthDateTextField = new JTextField("Birthdate");
  JLabel BirthDateLabel = new JLabel("Birthdate");
  JLabel GenderLabel = new JLabel("Gender");
  JRadioButton MaleRadioButton = new JRadioButton("Male");
  JRadioButton FeMaleRadioButton = new JRadioButton("Female");
  ButtonGroup GenderButtonGroup = new ButtonGroup();
  // For Type Of ACCOUNT//
  JLabel Acocunt_Type_Label = new JLabel("Account Type");
  JRadioButton VIP_RadioButton = new JRadioButton("VIP");
  JRadioButton Personal_RadioButton = new JRadioButton("Personal");
  ButtonGroup Acocunt_Type_ButtonGroup = new ButtonGroup();

  JLabel AlreadyhaveanaccountLabel = new JLabel("Already have an account?");
  JButton LoginButton = new JButton("  Login  ");
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
    p1.add(SignUPLabel);
    p1.add(NationalIDLabel);
    p1.add(NameLabel);
    p1.add(PhoneNumberLabel);
    p1.add(PasswordLabel);
    p1.add(InitialBalanceLabel);
    p1.add(BirthDateLabel);
    p1.add(GenderLabel);
    p1.add(AlreadyhaveanaccountLabel);
    p1.add(NationalIDTextField);
    p1.add(NameTextField);
    p1.add(PhoneNumberTextField);
    p1.add(PasswordTextField);
    p1.add(InitialBalanceTextField);
    p1.add(BirthDateTextField);
    p1.add(SignUPButton);
    p1.add(LoginButton);
    p1.add(MaleRadioButton);
    p1.add(FeMaleRadioButton);
    GenderButtonGroup.add(MaleRadioButton);
    GenderButtonGroup.add(FeMaleRadioButton);

    p1.add(Acocunt_Type_Label);
    p1.add(VIP_RadioButton);
    p1.add(Personal_RadioButton);
    Acocunt_Type_ButtonGroup.add(VIP_RadioButton);
    Acocunt_Type_ButtonGroup.add(Personal_RadioButton);
    // 2 LAYOUT OF THE PANEL.....................//
    int x = 30;
    int y = 20;

    SignUPLabel.setBounds(155, 3, 250, 70);
    NationalIDLabel.setBounds(90, 95 - x, 250, 30);
    NationalIDTextField.setBounds(90, 125 - x, 250, 20);
    NameLabel.setBounds(90, 150 - x, 250, 30);
    NameTextField.setBounds(90, 180 - x, 250, 20);
    PhoneNumberLabel.setBounds(90, 205 - x, 250, 20);
    PhoneNumberTextField.setBounds(90, 235 - x, 250, 20);
    PasswordLabel.setBounds(90, 260 - x, 250, 30);
    PasswordTextField.setBounds(90, 290 - x, 250, 20);
    Acocunt_Type_Label.setBounds(90, 285, 250, 30);
    VIP_RadioButton.setBounds(90, 315, 115, 20);
    Personal_RadioButton.setBounds(225, 315, 115, 20);

    InitialBalanceLabel.setBounds(90, 315 + y, 250, 30);
    InitialBalanceTextField.setBounds(90, 345 + y, 250, 20);
    BirthDateLabel.setBounds(90, 370 + y, 250, 30);
    BirthDateTextField.setBounds(90, 400 + y, 250, 20);
    GenderLabel.setBounds(90, 425 + y, 250, 30);
    MaleRadioButton.setBounds(90, 455 + y, 115, 20);
    FeMaleRadioButton.setBounds(225, 455 + y, 115, 20);
    SignUPButton.setBounds(90, 510, 250, 35);
    AlreadyhaveanaccountLabel.setBounds(60, 570, 250, 35);
    LoginButton.setBounds(300, 570, 150, 35);
    // COLORS AND FONT............//
    // FONT.........................//
    SignUPLabel.setFont(new Font("Arial Rounded MT bold", 70, 40));
    NationalIDLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    NameLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    PhoneNumberLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    PasswordLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    InitialBalanceLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    BirthDateLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    GenderLabel.setFont(new Font("Arial Rounded MT bold", 30, 20));
    Acocunt_Type_Label.setFont(new Font("Arial Rounded MT bold", 30, 20));
    SignUPButton.setFont(new Font("Arial Rounded MT bold", 35, 20));
    AlreadyhaveanaccountLabel.setFont(new Font("Arial Rounded MT bold", 40, 15));
    LoginButton.setFont(new Font("Arial Rounded MT bold", 40, 15));
    // END OF FONT.........................//
    p1.setBackground(new java.awt.Color(34, 45, 65));
    SignUPLabel.setForeground(Color.WHITE);
    NationalIDLabel.setForeground(Color.WHITE);
    NameLabel.setForeground(Color.WHITE);
    PhoneNumberLabel.setForeground(Color.WHITE);
    PasswordLabel.setForeground(Color.WHITE);
    InitialBalanceLabel.setForeground(Color.WHITE);
    BirthDateLabel.setForeground(Color.WHITE);
    GenderLabel.setForeground(Color.WHITE);
    Acocunt_Type_Label.setForeground(Color.WHITE);
    AlreadyhaveanaccountLabel.setForeground(Color.WHITE);
    NationalIDTextField.setBackground(Color.WHITE);
    NameTextField.setBackground(Color.WHITE);
    PhoneNumberTextField.setBackground(Color.WHITE);
    PasswordTextField.setBackground(Color.WHITE);
    InitialBalanceTextField.setBackground(Color.WHITE);
    BirthDateTextField.setBackground(Color.WHITE);
    // NationalIDTextField.setBackground(new java.awt.Color(34,45,65));
    SignUPButton.setBackground(new java.awt.Color(161, 194, 255));
    SignUPButton.setForeground(new java.awt.Color(35, 45, 65));
    LoginButton.setBackground(new java.awt.Color(161, 194, 255));
    LoginButton.setForeground(new java.awt.Color(35, 45, 65));

    // ADD TO FRAME................//
    signupFrame.add(p1);
    signupFrame.add(img);

    // ACTIONS..............//
    // SignUPButton.addActionListener(add);

    MaleRadioButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == MaleRadioButton) {
          Gender = true;
        }
      }
    });
    FeMaleRadioButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == FeMaleRadioButton) {
          Gender = false;
        }
      }
    });
    VIP_RadioButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == VIP_RadioButton) {
          Account_Type = true;
        }
      }
    });
    Personal_RadioButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Personal_RadioButton) {
          Account_Type = false;
        }
      }
    });
    /// VVVIIIIIIIPPPPPPPPPPP///
    SignUPButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SignUPButton) {

          try {
            if ("National ID".equals(NationalIDTextField.getText()) || NationalIDTextField.getText().length() != 14) {
              JOptionPane.showMessageDialog(signupFrame, "Please enter a valid 14 digit National Id");
            } else if ("Name".equals(NameTextField.getText())) {
              JOptionPane.showMessageDialog(signupFrame, "Please enter full name");
            } else if ("Phone Number".equals(PhoneNumberTextField.getText())) {
              JOptionPane.showMessageDialog(signupFrame, "Please enter a valid phone number");
            } else if ("Password".equals(PasswordTextField.getText())) {
              JOptionPane.showMessageDialog(signupFrame, "Please enter valid password");
            } else if ("Birthdate".equals(BirthDateTextField.getText())) {
              JOptionPane.showMessageDialog(signupFrame, "Please enter birthday");
            } else if (Account_Type == null) {
              JOptionPane.showMessageDialog(signupFrame, "Please choose account type");
            } else if (Gender == null) {
              JOptionPane.showMessageDialog(signupFrame, "Please choose gender");
            } else if ("Initial Balance".equals(InitialBalanceTextField.getText())) {
              JOptionPane.showMessageDialog(signupFrame, "Please enter valid initial balance");
            } else if (Account_Type.equals(true) && Double.parseDouble(InitialBalanceTextField.getText()) < 10000) {
              JOptionPane.showMessageDialog(signupFrame, "Sorry, minimum initial balance for vip account is 10000 EGP");
            } else if (Account_Type.equals(false) && Double.parseDouble(InitialBalanceTextField.getText()) < 1000) {
              JOptionPane.showMessageDialog(signupFrame,
                  "Sorry, minimum initial balance for personal account is 1000 EGP");
            } else {
              try {
                String BirthDate = BirthDateTextField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                LocalDate date1 = LocalDate.parse(BirthDate, formatter);

                System.out.println(BirthDate + "\t" + date1);
              } catch (Exception e) {
                JOptionPane.showMessageDialog(signupFrame,
                    "Please Enter Date in Numbers By this form only \n  \t Day/Month/Year ");
                BirthDateTextField.setText("");
              }
              Account account = new Account(0, NameTextField.getText(), NationalIDTextField.getText(),
                  PasswordTextField.getText(), LocalDate.now(), PhoneNumberTextField.getText(),
                  Double.parseDouble(InitialBalanceTextField.getText()), Utils.getRandomNumber(11111111, 99999999),
                  Gender, Account_Type);

              Account acc = Auth.signUp(account);
              if (acc != null) {
                new AccountFrame(account);
                signupFrame.dispose();

              }
              JOptionPane.showMessageDialog(signupFrame, "Sign Up Successfully :)");
            }
          } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(signupFrame, "Enter Numbers Only");
          } catch (Exception e) {
            JOptionPane.showMessageDialog(signupFrame, "invalid inputs");
          }

        }
      }
    });
    // End of VVVVIIIIIIIPPPP//

    LoginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        LoginFrame Login = new LoginFrame();
        signupFrame.dispose();
      }
    });

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
        if (NationalIDTextField.getText().length() != 0) {
          try {
            long nationalId_Long = Long.parseLong(NationalIDTextField.getText());
            NationalId_String = NationalIDTextField.getText();
            if (nationalId_Long <= 0) {
              JOptionPane.showMessageDialog(signupFrame, "Enter Positive National ID");
              NationalIDTextField.setText("");
            } else {
              if (NationalId_String.length() != 14) {
                JOptionPane.showMessageDialog(signupFrame, "National ID Should be 14 Numbers");
                NationalIDTextField.setText("");
              }
            }
          } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(signupFrame, "Enter Numbers Only For National ID");
            NationalIDTextField.setText("");
          }
        }
      }
    });
    NameTextField.addFocusListener(new FocusListener() {

      @Override
      public void focusGained(FocusEvent e) {
        if ("Name".equals(NameTextField.getText())) {
          NameTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {
        String name = NameTextField.getText();
        if (name.length() < 6 && name.length() != 0) {
          System.out.println(name);
          JOptionPane.showMessageDialog(signupFrame, "Enter full name");
          NameTextField.setText("");
        }
      }
    });
    PhoneNumberTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Phone Number".equals(PhoneNumberTextField.getText())) {
          PhoneNumberTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {
        if (PhoneNumberTextField.getText().length() != 0) {
          try {
            char c = PhoneNumberTextField.getText().charAt(2);
            int PhoneNumber_Integer = Integer.parseInt(PhoneNumberTextField.getText());
            if (PhoneNumber_Integer <= 0 || PhoneNumberTextField.getText().length() != 11) {
              JOptionPane.showMessageDialog(signupFrame, "invalid Phone Number");
              PhoneNumberTextField.setText("");
            } else {
              System.out.println(PhoneNumber_Integer);
            }
          } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(signupFrame, "Enter Numbers Only For PhoneNumber");
            PhoneNumberTextField.setText("");
          }
        }
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
        if (PasswordTextField.getText().length() != 0 && PasswordTextField.getText().length() < 8) {
          JOptionPane.showMessageDialog(signupFrame,
              "Weak Password , password shoulf be at least 8 characters or digits");
          PasswordTextField.setText("");
        }
      }
    });
    InitialBalanceTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Initial Balance".equals(InitialBalanceTextField.getText())) {
          InitialBalanceTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {
        if (InitialBalanceTextField.getText().length() != 0) {
          try {
            int InitialBalance_Integer = Integer.parseInt(InitialBalanceTextField.getText());
            if (InitialBalance_Integer <= 0) {
              JOptionPane.showMessageDialog(signupFrame, "Enter Positive Initial Balance");
              InitialBalanceTextField.setText("");
            } else {
              System.out.println(InitialBalance_Integer);
            }
          } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(signupFrame, "Enter Numbers Only For InitialBalance");
            InitialBalanceTextField.setText("");
          }
        }
      }
    });
    BirthDateTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Birthdate".equals(BirthDateTextField.getText())) {
          BirthDateTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {
        if (BirthDateTextField.getText().length() != 0) {
          try {
            String BirthDate = BirthDateTextField.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate date1 = LocalDate.parse(BirthDate, formatter);

            System.out.println(BirthDate + "\t" + date1);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(signupFrame,
                "Please Enter Date in Numbers By this form only \n  \t Day/Month/Year ");
            BirthDateTextField.setText("");
          }
        }
      }
    });
    // END OF EMPTY THE TEXT
    // FIELDS......................................................//////
  }
}