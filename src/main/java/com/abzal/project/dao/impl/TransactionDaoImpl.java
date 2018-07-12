package com.abzal.project.dao.impl;

import com.abzal.project.dao.AbstractDao;
import com.abzal.project.dao.TransactionDao;
import com.abzal.project.model.Cashier;
import com.abzal.project.model.Item;
import com.abzal.project.model.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
@Repository("transactionDao")
public class TransactionDaoImpl extends AbstractDao<Integer,Transaction> implements TransactionDao {
    @Override
    public void save(Transaction transaction) {
        persist(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
            delete(transaction);
    }

    @Override
    public ArrayList<Transaction> findAll() {
        Criteria entityCriteria = createEntityCriteria();
        return (ArrayList<Transaction>) entityCriteria.list();
    }

    @Override
    public void findById(int id) {
        getByKey(id);
    }

    @Override
    public ArrayList<Transaction> findByDate(Date timestamp) {
        ArrayList<Transaction> transactions = findAll();
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction tr :
                transactions) {
            Date date = new Date(tr.getTransactionTime().getTime());
            if(date.equals(timestamp)){
                filteredTransactions.add(tr);
            }
        }

        return filteredTransactions;
    }

    @Override
    public ArrayList<Transaction> findByCashier(Cashier cashier) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cashier",cashier));

        return (ArrayList<Transaction>) criteria.list();
    }

    @Override
    public ArrayList<Transaction> findByItem(Item item) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("item",item));
        return (ArrayList<Transaction>) criteria.list();
    }

    @Override
    public void deleteFromSession(Item item) {
        getSession().get(Item.class, item.getId());
    }
}
