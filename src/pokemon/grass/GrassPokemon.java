package pokemon.grass;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.fire.FireAttack;
import pokemon.water.WaterAttack;

import java.util.ArrayList;

/**
 * Class that represents a grass type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class GrassPokemon extends AbstractPokemon {

    /**
     * Creates a new grass Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public GrassPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                        ArrayList<IEnergy> energyList) {
        super(name, number, hp, attackList, energyList);
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
