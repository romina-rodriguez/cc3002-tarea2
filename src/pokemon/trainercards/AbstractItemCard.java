package pokemon.trainercards;

import pokemon.AbstractTrainerCard;
import pokemon.Trainer;

/**
 * Class that represents an Item Trainer Card.
 *
 *  @author Romina Rodríguez
 */
public abstract class AbstractItemCard extends AbstractTrainerCard implements IItemCard {

    /**
     * Creates a new Item Trainer Card.
     *
     * @param name        Card's name.
     * @param description Card's description.
     */
    public AbstractItemCard(String name, String description){
        super(name, description);
    }
}
