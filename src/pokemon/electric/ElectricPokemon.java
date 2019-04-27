package pokemon.electric;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.fighting.FightingAttack;
import java.util.List;

/**
 * Class that represents an electric type Pokémon.
 *
 *  @author Romina Rodríguez
 */

public class ElectricPokemon extends AbstractPokemon {

    /**
     * Creates a new electric Pokémon.
     *
     * @param number Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public ElectricPokemon(int number, int hp, List<IAttack> attackList) {
        super(number, hp, attackList);
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
