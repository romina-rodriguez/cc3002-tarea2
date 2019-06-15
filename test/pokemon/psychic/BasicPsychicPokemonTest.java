package pokemon.psychic;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.fighting.FightingAttack;
import pokemon.fighting.FightingEnergy;
import pokemon.grass.BasicGrassPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.grass.GrassEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the BasicPsychicPokemon class.
 *
 * @author Romina Rodríguez
 */
public class BasicPsychicPokemonTest {

    private IPokemon
            bulbasaur,
            abra;
    private WaterAttack waterAttack;
    private PsychicAttack psychicAttack;
    private PsychicEnergy psychicEnergy;
    private FightingAttack fightingAttack;
    private FightingEnergy fightingEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;

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
        abra = new BasicPsychicPokemon("Abra", 63, 100,
                new ArrayList<>(Arrays.asList(psychicAttack)),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Abra", abra.getName());
        assertEquals(100, abra.getHP());
        assertEquals(1, abra.getAbilities().size());
        assertEquals(psychicAttack, abra.getAbilities().get(0));
        assertNull(abra.getSelectedAbility());
        assertEquals(0, abra.getEnergies().size());
        assertEquals("Abra", abra.getCardName());
        assertEquals(63, abra.getNumber());
    }

    @Test
    public void selectAttackTest() {
        abra.selectAbility(0);
        assertEquals(psychicAttack, abra.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        abra.selectAbility(0);
        abra.attack(bulbasaur);
        assertEquals(100, bulbasaur.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, abra.getHP());
        abra.receivePsychicAttack(psychicAttack);
        assertEquals(40, abra.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveFightingAttack(fightingAttack);
        assertEquals(100, abra.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveWaterAttack(waterAttack);
        assertEquals(60, abra.getHP());
    }
}
