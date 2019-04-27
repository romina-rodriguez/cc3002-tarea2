package pokemon.psychic;

import pokemon.AbstractAttack;
import pokemon.IAttack;
import pokemon.IPokemon;

import java.util.List;

/**
 * This class defines the logic of a psychic type attack.
 *
 *  @author Romina Rodríguez
 */

public class PsychicAttack extends AbstractAttack {

    /**
     * Creates a new psychic type attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     * @param description Description of the attack
     * @param attackListRequired Cost of the attack
     */
    public PsychicAttack(String name, int baseDamage, String description, List<IAttack> attackListRequired) {
        super(name, baseDamage, description, attackListRequired);
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

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof PsychicAttack && super.equals(obj);
    }
}

