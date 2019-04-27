package pokemon.grass;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.fire.FireAttack;
import pokemon.water.WaterAttack;
import java.util.List;

/**
 * Class that represents a grass type Pokémon.
 */

public class GrassPokemon extends AbstractPokemon {

    /**
     * Creates a new grass Pokémon.
     *
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public GrassPokemon(int number, int hp, List<IAttack> attackList) {
        super(number, hp, attackList);
    }

    public void receiveWaterAttack(WaterAttack attack) {
        receiveResistantAttack(attack);
    }

    @Override
    public void receiveFireAttack(FireAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
