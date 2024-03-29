package pokemon.electric;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.fighting.FightingAttack;
import pokemon.fighting.FightingEnergy;
import pokemon.water.BasicWaterPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the BasicElectricPokemon class.
 *
 * @author Romina Rodríguez
 */
public class BasicElectricPokemonTest {

    private IPokemon
            pikachu,
            squirtle;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private ElectricEnergy electricEnergy;
    private FightingAttack fightingAttack;
    private FightingEnergy fightingEnergy;
    private WaterEnergy waterEnergy;
    private Trainer trainer;

    @Before
    public void setUp() {
        fightingAttack = new FightingAttack( "Low kick", 30, "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy)));
        electricAttack = new ElectricAttack( "Thundershock", 50, "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(electricAttack)),
                new ArrayList<>(Arrays.asList(electricEnergy)));
        trainer = new Trainer("Misty", squirtle,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Pikachu", pikachu.getName());
        assertEquals(100, pikachu.getHP());
        pikachu.setHP(0);
        assertEquals(0, pikachu.getHP());
        pikachu.setHP(100);
        assertEquals(100, pikachu.getHP());
        assertEquals(1, pikachu.getAbilities().size());
        assertEquals(electricAttack, pikachu.getAbilities().get(0));
        assertNull(pikachu.getSelectedAbility());
        assertEquals(1, pikachu.getEnergies().size());
        assertEquals(electricEnergy, pikachu.getEnergies().get(0));
        assertEquals("Pikachu", pikachu.getCardName());
        assertEquals(25, pikachu.getNumber());

    }

    @Test
    public void selectAttackTest() {
        pikachu.selectAbility(0);
        assertEquals(electricAttack, pikachu.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        pikachu.selectAbility(0);
        pikachu.attack(trainer);
        assertEquals(0, squirtle.getHP());
        pikachu.attack(trainer);
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
