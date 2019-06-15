package pokemon;

/**
 * Common interface for all the attacks. Every attack has a name, a base damage, a description
 * and a cost, and should be able to damage a Pokémon.
 *
 *  @author Romina Rodríguez
 */
public interface IAttack extends IAbility {

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
    //endregion
}