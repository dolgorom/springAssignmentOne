
import com.dolgoter.configuration.PlayerConfig;
import com.dolgoter.configuration.StatsConfig;
import com.dolgoter.springone.model.Player;
import com.dolgoter.springone.model.Player.Position;
import com.dolgoter.springone.model.Statistics;
import com.dolgoter.springone.model.Team;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
@ContextConfiguration(classes={StatsConfig.class})
public class StatsTest {
    
    
    @Autowired
    @Qualifier("valid_stats")
    private Statistics validStats;
    
    @Autowired
    @Qualifier("invalid_stats_negative_goals")
    private Statistics statsNegativeGoals;
    
    @Autowired
    @Qualifier("invalid_stats_negative_bookings")
    private Statistics statsNegativeBooksing;
    
    
    @Test
    public void isStatsNull(){
        assertNotNull(validStats);
    }
    
    @Test
    public void checkStatsAreValid(){
        assertTrue(validStats.areValid());
    }
    
    @Test
    public void checkStatsGoals(){
        assertEquals(9,validStats.getNumberOfGoals());
    }
    
    @Test
    public void checkStatsBookings(){
        assertEquals(2,validStats.getNumberOfBookings());
    }
    
    @Test
    public void checkStatsInvalideOnNegativeGoals(){
        assertFalse(statsNegativeGoals.areValid());
    }
    
    @Test
    public void checkStatsInvalideOnNegativeBookings(){
        assertFalse(statsNegativeBooksing.areValid());
    }
  
    
}
