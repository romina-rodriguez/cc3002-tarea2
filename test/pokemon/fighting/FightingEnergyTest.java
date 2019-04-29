package pokemon.fighting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the FightingEnergy class.
 *
 * @author Romina Rodríguez
 */
public class FightingEnergyTest {

    private FightingEnergy fightingEnergy;

    @Before
    public void setUp(){
        fightingEnergy = new FightingEnergy("fighting");
    }

    @Test
    public void constructorTest() {
        assertEquals("fighting", fightingEnergy.getType());
        assertEquals("fighting", fightingEnergy.getCardName());
    }
}
