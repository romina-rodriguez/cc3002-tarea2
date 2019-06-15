package pokemon.grass;

import org.junit.Before;
import org.junit.Test;
import pokemon.IEvoPokemon;
import pokemon.IPokemon;
import pokemon.fire.BasicFirePokemon;
import pokemon.fire.FireAttack;
import pokemon.fire.FireEnergy;
import pokemon.psychic.BasicPsychicPokemon;
import pokemon.psychic.PsychicAttack;
import pokemon.psychic.PsychicEnergy;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the FirstEvoGrassPokemon class.
 *
 * @author Romina Rodríguez
 */
public class FirstEvoGrassPokemonTest {

    private IPokemon
            charmander,
            mewtwo;
    private IEvoPokemon ivysaur;
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
        ivysaur = new FirstEvoGrassPokemon("Ivysaur", 2, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)), 1);
        charmander = new BasicFirePokemon("Charmander",4,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)));

    }

    @Test
    public void constructorTest() {
        assertEquals("Ivysaur", ivysaur.getName());
        assertEquals(100, ivysaur.getHP());
        assertEquals(1, ivysaur.getAbilities().size());
        assertEquals(grassAttack, ivysaur.getAbilities().get(0));
        assertNull(ivysaur.getSelectedAbility());
        assertEquals(1, ivysaur.getEnergies().size());
        assertEquals(grassEnergy, ivysaur.getEnergies().get(0));
        assertEquals("Ivysaur", ivysaur.getCardName());
        assertEquals(2, ivysaur.getNumber());
        assertEquals(1, ivysaur.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        ivysaur.selectAbility(0);
        assertEquals(grassAttack, ivysaur.getSelectedAbility());
    }

    @Test
    public void attackTest() {
        ivysaur.selectAbility(0);
        ivysaur.attack(mewtwo);
        assertEquals(60, mewtwo.getHP());
        ivysaur.attack(mewtwo);
        ivysaur.attack(mewtwo);
        assertEquals(0, mewtwo.getHP());
    }

    @Test
    public void receiveFireAttack() {
        assertEquals(100, ivysaur.getHP());
        ivysaur.receiveFireAttack(fireAttack);
        assertEquals(20, ivysaur.getHP());
    }

    @Test
    public void receiveWaterAttack() {
        assertEquals(100, ivysaur.getHP());
        ivysaur.receiveWaterAttack(waterAttack);
        assertEquals(90, ivysaur.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, ivysaur.getHP());
        ivysaur.receivePsychicAttack(psychicAttack);
        assertEquals(70, ivysaur.getHP());
    }
}