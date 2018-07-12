package com.abzal.project.service.impl;

import com.abzal.project.dao.CashierDao;
import com.abzal.project.model.Cashier;
import com.abzal.project.model.User;
import com.abzal.project.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Service("cashierService")
@Transactional
public class CashierServiceImpl implements CashierService{


    @Autowired
    private CashierDao cashierDao;

    @Override
    public void saveCashier(Cashier cashier) {
cashierDao.saveCashier(cashier);
    }

    @Override
    public void updateCashier(Cashier cashier) {
cashierDao.updateCashier(cashier);
    }

    @Override
    public void deleteCashier(Cashier cashier) {
cashierDao.deleteCashier(cashier);
    }

    @Override
    public Cashier findById(int id) {
        return cashierDao.findById(id);
    }

    @Override
    public ArrayList<Cashier> findAll() {
        return cashierDao.findAll();
    }

    @Override
    public Cashier findByUser(User user) {
        return cashierDao.findByUser(user);
    }

    @Override
    public void deleteTransactions(Cashier cashier) {
        cashierDao.deleteTransactions(cashier);
    }
}
