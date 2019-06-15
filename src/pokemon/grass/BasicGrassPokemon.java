package pokemon.grass;

import pokemon.IAbility;
import pokemon.IBasicPokemon;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a grass type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class BasicGrassPokemon extends AbstractGrassPokemon implements IBasicPokemon {

    /**
     * Creates a new grass Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param abilityList  Pokémon's abilities.
     * @param energyList Pokémon's energies.
     */
    public BasicGrassPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                             ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
    }
}
