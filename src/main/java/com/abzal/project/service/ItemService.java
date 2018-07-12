package com.abzal.project.service;

import com.abzal.project.model.Item;

import java.util.ArrayList;

public interface ItemService {

    void save(Item item);
    void update(Item item);
    void delete(Item item);
    Item findById(int id);
    ArrayList<Item> findAll();
    boolean checkUniCodeUniqulity(String uniCode);
    void deleteTransactions(Item item);

}
