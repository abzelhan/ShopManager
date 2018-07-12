package com.abzal.project.controller;

import com.abzal.project.model.*;
import com.abzal.project.service.CashierService;
import com.abzal.project.service.ItemService;
import com.abzal.project.service.UserService;
import com.abzal.project.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CashierService cashierService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show() {
        System.out.println("Basic url /");


        return "redirect:/home";
    }


    @RequestMapping(value = "/home")
    public String redirectToHomePage(ModelMap map){
        System.out.println("/home");
        String currentUserRole = getCurrentUserRole();
        String currentUsername = getCurrentUsername();
        String redirectHomePage = null;
        if(currentUserRole.equals(RoleEnum.ADMIN.getValue())){
            map.addAttribute("username",currentUsername);
            map.addAttribute("role",currentUserRole);
            ArrayList<Item> items = itemService.findAll();
            map.addAttribute("items",items);
            redirectHomePage = "items_board_page";

        }
        else if(currentUserRole.equals(RoleEnum.USER.getValue())){

            redirectHomePage = "redirect:/item/list";

        }



        return redirectHomePage;
    }


    @RequestMapping(value = "/registration")
    public String redirectToUserRegisterPage(ModelMap map) {
        List<Role> allRoles = roleService.findAllRoles();
        User user = new User();
        map.addAttribute("roles", allRoles);
        map.addAttribute("cashier", user);
        return "user_registration_page";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(final Principal principal) {
        System.out.println("tyt y");
        if (principal == null) {
            return "login_page";
        } else {
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage() {
        System.out.println("Logout");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }


    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getCurrentUsername());
        return "access_denied";
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
