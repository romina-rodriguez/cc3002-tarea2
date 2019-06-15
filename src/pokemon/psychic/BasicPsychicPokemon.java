package pokemon.psychic;

import pokemon.IAbility;
import pokemon.IBasicPokemon;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a basic psychic type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class BasicPsychicPokemon extends AbstractPsychicPokemon implements IBasicPokemon {

    /**
     * Creates a new psychic Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param abilityList  Pokémon's abilities.
     * @param energyList Pokémon's energies.
     */
    public BasicPsychicPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                               ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
    }
}