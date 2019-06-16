package pokemon;

public abstract class AbstractCard implements ICard {

    private String name;
    private Trainer trainer;

    /**
     * Creates a new card.
     *
     * @param name Card's name.
     */
    public AbstractCard(String name){
        this.name = name;
    }

    /**
     * Getter for the Card's name.
     *
     * @return Card's name.
     */
    @Override
    public String getCardName() {
        return name;
    }

    /**
     * Setter for the trainer that wants to use the card.
     * @param trainer trainer.
     */
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * Getter for the trainer that used the card.
     * @return trainer.
     */
    public Trainer getTrainer() {
        return trainer;
    }
}
