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
    private ArrayList<IPokemon> pokemonBench = new ArrayList<>(5); //max 5 different pokemon.
    private ArrayList<ICard> deck = new ArrayList<>(60);
    private ArrayList<ICard> discardPile;
    private ArrayList<ICard> priceCards= new ArrayList<>(6);

    /**
     * Creates a new trainer.
     *
     * @param name Name of the trainer
     * @param activePokemon Pokémon currently fighting
     * @param pokemonBench list of Pokémon available to fight
     * @param deck list of available cards to use (energies and Pokémon)
     */
    public Trainer(String name, IPokemon activePokemon, ArrayList<IPokemon> pokemonBench, ArrayList<ICard> deck,
                   ArrayList<ICard> discardPile, ArrayList<ICard> priceCards){
        this.name = name;
        this.activePokemon = activePokemon;
        this.pokemonBench = pokemonBench;
        this.deck = deck;
        this.discardPile = discardPile;
        this.priceCards = priceCards;
    }

    /**
     * Trainer uses a card to play.
     */
    public void useCardFromDeck(){
        ICard selectedCard = deck.get(0);
        selectedCard.useCard(this);
        deck.remove(selectedCard);
    }

    /**
     * Selects an attack from its active Pokémon and uses it to hurt its opponent's current active Pokémon.
     *
     * @param other Target of the attack.
     * @param index Index of the attack to be selected.
     */
    public void selectAttackAndAttackOpponent(int index, IPokemon other){
        activePokemon.selectAttack(index);
        activePokemon.attack(other);
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
     * Getter for the Pokémon that's currently fighting.
     *
     * @return trainer's active Pokémon.
     */
    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    /**
     * Setter for the trainer's active Pokémon.
     *
     * @param pokemon trainer's new active Pokémon.
     */
    public void setActivePokemon(IPokemon pokemon){
        this.activePokemon = pokemon;
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
     * Getter for the list of available cards.
     *
     * @return trainer's deck.
     */
    //public ArrayList<ICard> getDeck() {
     //   return deck;
    //}

    /**
     * Getter for the list of discarded cards.
     *
     * @return trainer's discarded pile.
     */
    public ArrayList<ICard> getDiscardPile() {
        return discardPile;
    }
    //endregion

}
