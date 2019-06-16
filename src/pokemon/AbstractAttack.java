package pokemon;

import java.util.ArrayList;

/**
 * Base class for all the attacks. This contains the methods to access the attack's properties, like
 * it's name, base damage, description and cost.
 *
 *  @author Romina Rodríguez
 *
 */
public abstract class AbstractAttack extends AbstractAbility implements IAttack {

    private int baseDamage;

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base Damage of the attack
     * @param description Description of the attack
     * @param energyListRequired Cost of the attack
     */
    protected AbstractAttack(String name, int baseDamage, String description, ArrayList<IEnergy> energyListRequired) {
        super(name, description, energyListRequired);
        this.baseDamage = baseDamage;
    }

    @Override
    public void useAbility(Trainer trainer){
        attack(trainer.getActivePokemon());
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
                && super.equals(obj);
    }
}
