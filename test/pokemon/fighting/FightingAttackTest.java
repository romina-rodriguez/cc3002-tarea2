package pokemon.fighting;

import org.junit.Before;
import org.junit.Test;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.electric.BasicElectricPokemon;
import pokemon.psychic.BasicPsychicPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests set for the FightingAttack class.
 *
 * @author Romina Rodriguez
 */
public class FightingAttackTest {

    private IAttack fightingAttack;
    private IPokemon
            pikachu,
            squirtle,
            mewtwo,
            mankey;
    private WaterAttack waterAttack;
    private FightingEnergy fightingEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(fightingEnergy));
        fightingAttack = new FightingAttack( "Low kick", 30, "This is a fighting attack",
                attackCost);
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        mewtwo = new BasicPsychicPokemon("Mewtwo", 150,100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        mankey = new BasicFightingPokemon("Mankey", 56, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Low kick", fightingAttack.getName());
        assertEquals(30, fightingAttack.getBaseDamage());
        assertEquals("This is a fighting attack", fightingAttack.getDescription());
        assertEquals(attackCost, fightingAttack.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        fightingAttack.attack(pikachu);
        fightingAttack.attack(squirtle);
        fightingAttack.attack(mewtwo);
        fightingAttack.attack(mankey);

        assertEquals(40, pikachu.getHP());
        assertEquals(100, squirtle.getHP());
        assertEquals(100, mewtwo.getHP());
        assertEquals(70, mankey.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(fightingAttack, new FightingAttack( "Low kick", 30,
                "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy))));
        assertNotEquals(fightingAttack, new FightingAttack( "Low kick", 40,
                "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy))));
        assertNotEquals(fightingAttack, new FightingAttack( "Not Low kick", 30,
                "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy))));
        assertNotEquals(fightingAttack, new FightingAttack( "Low kick", 30,
                "This is not a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy))));
        assertNotEquals(fightingAttack, new FightingAttack( "Low kick", 30,
                "This is a fighting attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(fightingAttack, new WaterAttack("Low kick", 30,
                "This is a fighting attack",
                new ArrayList<>(Arrays.asList(fightingEnergy))));
    }
}
