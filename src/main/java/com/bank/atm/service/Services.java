package com.bank.atm.service;

import java.time.LocalDate;
import com.bank.atm.dao.AccountDao;
import com.bank.atm.dao.ProcessDao;
import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;
import java.util.List;

public class Services {

    public static Boolean checkStatus(Account account) {
        if (account.getBalance() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean checkExpireDate(Account account) {
        if (account.getCreditEndDate().isBefore(LocalDate.now())
                || account.getCreditEndDate().isEqual(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    public static void renewCreditCard(Account account) {
        if (checkExpireDate(account)) {
            double newBalance = account.getBalance() - (account.getCreditBalanceLimit() - account.getCreditBalance());
            Account acc = new Account(account.getId(), account.getName(), account.getNationalId(),
                    account.getPassword(), account.getBirthday(), account.getPhone(), newBalance,
                    account.getCreditCardNumber(), account.getGender(), account.getInfo());
            acc = new Account(account.getId(), account.getName(), account.getNationalId(), account.getPassword(),
                    account.getBirthday(), account.getPhone(), newBalance, account.getCreditCardNumber(),
                    account.getGender(), checkStatus(acc));
            AccountDao.save(acc);
            CashProcess process = new CashProcess(0, acc.getName(), acc.getNationalId(),
                    (account.getCreditBalanceLimit() - account.getCreditBalance()), "credit debts", newBalance,
                    acc.getCreditBalance(), acc.getCreditDate(), "for renewing your credit card", "-");
            ProcessDao.save(process);
        }

    }

    public static Double getTotalWithdrawToday(Account account) {
        Double total = 0.0;
        List<CashProcess> allProcess = ProcessDao.findAllByNationalId(account.getNationalId());
        for (int i = 0; i < allProcess.size(); i++) {
            if (allProcess.get(i).getProcess().equals("withdraw")
                    && allProcess.get(i).getDate().equals(LocalDate.now())) {
                total += allProcess.get(i).getAmount();
            }
        }
        return total;

    }

    public static Double getTotalTransferToday(Account account) {
        Double total = 0.0;
        List<CashProcess> allProcess = ProcessDao.findAllByNationalId(account.getNationalId());
        for (int i = 0; i < allProcess.size(); i++) {
            if (allProcess.get(i).getProcess().equals("transfer")
                    && allProcess.get(i).getDate().equals(LocalDate.now())) {
                total += allProcess.get(i).getAmount();
            }
        }
        return total;

    }

    public static Double getTotalCreditToday(Account account) {
        Double total = 0.0;
        List<CashProcess> allProcess = ProcessDao.findAllByNationalId(account.getNationalId());
        for (int i = 0; i < allProcess.size(); i++) {
            if (allProcess.get(i).getProcess().equals("credit")
                    && allProcess.get(i).getDate().equals(LocalDate.now())) {
                total += allProcess.get(i).getAmount();
            }
        }
        return total;

    }

}
