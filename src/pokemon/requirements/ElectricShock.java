package pokemon.requirements;

import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.electric.ElectricAttack;

import java.util.ArrayList;

/**
 * This class defines the logic of an electric shock type attack.
 *
 *  @author Romina Rodríguez
 */
public class ElectricShock extends ElectricAttack {

    /**
     * Creates a new ElectricShock attack.
     *
     * @param name               Attack name
     * @param baseDamage         Base damage of the attack
     * @param description        Description of the attack
     * @param energyListRequired Cost of the attack
     */
    public ElectricShock(String name, int baseDamage, String description, ArrayList<IEnergy> energyListRequired) {
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
        if(Math.random() < 0.5) { //tails; >= 0.5 is heads.
            other.receiveElectricShock(this);
        }
    }

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack to.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricShock && super.equals(obj);
    }
}
