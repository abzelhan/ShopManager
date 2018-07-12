package com.abzal.project.dao;

import com.abzal.project.model.Cashier;
import com.abzal.project.model.Item;
import com.abzal.project.model.Transaction;

import java.util.ArrayList;
import java.util.Date;

public interface TransactionDao {
    void save(Transaction transaction);
    void deleteTransaction(Transaction transaction);
    ArrayList<Transaction> findAll();
    void findById(int id);
    ArrayList<Transaction> findByDate(Date timestamp);
    ArrayList<Transaction> findByCashier(Cashier cashier);
    ArrayList<Transaction> findByItem(Item item);
    void deleteFromSession(Item item);
}
