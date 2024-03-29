package pokemon;

import org.junit.Before;
import org.junit.Test;
import pokemon.electric.ElectricAttack;
import pokemon.electric.ElectricEnergy;
import pokemon.electric.BasicElectricPokemon;
import pokemon.grass.BasicGrassPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.GrassEnergy;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests set for the methods implemented in AbstractPokemon and AbstractEnergy.
 *
 * @author Romina Rodriguez
 */
public class pokemonTest {

    private Trainer trainer, otherTrainer;
    private IPokemon
            pikachu,
            bulbasaur,
            squirtle;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private GrassAttack grassAttack;
    private ElectricEnergy electricEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;

    @Before
    public void setUp() {
        electricAttack = new ElectricAttack( "Thundershock", 50, "This is an electric attack",
                new ArrayList<>(Arrays.asList(electricEnergy)));
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(electricAttack)),
                new ArrayList<>(Arrays.asList(electricEnergy)));
        trainer = new Trainer("Misty", null,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(squirtle, waterEnergy)),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
        otherTrainer = new Trainer("Mina", squirtle,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void useEnergyCardTest() {
        trainer.setActivePokemon(bulbasaur);
        assertEquals(bulbasaur, trainer.getActivePokemon());
        trainer.getActivePokemon().getEnergies().add(waterEnergy);
        assertEquals(new ArrayList<>(Arrays.asList(grassEnergy, waterEnergy)), trainer.getActivePokemon().getEnergies());
    }

    @Test
    public void usePokemonCardTest() {
        trainer.setActivePokemon(bulbasaur);
        assertEquals(bulbasaur, trainer.getActivePokemon());
        assertFalse(trainer.getPokemonBench().size() > 5);
        trainer.getPokemonBench().add(pikachu);
        assertEquals(new ArrayList<>(Arrays.asList(pikachu)), trainer.getPokemonBench());
        pikachu.selectAbility(0);
        pikachu.attack(otherTrainer);
        assertTrue(squirtle.isDead());
        assertFalse(pikachu.isDead());
    }

    @Test
    public void isDeadTest(){
        pikachu.selectAbility(0);
        pikachu.attack(otherTrainer);
        assertTrue(squirtle.isDead());
        assertFalse(pikachu.isDead());
    }
}
