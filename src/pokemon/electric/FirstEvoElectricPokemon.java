package pokemon.electric;

import pokemon.IAbility;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a first evolution electric type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class FirstEvoElectricPokemon extends AbstractEvoElectricPokemon {

    /**
     * Creates a new Electric Pokémon.
     *
     * @param name         Pokémon's name.
     * @param number       Pokémon's number.
     * @param hp           Pokémon's hit points.
     * @param abilityList   Pokémon's abilities.
     * @param energyList   Pokémon's energies.
     * @param preEvolution
     */
    protected FirstEvoElectricPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList, int preEvolution) {
        super(name, number, hp, abilityList, energyList, preEvolution);
    }
}
