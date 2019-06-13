package pokemon.electric;

import pokemon.IAttack;
import pokemon.IEnergy;
import pokemon.IFirstEvoPokemon;
import pokemon.fighting.FightingAttack;

import java.util.ArrayList;

public class FirstEvoElectricPokemon extends AbstractElectricPokemon implements IFirstEvoPokemon {

    private int preEvolution;

    /**
     * Creates a new First Evolution Electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     * @param preEvolution Pokémon's pre-evolution.
     */
    protected FirstEvoElectricPokemon(String name, int number, int hp, ArrayList<IAttack> attackList, ArrayList<IEnergy> energyList,
                                      int preEvolution) {
        super(name, number, hp, attackList, energyList);
        this.preEvolution = preEvolution;
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

    //region Properties
    /**
     * Getter for the Evolved Pokémon pre-evolution.
     *
     * @return Pokémon's pre-evolution.
     */
    public int getPreEvolution() {
        return preEvolution;
    }
    //endregion
}
