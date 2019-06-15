package pokemon.fighting;

import pokemon.IAbility;
import pokemon.IEnergy;

import java.util.ArrayList;

/**
 * Class that represents a second evolution fighting type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class SecondEvoFightingPokemon extends AbstractEvoFightingPokemon {

    /**
     * Creates a new Evolved Fighting Electric Pokémon.
     *
     * @param name         Pokémon's name.
     * @param number       Pokémon's number.
     * @param hp           Pokémon's hit points.
     * @param abilityList   Pokémon's abilites.
     * @param energyList   Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    protected SecondEvoFightingPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList, int preEvolution) {
        super(name, number, hp, abilityList, energyList, preEvolution);
    }
}
