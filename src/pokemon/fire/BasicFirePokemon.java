package pokemon.fire;

import pokemon.IAbility;
import pokemon.IBasicPokemon;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a basic fire type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class BasicFirePokemon extends AbstractFirePokemon implements IBasicPokemon {

    /**
     * Creates a new fire Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param abilityList  Pokémon's abilites.
     * @param energyList Pokémon's energies.
     */
    public BasicFirePokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                            ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
    }
}