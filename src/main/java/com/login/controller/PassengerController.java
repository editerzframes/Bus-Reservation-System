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
public class PassengerController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/passenger", method = RequestMethod.GET)
    public String showpassengerpage(ModelMap model){
        return "passenger";
    }

    @RequestMapping(value="/passenger", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String des, @RequestParam int num_pass, @RequestParam int num_passdiss) throws ClassNotFoundException, SQLException{

    	int cou = service.checkIfNameExist(name);
    	int cou1 = service.checkAvailability(des);
    	
        if (num_passdiss > num_pass) {
            model.put("errorMessage", "Invalid Input!\r\n" + 
            		"No. of Passengers are only " + num_pass +"!");
            return "passenger";
        }
        else if (cou > 0) {
            model.put("errorMessage", "Sorry, Passenger's name have already used!");
            return "passenger";
        }
        else if (num_pass > cou1) {
            model.put("errorMessage", "Tickets are not available for selected Destination");
            return "passenger";
        }
        else {
        	service.enterData(name, des, num_pass, num_passdiss);
        }
        
        return "welcome";
    }

}
