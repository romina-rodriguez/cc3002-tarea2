package pokemon.abilities;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the EnergyBurn class.
 *
 * @author Romina Rodriguez
 */
public class EnergyBurnTest {

    private IEnergy energy;
    private EnergyBurn energyBurn;
    private ArrayList<IEnergy> abilityCost;

    @Before
    public void setUp() {
        abilityCost = new ArrayList<>(Arrays.asList(energy));
        energyBurn = new EnergyBurn("Energy Burn", "This is an energy burn",
                new ArrayList<>(Arrays.asList(energy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Energy Burn", energyBurn.getName());
        assertEquals("This is an energy burn", energyBurn.getDescription());
        assertEquals(abilityCost, energyBurn.getEnergyListRequired());
    }

    @Test
    public void abilityTest() {
    }

    @Test
    public void equalsTest() {
        assertEquals(energyBurn, new EnergyBurn("Energy Burn", "This is an energy burn",
                new ArrayList<>(Arrays.asList(energy))));
        assertNotEquals(energyBurn, new EnergyBurn("Energy Burn", "This is not an energy burn",
                new ArrayList<>(Arrays.asList(energy))));
        assertNotEquals(energyBurn, new EnergyBurn("Not Energy Burn", "This is an energy burn",
                new ArrayList<>(Arrays.asList(energy))));
        assertNotEquals(energyBurn, new EnergyBurn("Energy Burn", "This is an energy burn",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(energyBurn, new Potion("Energy Burn", "This is an energy burn",
                new ArrayList<>(Arrays.asList(energy))));
    }
}