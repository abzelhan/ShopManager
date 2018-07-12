package com.abzal.project.dao.impl;

import com.abzal.project.dao.AbstractDao;
import com.abzal.project.dao.ItemDao;
import com.abzal.project.model.Item;
import com.abzal.project.model.Transaction;
import com.abzal.project.service.TransactionService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao<Integer, Item> implements ItemDao {

    @Autowired
    private TransactionService transactionService;

    @Override
    public void saveItem(Item item) {
        persist(item);
    }

    @Override
    public void updateItem(Item item) {
        update(item);
    }

    @Override
    public void deleteItem(Item item) {
        delete(item);

    }

    @Override
    public Item findById(int id) {
        return  getByKey(id);
    }

    @Override
    public ArrayList<Item> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.desc("price"));
        return (ArrayList<Item>) criteria.list();
    }

    @Override
    public boolean checkIfUniCodeExist(String uniCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("universalProductCode",Integer.parseInt(uniCode)));
        Object result = criteria.uniqueResult();
        if(result == null){
            return true;
        }
        return false;
    }

    @Override
    public void deleteTransactions(Item item) {
        ArrayList<Transaction> transactions = transactionService.findByItem(item);
        for (Transaction t :
                transactions) {

            transactionService.delete(t);
        }
    }
}
