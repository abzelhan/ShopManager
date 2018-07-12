package com.abzal.project.service.impl;

import com.abzal.project.dao.ItemDao;
import com.abzal.project.model.Item;
import com.abzal.project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public void save(Item item) {
        itemDao.saveItem(item);
    }

    @Override
    public void update(Item item) {
            itemDao.updateItem(item);
    }

    @Override
    public void delete(Item item) {
        itemDao.deleteItem(item);
    }

    @Override
    public Item findById(int id) {
        return itemDao.findById(id);
    }

    @Override
    public ArrayList<Item> findAll() {
        return itemDao.findAll();
    }
    @Override
    public boolean checkUniCodeUniqulity(String uniCode){
       return itemDao.checkIfUniCodeExist(uniCode);
    }

    @Override
    public void deleteTransactions(Item item) {
        itemDao.deleteTransactions(item);
    }
}
