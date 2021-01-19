package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.login.service.LoginService;

@Controller
@SessionAttributes("name")
public class SearchController2 {

    @Autowired
    LoginService service;

    @RequestMapping(value="/search2", method = RequestMethod.GET)
    public String showbillingpage(ModelMap model){
        return "search2";
    }

}
