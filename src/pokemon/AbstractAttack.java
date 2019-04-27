package pokemon;

/**
 * Base class for all the attacks. This contains the methods to access the attack's properties, like
 * it's name and base damage.
 *
 *  @author Romina Rodríguez
 */

public abstract class AbstractAttack implements IAttack {

    private int baseDamage;
    private String name;

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     */
    protected AbstractAttack(String name, int baseDamage) {
        this.baseDamage = baseDamage;
        this.name = name;
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
