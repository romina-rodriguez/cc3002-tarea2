package pokemon.fire;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.grass.GrassAttack;
import pokemon.grass.BasicGrassPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.grass.GrassEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the BasicFirePokemon class.
 *
 * @author Romina Rodríguez
 */
public class BasicFirePokemonTest {

    private IPokemon
            bulbasaur,
            charmander;
    private WaterAttack waterAttack;
    private FireAttack fireAttack;
    private FireEnergy fireEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;
    private GrassAttack grassAttack;
    private Trainer trainer;

    @Before
    public void setUp() {
        fireAttack = new FireAttack("Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        grassAttack = new GrassAttack("Synthesis", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        charmander = new BasicFirePokemon("Charmander",4,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)));
        trainer = new Trainer("Misty", bulbasaur,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Charmander", charmander.getName());
        assertEquals(100, charmander.getHP());
        assertEquals(1, charmander.getAbilities().size());
        assertEquals(fireAttack, charmander.getAbilities().get(0));
        assertNull(charmander.getSelectedAbility());
        assertEquals(1, charmander.getEnergies().size());
        assertEquals(fireEnergy, charmander.getEnergies().get(0));
        assertEquals("Charmander", charmander.getCardName());
        assertEquals(4, charmander.getNumber());
    }

    @Test
    public void selectAttackTest() {
        charmander.selectAbility(0);
        assertEquals(fireAttack, charmander.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        charmander.selectAbility(0);
        charmander.attack(trainer);
        assertEquals(20, bulbasaur.getHP());
        charmander.attack(trainer);
        assertEquals(0, bulbasaur.getHP());
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
