package pokemon;

/**
 * Common interface for all the Trainer Cards: Stadium, Item and Supporter. Every card has a name, a description, and should be
 * used by a trainer.
 *
 *  @author Romina Rodríguez
 */
public interface ITrainerCard extends ICard {

    //region Properties
    /**
     * @return Trainer Card's description.
     */
    String getTrainerCardDescription();
    //endregion
}
