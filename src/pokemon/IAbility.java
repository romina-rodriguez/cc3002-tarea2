package pokemon;

import java.util.ArrayList;

/**
 * Common interface for all the abilities. Every ability has a name, a description
 * and a cost.
 *
 *  @author Romina Rodríguez
 */
public interface IAbility {

    /**
     * Performs an ability.
     * {@inheritDoc}
     *
     * @param pokemon Pokémon that receives the ability.
     */
    void useAbility(IPokemon pokemon);

    //region Properties
    /**
     * @return Name of the ability.
     */
    String getName();

    /**
     * @return Description of the ability.
     */
    String getDescription();

    /**
     * @return List with all the energies required to use an ability.
     */
    ArrayList<IEnergy> getEnergyListRequired();
    //endregion
}
