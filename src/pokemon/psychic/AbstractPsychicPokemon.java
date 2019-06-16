package pokemon.psychic;

import pokemon.AbstractPokemon;
import pokemon.IAbility;
import pokemon.IEnergy;
import pokemon.fighting.FightingAttack;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic psychic Pokémon. This class receives all the methods implemented in
 * AbstractPokemon and specifies the weaknesses and strengths of this type of pokémon.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractPsychicPokemon extends AbstractPokemon implements IPsychicPokemon {

    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's requirements.
     * @param energyList Pokémon's energies.
     */
    protected AbstractPsychicPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
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
