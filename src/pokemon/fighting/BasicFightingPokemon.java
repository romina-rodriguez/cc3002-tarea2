package pokemon.fighting;

import pokemon.IAttack;
import pokemon.IBasicPokemon;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a basic fighting type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class BasicFightingPokemon extends AbstractFightingPokemon implements IBasicPokemon {
    /**
     * Creates a new fighting Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public BasicFightingPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                                ArrayList<IEnergy> energyList) {
        super(name, number, hp, attackList, energyList);
    }
}
