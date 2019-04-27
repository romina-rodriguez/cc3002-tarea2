package pokemon.fighting;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;
import java.util.List;

/**
 * Class that represents a fighting type Pokémon.
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

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        receiveWeaknessAttack(attack);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
