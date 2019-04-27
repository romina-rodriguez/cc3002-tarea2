package pokemon.electric;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.fighting.FightingAttack;
import java.util.List;

/**
 * Class that represents an electric type Pokémon.
 */

public class ElectricPokemon extends AbstractPokemon {

    /**
     * Creates a new grass Pokémon.
     *
     * @param number Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public ElectricPokemon(int number, int hp, List<IAttack> attackList) {
        super(number, hp, attackList);
    }

    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
