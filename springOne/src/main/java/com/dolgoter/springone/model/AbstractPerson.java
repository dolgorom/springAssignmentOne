/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dolgoter.springone.model;

import java.util.Currency;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 *
 * @author roman_dolgoter
 */

@Component
public abstract class AbstractPerson {

    protected String firstname;
    protected String secondname;
    private Salary salary;
    
    protected int age;
    
    abstract public boolean isAgeValid();
    abstract public boolean isCustomValid();
    
       /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the secondname
     */
    public String getSecondname() {
        return secondname;
    }

    /**
     * @param secondname the secondname to set
     */
    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
    
 
    
    

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
      /**
     * @return the salary
     */
    public Salary getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    
    public boolean isNameValid(){
                
                if((firstname == null || firstname.isEmpty()) || secondname == null || secondname.isEmpty()) {
                    return false;
                }
                
        
		String regex = "\\d";
		
		Pattern instance = Pattern.compile(regex);
		Matcher m = instance.matcher(firstname + secondname);
		if(m.find()) {
			return false;
		}
		return true;
    }
    
    public boolean isSalaryValid() {
        return (this.salary != null && this.salary.getAmount() != null);
    }
    
    public boolean isValid(){
        if(!isNameValid())
            return false;
        if(!isCustomValid()) 
            return false;
        if (!isAgeValid())
            return false;
        if (!isSalaryValid())
            return false;
        return true;
    }

  
}
