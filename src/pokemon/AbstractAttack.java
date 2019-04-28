package pokemon;

import java.util.List;

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
    private List<IAttack> attackListRequired;

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     * @param description Description of the attack
     * @param attackListRequired Cost of the attack
     */
    protected AbstractAttack(String name, int baseDamage, String description, List<IAttack> attackListRequired) {
        this.baseDamage = baseDamage;
        this.name = name;
        this.description = description;
        this.attackListRequired = attackListRequired;
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
     * Getter for the list of Pokémon attacks required to use an attack.
     *
     * @return List with all the Pokémon attacks.
     */
    @Override
    public List<IAttack> getAttackListRequired() {
        return attackListRequired;
    }
    //endregion

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IAttack && ((IAttack) obj).getBaseDamage() == baseDamage
                && ((IAttack) obj).getName().equals(name);
    }
}
