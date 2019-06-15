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
 * Tests set for the FirstEvoWaterPokemon class.
 *
 * @author Romina Rodríguez
 */
public class FirstEvoWaterPokemonTest {

    private IPokemon
            bulbasaur;
    private IEvoPokemon wartortle;
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
        wartortle = new FirstEvoWaterPokemon("Wartortle", 8, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)), 7);
    }

    @Test
    public void constructorTest() {
        assertEquals("Wartortle", wartortle.getName());
        assertEquals(100, wartortle.getHP());
        assertEquals(1, wartortle.getAbilities().size());
        assertEquals(waterAttack, wartortle.getAbilities().get(0));
        assertNull(wartortle.getSelectedAbility());
        assertEquals(1, wartortle.getEnergies().size());
        assertEquals(waterEnergy, wartortle.getEnergies().get(0));
        assertEquals("Wartortle", wartortle.getCardName());
        assertEquals(8, wartortle.getNumber());
        assertEquals(7, wartortle.getPreEvolution());

    }

    @Test
    public void selectAttackTest() {
        wartortle.selectAbility(0);
        assertEquals(waterAttack, wartortle.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        wartortle.selectAbility(0);
        wartortle.attack(bulbasaur);
        assertEquals(90, bulbasaur.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, wartortle.getHP());
        wartortle.receiveGrassAttack(grassAttack);
        assertEquals(20, wartortle.getHP());
    }

    @Test
    public void receiveElectricAttack() {
        assertEquals(100, wartortle.getHP());
        wartortle.receiveElectricAttack(electricAttack);
        assertEquals(0, wartortle.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, wartortle.getHP());
        wartortle.receiveFightingAttack(fightingAttack);
        assertEquals(100, wartortle.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, wartortle.getHP());
        wartortle.receiveWaterAttack(waterAttack);
        assertEquals(60, wartortle.getHP());
    }
}