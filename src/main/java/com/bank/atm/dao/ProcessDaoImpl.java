package com.bank.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.bank.atm.model.CashProcess;
import com.bank.atm.utils.Utils;

public class ProcessDaoImpl implements ProcessDao {

    @Override
    public List<CashProcess> findAllByNationalId(String nationalId) {
        Connection con = DbConnection.getConnection();
        List<CashProcess> processes = new LinkedList<>();
        if (con == null) {
            return null;
        }
        String query = "SELECT * FROM processes WHERE nationalId=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, nationalId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                CashProcess process = new CashProcess(result.getInt("id"), result.getString("name"),
                        result.getString("nationalId"), result.getDouble("amount"), result.getString("process"),
                        result.getDouble("balance"), result.getDouble("creditBalance"), result.getDate("date"),
                        result.getString("description"), result.getString("payTo"));
                processes.add(process);
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
        return processes;
    }

    @Override
    public void save(CashProcess process) {
        Connection con = DbConnection.getConnection();
        if (con == null) {
            return;
        }
        if (process.getId() > 0) {
            // **************** Update Data **************** //
            String query = "UPDATE processes SET name=?, nationalId=?, amount=?,process=?, balance=?,creditBalance=?, date=?, description=?, payTo=?, WHERE id=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, process.getName());
                preparedStatement.setString(2, process.getNationalId());
                preparedStatement.setDouble(3, process.getAmount());
                preparedStatement.setString(4, process.getProcess());
                preparedStatement.setDouble(5, process.getBalance());
                preparedStatement.setDouble(6, process.getCreditBalance());
                preparedStatement.setDate(7, Utils.getSqlDate(process.getDate()));
                preparedStatement.setString(8, process.getDescription());
                preparedStatement.setString(9, process.getPayTo());
                preparedStatement.setInt(10, process.getId());

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
            String query = "INSERT INTO processes  (name, nationalId, amount, process, balance,creditBalance, date, description, payTo) VALUES (?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, process.getName());
                preparedStatement.setString(2, process.getNationalId());
                preparedStatement.setDouble(3, process.getAmount());
                preparedStatement.setString(4, process.getProcess());
                preparedStatement.setDouble(5, process.getBalance());
                preparedStatement.setDouble(6, process.getCreditBalance());
                preparedStatement.setDate(7, Utils.getSqlDate(process.getDate()));
                preparedStatement.setString(8, process.getDescription());
                preparedStatement.setString(9, process.getPayTo());
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
