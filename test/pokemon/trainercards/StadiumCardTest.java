package pokemon.trainercards;

import org.junit.Before;
import org.junit.Test;
import pokemon.ITrainerCard;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the StadiumCard class.
 *
 * @author Romina Rodríguez
 */
public class StadiumCardTest {

    private ITrainerCard
            ecogym;
    @Before
    public void setUp() {
        ecogym = new ItemCard("Ecogym", "This is a stadium card");
    }

    @Test
    public void constructorTest() {
        assertEquals("Ecogym", ecogym.getCardName());
        assertEquals("This is a stadium card", ecogym.getTrainerCardDescription());
    }
}
