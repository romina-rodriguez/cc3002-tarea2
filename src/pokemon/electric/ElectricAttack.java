package pokemon.electric;

import pokemon.AbstractAttack;
import pokemon.IEnergy;
import pokemon.IPokemon;

import java.util.ArrayList;

/**
 * This class defines the logic of an electric type attack.
 *
 *  @author Romina Rodríguez
 */
public class ElectricAttack extends AbstractAttack {

    /**
     * Creates a new electric type attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     * @param description Description of the attack
     * @param energyListRequired Cost of the attack
     */
    public ElectricAttack(String name, int baseDamage, String description, ArrayList<IEnergy> energyListRequired) {
        super(name, baseDamage, description, energyListRequired);
    }

    /**
     * Performs an electric type attack.
     * {@inheritDoc}
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receiveElectricAttack(this);
    }

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricAttack && super.equals(obj);
    }
}
