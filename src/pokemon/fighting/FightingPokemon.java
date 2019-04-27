package pokemon.fighting;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;
import java.util.List;

/**
 * Class that represents a fighting type Pokémon.
 *
 *  @author Romina Rodríguez
 */

public class FightingPokemon extends AbstractPokemon {

    /**
     * Creates a new fighting Pokémon.
     *
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public FightingPokemon(int number, int hp, List<IAttack> attackList) {
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
     * Receives a psychic type attack.
     * {@inheritDoc}
     *
     * @param attack psychic type attack received.
     */
    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
