package com.abzal.project.service;

import com.abzal.project.model.Cashier;
import com.abzal.project.model.Item;
import com.abzal.project.model.Transaction;

import java.util.ArrayList;
import java.util.Date;

public interface TransactionService {
    void save(Transaction transaction);
    void delete(Transaction transaction);
    ArrayList<Transaction> findAll();
    void findById(int id);
    ArrayList<Transaction> findByDate(Date timestamp);
    ArrayList<Transaction> findByCashier(Cashier cashier);
    ArrayList<Transaction> findByItem(Item item);
    void deleteFromCache(Item item);
}
