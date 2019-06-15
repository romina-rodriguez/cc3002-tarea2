package pokemon;

import org.junit.Before;
import org.junit.Test;
import pokemon.electric.BasicElectricPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.GrassEnergy;
import pokemon.grass.BasicGrassPokemon;
import pokemon.water.BasicWaterPokemon;
import pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
/**
 * Tests set for the Trainer class.
 *
 * @author Romina Rodriguez
 */
public class TrainerTest {

    private Trainer trainer;
    private IPokemon
            bulbasaur,
            pikachu,
            squirtle;
    private GrassEnergy grassEnergy;
    private WaterEnergy waterEnergy;
    private GrassAttack grassAttack;

    @Before
    public void setUp() {
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList()));
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        trainer = new Trainer("Misty", bulbasaur,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(squirtle, waterEnergy)),
                new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Misty", trainer.getTrainersName());
        assertEquals(bulbasaur, trainer.getActivePokemon());
        assertEquals(new ArrayList<>(Arrays.asList()), trainer.getPokemonBench());
        assertEquals(new ArrayList<>(Arrays.asList()), trainer.getDiscardPile());
    }

    @Test
    public void selectAttackAndAttackOpponentTest() {
        trainer.getActivePokemon().selectAbility(0);
        assertEquals(grassAttack, trainer.getActivePokemon().getSelectedAbility());
        trainer.getActivePokemon().attack(pikachu); //attacks enemy's active Pokémon
        assertEquals(60, pikachu.getHP());
    }

    @Test
    public void discardTest() {
        trainer.discard(pikachu);
        assertEquals(new ArrayList<>(Arrays.asList(pikachu)), trainer.getDiscardPile());
    }
    /*@Test
    public void useCardFromDeckTest() {
        assertEquals(new ArrayList<>(Arrays.asList(squirtle, waterEnergy)), trainer.getDeck());
        assertEquals(squirtle, trainer.getDeck().get(0));
        squirtle.useCard(trainer);
        trainer.getDeck().remove(squirtle);
        assertEquals(new ArrayList<>(Arrays.asList(waterEnergy)), trainer.getDeck());
        assertEquals(waterEnergy, trainer.getDeck().get(0));
    }*/

}
