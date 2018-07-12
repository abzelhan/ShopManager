package com.abzal.project.controller;

import com.abzal.project.model.*;
import com.abzal.project.service.CashierService;
import com.abzal.project.service.ItemService;
import com.abzal.project.service.TransactionService;
import com.abzal.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CashierService cashierService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getTransactionList(ModelMap map){
        ArrayList<Transaction> transactions = null;

        if(getCurrentUserRole().equals(RoleEnum.USER.getValue())){
            User user = userService.findByUsername(getCurrentUsername());
            Cashier cashier = cashierService.findByUser(user);
            map.addAttribute("cashier",cashier);
            transactions = transactionService.findByCashier(cashier);
        }else{
            transactions = transactionService.findAll();
        }
        map.addAttribute("transactions",transactions);

        return "transactions_list_page";
    }

    @RequestMapping(value = "/create-{cashierId}-{itemId}",method = RequestMethod.POST)
    public String createTransaction(@PathVariable int cashierId,
                                    @PathVariable int itemId,
                                    @RequestParam int amount
                                    ){
        Cashier cashier = cashierService.findById(cashierId);
        Item item = itemService.findById(itemId);

        Transaction transaction = new Transaction();
        transaction.setItem(item);
        transaction.setCashier(cashier);
        transaction.setTransactionTime(new Timestamp(System.currentTimeMillis()));
        transaction.setAmount(amount);
        transactionService.save(transaction);

        item.setAmount(item.getAmount()-amount);
        itemService.update(item);
        return "redirect:/item/list";
    }

    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public String getStatistics(ModelMap map){
        ArrayList<Transaction> transactions = transactionService.findAll();
        map.addAttribute("transactions",transactions);
        map.addAttribute("max_price",getMaxPrice(transactions));
        return "statistics_page";
    }

    private int getMaxPrice(ArrayList<Transaction> transactions){
        int maxPrice = 0;
        if(transactions!= null && transactions.size()!=0) {
            for (int i = 0; i < transactions.size() - 1; i++) {
                if (transactions.get(i).getTotalPrice() < transactions.get(i + 1).getTotalPrice()) {
                    maxPrice = transactions.get(i + 1).getTotalPrice();
                }
            }
        }
        return maxPrice;

    }

    private String getCurrentUserRole() {
        String role = null;
        Collection<GrantedAuthority> authorities = getPrincipal().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }
        return role;
    }

    private String getCurrentUsername(){
        return getPrincipal().getUsername();
    }

    private org.springframework.security.core.userdetails.User getPrincipal() {
        return (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
