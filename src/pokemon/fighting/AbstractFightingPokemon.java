package pokemon.fighting;

import pokemon.AbstractPokemon;
import pokemon.IAbility;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic fighting Pokémon. This class receives all the methods implemented in
 * AbstractPokemon and specifies the weaknesses and strengths of this type of pokémon.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractFightingPokemon extends AbstractPokemon implements  IFightingPokemon{

    /**
     * Creates a new fighting Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param abilityList  Pokémon's abilites.
     * @param energyList Pokémon's energies.
     */
    public AbstractFightingPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                           ArrayList<IEnergy> energyList){
        super(name, number, hp, abilityList, energyList);
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
