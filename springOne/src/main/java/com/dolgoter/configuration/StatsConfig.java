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
public class StatsConfig {
    
    @Bean
    @Qualifier("valid_stats")
    public Statistics getStats (){
        Statistics stats = new Statistics();
        stats.setNumberOfBookings(2);
        stats.setNumberOfGoals(9);
        return stats;
    }
    
    @Bean
    @Qualifier("invalid_stats_negative_goals")
    public Statistics getStatsnegativeGoals (){
        Statistics stats = new Statistics();
        stats.setNumberOfBookings(2);
        stats.setNumberOfGoals(-9);
        return stats;
    }
    
    @Bean
    @Qualifier("invalid_stats_negative_bookings")
    public Statistics getStatsnegativeBookings (){
        Statistics stats = new Statistics();
        stats.setNumberOfBookings(-2);
        stats.setNumberOfGoals(9);
        return stats;
    }
    
    
}
