package pokemon.fire;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the FireEnergy class.
 *
 * @author Romina Rodríguez
 */
public class FireEnergyTest {

    private FireEnergy fireEnergy;

    @Before
    public void setUp(){
        fireEnergy = new FireEnergy("fire");
    }

    @Test
    public void constructorTest() {
        assertEquals("fire", fireEnergy.getType());
        assertEquals("fire", fireEnergy.getCardName());
    }
}
