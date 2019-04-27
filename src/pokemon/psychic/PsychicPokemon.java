package pokemon.psychic;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.fighting.FightingAttack;
import java.util.List;

/**
 * Class that represents a fire type Pokémon.
 */

public class PsychicPokemon extends AbstractPokemon {

    /**
     * Creates a new grass Pokémon.
     *
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public PsychicPokemon(int number, int hp, List<IAttack> attackList) {
        super(number, hp, attackList);
    }

    public void receivePsychicAttack(PsychicAttack attack) {
        receiveWeaknessAttack(attack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveResistantAttack(attack);
    }

}