package pokemon.requirements;

import org.junit.Before;
import org.junit.Test;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.electric.BasicElectricPokemon;
import pokemon.electric.ElectricEnergy;
import pokemon.water.BasicWaterPokemon;
import pokemon.water.WaterAttack;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests set for the ElectricShock class.
 *
 * @author Romina Rodriguez
 */
public class ElectricShockTest {

    private IAttack electricShock;
    private IPokemon
            pikachu,
            squirtle;
    private WaterAttack waterAttack;
    private ElectricEnergy electricEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(electricEnergy));
        electricShock = new ElectricShock("Electric Shock", 50, "This is an electric shock attack",
                new ArrayList<>(Arrays.asList(electricEnergy)));
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(electricShock)),
                new ArrayList<>(Arrays.asList(electricEnergy)));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Electric Shock", electricShock.getName());
        assertEquals(50, electricShock.getBaseDamage());
        assertEquals("This is an electric shock attack", electricShock.getDescription());
        assertEquals(attackCost, electricShock.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        electricShock.attack(pikachu);
        electricShock.attack(squirtle);

        assertTrue(squirtle.getHP() == 100 || squirtle.getHP() == 50);
        assertTrue(pikachu.getHP() == 100 || pikachu.getHP() == 50);
    }

    @Test
    public void equalsTest() {
        assertEquals(electricShock, new ElectricShock( "Electric Shock", 50,
                "This is an electric shock attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricShock, new ElectricShock( "Electric Shock", 40,
                "This is an electric shock attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricShock, new ElectricShock( "Not Electric Shock", 50,
                "This is an electric shock attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricShock, new ElectricShock( "Electrick Shock", 40,
                "This is not an electric shock attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
        assertNotEquals(electricShock, new ElectricShock( "Electrick Shock", 50,
                "This is an electric shock attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(electricShock, new WaterAttack("Electric Shock", 50,
                "This is an electric shock attack",
                new ArrayList<>(Arrays.asList(electricEnergy))));
    }
}
