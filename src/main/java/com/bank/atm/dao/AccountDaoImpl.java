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
    public List<Account> findAll() {
        Connection con = DbConnection.getConnection();
        List<Account> accounts = new LinkedList<>();
        if (con == null) {
            return null;
        }
        String query = "SELECT * FROM accounts;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Account account = new Account(result.getInt("id"), result.getString("name"),
                        result.getString("nationalId"), result.getString("password"), result.getDate("birthday"),
                        result.getString("phone"), result.getDouble("balance"), result.getDouble("creditBalance"),
                        result.getDate("creditDate"), result.getDate("creditEndDate"), result.getBoolean("status"),
                        result.getBoolean("gender"));
                accounts.add(account);
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
        return accounts;
    }

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
                        result.getDate("creditDate"), result.getDate("creditEndDate"), result.getBoolean("status"),
                        result.getBoolean("gender"));
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
            String query = "UPDATE accounts SET name=?, nationalId=?, password=?,birthday=?, phone=?, balance=?, creditBalance=?, creditDate=?, creditEndDate=?, status=?, gender=? WHERE id=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, account.getName());
                preparedStatement.setString(2, account.getNationalId());
                preparedStatement.setString(3, account.getPassword());
                preparedStatement.setDate(4, Utils.getSqlDate(account.getBirthday()));
                preparedStatement.setString(5, account.getPhone());
                preparedStatement.setDouble(6, account.getBalance());
                preparedStatement.setDouble(7, account.getCreditBalance());
                preparedStatement.setDate(8, Utils.getSqlDate(account.getCreditDate()));
                preparedStatement.setDate(9, Utils.getSqlDate(account.getCreditEndDate()));
                preparedStatement.setBoolean(10, account.getStatus());
                preparedStatement.setBoolean(11, account.getGender());
                preparedStatement.setInt(12, account.getId());

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
            String query = "INSERT INTO accounts  (name, nationalId, password, birthday, phone, balance, creditBalance, creditDate, creditEndDate, status, gender) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, account.getName());
                preparedStatement.setString(2, account.getNationalId());
                preparedStatement.setString(3, account.getPassword());
                preparedStatement.setDate(4, Utils.getSqlDate(account.getBirthday()));
                preparedStatement.setString(5, account.getPhone());
                preparedStatement.setDouble(6, account.getBalance());
                preparedStatement.setDouble(7, account.getCreditBalance());
                preparedStatement.setDate(8, Utils.getSqlDate(account.getCreditDate()));
                preparedStatement.setDate(9, Utils.getSqlDate(account.getCreditEndDate()));
                preparedStatement.setBoolean(10, account.getStatus());
                preparedStatement.setBoolean(11, account.getGender());

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
