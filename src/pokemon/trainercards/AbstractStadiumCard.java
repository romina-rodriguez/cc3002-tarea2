package pokemon.trainercards;

import pokemon.AbstractTrainerCard;
import pokemon.Trainer;

/**
 * Class that represents a Stadium Trainer Card.
 *
 *  @author Romina Rodríguez
 */
public abstract class AbstractStadiumCard extends AbstractTrainerCard implements IStadiumCard {

    /**
     * Creates a new Stadium Trainer Card.
     *
     * @param name        Card's name.
     * @param description Card's description.
     */
    public AbstractStadiumCard(String name, String description){
        super(name, description);
    }
}
