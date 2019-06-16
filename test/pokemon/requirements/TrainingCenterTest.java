package pokemon.requirements;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEnergy;
import pokemon.IEvoPokemon;
import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.grass.FirstEvoGrassPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.GrassEnergy;
import pokemon.grass.SecondEvoGrassPokemon;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the TrainingCenter class.
 *
 * @author Romina Rodriguez
 */
public class TrainingCenterTest {

    private TrainingCenter trainingCenter;
    private ArrayList<IEnergy> abilityCost;
    private Trainer trainer;
    private IEvoPokemon venusaur, ivysaur;
    private IPokemon squirtle;
    private GrassEnergy grassEnergy;
    private GrassAttack grassAttack;

    @Before
    public void setUp() {
        trainingCenter = new TrainingCenter("Training Center", "This is a training center");
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        ivysaur = new FirstEvoGrassPokemon("Ivysaur", 2, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)), 1);
        venusaur = new SecondEvoGrassPokemon("Venusaur", 3, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)), 2);
        trainer = new Trainer("Misty", ivysaur,
                new ArrayList<>(Arrays.asList(venusaur, squirtle)),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Training Center", trainingCenter.getCardName());
        assertEquals("This is a training center", trainingCenter.getTrainerCardDescription());
    }

    @Test
    public void useCardTest() {
        trainingCenter.useCard(trainer);
        assertEquals(150, trainer.getActivePokemon().getHP());
        assertEquals(150, trainer.getPokemonBench().get(0).getHP());
        assertEquals(100, trainer.getPokemonBench().get(1).getHP());
    }
}