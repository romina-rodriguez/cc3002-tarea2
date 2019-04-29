package pokemon.psychic;

import org.junit.Before;
import org.junit.Test;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.fighting.FightingPokemon;
import pokemon.water.WaterAttack;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests set for the PsychicAttack class.
 *
 * @author Romina Rodriguez
 */
public class PsychicAttackTest {

    private IAttack psychicAttack;
    private IPokemon
            mewtwo,
            mankey;
    private WaterAttack waterAttack;
    private PsychicEnergy psychicEnergy;
    private ArrayList<IEnergy> attackCost;


    @Before
    public void setUp() {
        attackCost = new ArrayList<>(Arrays.asList(psychicEnergy));
        psychicAttack = new PsychicAttack( "Calm mind", 30, "This is a psychic attack",
                attackCost);
        mewtwo = new PsychicPokemon("Mewtwo", 150,100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        mankey = new FightingPokemon("Mankey", 56, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void constructorTest() {
        assertEquals("Calm mind", psychicAttack.getName());
        assertEquals(30, psychicAttack.getBaseDamage());
        assertEquals("This is a psychic attack", psychicAttack.getDescription());
        assertEquals(attackCost, psychicAttack.getEnergyListRequired());
    }

    @Test
    public void attackTest() {
        psychicAttack.attack(mankey);
        psychicAttack.attack(mewtwo);

        assertEquals(40, mankey.getHP());
        assertEquals(40, mewtwo.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(psychicAttack, new PsychicAttack( "Calm mind", 30,
                "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy))));
        assertNotEquals(psychicAttack, new PsychicAttack( "Calm mind", 40,
                "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy))));
        assertNotEquals(psychicAttack, new PsychicAttack( "Not Calm mind", 30,
                "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy))));
        assertNotEquals(psychicAttack, new PsychicAttack( "Calm mind", 30,
                "This is a not psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy))));
        assertNotEquals(psychicAttack, new PsychicAttack( "Calm mind", 30,
                "This is a not psychic attack",
                new ArrayList<>(Arrays.asList())));
        assertNotEquals(psychicAttack, new WaterAttack("Calm mind", 30,
                "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy))));
    }
}
