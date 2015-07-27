
import com.dolgoter.configuration.PlayerConfig;
import com.dolgoter.springone.model.Player;
import com.dolgoter.springone.model.Player.Position;
import com.dolgoter.springone.model.Team;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roman_dolgoter
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PlayerConfig.class})
public class PlayerTest {
    
    
    @Autowired
    @Qualifier("messi")
    private Player player;
    
    @Autowired
    @Qualifier("invalid_country")
    private Player playerInvalidCountry;
    
    @Autowired
    @Qualifier("too_young")
    private Player playerTooYoung;
    
    @Autowired
    @Qualifier("too_old")
    private Player playerTooOld;
    
    @Autowired
    @Qualifier("no_salary")
    private Player playerNoSalary;
    
    @Autowired
    @Qualifier("wrong_stats")
    private Player playerWrongStats;
    
    
    @Test
    public void isMessiNull(){
        assertNotNull(player);
    }
    
    @Test
    public void didMessiScore(){
        assertEquals(9,player.getStats().getNumberOfGoals());
    }
    
    @Test
    public void checkMessiPosition(){
        assertEquals(Position.FORWARD,player.getPosition());
    }
    
    @Test
    public void wasMessiBooked(){
        assertEquals(2,player.getStats().getNumberOfBookings());
    }
    
    @Test
    public void checkMessiSalary(){
        assertEquals(new BigDecimal(100000000), player.getSalary().getAmount());
    } 
            
    
    @Test
    public void isMessiValid(){
        assertTrue(player.isValid());
    }
    
    @Test
    public void isPlayerInvalidOnInvalidCountry(){
        assertTrue(!playerInvalidCountry.isValid());
    }
    
    @Test
    public void isPlayerInvalidOnAge(){
        assertTrue(!playerTooYoung.isValid());
    }
    
    @Test
    public void isPlayerInvalidOnTooOld(){
        assertTrue(!playerTooOld.isValid());
    }
    
    @Test
    public void isPlayerInvalidOnNoSalary(){
        assertTrue(!playerNoSalary.isValid());
    }
    
    @Test
    public void isPlayerInvalidOnWrongStats(){
        assertTrue(!playerWrongStats.isValid());
    }
    
}
