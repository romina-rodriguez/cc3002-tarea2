package pokemon.grass;

import pokemon.IAbility;
import pokemon.IEnergy;
import pokemon.IEvoPokemon;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic evolved grass Pokémon. This class receives all the methods implemented in
 * AbstractGrassPokemon and implements a method to return the pre-evolution of it.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractEvoGrassPokemon extends AbstractGrassPokemon implements IEvoPokemon {

    private int preEvolution;
    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's requirements.
     * @param energyList Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    protected AbstractEvoGrassPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList,
                                      int preEvolution) {
        super(name, number, hp, abilityList, energyList);
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
