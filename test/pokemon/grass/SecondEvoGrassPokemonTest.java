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
 * Tests set for the SecondEvoGrassPokemon class.
 *
 * @author Romina Rodríguez
 */
public class SecondEvoGrassPokemonTest {

    private IPokemon
            charmander,
            mewtwo;
    private IEvoPokemon venusaur;
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
        venusaur = new SecondEvoGrassPokemon("Venusaur", 3, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)), 2);
        charmander = new BasicFirePokemon("Charmander",4,100,
                new ArrayList<>(Arrays.asList(fireAttack)),
                new ArrayList<>(Arrays.asList(fireEnergy)));

    }

    @Test
    public void constructorTest() {
        assertEquals("Venusaur", venusaur.getName());
        assertEquals(100, venusaur.getHP());
        assertEquals(1, venusaur.getAttacks().size());
        assertEquals(grassAttack, venusaur.getAttacks().get(0));
        assertNull(venusaur.getSelectedAttack());
        assertEquals(1, venusaur.getEnergies().size());
        assertEquals(grassEnergy, venusaur.getEnergies().get(0));
        assertEquals("Venusaur", venusaur.getCardName());
        assertEquals(3, venusaur.getNumber());
        assertEquals(2, venusaur.getPreEvolution());
    }

    @Test
    public void selectAttackTest() {
        venusaur.selectAttack(0);
        assertEquals(grassAttack, venusaur.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        venusaur.selectAttack(0);
        venusaur.attack(mewtwo);
        assertEquals(60, mewtwo.getHP());
        venusaur.attack(mewtwo);
        venusaur.attack(mewtwo);
        assertEquals(0, mewtwo.getHP());
    }

    @Test
    public void receiveFireAttack() {
        assertEquals(100, venusaur.getHP());
        venusaur.receiveFireAttack(fireAttack);
        assertEquals(20, venusaur.getHP());
    }

    @Test
    public void receiveWaterAttack() {
        assertEquals(100, venusaur.getHP());
        venusaur.receiveWaterAttack(waterAttack);
        assertEquals(90, venusaur.getHP());
    }

    @Test
    public void receiveAttack() {
        assertEquals(100, venusaur.getHP());
        venusaur.receivePsychicAttack(psychicAttack);
        assertEquals(70, venusaur.getHP());
    }
}