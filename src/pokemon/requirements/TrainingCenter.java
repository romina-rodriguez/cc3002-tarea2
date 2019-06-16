package pokemon.requirements;

import pokemon.IEvoPokemon;
import pokemon.IPokemon;
import pokemon.Trainer;
import pokemon.trainercards.AbstractStadiumCard;

public class TrainingCenter extends AbstractStadiumCard {

    /**
     * Creates a new Stadium Trainer Card.
     *
     * @param name        Card's name.
     * @param description Card's description.
     */
    public TrainingCenter(String name, String description) {
        super(name, description);
    }

    @Override
    public void useCard(Trainer trainer) {
        IPokemon pokemon = trainer.getActivePokemon();
        if(pokemon != null && pokemon instanceof IEvoPokemon){
            int newHP = trainer.getActivePokemon().getHP() + 50; //x = 50
            trainer.getActivePokemon().setHP(newHP);
        }
        if(!trainer.getPokemonBench().isEmpty()) {
            for (int i = 0; i < trainer.getPokemonBench().size(); i++) {
                if (trainer.getPokemonBench().get(i) instanceof IEvoPokemon) {
                    int newHP = trainer.getPokemonBench().get(i).getHP() + 50; //x = 50
                    trainer.getPokemonBench().get(i).setHP(newHP);
                }
            }
        }
    }
}
