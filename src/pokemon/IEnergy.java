package pokemon;

/**
 * Common interface for all the energies. Every energy has a different type.
 *
 *  @author Romina Rodríguez
 */
public interface IEnergy extends ICard{

    //region Properties
    /**
    * @return Energy type.
    */
    String getType();
    //endregion

}
