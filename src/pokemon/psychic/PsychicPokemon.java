package pokemon.psychic;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.fighting.FightingAttack;
import java.util.List;

/**
 * Class that represents a psychic type Pokémon.
 *
 *  @author Romina Rodríguez
 */

public class PsychicPokemon extends AbstractPokemon {

    /**
     * Creates a new psychic Pokémon.
     *
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public PsychicPokemon(int number, int hp, List<IAttack> attackList) {
        super(number, hp, attackList);
    }

    /**
     * Receives a psychic type attack.
     * {@inheritDoc}
     *
     * @param attack psychic type attack received.
     */
    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
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