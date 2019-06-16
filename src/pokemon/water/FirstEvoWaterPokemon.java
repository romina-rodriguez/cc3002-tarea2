package pokemon.water;

import pokemon.IAbility;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a first evolution water type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class FirstEvoWaterPokemon extends AbstractEvoWaterPokemon {

    /**
     * Creates a new Pokémon.
     *
     * @param name         Pokémon's name.
     * @param number       Pokémon's number.
     * @param hp           Pokémon's hit points.
     * @param abilityList   Pokémon's requirements.
     * @param energyList   Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    public FirstEvoWaterPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList, int preEvolution) {
        super(name, number, hp, abilityList, energyList, preEvolution);
    }
}
