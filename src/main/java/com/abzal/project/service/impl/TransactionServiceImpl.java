package com.abzal.project.service.impl;

import com.abzal.project.dao.TransactionDao;
import com.abzal.project.model.Cashier;
import com.abzal.project.model.Item;
import com.abzal.project.model.Transaction;
import com.abzal.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private TransactionDao transactionDao;

    @Override
    public void save(Transaction transaction) {
        transactionDao.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
transactionDao.deleteTransaction(transaction);
    }

    @Override
    public ArrayList<Transaction> findAll() {

        return transactionDao.findAll();
    }

    @Override
    public void findById(int id) {
transactionDao.findById(id);
    }

    @Override
    public ArrayList<Transaction> findByDate(Date timestamp) {
        return transactionDao.findByDate(timestamp);
    }

    @Override
    public ArrayList<Transaction> findByCashier(Cashier cashier) {
        ArrayList<Transaction> transactions = transactionDao.findByCashier(cashier);
        if(transactions == null){
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    @Override
    public ArrayList<Transaction> findByItem(Item item) {
        return transactionDao.findByItem(item);
    }

    @Override
    public void deleteFromCache(Item item) {
        transactionDao.deleteFromSession(item);
    }
}
