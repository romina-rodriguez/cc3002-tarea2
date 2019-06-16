package pokemon.grass;

import pokemon.AbstractPokemon;
import pokemon.IAbility;
import pokemon.IEnergy;
import pokemon.fire.FireAttack;
import pokemon.water.WaterAttack;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic grass Pokémon. This class receives all the methods implemented in
 * AbstractPokemon and specifies the weaknesses and strengths of this type of pokémon.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractGrassPokemon extends AbstractPokemon implements IGrassPokemon {
    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's requirements.
     * @param energyList Pokémon's energies.
     */
    protected AbstractGrassPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList) {
        super(name, number, hp, abilityList, energyList);
    }

    /**
     * Receives a water type attack.
     * {@inheritDoc}
     *
     * @param attack water type attack received.
     */
    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        receiveResistantAttack(attack);
    }

    /**
     * Receives a fire type attack.
     * {@inheritDoc}
     *
     * @param attack fire type attack received.
     */
    @Override
    public void receiveFireAttack(FireAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
