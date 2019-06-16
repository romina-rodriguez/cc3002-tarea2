package pokemon;

/**
 * Common interface for all the cards: Pokémon and Energy. Every card has a name, and should be
 * used by a trainer.
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
     * Trainer uses a card.
     *
     * @param trainer trainer that chose the card.
     * //@param card Card that was selected.
     */
    void useCard(Trainer trainer);

    /**
     * Setter for the trainer that wants to use the card
     * @param trainer trainer.
     */
    void setTrainer(Trainer trainer);

    /**
     * Getter for the trainer that used the card.
     * @return trainer.
     */
    Trainer getTrainer();
}
