/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dolgoter.springone.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author roman_dolgoter
 */
public class Trainer extends AbstractPerson{
    
    private List<Team> listOfPreviousTeams;
    
    
    public Trainer(){
        
    }
    
    
    public Trainer(String firstname, String secondname, int age, List <Team> previousTeams){
        this.firstname = firstname;
        this.secondname = secondname;
        this.age = age;
        this.listOfPreviousTeams = previousTeams;
    }
     

     public Trainer(String firstname, String secondname, int age){
        this.firstname = firstname;
        this.secondname = secondname;
        this.age = age;
    }

    /**
     * @return the listOfPreviousTeams
     */
    public List<Team> getListOfPreviousTeams() {
        return listOfPreviousTeams;
    }

    /**
     * @param listOfPreviousTeams the listOfPreviousTeams to set
     */
    public void setListOfPreviousTeams(List<Team> listOfPreviousTeams) {
        this.listOfPreviousTeams = listOfPreviousTeams;
    }

    @Override
    public boolean isAgeValid() {
       return (age > 40);
    }

    @Override
    public boolean isCustomValid() {
        return (listOfPreviousTeams != null);
    }
    
    
    
    
}
