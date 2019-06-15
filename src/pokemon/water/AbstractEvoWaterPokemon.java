package pokemon.water;

import pokemon.IAbility;
import pokemon.IEnergy;
import pokemon.IEvoPokemon;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic evolved water Pokémon. This class receives all the methods implemented in
 * AbstractWaterPokemon and implements a method to return the pre-evolution of it.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractEvoWaterPokemon extends AbstractWaterPokemon implements IEvoPokemon {

    private int preEvolution;

    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's abilities.
     * @param energyList Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    protected AbstractEvoWaterPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList,
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
