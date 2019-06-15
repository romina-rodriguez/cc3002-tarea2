package pokemon.water;

import pokemon.AbstractPokemon;
import pokemon.IAbility;
import pokemon.IEnergy;
import pokemon.electric.ElectricAttack;
import pokemon.fighting.FightingAttack;
import pokemon.grass.GrassAttack;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic water Pokémon. This class receives all the methods implemented in
 * AbstractPokemon and specifies the weaknesses and strengths of this type of pokémon.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractWaterPokemon extends AbstractPokemon implements IWaterPokemon {

    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's abilities.
     * @param energyList Pokémon's energies.
     */
    protected AbstractWaterPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList, ArrayList<IEnergy> energyList) {
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
