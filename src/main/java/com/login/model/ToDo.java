package com.login.model;

import java.util.Date;

public class ToDo {
    private int id;
    private String user;
    private String desc;
    private Date targetDate;
    private boolean isDone;

	//Getters, Setters, Constructors, toString, equals and hash code
    
    public ToDo()
    {
    	
            }
    
    public ToDo(int id, String user, String desc, Date tDate, boolean flag)
    {
    	this.id=id;
    	this.user = user;
    	this.desc = desc;
    	targetDate = tDate;
    	isDone=flag;
            }
} 