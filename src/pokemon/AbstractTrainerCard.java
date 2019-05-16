package pokemon;

/**
 * Abstract class that represents the 3 types of Trainer Cards. This class contains the
 * definitions to get the properties of each card like its description.
 *
 *  @author Romina Rodríguez
 */
abstract public class AbstractTrainerCard implements ITrainerCard {
    private String name;
    private String description;

    /**
    * Creates a new Trainer Card.
    *
    * @param name        Pokémon's name.
    * @param description Pokémon's description.
    */
    protected AbstractTrainerCard(String name, String description){
        this.name = name;
        this.description = description;
    }

    //region Properties
    /**
     * Getter for the Trainer Card's name.
     *
     * @return Card's name.
     */
    @Override
    public String getCardName() {
        return name;
    }

    /**
     * Getter for the Trainer Card's description.
     *
     * @return Card's description.
     */
    @Override
    public String getTrainerCardDescription(){
        return description;
    }
    //endregion
}


