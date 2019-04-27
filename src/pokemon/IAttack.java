package pokemon;

import java.util.List;

/**
 * Common interface for all the attacks/energies. Every attack has a name and a base damage, and should be
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

    /**
     * Getter for the base damage.
     *
     * @return Base damage of the attack.
     */
    int getBaseDamage();

    /**
     * Getter for the attack's name.
     *
     * @return Name of the attack.
     */
    String getName();

    /**
     * Getter for the attack's description.
     *
     * @return Description of the attack.
     */
    public String getDescription();

    /**
     * Getter for the list of Pokémon attacks required to use an attack.
     *
     * @return List with all the Pokémon attacks.
     */
    public List<IAttack> getAttackListRequired();
}