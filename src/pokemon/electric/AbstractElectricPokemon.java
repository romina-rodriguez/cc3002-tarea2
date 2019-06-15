package pokemon.electric;

import pokemon.AbstractPokemon;
import pokemon.IAbility;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.fighting.FightingAttack;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic electric Pokémon. This class receives all the methods implemented in
 * AbstractPokemon and specifies the weaknesses and strengths of this type of pokémon.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractElectricPokemon extends AbstractPokemon implements IElectricPokemon {

    /**
     * Creates a new Electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's abilites.
     * @param energyList Pokémon's energies.
     */
    protected AbstractElectricPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                              ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
    }

    /**
     * Receives a fighting type attack.
     *
     * @param attack fighting type attack received.
     */
    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
