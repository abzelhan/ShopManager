package com.abzal.project.controller;

import com.abzal.project.model.Cashier;
import com.abzal.project.model.Item;
import com.abzal.project.model.RoleEnum;
import com.abzal.project.model.User;
import com.abzal.project.service.CashierService;
import com.abzal.project.service.ItemService;
import com.abzal.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CashierService cashierService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllItem(ModelMap map){
        ArrayList<Item> items = itemService.findAll();
        map.addAttribute("items",items);
        if(getCurrentUserRole().equals(RoleEnum.USER.getValue())){
            User user = userService.findByUsername(getCurrentUsername());
            System.out.println(user);
            Cashier cashier = cashierService.findByUser(user);
            System.out.println(cashier);
            map.addAttribute("cashier",cashier);
        }
        return  "items_board_page";
    }

    @RequestMapping(value = "/item-creation-page",method = RequestMethod.GET)
    public String redirectToCreationPage(ModelMap map){
        Item item = new Item();
        map.addAttribute("item",item);
        return "items_creation_page";
    }

//    @RequestMapping(value = "/get-by-upc",method = RequestMethod.GET)
//    public String getItemByUPC(){
//
//    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewItem(@Valid @ModelAttribute("item") Item item, BindingResult bindingResult){


        if(!itemService.checkUniCodeUniqulity(String.valueOf(item.getUniversalProductCode()))){
            System.out.println("HERE!!!!");
            return "redirect:/item/item-creation-page?error";
    }


        itemService.save(item);
        return "redirect:/item/list";
    }

    @RequestMapping(value = "/delete-{itemId}",method = RequestMethod.GET)
    public String deleteItem(@PathVariable int itemId){
        Item item = itemService.findById(itemId);
        itemService.deleteTransactions(item);
        itemService.delete(item);
        return "redirect:/item/list";
    }


    @RequestMapping(value = "/edit-{itemId}",method = RequestMethod.GET)
    public String getUpdate(@PathVariable int itemId, ModelMap map){
        Item item = itemService.findById(itemId);
        map.addAttribute("item",item);
        return "items_editor_page";

    }


    @RequestMapping(value = "/update-{itemId}", method = RequestMethod.POST)
    public String updateItem(@PathVariable int itemId,
                             @RequestParam("uni_code") String uniCode,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") String price,
                             @RequestParam("amount") String amount,
                             @RequestParam("imageUrl") String imageUrl
                             ){
        Item item = itemService.findById(itemId);
        item.setUniversalProductCode(Integer.parseInt(uniCode));
        item.setName(name);
        item.setDescription(description);
        item.setPrice(Integer.parseInt(price));
        item.setAmount(Integer.parseInt(amount));
        item.setImageUrl(imageUrl);
        itemService.update(item);
        return "redirect:/item/list";
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
