package pokemon.electric;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.fighting.FightingAttack;
import pokemon.fighting.FightingEnergy;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.water.WaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the ElectricPokemon class.
 *
 * @author Romina Rodríguez
 */
public class ElectricPokemonTest {

    private IPokemon
            pikachu,
            squirtle;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private ElectricEnergy electricEnergy;
    private FightingAttack fightingAttack;
    private FightingEnergy fightingEnergy;
    private WaterEnergy waterEnergy;

    @Before
    public void setUp() {
        fightingAttack = new FightingAttack( "Low kick", 30, "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy)));
        electricAttack = new ElectricAttack( "Thundershock", 50, "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        squirtle = new WaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
        pikachu = new ElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(electricAttack)),
                new ArrayList<>(Arrays.asList(electricEnergy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Pikachu", pikachu.getName());
        assertEquals(100, pikachu.getHP());
        assertEquals(1, pikachu.getAttacks().size());
        assertEquals(electricAttack, pikachu.getAttacks().get(0));
        assertNull(pikachu.getSelectedAttack());
        assertEquals(1, pikachu.getEnergies().size());
        assertEquals(electricEnergy, pikachu.getEnergies().get(0));

    }

    @Test
    public void selectAttackTest() {
        pikachu.selectAttack(0);
        assertEquals(electricAttack, pikachu.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        pikachu.selectAttack(0);
        pikachu.attack(squirtle);
        assertEquals(0, squirtle.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveFightingAttack(fightingAttack);
        assertEquals(40, pikachu.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveWaterAttack(waterAttack);
        assertEquals(60, pikachu.getHP());
    }
}