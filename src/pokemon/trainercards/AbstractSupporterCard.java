package pokemon.trainercards;

import pokemon.AbstractTrainerCard;

/**
 * Class that represents a Supporter Trainer Card.
 *
 *  @author Romina Rodríguez
 */
public abstract class AbstractSupporterCard extends AbstractTrainerCard implements ISupporterCard {

    /**
     * Creates a new Supporter Trainer Card.
     *
     * @param name        Card's name.
     * @param description Card's description.
     */
    public AbstractSupporterCard(String name, String description){
        super(name, description);
    }
}
