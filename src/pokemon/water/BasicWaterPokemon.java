package pokemon.water;

import pokemon.IAttack;
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
     * @param attackList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public BasicWaterPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                             ArrayList<IEnergy> energyList) {
        super(name, number, hp, attackList, energyList);
    }
}