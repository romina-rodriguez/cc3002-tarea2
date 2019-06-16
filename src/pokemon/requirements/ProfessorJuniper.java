package pokemon.requirements;

import pokemon.ICard;
import pokemon.Trainer;
import pokemon.trainercards.AbstractSupporterCard;

import java.util.ArrayList;

public class ProfessorJuniper extends AbstractSupporterCard {

    /**
     * Creates a new Supporter Trainer Card.
     *
     * @param name        Card's name.
     * @param description Card's description.
     */
    public ProfessorJuniper(String name, String description) {
        super(name, description);
    }

    @Override
    public void useCard(Trainer trainer) {
        ArrayList<ICard> empty = new ArrayList<>();
        trainer.setHand(empty);
        ArrayList<ICard> newHand = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            ICard card = trainer.stealCard();
            newHand.add(card);
        }
        trainer.setHand(newHand);
    }
}
