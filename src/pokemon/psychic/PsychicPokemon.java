package pokemon.psychic;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.fighting.FightingAttack;

import java.util.ArrayList;

/**
 * Class that represents a psychic type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class PsychicPokemon extends AbstractPokemon {

    /**
     * Creates a new psychic Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public PsychicPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                          ArrayList<IEnergy> energyList) {
        super(name, number, hp, attackList, energyList);
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