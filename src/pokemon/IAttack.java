package pokemon;

import java.util.ArrayList;

/**
 * Common interface for all the attacks (abilities). Every attack has a name and a base damage, and should be
 * able to damage a Pokémon.
 *
 *  @author Romina Rodríguez
 */
public interface IAttack {

    /**
     * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     *
     * @param other Pokémon that receives the attack.
     */
    void attack(IPokemon other);

    //region Properties
    /**
     * @return Base damage of the attack.
     */
    int getBaseDamage();

    /**
     * @return Name of the attack.
     */
    String getName();

    /**
     * @return Description of the attack.
     */
    String getDescription();

    /**
     * @return List with all the energies required to do an attack.
     */
    ArrayList<IEnergy> getEnergyListRequired();
    //endregion
}