package com.bank.atm.gui;

import javax.swing.*;

import com.bank.atm.dao.AccountDao;
import com.bank.atm.model.Account;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AccountFrame {
  JFrame accFrame = new JFrame("Bankoo Account");

  public AccountFrame(Account acc) {
    Account account = AccountDao.findByNationalId(acc.getNationalId());
    //////////////////////// * Account Fields *///////////////////////
    double balance = acc.getBalance();
    double creditBalance = acc.getCreditBalance();
    String creditEndDate = acc.getCreditEndDate().toString();
    String name = acc.getName();
    String info = acc.getInfoAsString();
    String nationalID = acc.getNationalId();
    String creditCardNumber = acc.getCreditCardNumber();
    String phone = acc.getPhone();
    String gender = acc.getGenderAsString();
    String status = acc.getStatusAsString();
    String birthdayDate = acc.getBirthday().toString();

    ////////////////// * Setting of Frame *//////////////////////
    this.accFrame.setTitle("Account");
    accFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    accFrame.setVisible(true);
    accFrame.setResizable(false);
    accFrame.setSize(1000, 666);
    accFrame.setLocation(200, 20);
    accFrame.invalidate();
    accFrame.validate();
    accFrame.repaint();

    ////////////////////////////////////////////////////

    JPanel cardLayoutPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    JPanel accountPanel = new JPanel();
    JPanel transactionPanel = new JPanel();

    JPanel creditPanel = new JPanel();
    JButton accountButton = new JButton("Account");
    JButton transcButton = new JButton("Transactions");
    JButton creditButton = new JButton("Credit");
    CardLayout card1 = new CardLayout();

    // for transactionPanel...........//
    JPanel pcardt = new JPanel();
    JPanel pbuttons = new JPanel();
    JPanel depositPanel = new JPanel();
    JButton depositButton = new JButton("Deposit");
    JPanel transferPanel = new JPanel();
    JButton transferButton = new JButton("Transfer");
    JPanel withdrawPanel = new JPanel();
    JButton withdrawButton = new JButton("Withdraw");
    CardLayout card2 = new CardLayout();

    // SET IMAGE......................//
    ImageIcon image1 = new ImageIcon(getClass().getResource("../images/welcome.png"));
    JLabel img = new JLabel(image1);
    // END OF IMAGE......................//

    // VARIABLES OF CREDIT PANEL
    // creditPanel..................................................//
    JLabel creditTitleLabel = new JLabel("Credit Payment");
    JLabel amountCreditLabel = new JLabel("Amount");
    JLabel descriptionCreditLabel = new JLabel("Description");
    JLabel creditBalanceTitleLabel = new JLabel("Your Credit Balance");
    JLabel creditBalanceLabel = new JLabel(creditBalance + " EGP");
    JLabel creditexpireLabel = new JLabel("Expires at " + creditEndDate);
    JLabel payForLabel = new JLabel("Pay For");

    JTextField amountTextField = new JTextField("Enter The Amount");
    JTextField descriptionTextField = new JTextField("Enter a description");
    JTextField payForTextField = new JTextField("What you pay for");

    JButton submitButton = new JButton("Submit");

    // END OF VARIABLES OF CREDIT PANEL

    // VARIABLES OF DEPOSIT PANEL
    // depositPanel..................................................//
    JLabel depositTitleLabel = new JLabel("Deposit");
    JLabel Lamdp = new JLabel("Amount");
    JTextField tamdp = new JTextField("Enter The Amount");
    JLabel Ldsdp = new JLabel("Description");
    JTextField tdsdp = new JTextField("Enter a description");
    JButton bsdp = new JButton("Submit");
    JLabel LBL1dp = new JLabel("Your Balance");
    JLabel LBL2dp = new JLabel(balance + " EGP");
    // END OF VARIABLES OF DEPOSIT PANEL

    // VARIABLES OF TRANSFER PANEL
    // transferPanel..................................................//
    JLabel Ltr = new JLabel("Transfer");
    JLabel Lamtr = new JLabel("Amount");
    JTextField tamtr = new JTextField("Enter The Amount");
    JLabel Ldstr = new JLabel("Description");
    JTextField tdstr = new JTextField("Enter a description");
    JLabel Lnitr = new JLabel("National ID");
    JTextField tnitr = new JTextField("Enter National ID you transfeer to");
    JButton bstr = new JButton("Submit");
    JLabel LBL1tr = new JLabel("Your Balance");
    JLabel LBL2tr = new JLabel(balance + " EGP");
    // END OF TRANSFER OF PANEL
    // transferPanel.............................................//

    // VARIABLES OF Withdraw PANEL
    // withdrawPanel..................................................//
    JLabel Lwd = new JLabel("WithDraw");
    JLabel Lamwd = new JLabel("Amount");
    JTextField tamwd = new JTextField("Enter The Amount");
    JLabel Ldswd = new JLabel("Description");
    JTextField tdswd = new JTextField("Enter a description");
    JButton bswd = new JButton("Submit");
    JLabel LBL1wd = new JLabel("Your Balance");
    JLabel LBL2wd = new JLabel(balance + " EGP");
    // END OF Withdraw OF PANEL
    // withdrawPanel.............................................//
    // END OF TRANSICTIONS PANELS//...............................................//

    JLabel headerLeftlabel = new JLabel(info + " account");
    JLabel headerRightlabel = new JLabel(status);
    // VARIABLES OF ACCOUNT PANEL
    // accountPanel...........................................//

    JLabel Lname1 = new JLabel("Name");
    JLabel Lname2 = new JLabel(name);
    JLabel id1 = new JLabel("Ntional ID");
    JLabel id2 = new JLabel(nationalID);
    JLabel num1 = new JLabel("Phone Number");
    JLabel num2 = new JLabel(phone);
    JLabel bd1 = new JLabel("Status");
    JLabel bd2 = new JLabel(status);
    JLabel g1 = new JLabel("Gender");
    JLabel g2 = new JLabel(gender);
    JLabel bL1 = new JLabel("Your Balance");
    JLabel bL2 = new JLabel(balance + " EGP");
    JButton bsp = new JButton("Details");

    // END OF VARIABLES OF ACOUNT PANEL
    // pt.............................................//

    // BUTTONS ACTION
    // LISTENER............////////////////////////////////////////////
    // OPEN PROCESSES TABLE FRAME.................//
    bsp.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bsp) {
          // TableGUI nt = new TableGUI();

          new AccountFrame(account);
          accFrame.dispose();

        }
      }
    });
    // DONE OPEN PROCESSES TABLE FRAME.................//

    // Amount entered for transiction DEPOSIT............//
    bsdp.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == bsdp) {
        try {
          int amountDp = Integer.parseInt(tamdp.getText());
          if (amountDp <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else {
            System.out.println(amountDp);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }
        String DescriptionDp = tdsdp.getText();
        System.out.println(DescriptionDp);
      }
    });
    // FINISHED Amount entered for transiction DEPOSIT............//
    // Amount entered for transiction TRANSFER............//
    bstr.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bstr) {
          // AMOUNT
          try {
            int amountTr = Integer.parseInt(tamtr.getText());
            if (amountTr <= 0) {
              JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
            } else {
              System.out.println(amountTr);
            }
          } catch (NumberFormatException j) {
            JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only for amount");
          }
          // DESCRIPTION
          String DescriptionTR = tdstr.getText();
          System.out.println(DescriptionTR);
          // NATIONAL ID
          try {
            int NIDUSER = 123456789;
            int NationalIdTr = Integer.parseInt(tnitr.getText());
            if (NationalIdTr != NIDUSER) {
              JOptionPane.showMessageDialog(accFrame, "Enter valid Natinal ID User");
            } else {
              System.out.println(NationalIdTr);
            }
          } catch (NumberFormatException k) {
            JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only For NATIONAL ID");
          }
        }
      }
    });
    // FINISHED Amount entered for transiction TRANSFER............//
    // Amount entered for transiction WITHDRAW............//
    bswd.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == bswd) {
        try {
          int amountWd = Integer.parseInt(tamwd.getText());
          if (amountWd <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else {
            System.out.println(amountWd);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }
        String DescriptionWd = tdswd.getText();
        System.out.println(DescriptionWd);
      }
    });
    // FINISHED Amount entered for transiction WITHDRAW............//
    // Amount entered for CREDIT Payment............//
    submitButton.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == submitButton) {
        try {
          int amountCR = Integer.parseInt(amountTextField.getText());
          if (amountCR <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else {
            System.out.println(amountCR);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }
        String DescriptionCR = descriptionTextField.getText();
        System.out.println(DescriptionCR);
        String PayForCR = payForTextField.getText();
        System.out.println(PayForCR);
      }
    });
    // FINISHED Amount entered for CREDIT Payment............//
    // END OF BUTTONS ACTION
    // LISTENER............////////////////////////////////////////////

    headerPanel.setBackground(new java.awt.Color(34, 45, 65));
    headerPanel.add(headerLeftlabel);
    headerPanel.add(headerRightlabel);
    headerPanel.setLayout(null);
    accountButton.setBounds(0, 50, 333, 50);
    transcButton.setBounds(333, 50, 333, 50);
    creditButton.setBounds(666, 50, 333, 50);
    headerLeftlabel.setBounds(20, 0, 500, 50);
    headerRightlabel.setBounds(850, 0, 400, 50);
    headerLeftlabel.setBackground(new java.awt.Color(34, 45, 65));
    headerLeftlabel.setForeground(Color.WHITE);
    headerLeftlabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    headerRightlabel.setBackground(new java.awt.Color(34, 45, 65));
    headerRightlabel.setForeground(Color.WHITE);
    headerRightlabel.setFont(new Font("Arial Rounded MT bold", 35, 25));

    accountButton.setBackground(new java.awt.Color(34, 45, 65));
    transcButton.setBackground(new java.awt.Color(34, 45, 65));
    creditButton.setBackground(new java.awt.Color(34, 45, 65));
    accountButton.setForeground(Color.WHITE);
    transcButton.setForeground(Color.WHITE);
    creditButton.setForeground(Color.WHITE);
    accountButton.setFont(new Font("Arial Rounded MT bold", 30, 20));
    transcButton.setFont(new Font("Arial Rounded MT bold", 30, 20));
    creditButton.setFont(new Font("Arial Rounded MT bold", 30, 20));

    // ACOUNT PANEL accountPanel...........................................//
    accountPanel.setBackground(new java.awt.Color(34, 45, 65));
    accountPanel.setLayout(null);
    accountPanel.add(Lname1);
    accountPanel.add(id1);
    accountPanel.add(num1);
    accountPanel.add(bd1);
    accountPanel.add(g1);
    accountPanel.add(bL1);
    accountPanel.add(Lname2);
    accountPanel.add(id2);
    accountPanel.add(num2);
    accountPanel.add(bd2);
    accountPanel.add(g2);
    accountPanel.add(bL2);
    accountPanel.add(bsp);
    Lname1.setBounds(60, 60, 190, 40);
    Lname2.setBounds(260, 60, 400, 40);
    id1.setBounds(60, 100, 190, 40);
    id2.setBounds(260, 100, 400, 40);
    bL1.setBounds(710, 90, 350, 40);
    num1.setBounds(60, 140, 190, 40);
    num2.setBounds(260, 140, 400, 40);
    bL2.setBounds(730, 130, 350, 100);
    bd1.setBounds(60, 180, 190, 40);
    bd2.setBounds(260, 180, 400, 40);
    g1.setBounds(60, 220, 190, 40);
    g2.setBounds(260, 220, 400, 40);
    bsp.setBounds(200, 300, 400, 50);

    Lname1.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Lname1.setForeground(new java.awt.Color(161, 194, 255));
    Lname2.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Lname2.setForeground(Color.WHITE);
    id1.setFont(new Font("Arial Rounded MT bold", 35, 25));
    id1.setForeground(new java.awt.Color(161, 194, 255));
    id2.setFont(new Font("Arial Rounded MT bold", 35, 25));
    id2.setForeground(Color.WHITE);
    num1.setFont(new Font("Arial Rounded MT bold", 35, 25));
    num1.setForeground(new java.awt.Color(161, 194, 255));
    num2.setFont(new Font("Arial Rounded MT bold", 35, 25));
    num2.setForeground(Color.WHITE);
    bd1.setFont(new Font("Arial Rounded MT bold", 35, 25));
    bd1.setForeground(new java.awt.Color(161, 194, 255));
    bd2.setFont(new Font("Arial Rounded MT bold", 35, 25));
    bd2.setForeground(Color.WHITE);

    g1.setFont(new Font("Arial Rounded MT bold", 35, 25));
    g1.setForeground(new java.awt.Color(161, 194, 255));
    g2.setFont(new Font("Arial Rounded MT bold", 35, 25));
    g2.setForeground(Color.WHITE);
    bL1.setFont(new Font("Arial Rounded MT bold", 35, 25));
    bL1.setForeground(new java.awt.Color(161, 194, 255));
    bL2.setFont(new Font("Arial Rounded MT bold", 35, 25));
    bL2.setForeground(Color.WHITE);
    bsp.setFont(new Font("Arial Rounded MT bold", 40, 30));
    bsp.setBackground(new java.awt.Color(161, 194, 255));
    // END OF ACOUNT PANEL pt.............................................//
    // TRANSICTIONS PANELS.......///////////////////////////

    depositPanel.setBackground(Color.green);
    transferPanel.setBackground(Color.red);
    withdrawPanel.setBackground(Color.blue);
    // CREDIT DEPOSIT PANEL
    // depositPanel..................................................//
    int x = 70;
    depositPanel.setBackground(new java.awt.Color(63, 63, 63));
    depositPanel.setLayout(null);
    depositPanel.add(depositTitleLabel);
    depositPanel.add(bsdp);
    depositPanel.add(Lamdp);
    depositPanel.add(Ldsdp);
    depositPanel.add(LBL1dp);
    depositPanel.add(tamdp);
    depositPanel.add(tdsdp);
    depositPanel.add(LBL2dp);

    depositTitleLabel.setBounds(260, 60, 400, 40);
    Lamdp.setBounds(40, 60 + x, 160, 40);
    tamdp.setBounds(200, 60 + x, 400, 40);
    LBL1dp.setBounds(710, 90, 350, 40);
    Ldsdp.setBounds(40, 100 + x, 160, 40);
    tdsdp.setBounds(200, 100 + x, 400, 40);
    LBL2dp.setBounds(730, 130, 350, 100);
    bsdp.setBounds(200, 190 + x, 400, 50);

    Lamdp.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Lamdp.setForeground(new java.awt.Color(161, 194, 255));
    Ldsdp.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Ldsdp.setForeground(new java.awt.Color(161, 194, 255));

    tamdp.setForeground(Color.WHITE);
    tamdp.setBackground(new java.awt.Color(34, 45, 65));
    tamdp.setFont(new Font("Arial Rounded MT bold", 30, 20));
    tdsdp.setForeground(Color.WHITE);
    tdsdp.setBackground(new java.awt.Color(34, 45, 65));
    tdsdp.setFont(new Font("Arial Rounded MT bold", 30, 20));
    depositTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    depositTitleLabel.setForeground(Color.WHITE);
    LBL1dp.setFont(new Font("Arial Rounded MT bold", 40, 30));
    LBL1dp.setForeground(Color.WHITE);
    LBL2dp.setFont(new Font("Arial Rounded MT bold", 40, 30));
    LBL2dp.setForeground(new java.awt.Color(161, 194, 255));
    LBL2dp.setBackground(Color.WHITE);
    bsdp.setFont(new Font("Arial Rounded MT bold", 40, 30));
    bsdp.setBackground(new java.awt.Color(161, 194, 255));

    // END OF DEPOSIT PANEL
    // depositPanel.............................................//

    // TRANSFER PANEL
    // transferPanel..................................................//

    transferPanel.setBackground(new java.awt.Color(63, 63, 63));
    transferPanel.setLayout(null);
    transferPanel.add(Ltr);
    transferPanel.add(bstr);
    transferPanel.add(Lamtr);
    transferPanel.add(Ldstr);
    transferPanel.add(Lnitr);
    transferPanel.add(LBL1tr);
    transferPanel.add(tamtr);
    transferPanel.add(tdstr);
    transferPanel.add(tnitr);
    transferPanel.add(LBL2tr);

    Ltr.setBounds(260, 60, 400, 40);
    Lamtr.setBounds(40, 60 + x, 160, 40);
    tamtr.setBounds(200, 60 + x, 400, 40);
    LBL1tr.setBounds(710, 90, 350, 40);
    Ldstr.setBounds(40, 100 + x, 160, 40);
    tdstr.setBounds(200, 100 + x, 400, 40);
    LBL2tr.setBounds(730, 130, 350, 100);
    Lnitr.setBounds(40, 140 + x, 160, 40);
    tnitr.setBounds(200, 140 + x, 400, 40);
    bstr.setBounds(200, 190 + x, 400, 50);

    Lamtr.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Lamtr.setForeground(new java.awt.Color(161, 194, 255));
    Ldstr.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Ldstr.setForeground(new java.awt.Color(161, 194, 255));
    Lnitr.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Lnitr.setForeground(new java.awt.Color(161, 194, 255));

    tamtr.setForeground(Color.WHITE);
    tamtr.setBackground(new java.awt.Color(34, 45, 65));
    tamtr.setFont(new Font("Arial Rounded MT bold", 30, 20));
    tdstr.setForeground(Color.WHITE);
    tdstr.setBackground(new java.awt.Color(34, 45, 65));
    tdstr.setFont(new Font("Arial Rounded MT bold", 30, 20));
    tnitr.setForeground(Color.WHITE);
    tnitr.setBackground(new java.awt.Color(34, 45, 65));
    tnitr.setFont(new Font("Arial Rounded MT bold", 30, 20));
    Ltr.setFont(new Font("Arial Rounded MT bold", 45, 35));
    Ltr.setForeground(Color.WHITE);
    LBL1tr.setFont(new Font("Arial Rounded MT bold", 40, 30));
    LBL1tr.setForeground(Color.WHITE);
    LBL2tr.setFont(new Font("Arial Rounded MT bold", 40, 30));
    LBL2tr.setForeground(new java.awt.Color(161, 194, 255));
    LBL2tr.setBackground(Color.WHITE);
    bstr.setFont(new Font("Arial Rounded MT bold", 40, 30));
    bstr.setBackground(new java.awt.Color(161, 194, 255));

    // END OF TRANSFER PANEL
    // transferPanel..............................................//
    // Withdraw PANEL
    // withdrawPanel...................................................//

    withdrawPanel.setBackground(new java.awt.Color(63, 63, 63));
    withdrawPanel.setLayout(null);
    withdrawPanel.add(Lwd);
    withdrawPanel.add(bswd);
    withdrawPanel.add(Lamwd);
    withdrawPanel.add(Ldswd);
    withdrawPanel.add(LBL1wd);
    withdrawPanel.add(tamwd);
    withdrawPanel.add(tdswd);
    withdrawPanel.add(LBL2wd);

    Lwd.setBounds(260, 60, 400, 40);
    Lamwd.setBounds(40, 60 + x, 160, 40);
    tamwd.setBounds(200, 60 + x, 400, 40);
    LBL1wd.setBounds(710, 90, 350, 40);
    Ldswd.setBounds(40, 100 + x, 160, 40);
    tdswd.setBounds(200, 100 + x, 400, 40);
    LBL2wd.setBounds(730, 130, 350, 100);
    bswd.setBounds(200, 190 + x, 400, 50);

    Lamwd.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Lamwd.setForeground(new java.awt.Color(161, 194, 255));
    Ldswd.setFont(new Font("Arial Rounded MT bold", 35, 25));
    Ldswd.setForeground(new java.awt.Color(161, 194, 255));

    tamwd.setForeground(Color.WHITE);
    tamwd.setBackground(new java.awt.Color(34, 45, 65));
    tamwd.setFont(new Font("Arial Rounded MT bold", 30, 20));
    tdswd.setForeground(Color.WHITE);
    tdswd.setBackground(new java.awt.Color(34, 45, 65));
    tdswd.setFont(new Font("Arial Rounded MT bold", 30, 20));
    Lwd.setFont(new Font("Arial Rounded MT bold", 45, 35));
    Lwd.setForeground(Color.WHITE);
    LBL1wd.setFont(new Font("Arial Rounded MT bold", 40, 30));
    LBL1wd.setForeground(Color.WHITE);
    LBL2wd.setFont(new Font("Arial Rounded MT bold", 40, 30));
    LBL2wd.setForeground(new java.awt.Color(161, 194, 255));
    LBL2wd.setBackground(Color.WHITE);
    bswd.setFont(new Font("Arial Rounded MT bold", 40, 30));
    bswd.setBackground(new java.awt.Color(161, 194, 255));

    // END OF Withdraw PANEL
    // withdrawPanel..............................................//

    // END OF TRANSICTIONS PANELS//...............................................//
    transactionPanel.setLayout(null);
    transactionPanel.add(pbuttons);
    transactionPanel.add(pcardt);
    pbuttons.setBounds(0, 0, 1000, 50);
    pcardt.setBounds(0, 50, 1000, 512);

    pcardt.setLayout(card2);
    pbuttons.add(depositButton);
    pbuttons.add(transferButton);
    pbuttons.add(withdrawButton);
    pbuttons.setLayout(null);
    depositButton.setBounds(0, 0, 333, 50);
    transferButton.setBounds(333, 0, 333, 50);
    withdrawButton.setBounds(666, 0, 333, 50);

    depositButton.setBackground(new java.awt.Color(63, 63, 63));
    transferButton.setBackground(new java.awt.Color(63, 63, 63));
    withdrawButton.setBackground(new java.awt.Color(63, 63, 63));
    depositButton.setForeground(Color.WHITE);
    transferButton.setForeground(Color.WHITE);
    withdrawButton.setForeground(Color.WHITE);
    depositButton.setFont(new Font("Arial Rounded MT bold", 30, 20));
    transferButton.setFont(new Font("Arial Rounded MT bold", 30, 20));
    withdrawButton.setFont(new Font("Arial Rounded MT bold", 30, 20));

    pcardt.add(depositPanel, "5");
    pcardt.add(transferPanel, "6");
    pcardt.add(withdrawPanel, "7");
    card2.show(pcardt, "1");

    depositButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card2.show(pcardt, "5");
      }
    });

    transferButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card2.show(pcardt, "6");
      }
    });
    withdrawButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card2.show(pcardt, "7");
      }
    });

    // CREDIT PANEL creditPanel..................................................//

    creditPanel.setBackground(new java.awt.Color(34, 45, 65));
    creditPanel.setLayout(null);
    creditPanel.add(creditTitleLabel);
    creditPanel.add(submitButton);
    creditPanel.add(amountCreditLabel);
    creditPanel.add(descriptionCreditLabel);
    creditPanel.add(payForLabel);
    creditPanel.add(creditBalanceTitleLabel);
    creditPanel.add(amountTextField);
    creditPanel.add(descriptionTextField);
    creditPanel.add(payForTextField);
    creditPanel.add(creditBalanceLabel);
    creditPanel.add(creditexpireLabel);

    creditTitleLabel.setBounds(260, 60, 400, 40);
    amountCreditLabel.setBounds(40, 60 + x, 160, 40);
    amountTextField.setBounds(200, 60 + x, 400, 40);
    creditBalanceTitleLabel.setBounds(650, 90, 350, 40);
    descriptionCreditLabel.setBounds(40, 100 + x, 160, 40);
    descriptionTextField.setBounds(200, 100 + x, 400, 40);
    creditBalanceLabel.setBounds(730, 130, 350, 100);
    payForLabel.setBounds(40, 140 + x, 160, 40);
    payForTextField.setBounds(200, 140 + x, 400, 40);
    creditexpireLabel.setBounds(690, 200, 350, 100);
    submitButton.setBounds(200, 190 + x, 400, 50);

    amountCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountCreditLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionCreditLabel.setForeground(new java.awt.Color(161, 194, 255));
    payForLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    payForLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountTextField.setForeground(Color.WHITE);
    amountTextField.setBackground(new java.awt.Color(34, 45, 65));
    amountTextField.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionTextField.setForeground(Color.WHITE);
    descriptionTextField.setBackground(new java.awt.Color(34, 45, 65));
    descriptionTextField.setFont(new Font("Arial Rounded MT bold", 35, 25));
    payForTextField.setForeground(Color.WHITE);
    payForTextField.setBackground(new java.awt.Color(34, 45, 65));
    payForTextField.setFont(new Font("Arial Rounded MT bold", 35, 25));
    creditTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    creditTitleLabel.setForeground(Color.WHITE);
    creditBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    creditBalanceTitleLabel.setForeground(Color.WHITE);
    creditBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    creditBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    creditBalanceLabel.setBackground(Color.WHITE);
    submitButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitButton.setBackground(new java.awt.Color(161, 194, 255));
    creditexpireLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    creditexpireLabel.setForeground(new java.awt.Color(161, 194, 255));
    creditexpireLabel.setBackground(Color.WHITE);

    // END OF CREDIT PANEL
    // creditPanel.............................................//

    accFrame.setLayout(null);
    accFrame.add(headerPanel);
    accFrame.add(img);
    accFrame.add(cardLayoutPanel);
    ////////////////////////////////////////////////////////////////////////////////
    img.setBounds(0, 0, 1000, 104);
    headerPanel.setBounds(0, 104, 1000, 50 + 50);
    cardLayoutPanel.setBounds(0, 204, 1000, 512);

    cardLayoutPanel.setLayout(card1);
    headerPanel.add(accountButton);
    headerPanel.add(transcButton);
    headerPanel.add(creditButton);
    cardLayoutPanel.add(accountPanel, "1");
    cardLayoutPanel.add(transactionPanel, "2");
    cardLayoutPanel.add(creditPanel, "3");
    card1.show(cardLayoutPanel, "1");

    accountButton.addActionListener((ActionEvent ae) -> {
      card1.show(cardLayoutPanel, "1");
    });

    transcButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card1.show(cardLayoutPanel, "2");
      }
    });
    creditButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card1.show(cardLayoutPanel, "3");
      }
    });

    accFrame.add(cardLayoutPanel);
    // accFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // accFrame.pack();
    // accFrame.setVisible(true);
    // accFrame.setResizable(false);
    // accFrame.setSize(1000, 666);
    // accFrame.setLocation(20, 20);

    // EMPTY THE TEXT
    // FIELDS......................................................//////
    tamdp.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        tamdp.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
        // tamdp.setText("Enter The Amount");
      }
    });
    //////////////////////////////////
    amountTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        amountTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    descriptionTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        descriptionTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    payForTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        payForTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    tdsdp.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        tdsdp.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    tamtr.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        tamtr.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    tdstr.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        tdstr.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    tnitr.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        tnitr.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    tamwd.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        tamwd.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    //////////////////////////////////
    tdswd.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        tdswd.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });
    // END OF EMPTY THE TEXT
    // FIELDS......................................................//////
  }

}
