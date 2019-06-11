package pokemon.trainercards;

import org.junit.Before;
import org.junit.Test;
import pokemon.ITrainerCard;

import static org.junit.Assert.assertEquals;

/**
 * Tests set for the ItemCard class.
 *
 * @author Romina Rodríguez
 */
public class ItemCardTest {

    private ITrainerCard
            potion,
            pokedex;
    @Before
    public void setUp() {
        potion = new ItemCard("Potion", "This is an item card");
        pokedex = new ItemCard("Pokédex", "This is an item card" );
    }

    @Test
    public void constructorTest() {
        assertEquals("Potion", potion.getCardName());
        assertEquals("Pokédex", pokedex.getCardName());
        assertEquals("This is an item card", potion.getTrainerCardDescription());
    }
}
