package com.bank.atm.dao;

import java.util.List;

import com.bank.atm.model.CashProcess;

public interface ProcessDao {

    List<CashProcess> findAllByNationalId(String nationalId);

    void save(CashProcess process);

}
