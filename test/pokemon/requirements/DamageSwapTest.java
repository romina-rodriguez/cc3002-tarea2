package pokemon.requirements;

import org.junit.Before;
import org.junit.Test;
import pokemon.*;
import pokemon.electric.BasicElectricPokemon;
import pokemon.water.BasicWaterPokemon;
import pokemon.water.WaterAttack;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the DamageSwap class.
 *
 * @author Romina Rodriguez
 */
public class DamageSwapTest {

    private IAbility damageSwap;
    private IPokemon
            pikachu,
            squirtle;
    private WaterAttack waterAttack;
    private Trainer trainer;
    private IEnergy energy;
    private ArrayList<IEnergy> abilityCost;


    @Before
    public void setUp() {
        abilityCost = new ArrayList<>(Arrays.asList(energy));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()), abilityCost);
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList()));
        damageSwap = new DamageSwap("Damage Swap", "This is a damage swap", abilityCost);
        trainer = new Trainer("Misty", squirtle,
                new ArrayList<>(Arrays.asList(pikachu)), new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Damage Swap", damageSwap.getName());
        assertEquals("This is a damage swap", damageSwap.getDescription());
        assertEquals(abilityCost, damageSwap.getEnergyListRequired());
    }

    @Test
    public void useAbilityTest() {
        damageSwap.useAbility(trainer);

        assertEquals(trainer.getActivePokemon().getHP(), 130);
        assertEquals(trainer.selectPokemon(0).getHP(), 70);
    }

    @Test
    public void equalsTest() {
        assertEquals(damageSwap, new DamageSwap("Damage Swap",
                "This is a damage swap", abilityCost));
        assertNotEquals(damageSwap, new DamageSwap("Not Damage Swap",
                "This is a damage swap", abilityCost));
        assertNotEquals(damageSwap, new DamageSwap("Damage Swap",
                "This is not a damage swap", abilityCost));
        assertNotEquals(damageSwap, new DamageSwap( "Damage Swap",
                "This is a damage swap",
                new ArrayList<>(Arrays.asList())));
    }
}