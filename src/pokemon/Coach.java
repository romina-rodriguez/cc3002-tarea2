package pokemon;

import java.util.List;

/**
 * Class for the coach that plays the card game. This contains the methods to access the coach's properties, like
 * it's active Pokémon and list of Pokémon available to fight.
 *
 *  @author Romina Rodríguez
 */

public class Coach {

    private IPokemon activePokemon;
    private List<IPokemon> pokemonList;

    /**
     * Creates a new coach.
     *
     * @param activePokemon Pokémon currently fighting
     * @param pokemonList list of Pokémon available to fight
     */
    public Coach(IPokemon activePokemon, List<IPokemon> pokemonList){
        this.activePokemon = activePokemon;
        this.pokemonList = pokemonList;
    }

    //region Properties
    /**
     * Getter for the Pokémon that's currently fighting.
     *
     * @return coach's active Pokémon.
     */
    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    /**
     * Getter for the list of available Pokémon to play.
     *
     * @return coach's list of available Pokémon.
     */
    public List<IPokemon> getPokemonList() {
        return pokemonList;
    }
    //endregion

}
