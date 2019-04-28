package pokemon.electric;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.fighting.FightingAttack;
import java.util.ArrayList;

/**
 * Class that represents an electric type Pokémon.
 *
 *  @author Romina Rodríguez
 */

public class ElectricPokemon extends AbstractPokemon {

    /**
     * Creates a new electric Pokémon.
     *
     * @param name Pokémon's name.
     * @param number Pokémon's number.
     * @param hp Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public ElectricPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                           ArrayList<IEnergy> energyList) {
        super(name, number, hp, attackList, energyList);
    }

    /**
     * Receives a fighting type attack.
     * {@inheritDoc}
     *
     * @param attack fighting type attack received.
     */
    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
