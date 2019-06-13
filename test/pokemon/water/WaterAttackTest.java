package pokemon.water;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.IAttack;
import pokemon.fire.FireAttack;
import pokemon.fire.BasicFirePokemon;
import pokemon.grass.BasicGrassPokemon;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests set for the WaterAttack class.
 *
 * @author Romina Rodriguez
 */
public class WaterAttackTest {

    private IAttack waterAttack;
    private IPokemon
            charmander,
            bulbasaur,
            squirtle;
    private FireAttack fireAttack;
    private WaterEnergy waterEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(waterEnergy));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                attackCost);
        charmander = new BasicFirePokemon("Charmander",4,100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Bubble", waterAttack.getName());
        assertEquals(40, waterAttack.getBaseDamage());
        assertEquals("This is a water attack", waterAttack.getDescription());
        assertEquals(attackCost, waterAttack.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        waterAttack.attack(charmander);
        waterAttack.attack(squirtle);
        waterAttack.attack(bulbasaur);

        assertEquals(20, charmander.getHP());
        assertEquals(60, squirtle.getHP());
        assertEquals(90, bulbasaur.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(waterAttack, new WaterAttack("Bubble", 40,
                "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy))));
        assertNotEquals(waterAttack, new WaterAttack("Bubble", 30,
                "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy))));
        assertNotEquals(waterAttack, new WaterAttack("Not Bubble", 40,
                "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy))));
        assertNotEquals(waterAttack, new WaterAttack("Bubble", 40,
                "This is not a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy))));
        assertNotEquals(waterAttack, new WaterAttack("Bubble", 40,
                "This is not a water attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(waterAttack, new FireAttack("Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList(waterEnergy))));
    }
}
