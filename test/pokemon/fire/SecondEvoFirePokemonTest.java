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
 * Tests set for the SecondEvoFirePokemon class.
 *
 * @author Romina Rodríguez
 */
public class SecondEvoFirePokemonTest {

    private IPokemon
            bulbasaur;
    IEvoPokemon charizard;
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
        charizard = new SecondEvoFirePokemon("Charizard",6,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)), 5);
        trainer = new Trainer("Misty", bulbasaur,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Charizard", charizard.getName());
        assertEquals(100, charizard.getHP());
        assertEquals(1, charizard.getAbilities().size());
        assertEquals(fireAttack, charizard.getAbilities().get(0));
        assertNull(charizard.getSelectedAbility());
        assertEquals(1, charizard.getEnergies().size());
        assertEquals(fireEnergy, charizard.getEnergies().get(0));
        assertEquals("Charizard", charizard.getCardName());
        assertEquals(6, charizard.getNumber());
        assertEquals(5, charizard.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        charizard.selectAbility(0);
        assertEquals(fireAttack, charizard.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        charizard.selectAbility(0);
        charizard.attack(trainer);
        assertEquals(20, bulbasaur.getHP());
        charizard.attack(trainer);
        assertEquals(0, bulbasaur.getHP());
    }

    @Test
    public void receiveWaterAttack() {
        assertEquals(100, charizard.getHP());
        charizard.receiveWaterAttack(waterAttack);
        assertEquals(20, charizard.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, charizard.getHP());
        charizard.receiveGrassAttack(grassAttack);
        assertEquals(60, charizard.getHP());
    }

}