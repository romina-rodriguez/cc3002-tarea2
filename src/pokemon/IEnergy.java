package pokemon;

/**
 * Common interface for all the energies. Every energy has a different type.
 *
 *  @author Romina Rodríguez
 */
public interface IEnergy extends ICard{

    /**
     * Trainer uses an Energy card in combat, therefore an energy is added to the active Pokémon.
     *
     * @param activePokemon Pokémon that's currently active.
     * @param energyCard Energy card selected.
     */
    void useEnergyCard(IPokemon activePokemon, IEnergy energyCard);

    //region Properties
    /**
    * @return Energy type.
    */
    String getType();
    //endregion

}
