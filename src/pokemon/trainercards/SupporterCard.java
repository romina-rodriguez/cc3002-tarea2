package pokemon.trainercards;

import pokemon.AbstractTrainerCard;
import pokemon.Trainer;

/**
 * Class that represents a Supporter Trainer Card.
 *
 *  @author Romina Rodríguez
 */
public class SupporterCard extends AbstractTrainerCard {

    /**
     * Creates a new Supporter Trainer Card.
     *
     * @param name        Pokémon's name.
     * @param description Pokémon's description.
     */
    public SupporterCard(String name, String description){
        super(name, description);
    }

    @Override
    public void useCard(Trainer trainer){
        //trainer.discard(this);
    }
}
