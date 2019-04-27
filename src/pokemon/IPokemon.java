package pokemon;

import pokemon.fighting.FightingAttack;
import pokemon.fire.FireAttack;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;
import pokemon.electric.ElectricAttack;
import pokemon.water.WaterAttack;
import java.util.List;

/**
 * Common interface for all the Pokémon. Every Pokémon has a number, hit points and a list of attacks.
 *
 *  @author Romina Rodríguez
 */

public interface IPokemon {

    //region Properties

    /**
     * @return Pokémon's number.
     */
    int getNumber();

    /**
     * @return Pokémon's hit points
     */
    int getHP();

    /**
     * @return List with all the Pokémon attacks.
     */
    List<IAttack> getAttacks();

    /**
     * @return The current selected attack.
     */
    IAttack getSelectedAttack();
    //endregion

    /**
     * Attacks another Pokémon.
     *
     * @param other Target of the attack.
     */
    void attack(IPokemon other);

    /**
     * Selects an attack.
     *
     * @param index Index of the attack to be selected.
     */
    void selectAttack(int index);

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
}
