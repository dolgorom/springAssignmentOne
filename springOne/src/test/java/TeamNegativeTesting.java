/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.dolgoter.configuration.TeamConfig;
import com.dolgoter.configuration.TeamConfigNegative;
import com.dolgoter.springone.model.Player;
import com.dolgoter.springone.model.Statistics;
import com.dolgoter.springone.model.Team;
import com.dolgoter.springone.model.Trainer;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TeamConfigNegative.class})
public class TeamNegativeTesting {
   
     
    @Autowired
    @Qualifier("wrong_foundation_year")
    private Team team;
    
    @Autowired
    @Qualifier("no_trainer")
    private Team teamNoTrainer;
    
    @Autowired
    @Qualifier("no_name")
    private Team teamNoName;
               
    @Test
    public void trainerIsNotValid(){
        assertTrue(!team.getTrainer().isValid());
    }      
    
    @Test
    public void teamShouldNotBeValid(){
        assertTrue(!team.isValid());
    }
    
    @Test
    public void teamShouldNoTrainerShouildNotBeValid(){
        assertTrue(!teamNoTrainer.isValid());
    }
    
    
    @Test
    public void teamShouldNoNameShouildNotBeValid(){
        assertTrue(!teamNoName.isValid());
    }
  
}
