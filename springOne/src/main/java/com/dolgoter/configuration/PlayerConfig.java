/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dolgoter.configuration;

import com.dolgoter.springone.model.Player;
import com.dolgoter.springone.model.Salary;
import com.dolgoter.springone.model.Statistics;
import java.math.BigDecimal;
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
public class PlayerConfig {
    
    @Bean
    @Qualifier("messistats")
    public Statistics getStats (){
        Statistics stats = new Statistics();
        stats.setNumberOfBookings(2);
        stats.setNumberOfGoals(9);
        return stats;
    }
    
    @Bean
    public Salary getSalaryForMessi(){
        Salary sal = new Salary(new BigDecimal(100000000));
        return sal; 
    }
    
    
    @Bean
    @Qualifier("messi")
    public Player getPlayer(){
        Player messi = new Player();
        messi.setAge(22);
        messi.setBirthcountry("Argentina");
        messi.setFirstname("Lionel");
        messi.setSecondname("messi");
        messi.setPosition(Player.Position.FORWARD);
        messi.setStats(getStats());
        messi.setSalary(getSalaryForMessi());
        return messi;
    }
    
    
    
    @Bean
    @Qualifier("invalid_country")
    public Player getPlayerInvalidCountry(){
        Player notMessi = new Player();
        notMessi.setAge(22);
        notMessi.setBirthcountry("Argentina1212");
        notMessi.setFirstname("Forgot");
        notMessi.setSecondname("messi");
        notMessi.setSalary(getSalaryForMessi());
        notMessi.setPosition(Player.Position.FORWARD);
        return notMessi;
        
    }
    
    @Bean
    @Qualifier("too_young")
    public Player getPlayerTooYoung(){
        Player notMessi = new Player();
        notMessi.setAge(19);
        notMessi.setBirthcountry("Argentina");
        notMessi.setFirstname("Forgot");
        notMessi.setSecondname("messi");
        notMessi.setSalary(getSalaryForMessi());
        notMessi.setPosition(Player.Position.FORWARD);
        return notMessi;
        
    }
    
    @Bean
    @Qualifier("too_old")
    public Player getPlayerTooOld(){
        Player notMessi = new Player();
        notMessi.setAge(29);
        notMessi.setBirthcountry("Argentina");
        notMessi.setFirstname("Forgot");
        notMessi.setSecondname("messi");
        notMessi.setSalary(getSalaryForMessi());
        notMessi.setPosition(Player.Position.FORWARD);
        return notMessi;
        
    }
    
    @Bean
    @Qualifier("no_salary")
    public Player getPlayerNoSalary(){
        Player notMessi = new Player();
        notMessi.setAge(22);
        notMessi.setBirthcountry("Argentina");
        notMessi.setFirstname("Forgot");
        notMessi.setSecondname("messi");       
        notMessi.setPosition(Player.Position.FORWARD);
        return notMessi;
        
    }
    
    @Bean
    @Qualifier("wrong_stats")
    public Player getPlayerWrongStats(){
        Player notMessi = new Player();
        notMessi.setAge(22);
        notMessi.setBirthcountry("Argentina");
        notMessi.setFirstname("Forgot");
        notMessi.setSecondname("messi");
        notMessi.setSalary(getSalaryForMessi());
        notMessi.setPosition(Player.Position.FORWARD);
        notMessi.getStats().setNumberOfBookings(-2);
        return notMessi;
        
    }
  
    
}
