package pokemon.fighting;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;

import java.util.ArrayList;

/**
 * Class that represents a fighting type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class FightingPokemon extends AbstractPokemon {

    /**
     * Creates a new fighting Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public FightingPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                           ArrayList<IEnergy> energyList){
        super(name, number, hp, attackList, energyList);
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
