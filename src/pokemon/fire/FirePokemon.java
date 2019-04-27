package pokemon.fire;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.water.WaterAttack;
import java.util.List;

/**
 * Class that represents a fire type Pokémon.
 */

public class FirePokemon extends AbstractPokemon {

    /**
     * Creates a new fire Pokémon.
     *
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public FirePokemon(int number, int hp, List<IAttack> attackList) {
        super(number, hp, attackList);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        receiveWeaknessAttack(attack);
    }

}