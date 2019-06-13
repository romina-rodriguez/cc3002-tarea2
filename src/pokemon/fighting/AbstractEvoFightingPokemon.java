package pokemon.fighting;

import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.IEvoPokemon;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic evolved fighting Pokémon. This class receives all the methods implemented in
 * AbstractFightingPokemon and implements a method to return the pre-evolution of it.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractEvoFightingPokemon extends AbstractFightingPokemon implements IEvoPokemon {

    private int preEvolution;

    /**
     * Creates a new Evolved Fighting Electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    protected AbstractEvoFightingPokemon(String name, int number, int hp, ArrayList<IAttack> attackList, ArrayList<IEnergy> energyList,
                                         int preEvolution) {
        super(name, number, hp, attackList, energyList);
        this.preEvolution = preEvolution;
    }

    //region Properties
    /**
     * Getter for the Evolved Pokémon pre-evolution.
     *
     * @return Pokémon's pre-evolution.
     */
    public int getPreEvolution() {
        return preEvolution;
    }
    //endregion
}
