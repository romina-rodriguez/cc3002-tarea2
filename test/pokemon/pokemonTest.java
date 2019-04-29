package pokemon;

import org.junit.Before;
import org.junit.Test;
import pokemon.electric.ElectricAttack;
import pokemon.electric.ElectricEnergy;
import pokemon.electric.ElectricPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.GrassEnergy;
import pokemon.grass.GrassPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.water.WaterPokemon;

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

    private Trainer trainer;
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
        bulbasaur = new GrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        squirtle = new WaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
        pikachu = new ElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList(electricAttack)),
                new ArrayList<>(Arrays.asList(electricEnergy)));
        trainer = new Trainer("Misty", null,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(squirtle, waterEnergy)));
    }

    @Test
    public void useEnergyCardTest() {
        trainer.setActivePokemon(bulbasaur);
        assertEquals(bulbasaur, trainer.getActivePokemon());
        trainer.getActivePokemon().getEnergies().add(waterEnergy);
        assertEquals(new ArrayList<>(Arrays.asList(grassEnergy, waterEnergy)), trainer.getActivePokemon().getEnergies());
    }

    @Test
    public void addToBenchTest() {
        trainer.getPokemonBench().add(pikachu);
        assertEquals(new ArrayList<>(Arrays.asList(pikachu)), trainer.getPokemonBench());
    }

    @Test
    public void promoteToActiveTest(){
        trainer.setActivePokemon(bulbasaur);
        assertEquals(bulbasaur, trainer.getActivePokemon());
    }

    @Test
    public void isDeadTest(){
        pikachu.selectAttack(0);
        pikachu.attack(squirtle);
        assertTrue(squirtle.isDead());
        assertFalse(pikachu.isDead());
    }
}
