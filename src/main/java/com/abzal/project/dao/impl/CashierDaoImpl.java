package com.abzal.project.dao.impl;

import com.abzal.project.dao.AbstractDao;
import com.abzal.project.dao.CashierDao;
import com.abzal.project.model.Cashier;
import com.abzal.project.model.Transaction;
import com.abzal.project.model.User;
import com.abzal.project.service.TransactionService;
import com.abzal.project.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("cashierDao")
public class CashierDaoImpl extends AbstractDao<Integer, Cashier> implements CashierDao {


    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public void saveCashier(Cashier cashier) {
        persist(cashier);
    }

    @Override
    public void updateCashier(Cashier cashier) {
        update(cashier);
    }

    @Override
    public void deleteCashier(Cashier cashier) {
        delete(cashier);
    }

    @Override
    public Cashier findById(int id) {
        return getByKey(id);
    }

    @Override
    public ArrayList<Cashier> findAll() {
        return (ArrayList<Cashier>) createEntityCriteria().list();
    }

    @Override
    public Cashier findByUser(User user) {
        Criteria entityCriteria = createEntityCriteria();
        entityCriteria.add(Restrictions.eq("user", user));

        return (Cashier) entityCriteria.uniqueResult();
    }

    @Override
    public void deleteTransactions(Cashier cashier) {
        ArrayList<Transaction> transactions = transactionService.findByCashier(cashier);
        for (Transaction t :
                transactions) {
            transactionService.delete(t);
        }
    }
}
