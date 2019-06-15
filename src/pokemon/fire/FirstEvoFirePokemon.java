package pokemon.fire;

import pokemon.IAbility;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a second evolution electric type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class FirstEvoFirePokemon extends AbstractEvoFirePokemon {

    /**
     * Creates a new Pokémon.
     *
     * @param name         Pokémon's name.
     * @param number       Pokémon's number.
     * @param hp           Pokémon's hit points.
     * @param abilityList   Pokémon's abilities.
     * @param energyList   Pokémon's energies.
     * @param preEvolution Pokémo's pre-evolution.
     */
    protected FirstEvoFirePokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList, int preEvolution) {
        super(name, number, hp, abilityList, energyList, preEvolution);
    }
}
