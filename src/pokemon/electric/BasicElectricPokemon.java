package pokemon.electric;

import pokemon.IAttack;
import pokemon.IBasicPokemon;
import pokemon.IEnergy;
import pokemon.fighting.FightingAttack;
import java.util.ArrayList;

/**
 * Class that represents an electric type Pokémon.
 *
 *  @author Romina Rodríguez
 */
public class BasicElectricPokemon extends AbstractElectricPokemon implements IBasicPokemon {

    /**
     * Creates a new Basic Electric Pokémon.
     *
     * @param name Pokémon's name.
     * @param number Pokémon's number.
     * @param hp Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    public BasicElectricPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                                ArrayList<IEnergy> energyList) {
        super(name, number, hp, attackList, energyList);
    }

    /**
     * Receives a fighting type attack.
     * {@inheritDoc}
     *
     * @param attack fighting type attack received.
     */
    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveWeaknessAttack(attack);
    }
}
