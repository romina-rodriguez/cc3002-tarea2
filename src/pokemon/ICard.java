package pokemon;

/**
 * Common interface for all the cards: Pokémon and Energy. Every card has a name, and should be
 * used by a trainer in combat.
 *
 *  @author Romina Rodríguez
 */
public interface ICard {

    //region Properties
    /**
     * @return Card's name.
     */
    String getCardName();
    //endregion

    /**
     * Trainer uses a card in combat.
     *
     * @param card Card chosen by trainer.
     */
    void useCard(ICard card);
}
