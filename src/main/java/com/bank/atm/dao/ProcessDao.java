package com.bank.atm.dao;

import java.util.List;

import com.bank.atm.model.CashProcess;

public interface ProcessDao {
    List<CashProcess> findAll();

    List<CashProcess> findByNationalId(String nationalId);

    void save(CashProcess process);

}
