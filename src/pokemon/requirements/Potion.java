package pokemon.requirements;

import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.trainercards.AbstractItemCard;

/**
 * This class defines the logic of a potion type ability.
 *
 *  @author Romina Rodríguez
 */
public class Potion extends AbstractItemCard {

    private int damageCounter = 10;
    /**
     * Creates a new Item Trainer Card.
     *
     * @param name        Card's name.
     * @param description Card's description.
     */
    public Potion(String name, String description) {
        super(name, description);
    }

    @Override
    public void useCard(Trainer trainer) {
        IPokemon pokemon = trainer.selectPokemon(-1);
        int newHP = pokemon.getHP() + 2*damageCounter;
        pokemon.setHP(newHP); // x = 2.
    }
}
