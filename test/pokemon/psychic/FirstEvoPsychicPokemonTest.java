package pokemon.psychic;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEvoPokemon;
import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.fighting.FightingAttack;
import pokemon.fighting.FightingEnergy;
import pokemon.grass.BasicGrassPokemon;
import pokemon.grass.GrassEnergy;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the FirstEvoPsychicPokemon class.
 *
 * @author Romina Rodríguez
 */
public class FirstEvoPsychicPokemonTest {

    private IPokemon
            bulbasaur;
    private IEvoPokemon kadabra;
    private WaterAttack waterAttack;
    private PsychicAttack psychicAttack;
    private PsychicEnergy psychicEnergy;
    private FightingAttack fightingAttack;
    private FightingEnergy fightingEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;
    private Trainer trainer;

    @Before
    public void setUp() {
        fightingAttack = new FightingAttack( "Low kick", 30, "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy)));
        psychicAttack = new PsychicAttack( "Calm mind", 30, "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        kadabra = new FirstEvoPsychicPokemon("Kadabra", 64, 100,
                new ArrayList<>(Arrays.asList(psychicAttack)),
                new ArrayList<>(Arrays.asList()), 63);
        trainer = new Trainer("Misty", bulbasaur,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Kadabra", kadabra.getName());
        assertEquals(100, kadabra.getHP());
        assertEquals(1, kadabra.getAbilities().size());
        assertEquals(psychicAttack, kadabra.getAbilities().get(0));
        assertNull(kadabra.getSelectedAbility());
        assertEquals(0, kadabra.getEnergies().size());
        assertEquals("Kadabra", kadabra.getCardName());
        assertEquals(64, kadabra.getNumber());
        assertEquals(63, kadabra.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        kadabra.selectAbility(0);
        assertEquals(psychicAttack, kadabra.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        kadabra.selectAbility(0);
        kadabra.attack(trainer);
        assertEquals(100, bulbasaur.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, kadabra.getHP());
        kadabra.receivePsychicAttack(psychicAttack);
        assertEquals(40, kadabra.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, kadabra.getHP());
        kadabra.receiveFightingAttack(fightingAttack);
        assertEquals(100, kadabra.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, kadabra.getHP());
        kadabra.receiveWaterAttack(waterAttack);
        assertEquals(60, kadabra.getHP());
    }
}