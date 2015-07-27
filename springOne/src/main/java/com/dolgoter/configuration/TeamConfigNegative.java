/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dolgoter.configuration;

import com.dolgoter.springone.model.Player;
import com.dolgoter.springone.model.Team;
import com.dolgoter.springone.model.Trainer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author roman_dolgoter
 */
@Configuration
@ComponentScan(basePackages={"com.dolgoter.springone.model"})
public class TeamConfigNegative {
    
    @Bean
    @Qualifier("boss")
    public Trainer getTrainer(){
        return new Trainer("bala" , "f" , 35, new ArrayList<Team>());
    }
    
    @Bean
    @Qualifier("maradonas")
    public List<Player> getPlayers (){
        List<Player> output = new ArrayList<>();
        for (int i = 0; i < 21 ; i++)
            output.add(new Player());
        
        return output;
    }
    
    @Bean
    @Qualifier("wrong_foundation_year")
    public Team getTeam(){
        System.out.println("+++++++++++++++++inside getTeam() +++++++++++");

        Team aTeam =  new Team();
        aTeam.setPlayers(getPlayers ());
        
        aTeam.setTrainer(getTrainer());
 
        aTeam.setFoundationYear(1451);
        aTeam.setName("Barca");
        return aTeam;
    }
    
    @Bean
    @Qualifier("no_trainer")
    public Team getTeamNoTrainer(){


        Team aTeam =  new Team();
        aTeam.setPlayers(getPlayers ());

 
        aTeam.setFoundationYear(1951);
        aTeam.setName("Barca");
        return aTeam;
    }
    
    @Bean
    @Qualifier("no_name")
    public Team getTeamNoName(){


        Team aTeam =  new Team();
        aTeam.setPlayers(getPlayers ());

        aTeam.setTrainer(getTrainer());
        aTeam.setFoundationYear(1951);

        return aTeam;
    }
    
}
