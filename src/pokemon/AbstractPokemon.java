package pokemon;

import pokemon.abilities.ElectricShock;
import pokemon.abilities.EnergyBurn;
import pokemon.abilities.Potion;
import pokemon.fighting.FightingAttack;
import pokemon.fire.FireAttack;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;
import pokemon.electric.ElectricAttack;
import pokemon.water.WaterAttack;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic Pokémon. This class contains the necessary methods to
 * attack and receive damage, and definitions to get the properties of each Pokémon, like its number,
 * hp, name, list of attacks, and list of energies.
 *
 * @author Romina Rodríguez
 */
public abstract class AbstractPokemon implements IPokemon {

    private int damageCounter = 10;
    private String name;
    private int number;
    private int hp;
    private ArrayList<IAbility> abilityList = new ArrayList<>(4); //max 4 different attacks.
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
        this.name = name;
        this.number = number;
        this.hp = hp;
        this.abilityList = abilityList;
        this.energyList = energyList;
    }

    @Override
    public void useCard(Trainer trainer) {
        ArrayList<IPokemon> pokemonBench = trainer.getPokemonBench();
        IPokemon activePokemon = trainer.getActivePokemon();
        if(pokemonBench.size() < 5) {
            addToBench(trainer, this);
        }
        if(activePokemon.isDead()){
            promoteToActive(trainer);
        }
    }

    @Override
    public void addToBench(Trainer trainer, IPokemon pokemon) {
        ArrayList<IPokemon> pokemonBench = trainer.getPokemonBench();
        pokemonBench.add(pokemon);
    }

    @Override
    public void promoteToActive(Trainer trainer) {
        ArrayList<IPokemon> pokemonBench = trainer.getPokemonBench();
        IPokemon newActivePokemon = pokemonBench.get(0);
        trainer.setActivePokemon(newActivePokemon);
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
    public void attack(IPokemon other) {
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

    @Override
    public void receiveEnergyBurn(EnergyBurn ability) {
        //enum energies
    }

    @Override
    public void receivePotion(Potion ability) {
        setHP(this.hp -= 2*damageCounter); //x=2
    }

    /**
     * Receives an attack.
     * @param attack Received attack.
     */
    protected void receiveAttack(IAttack attack) {
        setHP(this.hp -= attack.getBaseDamage());
        /*if(this.isDead()){
            promoteToActive();
        }*/
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

    //region Properties
    /**
     * Getter for the Pokémon Card's name.
     *
     * @return Card's name.
     */
    @Override
    public String getCardName() {
        return name;
    }

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
        return name;
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
}