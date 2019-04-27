package pokemon.grass;

import pokemon.AbstractAttack;
import pokemon.IPokemon;

/**
 * This class defines the logic of a grass type attack.
 *
 *  @author Romina Rodríguez
 */

public class GrassAttack extends AbstractAttack {

    /**
     * Creates a new grass type attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     */
    public GrassAttack(String name, int baseDamage) {
        super(name, baseDamage);
    }

    /**
     * Performs a grass type attack.
     * {@inheritDoc}
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receiveGrassAttack(this);
    }

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof GrassAttack && super.equals(obj);
    }
}
