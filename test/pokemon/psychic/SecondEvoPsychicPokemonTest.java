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
 * Tests set for the SecondEvoPsychicPokemon class.
 *
 * @author Romina Rodríguez
 */
public class SecondEvoPsychicPokemonTest {

    private IPokemon
            bulbasaur;
    private IEvoPokemon alakazam;
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
        alakazam = new SecondEvoPsychicPokemon("Alakazam", 65, 100,
                new ArrayList<>(Arrays.asList(psychicAttack)),
                new ArrayList<>(Arrays.asList()), 64);
        trainer = new Trainer("Misty", bulbasaur,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Alakazam", alakazam.getName());
        assertEquals(100, alakazam.getHP());
        assertEquals(1, alakazam.getAbilities().size());
        assertEquals(psychicAttack, alakazam.getAbilities().get(0));
        assertNull(alakazam.getSelectedAbility());
        assertEquals(0, alakazam.getEnergies().size());
        assertEquals("Alakazam", alakazam.getCardName());
        assertEquals(65, alakazam.getNumber());
        assertEquals(64, alakazam.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        alakazam.selectAbility(0);
        assertEquals(psychicAttack, alakazam.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        alakazam.selectAbility(0);
        alakazam.attack(trainer);
        assertEquals(100, bulbasaur.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, alakazam.getHP());
        alakazam.receivePsychicAttack(psychicAttack);
        assertEquals(40, alakazam.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, alakazam.getHP());
        alakazam.receiveFightingAttack(fightingAttack);
        assertEquals(100, alakazam.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, alakazam.getHP());
        alakazam.receiveWaterAttack(waterAttack);
        assertEquals(60, alakazam.getHP());
    }
}