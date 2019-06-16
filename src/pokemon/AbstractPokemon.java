package pokemon;

import pokemon.requirements.ElectricShock;
import pokemon.fighting.FightingAttack;
import pokemon.fire.FireAttack;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;
import pokemon.electric.ElectricAttack;
import pokemon.requirements.FireSpin;
import pokemon.water.WaterAttack;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic Pokémon. This class contains the necessary methods to
 * attack and receive damage, and definitions to get the properties of each Pokémon, like its number,
 * hp, name, list of attacks, and list of energies.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractPokemon extends AbstractCard implements IPokemon {

    private int number;
    private int hp;
    private ArrayList<IAbility> abilityList; //max 4 different attacks.
    private IAbility selectedAbility;
    private ArrayList<IEnergy> energyList;

    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param number     Pokémon's number.
     * @param hp         Pokémon's hit points.
     * @param abilityList Pokémon's attacks.
     * @param energyList Pokémon's energies.
     */
    protected AbstractPokemon(String name, int number, int hp, ArrayList<IAbility> abilityList,
                              ArrayList<IEnergy> energyList) {
        super(name);
        if (abilityList.size() > 4) {
            System.exit(1);
        }
        this.number = number;
        this.hp = hp;
        this.abilityList = abilityList;
        this.energyList = energyList;
    }

    //region Properties
    /**
     * Getter for the Pokémon's number.
     *
     * @return Pokémon's number.
     */
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getName() {
        return this.getCardName();
    }

    /**
     * Getter for the Pokémon's HP.
     *
     * @return Pokémon's hit points
     */
    @Override
    public int getHP() {
        return hp;
    }

    /**
     * Getter for the list of Pokémon attacks.
     *
     * @return List with all the Pokémon attacks.
     */
    @Override
    public ArrayList<IAbility> getAbilities() {
        return abilityList;
    }

    /**
     * Getter for the selected Pokémon attack.
     *
     * @return The current selected attack.
     */
    @Override
    public IAbility getSelectedAbility() {
        return selectedAbility;
    }

    @Override
    /**
     * Getter for the list of Pokémon energies.
     *
     * @return List with all the Pokémon energies.
     */
    public ArrayList<IEnergy> getEnergies(){
        return energyList;
    }
    //endregion

    @Override
    public void useCard(Trainer trainer) {
        IPokemon pokemon = trainer.getActivePokemon();
        if(pokemon == null) {
            trainer.setActivePokemon(this);
        }
        else {
            if(this instanceof IEvoPokemon) {
                ArrayList<IPokemon> bench = trainer.getPokemonBench();
                ArrayList<Integer> preEvolutions = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    if(bench.get(i) instanceof IEvoPokemon) {
                        preEvolutions.add(((IEvoPokemon) bench.get(i)).getPreEvolution());
                    }
                    else {
                        preEvolutions.add(900); //there are only 807 pokémon
                    }
                }
                if (preEvolutions.contains(((IEvoPokemon) this).getPreEvolution())){
                    trainer.addToBench(this);
                }
            }
            else if (this instanceof IBasicPokemon) {
                trainer.addToBench(this);
            }
        }
    }

    @Override
    public boolean isDead() {
        return hp == 0;
    }

    @Override
    public void selectAbility(int index) {
        selectedAbility = abilityList.get(index);
    }

    @Override
    public void attack(Trainer other) {
        ArrayList<IEnergy> cost = selectedAbility.getEnergyListRequired();
        if(energyList.containsAll(cost)) {
            selectedAbility.useAbility(other);
        }
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveFireAttack(FireAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveElectricShock(ElectricShock attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        receiveAttack(attack);
    }

    /**
     * Receives an attack.
     * @param attack Received attack.
     */
    public void receiveAttack(IAttack attack) {
        setHP(this.hp -= attack.getBaseDamage());
    }

    @Override
    public void receiveFireSpin(FireSpin fireSpin) {
        receiveAttack(fireSpin);
    }

    /**
     * Sets a Pokémon's hp.
     * @param newHP Pokémon's new hit points
     */
    @Override
    public void setHP(int newHP){
        this.hp = newHP < 0 ? 0 : newHP;
    }

    /**
     * Receives an attack to which this Pokémon is weak.
     * @param attack  Received attack.
     */
    protected void receiveWeaknessAttack(IAttack attack) {
        setHP(this.hp -= attack.getBaseDamage() * 2);
    }

    /**
     * Receives an attack to which this Pokémon is resistant.
     * @param attack  Received attack.
     */
    protected void receiveResistantAttack(IAttack attack) {
        setHP(this.hp -= attack.getBaseDamage() - 30);
    }
}