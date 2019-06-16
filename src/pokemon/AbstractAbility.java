package pokemon;

import java.util.ArrayList;

/**
 * Base class for all the requirements. This contains the methods to access the ability's properties, like
 * it's name, description and cost.
 *
 *  @author Romina Rodríguez
 *
 */
public abstract class AbstractAbility implements IAbility {

    private String name;
    private String description;
    private ArrayList<IEnergy> energyListRequired;

    /**
     * Creates a new ability.
     *
     * @param name Ability name
     * @param description Description of the ability
     * @param energyListRequired Cost of the ability
     */
    protected AbstractAbility(String name, String description, ArrayList<IEnergy> energyListRequired) {
        this.name = name;
        this.description = description;
        this.energyListRequired = energyListRequired;
    }

    /**
     * Getter for the ability's name.
     *
     * @return Name of the ability.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for the ability's description.
     *
     * @return Description of the ability.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the list of energies required to use an ability.
     *
     * @return List with all the energies.
     */
    @Override
    public ArrayList<IEnergy> getEnergyListRequired() {
        return energyListRequired;
    }
    //endregion

    /**
     * Checks if this ability is equal to another.
     *
     * @param obj Object to compare this ability to.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IAbility && ((IAbility) obj).getName().equals(name)
                && ((IAbility) obj).getDescription().equals(description)
                && ((IAbility) obj).getEnergyListRequired().equals(energyListRequired);
    }
}
