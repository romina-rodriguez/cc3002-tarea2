package pokemon.water;

import pokemon.AbstractAttack;
import pokemon.IAttack;
import pokemon.IPokemon;

import java.util.List;

/**
 * This class defines the logic of a water type attack.
 *
 *  @author Romina Rodríguez
 */

public class WaterAttack extends AbstractAttack {

    /**
     * Creates a new water type attack.
     * {@inheritDoc}
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     * @param description Description of the attack
     * @param attackListRequired Cost of the attack
     */
    public WaterAttack(String name, int baseDamage, String description, List<IAttack> attackListRequired) {
        super(name, baseDamage, description, attackListRequired);
    }

    @Override
    public void attack(IPokemon other) {
        other.receiveWaterAttack(this);
    }

    /**
     * Checks if an object is equal to an ElectricAttack
     * {@inheritDoc}
     *
     * @param obj Object to compare
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof WaterAttack && super.equals(obj);
    }
}
