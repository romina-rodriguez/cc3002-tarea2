package pokemon.controller;

import org.junit.Before;
import org.junit.Test;
import pokemon.ICard;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.electric.BasicElectricPokemon;
import pokemon.grass.BasicGrassPokemon;
import pokemon.grass.GrassAttack;
import pokemon.grass.GrassEnergy;
import pokemon.requirements.TrainingCenter;
import pokemon.trainercards.IStadiumCard;
import pokemon.water.BasicWaterPokemon;
import pokemon.water.WaterAttack;
import pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the Game class.
 *
 * @author Romina Rodriguez
 */
public class GameTest {

    private Game game;
    private ArrayList<ICard> deck1;
    private ArrayList<ICard> deck2;
    private Trainer playerOne, playerTwo;
    private IPokemon
            bulbasaur,
            pikachu,
            squirtle;
    private GrassEnergy grassEnergy;
    private IEnergy waterEnergy;
    private GrassAttack grassAttack;
    private WaterAttack waterAttack;
    private IStadiumCard trainingCenter;

    @Before
    public void setUp () {
        trainingCenter = new TrainingCenter("Training Center", "This is a training center");
        grassAttack = new GrassAttack("Growl", 40, "This is a grass attack",
                new ArrayList<>(Arrays.asList(grassEnergy)));
        waterAttack = new WaterAttack("Bubble", 40, "This is a water attack",
                new ArrayList<>(Arrays.asList()));
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 1, 100,
                new ArrayList<>(Arrays.asList(grassAttack)),
                new ArrayList<>(Arrays.asList()));
        squirtle = new BasicWaterPokemon("Squirtle", 7, 100,
                new ArrayList<>(Arrays.asList(waterAttack)),
                new ArrayList<>(Arrays.asList(waterEnergy)));
        pikachu = new BasicElectricPokemon("Pikachu", 25, 100,
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList()));
        deck1 = new ArrayList<>(Arrays.asList(squirtle,waterEnergy, trainingCenter));
        deck2 = new ArrayList<>(Arrays.asList(bulbasaur,grassEnergy));
        playerOne = new Trainer("Misty", null,
                new ArrayList<>(), new ArrayList<>(), deck1, new ArrayList<>(), new ArrayList<>());
        playerTwo = new Trainer("Brock", bulbasaur,
                new ArrayList<>(), new ArrayList<ICard>(), deck2, new ArrayList<>(), new ArrayList<>());
        game = new Game(playerOne, deck1, playerTwo, deck2);
    }

    @Test
    public void constructorTest() {
        assertEquals(playerOne, game.getCurrentPlayer());
        assertEquals(0, game.getRounds());
        assertEquals(0, game.getCardsPlayed1());
        assertEquals(0, game.getCardsPlayed2());
    }

    @Test
    public void gameLogic() {
        game.addCardToHand();
        assertEquals(squirtle, game.getCardFromDeck());
        assertEquals(new ArrayList<>(Arrays.asList(squirtle)), playerOne.getHand());
        //after seeing their hand, playerOne chooses a card to use.
        assertNull(playerOne.getActivePokemon());
        game.playCard(0);
        assertEquals(playerOne.getActivePokemon(), squirtle);
        //player decides to attack
        game.useAbility(0);
        assertEquals(waterAttack, playerOne.getActivePokemon().getSelectedAbility());
        squirtle.attack(playerTwo);
        assertEquals(90, playerTwo.getActivePokemon().getHP());
        game.addCardToHand();
        game.addCardToHand();
        game.playCard(1);
        assertEquals(playerOne.getActivePokemon().getHP(), 60);
        game.update(game, trainingCenter);
        assertTrue(game.getStadiumCardPlayed());
    }

    @Test
    public void switchCurrentPlayer() {
        game.switchCurrentPlayer();
        assertEquals(playerTwo, game.getCurrentPlayer());
    }

}