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
public class BillingController2 {

    @Autowired
    LoginService service;

    @RequestMapping(value="/billing2", method = RequestMethod.GET)
    public String showbillingpage(ModelMap model){
        return "billing2";
    }

    @RequestMapping(value="/billing2", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam int total, @RequestParam int amount) throws ClassNotFoundException, SQLException{
      
    	String name1 = LoginService.getName();
    	if (amount != total) {
      model.put("errorMessage", "Invalid Input!");
      return "billing2";
  }
  else {
  	service.donepaid(name1);
    return "welcome";
  }

      
      
    }

}
