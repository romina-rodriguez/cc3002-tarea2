package pokemon.fire;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.GrassPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.grass.GrassEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the FirePokemon class.
 *
 * @author Romina Rodríguez
 */
public class FirePokemonTest {

    private IPokemon
            bulbasaur,
            charmander;
    private WaterAttack waterAttack;
    private FireAttack fireAttack;
    private FireEnergy fireEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;
    private GrassAttack grassAttack;

    @Before
    public void setUp() {
        fireAttack = new FireAttack("Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        grassAttack = new GrassAttack("Synthesis", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        bulbasaur = new GrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        charmander = new FirePokemon("Charmander",4,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Charmander", charmander.getName());
        assertEquals(100, charmander.getHP());
        assertEquals(1, charmander.getAttacks().size());
        assertEquals(fireAttack, charmander.getAttacks().get(0));
        assertNull(charmander.getSelectedAttack());
        assertEquals(1, charmander.getEnergies().size());
        assertEquals(fireEnergy, charmander.getEnergies().get(0));
    }

    @Test
    public void selectAttackTest() {
        charmander.selectAttack(0);
        assertEquals(fireAttack, charmander.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        charmander.selectAttack(0);
        charmander.attack(bulbasaur);
        assertEquals(20, bulbasaur.getHP());
    }

    @Test
    public void receiveWaterAttack() {
        assertEquals(100, charmander.getHP());
        charmander.receiveWaterAttack(waterAttack);
        assertEquals(20, charmander.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, charmander.getHP());
        charmander.receiveGrassAttack(grassAttack);
        assertEquals(60, charmander.getHP());
    }

}
