package com.bank.atm.gui;

import javax.swing.*;

import com.bank.atm.dao.AccountDao;
import com.bank.atm.model.Account;
import com.bank.atm.service.Transactions;
import com.bank.atm.utils.Utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class AccountFrame {
  JFrame accFrame = new JFrame("Bankoo Account");
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public AccountFrame(Account acc) {
    Account account = AccountDao.findByNationalId(acc.getNationalId());

    //////////////////////// * Account Fields *///////////////////////
    double balance = acc.getBalance();
    double creditBalance = acc.getCreditBalance();
    LocalDate creditEndDate = acc.getCreditEndDate();
    LocalDate creditDate = acc.getCreditDate();

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

    JButton detailsButton = new JButton("Account Summary");
    JButton logoutButton = new JButton("Logout");

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
    JLabel creditexpireLabel = new JLabel("Card expires at " + creditEndDate.toString());
    JLabel cardRemianDaysLabel = new JLabel(
        "remaining days is " + LocalDate.now().until(creditEndDate, ChronoUnit.DAYS) + " days");
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

    //////////////////////// * Select Panel Function *///////////////////////
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

    ////////////////////// * Details Button Listener *////////////////
    detailsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == detailsButton) {
          TableGUI nt = new TableGUI(account);

        }
      }
    });
    ////////////////////// * logout Button Listener *////////////////
    logoutButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == logoutButton) {
          new LoginFrame();
          accFrame.dispose();

        }
      }
    });

    ////////////////////// * Deposit Submit Button Listener *//////////////////
    submitDepositButton.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == submitDepositButton) {
        String DescriptionDp = descriptionDepositTextField.getText();

        try {
          int amountDp = Integer.parseInt(amountDepositTextField.getText());
          if (amountDp <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else if ("Enter a description".equals(descriptionDepositTextField.getText())
              || descriptionDepositTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter a description");
          } else {
            String result = Transactions.deposit(account, amountDp, DescriptionDp);
            if (result == "1") {
              new AccountFrame(AccountDao.findByNationalId(account.getNationalId()));
              accFrame.dispose();
            }
            System.out.println(amountDp);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }
        System.out.println(DescriptionDp);
      }
    });

    ////////////////////// * Deposit Text Field Listeners *////////////////
    amountDepositTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter The Amount".equals(amountDepositTextField.getText())) {
          amountDepositTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    descriptionDepositTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter a description".equals(descriptionDepositTextField.getText())) {
          descriptionDepositTextField.setText("");
        }
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

          try {
            String nationalIdAsString = nationalIdTransferTextField.getText();
            long NationalIdTr = Long.parseLong(nationalIdAsString);
            int amountTr = Integer.parseInt(amountTransferTextField.getText());
            String DescriptionTR = descriptionTransferTextField.getText();
            System.out.println(DescriptionTR);
            System.out.println(NationalIdTr);

            if (amountTr <= 0) {
              JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
            } else if (AccountDao.findByNationalId(nationalIdAsString) == null) {
              JOptionPane.showMessageDialog(accFrame, "This national Id hasn't any accounts");
            } else if ("Enter a description".equals(descriptionTransferTextField.getText())
                || descriptionTransferTextField.getText().length() == 0) {
              JOptionPane.showMessageDialog(accFrame, "Enter a description");
            } else if ("Enter National ID you transfer to".equals(nationalIdTransferTextField.getText())
                || nationalIdTransferTextField.getText().length() == 0) {
              JOptionPane.showMessageDialog(accFrame, "Enter National ID you transfer to");
            } else {
              String result = Transactions.transfer(account, amountTr, DescriptionTR, nationalIdAsString);
              if (result == "1") {
                new AccountFrame(AccountDao.findByNationalId(account.getNationalId()));
                accFrame.dispose();
              }
              System.out.println(amountTr);
            }
          } catch (NumberFormatException j) {
            System.out.println(j);

            JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only for amount and National Id");
          }

        }
      }
    });

    ////////////////////// * Transfer Text Field Listeners *////////////////
    amountTransferTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter The Amount".equals(amountTransferTextField.getText())) {
          amountTransferTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    descriptionTransferTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter a description".equals(descriptionTransferTextField.getText())) {
          descriptionTransferTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    nationalIdTransferTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter National ID you transfer to".equals(nationalIdTransferTextField.getText())) {
          nationalIdTransferTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    ////////////////////// * Withdraw Submit Button Listener */////////////////////
    submitWithdrawButton.addActionListener((ActionEvent ae) -> {
      if (ae.getSource() == submitWithdrawButton) {
        String DescriptionWd = descriptionWithdrawTextField.getText();
        try {
          int amountWd = Integer.parseInt(amountWithdrawTextField.getText());
          if (amountWd <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else if ("Enter a description".equals(descriptionWithdrawTextField.getText())
              || descriptionWithdrawTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter a description");
          } else {
            String result = Transactions.withdraw(account, amountWd, DescriptionWd);
            if (result == "1") {
              new AccountFrame(AccountDao.findByNationalId(account.getNationalId()));
              accFrame.dispose();
            }
            System.out.println(amountWd);
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }

        System.out.println(DescriptionWd);
      }
    });

    ////////////////////// * Withdraw Text Field Listeners *////////////////
    amountWithdrawTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter The Amount".equals(amountWithdrawTextField.getText())) {
          amountWithdrawTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    descriptionWithdrawTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter a description".equals(descriptionWithdrawTextField.getText())) {
          descriptionWithdrawTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    ////////////////////// * Credit Submit Button Listener *////////////////
    submitCreditButton.addActionListener((ActionEvent ae) -> {
      String DescriptionCR = descriptionCreditTextField.getText();
      String PayForCR = payForCreditTextField.getText();

      if (ae.getSource() == submitCreditButton) {
        try {
          int amountCR = Integer.parseInt(amountCreditTextField.getText());
          if (amountCR <= 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter valid Amount");
          } else if ("Enter a description".equals(descriptionCreditTextField.getText())
              || descriptionCreditTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter a description");
          } else if ("What you pay for".equals(payForCreditTextField.getText())
              || payForCreditTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(accFrame, "Enter for what you pay");
          } else {
            System.out.println(amountCR);
            String result = Transactions.credit(account, amountCR, DescriptionCR, PayForCR);
            if (result == "1") {
              new AccountFrame(AccountDao.findByNationalId(account.getNationalId()));
              accFrame.dispose();
            }
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(accFrame, "Enter Numbers Only");
        }

        System.out.println(DescriptionCR);
        System.out.println(PayForCR);
      }
    });

    ////////////////////// * Credit Text Field Listeners *////////////////
    amountCreditTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter The Amount".equals(amountCreditTextField.getText())) {
          amountCreditTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    descriptionCreditTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("Enter a description".equals(descriptionCreditTextField.getText())) {
          descriptionCreditTextField.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent fe) {

      }
    });

    payForCreditTextField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if ("What you pay for".equals(payForCreditTextField.getText())) {
          payForCreditTextField.setText("");
        }
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

    //////////////////////////// * Header Style *///////////////////////////
    headerPanel.setBackground(new java.awt.Color(34, 45, 65));
    headerPanel.add(headerLeftlabel);
    headerPanel.add(headerRightlabel);
    headerPanel.setLayout(null);
    accountButton.setBounds(0, 50, 333, 50);
    transcButton.setBounds(333, 50, 333, 50);
    creditButton.setBounds(666, 50, 333, 50);
    headerLeftlabel.setBounds(20, 0, 500, 50);
    headerRightlabel.setBounds(750, 0, 400, 50);
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

    depositButton.setBackground(new java.awt.Color(50, 50, 50));
    transferButton.setBackground(new java.awt.Color(50, 50, 50));
    withdrawButton.setBackground(new java.awt.Color(50, 50, 50));
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

    //////////////////////////// * Account Style *///////////////////////////
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
    accountPanel.add(logoutButton);

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

    balanceTitleLabel.setBounds(600, 90, 350, 40);
    balanceLabel.setBounds(610, 100, 350, 100);
    detailsButton.setBounds(350, 300, 300, 40);
    logoutButton.setBounds(880, 10, 100, 30);

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
    balanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 30));
    balanceTitleLabel.setForeground(new java.awt.Color(161, 194, 255));
    balanceLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    balanceLabel.setForeground(Color.WHITE);
    detailsButton.setFont(new Font("Arial Rounded MT bold", 30, 25));
    detailsButton.setBackground(new java.awt.Color(161, 194, 255));
    detailsButton.setForeground(new java.awt.Color(34, 45, 65));
    logoutButton.setFont(new Font("Arial Rounded MT bold", 30, 15));
    logoutButton.setBackground(new java.awt.Color(34, 45, 65));
    logoutButton.setForeground(new java.awt.Color(161, 194, 255));

    //////////////////////////// * Deposit Style *///////////////////////////
    int x = 30;
    int y = 70;
    depositPanel.setBackground(new java.awt.Color(50, 50, 50));
    depositPanel.setLayout(null);
    depositPanel.add(depositTitleLabel);
    depositPanel.add(submitDepositButton);
    depositPanel.add(amountdepositLabel);
    depositPanel.add(descriptionDepositLabel);
    depositPanel.add(depositBalanceTitleLabel);
    depositPanel.add(amountDepositTextField);
    depositPanel.add(descriptionDepositTextField);
    depositPanel.add(depositBalanceLabel);

    depositTitleLabel.setBounds(260, 20, 400, 40);
    amountdepositLabel.setBounds(40, 60 + x, 160, 40);
    amountDepositTextField.setBounds(200, 60 + x, 400, 40);
    descriptionDepositLabel.setBounds(40, 110 + x, 160, 40);
    descriptionDepositTextField.setBounds(200, 110 + x, 400, 40);
    submitDepositButton.setBounds(200, 230 + x, 400, 50);

    depositBalanceTitleLabel.setBounds(700, 50, 350, 40);
    depositBalanceLabel.setBounds(710, 60, 350, 100);

    amountdepositLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountdepositLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionDepositLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionDepositLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountDepositTextField.setBackground(Color.WHITE);
    amountDepositTextField.setForeground(new java.awt.Color(50, 50, 50));
    amountDepositTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    descriptionDepositTextField.setForeground(new java.awt.Color(50, 50, 50));
    descriptionDepositTextField.setBackground(Color.WHITE);
    descriptionDepositTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    depositTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    depositTitleLabel.setForeground(Color.WHITE);
    depositBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    depositBalanceTitleLabel.setForeground(Color.WHITE);
    depositBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 25));
    depositBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    depositBalanceLabel.setBackground(Color.WHITE);
    submitDepositButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitDepositButton.setBackground(new java.awt.Color(34, 45, 65));
    submitDepositButton.setForeground(Color.WHITE);

    //////////////////////////// * Transfer Style *///////////////////////////
    transferPanel.setBackground(new java.awt.Color(50, 50, 50));
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

    transferTitleLabel.setBounds(260, 20, 400, 40);
    amountTransferLabel.setBounds(40, 60 + x, 160, 40);
    amountTransferTextField.setBounds(200, 60 + x, 400, 40);
    descriptionTransferLabel.setBounds(40, 110 + x, 160, 40);
    descriptionTransferTextField.setBounds(200, 110 + x, 400, 40);
    nationalIDTransferLabel.setBounds(40, 160 + x, 160, 40);
    nationalIdTransferTextField.setBounds(200, 160 + x, 400, 40);
    submitTransferButton.setBounds(200, 230 + x, 400, 50);

    transferBalanceTitleLabel.setBounds(700, 50, 350, 40);
    transferBalanceLabel.setBounds(710, 60, 350, 100);

    amountTransferLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountTransferLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionTransferLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionTransferLabel.setForeground(new java.awt.Color(161, 194, 255));
    nationalIDTransferLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    nationalIDTransferLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountTransferTextField.setBackground(Color.WHITE);
    amountTransferTextField.setForeground(new java.awt.Color(50, 50, 50));
    amountTransferTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    descriptionTransferTextField.setForeground(new java.awt.Color(50, 50, 50));
    descriptionTransferTextField.setBackground(Color.WHITE);
    descriptionTransferTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    nationalIdTransferTextField.setForeground(new java.awt.Color(50, 50, 50));
    nationalIdTransferTextField.setBackground(Color.WHITE);
    nationalIdTransferTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    transferTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    transferTitleLabel.setForeground(Color.WHITE);
    transferBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    transferBalanceTitleLabel.setForeground(Color.WHITE);
    transferBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 25));
    transferBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    transferBalanceLabel.setBackground(Color.WHITE);
    submitTransferButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitTransferButton.setBackground(new java.awt.Color(34, 45, 65));
    submitTransferButton.setForeground(Color.WHITE);

    //////////////////////////// * Withdraw Style *///////////////////////////
    withdrawPanel.setBackground(new java.awt.Color(50, 50, 50));
    withdrawPanel.setLayout(null);
    withdrawPanel.add(withdrawTitleLabel);
    withdrawPanel.add(submitWithdrawButton);
    withdrawPanel.add(amountWithdrawLabel);
    withdrawPanel.add(descriptionWithdrawLabel);
    withdrawPanel.add(withdrawBalanceTitleLabel);
    withdrawPanel.add(amountWithdrawTextField);
    withdrawPanel.add(descriptionWithdrawTextField);
    withdrawPanel.add(withdrawBalanceLabel);

    withdrawTitleLabel.setBounds(260, 20, 400, 40);
    amountWithdrawLabel.setBounds(40, 60 + x, 160, 40);
    amountWithdrawTextField.setBounds(200, 60 + x, 400, 40);
    descriptionWithdrawLabel.setBounds(40, 110 + x, 160, 40);
    descriptionWithdrawTextField.setBounds(200, 110 + x, 400, 40);
    submitWithdrawButton.setBounds(200, 230 + x, 400, 50);

    withdrawBalanceTitleLabel.setBounds(700, 50, 350, 40);
    withdrawBalanceLabel.setBounds(710, 60, 350, 100);

    amountWithdrawLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountWithdrawLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionWithdrawLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionWithdrawLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountWithdrawTextField.setBackground(Color.WHITE);
    amountWithdrawTextField.setForeground(new java.awt.Color(50, 50, 50));
    amountWithdrawTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    descriptionWithdrawTextField.setForeground(new java.awt.Color(50, 50, 50));
    descriptionWithdrawTextField.setBackground(Color.WHITE);
    descriptionWithdrawTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    withdrawTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    withdrawTitleLabel.setForeground(Color.WHITE);
    withdrawBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 40, 30));
    withdrawBalanceTitleLabel.setForeground(Color.WHITE);
    withdrawBalanceLabel.setFont(new Font("Arial Rounded MT bold", 40, 25));
    withdrawBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    withdrawBalanceLabel.setBackground(Color.WHITE);
    submitWithdrawButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitWithdrawButton.setBackground(new java.awt.Color(34, 45, 65));
    submitWithdrawButton.setForeground(Color.WHITE);

    //////////////////////////// * Credit Style *///////////////////////////
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
    creditPanel.add(cardRemianDaysLabel);

    creditTitleLabel.setBounds(260, 60, 400, 40);
    amountCreditLabel.setBounds(40, 60 + y, 160, 40);
    amountCreditTextField.setBounds(200, 60 + y, 400, 40);
    descriptionCreditLabel.setBounds(40, 110 + y, 160, 40);
    descriptionCreditTextField.setBounds(200, 110 + y, 400, 40);
    payForCreditLabel.setBounds(40, 160 + y, 160, 40);
    payForCreditTextField.setBounds(200, 160 + y, 400, 40);
    submitCreditButton.setBounds(200, 210 + y, 400, 50);

    creditBalanceTitleLabel.setBounds(670, 50, 350, 40);
    creditBalanceLabel.setBounds(710, 60, 350, 100);
    creditexpireLabel.setBounds(660, 100, 350, 100);
    cardRemianDaysLabel.setBounds(700, 130, 350, 100);

    amountCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    amountCreditLabel.setForeground(new java.awt.Color(161, 194, 255));
    descriptionCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    descriptionCreditLabel.setForeground(new java.awt.Color(161, 194, 255));
    payForCreditLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    payForCreditLabel.setForeground(new java.awt.Color(161, 194, 255));

    amountCreditTextField.setForeground(Color.WHITE);
    amountCreditTextField.setBackground(new java.awt.Color(34, 45, 65));
    amountCreditTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    descriptionCreditTextField.setForeground(Color.WHITE);
    descriptionCreditTextField.setBackground(new java.awt.Color(34, 45, 65));
    descriptionCreditTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    payForCreditTextField.setForeground(Color.WHITE);
    payForCreditTextField.setBackground(new java.awt.Color(34, 45, 65));
    payForCreditTextField.setFont(new Font("Arial Rounded MT bold", 30, 20));
    creditTitleLabel.setFont(new Font("Arial Rounded MT bold", 45, 35));
    creditTitleLabel.setForeground(Color.WHITE);
    creditBalanceTitleLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    creditBalanceTitleLabel.setForeground(Color.WHITE);
    creditBalanceLabel.setFont(new Font("Arial Rounded MT bold", 35, 25));
    creditBalanceLabel.setForeground(new java.awt.Color(161, 194, 255));
    creditBalanceLabel.setBackground(Color.WHITE);
    submitCreditButton.setFont(new Font("Arial Rounded MT bold", 40, 30));
    submitCreditButton.setBackground(new java.awt.Color(161, 194, 255));
    creditexpireLabel.setFont(new Font("Arial Rounded MT bold", 35, 20));
    creditexpireLabel.setForeground(new java.awt.Color(161, 194, 255));
    creditexpireLabel.setBackground(Color.WHITE);
    cardRemianDaysLabel.setFont(new Font("Arial Rounded MT bold", 35, 15));
    cardRemianDaysLabel.setForeground(new java.awt.Color(240, 40, 40));
    cardRemianDaysLabel.setBackground(Color.WHITE);

  }

}