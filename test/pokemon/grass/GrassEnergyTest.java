package pokemon.grass;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the GrassEnergy class.
 *
 * @author Romina Rodríguez
 */
public class GrassEnergyTest {

    private GrassEnergy grassEnergy;

    @Before
    public void setUp(){
        grassEnergy = new GrassEnergy("grass");
    }

    @Test
    public void constructorTest() {
        assertEquals("grass", grassEnergy.getType());
        assertEquals("grass", grassEnergy.getCardName());
    }
}
