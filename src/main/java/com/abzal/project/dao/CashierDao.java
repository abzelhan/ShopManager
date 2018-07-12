package com.abzal.project.dao;

import com.abzal.project.model.Cashier;
import com.abzal.project.model.User;

import java.util.ArrayList;

public interface CashierDao {

    void saveCashier(Cashier cashier);
    void updateCashier(Cashier cashier);
    void deleteCashier(Cashier cashier);
    Cashier findById(int id);
    ArrayList<Cashier> findAll();
    Cashier findByUser(User user);
    void deleteTransactions(Cashier cashier);
}
