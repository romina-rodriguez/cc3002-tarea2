package pokemon.fire;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.IAttack;
import pokemon.grass.BasicGrassPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests set for the FireAttack class.
 *
 * @author Romina Rodriguez
 */
public class FireAttackTest {

    private IAttack fireAttack;
    private IPokemon
            charmander,
            bulbasaur,
            squirtle;
    private WaterAttack waterAttack;
    private FireEnergy fireEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(fireEnergy));
        fireAttack = new FireAttack("Ember", 40, "This is a fire attack",
                attackCost);
        charmander = new BasicFirePokemon("Charmander",4,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Ember", fireAttack.getName());
        assertEquals(40, fireAttack.getBaseDamage());
        assertEquals("This is a fire attack", fireAttack.getDescription());
        assertEquals(attackCost, fireAttack.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        fireAttack.attack(charmander);
        fireAttack.attack(squirtle);
        fireAttack.attack(bulbasaur);

        assertEquals(60, charmander.getHP());
        assertEquals(60, squirtle.getHP());
        assertEquals(20, bulbasaur.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(fireAttack, new FireAttack("Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy))));
        assertNotEquals(fireAttack, new FireAttack("Ember", 30, "This is a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy))));
        assertNotEquals(fireAttack, new FireAttack("Not Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy))));
        assertNotEquals(fireAttack, new FireAttack("Ember", 40, "This is not a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy))));
        assertNotEquals(fireAttack, new FireAttack("Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(fireAttack, new WaterAttack("Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy))));
    }
}
