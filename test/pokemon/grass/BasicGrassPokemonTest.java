package pokemon.grass;

import org.junit.Before;
import org.junit.Test;
import pokemon.IPokemon;
import pokemon.fire.FireAttack;
import pokemon.fire.BasicFirePokemon;
import pokemon.fire.FireEnergy;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;
import pokemon.psychic.BasicPsychicPokemon;
import pokemon.psychic.PsychicAttack;
import pokemon.psychic.PsychicEnergy;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests set for the BasicGrassPokemon class.
 *
 * @author Romina Rodríguez
 */
public class BasicGrassPokemonTest {

    private IPokemon
            bulbasaur,
            charmander,
            mewtwo;
    private WaterAttack waterAttack;
    private PsychicAttack psychicAttack;
    private FireAttack fireAttack;
    private FireEnergy fireEnergy;
    private PsychicEnergy psychicEnergy;
    private WaterEnergy waterEnergy;
    private GrassEnergy grassEnergy;
    private GrassAttack grassAttack;

    @Before
    public void setUp() {
        psychicAttack = new PsychicAttack( "Calm mind", 30, "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList(waterEnergy)));
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        fireAttack = new FireAttack("Ember", 40, "This is a fire attack",
                new ArrayList<>(Arrays.asList(fireEnergy)));
        mewtwo = new BasicPsychicPokemon("Mewtwo", 150,100,
                new ArrayList<>(Arrays.asList(psychicAttack)),
                new ArrayList<>(Arrays.asList(psychicEnergy)));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        charmander = new BasicFirePokemon("Charmander",4,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)));

    }

    @Test
    public void constructorTest() {
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals(100, bulbasaur.getHP());
        assertEquals(1, bulbasaur.getAbilities().size());
        assertEquals(grassAttack, bulbasaur.getAbilities().get(0));
        assertNull(bulbasaur.getSelectedAbility());
        assertEquals(1, bulbasaur.getEnergies().size());
        assertEquals(grassEnergy, bulbasaur.getEnergies().get(0));
        assertEquals("Bulbasaur", bulbasaur.getCardName());
        assertEquals(1, bulbasaur.getNumber());
    }

    @Test
    public void selectAttackTest() {
        bulbasaur.selectAbility(0);
        assertEquals(grassAttack, bulbasaur.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        bulbasaur.selectAbility(0);
        bulbasaur.attack(mewtwo);
        assertEquals(60, mewtwo.getHP());
        bulbasaur.attack(mewtwo);
        bulbasaur.attack(mewtwo);
        assertEquals(0, mewtwo.getHP());
    }

    @Test
    public void receiveFireAttack() {
        assertEquals(100, bulbasaur.getHP());
        bulbasaur.receiveFireAttack(fireAttack);
        assertEquals(20, bulbasaur.getHP());
    }

    @Test
    public void receiveWaterAttack() {
        assertEquals(100, bulbasaur.getHP());
        bulbasaur.receiveWaterAttack(waterAttack);
        assertEquals(90, bulbasaur.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, bulbasaur.getHP());
        bulbasaur.receivePsychicAttack(psychicAttack);
        assertEquals(70, bulbasaur.getHP());
    }

}
