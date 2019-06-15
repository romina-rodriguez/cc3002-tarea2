package pokemon.water;

import pokemon.IAbility;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a basic water type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class BasicWaterPokemon extends AbstractWaterPokemon {

    /**
     * Creates a new water Pokémon.
     *
     * @param name Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's abilities.
     * @param energyList Pokémon's energies.
     */
    public BasicWaterPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                             ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
    }
}