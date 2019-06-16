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

import static org.junit.Assert.*;

/**
 * Tests set for the Trainer class.
 *
 * @author Romina Rodriguez
 */
public class TrainerTest {

    private Trainer trainer, otherTrainer;
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
        trainer = new Trainer("Misty", null,
                new ArrayList<>(Arrays.asList()), new ArrayList<>(),
                new ArrayList<>(Arrays.asList(squirtle, waterEnergy)),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(squirtle)));
        otherTrainer = new Trainer("Mina", squirtle,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Misty", trainer.getTrainersName());
        trainer.setActivePokemon(bulbasaur);
        assertEquals(bulbasaur, trainer.getActivePokemon());
        assertEquals(new ArrayList<>(Arrays.asList()), trainer.getPokemonBench());
        assertEquals(new ArrayList<>(Arrays.asList()), trainer.getHand());
        assertEquals(new ArrayList<>(Arrays.asList()), trainer.getDiscardPile());
    }

    @Test
    public void discardTest() {
        trainer.discard(pikachu);
        assertEquals(new ArrayList<>(Arrays.asList(pikachu)), trainer.getDiscardPile());
    }

    @Test
    public void addToBenchTest() {
        trainer.addToBench(pikachu);
        assertTrue(trainer.getPokemonBench().size() < 5);
        assertEquals(pikachu, trainer.getPokemonBench().get(0));
    }

    @Test
    public void setActivePokemonTest(){
        trainer.setActivePokemon(bulbasaur);
        assertEquals(bulbasaur, trainer.getActivePokemon());
    }

    @Test
    public void selectPokemonTest() {
        trainer.addToBench(pikachu);
        trainer.setActivePokemon(bulbasaur);
        assertEquals(trainer.selectPokemon(0), pikachu);
        assertEquals(trainer.selectPokemon(-1), bulbasaur);
    }

    @Test
    public void playTest() {
        trainer.play(bulbasaur);
        assertEquals(bulbasaur, trainer.getActivePokemon());
    }

    @Test
    public void attackOpponentTest() {
        trainer.setActivePokemon(bulbasaur);
        trainer.attackOpponent(0, otherTrainer);
        assertEquals(otherTrainer.getActivePokemon().getHP(), 20);
    }
}
