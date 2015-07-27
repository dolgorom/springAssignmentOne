
import com.dolgoter.configuration.TrainerConfig;
import com.dolgoter.springone.model.Trainer;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
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
@ContextConfiguration(classes={TrainerConfig.class})
public class TrainerTest {
    
    
    @Autowired
    @Qualifier("boss")
    private Trainer boss;
    
    @Autowired
    @Qualifier("invalid_firstname")
    private Trainer bossInvalidFirstName;
    
    @Autowired
    @Qualifier("invalid_secondname")
    private Trainer bossInvalidSecondName;
    
    @Autowired
    @Qualifier("invalid_age")
    private Trainer bossInvalidAge;
    
    @Autowired
    @Qualifier("no_salary")
    private Trainer bossNoSalary;
    
    @Test
    public void checkThatTrainerIsNotNull(){
        assertNotNull(boss);
    }
    
    @Test
    public void checkThatTrainerBossIsValid(){
        assertTrue(boss.isValid());
    }
    
    @Test
    public void checkTrainerFirstName(){
        assertEquals("Jose",boss.getFirstname());
    }
    
    @Test
    public void checkTrainerSecondName(){
        assertEquals("Mourinho",boss.getSecondname());
    }
    
    @Test
    public void checkTrainerAge(){
        assertEquals(45,boss.getAge());
    }
    
    @Test
    public void checkTrainerSalary(){
        assertEquals(new BigDecimal(1000000),boss.getSalary().getAmount());
    }

    
    @Test
    public void checkThatValidationFailsOnWrongFirstName(){
        assertFalse(bossInvalidFirstName.isValid());
    }
    
    @Test
    public void checkThatValidationFailsOnWrongSecondName(){
        assertFalse(bossInvalidSecondName.isValid());
    }
    
    @Test
    public void checkThatValidationFailsOnWrongAge(){
        assertFalse(bossInvalidAge.isValid());
    }
    
    @Test
    public void checkThatValidationFailsOnWrongSalary(){
        assertFalse(bossNoSalary.isValid());
    }
}
