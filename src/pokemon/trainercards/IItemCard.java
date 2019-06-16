package pokemon.trainercards;

import pokemon.ITrainerCard;
import pokemon.Trainer;

public interface IItemCard extends ITrainerCard {

    Trainer getTrainer();
}
