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
 * Tests set for the SecondEvoFightingPokemon class.
 *
 * @author Romina Rodríguez
 */
public class SecondEvoFightingPokemonTest {

    private IPokemon
            bulbasaur;
    private IEvoPokemon machamp;
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
        fightingAttack = new FightingAttack("Low kick", 30, "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy)));
        psychicAttack = new PsychicAttack("Calm mind", 30, "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        machamp = new SecondEvoFightingPokemon("Machamp", 68, 100,
                new ArrayList<>(Arrays.asList(fightingAttack)),
                new ArrayList<>(Arrays.asList(fightingEnergy, waterEnergy)), 67);
    }

    @Test
    public void constructorTest() {
        assertEquals("Machamp", machamp.getName());
        assertEquals(100, machamp.getHP());
        assertEquals(1, machamp.getAbilities().size());
        assertEquals(fightingAttack, machamp.getAbilities().get(0));
        assertNull(machamp.getSelectedAbility());
        assertEquals(2, machamp.getEnergies().size());
        assertEquals(fightingEnergy, machamp.getEnergies().get(0));
        assertEquals(waterEnergy, machamp.getEnergies().get(1));
        assertEquals("Machamp", machamp.getCardName());
        assertEquals(68, machamp.getNumber());
        assertEquals(67, machamp.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        machamp.selectAbility(0);
        assertEquals(fightingAttack, machamp.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        machamp.selectAbility(0);
        machamp.attack(bulbasaur);
        assertEquals(70, bulbasaur.getHP());
        machamp.attack(bulbasaur);
        machamp.attack(bulbasaur);
        machamp.attack(bulbasaur);
        assertEquals(0, bulbasaur.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, machamp.getHP());
        machamp.receivePsychicAttack(psychicAttack);
        assertEquals(40, machamp.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, machamp.getHP());
        machamp.receiveGrassAttack(grassAttack);
        assertEquals(20, machamp.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, machamp.getHP());
        machamp.receiveWaterAttack(waterAttack);
        assertEquals(60, machamp.getHP());
    }
}