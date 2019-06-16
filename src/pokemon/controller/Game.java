package pokemon.controller;

import pokemon.*;
import pokemon.trainercards.AbstractStadiumCard;
import pokemon.trainercards.AbstractSupporterCard;
import pokemon.trainercards.IStadiumCard;
import pokemon.trainercards.ISupporterCard;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Game logic controller class.
 *
 * @author Romina Rodríguez
 */
public class Game extends Observable implements Observer {

    private Trainer playerOne;
    private Trainer playerTwo;
    private ArrayList<ICard> deck1;
    private ArrayList<ICard> deck2;
    private Trainer currentPlayer;
    private Trainer opponent;
    private int rounds = 0;
    private int cardsPlayed1 = 0;
    private int cardsPlayed2 = 0;
    private boolean gameOver = false;
    private boolean cardToEndTurnPlayed = false;
    private boolean stadiumCardPlayed = false;
    private boolean playerAttacks = false;

    /**
     * Creates a new game.
     *
     * @param playerOne first trainer.
     * @param deck1 its deck.
     * @param playerTwo second trainer.
     * @param deck2 its deck.
     */
    public Game(Trainer playerOne, ArrayList<ICard> deck1, Trainer playerTwo, ArrayList<ICard> deck2) {
        this.playerOne = playerOne;
        this.deck1 = deck1;
        playerOne.setDeck(deck1);
        this.playerTwo = playerTwo;
        this.deck2 = deck2;
        playerTwo.setDeck(deck2);
        currentPlayer = playerOne;
        opponent = playerTwo;
    }

    //region properties
    /**
     * Getter for the amount of rounds played in a game.
     * @return the amount of rounds.
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * Getter for the current player.
     * @return current player
     */
    public Trainer getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Getter for the amount cards played from deck1.
     * @return the amount cards.
     */
    public int getCardsPlayed1() {
        return cardsPlayed1;
    }

    /**
     * Getter for the amount cards played from deck2.
     * @return the amount cards.
     */
    public int getCardsPlayed2() {
        return cardsPlayed2;
    }

    /**
     * Getter for the boolean StadiumCardPlayed.
     * @return boolean.
     */
    public boolean getStadiumCardPlayed() {
        return stadiumCardPlayed;
    }

    /**
     * Getter for the boolean CardToEndTurnPlayed.
     * @return boolean.
     */
    public boolean getCardToEndTurnPlayed() {
        return cardToEndTurnPlayed;
    }
    //end region

    /**
     * Method to play Pokémon TCG.
     */
    public void playGame() {
        playRounds();
    }

    /**
     * Method that executes the rounds the player's play while the game isn't over.
     * It also keeps track of the amount of rounds played.
     */
    public void playRounds() {
        while(!gameOver){
            playRound();
            rounds++;
            switchCurrentPlayer();
        }
    }

    /**
     * Player sees both its pokemon currently in game and its opponents.
     */
    public ArrayList<IPokemon> seePokemon() {
        IPokemon myActivePokemon = currentPlayer.getActivePokemon();
        ArrayList<IPokemon> myBench = currentPlayer.getPokemonBench();
        IPokemon opponentsActivePokemon = opponent.getActivePokemon();
        ArrayList<IPokemon> opponentsPokemonBench =opponent.getPokemonBench();
        ArrayList<IPokemon> allPokemon = new ArrayList<>();
        allPokemon.add(myActivePokemon);
        allPokemon.addAll(myBench);
        allPokemon.add(opponentsActivePokemon);
        allPokemon.addAll(opponentsPokemonBench);
        return allPokemon;
    }

    /**
     * Player sees the cards in its hand.
     */
    public ArrayList<ICard> seeHand() {
        return currentPlayer.getHand();
    }

    /**
     * Player chooses a card to play from its hand.
     * @param index index of chosen card.
     */
    public void playCard(int index) {
        ICard cardToPlay = currentPlayer.getHand().get(index);
        currentPlayer.play(cardToPlay);
        update(this, cardToPlay);
    }

    /**
     * Player uses an ability from its active pokemon.
     * @param index index of ability chosen.
     */
    public void useAbility(int index) {
        currentPlayer.getActivePokemon().selectAbility(index);
        IAbility ability = currentPlayer.getActivePokemon().getSelectedAbility();
        if (ability instanceof IAttack) {
            playerAttacks = true;
        }
        ability.useAbility(currentPlayer);
    }

    /**
     * Once a player's turn is over, while the game is still ongoing, the other's player's turn starts;
     */
    public void switchCurrentPlayer() {
        if (currentPlayer == playerOne) {
            opponent = playerOne;
            currentPlayer = playerTwo;
        }
        else if (currentPlayer == playerTwo ){
            opponent = playerTwo;
            currentPlayer = playerOne;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof IEnergy || arg instanceof ISupporterCard) {
            cardToEndTurnPlayed = true;
        }
        else if (arg instanceof IStadiumCard) {
            stadiumCardPlayed = true;
        }
    }

    /**
     * Method that defines the logic of a player's turn.
     */
    public ICard getCardFromDeck() {
        if(currentPlayer == playerOne){
            ICard cardFromDeck = deck1.get(0);
            return cardFromDeck;
        }
        else{
            ICard cardFromDeck = deck2.get(0);
            return cardFromDeck;
        }
    }

    public void addCardToHand() {
        ICard cardFromDeck = getCardFromDeck();
        currentPlayer.getHand().add(cardFromDeck);
    }

    public void playRound() {
        boolean roundIsOver = false;
        addCardToHand();
        if(currentPlayer == playerOne){
            cardsPlayed1++;
        }
        else if(currentPlayer == playerTwo){
            cardsPlayed2++;
        }
        if(cardsPlayed1 == 60 || cardsPlayed2 == 60) { //we don't know yet the condition for a player to win
            gameOver = true;
        }
        while(!roundIsOver) {
            //player sees the cards in his hand
            seeHand();
            //player plays a card
            ICard cardToPlay = currentPlayer.getHand().get(0);
            currentPlayer.play(cardToPlay);
            update(this, cardToPlay);
            //their turn may now end, depending on the card played
            if(cardToEndTurnPlayed || playerAttacks) {
                roundIsOver = true;
            }
            //player sees the pokemon being used
            seePokemon();
            //player uses an ability from its active pokemon
            useAbility(0);
            //player finishes their turn
            roundIsOver = true;
            switchCurrentPlayer();
        }
    }
}

