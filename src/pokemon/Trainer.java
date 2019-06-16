package pokemon;

import java.util.ArrayList;

/**
 * Class for the trainer that plays the card game. This contains the methods to access the trainer's properties, like
 * it's name, active Pokémon, list of Pokémon available to fight and deck.
 *
 *  @author Romina Rodríguez
 */
public class Trainer {

    private String name;
    private IPokemon activePokemon;
    private ArrayList<IPokemon> pokemonBench; //max 5 pokemon.
    private ArrayList<ICard> deck; //initial 60
    private ArrayList<ICard> discardPile;
    private ArrayList<ICard> priceCards; //max 6.
    private ArrayList<ICard> hand;

    /**
     * Creates a new trainer.
     *
     * @param name Name of the trainer
     * @param activePokemon Pokémon currently being used
     * @param pokemonBench list of Pokémon available to be used
     * @param hand list of available cards to use
     * @param deck place to take cards from
     * @param discardPile place to discard cards
     * @param priceCards trainer's price cards
     */
    public Trainer(String name, IPokemon activePokemon, ArrayList<IPokemon> pokemonBench, ArrayList<ICard> hand, ArrayList<ICard> deck,
                   ArrayList<ICard> discardPile, ArrayList<ICard> priceCards){
        if(pokemonBench.size() > 5 || deck.size() > 60 || priceCards.size() > 6) {
            System.exit(1);
        }
        this.name = name;
        this.activePokemon = activePokemon;
        this.pokemonBench = pokemonBench;
        this.hand = hand;
        this.deck = deck;
        this.discardPile = discardPile;
        this.priceCards = priceCards;
    }

    /**
     * Setter for the trainer's active Pokémon.
     *
     * @param pokemon trainer's new active Pokémon.
     */
     public void setActivePokemon(IPokemon pokemon){
        this.activePokemon = pokemon;
    }

    //region Properties
    /**
     * Getter for the Trainer's name.
     *
     * @return trainer's name.
     */
    public String getTrainersName() {
        return name;
    }

    /**
     * Getter for the Pokémon that's currently being used.
     *
     * @return trainer's active Pokémon.
     */
    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    /**
     * Getter for the list of available cards in my hand.
     *
     * @return trainer's list of available cards.
     */
    public ArrayList<ICard> getHand() {
        return hand;
    }

    /**
     * Setter for the trainer's deck.
     *
     * @param deck trainer's deck.
     */
    public void setDeck(ArrayList<ICard> deck) {
        this.deck = deck;
    }

    /**
     * Setter for the hand.
     *
     * @param hand trainer's hand.
     */
    public void setHand(ArrayList<ICard> hand) {
        this.hand = hand;
    }
    /**
     * Getter for the list of available Pokémon.
     *
     * @return trainer's list of available Pokémon.
     */
    public ArrayList<IPokemon> getPokemonBench() {
        return pokemonBench;
    }

    /**
     * Getter for the list of discarded cards.
     *
     * @return trainer's discarded pile.
     */
    public ArrayList<ICard> getDiscardPile() {
        return discardPile;
    }

    //endregion

    /**
     * Gets a card from the deck.
     *
     * @return card card chosen.
     */
    public ICard stealCard(){
        ICard card = deck.get(0);
        deck.remove(0);
        return card;
    }

    /**
     * Adds a Pokémon to the trainer's bench if a spot is available.
     *
     * @param pokemon Pokémon card selected.
     */
    public void addToBench(IPokemon pokemon) {
        if(pokemonBench.size() < 5) {
            pokemonBench.add(pokemon);
        }
    }

    /**
     * Trainer uses a card to play.
     */
    public void play(ICard card){
        card.useCard(this);
    }

    /**
     * Selects an attack from its active Pokémon and uses it to hurt its opponent's current active Pokémon.
     *
     * @param other Target of the attack.
     * @param index Index of the attack to be selected.
     */
    public void attackOpponent(int index, Trainer other){
        activePokemon.selectAbility(index);
        activePokemon.attack(other);
    }

    /**
     * Adds a card to de discarded pile.
     *
     * @param card card to be discarded.
     */
    public void discard(ICard card){
        discardPile.add(card);
    }

    /**
     * Once the current active Pokémon dies, another one must be promoted from the bench if available.
     *
     * @param trainer trainer that chose the card.
     */
    private void promoteToActive(Trainer trainer){
        IPokemon newActivePokemon = pokemonBench.get(0);
        trainer.setActivePokemon(newActivePokemon);
    }

    /**
     * Active Pokémon receives an attack.
     *
     * @param attack Received attack.
     */
    protected void receiveAttack(IAttack attack) {
        activePokemon.receiveAttack(attack);
        if(activePokemon.isDead()){
            promoteToActive(this);
            discard(activePokemon);
        }
    }

    /**
     * Selects a Pokémon.
     *
     * @param i index of pokemon, negative for the currently active pokémon.
     * @return pokémon selected.
     */
    public IPokemon selectPokemon(int i) {
        if(i < 0) {
            return activePokemon;
        }
        else {
            return pokemonBench.get(i);
        }
    }
}
