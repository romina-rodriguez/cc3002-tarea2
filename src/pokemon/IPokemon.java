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
 * Common interface for all the Pokémon. Every Pokémon has a number, a name, hit points,
 * a list of energies and a list of attacks.
 *
 *  @author Romina Rodríguez
 */
public interface IPokemon extends ICard {

    //region Properties
    /**
     * @return Pokémon's number.
     */
    int getNumber();

    /**
     * @return Pokémon's name.
     */
    String getName();

    /**
     * @return Pokémon's hit points
     */
    int getHP();

    /**
     * @return List with all the Pokémon requirements.
     */
    ArrayList<IAbility> getAbilities();

    /**
     * @return The current selected ability.
     */
    IAbility getSelectedAbility();

    /**
     * @return List with all the Pokémon energies.
     */
    ArrayList<IEnergy> getEnergies();
    //endregion

    /**
     * Checks whether the Pokémon is dead or not.
     *
     * @return true if the pokemon is dead, false if not.
     */
    boolean isDead();

    /**
     * Performs an attack.
     *
     * @param other Target of the attack.
     */
    void attack(Trainer other);

    /**
     * Selects an ability.
     *
     * @param index Index of the ability to be selected.
     */
    void selectAbility(int index);

    /**
     * Receives damage from a water attack.
     *
     * @param attack Received attack.
     */
    void receiveWaterAttack(WaterAttack attack);

    /**
     * Receives damage from a grass attack.
     *
     * @param attack Received attack.
     */
    void receiveGrassAttack(GrassAttack attack);

    /**
     * Receives damage from a fire attack.
     *
     * @param attack Received attack.
     */
    void receiveFireAttack(FireAttack attack);

    /**
     * Receives damage from a fighting attack.
     *
     * @param attack Received attack.
     */
    void receiveFightingAttack(FightingAttack attack);

    /**
     * Receives damage from an electric attack.
     *
     * @param attack Received attack.
     */
    void receiveElectricAttack(ElectricAttack attack);

    /**
     * Receives damage from a psychic attack.
     *
     * @param attack Received attack.
     */
    void receivePsychicAttack(PsychicAttack attack);

    /**
     * Receives damage from an electric shock.
     *
     * @param attack Received attack.
     */
    void receiveElectricShock(ElectricShock attack);

    /**
     * Sets a Pokémon's hp
     *
     * @param newHP Pokémon's new hit points
     */
    void setHP(int newHP);

    /**
     * Receives effect from an attack.
     *
     * @param attack Received attack.
     */
    void receiveAttack(IAttack attack);

    /**
     * Receives effect from a fire spin.
     *
     * @param fireSpin Received attack.
     */
    void receiveFireSpin(FireSpin fireSpin);
}
