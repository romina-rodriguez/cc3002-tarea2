package pokemon.requirements;

import pokemon.AbstractAbility;
import pokemon.IEnergy;
import pokemon.IPokemon;
import pokemon.Trainer;
import java.util.ArrayList;

public class DamageSwap extends AbstractAbility {

    private int damageCounter = 10;

    /**
     * Creates a new ability.
     *
     * @param name               Ability name
     * @param description        Description of the ability
     * @param energyListRequired Cost of the ability
     */
    protected DamageSwap(String name, String description, ArrayList<IEnergy> energyListRequired) {
        super(name, description, energyListRequired);
    }

    @Override
    public void useAbility(Trainer trainer) {
        ArrayList<IEnergy> energyList = trainer.getActivePokemon().getEnergies();
        if(energyList.containsAll(getEnergyListRequired())) {
            IPokemon source = trainer.selectPokemon(0); //first in the bench
            int newHP = source.getHP() - damageCounter*3; //i want to move 3 damage counters to my active pokemon.
            source.setHP(newHP);
            if(!source.isDead()){
                trainer.getActivePokemon().setHP(trainer.getActivePokemon().getHP() + damageCounter*3);
            }
            else {
                source.setHP(newHP + damageCounter*3);
            }
        }
    }

    /**
     * Checks if this ability is equal to another.
     *
     * @param obj Object to compare this ability to.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof DamageSwap && super.equals(obj);
    }
}
