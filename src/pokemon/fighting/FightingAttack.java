package pokemon.fighting;

import pokemon.AbstractAttack;
import pokemon.IPokemon;

/**
 * This class defines the logic of a fighting type attack.
 */

public class FightingAttack extends AbstractAttack {

    /**
     * Creates a new fighting type attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     */
    public FightingAttack(String name, int baseDamage) {
        super(name, baseDamage);
    }

    /**
     * Performs a fighting type attack.
     * {@inheritDoc}
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receiveFightingAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FightingAttack && super.equals(obj);
    }
}