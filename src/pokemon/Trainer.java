package pokemon;

import java.util.List;

/**
 * Class for the trainer that plays the card game. This contains the methods to access the trainer's properties, like
 * it's active Pokémon and list of Pokémon available to fight.
 *
 *  @author Romina Rodríguez
 */

public class Trainer {

    private String name;
    private IPokemon activePokemon;
    private List<IPokemon> pokemonBench;

    /**
     * Creates a new trainer.
     *
     * @param name Name of the trainer
     * @param activePokemon Pokémon currently fighting
     * @param pokemonBench list of Pokémon available to fight
     */
    public Trainer(String name, IPokemon activePokemon, List<IPokemon> pokemonBench){
        this.name = name;
        this.activePokemon = activePokemon;
        this.pokemonBench = pokemonBench;
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
     * Getter for the list of available Pokémon.
     *
     * @return trainer's list of available Pokémon.
     */
    public List<IPokemon> getPokemonBench() {
        return pokemonBench;
    }
    //endregion

}
