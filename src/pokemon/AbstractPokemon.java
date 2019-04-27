package pokemon;

import pokemon.fighting.FightingAttack;
import pokemon.fire.FireAttack;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;
import pokemon.electric.ElectricAttack;
import pokemon.water.WaterAttack;

import java.util.List;

/**
 * Abstract class that represents a generic Pokémon. This class contains the necessary methods to
 * attack and receive damage, and definitions to get the properties of each Pokémon, like its name
 * and hp.
 */

public abstract class AbstractPokemon implements IPokemon {

    private int number;
    private int hp;
    private List<IAttack> attackList;
    private IAttack selectedAttack;

    /**
     * Creates a new Pokémon.
     *
     * @param number  Pokémon's number.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    protected AbstractPokemon(int number, int hp, List<IAttack> attackList) {
        this.number = number;
        this.hp = hp;
        this.attackList = attackList;
    }

    @Override
    public void selectAttack(int index) {
        selectedAttack = attackList.get(index);
    }

    @Override
    public void attack(IPokemon other) {
        selectedAttack.attack(other);
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
    public void receiveFightingAttack(FightingAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        receiveAttack(attack);
    }


    /**
     * Receives an attack.
     * @param attack  Received attack.
     */
    protected void receiveAttack(IAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    /**
     * Receives an attack to which this Pokémon is weak.
     * @param attack  Received attack.
     */
    protected void receiveWeaknessAttack(IAttack attack) {
        this.hp -= attack.getBaseDamage() * 2;
    }

    /**
     * Receives an attack to which this Pokémon is resistant.
     * @param attack  Received attack.
     */
    protected void receiveResistantAttack(IAttack attack) {
        this.hp -= attack.getBaseDamage() - 30;
    }

    //region Properties
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public List<IAttack> getAttacks() {
        return attackList;
    }

    @Override
    public IAttack getSelectedAttack() {
        return selectedAttack;
    }
    //endregion
}