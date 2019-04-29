package pokemon.electric;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the ElectricEnergy class.
 *
 * @author Romina Rodríguez
 */
public class ElectricEnergyTest {

    private ElectricEnergy electricEnergy;

    @Before
    public void setUp(){
        electricEnergy = new ElectricEnergy("electric");
    }

    @Test
    public void constructorTest() {
        assertEquals("electric", electricEnergy.getType());
        assertEquals("electric", electricEnergy.getCardName());
    }
}
