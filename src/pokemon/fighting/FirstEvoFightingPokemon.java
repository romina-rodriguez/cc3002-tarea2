package pokemon.fighting;

import pokemon.IAttack;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a first evolution fighting type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class FirstEvoFightingPokemon extends AbstractEvoFightingPokemon {

    /**
     * Creates a new Evolved Fighting Electric Pokémon.
     *
     * @param name         Pokémon's name.
     * @param number       Pokémon's number.
     * @param hp           Pokémon's hit points.
     * @param attackList   Pokémon's attacks.
     * @param energyList   Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    protected FirstEvoFightingPokemon(String name, int number, int hp, ArrayList<IAttack> attackList, ArrayList<IEnergy> energyList, int preEvolution) {
        super(name, number, hp, attackList, energyList, preEvolution);
    }
}
