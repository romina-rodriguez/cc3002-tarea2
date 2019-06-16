package pokemon;

import java.util.ArrayList;

/**
 * Abstract class that represents the energies. This class contains the
 * definitions to get the properties of each energy, like its type.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractEnergy extends AbstractCard implements IEnergy {

    /**
     * Creates a new energy.
     *
     * @param type Energy type
     */
    public AbstractEnergy(String type){
        super(type);
    }

    public void useCard(Trainer trainer, int index){
        IPokemon pokemon = trainer.selectPokemon(index);
        ArrayList<IEnergy> pokemonEnergyList = pokemon.getEnergies();
        pokemonEnergyList.add(this);
    }

    @Override
    public void useCard(Trainer trainer) {
        useCard(trainer, -1);
    }

    //region Properties
    /**
     * Getter for the energy type.
     *
     * @return Energy type.
     */
    @Override
    public String getType() {
        return this.getCardName();
    }
    //endregion
}
