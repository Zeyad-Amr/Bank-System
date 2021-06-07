package com.bank.atm.model;

import java.time.LocalDate;

public class Account extends Model {

    private String password;
    private LocalDate birthday;
    private String phone;
    private String creditCardNumber;
    private double creditBalanceLimit;
    private LocalDate creditDate;
    private LocalDate creditEndDate;
    private Boolean status;
    private Boolean gender;
    private Boolean info;

    // **************** Custom Constructor ****************//
    public Account() {
    }

    // **************** Custom Constructor ****************//
    public Account(int id, String name, String nationalId, String password, LocalDate birthday, String phone,
            double balance, double creditBalance, String creditCardNumber, double creditBalanceLimit,
            LocalDate creditDate, LocalDate creditEndDate, Boolean status, Boolean gender, Boolean info) {
        this.id = id;
        this.name = name;
        this.nationalId = nationalId;
        this.password = password;
        this.birthday = birthday;
        this.phone = phone;
        this.balance = balance;
        this.creditBalance = creditBalance;
        this.creditCardNumber = creditCardNumber;
        this.creditBalanceLimit = creditBalanceLimit;
        this.creditDate = creditDate;
        this.creditEndDate = creditEndDate;
        this.status = status;
        this.gender = gender;
        this.info = info;

    }

    // **************** Custom 2 Constructor for Signing Up ****************//
    public Account(int id, String name, String nationalId, String password, LocalDate birthday, String phone,
            double balance, String creditCardNumber, Boolean gender, Boolean info) {
        this.id = id;
        this.name = name;
        this.nationalId = nationalId;
        this.password = password;
        this.birthday = birthday;
        this.phone = phone;
        this.balance = balance;
        this.creditCardNumber = creditCardNumber;
        this.gender = gender;
        this.creditDate = LocalDate.now();
        this.info = info;
        if (info) {
            if (balance > 0) {
                this.creditBalance = 0.8 * balance;
                this.creditBalanceLimit = 0.8 * balance;

            } else {
                this.creditBalance = 0;
                this.creditBalanceLimit = 0;
            }
            this.creditEndDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue() + 3,
                    LocalDate.now().getDayOfMonth());

        } else if (!info) {
            // Personal Account
            if (balance > 0) {
                this.creditBalance = 0.6 * balance;
                this.creditBalanceLimit = 0.6 * balance;

            } else {
                this.creditBalance = 0;
                this.creditBalanceLimit = 0;
            }
            this.creditEndDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue() + 2,
                    LocalDate.now().getDayOfMonth());

        }
        if (balance >= 0) {
            status = false;
        } else {
            status = true;
        }

    }

    // **************** Id Setter and Getter ****************//
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // **************** Name Setter and Getter ****************//
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // **************** NationalId Setter and Getter ****************//
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalId() {
        return nationalId;
    }

    // **************** Password Setter and Getter ****************//
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // **************** Birthday Setter and Getter ****************//
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    // **************** Phone Setter and Getter ****************//
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    // **************** CreditCardnumber Setter and Getter ****************//

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    // **************** CreditBalanceLimit Setter and Getter ****************//
    public void setCreditBalanceLimit(double creditBalanceLimit) {
        this.creditBalanceLimit = creditBalanceLimit;
    }

    public double getCreditBalanceLimit() {
        return creditBalanceLimit;
    }

    // **************** CreditDate Setter and Getter ****************//
    public void setCreditDate(LocalDate creditDate) {
        this.creditDate = creditDate;
    }

    public LocalDate getCreditDate() {
        return creditDate;
    }

    // **************** CreditEndDate Setter and Getter ****************//
    public void setCreditEndDate(LocalDate creditEndDate) {
        this.creditEndDate = creditEndDate;
    }

    public LocalDate getCreditEndDate() {
        return creditEndDate;
    }

    // **************** Status Setter and Getter ****************//
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getStatusAsString() {
        if (status) {
            return "Indebted";
        } else {
            return "Not indebted";
        }
    }

    // **************** Gender Setter and Getter ****************//

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getGenderAsString() {
        if (gender == true) {
            return "Male";
        } else {
            return "Female";
        }
    }

    // **************** Info Setter and Getter ****************//

    public void setInfo(Boolean info) {
        this.info = info;
    }

    public Boolean getInfo() {
        return info;
    }

    public String getInfoAsString() {
        if (info == true) {
            return "VIP";
        } else {
            return "Personal";
        }
    }

    @Override
    public String toString() {
        return "Account Data {" + "\nid: " + id + "\nname: " + name + "\nnationalId: " + nationalId + "\npassord: "
                + password + "\nphone: " + phone + "\ngender: " + gender + "\nbirthday: " + birthday + "\nbalance: "
                + balance + "\ncreditBalance: " + creditBalance + "\ncreditBalanceLimit: " + creditBalanceLimit
                + "\ncreditCardNumber: " + creditCardNumber + "\ncreditDate: " + creditDate + "\ncreditEndDate: "
                + creditEndDate + "\ninfo: " + info + "\nstatus: " + status + "\n}";

    }
}
