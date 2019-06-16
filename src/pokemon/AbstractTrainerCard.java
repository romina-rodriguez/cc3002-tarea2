package pokemon;

/**
 * Abstract class that represents the 3 types of Trainer Cards. This class contains the
 * definitions to get the properties of each card like its description.
 *
 *  @author Romina Rodríguez
 */
abstract public class AbstractTrainerCard extends AbstractCard implements ITrainerCard {

    private String description;

    /**
    * Creates a new Trainer Card.
    *
    * @param name        Card's name.
    * @param description Card's description.
    */
    protected AbstractTrainerCard(String name, String description){
        super(name);
        this.description = description;
    }

    //region Properties
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


