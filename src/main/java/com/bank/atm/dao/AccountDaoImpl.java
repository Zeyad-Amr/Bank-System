package com.bank.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.sql.SQLException;

import com.bank.atm.model.Account;
import com.bank.atm.utils.Utils;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account findByNationalId(String nationalId) {
        Connection con = DbConnection.getConnection();

        if (con == null) {
            return null;
        }
        String query = "SELECT * FROM accounts WHERE nationalId=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, nationalId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Account account = new Account(result.getInt("id"), result.getString("name"),
                        result.getString("nationalId"), result.getString("password"), result.getDate("birthday"),
                        result.getString("phone"), result.getDouble("balance"), result.getDouble("creditBalance"),
                        result.getString("creditCardNumber"), result.getDouble("creditBalanceLimit"),
                        result.getDate("creditDate"), result.getDate("creditEndDate"), result.getBoolean("status"),
                        result.getBoolean("gender"), result.getBoolean("info"));
                return account;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void save(Account account) {
        Connection con = DbConnection.getConnection();
        if (con == null) {
            return;
        }
        if (account.getId() > 0) {
            // **************** Update Data **************** //
            String query = "UPDATE accounts SET name=?, nationalId=?, password=?,birthday=?, phone=?, balance=?, creditBalance=?, creditCardNumber=?,creditBalanceLimit=?, creditDate=?, creditEndDate=?, status=?, gender=?, info=? WHERE id=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, account.getName());
                preparedStatement.setString(2, account.getNationalId());
                preparedStatement.setString(3, account.getPassword());
                preparedStatement.setDate(4, Utils.getSqlDate(account.getBirthday()));
                preparedStatement.setString(5, account.getPhone());
                preparedStatement.setDouble(6, account.getBalance());
                preparedStatement.setDouble(7, account.getCreditBalance());
                preparedStatement.setString(8, account.getCreditCardNumber());
                preparedStatement.setDouble(9, account.getCreditBalanceLimit());
                preparedStatement.setDate(10, Utils.getSqlDate(account.getCreditDate()));
                preparedStatement.setDate(11, Utils.getSqlDate(account.getCreditEndDate()));
                preparedStatement.setBoolean(12, account.getStatus());
                preparedStatement.setBoolean(13, account.getGender());
                preparedStatement.setBoolean(14, account.getInfo());
                preparedStatement.setInt(15, account.getId());

                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }
        } else {
            // **************** Create Data **************** //
            String query = "INSERT INTO accounts  (name, nationalId, password, birthday, phone, balance, creditBalance, creditCardNumber, creditBalanceLimit, creditDate, creditEndDate, status, gender, info) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, account.getName());
                preparedStatement.setString(2, account.getNationalId());
                preparedStatement.setString(3, account.getPassword());
                preparedStatement.setDate(4, Utils.getSqlDate(account.getBirthday()));
                preparedStatement.setString(5, account.getPhone());
                preparedStatement.setDouble(6, account.getBalance());
                preparedStatement.setDouble(7, account.getCreditBalance());
                preparedStatement.setString(8, account.getCreditCardNumber());
                preparedStatement.setDouble(9, account.getCreditBalanceLimit());
                preparedStatement.setDate(10, Utils.getSqlDate(account.getCreditDate()));
                preparedStatement.setDate(11, Utils.getSqlDate(account.getCreditEndDate()));
                preparedStatement.setBoolean(12, account.getStatus());
                preparedStatement.setBoolean(13, account.getGender());
                preparedStatement.setBoolean(14, account.getInfo());

                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }
        }
    }

}
