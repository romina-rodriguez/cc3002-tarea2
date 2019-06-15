package pokemon.electric;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEvoPokemon;
import pokemon.IPokemon;
import pokemon.abilities.ElectricShock;
import pokemon.fighting.FightingAttack;
import pokemon.fighting.FightingEnergy;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the FirstEvoElectricPokemon class.
 *
 * @author Romina Rodríguez
 */
public class SecondEvoElectricPokemonTest {

    private IPokemon
            pikachu,
            squirtle;
    private IEvoPokemon electivire;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private ElectricEnergy electricEnergy;
    private FightingAttack fightingAttack;
    private FightingEnergy fightingEnergy;
    private WaterEnergy waterEnergy;
    private ElectricShock electricShock;

    @Before
    public void setUp() {
        fightingAttack = new FightingAttack( "Low kick", 30, "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy)));
        electricAttack = new ElectricAttack( "Thundershock", 50, "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy)));
        electricShock = new ElectricShock("Electric Shock", 50, "This is an electric shock attack",
                new ArrayList<>(Arrays.asList(electricEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(electricAttack)),
                new ArrayList<>(Arrays.asList(electricEnergy)));
        electivire = new SecondEvoElectricPokemon("Electivire", 466, 100,
                new ArrayList<>(Arrays.asList(electricAttack, electricShock)),
                new ArrayList<>(Arrays.asList(electricEnergy)), 125);
    }

    @Test
    public void constructorTest() {
        assertEquals("Electivire", electivire.getName());
        assertEquals(100, electivire.getHP());
        electivire.setHP(0);
        assertEquals(0, electivire.getHP());
        electivire.setHP(100);
        assertEquals(100, electivire.getHP());
        assertEquals(2, electivire.getAbilities().size());
        assertEquals(electricAttack, electivire.getAbilities().get(0));
        assertNull(electivire.getSelectedAbility());
        assertEquals(1, electivire.getEnergies().size());
        assertEquals(electricEnergy, electivire.getEnergies().get(0));
        assertEquals("Electivire", electivire.getCardName());
        assertEquals(466, electivire.getNumber());
        assertEquals(125, electivire.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        electivire.selectAbility(0);
        assertEquals(electricAttack, electivire.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        electivire.selectAbility(1);
        electivire.attack(squirtle);
        assertTrue(squirtle.getHP() == 100 || squirtle.getHP() == 50);
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