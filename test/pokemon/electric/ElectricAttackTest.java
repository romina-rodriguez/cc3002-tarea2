package pokemon.electric;

import org.junit.Before;
import org.junit.Test;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.water.BasicWaterPokemon;
import pokemon.water.WaterAttack;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests set for the ElectricAttack class.
 *
 * @author Romina Rodriguez
 */
public class ElectricAttackTest {

    private IAttack electricAttack;
    private IPokemon
            pikachu,
            squirtle;
    private WaterAttack waterAttack;
    private ElectricEnergy electricEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(electricEnergy));
        electricAttack = new ElectricAttack( "Thundershock", 50, "This is an electric attack",
                attackCost);
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(electricAttack)),
                new ArrayList<>(Arrays.asList(electricEnergy)));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Thundershock", electricAttack.getName());
        assertEquals(50, electricAttack.getBaseDamage());
        assertEquals("This is an electric attack", electricAttack.getDescription());
        assertEquals(attackCost, electricAttack.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        electricAttack.attack(pikachu);
        electricAttack.attack(squirtle);

        assertEquals(50, pikachu.getHP());
        assertEquals(0, squirtle.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(electricAttack, new ElectricAttack( "Thundershock", 50,
                "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricAttack, new ElectricAttack( "Thundershock", 40,
                "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricAttack, new ElectricAttack( "Not Thundershock", 50,
                "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricAttack, new ElectricAttack( "Thundershock", 40,
                "This is not an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricAttack, new ElectricAttack( "Thundershock", 50,
                "This is an electric attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(electricAttack, new WaterAttack("Thundershock", 50,
                "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
    }

}
