/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dolgoter.configuration;

import com.dolgoter.springone.model.Player;
import com.dolgoter.springone.model.Salary;
import com.dolgoter.springone.model.Team;
import com.dolgoter.springone.model.Trainer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author roman_dolgoter
 */
@Configuration
@ComponentScan(basePackages={"com.dolgoter.springone.model"})
@Profile("full_team")
public class TeamConfig {
    
    @Bean
    @Qualifier("boss")
    public Trainer getTrainer(){
         Trainer mour = new Trainer("Jose" , "Mourinho" , 45, new ArrayList<Team>());
        mour.setSalary(new Salary(new BigDecimal(1000000)));
        return mour;
    }
    
    @Bean
    @Qualifier("maradonas")
    public List<Player> getPlayers (){
        List<Player> output = new ArrayList<>();
        for (int i = 0; i < 22 ; i++)
            output.add(new Player());
        
        return output;
    }
    
    @Bean
    @Qualifier("mu")
    public Team getTeam(){

        Team aTeam =  new Team();
        aTeam.setPlayers(getPlayers ());

 
        aTeam.setFoundationYear(1951);
        aTeam.setName("Chelsea");
        return aTeam;
    }
    
}
