package pokemon.psychic;

import pokemon.AbstractAttack;
import pokemon.IPokemon;

/**
 * This class defines the logic of a psychic type attack.
 */

public class PsychicAttack extends AbstractAttack {

    /**
     * Creates a new psychic type attack.
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     */
    public PsychicAttack(String name, int baseDamage) {
        super(name, baseDamage);
    }

    /**
     * Performs a psychic type attack.
     * {@inheritDoc}
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receivePsychicAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PsychicAttack && super.equals(obj);
    }
}

