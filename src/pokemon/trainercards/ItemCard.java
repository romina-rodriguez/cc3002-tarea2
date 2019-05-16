package pokemon.trainercards;

import pokemon.AbstractTrainerCard;
import pokemon.Trainer;

/**
 * Class that represents an Item Trainer Card.
 *
 *  @author Romina Rodríguez
 */
public class ItemCard extends AbstractTrainerCard {

    /**
     * Creates a new Item Trainer Card.
     *
     * @param name        Pokémon's name.
     * @param description Pokémon's description.
     */
    public ItemCard(String name, String description){
        super(name, description);
    }

    @Override
    public void useCard(Trainer trainer){

    }
}
