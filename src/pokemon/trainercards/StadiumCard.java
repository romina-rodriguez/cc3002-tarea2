package pokemon.trainercards;

import pokemon.AbstractTrainerCard;
import pokemon.Trainer;

/**
 * Class that represents a Stadium Trainer Card.
 *
 *  @author Romina Rodríguez
 */
public class StadiumCard extends AbstractTrainerCard {

    /**
     * Creates a new Stadium Trainer Card.
     *
     * @param name        Pokémon's name.
     * @param description Pokémon's description.
     */
    public StadiumCard(String name, String description){
        super(name, description);
    }

    @Override
    public void useCard(Trainer trainer){

    }
}
