package pokemon;

import pokemon.fighting.FightingAttack;
import pokemon.fire.FireAttack;
import pokemon.grass.GrassAttack;
import pokemon.psychic.PsychicAttack;
import pokemon.electric.ElectricAttack;
import pokemon.water.WaterAttack;
import java.util.ArrayList;

/**
 * Common interface for all the Pokémon. Every Pokémon has a number, hit points and a list of attacks.
 *
 *  @author Romina Rodríguez
 */
public interface IPokemon extends ICard {

    /**
     * Trainer uses a Pokemon Card in combat.
     *
     * @param trainer trainer that chose the card.
     * @param pokemonCard Pokémon card selected.
     */
    void usePokemonCard(Trainer trainer, IPokemon pokemonCard);

    /**
     * Adds a Pokémon to the trainer's bench if a spot is available.
     *
     * @param trainer trainer that chose the card.
     * @param pokemonCard Pokémon card selected.
     */
    void addToBench(Trainer trainer, IPokemon pokemonCard);

    /**
     * Once the current active Pokémon dies, another one must be promoted from the bench if available.
     *
     * @param trainer trainer that chose the card.
     * @param pokemonCard Pokémon card selected.
     */
    void promoteToActive(Trainer trainer, IPokemon pokemonCard);

    /**
     * Checks whether the Pokémon is dead or not.
     *
     * @return true if the pokemon is dead, false if not.
     */
    boolean isDead();

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
     * @return List with all the Pokémon attacks.
     */
    ArrayList<IAttack> getAttacks();

    /**
     * @return The current selected attack.
     */
    IAttack getSelectedAttack();

    /**
     * @return List with all the Pokémon energies.
     */
    ArrayList<IEnergy> getEnergies();
    //endregion
}
