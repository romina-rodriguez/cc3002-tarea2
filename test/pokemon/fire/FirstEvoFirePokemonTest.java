package pokemon.fire;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEvoPokemon;
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
 * Tests set for the FirstEvoFirePokemon class.
 *
 * @author Romina Rodríguez
 */
public class FirstEvoFirePokemonTest {

    private IPokemon
            bulbasaur;
    IEvoPokemon charmeleon;
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
        charmeleon = new FirstEvoFirePokemon("Charmeleon",5,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)), 4);
        trainer = new Trainer("Misty", bulbasaur,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Charmeleon", charmeleon.getName());
        assertEquals(100, charmeleon.getHP());
        assertEquals(1, charmeleon.getAbilities().size());
        assertEquals(fireAttack, charmeleon.getAbilities().get(0));
        assertNull(charmeleon.getSelectedAbility());
        assertEquals(1, charmeleon.getEnergies().size());
        assertEquals(fireEnergy, charmeleon.getEnergies().get(0));
        assertEquals("Charmeleon", charmeleon.getCardName());
        assertEquals(5, charmeleon.getNumber());
        assertEquals(4, charmeleon.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        charmeleon.selectAbility(0);
        assertEquals(fireAttack, charmeleon.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        charmeleon.selectAbility(0);
        charmeleon.attack(trainer);
        assertEquals(20, bulbasaur.getHP());
        charmeleon.attack(trainer);
        assertEquals(0, bulbasaur.getHP());
    }

    @Test
    public void receiveWaterAttack() {
        assertEquals(100, charmeleon.getHP());
        charmeleon.receiveWaterAttack(waterAttack);
        assertEquals(20, charmeleon.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, charmeleon.getHP());
        charmeleon.receiveGrassAttack(grassAttack);
        assertEquals(60, charmeleon.getHP());
    }

}