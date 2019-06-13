package pokemon.water;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.fighting.FightingAttack;
import pokemon.fighting.FightingEnergy;
import pokemon.grass.GrassAttack;
import pokemon.grass.BasicGrassPokemon;
import pokemon.electric.ElectricEnergy;
import pokemon.electric.ElectricAttack;
import pokemon.grass.GrassEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the BasicWaterPokemon class.
 *
 * @author Romina Rodríguez
 */
public class BasicWaterPokemonTest {

    private IPokemon
            bulbasaur,
            squirtle;
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
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Squirtle", squirtle.getName());
        assertEquals(100, squirtle.getHP());
        assertEquals(1, squirtle.getAttacks().size());
        assertEquals(waterAttack, squirtle.getAttacks().get(0));
        assertNull(squirtle.getSelectedAttack());
        assertEquals(1, squirtle.getEnergies().size());
        assertEquals(waterEnergy, squirtle.getEnergies().get(0));
        assertEquals("Squirtle", squirtle.getCardName());
        assertEquals(7, squirtle.getNumber());

    }

    @Test
    public void selectAttackTest() {
        squirtle.selectAttack(0);
        assertEquals(waterAttack, squirtle.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        squirtle.selectAttack(0);
        squirtle.attack(bulbasaur);
        assertEquals(90, bulbasaur.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, squirtle.getHP());
        squirtle.receiveGrassAttack(grassAttack);
        assertEquals(20, squirtle.getHP());
    }

    @Test
    public void receiveElectricAttack() {
        assertEquals(100, squirtle.getHP());
        squirtle.receiveElectricAttack(electricAttack);
        assertEquals(0, squirtle.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, squirtle.getHP());
        squirtle.receiveFightingAttack(fightingAttack);
        assertEquals(100, squirtle.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, squirtle.getHP());
        squirtle.receiveWaterAttack(waterAttack);
        assertEquals(60, squirtle.getHP());
    }
}
