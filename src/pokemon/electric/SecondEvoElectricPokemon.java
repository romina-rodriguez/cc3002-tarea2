package pokemon.electric;

import pokemon.IAttack;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a second evolution electric type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class SecondEvoElectricPokemon extends AbstractEvoElectricPokemon {

    /**
     * Creates a new Electric Pokémon.
     *
     * @param name         Pokémon's name.
     * @param number       Pokémon's number.
     * @param hp           Pokémon's hit points.
     * @param attackList   Pokémon's attacks.
     * @param energyList   Pokémon's energies.
     * @param preEvolution
     */
    protected SecondEvoElectricPokemon(String name, int number, int hp, ArrayList<IAttack> attackList, ArrayList<IEnergy> energyList, int preEvolution) {
        super(name, number, hp, attackList, energyList, preEvolution);
    }
}
