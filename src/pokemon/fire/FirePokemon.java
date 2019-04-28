package pokemon.fire;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.water.WaterAttack;

import java.util.ArrayList;

/**
 * Class that represents a fire type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class FirePokemon extends AbstractPokemon {

    /**
     * Creates a new fire Pokémon.
     *
     * @param name Pokémon's name.
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public FirePokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
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
        receiveWeaknessAttack(attack);
    }

}