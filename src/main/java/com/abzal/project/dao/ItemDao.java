package com.abzal.project.dao;

import com.abzal.project.model.Item;

import java.util.ArrayList;

public interface ItemDao {

    void saveItem(Item item);
    void updateItem(Item item);
    void deleteItem(Item item);
    Item findById(int id);
    ArrayList<Item> findAll();
    boolean checkIfUniCodeExist(String uniCode);
    void deleteTransactions(Item item);
}
