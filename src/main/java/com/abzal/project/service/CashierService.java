package com.abzal.project.service;

import com.abzal.project.model.Cashier;
import com.abzal.project.model.User;

import java.util.ArrayList;

public interface CashierService {

    void saveCashier(Cashier cashier);
    void updateCashier(Cashier cashier);
    void deleteCashier(Cashier cashier);
    Cashier findById(int id);
    ArrayList<Cashier> findAll();
    Cashier findByUser(User user);
    void deleteTransactions(Cashier cashier);
}
