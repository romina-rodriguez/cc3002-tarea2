package pokemon.requirements;

import org.junit.Before;
import org.junit.Test;
import pokemon.*;
import pokemon.grass.*;
import pokemon.psychic.BasicPsychicPokemon;
import pokemon.psychic.FirstEvoPsychicPokemon;
import pokemon.psychic.PsychicAttack;
import pokemon.psychic.PsychicEnergy;
import pokemon.water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the ProfessorJuniper class.
 *
 * @author Romina Rodriguez
 */
public class ProfessorJuniperTest {


    private ProfessorJuniper prof;
    private ArrayList<IEnergy> abilityCost;
    private Trainer trainer;
    private IEvoPokemon venusaur, ivysaur;
    private IPokemon squirtle;
    private GrassEnergy grassEnergy;
    private PsychicAttack psychicAttack;
    private PsychicEnergy psychicEnergy;
    private GrassAttack grassAttack;
    private IPokemon
            bulbasaur,
            abra;
    private IEvoPokemon kadabra;

    @Before
    public void setUp() {
        prof = new ProfessorJuniper("Professor Juniper", "This is a Professor Juniper card");
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        psychicAttack = new PsychicAttack( "Calm mind", 30, "This is a psychic attack",
                new ArrayList<>(Arrays.asList(psychicEnergy)));
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        ivysaur = new FirstEvoGrassPokemon("Ivysaur", 2, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)), 1);
        venusaur = new SecondEvoGrassPokemon("Venusaur", 3, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList(grassEnergy)), 2);
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(grassEnergy)));
        kadabra = new FirstEvoPsychicPokemon("Kadabra", 64, 100,
                new ArrayList<>(Arrays.asList(psychicAttack)),
                new ArrayList<>(Arrays.asList()), 63);
        abra = new BasicPsychicPokemon("Abra", 63, 100,
                new ArrayList<>(Arrays.asList(psychicAttack)),
                new ArrayList<>(Arrays.asList()));
        trainer = new Trainer("Misty", null,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(Arrays.asList(squirtle)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Professor Juniper", prof.getCardName());
        assertEquals("This is a Professor Juniper card", prof.getTrainerCardDescription());
    }

    @Test
    public void useCardTest() {
        trainer.setDeck(new ArrayList<>(Arrays.asList(abra, kadabra, bulbasaur,
                psychicEnergy, venusaur, ivysaur, grassEnergy)));
        prof.useCard(trainer);
        ArrayList<ICard> newHand = new ArrayList<>(Arrays.asList(abra, kadabra, bulbasaur,
                psychicEnergy, venusaur, ivysaur, grassEnergy));
        assertTrue(trainer.getHand().containsAll(newHand));
    }
}