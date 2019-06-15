package pokemon.abilities;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the Potion class.
 *
 * @author Romina Rodriguez
 */
public class PotionTest {

    private IEnergy energy;
    private Potion potion;
    private ArrayList<IEnergy> abilityCost;
    private IPokemon squirtle;

    @Before
    public void setUp() {
        abilityCost = new ArrayList<>(Arrays.asList(energy));
        potion = new Potion("Potion", "This is a potion",
                new ArrayList<>(Arrays.asList(energy)));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Potion", potion.getName());
        assertEquals("This is a potion", potion.getDescription());
        assertEquals(abilityCost, potion.getEnergyListRequired());
    }

    @Test
    public void abilityTest() {
        potion.useAbility(squirtle);
        assertEquals(80, squirtle.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(potion, new Potion("Potion", "This is a potion",
                new ArrayList<>(Arrays.asList(energy))));
        assertNotEquals(potion, new Potion("Not a Potion", "This is a potion",
                new ArrayList<>(Arrays.asList(energy))));
        assertNotEquals(potion, new Potion("Potion", "This is not a potion",
                new ArrayList<>(Arrays.asList(energy))));
        assertNotEquals(potion, new Potion("Potion", "This is a potion",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(potion, new EnergyBurn("Potion", "This is a potion",
                new ArrayList<>(Arrays.asList(energy))));
    }
}