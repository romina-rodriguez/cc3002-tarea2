package pokemon.electric;

import pokemon.AbstractPokemon;
import pokemon.IAttack;
import pokemon.IEnergy;

import java.util.ArrayList;

public class AbstractElectricPokemon extends AbstractPokemon {

    private String name;
    private int number;
    private int hp;
    private ArrayList<IAttack> attackList = new ArrayList<>(4); //max 4 different attacks.
    private IAttack selectedAttack;
    private ArrayList<IEnergy> energyList;

    /**
     * Creates a new Electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    protected AbstractElectricPokemon(String name, int number, int hp, ArrayList<IAttack> attackList,
                              ArrayList<IEnergy> energyList) {
        super(name, number, hp, attackList, energyList);
    }
}
