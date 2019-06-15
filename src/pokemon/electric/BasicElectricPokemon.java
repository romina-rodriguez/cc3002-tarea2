package pokemon.electric;

import pokemon.IAbility;
import pokemon.IBasicPokemon;
import pokemon.IEnergy;
import java.util.ArrayList;

/**
 * Class that represents a basic electric type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class BasicElectricPokemon extends AbstractElectricPokemon implements IBasicPokemon {

    /**
     * Creates a new Basic Electric Pokémon.
     *
     * @param name Pokémon's name.
     * @param number Pokémon's number.
     * @param hp Pokémon's hit points.
     * @param abilityList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public BasicElectricPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                                ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
    }
}
