package pokemon.abilities;

import pokemon.AbstractAbility;
import pokemon.IEnergy;
import pokemon.IPokemon;

import java.util.ArrayList;

/**
 * This class defines the logic of a potion type ability.
 *
 *  @author Romina Rodríguez
 */
public class Potion extends AbstractAbility {

    /**
     * Creates a new ability.
     *
     * @param name               Ability name
     * @param description        Description of the ability
     * @param energyListRequired Cost of the ability
     */
    protected Potion(String name, String description, ArrayList<IEnergy> energyListRequired) {
        super(name, description, energyListRequired);
    }

    /**
     * Performs a potion type ability.
     * {@inheritDoc}
     *
     * @param pokemon Pokémon that receives the ability.
     */
    @Override
    public void useAbility(IPokemon pokemon){
        pokemon.receivePotion(this);
    }

    /**
     * Checks if this ability is equal to another.
     *
     * @param obj Object to compare this ability.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Potion && super.equals(obj);
    }
}
