package pokemon;

import java.util.ArrayList;

/**
 * Base class for all the attacks. This contains the methods to access the attack's properties, like
 * it's name and base damage.
 *
 *  @author Romina Rodríguez
 *
 */
public abstract class AbstractAttack implements IAttack {

    private int baseDamage;
    private String name;
    private String description;
    private ArrayList<IEnergy> energyListRequired;

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     * @param description Description of the attack
     * @param energyListRequired Cost of the attack
     */
    protected AbstractAttack(String name, int baseDamage, String description, ArrayList<IEnergy> energyListRequired) {
        this.baseDamage = baseDamage;
        this.name = name;
        this.description = description;
        this.energyListRequired = energyListRequired;
    }

    //region Properties
    /**
     * Getter for the base damage.
     *
     * @return Base damage of the attack.
     */
    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * Getter for the attack's name.
     *
     * @return Name of the attack.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for the attack's description.
     *
     * @return Description of the attack.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the list of energies required to use an attack.
     *
     * @return List with all the energies.
     */
    @Override
    public ArrayList<IEnergy> getEnergyListRequired() {
        return energyListRequired;
    }
    //endregion

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack to.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IAttack && ((IAttack) obj).getBaseDamage() == baseDamage
                && ((IAttack) obj).getName().equals(name)
                && ((IAttack) obj).getDescription().equals(description)
                && ((IAttack) obj).getEnergyListRequired().equals(energyListRequired);
    }
}
