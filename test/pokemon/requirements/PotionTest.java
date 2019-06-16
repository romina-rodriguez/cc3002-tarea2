package pokemon.requirements;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the Potion class.
 *
 * @author Romina Rodriguez
 */
public class PotionTest {

    private Potion potion;
    private ArrayList<IEnergy> abilityCost;
    private IPokemon squirtle;
    private Trainer trainer;

    @Before
    public void setUp() {
        potion = new Potion("Potion", "This is a potion");
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        trainer = new Trainer("Misty", squirtle,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Potion", potion.getCardName());
        assertEquals("This is a potion", potion.getTrainerCardDescription());
    }

    @Test
    public void useCardTest() {
        potion.useCard(trainer);
        assertEquals(120, squirtle.getHP());

    }
}