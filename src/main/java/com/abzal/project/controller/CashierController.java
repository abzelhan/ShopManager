package com.abzal.project.controller;

import com.abzal.project.model.Cashier;
import com.abzal.project.model.RoleEnum;
import com.abzal.project.model.Transaction;
import com.abzal.project.model.User;
import com.abzal.project.service.CashierService;
import com.abzal.project.service.TransactionService;
import com.abzal.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/cashier")
public class CashierController {

    @Autowired
    UserService userService;

    @Autowired
    CashierService cashierService;
    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/registrate",method = RequestMethod.POST)
    public String registrateNewUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model){
        String userRole = user.getRole().getName();
        userService.saveUser(user);
        String page=null;
        if(userRole.equals("USER")){
            Cashier cashier = new Cashier();
            cashier.setUser(user);
            cashierService.saveCashier(cashier);
            page = "redirect:/cashier/edit-"+cashier.getId();
        }
        else{
            page="redirect:/";
        }
        return page;
    }
    @RequestMapping(value = "/edit-{cashierId}",method = RequestMethod.GET )
    public String getUpdatePage(@PathVariable int cashierId,
                                ModelMap map){
        Cashier cashier = cashierService.findById(cashierId);
        System.out.println(cashier);
        map.addAttribute("cashier",cashier);
        return "cashier_editor_page";
    }

    @RequestMapping(value = "/delete-{cashierId}",method = RequestMethod.GET)
    public String deleteCashier(@PathVariable int cashierId){
        Cashier cashier = cashierService.findById(cashierId);
        cashierService.deleteTransactions(cashier);
        cashierService.deleteCashier(cashier);
        return "redirect:/cashier/list";
    }

    @RequestMapping(value = "/update-{cashierId}",method = RequestMethod.POST )
    public String updateCashier(@PathVariable int cashierId,
                                @RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("birth_date") String birthDate,
                                @RequestParam("gender") String gender,
                                @RequestParam("phone") String phone,
                                @RequestParam("email") String email,
                                @RequestParam("imageUrl") String imageUrl
                                ) throws ParseException {
        String redirectUrl = null;
        Cashier cashier = cashierService.findById(cashierId);
        cashier.setName(name);
        cashier.setSurname(surname);
        if(birthDate != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           cashier.setBirthDate(dateFormat.parse(birthDate));
        }
        cashier.setGender(gender);
        cashier.setPhone(phone);
        cashier.setEmail(email);
        cashier.setImageUrl(imageUrl);
        cashierService.updateCashier(cashier);

        if(getCurrentUserRole().equals(RoleEnum.USER.getValue())){
            redirectUrl = "redirect:/home";
        }
        else{
            redirectUrl = "redirect:/cashier/list";
        }
        return redirectUrl;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAllCashiers(ModelMap map){
        ArrayList<Cashier> cashiers = cashierService.findAll();
        map.addAttribute("cashiers",cashiers);
        return "cashier_list_page";
    }

    @RequestMapping(value = "/profile-{cashierId}",method = RequestMethod.GET)
    public String showProfile(@PathVariable int cashierId,ModelMap map){
        Cashier cashier = cashierService.findById(cashierId);
        map.addAttribute("cashier",cashier);
        ArrayList<Transaction> transactions = transactionService.findByCashier(cashier);
        map.addAttribute("transactions",transactions);
        map.addAttribute("max_price",getMaxPrice(transactions));
        return "cashier_profile_page";
    }

    private int getMaxPrice(ArrayList<Transaction> transactions){
        int maxPrice = 0;
        if(transactions.size()!=0) {
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
