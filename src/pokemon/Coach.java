package pokemon;

import java.util.List;

public class Coach {

    private IPokemon activePokemon;
    private List<IPokemon> pokemonList;

    public Coach(IPokemon activePokemon, List<IPokemon> pokemonList){
        this.activePokemon = activePokemon;
        this.pokemonList = pokemonList;
    }

    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    public List<IPokemon> getPokemonList() {
        return pokemonList;
    }


}
