package pokemon.water;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEvoPokemon;
import pokemon.IPokemon;
import pokemon.electric.ElectricAttack;
import pokemon.electric.ElectricEnergy;
import pokemon.fighting.FightingAttack;
import pokemon.fighting.FightingEnergy;
import pokemon.grass.BasicGrassPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.GrassEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the SecondEvoWaterPokemon class.
 *
 * @author Romina Rodríguez
 */
public class SecondEvoWaterPokemonTest {

    private IPokemon
            bulbasaur;
    private IEvoPokemon blastoise;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private ElectricEnergy electricEnergy;
    private FightingAttack fightingAttack;
    private FightingEnergy fightingEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;
    private GrassAttack grassAttack;

    @Before
    public void setUp() {
        fightingAttack = new FightingAttack( "Low kick", 30, "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy)));
        electricAttack = new ElectricAttack( "Thundershock", 50, "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        blastoise = new FirstEvoWaterPokemon("Blastoise", 9, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)), 8);
    }

    @Test
    public void constructorTest() {
        assertEquals("Blastoise", blastoise.getName());
        assertEquals(100, blastoise.getHP());
        assertEquals(1, blastoise.getAbilities().size());
        assertEquals(waterAttack, blastoise.getAbilities().get(0));
        assertNull(blastoise.getSelectedAbility());
        assertEquals(1, blastoise.getEnergies().size());
        assertEquals(waterEnergy, blastoise.getEnergies().get(0));
        assertEquals("Blastoise", blastoise.getCardName());
        assertEquals(9, blastoise.getNumber());
        assertEquals(8, blastoise.getPreEvolution());

    }

    @Test
    public void selectAttackTest() {
        blastoise.selectAbility(0);
        assertEquals(waterAttack, blastoise.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        blastoise.selectAbility(0);
        blastoise.attack(bulbasaur);
        assertEquals(90, bulbasaur.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, blastoise.getHP());
        blastoise.receiveGrassAttack(grassAttack);
        assertEquals(20, blastoise.getHP());
    }

    @Test
    public void receiveElectricAttack() {
        assertEquals(100, blastoise.getHP());
        blastoise.receiveElectricAttack(electricAttack);
        assertEquals(0, blastoise.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, blastoise.getHP());
        blastoise.receiveFightingAttack(fightingAttack);
        assertEquals(100, blastoise.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, blastoise.getHP());
        blastoise.receiveWaterAttack(waterAttack);
        assertEquals(60, blastoise.getHP());
    }
}