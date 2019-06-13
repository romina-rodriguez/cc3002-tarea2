package pokemon.fighting;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEvoPokemon;
import pokemon.IPokemon;
import pokemon.grass.BasicGrassPokemon;
import pokemon.grass.GrassAttack;
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
 * Tests set for the FirstEvoFightingPokemon class.
 *
 * @author Romina Rodríguez
 */
public class FirstEvoFightingPokemonTest {

    private IPokemon
            bulbasaur;
    private IEvoPokemon primeape;
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
        primeape = new FirstEvoFightingPokemon("Primeape", 57, 100,
                new ArrayList<>(Arrays.asList(fightingAttack)),
                new ArrayList<>(Arrays.asList(fightingEnergy, waterEnergy)), 56);
    }

    @Test
    public void constructorTest() {
        assertEquals("Primeape", primeape.getName());
        assertEquals(100, primeape.getHP());
        assertEquals(1, primeape.getAttacks().size());
        assertEquals(fightingAttack, primeape.getAttacks().get(0));
        assertNull(primeape.getSelectedAttack());
        assertEquals(2, primeape.getEnergies().size());
        assertEquals(fightingEnergy, primeape.getEnergies().get(0));
        assertEquals(waterEnergy, primeape.getEnergies().get(1));
        assertEquals("Primeape", primeape.getCardName());
        assertEquals(57, primeape.getNumber());
        assertEquals(56, primeape.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        primeape.selectAttack(0);
        assertEquals(fightingAttack, primeape.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        primeape.selectAttack(0);
        primeape.attack(bulbasaur);
        assertEquals(70, bulbasaur.getHP());
        primeape.attack(bulbasaur);
        primeape.attack(bulbasaur);
        primeape.attack(bulbasaur);
        assertEquals(0, bulbasaur.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, primeape.getHP());
        primeape.receivePsychicAttack(psychicAttack);
        assertEquals(40, primeape.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, primeape.getHP());
        primeape.receiveGrassAttack(grassAttack);
        assertEquals(20, primeape.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, primeape.getHP());
        primeape.receiveWaterAttack(waterAttack);
        assertEquals(60, primeape.getHP());
    }
}