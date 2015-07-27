/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.dolgoter.configuration.TeamConfig;
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
@ContextConfiguration(classes={TeamConfig.class})
@ActiveProfiles("full_team")
public class TeamTest {
   
     
    @Autowired
    @Qualifier("mu")
    private Team team;
    
   

    @Test
    public void teamShouldNotBeNull(){
        assertNotNull(team);
    }
    
    @Test
    public void checkFoundationYear(){
        assertEquals(1951,team.getFoundationYear());
    }
    
    @Test
    public void checkName(){
        assertEquals("Chelsea",team.getName());
    }

    @Test
    public void trainerInTeamShouldNotBeNull(){
        assertNotNull(team.getTrainer());       
    }
        
    @Test
    public void trainerValid(){
        assertTrue(team.getTrainer().isValid());
    }      
    
    @Test
    public void playersShouldNotBeNull(){
        assertNotNull(team.getPlayers());
    }
    
    @Test
    public void checkPlayersSize(){
        assertEquals(22,team.getPlayers().size());
    }
    
    @Test
    public void teamShouldBeValid(){
        assertTrue(team.isValid());
    }
    
  
}
