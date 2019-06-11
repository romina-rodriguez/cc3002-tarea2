package pokemon.trainercards;

import org.junit.Before;
import org.junit.Test;
import pokemon.ITrainerCard;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the SupporterCard class.
 *
 * @author Romina Rodríguez
 */
public class SupporterCardTest {

    private ITrainerCard
            copycat;
    @Before
    public void setUp() {
        copycat = new ItemCard("Copycat", "This is a supporter card");
    }

    @Test
    public void constructorTest() {
        assertEquals("Copycat", copycat.getCardName());
        assertEquals("This is a supporter card", copycat.getTrainerCardDescription());
    }
}
