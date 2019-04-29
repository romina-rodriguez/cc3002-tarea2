package pokemon;

import java.util.ArrayList;

/**
 * Abstract class that represents the energies. This class contains the
 * definitions to get the properties of each energy, like its type.
 *
 * @author Romina Rodríguez
 */
public class AbstractEnergy implements IEnergy {

    private String type; //doubles as energy name.

    /**
     * Creates a new energy.
     *
     * @param type Energy type
     */
    public AbstractEnergy(String type){
        this.type = type;
    }

    @Override
    public void useCard(Trainer trainer){
        IPokemon activePokemon = trainer.getActivePokemon();
        ArrayList<IEnergy> activePokemonEnergyList = activePokemon.getEnergies();
        activePokemonEnergyList.add(this);
    }

    //region Properties
    /**
     * Getter for the energy type.
     *
     * @return Energy type.
     */
    @Override
    public String getType(){
        return type;
    }

    /**
     * Getter for the Energy Card's name.
     *
     * @return Card's name.
     */
    @Override
    public String getCardName() {
        return type;
    }
    //endregion
}
