package pokemon.psychic;

import pokemon.IAttack;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a first evolution psychic type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class SecondEvoPsychicPokemon extends AbstractEvoPsychicPokemon {

    /**
     * Creates a new Pokémon.
     *
     * @param name         Pokémon's name.
     * @param number       Pokémon's number.
     * @param hp           Pokémon's hit points.
     * @param attackList   Pokémon's attacks.
     * @param energyList   Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    protected SecondEvoPsychicPokemon(String name, int number, int hp, ArrayList<IAttack> attackList, ArrayList<IEnergy> energyList, int preEvolution) {
        super(name, number, hp, attackList, energyList, preEvolution);
    }
}
