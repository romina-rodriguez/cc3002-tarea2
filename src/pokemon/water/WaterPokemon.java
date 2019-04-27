package pokemon.water;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.fighting.FightingAttack;
import pokemon.electric.ElectricAttack;
import pokemon.grass.GrassAttack;
import java.util.List;

/**
 * Class that represents a water type Pokémon.
 *
 *  @author Romina Rodríguez
 */

public class WaterPokemon extends AbstractPokemon {

    /**
     * Creates a new water Pokémon.
     *
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    public WaterPokemon(int number, int hp, List<IAttack> attackList) {
        super(number, hp, attackList);
    }

    /**
     * Receives a grass type attack.
     * {@inheritDoc}
     *
     * @param attack grass type attack received.
     */
    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        receiveWeaknessAttack(attack);
    }

    /**
     * Receives an electric type attack.
     * {@inheritDoc}
     *
     * @param attack electric type attack received.
     */
    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        receiveWeaknessAttack(attack);
    }

    /**
     * Receives a fighting type attack.
     * {@inheritDoc}
     *
     * @param attack fighting type attack received.
     */
    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveResistantAttack(attack);
    }
}