package pokemon.fighting;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.BasicGrassPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.grass.GrassEnergy;
import pokemon.psychic.PsychicAttack;
import pokemon.psychic.PsychicEnergy;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the BasicFightingPokemon class.
 *
 * @author Romina Rodríguez
 */
public class BasicFightingPokemonTest {

    private IPokemon
            bulbasaur,
            mankey;
    private WaterAttack waterAttack;
    private PsychicAttack psychicAttack;
    private PsychicEnergy psychicEnergy;
    private FightingAttack fightingAttack;
    private FightingEnergy fightingEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;
    private GrassAttack grassAttack;

    @Before
    public void setUp() {
        fightingAttack = new FightingAttack( "Low kick", 30, "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy)));
        psychicAttack = new PsychicAttack( "Calm mind", 30, "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        mankey = new BasicFightingPokemon("Mankey", 56, 100,
                new ArrayList<>(Arrays.asList(fightingAttack)),
                new ArrayList<>(Arrays.asList(fightingEnergy, waterEnergy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Mankey", mankey.getName());
        assertEquals(100, mankey.getHP());
        assertEquals(1, mankey.getAttacks().size());
        assertEquals(fightingAttack, mankey.getAttacks().get(0));
        assertNull(mankey.getSelectedAttack());
        assertEquals(2, mankey.getEnergies().size());
        assertEquals(fightingEnergy, mankey.getEnergies().get(0));
        assertEquals(waterEnergy, mankey.getEnergies().get(1));
        assertEquals("Mankey", mankey.getCardName());
        assertEquals(56, mankey.getNumber());
    }

    @Test
    public void selectAttackTest() {
        mankey.selectAttack(0);
        assertEquals(fightingAttack, mankey.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        mankey.selectAttack(0);
        mankey.attack(bulbasaur);
        assertEquals(70, bulbasaur.getHP());
        mankey.attack(bulbasaur);
        mankey.attack(bulbasaur);
        mankey.attack(bulbasaur);
        assertEquals(0, bulbasaur.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, mankey.getHP());
        mankey.receivePsychicAttack(psychicAttack);
        assertEquals(40, mankey.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, mankey.getHP());
        mankey.receiveGrassAttack(grassAttack);
        assertEquals(20, mankey.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, mankey.getHP());
        mankey.receiveWaterAttack(waterAttack);
        assertEquals(60, mankey.getHP());
    }
}
