package com.login.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.login.service.LoginService;

@Controller
@SessionAttributes("name")
public class SearchController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public String showbillingpage(ModelMap model){
        return "search";
    }

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name) throws ClassNotFoundException, SQLException{

        boolean isValidUser = service.alreadyExist(name);

        if (!isValidUser) {
            model.put("errorMessage", "PASSENGER'S NAME NOT FOUND!");
            return "search";
        }
        
        service.setName2(name);	
       
        return "search2";
    }

}
