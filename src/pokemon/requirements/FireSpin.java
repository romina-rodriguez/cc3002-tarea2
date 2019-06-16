package pokemon.requirements;

import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.fire.FireAttack;

import java.util.ArrayList;

public class FireSpin extends FireAttack {

    /**
     * Creates a new fire type attack.
     *
     * @param name               Attack name
     * @param baseDamage         Base damage of the attack
     * @param description        Description of the attack
     * @param energyListRequired Cost of the attack
     */
    public FireSpin(String name, int baseDamage, String description, ArrayList<IEnergy> energyListRequired) {
        super(name, baseDamage, description, energyListRequired);
    }

    @Override
    public void attack(IPokemon other) {
        ArrayList<IEnergy> energies = other.getEnergies();
        if(energies.size() >= 2 && !energies.isEmpty()) {
            other.getEnergies().remove(0);
            other.getEnergies().remove(0); //deletes two energies; x = 2;
            other.receiveFireSpin(this);
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
        return obj instanceof FireSpin && super.equals(obj);
    }
}
