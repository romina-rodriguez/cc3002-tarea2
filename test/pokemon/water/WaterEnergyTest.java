package pokemon.water;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the WaterEnergy class.
 *
 * @author Romina Rodríguez
 */
public class WaterEnergyTest {

    private WaterEnergy waterEnergy;

    @Before
    public void setUp(){
        waterEnergy = new WaterEnergy("water");
    }

    @Test
    public void constructorTest() {
        assertEquals("water", waterEnergy.getType());
        assertEquals("water", waterEnergy.getCardName());
    }
}
