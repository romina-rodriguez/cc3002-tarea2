package pokemon.psychic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the PsychicEnergy class.
 *
 * @author Romina Rodríguez
 */
public class PsychicEnergyTest {

    private PsychicEnergy psychicEnergy;

    @Before
    public void setUp(){
        psychicEnergy = new PsychicEnergy("psychic");
    }

    @Test
    public void constructorTest() {
        assertEquals("psychic", psychicEnergy.getType());
        assertEquals("psychic", psychicEnergy.getCardName());
    }
}
