package pokemon.electric;

import pokemon.AbstractAttack;
import pokemon.IPokemon;

/**
 * This class defines the logic of an electric type attack.
 */

public class ElectricAttack extends AbstractAttack {

    /**
     * Creates a new electric type attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     */
    public ElectricAttack(String name, int baseDamage) {
        super(name, baseDamage);
    }

    /**
     * Performs a electric type attack.
     * {@inheritDoc}
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receiveElectricAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricAttack && super.equals(obj);
    }
}
