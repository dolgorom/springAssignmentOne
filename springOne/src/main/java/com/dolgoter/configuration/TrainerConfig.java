/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dolgoter.configuration;

import com.dolgoter.springone.model.Player;
import com.dolgoter.springone.model.Salary;
import com.dolgoter.springone.model.Statistics;
import com.dolgoter.springone.model.Team;
import com.dolgoter.springone.model.Trainer;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author roman_dolgoter
 */
@Configuration
@ComponentScan(basePackages={"com.dolgoter.springone.model"})
//@Profile("full_team")
public class TrainerConfig {
    
    
    @Bean
    @Qualifier("boss")
    public Trainer getTrainer(){
        Trainer mour = new Trainer("Jose" , "Mourinho" , 45, new ArrayList<Team>());
        mour.setSalary(new Salary(new BigDecimal(1000000)));
        return mour;
    }
    
    @Bean
    @Qualifier("invalid_firstname")
    public Trainer getTrainerInvalidFirstname(){
         Trainer mour = new Trainer("Jose2" , "Mourinho" , 45, new ArrayList<Team>());
        mour.setSalary(new Salary(new BigDecimal(1000000)));
        return mour;
    }
    
  @Bean
    @Qualifier("invalid_secondname")
    public Trainer getTrainerInvalidSecondname(){
         Trainer mour = new Trainer("Jose" , "Mourinho2" , 45, new ArrayList<Team>());
        mour.setSalary(new Salary(new BigDecimal(1000000)));
        return mour;
    }
    
    @Bean
    @Qualifier("invalid_age")
    public Trainer getTrainerInvalidAge(){
        Trainer mour = new Trainer("Jose" , "Mourinho" , 35, new ArrayList<Team>());
        mour.setSalary(new Salary(new BigDecimal(1000000)));
        return mour;
    }
    
    @Bean
    @Qualifier("no_salary")
    public Trainer getTrainerInvalidSalary(){
        return new Trainer("bala" , "secondname" , 45, new ArrayList<Team>());
    }
    
}
