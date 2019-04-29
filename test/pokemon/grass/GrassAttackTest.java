package pokemon.grass;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.IAttack;
import pokemon.fighting.FightingPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests set for the GrassAttack class.
 *
 * @author Romina Rodriguez
 */
public class GrassAttackTest {

    private IAttack grassAttack;
    private IPokemon
            mankey,
            bulbasaur,
            squirtle;
    private WaterAttack waterAttack;
    private GrassEnergy grassEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(grassEnergy));
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        bulbasaur = new GrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        squirtle = new WaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        mankey = new FightingPokemon("Mankey", 56, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Growl", grassAttack.getName());
        assertEquals(40, grassAttack.getBaseDamage());
        assertEquals("This is a grass attack", grassAttack.getDescription());
        assertEquals(attackCost, grassAttack.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        grassAttack.attack(mankey);
        grassAttack.attack(squirtle);
        grassAttack.attack(bulbasaur);

        assertEquals(20, mankey.getHP());
        assertEquals(20, squirtle.getHP());
        assertEquals(60, bulbasaur.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(grassAttack, new GrassAttack("Growl", 40,
                "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy))));
        assertNotEquals(grassAttack, new GrassAttack("Growl", 30,
                "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy))));
        assertNotEquals(grassAttack, new GrassAttack("Not Growl", 40,
                "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy))));
        assertNotEquals(grassAttack, new GrassAttack("Growl", 40,
                "This is not a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy))));
        assertNotEquals(grassAttack, new GrassAttack("Growl", 40,
                "This is not a grass attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(grassAttack, new WaterAttack("Growl", 40,
                "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy))));
    }
}
