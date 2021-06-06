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

    ////////////////////// * Main Panels *//////////////////////

    JPanel cardLayoutPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    JPanel accountPanel = new JPanel();
    JPanel transactionPanel = new JPanel();
    JPanel creditPanel = new JPanel();

    JButton accountButton = new JButton("Account");
    JButton transcButton = new JButton("Transactions");
    JButton creditButton = new JButton("Credit");

    CardLayout card1 = new CardLayout();

    ////////////////////// * Header Panel Labels *//////////////////////
    JLabel headerLeftlabel = new JLabel("Welcome " + name.split(" ")[0].toString());
    JLabel headerRightlabel = new JLabel(info + " account");

    ////////////////////// * Account Panel Labels *//////////////////////
    JLabel nameTitleLabel = new JLabel("Name");
    JLabel nameLabel = new JLabel(name);
    JLabel nationalIDTitleLabel = new JLabel("National ID");
    JLabel nationalIDLabel = new JLabel(nationalID);
    JLabel creditCardNumbTitleLabel = new JLabel("Card Number");
    JLabel creditCardNumbLabel = new JLabel(creditCardNumber);
    JLabel phoneTitleLabel = new JLabel("Phone");
    JLabel phoneLabel = new JLabel(phone);
    JLabel birthdateTitleLabel = new JLabel("Birthday");
    JLabel birthdateLabel = new JLabel(birthdayDate);
    JLabel statusTitleLabel = new JLabel("Status");
    JLabel statusLabel = new JLabel(status);
    JLabel genderTitleLabel = new JLabel("Gender");
    JLabel genderLabel = new JLabel(gender);
    JLabel balanceTitleLabel = new JLabel("Your Balance");
    JLabel balanceLabel = new JLabel(balance + " EGP");

    JButton detailsButton = new JButton("Details");

    ////////////////////// * Transactions *//////////////////////
    JPanel transactionCardLayout = new JPanel();
    JPanel pbuttons = new JPanel();
    JPanel depositPanel = new JPanel();
    JPanel transferPanel = new JPanel();
    JPanel withdrawPanel = new JPanel();

    JButton depositButton = new JButton("Deposit");
    JButton transferButton = new JButton("Transfer");
    JButton withdrawButton = new JButton("Withdraw");

    CardLayout card2 = new CardLayout();

    ///////////////////////// * IMAGE*////////////////////////
    ImageIcon image1 = new ImageIcon(getClass().getResource("../images/welcome.png"));
    JLabel img = new JLabel(image1);

    ////////////////////// * Credit Panel Labels *//////////////////////
    JLabel creditTitleLabel = new JLabel("Credit Payment");
    JLabel amountCreditLabel = new JLabel("Amount");
    JLabel descriptionCreditLabel = new JLabel("Description");
    JLabel creditBalanceTitleLabel = new JLabel("Your Credit Balance");
    JLabel creditBalanceLabel = new JLabel(creditBalance + " EGP");
    JLabel creditexpireLabel = new JLabel("Expires at " + creditEndDate);
    JLabel payForCreditLabel = new JLabel("Pay For");

    JTextField amountCreditTextField = new JTextField("Enter The Amount");
    JTextField descriptionCreditTextField = new JTextField("Enter a description");
    JTextField payForCreditTextField = new JTextField("What you pay for");

    JButton submitCreditButton = new JButton("Submit");

    ////////////////////// * Deposit Panel Labels *//////////////////////
    JLabel depositTitleLabel = new JLabel("Deposit");
    JLabel amountdepositLabel = new JLabel("Amount");
    JLabel descriptionDepositLabel = new JLabel("Description");
    JLabel depositBalanceTitleLabel = new JLabel("Your Balance");
    JLabel depositBalanceLabel = new JLabel(balance + " EGP");

    JTextField amountDepositTextField = new JTextField("Enter The Amount");
    JTextField descriptionDepositTextField = new JTextField("Enter a description");

    JButton submitDepositButton = new JButton("Submit");

    ////////////////////// * Transfer Panel Labels *//////////////////////
    JLabel transferTitleLabel = new JLabel("Transfer");
    JLabel amountTransferLabel = new JLabel("Amount");
    JLabel descriptionTransferLabel = new JLabel("Description");
    JLabel nationalIDTransferLabel = new JLabel("National ID");
    JLabel transferBalanceTitleLabel = new JLabel("Your Balance");
    JLabel transferBalanceLabel = new JLabel(balance + " EGP");

    JTextField amountTransferTextField = new JTextField("Enter The Amount");
    JTextField descriptionTransferTextField = new JTextField("Enter a description");
    JTextField nationalIdTransferTextField = new JTextField("Enter National ID you transfer to");

    JButton submitTransferButton = new JButton("Submit");

    ////////////////////// * Withdraw Panel Labels *//////////////////////
    JLabel withdrawTitleLabel = new JLabel("WithDraw");
    JLabel amountWithdrawLabel = new JLabel("Amount");
    JLabel descriptionWithdrawLabel = new JLabel("Description");
    JLabel withdrawBalanceTitleLabel = new JLabel("Your Balance");
    JLabel withdrawBalanceLabel = new JLabel(balance + " EGP");

    JTextField amountWithdrawTextField = new JTextField("Enter The Amount");
    JTextField descriptionWithdrawTextField = new JTextField("Enter a description");

    JButton submitWithdrawButton = new JButton("Submit");

    ////////////////////// * Functions *//////////////////////

    ////////////////////// * Details Button Listener *////////////////
    detailsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == detailsButton) {
          // TableGUI nt = new TableGUI();

          new AccountFrame(account);
          accFrame.dispose();

        }
      }
    });

    ////////////////////// * Deposit Submit Button Listener *//////////////////
    submitDepositButton.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == submitDepositButton) {
        try {
          int amountDp = Integer.parseInt(amountDepositTextField.getText());
          if (amountDp <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else {
            System.out.println(amountDp);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }
        String DescriptionDp = descriptionDepositTextField.getText();
        System.out.println(DescriptionDp);
      }
    });

    ////////////////////// * Deposit Text Field Listeners *////////////////
    amountDepositTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        amountDepositTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {
        // amountDepositTextField.setText("Enter The Amount");
      }
    });

    descriptionDepositTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        descriptionDepositTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    ////////////////////// * Transfer Submit Button Listener *////////////////////
    submitTransferButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitTransferButton) {
          // AMOUNT
          try {
            int amountTr = Integer.parseInt(amountTransferTextField.getText());
            if (amountTr <= 0) {
              JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
            } else {
              System.out.println(amountTr);
            }
          } catch (NumberFormatException j) {
            JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only for amount");
          }
          // DESCRIPTION
          String DescriptionTR = descriptionTransferTextField.getText();
          System.out.println(DescriptionTR);
          // NATIONAL ID
          try {
            int NIDUSER = 123456789;
            int NationalIdTr = Integer.parseInt(nationalIdTransferTextField.getText());
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

    ////////////////////// * Transfer Text Field Listeners *////////////////
    amountTransferTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        amountTransferTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    descriptionTransferTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        descriptionTransferTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    nationalIdTransferTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        nationalIdTransferTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    ////////////////////// * Withdraw Submit Button Listener */////////////////////
    submitWithdrawButton.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == submitWithdrawButton) {
        try {
          int amountWd = Integer.parseInt(amountWithdrawTextField.getText());
          if (amountWd <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else {
            System.out.println(amountWd);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }
        String DescriptionWd = descriptionWithdrawTextField.getText();
        System.out.println(DescriptionWd);
      }
    });

    ////////////////////// * Withdraw Text Field Listeners *////////////////
    amountWithdrawTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        amountWithdrawTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    descriptionWithdrawTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        descriptionWithdrawTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    ////////////////////// * Credit Submit Button Listener *////////////////
    submitCreditButton.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == submitCreditButton) {
        try {
          int amountCR = Integer.parseInt(amountCreditTextField.getText());
          if (amountCR <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else {
            System.out.println(amountCR);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }
        String DescriptionCR = descriptionCreditTextField.getText();
        System.out.println(DescriptionCR);
        String PayForCR = payForCreditTextField.getText();
        System.out.println(PayForCR);
      }
    });

    ////////////////////// * Credit Text Field Listeners *////////////////
    amountCreditTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        amountCreditTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    descriptionCreditTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        descriptionCreditTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    payForCreditTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        payForCreditTextField.setText("");
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    accFrame.setLayout(null);
    accFrame.add(headerPanel);
    accFrame.add(img);
    accFrame.add(cardLayoutPanel);
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

    //////////////////////////// * Style *///////////////////////////
    headerPanel.setBackground(new java.awt.Color(34, 45, 65));
    headerPanel.add(headerLeftlabel);
    headerPanel.add(headerRightlabel);
    headerPanel.setLayout(null);
    accountButton.setBounds(0, 50, 333, 50);
    transcButton.setBounds(333, 50, 333, 50);
    creditButton.setBounds(666, 50, 333, 50);
    headerLeftlabel.setBounds(20, 0, 500, 50);
    headerRightlabel.setBounds(760, 0, 400, 50);
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
    accountPanel.add(nameTitleLabel);
    accountPanel.add(nationalIDTitleLabel);
    accountPanel.add(phoneTitleLabel);
    accountPanel.add(statusTitleLabel);
    accountPanel.add(genderTitleLabel);
    accountPanel.add(balanceTitleLabel);
    accountPanel.add(nameLabel);
    accountPanel.add(nationalIDLabel);
    accountPanel.add(phoneLabel);
    accountPanel.add(statusLabel);
    accountPanel.add(genderLabel);
    accountPanel.add(creditCardNumbLabel);
    accountPanel.add(creditCardNumbTitleLabel);
    accountPanel.add(birthdateLabel);
    accountPanel.add(birthdateTitleLabel);
    accountPanel.add(balanceLabel);
    accountPanel.add(detailsButton);

    nameTitleLabel.setBounds(60, 30, 190, 40);
    nationalIDTitleLabel.setBounds(60, 60, 190, 40);
    creditCardNumbTitleLabel.setBounds(60, 90, 190, 40);
    phoneTitleLabel.setBounds(60, 120, 190, 40);
    genderTitleLabel.setBounds(60, 150, 190, 40);
    birthdateTitleLabel.setBounds(60, 180, 190, 40);
    statusTitleLabel.setBounds(60, 210, 190, 40);

    nameLabel.setBounds(260, 30, 400, 40);
    nationalIDLabel.setBounds(260, 60, 400, 40);
    creditCardNumbLabel.setBounds(260, 90, 400, 40);
    phoneLabel.setBounds(260, 120, 400, 40);
    genderLabel.setBounds(260, 150, 400, 40);
    birthdateLabel.setBounds(260, 180, 400, 40);
    statusLabel.setBounds(260, 210, 400, 40);

    balanceTitleLabel.setBounds(710, 90, 350, 40);
    balanceLabel.setBounds(730, 130, 350, 100);
    detailsButton.setBounds(200, 300, 400, 50);

    nameTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    nameTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    nameLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    nameLabel.setForeground(Color.WHITE);
    nationalIDTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    nationalIDTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    nationalIDLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    nationalIDLabel.setForeground(Color.WHITE);

    birthdateTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    birthdateTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    birthdateLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    birthdateLabel.setForeground(Color.WHITE);

    creditCardNumbTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    creditCardNumbTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    creditCardNumbLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    creditCardNumbLabel.setForeground(Color.WHITE);

    phoneTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    phoneTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    phoneLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    phoneLabel.setForeground(Color.WHITE);
    statusTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    statusTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    statusLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    statusLabel.setForeground(Color.WHITE);

    genderTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    genderTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    genderLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    genderLabel.setForeground(Color.WHITE);
    balanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    balanceTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    balanceLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    balanceLabel.setForeground(Color.WHITE);
    detailsButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    detailsButton.setBackground(new java.awt.Color(161, 194, 255));
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
    depositPanel.add(submitDepositButton);
    depositPanel.add(amountdepositLabel);
    depositPanel.add(descriptionDepositLabel);
    depositPanel.add(depositBalanceTitleLabel);
    depositPanel.add(amountDepositTextField);
    depositPanel.add(descriptionDepositTextField);
    depositPanel.add(depositBalanceLabel);

    depositTitleLabel.setBounds(260, 60, 400, 40);
    amountdepositLabel.setBounds(40, 60 + x, 160, 40);
    amountDepositTextField.setBounds(200, 60 + x, 400, 40);
    depositBalanceTitleLabel.setBounds(710, 90, 350, 40);
    descriptionDepositLabel.setBounds(40, 100 + x, 160, 40);
    descriptionDepositTextField.setBounds(200, 100 + x, 400, 40);
    depositBalanceLabel.setBounds(730, 130, 350, 100);
    submitDepositButton.setBounds(200, 190 + x, 400, 50);

    amountdepositLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountdepositLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionDepositLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionDepositLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountDepositTextField.setForeground(Color.WHITE);
    amountDepositTextField.setBackground(new java.awt.Color(34, 45, 65));
    amountDepositTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    descriptionDepositTextField.setForeground(Color.WHITE);
    descriptionDepositTextField.setBackground(new java.awt.Color(34, 45, 65));
    descriptionDepositTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    depositTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    depositTitleLabel.setForeground(Color.WHITE);
    depositBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    depositBalanceTitleLabel.setForeground(Color.WHITE);
    depositBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    depositBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    depositBalanceLabel.setBackground(Color.WHITE);
    submitDepositButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitDepositButton.setBackground(new java.awt.Color(161, 194, 255));

    // END OF DEPOSIT PANEL
    // depositPanel.............................................//

    // TRANSFER PANEL
    // transferPanel..................................................//

    transferPanel.setBackground(new java.awt.Color(63, 63, 63));
    transferPanel.setLayout(null);
    transferPanel.add(transferTitleLabel);
    transferPanel.add(submitTransferButton);
    transferPanel.add(amountTransferLabel);
    transferPanel.add(descriptionTransferLabel);
    transferPanel.add(nationalIDTransferLabel);
    transferPanel.add(transferBalanceTitleLabel);
    transferPanel.add(amountTransferTextField);
    transferPanel.add(descriptionTransferTextField);
    transferPanel.add(nationalIdTransferTextField);
    transferPanel.add(transferBalanceLabel);

    transferTitleLabel.setBounds(260, 60, 400, 40);
    amountTransferLabel.setBounds(40, 60 + x, 160, 40);
    amountTransferTextField.setBounds(200, 60 + x, 400, 40);
    transferBalanceTitleLabel.setBounds(710, 90, 350, 40);
    descriptionTransferLabel.setBounds(40, 100 + x, 160, 40);
    descriptionTransferTextField.setBounds(200, 100 + x, 400, 40);
    transferBalanceLabel.setBounds(730, 130, 350, 100);
    nationalIDTransferLabel.setBounds(40, 140 + x, 160, 40);
    nationalIdTransferTextField.setBounds(200, 140 + x, 400, 40);
    submitTransferButton.setBounds(200, 190 + x, 400, 50);

    amountTransferLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountTransferLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionTransferLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionTransferLabel.setForeground(new java.awt.Color(161, 194, 255));
    nationalIDTransferLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    nationalIDTransferLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountTransferTextField.setForeground(Color.WHITE);
    amountTransferTextField.setBackground(new java.awt.Color(34, 45, 65));
    amountTransferTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    descriptionTransferTextField.setForeground(Color.WHITE);
    descriptionTransferTextField.setBackground(new java.awt.Color(34, 45, 65));
    descriptionTransferTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    nationalIdTransferTextField.setForeground(Color.WHITE);
    nationalIdTransferTextField.setBackground(new java.awt.Color(34, 45, 65));
    nationalIdTransferTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    transferTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    transferTitleLabel.setForeground(Color.WHITE);
    transferBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    transferBalanceTitleLabel.setForeground(Color.WHITE);
    transferBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    transferBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    transferBalanceLabel.setBackground(Color.WHITE);
    submitTransferButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitTransferButton.setBackground(new java.awt.Color(161, 194, 255));

    // END OF TRANSFER PANEL
    // transferPanel..............................................//
    // Withdraw PANEL
    // withdrawPanel...................................................//

    withdrawPanel.setBackground(new java.awt.Color(63, 63, 63));
    withdrawPanel.setLayout(null);
    withdrawPanel.add(withdrawTitleLabel);
    withdrawPanel.add(submitWithdrawButton);
    withdrawPanel.add(amountWithdrawLabel);
    withdrawPanel.add(descriptionWithdrawLabel);
    withdrawPanel.add(withdrawBalanceTitleLabel);
    withdrawPanel.add(amountWithdrawTextField);
    withdrawPanel.add(descriptionWithdrawTextField);
    withdrawPanel.add(withdrawBalanceLabel);

    withdrawTitleLabel.setBounds(260, 60, 400, 40);
    amountWithdrawLabel.setBounds(40, 60 + x, 160, 40);
    amountWithdrawTextField.setBounds(200, 60 + x, 400, 40);
    withdrawBalanceTitleLabel.setBounds(710, 90, 350, 40);
    descriptionWithdrawLabel.setBounds(40, 100 + x, 160, 40);
    descriptionWithdrawTextField.setBounds(200, 100 + x, 400, 40);
    withdrawBalanceLabel.setBounds(730, 130, 350, 100);
    submitWithdrawButton.setBounds(200, 190 + x, 400, 50);

    amountWithdrawLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountWithdrawLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionWithdrawLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionWithdrawLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountWithdrawTextField.setForeground(Color.WHITE);
    amountWithdrawTextField.setBackground(new java.awt.Color(34, 45, 65));
    amountWithdrawTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    descriptionWithdrawTextField.setForeground(Color.WHITE);
    descriptionWithdrawTextField.setBackground(new java.awt.Color(34, 45, 65));
    descriptionWithdrawTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    withdrawTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    withdrawTitleLabel.setForeground(Color.WHITE);
    withdrawBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    withdrawBalanceTitleLabel.setForeground(Color.WHITE);
    withdrawBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    withdrawBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    withdrawBalanceLabel.setBackground(Color.WHITE);
    submitWithdrawButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitWithdrawButton.setBackground(new java.awt.Color(161, 194, 255));

    // END OF Withdraw PANEL
    // withdrawPanel..............................................//

    // END OF TRANSICTIONS PANELS//...............................................//
    transactionPanel.setLayout(null);
    transactionPanel.add(pbuttons);
    transactionPanel.add(transactionCardLayout);
    pbuttons.setBounds(0, 0, 1000, 50);
    transactionCardLayout.setBounds(0, 50, 1000, 512);

    transactionCardLayout.setLayout(card2);
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

    transactionCardLayout.add(depositPanel, "5");
    transactionCardLayout.add(transferPanel, "6");
    transactionCardLayout.add(withdrawPanel, "7");
    card2.show(transactionCardLayout, "1");

    depositButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card2.show(transactionCardLayout, "5");
      }
    });

    transferButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card2.show(transactionCardLayout, "6");
      }
    });
    withdrawButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        card2.show(transactionCardLayout, "7");
      }
    });

    // CREDIT PANEL creditPanel..................................................//

    creditPanel.setBackground(new java.awt.Color(34, 45, 65));
    creditPanel.setLayout(null);
    creditPanel.add(creditTitleLabel);
    creditPanel.add(submitCreditButton);
    creditPanel.add(amountCreditLabel);
    creditPanel.add(descriptionCreditLabel);
    creditPanel.add(payForCreditLabel);
    creditPanel.add(creditBalanceTitleLabel);
    creditPanel.add(amountCreditTextField);
    creditPanel.add(descriptionCreditTextField);
    creditPanel.add(payForCreditTextField);
    creditPanel.add(creditBalanceLabel);
    creditPanel.add(creditexpireLabel);

    creditTitleLabel.setBounds(260, 60, 400, 40);
    amountCreditLabel.setBounds(40, 60 + x, 160, 40);
    amountCreditTextField.setBounds(200, 60 + x, 400, 40);
    creditBalanceTitleLabel.setBounds(650, 90, 350, 40);
    descriptionCreditLabel.setBounds(40, 100 + x, 160, 40);
    descriptionCreditTextField.setBounds(200, 100 + x, 400, 40);
    creditBalanceLabel.setBounds(730, 130, 350, 100);
    payForCreditLabel.setBounds(40, 140 + x, 160, 40);
    payForCreditTextField.setBounds(200, 140 + x, 400, 40);
    creditexpireLabel.setBounds(690, 200, 350, 100);
    submitCreditButton.setBounds(200, 190 + x, 400, 50);

    amountCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountCreditLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionCreditLabel.setForeground(new java.awt.Color(161, 194, 255));
    payForCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    payForCreditLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountCreditTextField.setForeground(Color.WHITE);
    amountCreditTextField.setBackground(new java.awt.Color(34, 45, 65));
    amountCreditTextField.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionCreditTextField.setForeground(Color.WHITE);
    descriptionCreditTextField.setBackground(new java.awt.Color(34, 45, 65));
    descriptionCreditTextField.setFont(new Font("Arial Rounded MT bold", 35, 25));
    payForCreditTextField.setForeground(Color.WHITE);
    payForCreditTextField.setBackground(new java.awt.Color(34, 45, 65));
    payForCreditTextField.setFont(new Font("Arial Rounded MT bold", 35, 25));
    creditTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    creditTitleLabel.setForeground(Color.WHITE);
    creditBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    creditBalanceTitleLabel.setForeground(Color.WHITE);
    creditBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    creditBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    creditBalanceLabel.setBackground(Color.WHITE);
    submitCreditButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitCreditButton.setBackground(new java.awt.Color(161, 194, 255));
    creditexpireLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    creditexpireLabel.setForeground(new java.awt.Color(161, 194, 255));
    creditexpireLabel.setBackground(Color.WHITE);

    // END OF CREDIT PANEL
    // creditPanel.............................................//

  }

}
