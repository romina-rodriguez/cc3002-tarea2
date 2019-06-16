package pokemon.requirements;

import org.junit.Before;
import org.junit.Test;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.electric.BasicElectricPokemon;
import pokemon.fire.FireEnergy;
import pokemon.water.BasicWaterPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the FireSpin class.
 *
 * @author Romina Rodriguez
 */
public class FireSpinTest {

    private IAttack fireSpin;
    private IPokemon
            pikachu,
            squirtle;
    private FireEnergy fireEnergy;
    private WaterEnergy waterEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(fireEnergy));
        fireSpin = new FireSpin("Fire Spin", 50, "This is a fire spin attack",
                new ArrayList<>(Arrays.asList(fireEnergy)));
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(fireSpin)), new ArrayList<>());
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(waterEnergy, fireEnergy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Fire Spin", fireSpin.getName());
        assertEquals(50, fireSpin.getBaseDamage());
        assertEquals("This is a fire spin attack", fireSpin.getDescription());
        assertEquals(attackCost, fireSpin.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        fireSpin.attack(pikachu);
        fireSpin.attack(squirtle);

        assertEquals(squirtle.getHP(), 50);
        assertEquals(pikachu.getHP(), 100);
    }

    @Test
    public void equalsTest() {
        assertEquals(fireSpin, new FireSpin( "Fire Spin", 50,
                "This is a fire spin attack", attackCost));
        assertNotEquals(fireSpin, new FireSpin( "Fire Spin", 40,
                "This is a fire spin attack", attackCost));
        assertNotEquals(fireSpin, new FireSpin( "Not Fire Spin", 50,
                "This is a fire spin attack", attackCost));
        assertNotEquals(fireSpin, new FireSpin( "Fire Spin", 50,
                "This is not a fire spin attack", attackCost));
        assertNotEquals(fireSpin, new FireSpin( "Fire Spin", 50,
                "This is a fire spin attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(fireSpin, new WaterAttack("Fire Spin", 50,
                "This is a fire spin attack", attackCost));
    }
}