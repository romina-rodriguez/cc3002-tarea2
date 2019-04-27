package pokemon.water;

import pokemon.AbstractAttack;
import pokemon.IPokemon;

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
     * @param name Attack's name.
     * @param baseDamage Attack's base damage.
     */
    public WaterAttack(String name, int baseDamage) {
        super(name, baseDamage);
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
