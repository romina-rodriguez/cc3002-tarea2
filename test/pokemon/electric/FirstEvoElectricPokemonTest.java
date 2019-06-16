package pokemon.electric;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEvoPokemon;
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
 * Tests set for the FirstEvoElectricPokemon class.
 *
 * @author Romina Rodríguez
 */
public class FirstEvoElectricPokemonTest {

    private IPokemon
            pikachu,
            squirtle;
    private IEvoPokemon raichu;
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
        raichu = new FirstEvoElectricPokemon("Raichu", 26, 100,
                new ArrayList<>(Arrays.asList(electricAttack)),
                new ArrayList<>(Arrays.asList(electricEnergy)), 25);
        trainer = new Trainer("Misty", squirtle,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Raichu", raichu.getName());
        assertEquals(100, raichu.getHP());
        raichu.setHP(0);
        assertEquals(0, raichu.getHP());
        raichu.setHP(100);
        assertEquals(100, raichu.getHP());
        assertEquals(1, raichu.getAbilities().size());
        assertEquals(electricAttack, raichu.getAbilities().get(0));
        assertNull(raichu.getSelectedAbility());
        assertEquals(1, raichu.getEnergies().size());
        assertEquals(electricEnergy, raichu.getEnergies().get(0));
        assertEquals("Raichu", raichu.getCardName());
        assertEquals(26, raichu.getNumber());
        assertEquals(25, raichu.getPreEvolution());

    }

    @Test
    public void selectAttackTest() {
        raichu.selectAbility(0);
        assertEquals(electricAttack, raichu.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        raichu.selectAbility(0);
        raichu.attack(trainer);
        assertEquals(0, squirtle.getHP());
        raichu.attack(trainer);
        assertEquals(0, squirtle.getHP());
    }

    @Test
    public void receiveFightingAttack() {
        assertEquals(100, raichu.getHP());
        raichu.receiveFightingAttack(fightingAttack);
        assertEquals(40, raichu.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, raichu.getHP());
        raichu.receiveWaterAttack(waterAttack);
        assertEquals(60, raichu.getHP());
    }
}